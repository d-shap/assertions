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
package ru.d_shap.assertions.asimp.java.lang;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IterableAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IterableAsStringConverterTest() {
        super();
    }

    /**
     * {@link IterableAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IterableAsStringConverter().getValueClass()).isEqualTo(Iterable.class);
    }

    /**
     * {@link IterableAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IterableAsStringConverter().asString(createIterable())).isEqualTo("<EMPTY>");
        Assertions.assertThat(new IterableAsStringConverter().asString(createIterable(""))).isEqualTo("[]");
        Assertions.assertThat(new IterableAsStringConverter().asString(createIterable("val1"))).isEqualTo("[val1]");
        Assertions.assertThat(new IterableAsStringConverter().asString(createIterable("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new IterableAsStringConverter().asString(createIterable("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

    /**
     * {@link IterableAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new IterableAsStringConverter().asString(null);
    }

    /**
     * {@link IterableAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new IterableAsStringConverter().asString(new Object());
    }

}
