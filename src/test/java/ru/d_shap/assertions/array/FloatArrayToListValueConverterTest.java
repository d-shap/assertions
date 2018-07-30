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
 * Tests for {@link FloatArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatArrayToListValueConverter().getValueClass()).isEqualTo(float[].class);
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new FloatArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new FloatArrayToListValueConverter().canConvert(new float[0])).isTrue();
        Assertions.assertThat(new FloatArrayToListValueConverter().canConvert(new float[]{1.0f, 2.0f})).isTrue();
        Assertions.assertThat(new FloatArrayToListValueConverter().canConvert(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).isTrue();
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new FloatArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new FloatArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{}), Raw.<Float>listAssertion()).isEmpty();
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{})).as(Raw.<Float>listAssertion()).isEmpty();

        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f})).isInstanceOf(List.class);
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f}), Raw.<Float>listAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f})).as(Raw.<Float>listAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).isInstanceOf(List.class);
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), Raw.<Float>listAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThat(new FloatArrayToListValueConverter().convert(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).as(Raw.<Float>listAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new FloatArrayToListValueConverter().convert(null);
    }

    /**
     * {@link FloatArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new FloatArrayToListValueConverter().convert(new Object());
    }

}