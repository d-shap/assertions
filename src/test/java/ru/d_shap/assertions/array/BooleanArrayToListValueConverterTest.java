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
 * Tests for {@link BooleanArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new BooleanArrayToListValueConverter().getValueClass()).isEqualTo(boolean[].class);
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new BooleanArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new BooleanArrayToListValueConverter().canConvert(new boolean[0])).isTrue();
        Assertions.assertThat(new BooleanArrayToListValueConverter().canConvert(new boolean[]{true, false})).isTrue();
        Assertions.assertThat(new BooleanArrayToListValueConverter().canConvert(new boolean[]{true, true, false, false})).isTrue();
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().canConvert(new boolean[0], new Object());
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{}), Raw.<Boolean>listAssertion()).isEmpty();
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{})).as(Raw.<Boolean>listAssertion()).isEmpty();

        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, false})).isInstanceOf(List.class);
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, false}), Raw.<Boolean>listAssertion()).containsExactlyInOrder(true, false);
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, false})).as(Raw.<Boolean>listAssertion()).containsExactlyInOrder(true, false);

        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, true, false, false})).isInstanceOf(List.class);
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, true, false, false}), Raw.<Boolean>listAssertion()).containsExactlyInOrder(true, true, false, false);
        Assertions.assertThat(new BooleanArrayToListValueConverter().convert(new boolean[]{true, true, false, false})).as(Raw.<Boolean>listAssertion()).containsExactlyInOrder(true, true, false, false);
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().convert(null);
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link BooleanArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new BooleanArrayToListValueConverter().convert(new boolean[0], new Object());
    }

}
