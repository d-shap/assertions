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
package ru.d_shap.assertions.array;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharArrayToListValueConverter().getValueClass()).isEqualTo(char[].class);
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new CharArrayToListValueConverter().canConvert(new char[0])).isTrue();
        Assertions.assertThat(new CharArrayToListValueConverter().canConvert(new char[]{'1', '2'})).isTrue();
        Assertions.assertThat(new CharArrayToListValueConverter().canConvert(new char[]{'1', '2', '3', '4'})).isTrue();
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().canConvert(new char[0], new Object());
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{}), Raw.<Character>listAssertion()).isEmpty();
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{})).as(Raw.<Character>listAssertion()).isEmpty();

        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2'})).isInstanceOf(List.class);
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2'}), Raw.<Character>listAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2'})).as(Raw.<Character>listAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2', '3', '4'})).isInstanceOf(List.class);
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2', '3', '4'}), Raw.<Character>listAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharArrayToListValueConverter().convert(new char[]{'1', '2', '3', '4'})).as(Raw.<Character>listAssertion()).containsExactlyInOrder('1', '2', '3', '4');
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().convert(null);
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link CharArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new CharArrayToListValueConverter().convert(new char[0], new Object());
    }

}
