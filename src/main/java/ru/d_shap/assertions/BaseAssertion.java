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

import org.hamcrest.Matcher;

import ru.d_shap.assertions.asimp.java.lang.ClassActualValueValidator;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.fail.AssertionErrorBuilder;
import ru.d_shap.assertions.fail.FailDescription;

/**
 * Base class for all assertions.
 *
 * @param <T> the generic type of the actual value.
 *
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
        ActualValueValidatorProvider actualValueValidator = new ClassActualValueValidator(actualValueClass);
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
    protected final void addActualValueValidator(final ActualValueValidatorProvider actualValueValidator) {
        _actualValueValidator.addActualValueValidator(actualValueValidator);
    }

    /**
     * Get the actual value.
     *
     * @return the actual value.
     */
    protected final T getActual() {
        checkInitialized();
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
     * @param actual    the actual value.
     * @param message   the message.
     * @param arguments the message arguments.
     */
    final void initialize(final T actual, final String message, final Object... arguments) {
        initialize(actual, new FailDescription(message, arguments));
    }

    private void initialize(final T actual, final FailDescription failDescription) {
        if (_initialized) {
            throw getAssertionErrorBuilder(failDescription).addMessage(Messages.Fail.Assertion.IS_NOT_INITIALIZED).build();
        }
        if (!_actualValueValidator.isValid(actual)) {
            throw getAssertionErrorBuilder(failDescription).addMessage(Messages.Fail.Assertion.MATCHES).build();
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
     *
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual) {
        checkInitialized();
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
     *
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initializeAssertion(final S assertion, final U actual, final String message, final Object... arguments) {
        checkInitialized();
        ((BaseAssertion<W>) assertion).initialize(actual, new FailDescription(_failDescription, message, arguments));
        return assertion;
    }

    /**
     * Make assertion with the hamcrest matcher.
     *
     * @param actual  the actual value.
     * @param matcher the hamcrest matcher.
     * @param <W>     the generic type of the matcher's actual value.
     * @param <U>     the generic type of the actual value.
     */
    protected final <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher) {
        checkInitialized();
        HamcrestMatcher.matcherAssertion(actual, matcher, _failDescription);
    }

    /**
     * Make assertion with the hamcrest matcher.
     *
     * @param actual    the actual value.
     * @param matcher   the hamcrest matcher.
     * @param message   the message.
     * @param arguments the message arguments.
     * @param <W>       the generic type of the matcher's actual value.
     * @param <U>       the generic type of the actual value.
     */
    protected final <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher, final String message, final Object... arguments) {
        checkInitialized();
        HamcrestMatcher.matcherAssertion(actual, matcher, _failDescription, message, arguments);
    }

    /**
     * Make assertion of the specified type about the same actual.
     *
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    @SuppressWarnings("unchecked")
    public final <W extends T, S extends BaseAssertion<W>> S as(final S assertion) {
        checkArgumentIsNotNull(assertion, "assertion");
        return initializeAssertion(assertion, (W) _actual);
    }

    /**
     * Make assertion of the specified type about the same actual with the message.
     *
     * @param assertion the assertion.
     * @param message   the message.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    @SuppressWarnings("unchecked")
    public final <W extends T, S extends BaseAssertion<W>> S as(final S assertion, final String message) {
        checkArgumentIsNotNull(assertion, "assertion");
        return initializeAssertion(assertion, (W) _actual, Messages.SIMPLE_MESSAGE, message);
    }

    /**
     * Get the value converted to the target class.
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     * @param <V>         the generic type of the value converted to the target class.
     *
     * @return the value converted to the target class.
     */
    protected final <V> V convertValue(final Object value, final Class<?> targetClass, final Object... arguments) {
        checkInitialized();
        try {
            return ValueConverter.convert(value, targetClass, arguments);
        } catch (ConversionException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    private void checkInitialized() {
        if (!_initialized) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Assertion.IS_INITIALIZED).build();
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    protected final void checkActualIsNotNull() {
        checkInitialized();
        if (_actual == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NULL).build();
        }
    }

    /**
     * Check if the argument is NOT null.
     *
     * @param argument     the argument.
     * @param argumentName the argument name.
     */
    protected final void checkArgumentIsNotNull(final Object argument, final String argumentName) {
        checkInitialized();
        if (argument == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Argument.IS_NOT_NULL, argumentName).build();
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always known.
     *
     * @param isEmpty      is the argument empty.
     * @param argumentName the argument name.
     * @param knownResult  the known result of the check.
     */
    protected final void checkArgumentIsNotEmpty(final boolean isEmpty, final String argumentName, final boolean knownResult) {
        checkInitialized();
        if (isEmpty) {
            AssertionErrorBuilder assertionErrorBuilder = getAssertionErrorBuilder().addMessage(Messages.Fail.Argument.IS_NOT_EMPTY, argumentName);
            if (knownResult) {
                assertionErrorBuilder.addMessage(Messages.Fail.Argument.RESULT_IS_ALWAYS_TRUE);
            } else {
                assertionErrorBuilder.addMessage(Messages.Fail.Argument.RESULT_IS_ALWAYS_FALSE);
            }
            throw assertionErrorBuilder.build();
        }
    }

    /**
     * Check if the argument is valid.
     *
     * @param valid        is the argument valid.
     * @param argumentName the argument name.
     * @param message      the message template.
     * @param arguments    the message arguments.
     */
    protected final void checkArgumentIsValid(final boolean valid, final String argumentName, final String message, final Object... arguments) {
        checkInitialized();
        if (!valid) {
            AssertionErrorBuilder assertionErrorBuilder = getAssertionErrorBuilder().addMessage(Messages.Fail.Argument.IS_VALID, argumentName);
            assertionErrorBuilder.addMessage(message, arguments);
            throw assertionErrorBuilder.build();
        }
    }

    /**
     * Create the assertion error for the underlying exception.
     *
     * @param ex the underlying exception.
     *
     * @return the assertion error.
     */
    protected final AssertionError createWrapperAssertionError(final Exception ex) {
        return getAssertionErrorBuilder().addThrowable(ex).addMessage(ex).build();
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
        return AssertionErrorBuilder.getInstance(failDescription, getActualValueClass(), _actual);
    }

}
