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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
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
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).isInstanceOf(Double[].class);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleArrayToObjectArrayValueConverter().convert(new double[]{1.0, 2.0, 3.0, 4.0})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new DoubleArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new DoubleArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link DoubleArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new DoubleArrayToObjectArrayValueConverter().convert(new double[]{}, new Object());
    }

}
