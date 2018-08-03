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
 * Tests for {@link ReaderToIntValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReaderToIntValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReaderToIntValueConverterTest() {
        super();
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ReaderToIntValueConverter().getValueClass()).isEqualTo(Reader.class);
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ReaderToIntValueConverter().getTargetClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new ReaderToIntValueConverter().canConvert(new StringReader(""))).isTrue();
        Assertions.assertThat(new ReaderToIntValueConverter().canConvert(new StringReader("1"))).isTrue();
        Assertions.assertThat(new ReaderToIntValueConverter().canConvert(new StringReader("12"))).isTrue();
        Assertions.assertThat(new ReaderToIntValueConverter().canConvert(new StringReader("1234"))).isTrue();

        Assertions.assertThat(new ReaderToIntValueConverter().canConvert(createErrorReader())).isTrue();
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().canConvert(null);
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().canConvert(new Object());
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().canConvert(new StringReader(""), new Object());
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader(""))).isInstanceOf(Integer.class);
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("")), Raw.intAssertion()).isLessThan(0);
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader(""))).as(Raw.intAssertion()).isLessThan(0);

        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1"))).isInstanceOf(Integer.class);
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1")), Raw.intAssertion()).isEqualTo('1');
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1"))).as(Raw.intAssertion()).isEqualTo('1');

        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("12"))).isInstanceOf(Integer.class);
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("12")), Raw.intAssertion()).isEqualTo('1');
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("12"))).as(Raw.intAssertion()).isEqualTo('1');

        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1234"))).isInstanceOf(Integer.class);
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1234")), Raw.intAssertion()).isEqualTo('1');
        Assertions.assertThat(new ReaderToIntValueConverter().convert(new StringReader("1234"))).as(Raw.intAssertion()).isEqualTo('1');

        try {
            Assertions.assertThat(new ReaderToIntValueConverter().convert(createErrorReader()));
            Assertions.fail("ReaderToIntValueConverter test fail");
        } catch (ConvertionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().convert(null);
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().convert(new Object());
    }

    /**
     * {@link ReaderToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new ReaderToIntValueConverter().convert(new StringReader(""), new Object());
    }

}
