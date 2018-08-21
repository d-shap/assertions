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
package ru.d_shap.assertions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for {@link BaseValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BaseValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BaseValueConverterTest() {
        super();
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test
    public void checkArgumentCountTest() {
        createValueConverter().checkArgumentCount(new Object[]{}, 0);
        createValueConverter().checkArgumentCount(new Object[]{"argument"}, 1);
        createValueConverter().checkArgumentCount(new Object[]{"argument1", "argument2"}, 2);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkArgumentCountWrongCount0FailTest() {
        createValueConverter().checkArgumentCount(new Object[]{"argument"}, 0);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkArgumentCountWrongCount1FailTest() {
        createValueConverter().checkArgumentCount(new Object[]{}, 1);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test
    public void checkArgumentClassTest() {
        createValueConverter().checkArgumentClass(new Object[]{"argument"}, 0, String.class);
        createValueConverter().checkArgumentClass(new Object[]{"argument"}, 0, Object.class);
        createValueConverter().checkArgumentClass(new Object[]{new Object()}, 0, Object.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void checkArgumentClassNullArgumentFailTest() {
        createValueConverter().checkArgumentClass(new Object[]{null}, 0, String.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void checkArgumentClassWrongArgumentTypeFailTest() {
        createValueConverter().checkArgumentClass(new Object[]{new Object()}, 0, String.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConversionException {
        Assertions.assertThat(createValueConverter().canConvert(100)).isTrue();
        Assertions.assertThat(createValueConverter().canConvert(100000)).isTrue();
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConversionException {
        createValueConverter().canConvert(null);
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(createValueConverter().convert(100)).isInstanceOf(Integer.class);
        Assertions.assertThat(createValueConverter().convert(100)).isEqualTo(100);
        Assertions.assertThat(createValueConverter().convert(100000)).isInstanceOf(Integer.class);
        Assertions.assertThat(createValueConverter().convert(100000)).isEqualTo(100000);
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        createValueConverter().convert(null);
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertValueToTargetClassTest() throws ConversionException {
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(null, String.class)).isNull();

        Assertions.assertThat(createValueConverter().convertValueToTargetClass(100, Character.class)).isInstanceOf(Character.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(100, Character.class)).isEqualTo((char) 100);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(100000, Character.class)).isInstanceOf(Integer.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(100000, Character.class)).isEqualTo(100000);

        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1), Raw.<Integer>listAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(createValueConverter().convertValueToTargetClass(Arrays.asList(1, 2, 3, 4, 5), Map.class)).isInstanceOf(List.class);
    }

}
