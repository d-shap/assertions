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
 * Tests for {@link IntArrayToCharArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToCharArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToCharArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().getTargetClass()).isEqualTo(char[].class);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{}), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{})).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1}), Raw.charArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1})).as(Raw.charArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000}), Raw.intArrayAssertion()).containsExactlyInOrder(100000);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2}), Raw.charArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2})).as(Raw.charArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.charArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.charArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(int[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001}), Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.intArrayAssertion()).containsExactlyInOrder(100000, 100001);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new IntArrayToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new IntArrayToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new IntArrayToCharArrayValueConverter().convert(new int[]{}, new Object());
    }

}
