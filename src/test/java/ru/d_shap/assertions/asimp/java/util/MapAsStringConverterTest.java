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

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link MapAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class MapAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MapAsStringConverterTest() {
        super();
    }

    /**
     * {@link MapAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new MapAsStringConverter().getValueClass()).isEqualTo(Map.class);
    }

    /**
     * {@link MapAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Map<String, String> map = new LinkedHashMap<>();
        Assertions.assertThat(new MapAsStringConverter().asString(map)).isEqualTo("<EMPTY>");

        map.put("key1", "val1");
        Assertions.assertThat(new MapAsStringConverter().asString(map)).isEqualTo("{key1=val1}");

        map.put("key2", "val2");
        map.put("key3", "val3");
        Assertions.assertThat(new MapAsStringConverter().asString(map)).isEqualTo("{key1=val1, key2=val2, key3=val3}");

        map.put("key4", "val4");
        map.put("key5", "val5");
        Assertions.assertThat(new MapAsStringConverter().asString(map)).isEqualTo("{key1=val1, key2=val2, key3=val3, key4=val4, key5=val5}");
    }

    /**
     * {@link MapAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new MapAsStringConverter().asString(null);
    }

    /**
     * {@link MapAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new MapAsStringConverter().asString(new Object());
    }

}
