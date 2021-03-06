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

    private AssertionErrorBuilder(final FailDescription failDescription, final Class<?> actualClass, final Object actual) {
        super();
        _failDescription = failDescription;
        _failDescriptionEntries = new ArrayList<>();
        _failDescriptionValues = new FailDescriptionValues(actualClass, actual);
        _throwable = null;
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
     * Add the throwabe message to the assertion error.
     *
     * @param throwable the throwabe.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addMessage(final Throwable throwable) {
        return addMessage(Messages.SIMPLE_MESSAGE, getThrowable(throwable).toString());
    }

    /**
     * Add the actual value of the assertion to the assertion error.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addActual() {
        _failDescriptionValues.addActual();
        return this;
    }

    /**
     * Add the expected value of the assertion to the assertion error.
     * The expected value is converted to the actual value's class.
     *
     * @param expected the expected value of the assertion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expected) {
        _failDescriptionValues.addExpected(expected);
        return this;
    }

    /**
     * Add the expected value range of the assertion to the assertion error.
     * The expected value is converted to the actual value's class.
     *
     * @param expectedFrom the lower bound of the expected value range of the assertion.
     * @param expectedTo   the upper bound of the expected value range of the assertion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expectedFrom, final Object expectedTo) {
        _failDescriptionValues.addExpected(expectedFrom, expectedTo);
        return this;
    }

    /**
     * Add the expected value of the assertion to the assertion error.
     * The expected value is converted to the specified class.
     *
     * @param expected      the expected value of the assertion.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpected(final Object expected, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpected(expected, expectedClass);
        return this;
    }

    /**
     * Add the expected value of the assertion to the assertion error.
     * The expected value is converted to the specified class.
     *
     * @param expectedFrom  the lower bound of the expected value range of the assertion.
     * @param expectedTo    the upper bound of the expected value range of the assertion.
     * @param expectedClass the specified class for the value conversion.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addRawExpected(final Object expectedFrom, final Object expectedTo, final Class<?> expectedClass) {
        _failDescriptionValues.addRawExpected(expectedFrom, expectedTo, expectedClass);
        return this;
    }

    /**
     * Add the actual and expected values' delta to the assertion error.
     * The delta value is converted to the actual or expected values' class.
     *
     * @param delta the actual and expected values' delta.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addDelta(final Object delta) {
        _failDescriptionValues.addDelta(delta);
        return this;
    }

    /**
     * Add the throwabe to the assertion error.
     *
     * @param throwable the throwabe.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addThrowable(final Throwable throwable) {
        _throwable = throwable;
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

    private AssertionError createAssertionError() throws ConversionException {
        List<FailDescriptionEntry> failDescriptionEntries = new ArrayList<>(_failDescriptionEntries);
        _failDescriptionValues.addFailDescriptionEntry(failDescriptionEntries);

        FailDescription failDescription = new FailDescription(_failDescription);
        for (FailDescriptionEntry failDescriptionEntry : failDescriptionEntries) {
            failDescription = new FailDescription(failDescription, failDescriptionEntry);
        }
        String fullMessage = failDescription.getFullMessage();
        Throwable throwable = getThrowable(_throwable);
        return new AssertionError(fullMessage, throwable);
    }

    private AssertionError createAssertionError(final ConversionException conversionException) {
        Throwable throwable = getThrowable(conversionException);
        try {
            FailDescription failDescription = new FailDescription(_failDescription, throwable.toString());
            String fullMessage = failDescription.getFullMessage();
            return new AssertionError(fullMessage, throwable);
        } catch (ConversionException ex) {
            return new AssertionError(throwable.toString(), throwable);
        }
    }

    private Throwable getThrowable(final Throwable throwable) {
        if (throwable instanceof ConversionException) {
            return throwable.getCause();
        } else {
            return throwable;
        }
    }

}
