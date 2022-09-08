///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.fail;

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Builder for the assertion error.
 *
 * @author Dmitry Shapovalov
 */
public final class AssertionErrorBuilder {

    private final FailDescription _failDescription;

    private final List<FailDescriptionEntry> _failDescriptionEntries;

    private final FailDescriptionValues _failDescriptionValues;

    private Throwable _throwable;

    private final List<Throwable> _suppressedThrowables;

    private AssertionErrorBuilder(final FailDescription failDescription, final Class<?> actualClass, final Object actual) {
        super();
        _failDescription = failDescription;
        _failDescriptionEntries = new ArrayList<>();
        _failDescriptionValues = new FailDescriptionValues(actualClass, actual);
        _throwable = null;
        _suppressedThrowables = new ArrayList<>();
    }

    /**
     * Get the instance of the assertion error builder.
     *
     * @return the instance of the assertion error builder.
     */
    public static AssertionErrorBuilder getInstance() {
        return new AssertionErrorBuilder(null, null, null);
    }

    /**
     * Get the instance of the assertion error builder.
     *
     * @param failDescription the fail description.
     *
     * @return the instance of the assertion error builder.
     */
    public static AssertionErrorBuilder getInstance(final FailDescription failDescription) {
        return new AssertionErrorBuilder(failDescription, null, null);
    }

    /**
     * Get the instance of the assertion error builder.
     *
     * @param failDescription the fail description.
     * @param actualClass     the actual value's class (as specified in the assertion).
     * @param actual          the actual value.
     *
     * @return the instance of the assertion error builder.
     */
    public static AssertionErrorBuilder getInstance(final FailDescription failDescription, final Class<?> actualClass, final Object actual) {
        return new AssertionErrorBuilder(failDescription, actualClass, actual);
    }

