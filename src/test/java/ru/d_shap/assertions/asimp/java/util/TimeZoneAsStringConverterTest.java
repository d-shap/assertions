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

import java.util.TimeZone;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link TimeZoneAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class TimeZoneAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public TimeZoneAsStringConverterTest() {
        super();
    }

    /**
     * {@link TimeZoneAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new TimeZoneAsStringConverter().getValueClass()).isEqualTo(TimeZone.class);
    }

    /**
     * {@link TimeZoneAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("UTC"))).isEqualTo("UTC");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("GMT"))).isEqualTo("GMT");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("Asia/Novosibirsk"))).isEqualTo("Asia/Novosibirsk");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("Asia/Krasnoyarsk"))).isEqualTo("Asia/Krasnoyarsk");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("Asia/Vientiane"))).isEqualTo("Asia/Vientiane");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("Europe/Berlin"))).isEqualTo("Europe/Berlin");
        Assertions.assertThat(new TimeZoneAsStringConverter().asString(TimeZone.getTimeZone("Europe/Vienna"))).isEqualTo("Europe/Vienna");
    }

    /**
     * {@link TimeZoneAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new TimeZoneAsStringConverter().asString(null);
    }

    /**
     * {@link TimeZoneAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new TimeZoneAsStringConverter().asString(new Object());
    }

}
