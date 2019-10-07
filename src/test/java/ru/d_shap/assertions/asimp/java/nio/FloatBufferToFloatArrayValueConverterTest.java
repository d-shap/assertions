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

import java.nio.FloatBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatBufferToFloatArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferToFloatArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferToFloatArrayValueConverterTest() {
        super();
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().getValueClass()).isEqualTo(FloatBuffer.class);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().getTargetClass()).isEqualTo(float[].class);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new FloatBufferToFloatArrayValueConverter().convert(null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new FloatBufferToFloatArrayValueConverter().convert(new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws Exception {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}));
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws Exception {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object(), new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws Exception {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object());
    }

}
