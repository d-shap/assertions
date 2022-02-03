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
package ru.d_shap.assertions.asimp.javax.xml.datatype;

import java.util.Calendar;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link XMLGregorianCalendarAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public class XMLGregorianCalendarAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public XMLGregorianCalendarAssertionTest() {
        super();
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));

        try {
            initializeWithRawActual(Raw.xmlGregorianCalendarAssertion(), new Object());
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.datatype.XMLGregorianCalendar> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.xmlGregorianCalendarAssertion(), new Object(), "Message");
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.datatype.XMLGregorianCalendar> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toYearTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetMatcherTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasZoneOffsetTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneCalendarTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneIdCalendarTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toUtcTimeZoneCalendarTest() {
        // TODO
    }

}
