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
import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link DateToCalendarValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DateToCalendarValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DateToCalendarValueConverterTest() {
        super();
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DateToCalendarValueConverter().getValueClass()).isEqualTo(Date.class);
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new DateToCalendarValueConverter().getTargetClass()).isEqualTo(Calendar.class);
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47)), Raw.calendarAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47))).as(Raw.calendarAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)), Raw.calendarAssertion()).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47))).as(Raw.calendarAssertion()).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)), Raw.calendarAssertion()).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543))).as(Raw.calendarAssertion()).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543))).isInstanceOf(Calendar.class);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)), Raw.calendarAssertion()).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        Assertions.assertThat(new DateToCalendarValueConverter().convert(DataHelper.createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543))).as(Raw.calendarAssertion()).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new DateToCalendarValueConverter().convert(null);
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new DateToCalendarValueConverter().convert(new Object());
    }

    /**
     * {@link DateToCalendarValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new DateToCalendarValueConverter().convert(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47), new Object());
    }

}
