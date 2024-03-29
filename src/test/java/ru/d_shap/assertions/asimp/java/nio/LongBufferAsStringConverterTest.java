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

import java.nio.LongBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link LongBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link LongBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongBufferAsStringConverter().getValueClass()).isEqualTo(LongBuffer.class);
    }

    /**
     * {@link LongBufferAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L}))).isEqualTo("[1L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L}))).isEqualTo("[1L, 2L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L}))).isEqualTo("[1L, 2L, 3L, 4L]");

        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L}, 1))).isEqualTo("[2L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1))).isEqualTo("[2L, 3L, 4L]");

        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L}, 0, 1))).isEqualTo("[1L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L}, 0, 1))).isEqualTo("[1L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1))).isEqualTo("[1L]");

        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L}, 0, 5, 5))).isEqualTo("[1L, 0L, 0L, 0L, 0L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5))).isEqualTo("[1L, 2L, 0L, 0L, 0L]");
        Assertions.assertThat(new LongBufferAsStringConverter().asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5))).isEqualTo("[1L, 2L, 3L, 4L, 0L]");
    }

    /**
     * {@link LongBufferAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new LongBufferAsStringConverter().asString(null);
    }

    /**
     * {@link LongBufferAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new LongBufferAsStringConverter().asString(new Object());
    }

}
