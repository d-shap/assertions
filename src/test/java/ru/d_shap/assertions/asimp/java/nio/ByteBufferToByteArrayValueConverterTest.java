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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link ByteBufferToByteArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferToByteArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferToByteArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().getValueClass()).isEqualTo(ByteBuffer.class);
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().getTargetClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{})), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}))).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), false), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), true), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1})), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2})), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4})), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder(2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder(2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1)), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 1), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5)), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1}, 0, 5, 5), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 0, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5)), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2}, 0, 5, 5), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 0, 0, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5))).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5)), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5))).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), (Object) null)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), (Object) null), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), (Object) null)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), false)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), false), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), false)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);

        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), true)).isInstanceOf(byte[].class);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), true), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
        Assertions.assertThat(new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{1, 2, 3, 4}, 0, 5, 5), true)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4, 0);
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new ByteBufferToByteArrayValueConverter().convert(null);
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new ByteBufferToByteArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), new Object(), new Object());
    }

    /**
     * {@link ByteBufferToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new ByteBufferToByteArrayValueConverter().convert(createByteBuffer(new byte[]{}), new Object());
    }

}
