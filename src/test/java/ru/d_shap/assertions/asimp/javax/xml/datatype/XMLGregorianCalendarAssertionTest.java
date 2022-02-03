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
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).isEqualTo(createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).isEqualTo(createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));

        try {
            Raw.xmlGregorianCalendarAssertion().isEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isEqualTo(createXmlCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isEqualTo(createXmlCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1323, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.NOVEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 20, 3, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 21, 46, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 45, 543, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 555, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 5, 22, 46, 543, "Europe/Berlin"));

        try {
            Raw.xmlGregorianCalendarAssertion().isNotEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isNotEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"), "Message").isNotEqualTo(createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin")).isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T17:23:47.000+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"), "Message").isNotEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T17:23:47.000+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));

        try {
            Raw.xmlGregorianCalendarAssertion().isGreaterThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));

        try {
            Raw.xmlGregorianCalendarAssertion().isGreaterThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.xmlGregorianCalendarAssertion().isLessThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThan(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.xmlGregorianCalendarAssertion().isLessThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThanOrEqualTo(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));

        try {
            Raw.xmlGregorianCalendarAssertion().isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.MAY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.SEPTEMBER, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 9, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 13, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 21, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 25, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 45, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 49, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 343, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 347, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.xmlGregorianCalendarAssertion().isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null).isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), null, "Message").isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(createXmlCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(createXmlCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createXmlCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.xmlGregorianCalendarAssertion(), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isNotInRange(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("XMLGregorianCalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
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
    public void hasTimeZoneDateTest() {
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
    public void hasTimeZoneTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeMillisecondTest() {
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
    public void hasTimeZoneDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeMillisecondTest() {
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

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link XMLGregorianCalendarAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
