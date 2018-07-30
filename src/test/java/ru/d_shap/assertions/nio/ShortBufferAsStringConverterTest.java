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
package ru.d_shap.assertions.nio;

import java.nio.ShortBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;

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
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConvertionException {
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{}))).isEqualTo("[]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}))).isEqualTo("[1]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}))).isEqualTo("[1, 2]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}))).isEqualTo("[1, 2, 3, 4]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 1))).isEqualTo("[]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 1))).isEqualTo("[2]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 1))).isEqualTo("[2, 3, 4]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 0, 1))).isEqualTo("[1]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 0, 1))).isEqualTo("[1]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1))).isEqualTo("[1]");

        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1}, 0, 5, 5))).isEqualTo("[1, 0, 0, 0, 0]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2}, 0, 5, 5))).isEqualTo("[1, 2, 0, 0, 0]");
        Assertions.assertThat(new ShortBufferAsStringConverter().asString(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5))).isEqualTo("[1, 2, 3, 4, 0]");
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws ConvertionException {
        new ShortBufferAsStringConverter().asString(null);
    }

    /**
     * {@link ShortBufferAsStringConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws ConvertionException {
        new ShortBufferAsStringConverter().asString(new Object());
    }

}