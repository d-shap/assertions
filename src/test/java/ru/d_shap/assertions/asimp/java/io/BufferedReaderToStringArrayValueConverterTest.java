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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link BufferedReaderToStringArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BufferedReaderToStringArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BufferedReaderToStringArrayValueConverterTest() {
        super();
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().getValueClass()).isEqualTo(BufferedReader.class);
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().getTargetClass()).isEqualTo(String[].class);
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")))).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader(""))), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")))).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")))).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1"))), Raw.objectArrayAssertion()).containsExactlyInOrder("1");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")))).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")))).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2"))), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")))).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")))).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4"))), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")))).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")))).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n"))), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")))).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 0)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 0), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 0)).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 0)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 0), Raw.objectArrayAssertion()).containsExactlyInOrder("1");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 0)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 0)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 0), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 0)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 0)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 0), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 0)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 0)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 0), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 0)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3", "4");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 2)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 2), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), 2)).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 2)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 2), Raw.objectArrayAssertion()).containsExactlyInOrder("1");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1")), 2)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 2)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 2), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2")), 2)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 2)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 2), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4")), 2)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");

        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 2)).isInstanceOf(String[].class);
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 2), Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");
        Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("1\n2\n3\n4\n")), 2)).as(Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2");

        try {
            Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(createErrorReader())));
            Assertions.fail("BufferedReaderToStringArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(createErrorReader()), 0));
            Assertions.fail("BufferedReaderToStringArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }

        try {
            Assertions.assertThat(new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(createErrorReader()), 2));
            Assertions.fail("BufferedReaderToStringArrayValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new BufferedReaderToStringArrayValueConverter().convert(null);
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new BufferedReaderToStringArrayValueConverter().convert(new Object());
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), new Object(), new Object());
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullArgumentFailTest() throws ConversionException {
        new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), (Object) null);
    }

    /**
     * {@link BufferedReaderToStringArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new BufferedReaderToStringArrayValueConverter().convert(new BufferedReader(new StringReader("")), new Object());
    }

}
