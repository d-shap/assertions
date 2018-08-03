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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ReaderToCharArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReaderToCharArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReaderToCharArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ReaderToCharArrayValueConverter().getValueClass()).isEqualTo(Reader.class);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ReaderToCharArrayValueConverter().getTargetClass()).isEqualTo(char[].class);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader(""), 0)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("1"), 0)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("12"), 0)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("1234"), 0)).isTrue();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader(""), 2)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("1"), 2)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("12"), 2)).isTrue();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(new StringReader("1234"), 2)).isTrue();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(createErrorReader(), 0)).isTrue();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().canConvert(createErrorReader(), 2)).isTrue();
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount0FailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(new StringReader(""));
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCount2FailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(new StringReader(""), new Object(), new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullArgumentFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(new StringReader(""), (Object) null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongArgumentTypeFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().canConvert(new StringReader(""), new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0), Raw.charArrayAssertion()).isEmpty();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0)).as(Raw.charArrayAssertion()).isEmpty();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 0)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 0), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 0)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 0)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 0), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 0)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 0)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 0), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 0)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 2)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 2), Raw.charArrayAssertion()).isEmpty();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 2)).as(Raw.charArrayAssertion()).isEmpty();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 2)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 2), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), 2)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 2)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 2), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), 2)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 2)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 2), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), 2)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        try {
            Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(createErrorReader(), 0));
            Assertions.fail("ReaderToCharArrayValueConverter test fail");
        } catch (ConvertionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(createErrorReader(), 2));
            Assertions.fail("ReaderToCharArrayValueConverter test fail");
        } catch (ConvertionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""));
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object(), new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), (Object) null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConvertionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object());
    }

}
