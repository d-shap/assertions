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
 * Tests for {@link IntArrayToCharArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToCharArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToCharArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().getTargetClass()).isEqualTo(char[].class);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().canConvert(new int[0])).isTrue();
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().canConvert(new int[]{1, 2})).isTrue();
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().canConvert(new int[]{1, 2, 3, 4})).isTrue();
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().canConvert(new int[]{100000, 100001})).isFalse();
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new IntArrayToCharArrayValueConverter().canConvert(null);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToCharArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{}), Raw.charArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{})).as(Raw.charArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2}), Raw.charArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2})).as(Raw.charArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.charArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.charArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(char[].class);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001}), Raw.charArrayAssertion()).containsExactlyInOrder(34464, 34465);
        Assertions.assertThat(new IntArrayToCharArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.charArrayAssertion()).containsExactlyInOrder(34464, 34465);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new IntArrayToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToCharArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToCharArrayValueConverter().convert(new Object());
    }

}
