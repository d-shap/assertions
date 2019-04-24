///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link AsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class AsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public AsStringConverterTest() {
        super();
    }

    /**
     * {@link AsStringConverter} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(AsStringConverter.class).hasOnePrivateConstructor();
    }

    /**
     * {@link AsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(AsStringConverter.asString(null)).isEqualTo("<NULL>");

        Assertions.assertThat(AsStringConverter.asString(1)).isEqualTo("1");
        Assertions.assertThat(AsStringConverter.asString('1')).isEqualTo("1(49)");
        Assertions.assertThat(AsStringConverter.asString(true)).isEqualTo("T");
        Assertions.assertThat(AsStringConverter.asString("value")).isEqualTo("value");
        Assertions.assertThat(AsStringConverter.asString(Arrays.asList("value1", "value2", "value3"))).isEqualTo("[value1, value2, value3]");
        Assertions.assertThat(AsStringConverter.asString(createHashSet(String.class, Object.class))).isEqualTo("[java.lang.String, java.lang.Object]");
        Assertions.assertThat(AsStringConverter.asString(createHashMap('1', Arrays.asList('1', '2', '3'), '2', Arrays.asList("val1", "val2", "val3")))).isEqualTo("{1(49)=[1(49), 2(50), 3(51)], 2(50)=[val1, val2, val3]}");
    }

    /**
     * {@link AsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringValueConverterTest() throws Exception {
        Assertions.assertThat(AsStringConverter.asString(null, String.class)).isEqualTo("<NULL>");

        Assertions.assertThat(AsStringConverter.asString(100, Character.class)).isEqualTo("d(100)");
        Assertions.assertThat(AsStringConverter.asString(100, Integer.class)).isEqualTo("100");
        Assertions.assertThat(AsStringConverter.asString(100000, Character.class)).isEqualTo("100000");
        Assertions.assertThat(AsStringConverter.asString(100000, Integer.class)).isEqualTo("100000");

        Assertions.assertThat(AsStringConverter.asString(createIterator(1, 2, 3, 4, 5), List.class, 5)).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(AsStringConverter.asString(createIterator(1, 2, 3, 4, 5), List.class, 4)).isEqualTo("[1, 2, 3, 4]");
        Assertions.assertThat(AsStringConverter.asString(createIterator(1, 2, 3, 4, 5), List.class, 3)).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(AsStringConverter.asString(createIterator(1, 2, 3, 4, 5), List.class, 2)).isEqualTo("[1, 2]");
        Assertions.assertThat(AsStringConverter.asString(createIterator(1, 2, 3, 4, 5), List.class, 1)).isEqualTo("[1]");

        Assertions.assertThat(AsStringConverter.asString(Arrays.asList(1, 2, 3, 4, 5), Map.class)).isEqualTo("[1, 2, 3, 4, 5]");
    }

}
