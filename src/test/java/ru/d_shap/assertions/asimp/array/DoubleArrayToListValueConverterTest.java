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
package ru.d_shap.assertions.asimp.array;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link DoubleArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleArrayToListValueConverter().getValueClass()).isEqualTo(double[].class);
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new DoubleArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{}), Raw.<Double>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{})).as(Raw.<Double>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0})).isInstanceOf(List.class);
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0}), Raw.<Double>listAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0})).as(Raw.<Double>listAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).isInstanceOf(List.class);
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0}), Raw.<Double>listAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleArrayToListValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).as(Raw.<Double>listAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new DoubleArrayToListValueConverter().convert(null);
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new DoubleArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link DoubleArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new DoubleArrayToListValueConverter().convert(new double[]{}, new Object());
    }

}
