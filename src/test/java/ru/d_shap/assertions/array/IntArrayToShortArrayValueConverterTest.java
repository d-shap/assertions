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
 * Tests for {@link IntArrayToShortArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToShortArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToShortArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().getTargetClass()).isEqualTo(short[].class);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().canConvert(new int[0])).isTrue();
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().canConvert(new int[]{1, 2})).isTrue();
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().canConvert(new int[]{1, 2, 3, 4})).isTrue();
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().canConvert(new int[]{100000, 100001})).isFalse();
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new IntArrayToShortArrayValueConverter().canConvert(null);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToShortArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{}), Raw.shortArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{})).as(Raw.shortArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2}), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);

        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001})).isInstanceOf(short[].class);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001}), Raw.shortArrayAssertion()).containsExactlyInOrder(-31072, -31071);
        Assertions.assertThat(new IntArrayToShortArrayValueConverter().convert(new int[]{100000, 100001})).as(Raw.shortArrayAssertion()).containsExactlyInOrder(-31072, -31071);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new IntArrayToShortArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToShortArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToShortArrayValueConverter().convert(new Object());
    }

}
