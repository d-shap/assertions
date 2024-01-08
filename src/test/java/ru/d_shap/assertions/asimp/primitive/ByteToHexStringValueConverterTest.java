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
import ru.d_shap.assertions.asimp.HexString;

/**
 * Tests for {@link ByteToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteToHexStringValueConverter().getValueClass()).isEqualTo(Byte.class);
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 0), Raw.charSequenceAssertion()).isEqualTo("00");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 0)).as(Raw.charSequenceAssertion()).isEqualTo("00");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 1), Raw.charSequenceAssertion()).isEqualTo("01");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 1)).as(Raw.charSequenceAssertion()).isEqualTo("01");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 31)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 31), Raw.charSequenceAssertion()).isEqualTo("1f");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 31)).as(Raw.charSequenceAssertion()).isEqualTo("1f");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 100)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 100), Raw.charSequenceAssertion()).isEqualTo("64");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 100)).as(Raw.charSequenceAssertion()).isEqualTo("64");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MAX_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7f");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7f");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 255)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 255), Raw.charSequenceAssertion()).isEqualTo("ff");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) 255)).as(Raw.charSequenceAssertion()).isEqualTo("ff");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) -100)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) -100), Raw.charSequenceAssertion()).isEqualTo("9c");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert((byte) -100)).as(Raw.charSequenceAssertion()).isEqualTo("9c");

        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MIN_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("80");
        Assertions.assertThat(new ByteToHexStringValueConverter().convert(Byte.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("80");
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ByteToHexStringValueConverter().convert(null);
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ByteToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link ByteToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new ByteToHexStringValueConverter().convert((byte) 0, new Object());
    }

}
