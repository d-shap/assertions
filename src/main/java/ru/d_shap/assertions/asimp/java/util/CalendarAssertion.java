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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Calendar;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the calendar.
 *
 * @author Dmitry Shapovalov
 */
public class CalendarAssertion extends ReferenceAssertion<Calendar> {

    /**
     * Create new object.
     */
    public CalendarAssertion() {
        super();
    }

    @Override
    protected final Class<Calendar> getActualValueClass() {
        return Calendar.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) <= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) > 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final Calendar expectedFrom, final Calendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) < 0 || getActual().compareTo(expectedTo) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final Calendar expectedFrom, final Calendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) >= 0 && getActual().compareTo(expectedTo) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @return the assertion.
     */
    public final IntAssertion toYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.YEAR), Messages.Check.YEAR);
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toYear(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.YEAR), matcher, Messages.Check.YEAR);
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     */
    public final void hasYear(final int expected) {
        toYear().isEqualTo(expected);
    }

}
