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
 * Tests for {@link IntArrayToShortArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToShortArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToShortArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().getTargetClass()).isEqualTo(short[].class);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{}), Raw.shortArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{})).as(Raw.shortArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1}), Raw.shortArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000}), Raw.intArrayAssertion()).containsExactlyInOrder(100000);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2}), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001}), Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new IntArrayToShortArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new IntArrayToShortArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new IntArrayToShortArrayValueConverter().convert(new int[]{}, new Object());
    }

}
