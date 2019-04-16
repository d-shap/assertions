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
package ru.d_shap.assertions.asimp.java.io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

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
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""))).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("")), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""))).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"))).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1")), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"))).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12")), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"))).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234")), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), -1)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), -1), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), -1)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), -1)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), -1), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1"), -1)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), -1)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), -1), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("12"), -1)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), -1)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), -1), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader("1234"), -1)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0)).isInstanceOf(char[].class);
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 0)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

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
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 2), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(new StringReader(""), 2)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

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
            Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(createErrorReader()));
            Assertions.fail("ReaderToCharArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(createErrorReader(), 0));
            Assertions.fail("ReaderToCharArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new ReaderToCharArrayValueConverter().convert(createErrorReader(), 2));
            Assertions.fail("ReaderToCharArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new ReaderToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new ReaderToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object(), new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object());
    }

}
