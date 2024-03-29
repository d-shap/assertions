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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.FloatBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link FloatBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link FloatBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatBufferAsStringConverter().getValueClass()).isEqualTo(FloatBuffer.class);
    }

    /**
     * {@link FloatBufferAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f}))).isEqualTo("[1.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f}))).isEqualTo("[1.0f, 2.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}))).isEqualTo("[1.0f, 2.0f, 3.0f, 4.0f]");

        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f}, 1))).isEqualTo("[2.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1))).isEqualTo("[2.0f, 3.0f, 4.0f]");

        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f}, 0, 1))).isEqualTo("[1.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1))).isEqualTo("[1.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1))).isEqualTo("[1.0f]");

        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f}, 0, 5, 5))).isEqualTo("[1.0f, 0.0f, 0.0f, 0.0f, 0.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5))).isEqualTo("[1.0f, 2.0f, 0.0f, 0.0f, 0.0f]");
        Assertions.assertThat(new FloatBufferAsStringConverter().asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5))).isEqualTo("[1.0f, 2.0f, 3.0f, 4.0f, 0.0f]");
    }

    /**
     * {@link FloatBufferAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new FloatBufferAsStringConverter().asString(null);
    }

    /**
     * {@link FloatBufferAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new FloatBufferAsStringConverter().asString(new Object());
    }

}
