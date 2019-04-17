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

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteArrayToListValueConverter().getValueClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{}), Raw.<Byte>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{})).as(Raw.<Byte>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2})).isInstanceOf(List.class);
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2}), Raw.<Byte>listAssertion()).containsExactlyInOrder((byte) 1, (byte) 2);
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2})).as(Raw.<Byte>listAssertion()).containsExactlyInOrder((byte) 1, (byte) 2);

        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2, 3, 4})).isInstanceOf(List.class);
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2, 3, 4}), Raw.<Byte>listAssertion()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Assertions.assertThat(new ByteArrayToListValueConverter().convert(new byte[]{1, 2, 3, 4})).as(Raw.<Byte>listAssertion()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new ByteArrayToListValueConverter().convert(null);
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new ByteArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link ByteArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new ByteArrayToListValueConverter().convert(new byte[]{}, new Object());
    }

}
