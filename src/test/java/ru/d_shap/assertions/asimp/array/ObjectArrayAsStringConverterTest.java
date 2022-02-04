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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ObjectArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectArrayAsStringConverterTest() {
        super();
    }

    /**
     * {@link ObjectArrayAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ObjectArrayAsStringConverter().getValueClass()).isEqualTo(Object[].class);
    }

    /**
     * {@link ObjectArrayAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ObjectArrayAsStringConverter().asString(new String[]{})).isEqualTo("<EMPTY>");
        Assertions.assertThat(new ObjectArrayAsStringConverter().asString(new String[]{"val1"})).isEqualTo("[val1]");
        Assertions.assertThat(new ObjectArrayAsStringConverter().asString(new String[]{"val1", "val2"})).isEqualTo("[val1, val2]");
        Assertions.assertThat(new ObjectArrayAsStringConverter().asString(new String[]{"val1", "val2", "val3", "val4"})).isEqualTo("[val1, val2, val3, val4]");
    }

    /**
     * {@link ObjectArrayAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new ObjectArrayAsStringConverter().asString(null);
    }

    /**
     * {@link ObjectArrayAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new ObjectArrayAsStringConverter().asString(new Object());
    }

}
