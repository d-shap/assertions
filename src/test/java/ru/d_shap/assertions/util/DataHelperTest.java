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
package ru.d_shap.assertions.util;

import java.util.Calendar;
import java.util.TimeZone;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DataHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class DataHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DataHelperTest() {
        super();
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(DataHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDateTest() {
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDateMillisecondTest() {
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarTest() {
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 2 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 2 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 2 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 2 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarTest() {
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDatatypeFactoryTest() {
        DatatypeFactory datatypeFactory = DataHelper.createDatatypeFactory();
        datatypeFactory.newXMLGregorianCalendar();

        try {
            DataHelper.createDatatypeFactory(new DatatypeFactoryCreatorFailImpl());
            Assertions.fail("DataHelper test fail");
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(DatatypeConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createDocumentBuilderFactoryTest() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DataHelper.createDocumentBuilderFactory();
        Assertions.assertThat(documentBuilderFactory.isNamespaceAware()).isTrue();
        Assertions.assertThat(documentBuilderFactory.isXIncludeAware()).isTrue();
        Assertions.assertThat(documentBuilderFactory.getFeature(XMLConstants.FEATURE_SECURE_PROCESSING)).isTrue();
        Assertions.assertThat(documentBuilderFactory.getFeature("http://apache.org/xml/features/disallow-doctype-decl")).isTrue();

        try {
            DataHelper.createDocumentBuilderFactory(new DocumentBuilderFactoryCreatorFailImpl());
            Assertions.fail("DataHelper test fail");
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(ParserConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDocumentBuilderTest() {
        DocumentBuilder documentBuilder = DataHelper.createDocumentBuilder();
        Assertions.assertThat(documentBuilder.isNamespaceAware()).isTrue();
        Assertions.assertThat(documentBuilder.isXIncludeAware()).isTrue();

        try {
            DataHelper.createDocumentBuilder(new DocumentBuilderCreatorFailImpl());
            Assertions.fail("DataHelper test fail");
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(ParserConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTransformerFactoryTest() {
        TransformerFactory transformerFactory = DataHelper.createTransformerFactory();
        Assertions.assertThat(transformerFactory.getAttribute(XMLConstants.ACCESS_EXTERNAL_DTD)).isEqualTo("");
        Assertions.assertThat(transformerFactory.getAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET)).isEqualTo("");
        Assertions.assertThat(transformerFactory.getFeature(XMLConstants.FEATURE_SECURE_PROCESSING)).isTrue();

        try {
            DataHelper.createTransformerFactory(new TransformerFactoryCreatorFailImpl());
            Assertions.fail("DataHelper test fail");
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(TransformerConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTransformerTest() {
        Transformer transformer = DataHelper.createTransformer();
        Assertions.assertThat(transformer.getErrorListener()).isInstanceOf(DataHelper.TransformerNoopErrorListener.class);

        try {
            DataHelper.createTransformer(new TransformerCreatorFailImpl());
            Assertions.fail("DataHelper test fail");
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(TransformerConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void transformerNoopErrorListenerTest() {
        new DataHelper.TransformerNoopErrorListener().warning(null);
        new DataHelper.TransformerNoopErrorListener().error(null);
        new DataHelper.TransformerNoopErrorListener().fatalError(null);
    }

    private static final class DatatypeFactoryCreatorFailImpl implements DataHelper.DatatypeFactoryCreator {

        DatatypeFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public DatatypeFactory newDatatypeFactory() throws DatatypeConfigurationException {
            throw new DatatypeConfigurationException("test exception");
        }

    }

    private static final class DocumentBuilderFactoryCreatorFailImpl implements DataHelper.DocumentBuilderFactoryCreator {

        DocumentBuilderFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public DocumentBuilderFactory newDocumentBuilderFactory() throws ParserConfigurationException {
            throw new ParserConfigurationException("test exception");
        }

    }

    private static final class DocumentBuilderCreatorFailImpl implements DataHelper.DocumentBuilderCreator {

        DocumentBuilderCreatorFailImpl() {
            super();
        }

        @Override
        public DocumentBuilder newDocumentBuilder(final DocumentBuilderFactory documentBuilderFactory) throws ParserConfigurationException {
            throw new ParserConfigurationException("test exception");
        }

    }

    private static final class TransformerFactoryCreatorFailImpl implements DataHelper.TransformerFactoryCreator {

        TransformerFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public TransformerFactory newTransformerFactory() throws TransformerConfigurationException {
            throw new TransformerConfigurationException("test exception");
        }

    }

    private static final class TransformerCreatorFailImpl implements DataHelper.TransformerCreator {

        TransformerCreatorFailImpl() {
            super();
        }

        @Override
        public Transformer newTransformer(final TransformerFactory transformerFactory) throws TransformerException {
            throw new TransformerConfigurationException("test exception");
        }

    }

}
