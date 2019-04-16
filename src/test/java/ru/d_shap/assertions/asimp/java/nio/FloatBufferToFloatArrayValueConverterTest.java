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

import java.nio.FloatBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

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
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{})), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}))).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f})), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f})), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 1), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f}, 0, 5, 5), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), false)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 5, 5), true)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 0.0f, 0.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5))).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5)), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5))).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);

        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), (Object) null)).isInstanceOf(float[].class);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), (Object) null), Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);
        Assertions.assertThat(new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, 0, 5, 5), (Object) null)).as(Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 0.0f);

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
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new FloatBufferToFloatArrayValueConverter().convert(null);
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new FloatBufferToFloatArrayValueConverter().convert(new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object(), new Object());
    }

    /**
     * {@link FloatBufferToFloatArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new FloatBufferToFloatArrayValueConverter().convert(createFloatBuffer(new float[]{}), new Object());
    }

}
