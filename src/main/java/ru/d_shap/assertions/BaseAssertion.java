///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions;

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Base class for all assertions.
 *
 * @param <T> the generic type of the actual value.
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion<T> {

    private final List<ActualValueValidator> _actualValidators;

    private boolean _initialized;

    private T _actual;

    private FailDescription _failDescription;

    /**
     * Create new object.
     */
    protected BaseAssertion() {
        super();
        _actualValidators = new ArrayList<>();
        Class<T> actualValueClass = getActualValueClass();
        ActualValueValidator actualValueValidator = new ActualValueClassValidator(actualValueClass);
        addActualValueValidator(actualValueValidator);
        _initialized = false;
        _actual = null;
        _failDescription = null;
    }

    /**
     * Get the actual value class.
     *
     * @return the actual value class.
     */
    protected abstract Class<T> getActualValueClass();

    /**
     * Add validator for the actual value.
     *
     * @param actualValueValidator validator for the actual value.
     */
    protected final void addActualValueValidator(final ActualValueValidator actualValueValidator) {
        _actualValidators.add(actualValueValidator);
    }

    /**
     * Get the actual value.
     *
     * @return the actual value.
     */
    protected final T getActual() {
        return _actual;
    }

    /**
     * Get the fail description.
     *
     * @return the fail description.
     */
    protected final FailDescription getFailDescription() {
        return new FailDescription(_failDescription);
    }

    /**
     * Get the fail description with the message.
     *
     * @param message the message.
     * @return the fail description.
     */
    protected final FailDescription getFailDescription(final String message) {
        return new FailDescription(_failDescription, message);
    }

    /**
     * Initialize assertion with the actual value.
     *
     * @param actual the actual value.
     */
    final void initialize(final T actual) {
        initialize(actual, new FailDescription());
    }

    /**
     * Initialize assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     */
    final void initialize(final T actual, final String message) {
        initialize(actual, new FailDescription(message));
    }

    private void initialize(final T actual, final FailDescription failDescription) {
        _failDescription = failDescription;
        if (_initialized) {
            throw createAssertionError(Messages.Fail.ASSERTION_IS_NOT_INITIALIZED);
        }
        _initialized = true;
        if (actual == null) {
            _actual = null;
        } else {
            for (ActualValueValidator actualValidator : _actualValidators) {
                if (!actualValidator.isValid(actual)) {
                    throw createAssertionError(Messages.Fail.ASSERTION_MATCHES);
                }
            }
            _actual = actual;
        }
    }

    /**
     * Initialize the specified assertion with the actual value.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual) {
        ((BaseAssertion<W>) assertion).initialize(actual, getFailDescription());
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual, final String message) {
        ((BaseAssertion<W>) assertion).initialize(actual, getFailDescription(message));
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message with the message parameter.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param parameter the message parameter.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual, final String message, final Object parameter) {
        ((BaseAssertion<W>) assertion).initialize(actual, getFailDescription(message + ": " + parameter));
        return assertion;
    }

    /**
     * Make assertion of the specified type about the same actual.
     *
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the assertion.
     */
    @SuppressWarnings("unchecked")
    public final <W extends T, S extends BaseAssertion<W>> S as(final S assertion) {
        checkInitialized();
        checkArgumentIsNotNull(assertion);
        return initializeAssertion(assertion, (W) _actual);
    }

    /**
     * Make assertion of the specified type about the same actual with the message.
     *
     * @param assertion the assertion.
     * @param message   the message.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the assertion.
     */
    @SuppressWarnings("unchecked")
    public final <W extends T, S extends BaseAssertion<W>> S as(final S assertion, final String message) {
        checkInitialized();
        checkArgumentIsNotNull(assertion);
        return initializeAssertion(assertion, (W) _actual, message);
    }

    /**
     * Make assertion of the specified type about the same actual with the message and the message parameter.
     *
     * @param assertion the assertion.
     * @param message   the message.
     * @param parameter the message parameter.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the assertion.
     */
    @SuppressWarnings("unchecked")
    public final <W extends T, S extends BaseAssertion<W>> S as(final S assertion, final String message, final Object parameter) {
        checkInitialized();
        checkArgumentIsNotNull(assertion);
        return initializeAssertion(assertion, (W) _actual, message, parameter);
    }

    /**
     * Check if the current assertion is initialized.
     */
    protected final void checkInitialized() {
        if (!_initialized) {
            throw createAssertionError(Messages.Fail.ASSERTION_IS_INITIALIZED);
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    protected final void checkActualIsNotNull() {
        if (_actual == null) {
            throw createAssertionError(Messages.Fail.IS_NOT_NULL);
        }
    }

    /**
     * Check if the argument is NOT null.
     *
     * @param argument the argument.
     */
    protected final void checkArgumentIsNotNull(final Object argument) {
        if (argument == null) {
            throw createAssertionError(Messages.Fail.ARGUMENT_IS_NOT_NULL);
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always true.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyTrue(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(Messages.Fail.ARGUMENT_IS_NOT_EMPTY_TRUE);
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always false.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyFalse(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(Messages.Fail.ARGUMENT_IS_NOT_EMPTY_FALSE);
        }
    }

    /**
     * Check if the argument is valid.
     *
     * @param valid is the argument valid.
     */
    protected final void checkArgumentIsValid(final boolean valid) {
        if (!valid) {
            throw createAssertionError(Messages.Fail.ARGUMENT_IS_VALID);
        }
    }

    /**
     * Create the assertion error based on the fail description.
     *
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError() {
        return getFailDescription().createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message.
     *
     * @param message the message.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message) {
        return getFailDescription(message).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the expected value.
     *
     * @param expected the expected value.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Object expected) {
        return getFailDescription().addExpected(this, expected).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message and the expected value.
     *
     * @param message  the message.
     * @param expected the expected value.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message, final Object expected) {
        return getFailDescription(message).addExpected(this, expected).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the expected value range.
     *
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Object expectedFrom, final Object expectedTo) {
        return getFailDescription().addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message and the expected value range.
     *
     * @param message      the message.
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message, final Object expectedFrom, final Object expectedTo) {
        return getFailDescription(message).addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the throwable.
     *
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Throwable throwable) {
        return getFailDescription().addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message and the throwable.
     *
     * @param message   the message.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message, final Throwable throwable) {
        return getFailDescription(message).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the expected value and the throwable.
     *
     * @param expected  the expected value.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Object expected, final Throwable throwable) {
        return getFailDescription().addExpected(this, expected).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message, the expected value and the throwable.
     *
     * @param message   the message.
     * @param expected  the expected value.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message, final Object expected, final Throwable throwable) {
        return getFailDescription(message).addExpected(this, expected).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the expected value range and the throwable.
     *
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @param throwable    the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Object expectedFrom, final Object expectedTo, final Throwable throwable) {
        return getFailDescription().addExpected(this, expectedFrom, expectedTo).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message, the expected value range and the throwable.
     *
     * @param message      the message.
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @param throwable    the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String message, final Object expectedFrom, final Object expectedTo, final Throwable throwable) {
        return getFailDescription(message).addExpected(this, expectedFrom, expectedTo).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value.
     *
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual() {
        return getFailDescription().addActual(this).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value and the message.
     *
     * @param message the message.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message) {
        return getFailDescription(message).addActual(this).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value and the expected value.
     *
     * @param expected the expected value.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Object expected) {
        return getFailDescription().addActual(this).addExpected(this, expected).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message and the expected value.
     *
     * @param message  the message.
     * @param expected the expected value.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message, final Object expected) {
        return getFailDescription(message).addActual(this).addExpected(this, expected).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value and the expected value range.
     *
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Object expectedFrom, final Object expectedTo) {
        return getFailDescription().addActual(this).addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message and the expected value range.
     *
     * @param message      the message.
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message, final Object expectedFrom, final Object expectedTo) {
        return getFailDescription(message).addActual(this).addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value and the throwable.
     *
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Throwable throwable) {
        return getFailDescription().addActual(this).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message and the throwable.
     *
     * @param message   the message.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message, final Throwable throwable) {
        return getFailDescription(message).addActual(this).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the expected value and the throwable.
     *
     * @param expected  the expected value.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Object expected, final Throwable throwable) {
        return getFailDescription().addActual(this).addExpected(this, expected).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message, the expected value and the throwable.
     *
     * @param message   the message.
     * @param expected  the expected value.
     * @param throwable the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message, final Object expected, final Throwable throwable) {
        return getFailDescription(message).addActual(this).addExpected(this, expected).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the expected value range and the throwable.
     *
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @param throwable    the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Object expectedFrom, final Object expectedTo, final Throwable throwable) {
        return getFailDescription().addActual(this).addExpected(this, expectedFrom, expectedTo).addThrowable(throwable).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message, the expected value range and the throwable.
     *
     * @param message      the message.
     * @param expectedFrom the lower (inclusive) bound of the expected value range.
     * @param expectedTo   the upper (exclusive) bound of the expected value range.
     * @param throwable    the throwabe.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final String message, final Object expectedFrom, final Object expectedTo, final Throwable throwable) {
        return getFailDescription(message).addActual(this).addExpected(this, expectedFrom, expectedTo).addThrowable(throwable).createAssertionError();
    }

    /**
     * Get the string representation of the value.
     *
     * @param value the value.
     * @return the string representation of the value.
     */
    protected abstract String asString(Object value);

}
