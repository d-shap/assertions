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

import ru.d_shap.assertions.core.ClassActualValueValidator;

/**
 * Base class for all assertions.
 *
 * @param <T> the generic type of the actual value.
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion<T> {

    private final ActualValueValidator _actualValueValidator;

    private boolean _initialized;

    private T _actual;

    private FailDescription _failDescription;

    /**
     * Create new object.
     */
    protected BaseAssertion() {
        super();
        _actualValueValidator = new ActualValueValidator();
        Class<T> actualValueClass = getActualValueClass();
        BaseActualValueValidator actualValueValidator = new ClassActualValueValidator(actualValueClass);
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
    protected final void addActualValueValidator(final BaseActualValueValidator actualValueValidator) {
        _actualValueValidator.addActualValueValidator(actualValueValidator);
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
        if (_initialized) {
            throw getAssertionErrorBuilder(failDescription).addMessage(Messages.Fail.ASSERTION_IS_NOT_INITIALIZED).build();
        }
        if (!_actualValueValidator.isValid(actual)) {
            throw getAssertionErrorBuilder(failDescription).addMessage(Messages.Fail.ASSERTION_MATCHES).build();
        }
        _initialized = true;
        _actual = actual;
        _failDescription = failDescription;
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
        ((BaseAssertion<W>) assertion).initialize(actual, new FailDescription(_failDescription));
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message with the message arguments.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param arguments the message arguments.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual, final String message, final Object... arguments) {
        ((BaseAssertion<W>) assertion).initialize(actual, new FailDescription(_failDescription, message, arguments));
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
     * Get the value converted to the target class.
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     * @param <V>         the generic type of the value converted to the target class.
     * @return the value converted to the target class.
     */
    protected final <V> V convertValue(final Object value, final Class<?> targetClass, final Object... arguments) {
        try {
            return ValueConverter.convert(value, targetClass, arguments);
        } catch (ConvertionException ex) {
            throw getAssertionErrorBuilder().addMessage(ex).addThrowable(ex).build();
        }
    }

    /**
     * Check if the current assertion is initialized.
     */
    protected final void checkInitialized() {
        if (!_initialized) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.ASSERTION_IS_INITIALIZED).build();
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    protected final void checkActualIsNotNull() {
        if (_actual == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_NULL).build();
        }
    }

    /**
     * Check if the argument is NOT null.
     *
     * @param argument the argument.
     */
    protected final void checkArgumentIsNotNull(final Object argument) {
        if (argument == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.ARGUMENT_IS_NOT_NULL).build();
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always true.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyTrue(final boolean isEmpty) {
        if (isEmpty) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.ARGUMENT_IS_NOT_EMPTY).addMessage(Messages.Fail.RESULT_IS_ALWAYS_TRUE).build();
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always false.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyFalse(final boolean isEmpty) {
        if (isEmpty) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.ARGUMENT_IS_NOT_EMPTY).addMessage(Messages.Fail.RESULT_IS_ALWAYS_FALSE).build();
        }
    }

    /**
     * Check if the argument is valid.
     *
     * @param valid is the argument valid.
     */
    protected final void checkArgumentIsValid(final boolean valid) {
        if (!valid) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.ARGUMENT_IS_VALID).build();
        }
    }

    /**
     * Get the assertion error builder instance.
     *
     * @return the assertion error builder instance.
     */
    protected final AssertionErrorBuilder getAssertionErrorBuilder() {
        return getAssertionErrorBuilder(_failDescription);
    }

    private AssertionErrorBuilder getAssertionErrorBuilder(final FailDescription failDescription) {
        return AssertionErrorBuilder.getInstance(failDescription, getActualValueClass(), getActual());
    }

}
