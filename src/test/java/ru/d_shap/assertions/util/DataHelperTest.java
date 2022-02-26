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
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarMillisecondTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarTest() {
        // TODO
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarMillisecondTest() {
        // TODO
    }

}
