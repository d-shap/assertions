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
package ru.d_shap.assertions.nio;

import java.nio.FloatBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
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
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}), false)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}), true)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 1), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 1), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 0, 1), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 0, 1), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), false)).isTrue();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), true)).isTrue();
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}));
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}), new Object(), new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}), (Object) null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().canConvert(createFloatBuffer(new float[]{}), new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false), Raw.floatArrayAssertion()).isEmpty();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).as(Raw.floatArrayAssertion()).isEmpty();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true), Raw.floatArrayAssertion()).isEmpty();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).as(Raw.floatArrayAssertion()).isEmpty();

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
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false), Raw.floatArrayAssertion()).isEmpty();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false)).as(Raw.floatArrayAssertion()).isEmpty();

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
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}));
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object(), new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), (Object) null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConvertionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object());
    }

}
