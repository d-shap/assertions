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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link FloatArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAsStringConverterTest() {
        super();
    }

    /**
     * {@link FloatArrayAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatArrayAsStringConverter().getValueClass()).isEqualTo(float[].class);
    }

    /**
     * {@link FloatArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new FloatArrayAsStringConverter().asString(new float[]{})).isEqualTo("[]");
        Assertions.assertThat(new FloatArrayAsStringConverter().asString(new float[]{1.0f})).isEqualTo("[1.0f]");
        Assertions.assertThat(new FloatArrayAsStringConverter().asString(new float[]{1.0f, 2.0f})).isEqualTo("[1.0f, 2.0f]");
        Assertions.assertThat(new FloatArrayAsStringConverter().asString(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).isEqualTo("[1.0f, 2.0f, 3.0f, 4.0f]");
    }

    /**
     * {@link FloatArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new FloatArrayAsStringConverter().asString(null);
    }

    /**
     * {@link FloatArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new FloatArrayAsStringConverter().asString(new Object());
    }

}
