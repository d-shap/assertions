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

/**
 * Fail description actual and expected values.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionValues {

    private static final String DELTA_SIGN = "\u00b1";

    private final Class<?> _actualClass;

    private Class<?> _expectedClass;

    private boolean _actualDefined;

    private final Object _actual;

    private boolean _actualDeltaDefined;

    private Object _actualDelta;

    private boolean _expected1Defined;

    private Object _expected1;

    private boolean _expected2Defined;

    private Object _expected2;

    private boolean _expectedDeltaDefined;

    private Object _expectedDelta;

    FailDescriptionValues(final Class<?> actualClass, final Object actual) {
        super();
        _actualClass = actualClass;
        _expectedClass = null;
        _actualDefined = false;
        _actual = actual;
        _actualDeltaDefined = false;
        _actualDelta = null;
        _expected1Defined = false;
        _expected1 = null;
        _expected2Defined = false;
        _expected2 = null;
        _expectedDeltaDefined = false;
        _expectedDelta = null;
    }

    void addActual() {
        _actualDefined = true;
        _actualDeltaDefined = false;
        _actualDelta = null;
    }

    void addActualWithDelta(final Object delta) {
        _actualDefined = true;
        _actualDeltaDefined = true;
        _actualDelta = delta;
    }

    void addExpected(final Object expected) {
        addRawExpected(expected, _actualClass);
    }

    void addExpected(final Object expectedFrom, final Object expectedTo) {
        addRawExpected(expectedFrom, expectedTo, _actualClass);
    }

    void addExpectedWithDelta(final Object expected, final Object delta) {
        addRawExpectedWithDelta(expected, delta, _actualClass);
    }

    void addExpectedWithDelta(final Object expectedFrom, final Object expectedTo, final Object delta) {
        addRawExpectedWithDelta(expectedFrom, expectedTo, delta, _actualClass);
    }

    void addRawExpected(final Object expected, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = true;
        _expected1 = expected;
        _expected2Defined = false;
        _expected2 = null;
        _expectedDeltaDefined = false;
        _expectedDelta = null;
    }

    void addRawExpected(final Object expectedFrom, final Object expectedTo, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = false;
        _expected1 = expectedFrom;
        _expected2Defined = true;
        _expected2 = expectedTo;
        _expectedDeltaDefined = false;
        _expectedDelta = null;
    }

    void addRawExpectedWithDelta(final Object expected, final Object delta, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = true;
        _expected1 = expected;
        _expected2Defined = false;
        _expected2 = null;
        _expectedDeltaDefined = true;
        _expectedDelta = delta;
    }

    void addRawExpectedWithDelta(final Object expectedFrom, final Object expectedTo, final Object delta, final Class<?> expectedClass) {
        _expectedClass = expectedClass;
        _expected1Defined = false;
        _expected1 = expectedFrom;
        _expected2Defined = true;
        _expected2 = expectedTo;
        _expectedDeltaDefined = true;
        _expectedDelta = delta;
    }

    void addFailDescriptionEntry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (_actualClass != null) {
            addActualEntry(failDescriptionEntries);
            addExpectedEntry(failDescriptionEntries);
            addExpected2Entry(failDescriptionEntries);
            addActualAndExpectedEntry(failDescriptionEntries);
            addActualAndExpected2Entry(failDescriptionEntries);
        }
    }

    private void addActualEntry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (_actualDefined && !_expected1Defined && !_expected2Defined) {
            String actual = getActualMessage();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL, new Object[]{actual}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (!_actualDefined && _expected1Defined) {
            String expected = getExpectedMessage();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (!_actualDefined && _expected2Defined) {
            String expected = getExpected2Message();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.EXPECTED, new Object[]{expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpectedEntry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (_actualDefined && _expected1Defined) {
            String actual = getActualMessage();
            String expected = getExpectedMessage();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private void addActualAndExpected2Entry(final List<FailDescriptionEntry> failDescriptionEntries) {
        if (_actualDefined && _expected2Defined) {
            String actual = getActualMessage();
            String expected = getExpected2Message();
            FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(Messages.Value.ACTUAL_AND_EXPECTED, new Object[]{actual, expected}, false);
            failDescriptionEntries.add(failDescriptionEntry);
        }
    }

    private String getActualMessage() {
        String objectStr = AsStringConverter.asString(_actual, _actualClass);
        if (_actualDeltaDefined) {
            objectStr += DELTA_SIGN;
            objectStr += AsStringConverter.asString(_actualDelta, _actualClass);
        }
        return "<" + objectStr + ">";
    }

    private String getExpectedMessage() {
        String objectStr = AsStringConverter.asString(_expected1, _expectedClass);
        if (_expectedDeltaDefined) {
            objectStr += DELTA_SIGN;
            objectStr += AsStringConverter.asString(_expectedDelta, _expectedClass);
        }
        return "<" + objectStr + ">";
    }

    private String getExpected2Message() {
        String objectStr = AsStringConverter.asString(_expected1, _expectedClass);
        objectStr += ":";
        objectStr += AsStringConverter.asString(_expected2, _expectedClass);
        if (_expectedDeltaDefined) {
            objectStr += DELTA_SIGN;
            objectStr += AsStringConverter.asString(_expectedDelta, _expectedClass);
        }
        return "<" + objectStr + ">";
    }

}
