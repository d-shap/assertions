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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.util.DataHelper;

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
     */
    @Test
    public void convertTest() {
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

        new ReaderToCharArrayValueConverter().convert(DataHelper.createReaderBuilder().setReadException("read exception").buildReader(), -1);
        try {
            new ReaderToCharArrayValueConverter().convert(DataHelper.createReaderBuilder().setReadException("read exception").buildReader(), 0);
            Assertions.fail(ReaderToCharArrayValueConverter.class);
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
        try {
            new ReaderToCharArrayValueConverter().convert(DataHelper.createReaderBuilder().setReadException("read exception").buildReader(), 2);
            Assertions.fail(ReaderToCharArrayValueConverter.class);
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ReaderToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ReaderToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""));
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object(), new Object());
    }

    /**
     * {@link ReaderToCharArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType1FailTest() {
        new ReaderToCharArrayValueConverter().convert(new StringReader(""), new Object());
    }

}
