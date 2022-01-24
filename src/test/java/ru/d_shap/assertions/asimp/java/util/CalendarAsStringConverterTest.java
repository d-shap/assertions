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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link CalendarAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CalendarAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CalendarAsStringConverterTest() {
        super();
    }

    /**
     * {@link CalendarAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CalendarAsStringConverter().getValueClass()).isEqualTo(Calendar.class);
    }

    /**
     * {@link CalendarAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new CalendarAsStringConverter().asString(createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47))).isEqualTo("2020-07-11T15:23:47.000+0000");
        Assertions.assertThat(new CalendarAsStringConverter().asString(createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47))).isEqualTo("2020-12-11T15:23:47.000+0000");
        Assertions.assertThat(new CalendarAsStringConverter().asString(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"))).isEqualTo("2020-07-11T15:23:47.000+0700");
        Assertions.assertThat(new CalendarAsStringConverter().asString(createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"))).isEqualTo("2020-12-11T15:23:47.000+0700");
        Assertions.assertThat(new CalendarAsStringConverter().asString(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"))).isEqualTo("2020-07-11T15:23:47.000+0200");
        Assertions.assertThat(new CalendarAsStringConverter().asString(createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"))).isEqualTo("2020-12-11T15:23:47.000+0100");
    }

    /**
     * {@link CalendarAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new CalendarAsStringConverter().asString(null);
    }

    /**
     * {@link CalendarAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new CalendarAsStringConverter().asString(new Object());
    }

}
