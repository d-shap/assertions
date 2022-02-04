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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntArrayToByteArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToByteArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToByteArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().getTargetClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{}), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{})).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1}), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000}), Raw.intArrayAssertion()).containsExactlyInOrder(100000);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2}), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(byte[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001}), Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
        Assertions.assertThat(new IntArrayToByteArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IntArrayToByteArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IntArrayToByteArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToByteArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new IntArrayToByteArrayValueConverter().convert(new int[]{}, new Object());
    }

}
