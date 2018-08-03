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
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link InputStreamToIntValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamToIntValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public InputStreamToIntValueConverterTest() {
        super();
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new InputStreamToIntValueConverter().getValueClass()).isEqualTo(InputStream.class);
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new InputStreamToIntValueConverter().getTargetClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new InputStreamToIntValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}))).isTrue();
        Assertions.assertThat(new InputStreamToIntValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1}))).isTrue();
        Assertions.assertThat(new InputStreamToIntValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2}))).isTrue();
        Assertions.assertThat(new InputStreamToIntValueConverter().canConvert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}))).isTrue();

        Assertions.assertThat(new InputStreamToIntValueConverter().canConvert(createErrorInputStream())).isTrue();
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().canConvert(null);
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().canConvert(new Object());
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().canConvert(new ByteArrayInputStream(new byte[]{}), new Object());
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{}))).isInstanceOf(Integer.class);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{})), Raw.intAssertion()).isLessThan(0);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{}))).as(Raw.intAssertion()).isLessThan(0);

        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1}))).isInstanceOf(Integer.class);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1})), Raw.intAssertion()).isEqualTo(1);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1}))).as(Raw.intAssertion()).isEqualTo(1);

        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}))).isInstanceOf(Integer.class);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2})), Raw.intAssertion()).isEqualTo(1);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2}))).as(Raw.intAssertion()).isEqualTo(1);

        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}))).isInstanceOf(Integer.class);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4})), Raw.intAssertion()).isEqualTo(1);
        Assertions.assertThat(new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{1, 2, 3, 4}))).as(Raw.intAssertion()).isEqualTo(1);

        try {
            Assertions.assertThat(new InputStreamToIntValueConverter().convert(createErrorInputStream()));
            Assertions.fail("InputStreamToIntValueConverter test fail");
        } catch (ConvertionException ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
            Assertions.assertThat(ex).hasCause(IOException.class);
        }
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().convert(null);
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().convert(new Object());
    }

    /**
     * {@link InputStreamToIntValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new InputStreamToIntValueConverter().convert(new ByteArrayInputStream(new byte[]{}), new Object());
    }

}
