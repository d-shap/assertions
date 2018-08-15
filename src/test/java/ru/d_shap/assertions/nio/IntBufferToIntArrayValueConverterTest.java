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

import java.nio.IntBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntBufferToIntArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferToIntArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntBufferToIntArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().getValueClass()).isEqualTo(IntBuffer.class);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().getTargetClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}), false)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}), true)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}), false)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}), true)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 1), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 1), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), false)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 1), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 1), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), true)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 0, 1), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 0, 1), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), false)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 0, 1), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 0, 1), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), true)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), false)).isTrue();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), true)).isTrue();
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(null);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}));
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}), new Object(), new Object());
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}), (Object) null);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().canConvert(createIntBuffer(new int[]{}), new Object());
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), false), Raw.intArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), false)).as(Raw.intArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), true), Raw.intArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), true)).as(Raw.intArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), false), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), true), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), false), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), false), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), false), Raw.intArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), false)).as(Raw.intArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), false), Raw.intArrayAssertion()).containsExactlyInOrder(2);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(2);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), false), Raw.intArrayAssertion()).containsExactlyInOrder(2, 3, 4);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(2, 3, 4);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), false), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), false), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), false), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), true), Raw.intArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 1), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), false), Raw.intArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1}, 0, 5, 5), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), false), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2}, 0, 5, 5), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), false)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), false), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), false)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);

        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), true)).isInstanceOf(int[].class);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), true), Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{1, 2, 3, 4}, 0, 5, 5), true)).as(Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(null);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}));
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), new Object(), new Object());
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), (Object) null);
    }

    /**
     * {@link IntBufferToIntArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new IntBufferToIntArrayValueConverter().convert(createIntBuffer(new int[]{}), new Object());
    }

}