    /**
     * Add the message to the assertion error.
     *
     * @param message   the message.
     * @param arguments the message arguments.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addMessage(final String message, final Object... arguments) {
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
        return this;
    }

    /**
     * Add the throwable message to the assertion error.
     *
     * @param throwable the throwable.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addMessage(final Throwable throwable) {
        Throwable unwrappedThrowable = getUnwrappedThrowable(throwable);
        return addMessage(Messages.SIMPLE_MESSAGE, unwrappedThrowable.toString());
    }

    /**
     * Add the actual value to the assertion error.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addActual() {
        _failDescriptionValues.addActual();
        return this;
    }

    /**
     * Add the actual value with the delta to the assertion error.
     * The delta is converted to the actual value's class.
     *
     * @param delta the actual value's delta.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addActualWithDelta(final Object delta) {
        _failDescriptionValues.addActualWithDelta(delta);
        return this;
    }

    /**
     * Add the expected value to the assertion error.
     * The expected value is converted to the actual value's class.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expected) {
        _failDescriptionValues.addExpected(expected);
        return this;
    }

    /**
     * Add the range of the expected values to the assertion error.
     * The expected values are converted to the actual value's class.
     *
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expectedFrom, final Object expectedTo) {
        _failDescriptionValues.addExpected(expectedFrom, expectedTo);
        return this;
    }

    /**
     * Add the expected value with the delta to the assertion error.
     * The expected value and the delta are converted to the actual value's class.
     *
     * @param expected the expected value.
     * @param delta    the expected value's delta.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpectedWithDelta(final Object expected, final Object delta) {
        _failDescriptionValues.addExpectedWithDelta(expected, delta);
        return this;
    }

    /**
     * Add the range of the expected values with the delta to the assertion error.
     * The expected values and the delta are converted to the actual value's class.
     *
     * @param expectedFrom the lower bound of the expected value range.
     * @param expectedTo   the upper bound of the expected value range.
     * @param delta        the expected value's delta.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpectedWithDelta(final Object expectedFrom, final Object expectedTo, final Object delta) {
        _failDescriptionValues.addExpectedWithDelta(expectedFrom, expectedTo, delta);
        return this;
    }

    /**
     * Add the expected value to the assertion error.
     * The expected value is converted to the specified class.
     *
     * @param expected      the expected value.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpected(final Object expected, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpected(expected, expectedClass);
        return this;
    }

    /**
     * Add the range of the expected values to the assertion error.
     * The expected values are converted to the specified class.
     *
     * @param expectedFrom  the lower bound of the expected value range.
     * @param expectedTo    the upper bound of the expected value range.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpected(final Object expectedFrom, final Object expectedTo, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpected(expectedFrom, expectedTo, expectedClass);
        return this;
    }

    /**
     * Add the expected value with the delta to the assertion error.
     * The expected value and the delta are converted to the specified class.
     *
     * @param expected      the expected value.
     * @param delta         the expected value's delta.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpectedWithDelta(final Object expected, final Object delta, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpectedWithDelta(expected, delta, expectedClass);
        return this;
    }

    /**
     * Add the range of the expected values with the delta to the assertion error.
     * The expected values and the delta are converted to the specified class.
     *
     * @param expectedFrom  the lower bound of the expected value range.
     * @param expectedTo    the upper bound of the expected value range.
     * @param delta         the expected value's delta.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpectedWithDelta(final Object expectedFrom, final Object expectedTo, final Object delta, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpectedWithDelta(expectedFrom, expectedTo, delta, expectedClass);
        return this;
    }

    /**
     * Add the throwable to the assertion error.
     *
     * @param throwable the throwable.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addThrowable(final Throwable throwable) {
        _throwable = throwable;
        return this;
    }

    /**
     * Add the suppressed throwable to the assertion error.
     *
     * @param throwable the suppressed throwable.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addSuppressedThrowable(final Throwable throwable) {
        _suppressedThrowables.add(throwable);
        return this;
    }

    /**
     * Add the suppressed throwables to the assertion error.
     *
     * @param throwables the suppressed throwables.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addSuppressedThrowable(final List<? extends Throwable> throwables) {
        _suppressedThrowables.addAll(throwables);
        return this;
    }

    /**
     * Build the assertion error.
     *
     * @return the assertion error.
     */
    public AssertionError build() {
        try {
            return createAssertionError();
        } catch (ConversionException ex) {
            return createAssertionError(ex);
        }
    }

    private AssertionError createAssertionError() {
        List<FailDescriptionEntry> failDescriptionEntries = new ArrayList<>(_failDescriptionEntries);
        _failDescriptionValues.addFailDescriptionEntry(failDescriptionEntries);

        FailDescription failDescription = new FailDescription(_failDescription);
        for (FailDescriptionEntry failDescriptionEntry : failDescriptionEntries) {
            failDescription = new FailDescription(failDescription, failDescriptionEntry);
        }
        String fullMessage = failDescription.getFullMessage();
        Throwable unwrappedThrowable = getUnwrappedThrowable(_throwable);
        AssertionError assertionError = new AssertionError(fullMessage, unwrappedThrowable);
        fillSuppressedThrowable(assertionError);
        return assertionError;
    }

    private AssertionError createAssertionError(final ConversionException conversionException) {
        Throwable unwrappedThrowable = getUnwrappedThrowable(conversionException);
        try {
            FailDescription failDescription = new FailDescription(_failDescription, unwrappedThrowable.toString());
            String fullMessage = failDescription.getFullMessage();
            return new AssertionError(fullMessage, unwrappedThrowable);
        } catch (ConversionException ex) {
            return new AssertionError(unwrappedThrowable.toString(), unwrappedThrowable);
        }
    }

    private Throwable getUnwrappedThrowable(final Throwable throwable) {
        if (throwable instanceof ConversionException) {
            return throwable.getCause();
        } else {
            return throwable;
        }
    }

    private void fillSuppressedThrowable(final AssertionError assertionError) {
        for (Throwable throwable : _suppressedThrowables) {
            Throwable unwrappedThrowable = getUnwrappedThrowable(throwable);
            assertionError.addSuppressed(unwrappedThrowable);
        }
    }

}
