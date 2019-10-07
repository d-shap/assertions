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
 * Tests for {@link CharArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(char[].class);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Character[].class);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'}), Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'})).as(Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'}), Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'})).as(Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new CharArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new CharArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new CharArrayToObjectArrayValueConverter().convert(new char[]{}, new Object());
    }

}
