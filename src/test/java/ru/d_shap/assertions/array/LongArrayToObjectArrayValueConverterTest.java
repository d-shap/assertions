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
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(long[].class);
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Long[].class);
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().canConvert(new long[0])).isTrue();
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().canConvert(new long[]{1L, 2L})).isTrue();
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().canConvert(new long[]{1L, 2L, 3L, 4L})).isTrue();
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().canConvert(new long[0], new Object());
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{})).isInstanceOf(Long[].class);
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{}), Raw.objectArrayAssertion()).isEmpty();
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{})).as(Raw.objectArrayAssertion()).isEmpty();

        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L})).isInstanceOf(Long[].class);
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L}), Raw.objectArrayAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1L, 2L);

        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L, 3L, 4L})).isInstanceOf(Long[].class);
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L, 3L, 4L}), Raw.objectArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        Assertions.assertThat(new LongArrayToObjectArrayValueConverter().convert(new long[]{1L, 2L, 3L, 4L})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link LongArrayToObjectArrayValueConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new LongArrayToObjectArrayValueConverter().convert(new long[0], new Object());
    }

}
