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
package ru.d_shap.assertions.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntToCharValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToCharValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToCharValueConverterTest() {
        super();
    }

    /**
     * {@link IntToCharValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToCharValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToCharValueConverter().getTargetClass()).isEqualTo(Character.class);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new IntToCharValueConverter().canConvert(0)).isTrue();
        Assertions.assertThat(new IntToCharValueConverter().canConvert(100)).isTrue();
        Assertions.assertThat(new IntToCharValueConverter().canConvert(65535)).isTrue();
        Assertions.assertThat(new IntToCharValueConverter().canConvert(65536)).isFalse();
        Assertions.assertThat(new IntToCharValueConverter().canConvert(-1)).isFalse();
        Assertions.assertThat(new IntToCharValueConverter().canConvert(-100)).isFalse();
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new IntToCharValueConverter().canConvert(null);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new IntToCharValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new IntToCharValueConverter().canConvert(0, new Object());
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new IntToCharValueConverter().convert(0)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(0), Raw.charAssertion()).isEqualTo(0);
        Assertions.assertThat(new IntToCharValueConverter().convert(0)).as(Raw.charAssertion()).isEqualTo(0);

        Assertions.assertThat(new IntToCharValueConverter().convert(100)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(100), Raw.charAssertion()).isEqualTo(100);
        Assertions.assertThat(new IntToCharValueConverter().convert(100)).as(Raw.charAssertion()).isEqualTo(100);

        Assertions.assertThat(new IntToCharValueConverter().convert(65535)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(65535), Raw.charAssertion()).isEqualTo(65535);
        Assertions.assertThat(new IntToCharValueConverter().convert(65535)).as(Raw.charAssertion()).isEqualTo(65535);

        Assertions.assertThat(new IntToCharValueConverter().convert(65536)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(65536), Raw.charAssertion()).isEqualTo(0);
        Assertions.assertThat(new IntToCharValueConverter().convert(65536)).as(Raw.charAssertion()).isEqualTo(0);

        Assertions.assertThat(new IntToCharValueConverter().convert(-1)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(-1), Raw.charAssertion()).isEqualTo(65535);
        Assertions.assertThat(new IntToCharValueConverter().convert(-1)).as(Raw.charAssertion()).isEqualTo(65535);

        Assertions.assertThat(new IntToCharValueConverter().convert(-100)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(-100), Raw.charAssertion()).isEqualTo(65436);
        Assertions.assertThat(new IntToCharValueConverter().convert(-100)).as(Raw.charAssertion()).isEqualTo(65436);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new IntToCharValueConverter().convert(null);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new IntToCharValueConverter().convert(new Object());
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new IntToCharValueConverter().convert(0, new Object());
    }

}
