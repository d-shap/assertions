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
 * Tests for {@link ShortArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(short[].class);
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Short[].class);
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().canConvert(new short[]{})).isTrue();
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().canConvert(new short[]{1, 2})).isTrue();
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().canConvert(new short[]{1, 2, 3, 4})).isTrue();
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().canConvert(new short[]{}, new Object());
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{})).isInstanceOf(Short[].class);
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2})).isInstanceOf(Short[].class);
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2}), Raw.objectArrayAssertion()).containsExactlyInOrder((short) 1, (short) 2);
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2})).as(Raw.objectArrayAssertion()).containsExactlyInOrder((short) 1, (short) 2);

        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2, 3, 4})).isInstanceOf(Short[].class);
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2, 3, 4}), Raw.objectArrayAssertion()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        Assertions.assertThat(new ShortArrayToObjectArrayValueConverter().convert(new short[]{1, 2, 3, 4})).as(Raw.objectArrayAssertion()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ShortArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new ShortArrayToObjectArrayValueConverter().convert(new short[]{}, new Object());
    }

}
