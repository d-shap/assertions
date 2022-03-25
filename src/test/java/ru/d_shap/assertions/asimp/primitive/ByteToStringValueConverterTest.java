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
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0), Raw.charSequenceAssertion()).isEqualTo("00");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 0)).as(Raw.charSequenceAssertion()).isEqualTo("00");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1), Raw.charSequenceAssertion()).isEqualTo("01");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 1)).as(Raw.charSequenceAssertion()).isEqualTo("01");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31), Raw.charSequenceAssertion()).isEqualTo("1f");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 31)).as(Raw.charSequenceAssertion()).isEqualTo("1f");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100), Raw.charSequenceAssertion()).isEqualTo("64");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 100)).as(Raw.charSequenceAssertion()).isEqualTo("64");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 127)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 127), Raw.charSequenceAssertion()).isEqualTo("7f");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 127)).as(Raw.charSequenceAssertion()).isEqualTo("7f");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255), Raw.charSequenceAssertion()).isEqualTo("ff");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) 255)).as(Raw.charSequenceAssertion()).isEqualTo("ff");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100), Raw.charSequenceAssertion()).isEqualTo("9c");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -100)).as(Raw.charSequenceAssertion()).isEqualTo("9c");

        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -128)).isInstanceOf(String.class);
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -128), Raw.charSequenceAssertion()).isEqualTo("80");
        Assertions.assertThat(new ByteToStringValueConverter().convert((byte) -128)).as(Raw.charSequenceAssertion()).isEqualTo("80");
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
    public void convertWrongArgumentCountFailTest() {
        new ByteToStringValueConverter().convert((byte) 0, new Object());
    }

}
