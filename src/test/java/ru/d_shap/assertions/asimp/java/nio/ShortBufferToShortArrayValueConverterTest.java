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

import java.nio.ShortBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
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
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false), Raw.shortArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true)).isInstanceOf(short[].class);
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true), Raw.shortArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), true)).as(Raw.shortArrayAssertion()).containsExactlyInOrder();

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
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), false), Raw.shortArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{1}, 1), false)).as(Raw.shortArrayAssertion()).containsExactlyInOrder();

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
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new ShortBufferToShortArrayValueConverter().convert(null);
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new ShortBufferToShortArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws Exception {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}));
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws Exception {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), new Object(), new Object());
    }

    /**
     * {@link ShortBufferToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws Exception {
        new ShortBufferToShortArrayValueConverter().convert(createShortBuffer(new short[]{}), new Object());
    }

}
