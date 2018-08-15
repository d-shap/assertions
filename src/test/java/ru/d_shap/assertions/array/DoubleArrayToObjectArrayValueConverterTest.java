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
 * Tests for {@link DoubleArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(double[].class);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Double[].class);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().canConvert(new double[0])).isTrue();
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().canConvert(new double[]{1.0, 2.0})).isTrue();
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().canConvert(new double[]{1.0, 2.0, 3.0, 4.0})).isTrue();
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().canConvert(new double[0], new Object());
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{}), Raw.objectArrayAssertion()).isEmpty();
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{})).as(Raw.objectArrayAssertion()).isEmpty();

        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new DoubleArrayToObjectArrayValueConverter().convert(new double[0], new Object());
    }

}
