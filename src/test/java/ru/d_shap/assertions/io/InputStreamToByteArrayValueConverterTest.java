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
package ru.d_shap.assertions.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

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
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), 0)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1}), 0)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2}), 0)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 0)).isTrue();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), 2)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1}), 2)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2}), 2)).isTrue();
        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}), 2)).isTrue();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(createErrorInputStream(), 0)).isTrue();

        Assertions.assertThat(new InputStreamToByteArrayValueConverter().canConvert(createErrorInputStream(), 2)).isTrue();
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(null);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}));
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), new Object(), new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), (Object) null);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
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

        try {
            Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(createErrorInputStream(), 0));
            Assertions.fail("InputStreamToByteArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new InputStreamToByteArrayValueConverter().convert(createErrorInputStream(), 2));
            Assertions.fail("InputStreamToByteArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(null);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}));
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), new Object(), new Object());
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), (Object) null);
    }

    /**
     * {@link InputStreamToByteArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new InputStreamToByteArrayValueConverter().convert(new ByteArrayInputStream(new byte[]{}), new Object());
    }

}
