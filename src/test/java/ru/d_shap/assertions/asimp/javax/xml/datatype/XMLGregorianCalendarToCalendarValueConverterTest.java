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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link XMLGregorianCalendarToCalendarValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class XMLGregorianCalendarToCalendarValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public XMLGregorianCalendarToCalendarValueConverterTest() {
        super();
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().getValueClass()).isEqualTo(XMLGregorianCalendar.class);
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().getTargetClass()).isEqualTo(Calendar.class);
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "GMT+00:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "GMT+00:00");

        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "GMT+02:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "GMT+02:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "GMT+01:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "GMT+01:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "GMT+01:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "GMT+01:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null)).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "GMT+01:00");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), (TimeZone) null)).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "GMT+01:00");

        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 20, 23, 47, 0, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 20, 23, 47, 0, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 21, 23, 47, 0, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 21, 23, 47, 0, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("Asia/Vientiane"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane");

        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47, 0, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47, 0, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC")), Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC");
        Assertions.assertThat(new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"), TimeZone.getTimeZone("UTC"))).as(Raw.calendarAssertion()).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC");
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new XMLGregorianCalendarToCalendarValueConverter().convert(null);
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new XMLGregorianCalendarToCalendarValueConverter().convert(new Object());
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47));
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), new Object(), new Object());
    }

    /**
     * {@link XMLGregorianCalendarToCalendarValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() {
        new XMLGregorianCalendarToCalendarValueConverter().convert(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47), new Object());
    }

}
