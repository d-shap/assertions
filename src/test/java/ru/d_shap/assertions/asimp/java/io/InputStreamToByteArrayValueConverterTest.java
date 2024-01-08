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
package ru.d_shap.assertions.asimp.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link InputStreamToByteArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamToByteArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public InputStreamToByteArrayValueConverterTest() {
        super();
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().getValueClass()).isEqualTo(InputStream.class);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().getTargetClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), -1)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), -1), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), -1)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), -1)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), -1), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), -1)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), -1)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), -1), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), -1)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), -1)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), -1), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), -1)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 0)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 0), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 0)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 0)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 0), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 0)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 0)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 0), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 0)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 0)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 0), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 0)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 2)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 2), Raw.byteArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), 2)).as(Raw.byteArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 2)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 2), Raw.byteArrayAssertion()).containsExactlyInOrder(1);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1}), 2)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 2)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 2), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}), 2)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 2)).isInstanceOf(byte[].class);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 2), Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 2)).as(Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2);

        new InputStreamToByteArrayValueConverter().convert(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), -1);
        try {
            new InputStreamToByteArrayValueConverter().convert(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), 0);
            Assertions.fail(InputStreamToByteArrayValueConverter.class);
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
        try {
            new InputStreamToByteArrayValueConverter().convert(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), 2);
            Assertions.fail(InputStreamToByteArrayValueConverter.class);
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new InputStreamToByteArrayValueConverter().convert(null);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new InputStreamToByteArrayValueConverter().convert(new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}));
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), new Object(), new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType1FailTest() {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), new Object());
    }

}
