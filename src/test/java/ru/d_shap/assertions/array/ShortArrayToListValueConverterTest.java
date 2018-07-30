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
 * Tests for {@link ShortArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortArrayToListValueConverter().getValueClass()).isEqualTo(short[].class);
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ShortArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new ShortArrayToListValueConverter().canConvert(new short[0])).isTrue();
        Assertions.assertThat(new ShortArrayToListValueConverter().canConvert(new short[]{1, 2})).isTrue();
        Assertions.assertThat(new ShortArrayToListValueConverter().canConvert(new short[]{1, 2, 3, 4})).isTrue();
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().canConvert(new short[0], new Object());
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{}), Raw.<Short>listAssertion()).isEmpty();
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{})).as(Raw.<Short>listAssertion()).isEmpty();

        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2})).isInstanceOf(List.class);
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2}), Raw.<Short>listAssertion()).containsExactlyInOrder((short) 1, (short) 2);
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2})).as(Raw.<Short>listAssertion()).containsExactlyInOrder((short) 1, (short) 2);

        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2, 3, 4})).isInstanceOf(List.class);
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2, 3, 4}), Raw.<Short>listAssertion()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        Assertions.assertThat(new ShortArrayToListValueConverter().convert(new short[]{1, 2, 3, 4})).as(Raw.<Short>listAssertion()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().convert(null);
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link ShortArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new ShortArrayToListValueConverter().convert(new short[0], new Object());
    }

}
