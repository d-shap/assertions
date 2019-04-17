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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(float[].class);
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Float[].class);
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{})).isInstanceOf(Float[].class);
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f})).isInstanceOf(Float[].class);
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).isInstanceOf(Float[].class);
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), Raw.objectArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatArrayToObjectArrayValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new FloatArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new FloatArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link FloatArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new FloatArrayToObjectArrayValueConverter().convert(new float[]{}, new Object());
    }

}
