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

/**
 * Builder for the assertion error.
 *
 * @author Dmitry Shapovalov
 */
public final class AssertionErrorBuilder {

    private static final String VALUE_ACTUAL = "Actual:{0}";

    private static final String VALUE_EXPECTED = "Expected:{0}";

    private static final String VALUE_ACTUAL_AND_EXPECTED = "Expected:{1} but was:{0}";

    private final FailDescription _failDescription;

    private final Class<?> _valueClass;

    private final List<FailDescriptionEntry> _failDescriptionEntries;

    private boolean _actualDefined;

    private Object _actual;

    private boolean _expected1Defined;

    private Object _expected1;

    private boolean _expected2Defined;

    private Object _expected2;

    private Throwable _throwable;

    AssertionErrorBuilder(final FailDescription failDescription, final Class<?> valueClass, final Object actual) {
        super();
        _failDescription = failDescription;
        _valueClass = valueClass;
        _failDescriptionEntries = new ArrayList<>();
        _actualDefined = false;
        _actual = actual;
        _expected1Defined = false;
        _expected1 = null;
        _expected2Defined = false;
        _expected2 = null;
        _throwable = null;
    }

    /**
     * Add the message to the assertion error.
     *
     * @param message   the message.
     * @param arguments the message arguments.
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addMessage(final String message, final Object... arguments) {
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
        return this;
    }

    /**
     * Add the actual value of the assertion to the assertion error.
     *
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addActual() {
        _actualDefined = true;
        return this;
    }

    /**
     * Add the expected value of the assertion to the assertion error.
     *
     * @param expected the expected value of the assertion.
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expected) {
        _expected1Defined = true;
        _expected1 = expected;
        _expected2Defined = false;
        _expected2 = null;
        return this;
    }

    /**
     * Add the expected value range of the assertion to the assertion error.
     *
     * @param expectedFrom the lower (inclusive) bound of the expected value range of the assertion.
     * @param expectedTo   the upper (exclusive) bound of the expected value range of the assertion.
     * @return current object for the chain call.
     */
    public AssertionErrorBuilder addExpected(final Object expectedFrom, final Object expectedTo) {
        _expected1Defined = false;
        _expected1 = expectedFrom;
        _expected2Defined = true;
        _expected2 = expectedTo;
        return this;
    }

    /**
     * Add the throwabe to the assertion error.
     *
     * @param throwable the throwabe.
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
            List<FailDescriptionEntry> failDescriptionEntries = new ArrayList<>(_failDescriptionEntries);
            addFailDescriptionEntryForValues(failDescriptionEntries);

            FailDescription failDescription = new FailDescription(_failDescription);
            for (FailDescriptionEntry failDescriptionEntry : failDescriptionEntries) {
                failDescription = new FailDescription(failDescription, failDescriptionEntry);
            }
            String fullMessage = failDescription.getFullMessage();
            Throwable throwable = getThrowable(_throwable);
            return new AssertionError(fullMessage, throwable);
        } catch (ConvertionException ex) {
            String fullMessage = _failDescription.getFullMessage();
            Throwable throwable = getThrowable(ex);
            return new AssertionError(fullMessage, throwable);
        }
    }

    private void addFailDescriptionEntryForValues(final List<FailDescriptionEntry> failDescriptionEntries) throws ConvertionException {
        if (_actualDefined) {
            if (_expected2Defined) {
                String actual = getValueMessage(_actual, _valueClass);
                String expected = getValueMessage(_expected1, _expected2, _valueClass);
                FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(VALUE_ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
                failDescriptionEntries.add(failDescriptionEntry);
            } else if (_expected1Defined) {
                String actual = getValueMessage(_actual, _valueClass);
                String expected = getValueMessage(_expected1, _valueClass);
                FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(VALUE_ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
                failDescriptionEntries.add(failDescriptionEntry);
            } else {
                String actual = getValueMessage(_actual, _valueClass);
                FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(VALUE_ACTUAL, new Object[]{actual}, false);
                failDescriptionEntries.add(failDescriptionEntry);
            }
        } else {
            if (_expected2Defined) {
                String expected = getValueMessage(_expected1, _expected2, _valueClass);
                FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(VALUE_EXPECTED, new Object[]{expected}, false);
                failDescriptionEntries.add(failDescriptionEntry);
            } else if (_expected1Defined) {
                String expected = getValueMessage(_expected1, _valueClass);
                FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(VALUE_EXPECTED, new Object[]{expected}, false);
                failDescriptionEntries.add(failDescriptionEntry);
            }
        }
    }

    private String getValueMessage(final Object object, final Class<?> valueClass) throws ConvertionException {
        String objectStr = AsStringConverter.asString(object, valueClass);
        return "<" + objectStr + ">";
    }

    private String getValueMessage(final Object objectFrom, final Object objectTo, final Class<?> valueClass) throws ConvertionException {
        String objectFromStr = AsStringConverter.asString(objectFrom, valueClass);
        String objectToStr = AsStringConverter.asString(objectTo, valueClass);
        return "<" + objectFromStr + ":" + objectToStr + ">";
    }

    private Throwable getThrowable(final Throwable throwable) {
        if (throwable instanceof ConvertionException) {
            return throwable.getCause();
        } else {
            return throwable;
        }
    }

}
