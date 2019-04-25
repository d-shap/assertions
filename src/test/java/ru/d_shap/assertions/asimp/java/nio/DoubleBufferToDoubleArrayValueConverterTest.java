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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.DoubleBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleBufferToDoubleArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferToDoubleArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleBufferToDoubleArrayValueConverterTest() {
        super();
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().getValueClass()).isEqualTo(DoubleBuffer.class);
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().getTargetClass()).isEqualTo(double[].class);
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), false), Raw.doubleArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), true), Raw.doubleArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(2.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(2.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(2.0, 3.0, 4.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 0.0, 0.0, 0.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 0.0, 0.0, 0.0, 0.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 0.0, 0.0, 0.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0}, 0, 5, 5), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 0.0, 0.0, 0.0, 0.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 0.0, 0.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 0.0, 0.0, 0.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 0.0, 0.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 0.0, 0.0, 0.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), false)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), false), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), false)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 0.0);

        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), true)).isInstanceOf(double[].class);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), true), Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 0.0);
        Assertions.assertThat(new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5), true)).as(Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 0.0);
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new DoubleBufferToDoubleArrayValueConverter().convert(null);
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new DoubleBufferToDoubleArrayValueConverter().convert(new Object());
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws Exception {
        new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}));
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws Exception {
        new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), new Object(), new Object());
    }

    /**
     * {@link DoubleBufferToDoubleArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws Exception {
        new DoubleBufferToDoubleArrayValueConverter().convert(createDoubleBuffer(new double[]{}), new Object());
    }

}
