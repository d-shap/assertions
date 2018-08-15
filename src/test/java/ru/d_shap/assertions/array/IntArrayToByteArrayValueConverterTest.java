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
package ru.d_shap.assertions.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntArrayToByteArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToByteArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToByteArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().getTargetClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().canConvert(new int[]{})).isTrue();
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().canConvert(new int[]{1, 2})).isTrue();
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().canConvert(new int[]{1, 2, 3, 4})).isTrue();
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().canConvert(new int[]{100000, 100001})).isFalse();
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().canConvert(null);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().canConvert(new int[]{}, new Object());
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{}), Raw.byteArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{})).as(Raw.byteArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2}), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001}), Raw.byteArrayAssertion()).containsExactlyInOrder(-96, -95);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(-96, -95);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new IntArrayToByteArrayValueConverter().convert(new int[]{}, new Object());
    }

}
