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

import java.nio.LongBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongBufferToLongArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferToLongArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferToLongArrayValueConverterTest() {
        super();
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().getValueClass()).isEqualTo(LongBuffer.class);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().getTargetClass()).isEqualTo(long[].class);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}), false)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}), true)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), false)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), true)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 1), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 1), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), false)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 1), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 1), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), true)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 0, 1), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 0, 1), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), false)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 0, 1), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 0, 1), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), true)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), false)).isTrue();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), true)).isTrue();
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(null);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}));
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}), new Object(), new Object());
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}), (Object) null);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().canConvert(createLongBuffer(new long[]{}), new Object());
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), false), Raw.longArrayAssertion()).isEmpty();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), false)).as(Raw.longArrayAssertion()).isEmpty();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), true), Raw.longArrayAssertion()).isEmpty();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), true)).as(Raw.longArrayAssertion()).isEmpty();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), false), Raw.longArrayAssertion()).isEmpty();
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), false)).as(Raw.longArrayAssertion()).isEmpty();

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), false), Raw.longArrayAssertion()).containsExactlyInOrder(2L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(2L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), false), Raw.longArrayAssertion()).containsExactlyInOrder(2L, 3L, 4L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(2L, 3L, 4L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 1), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 0L, 0L, 0L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 0L, 0L, 0L, 0L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 0L, 0L, 0L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L}, 0, 5, 5), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 0L, 0L, 0L, 0L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 0L, 0L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 0L, 0L, 0L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 0L, 0L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L}, 0, 5, 5), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 0L, 0L, 0L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), false)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), false), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), false)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L, 0L);

        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), true)).isInstanceOf(long[].class);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), true), Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L, 0L);
        Assertions.assertThat(new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{1L, 2L, 3L, 4L}, 0, 5, 5), true)).as(Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L, 0L);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(null);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(new Object());
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}));
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), new Object(), new Object());
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), (Object) null);
    }

    /**
     * {@link LongBufferToLongArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new LongBufferToLongArrayValueConverter().convert(createLongBuffer(new long[]{}), new Object());
    }

}
