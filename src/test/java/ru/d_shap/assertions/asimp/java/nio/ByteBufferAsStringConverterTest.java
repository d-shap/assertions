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

import java.nio.ByteBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ByteBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link ByteBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteBufferAsStringConverter().getValueClass()).isEqualTo(ByteBuffer.class);
    }

    /**
     * {@link ByteBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1}))).isEqualTo("[1b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2}))).isEqualTo("[1b, 2b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2, 3, 4}))).isEqualTo("[1b, 2b, 3b, 4b]");

        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2}, 1))).isEqualTo("[2b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2, 3, 4}, 1))).isEqualTo("[2b, 3b, 4b]");

        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1}, 0, 1))).isEqualTo("[1b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2}, 0, 1))).isEqualTo("[1b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1))).isEqualTo("[1b]");

        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1}, 0, 5, 5))).isEqualTo("[1b, 0b, 0b, 0b, 0b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2}, 0, 5, 5))).isEqualTo("[1b, 2b, 0b, 0b, 0b]");
        Assertions.assertThat(new ByteBufferAsStringConverter().asString(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5))).isEqualTo("[1b, 2b, 3b, 4b, 0b]");
    }

    /**
     * {@link ByteBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new ByteBufferAsStringConverter().asString(null);
    }

    /**
     * {@link ByteBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new ByteBufferAsStringConverter().asString(new Object());
    }

}
