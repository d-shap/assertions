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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.CharBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link CharBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link CharBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharBufferAsStringConverter().getValueClass()).isEqualTo(CharBuffer.class);
    }

    /**
     * {@link CharBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1'}))).isEqualTo("[1(49)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2'}))).isEqualTo("[1(49), 2(50)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2', '3', '4'}))).isEqualTo("[1(49), 2(50), 3(51), 4(52)]");

        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1'}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2'}, 1))).isEqualTo("[2(50)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1))).isEqualTo("[2(50), 3(51), 4(52)]");

        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1'}, 0, 1))).isEqualTo("[1(49)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2'}, 0, 1))).isEqualTo("[1(49)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1))).isEqualTo("[1(49)]");

        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1'}, 0, 5, 5))).isEqualTo("[1(49),  (0),  (0),  (0),  (0)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5))).isEqualTo("[1(49), 2(50),  (0),  (0),  (0)]");
        Assertions.assertThat(new CharBufferAsStringConverter().asString(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5))).isEqualTo("[1(49), 2(50), 3(51), 4(52),  (0)]");
    }

    /**
     * {@link CharBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new CharBufferAsStringConverter().asString(null);
    }

    /**
     * {@link CharBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new CharBufferAsStringConverter().asString(new Object());
    }

}
