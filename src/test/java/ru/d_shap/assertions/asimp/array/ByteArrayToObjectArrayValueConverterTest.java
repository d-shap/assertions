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
 * Tests for {@link ByteArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Byte[].class);
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{})).isInstanceOf(Byte[].class);
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2})).isInstanceOf(Byte[].class);
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2}), Raw.objectArrayAssertion()).containsExactlyInOrder((byte) 1, (byte) 2);
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2})).as(Raw.objectArrayAssertion()).containsExactlyInOrder((byte) 1, (byte) 2);

        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2, 3, 4})).isInstanceOf(Byte[].class);
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2, 3, 4}), Raw.objectArrayAssertion()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Assertions.assertThat(new ByteArrayToObjectArrayValueConverter().convert(new byte[]{1, 2, 3, 4})).as(Raw.objectArrayAssertion()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new ByteArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new ByteArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ByteArrayToObjectArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new ByteArrayToObjectArrayValueConverter().convert(new byte[]{}, new Object());
    }

}
