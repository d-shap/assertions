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
 * Tests for {@link BooleanArrayToObjectArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayToObjectArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayToObjectArrayValueConverterTest() {
        super();
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().getValueClass()).isEqualTo(boolean[].class);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().getTargetClass()).isEqualTo(Boolean[].class);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().canConvert(new boolean[0])).isTrue();
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().canConvert(new boolean[]{true, false})).isTrue();
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().canConvert(new boolean[]{true, true, false, false})).isTrue();
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().canConvert(null);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().canConvert(new Object());
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().canConvert(new boolean[0], new Object());
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{}), Raw.objectArrayAssertion()).isEmpty();
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{})).as(Raw.objectArrayAssertion()).isEmpty();

        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false}), Raw.objectArrayAssertion()).containsExactlyInOrder(true, false);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(true, false);

        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false}), Raw.objectArrayAssertion()).containsExactlyInOrder(true, true, false, false);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(true, true, false, false);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConversionException {
        new BooleanArrayToObjectArrayValueConverter().convert(new boolean[0], new Object());
    }

}
