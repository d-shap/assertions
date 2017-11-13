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

import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Base class for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion {

    private final List<ActualValueValidator> _actualValidators;

    private Object _actual;

    private FailDescription _failDescription;

    /**
     * Create new object.
     */
    protected BaseAssertion() {
        super();
        _actualValidators = new ArrayList<>();
    }

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
    protected final Object getActual() {
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
     * Initialize the current assertion.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    protected final void initialize(final Object actual, final FailDescription failDescription) {
        if (actual != null) {
            for (ActualValueValidator actualValidator : _actualValidators) {
                if (!actualValidator.isValid(actual)) {
                    throw createAssertionError(Messages.Fail.DOES_NOT_MATCH_THE_ASSERTION);
                }
            }
        }
        _actual = actual;
        _failDescription = failDescription;
    }

    /**
     * Initialize the specified assertion.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <T>       type of the actual value.
     * @return the initialized assertion.
     */
    protected final <T extends BaseAssertion> T initialize(final T assertion, final Object actual) {
        assertion.initialize(actual, getFailDescription());
        return assertion;
    }

    /**
     * Initialize the specified assertion.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <T>       type of the actual value.
     * @return the initialized assertion.
     */
    protected final <T extends BaseAssertion> T initialize(final T assertion, final Object actual, final String message) {
        assertion.initialize(actual, getFailDescription(message));
        return assertion;
    }

    /**
     * Make assertion of specified type about the same actual.
     *
     * @param assertion the assertion.
     * @param <T>       type of the assertion.
     * @return the assertion.
     */
    public final <T extends BaseAssertion> T as(final T assertion) {
        checkInitialized();
        checkArgumentIsNotNull(assertion);
        return initialize(assertion, _actual);
    }

    /**
     * Make assertion of specified type about the same actual.
     *
     * @param assertion the assertion.
     * @param <T>       type of the assertion.
     * @return the assertion.
     */
    public final <T extends BaseAssertion> T as(final T assertion, final String message) {
        checkInitialized();
        checkArgumentIsNotNull(assertion);
        return initialize(assertion, _actual, message);
    }

    /**
     * Check if the current assertion is initialized.
     */
    protected final void checkInitialized() {
        if (_failDescription == null) {
            throw createAssertionError(Messages.Fail.ASSERTION_IS_NOT_INITIALIZED);
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
            throw createAssertionError(Messages.Fail.ARGUMENT_IS_NOT_VALID);
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Object expectedFrom, final Object expectedTo) {
        return getFailDescription().addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the message and the expected value range.
     *
     * @param message      the message.
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionErrorWithActual(final Object expectedFrom, final Object expectedTo) {
        return getFailDescription().addActual(this).addExpected(this, expectedFrom, expectedTo).createAssertionError();
    }

    /**
     * Create the assertion error based on the fail description with the actual value, the message and the expected value range.
     *
     * @param message      the message.
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
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
