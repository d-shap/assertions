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
 * Tests for {@link IntArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Integer[].class);
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().canConvert(new int[0])).isTrue();
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().canConvert(new int[]{1, 2})).isTrue();
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().canConvert(new int[]{1, 2, 3, 4})).isTrue();
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().canConvert(new int[0], new Object());
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{})).isInstanceOf(Integer[].class);
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{}), Raw.objectArrayAssertion()).isEmpty();
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{})).as(Raw.objectArrayAssertion()).isEmpty();

        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2})).isInstanceOf(Integer[].class);
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2}), Raw.objectArrayAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(Integer[].class);
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.objectArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToObjectArrayValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1, 2, 3, 4);
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new IntArrayToObjectArrayValueConverter().convert(new int[0], new Object());
    }

}
