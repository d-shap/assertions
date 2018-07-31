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
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntToShortValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToShortValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToShortValueConverterTest() {
        super();
    }

    /**
     * {@link IntToShortValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToShortValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToShortValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToShortValueConverter().getTargetClass()).isEqualTo(Short.class);
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new IntToShortValueConverter().canConvert(0)).isTrue();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(100)).isTrue();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(32767)).isTrue();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(32768)).isFalse();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(-100)).isTrue();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(-32768)).isTrue();
        Assertions.assertThat(new IntToShortValueConverter().canConvert(-32769)).isFalse();
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new IntToShortValueConverter().canConvert(null);
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new IntToShortValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new IntToShortValueConverter().canConvert(0, new Object());
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new IntToShortValueConverter().convert(0)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(0), Raw.shortAssertion()).isEqualTo(0);
        Assertions.assertThat(new IntToShortValueConverter().convert(0)).as(Raw.shortAssertion()).isEqualTo(0);

        Assertions.assertThat(new IntToShortValueConverter().convert(100)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(100), Raw.shortAssertion()).isEqualTo(100);
        Assertions.assertThat(new IntToShortValueConverter().convert(100)).as(Raw.shortAssertion()).isEqualTo(100);

        Assertions.assertThat(new IntToShortValueConverter().convert(32767)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(32767), Raw.shortAssertion()).isEqualTo(32767);
        Assertions.assertThat(new IntToShortValueConverter().convert(32767)).as(Raw.shortAssertion()).isEqualTo(32767);

        Assertions.assertThat(new IntToShortValueConverter().convert(32768)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(32768), Raw.shortAssertion()).isEqualTo(-32768);
        Assertions.assertThat(new IntToShortValueConverter().convert(32768)).as(Raw.shortAssertion()).isEqualTo(-32768);

        Assertions.assertThat(new IntToShortValueConverter().convert(-100)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(-100), Raw.shortAssertion()).isEqualTo(-100);
        Assertions.assertThat(new IntToShortValueConverter().convert(-100)).as(Raw.shortAssertion()).isEqualTo(-100);

        Assertions.assertThat(new IntToShortValueConverter().convert(-32768)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(-32768), Raw.shortAssertion()).isEqualTo(-32768);
        Assertions.assertThat(new IntToShortValueConverter().convert(-32768)).as(Raw.shortAssertion()).isEqualTo(-32768);

        Assertions.assertThat(new IntToShortValueConverter().convert(-32769)).isInstanceOf(Short.class);
        Assertions.assertThat(new IntToShortValueConverter().convert(-32769), Raw.shortAssertion()).isEqualTo(32767);
        Assertions.assertThat(new IntToShortValueConverter().convert(-32769)).as(Raw.shortAssertion()).isEqualTo(32767);
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new IntToShortValueConverter().convert(null);
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new IntToShortValueConverter().convert(new Object());
    }

    /**
     * {@link IntToShortValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new IntToShortValueConverter().convert(0, new Object());
    }

}
