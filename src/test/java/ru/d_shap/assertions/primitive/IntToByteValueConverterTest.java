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
package ru.d_shap.assertions.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntToByteValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToByteValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToByteValueConverterTest() {
        super();
    }

    /**
     * {@link IntToByteValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToByteValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToByteValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToByteValueConverter().getTargetClass()).isEqualTo(Byte.class);
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new IntToByteValueConverter().canConvert(0)).isTrue();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(100)).isTrue();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(127)).isTrue();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(128)).isFalse();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(-100)).isTrue();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(-128)).isTrue();
        Assertions.assertThat(new IntToByteValueConverter().canConvert(-129)).isFalse();
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new IntToByteValueConverter().canConvert(null);
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new IntToByteValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new IntToByteValueConverter().canConvert(0, new Object());
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new IntToByteValueConverter().convert(0)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(0), Raw.byteAssertion()).isEqualTo(0);
        Assertions.assertThat(new IntToByteValueConverter().convert(0)).as(Raw.byteAssertion()).isEqualTo(0);

        Assertions.assertThat(new IntToByteValueConverter().convert(100)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(100), Raw.byteAssertion()).isEqualTo(100);
        Assertions.assertThat(new IntToByteValueConverter().convert(100)).as(Raw.byteAssertion()).isEqualTo(100);

        Assertions.assertThat(new IntToByteValueConverter().convert(127)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(127), Raw.byteAssertion()).isEqualTo(127);
        Assertions.assertThat(new IntToByteValueConverter().convert(127)).as(Raw.byteAssertion()).isEqualTo(127);

        Assertions.assertThat(new IntToByteValueConverter().convert(128)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(128), Raw.byteAssertion()).isEqualTo(-128);
        Assertions.assertThat(new IntToByteValueConverter().convert(128)).as(Raw.byteAssertion()).isEqualTo(-128);

        Assertions.assertThat(new IntToByteValueConverter().convert(-100)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(-100), Raw.byteAssertion()).isEqualTo(-100);
        Assertions.assertThat(new IntToByteValueConverter().convert(-100)).as(Raw.byteAssertion()).isEqualTo(-100);

        Assertions.assertThat(new IntToByteValueConverter().convert(-128)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(-128), Raw.byteAssertion()).isEqualTo(-128);
        Assertions.assertThat(new IntToByteValueConverter().convert(-128)).as(Raw.byteAssertion()).isEqualTo(-128);

        Assertions.assertThat(new IntToByteValueConverter().convert(-129)).isInstanceOf(Byte.class);
        Assertions.assertThat(new IntToByteValueConverter().convert(-129), Raw.byteAssertion()).isEqualTo(127);
        Assertions.assertThat(new IntToByteValueConverter().convert(-129)).as(Raw.byteAssertion()).isEqualTo(127);
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new IntToByteValueConverter().convert(null);
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new IntToByteValueConverter().convert(new Object());
    }

    /**
     * {@link IntToByteValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new IntToByteValueConverter().convert(0, new Object());
    }

}
