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

import java.nio.ShortBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ShortBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortBufferAsStringConverter().getValueClass()).isEqualTo(ShortBuffer.class);
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}))).isEqualTo("[1s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}))).isEqualTo("[1s, 2s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}))).isEqualTo("[1s, 2s, 3s, 4s]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 1))).isEqualTo("[2s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 1))).isEqualTo("[2s, 3s, 4s]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 0, 1))).isEqualTo("[1s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 0, 1))).isEqualTo("[1s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1))).isEqualTo("[1s]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 0, 5, 5))).isEqualTo("[1s, 0s, 0s, 0s, 0s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 0, 5, 5))).isEqualTo("[1s, 2s, 0s, 0s, 0s]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5))).isEqualTo("[1s, 2s, 3s, 4s, 0s]");
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new ShortBufferAsStringConverter().asString(null);
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new ShortBufferAsStringConverter().asString(new Object());
    }

}
