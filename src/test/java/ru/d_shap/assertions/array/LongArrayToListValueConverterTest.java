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
import ru.d_shap.assertions.ConversionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongArrayToListValueConverter().getValueClass()).isEqualTo(long[].class);
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new LongArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new LongArrayToListValueConverter().canConvert(new long[0])).isTrue();
        Assertions.assertThat(new LongArrayToListValueConverter().canConvert(new long[]{1L, 2L})).isTrue();
        Assertions.assertThat(new LongArrayToListValueConverter().canConvert(new long[]{1L, 2L, 3L, 4L})).isTrue();
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new LongArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new LongArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new LongArrayToListValueConverter().canConvert(new long[0], new Object());
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{}), Raw.<Long>listAssertion()).isEmpty();
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{})).as(Raw.<Long>listAssertion()).isEmpty();

        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L})).isInstanceOf(List.class);
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L}), Raw.<Long>listAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L})).as(Raw.<Long>listAssertion()).containsExactlyInOrder(1L, 2L);

        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L, 3L, 4L})).isInstanceOf(List.class);
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L, 3L, 4L}), Raw.<Long>listAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        Assertions.assertThat(new LongArrayToListValueConverter().convert(new long[]{1L, 2L, 3L, 4L})).as(Raw.<Long>listAssertion()).containsExactlyInOrder(1L, 2L, 3L, 4L);
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new LongArrayToListValueConverter().convert(null);
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new LongArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link LongArrayToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new LongArrayToListValueConverter().convert(new long[0], new Object());
    }

}
