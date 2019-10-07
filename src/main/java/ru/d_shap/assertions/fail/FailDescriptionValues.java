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

import java.util.List;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Fail description actual and expected values.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionValues {

    private final Class<?> _actualClass;

    private Class<?> _expectedClass;

    private boolean _actualDefined;

    private final Object _actual;

    private boolean _expected1Defined;

    private Object _expected1;

    private boolean _expected2Defined;

    private Object _expected2;

    private boolean _deltaDefined;

    private Object _delta;

    FailDescriptionValues(final Class<?> actualClass, final Object actual) {
        super();
        _actualClass = actualClass;
        _expectedClass = null;
        _actualDefined = false;
        _actual = actual;
        _expected1Defined = false;
        _expected1 = null;
        _expected2Defined = false;
        _expected2 = null;
        _deltaDefined = false;
        _delta = null;
    }

    void addActual() {
        _actualDefined = true;
    }

    void addExpected(final Object expected) {
        addRawExpected(expected, _actualClass);
    }

    void addExpected(final Object expectedFrom, final Object expectedTo) {
        addRawExpected(expectedFrom, expectedTo, _actualClass);
    }

    void addRawExpected(final Object expected, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = true;
        _expected1 = expected;
        _expected2Defined = false;
        _expected2 = null;
    }

    void addRawExpected(final Object expectedFrom, final Object expectedTo, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = false;
        _expected1 = expectedFrom;
        _expected2Defined = true;
        _expected2 = expectedTo;
    }

    void addDelta(final Object delta) {
        _deltaDefined = true;
        _delta = delta;
    }

    void addFailDescriptionEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualClass != null) {
            addActualEntry(failDescriptionEntries);
            addExpectedEntry(failDescriptionEntries);
            addExpected2Entry(failDescriptionEntries);
            addActualAndExpectedEntry(failDescriptionEntries);
            addActualAndExpected2Entry(failDescriptionEntries);
        }
    }

    private void addActualEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && !_expected1Defined && !_expected2Defined) {
            String actual = getActualMessage(true);
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL, new Object[]{actual}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (!_actualDefined && _expected1Defined) {
            String expected = getExpectedMessage();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (!_actualDefined && _expected2Defined) {
            String expected = getExpected2Message();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && _expected1Defined) {
            String actual = getActualMessage(false);
            String expected = getExpectedMessage();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) throws ConversionException {
        if (_actualDefined && _expected2Defined) {
            String actual = getActualMessage(false);
            String expected = getExpected2Message();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private String getActualMessage(final boolean withDelta) throws ConversionException {
        String objectStr = AsStringConverter.asString(_actual, _actualClass);
        if (withDelta && _deltaDefined) {
            objectStr += "\u00b1";
            objectStr += AsStringConverter.asString(_delta, _actualClass);
        }
        return "<" + objectStr + ">";
    }

    private String getExpectedMessage() throws ConversionException {
        String objectStr = AsStringConverter.asString(_expected1, _expectedClass);
        if (_deltaDefined) {
            objectStr += "\u00b1";
            objectStr += AsStringConverter.asString(_delta, _expectedClass);
        }
        return "<" + objectStr + ">";
    }

    private String getExpected2Message() throws ConversionException {
        String objectStr = AsStringConverter.asString(_expected1, _expectedClass);
        objectStr += ":";
        objectStr += AsStringConverter.asString(_expected2, _expectedClass);
        if (_deltaDefined) {
            objectStr += "\u00b1";
            objectStr += AsStringConverter.asString(_delta, _expectedClass);
        }
        return "<" + objectStr + ">";
    }

}
