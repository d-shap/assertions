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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteToStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteToStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteToStringValueConverterTest() {
        super();
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteToStringValueConverter().getValueClass()).isEqualTo(Byte.class);
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteToStringValueConverter().getTargetClass()).isEqualTo(String.class);
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("127");
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("127");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, false), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, false)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, false), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, false)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, false), Raw.charSequenceAssertion()).isEqualTo("127");
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, false)).as(Raw.charSequenceAssertion()).isEqualTo("127");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, true), Raw.charSequenceAssertion()).isEqualTo("00");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0, true)).as(Raw.charSequenceAssertion()).isEqualTo("00");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1, true), Raw.charSequenceAssertion()).isEqualTo("01");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1, true)).as(Raw.charSequenceAssertion()).isEqualTo("01");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31, true), Raw.charSequenceAssertion()).isEqualTo("1f");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31, true)).as(Raw.charSequenceAssertion()).isEqualTo("1f");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, true), Raw.charSequenceAssertion()).isEqualTo("64");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100, true)).as(Raw.charSequenceAssertion()).isEqualTo("64");

        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("7f");
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MAX_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("7f");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255, true), Raw.charSequenceAssertion()).isEqualTo("ff");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255, true)).as(Raw.charSequenceAssertion()).isEqualTo("ff");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100, true), Raw.charSequenceAssertion()).isEqualTo("9c");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100, true)).as(Raw.charSequenceAssertion()).isEqualTo("9c");

        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MIN_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MIN_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("80");
        Assertions.assertThat(new ByteToStringValueConverter().convert(Byte.MIN_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("80");
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ByteToStringValueConverter().convert(null);
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ByteToStringValueConverter().convert(new Object());
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new ByteToStringValueConverter().convert((byte) 0);
    }

    /**
     * {@link ByteToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new ByteToStringValueConverter().convert((byte) 0, new Object(), new Object());
    }

}
