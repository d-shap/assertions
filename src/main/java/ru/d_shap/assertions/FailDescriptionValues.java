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

import java.util.List;

/**
 * Fail description actual and expected values.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionValues {

    private final Class<?> _valueClass;

    private boolean _actualDefined;

    private final Object _actual;

    private boolean _expected1Defined;

    private Object _expected1;

    private boolean _expected2Defined;

    private Object _expected2;

    FailDescriptionValues(final Class<?> valueClass, final Object actual) {
        super();
        _valueClass = valueClass;
        _actualDefined = false;
        _actual = actual;
        _expected1Defined = false;
        _expected1 = null;
        _expected2Defined = false;
        _expected2 = null;
    }

    void addActual() {
        _actualDefined = true;
    }

    void addExpected(final Object expected) {
        _expected1Defined = true;
        _expected1 = expected;
        _expected2Defined = false;
        _expected2 = null;
    }

    void addExpected(final Object expectedFrom, final Object expectedTo) {
        _expected1Defined = false;
        _expected1 = expectedFrom;
        _expected2Defined = true;
        _expected2 = expectedTo;
    }

    void addFailDescriptionEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_valueClass != null) {
            addExpectedEntry(failDescriptionEntries);
            addExpected2Entry(failDescriptionEntries);
            addActualEntry(failDescriptionEntries);
            addActualAndExpectedEntry(failDescriptionEntries);
            addActualAndExpected2Entry(failDescriptionEntries);
        }
    }

    private void addExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (!_actualDefined && _expected1Defined) {
            String expected = getValueMessage(_expected1, _valueClass);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (!_actualDefined && _expected2Defined) {
            String expected = getValueMessage(_expected1, _expected2, _valueClass);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && !_expected1Defined && !_expected2Defined) {
            String actual = getValueMessage(_actual, _valueClass);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL, new Object[]{actual}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && _expected1Defined) {
            String actual = getValueMessage(_actual, _valueClass);
            String expected = getValueMessage(_expected1, _valueClass);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && _expected2Defined) {
            String actual = getValueMessage(_actual, _valueClass);
            String expected = getValueMessage(_expected1, _expected2, _valueClass);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private String getValueMessage(final Object object, final Class<?> valueClass) throws ConversionException {
        String objectStr = AsStringConverter.asString(object, valueClass);
        return "<" + objectStr + ">";
    }

    private String getValueMessage(final Object objectFrom, final Object objectTo, final Class<?> valueClass) throws ConversionException {
        String objectFromStr = AsStringConverter.asString(objectFrom, valueClass);
        String objectToStr = AsStringConverter.asString(objectTo, valueClass);
        return "<" + objectFromStr + ":" + objectToStr + ">";
    }

}
