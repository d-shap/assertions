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

import java.nio.ShortBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortBufferToShortArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferToShortArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferToShortArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().getValueClass()).isEqualTo(ShortBuffer.class);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().getTargetClass()).isEqualTo(short[].class);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}), false)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}), true)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}), false)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}), true)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 1), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 1), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), false)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 1), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 1), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), true)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 0, 1), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 0, 1), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), false)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 0, 1), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 0, 1), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), true)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), false)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), false)).isTrue();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), true)).isTrue();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), true)).isTrue();
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(null);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}));
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}), new Object(), new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}), (Object) null);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().canConvert(createShortBuffer(new short[]{}), new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false), Raw.shortArrayAssertion()).isEmpty();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false)).as(Raw.shortArrayAssertion()).isEmpty();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true), Raw.shortArrayAssertion()).isEmpty();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true)).as(Raw.shortArrayAssertion()).isEmpty();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), false), Raw.shortArrayAssertion()).isEmpty();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), false)).as(Raw.shortArrayAssertion()).isEmpty();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder(2);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(2);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder(2, 3, 4);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(2, 3, 4);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 1), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 0, 5, 5), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2}, 0, 5, 5), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), false), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), true), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1, 2, 3, 4}, 0, 5, 5), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(null);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}));
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), new Object(), new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), (Object) null);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), new Object());
    }

}
