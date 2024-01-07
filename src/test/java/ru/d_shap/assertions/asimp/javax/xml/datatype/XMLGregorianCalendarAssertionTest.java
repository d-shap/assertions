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
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link XMLGregorianCalendarAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class XMLGregorianCalendarAssertionTest extends AssertionTest {

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
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));

        try {
            initializeWithRawActual(Raw.xmlGregorianCalendarAssertion(), new Object());
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.datatype.XMLGregorianCalendar> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.xmlGregorianCalendarAssertion(), new Object(), "Message");
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.datatype.XMLGregorianCalendar> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), null).isEqualTo(null);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isEqualTo(DataHelper.createXmlCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotEqualTo(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(null);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1323, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.NOVEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 20, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 21, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 45, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 555, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 5, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().isNotEqualTo(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isNotEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"), "Message").isNotEqualTo(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin")).isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T17:23:47.000+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"), "Message").isNotEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T17:23:47.000+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isGreaterThan(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isGreaterThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isLessThan(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isLessThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThan(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isLessThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThanOrEqualTo(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.MAY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.SEPTEMBER, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 9, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 13, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 21, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 25, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 45, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 49, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 343, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 347, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(DataHelper.createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(DataHelper.createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isNotInRange(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toYearTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toYear().isEqualTo(2020);

        try {
            Raw.xmlGregorianCalendarAssertion().toYear();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toYear();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toYear();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear()).isEqualTo(2020);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear()).isEqualTo(2020);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2019);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear().isEqualTo(2019);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toYear(Matchers.is(Matchers.equalTo(2020))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toYear(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toYear(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toYear(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toYear(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toYear(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasYear(2020).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasYear(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasYear(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasYear(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2019);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasYear(2019);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMonth().isEqualTo(Calendar.JULY);

        try {
            Raw.xmlGregorianCalendarAssertion().toMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.JULY);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMonth(Calendar.JULY);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMonth(Calendar.JULY).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMonth(Calendar.DECEMBER);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfMonth().isEqualTo(11);

        try {
            Raw.xmlGregorianCalendarAssertion().toDayOfMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toDayOfMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toDayOfMonth();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth().isEqualTo(12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfMonth(Matchers.is(Matchers.equalTo(11))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toDayOfMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toDayOfMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasDayOfMonth(11).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasDayOfMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasDayOfMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasDayOfMonth(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfMonth(12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHourOfDay().isEqualTo(15);

        try {
            Raw.xmlGregorianCalendarAssertion().toHourOfDay();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toHourOfDay();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toHourOfDay();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(14);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay().isEqualTo(14);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHourOfDay(Matchers.is(Matchers.equalTo(15))).isInstanceOf(XMLGregorianCalendar.class).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toHourOfDay(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toHourOfDay(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasHourOfDay(15).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasHourOfDay(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasHourOfDay(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasHourOfDay(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(14);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHourOfDay(14);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMinute().isEqualTo(23);

        try {
            Raw.xmlGregorianCalendarAssertion().toMinute();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMinute();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMinute();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(22);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute().isEqualTo(22);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMinute(Matchers.is(Matchers.equalTo(23))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toMinute(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMinute(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMinute(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMinute(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMinute(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMinute(23).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasMinute(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasMinute(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasMinute(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(22);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMinute(22);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toSecond().isEqualTo(47);

        try {
            Raw.xmlGregorianCalendarAssertion().toSecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toSecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toSecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(46);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond().isEqualTo(46);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toSecond(Matchers.is(Matchers.equalTo(47))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toSecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toSecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toSecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toSecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toSecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasSecond(47).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasSecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasSecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasSecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(46);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasSecond(46);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMillisecond().isEqualTo(0);

        try {
            Raw.xmlGregorianCalendarAssertion().toMillisecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMillisecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMillisecond();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond()).isEqualTo(193);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond().isEqualTo(544);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond().isEqualTo(544);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMillisecond(Matchers.is(Matchers.equalTo(0))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toMillisecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMillisecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMillisecond(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toMillisecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toMillisecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMillisecond(0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasMillisecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasMillisecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasMillisecond(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).hasMillisecond(544);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").hasMillisecond(544);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toZoneOffset().isEqualTo(0);

        try {
            Raw.xmlGregorianCalendarAssertion().toZoneOffset();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toZoneOffset();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toZoneOffset();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset()).isEqualTo(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset()).isEqualTo(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset().isEqualTo(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset().isEqualTo(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetMatcherTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(2 * 60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toZoneOffset(Matchers.is(Matchers.equalTo(0))).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toZoneOffset(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toZoneOffset(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset(null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasZoneOffsetTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasZoneOffset(0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasZoneOffset(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasZoneOffset(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasZoneOffset(0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasZoneOffset(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasZoneOffset(100);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDate(2020, Calendar.JULY, 11).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2019, Calendar.JULY, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2019, Calendar.JULY, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.JULY, 12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.JULY, 21, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.JULY, 11, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.JULY, 21, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.JULY, 11, 2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.JULY, 21, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDate(2020, Calendar.JULY, 11, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2019, Calendar.JULY, 11, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2019, Calendar.JULY, 11, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.AUGUST, 11, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.AUGUST, 11, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 12, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 12, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 11, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.JULY, 20);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.DECEMBER, 20);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDate(2020, Calendar.JULY, 11).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasUtcDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasUtcDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasUtcDate(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTime(15, 23, 47).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 22, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 22, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 45);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 23, 45);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTime(15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 22, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 22, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 45, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 45, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(16, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 22, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 45, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, 2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, 0, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(16, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 22, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 45, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 555, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 555, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcTime(15, 23, 47).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasUtcTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasUtcTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasUtcTime(1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(11, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 22, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 45);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcTime(15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasUtcTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasUtcTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasUtcTime(1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(11, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 22, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 45, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 2 * 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, 0);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeMillisecondTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47, 0);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543);
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(XMLGregorianCalendar.class);

        try {
            Raw.xmlGregorianCalendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneCalendarTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 10, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 9, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 20, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 21, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.xmlGregorianCalendarAssertion().toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: timeZone.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: timeZone.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneIdCalendarTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 10, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 9, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 20, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 21, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.xmlGregorianCalendarAssertion().toTimeZoneCalendar("UTC");
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toTimeZoneCalendar("UTC");
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toTimeZoneCalendar("UTC");
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toTimeZoneCalendar((String) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toTimeZoneCalendar((String) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar((String) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: timeZoneId.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZoneCalendar((String) null);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: timeZoneId.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void toUtcTimeZoneCalendarTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.xmlGregorianCalendarAssertion().toUtcTimeZoneCalendar();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).toUtcTimeZoneCalendar();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").toUtcTimeZoneCalendar();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 8, 23, 47, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T08:23:47.000+0000> but was:<2020-07-11T08:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 8, 23, 47, "UTC"));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T08:23:47.000+0000> but was:<2020-07-11T08:23:47.000+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void changeTimeZoneTest() {
        TimeZone timeZone = TimeZone.getDefault();

        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));

            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47);
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasZoneOffset(7 * 60 * 60 * 1000);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));

            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47);
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasZoneOffset(2 * 60 * 60 * 1000);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), null).isNull();

        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNull();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isNull();
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        XMLGregorianCalendar value = DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), value).isSameAs(DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<2020-07-11T15:23:47.000+0000> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), value, "Message").isSameAs(DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<2020-07-11T15:23:47.000+0000> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        XMLGregorianCalendar value = DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.xmlGregorianCalendarAssertion(), value).isNotSameAs(DataHelper.createUtcXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));

        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), value).isNotSameAs(value);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(XMLGregorianCalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
    }

}
