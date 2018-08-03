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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(char[].class);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Character[].class);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().canConvert(new char[0])).isTrue();
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().canConvert(new char[]{'1', '2'})).isTrue();
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().canConvert(new char[]{'1', '2', '3', '4'})).isTrue();
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().canConvert(new char[0], new Object());
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{}), Raw.objectArrayAssertion()).isEmpty();
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{})).as(Raw.objectArrayAssertion()).isEmpty();

        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'}), Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2'})).as(Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'})).isInstanceOf(Character[].class);
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'}), Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharArrayToObjectArrayValueConverter().convert(new char[]{'1', '2', '3', '4'})).as(Raw.objectArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link CharArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new CharArrayToObjectArrayValueConverter().convert(new char[0], new Object());
    }

}
