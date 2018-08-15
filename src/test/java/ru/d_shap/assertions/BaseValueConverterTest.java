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
    public void checkValueClassTest() {
        createValueConverter().checkValueClass("value");
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void checkValueClassNullValueFailTest() {
        createValueConverter().checkValueClass(null);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void checkValueClassWrongValueTypeFailTest() {
        createValueConverter().checkValueClass(new Object());
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test
    public void checkArgumentValueCountTest() {
        createValueConverter().checkArgumentValueCount(0);
        createValueConverter().checkArgumentValueCount(1, "argument");
        createValueConverter().checkArgumentValueCount(2, "argument1", "argument2");
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkArgumentValueCountWrongCount0FailTest() {
        createValueConverter().checkArgumentValueCount(0, "argument");
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkArgumentValueCountWrongCount1FailTest() {
        createValueConverter().checkArgumentValueCount(1);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test
    public void checkArgumentClassTest() {
        createValueConverter().checkArgumentClass("argument", String.class);
        createValueConverter().checkArgumentClass("argument", Object.class);
        createValueConverter().checkArgumentClass(new Object(), Object.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void checkArgumentClassNullArgumentFailTest() {
        createValueConverter().checkArgumentClass(null, String.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void checkArgumentClassWrongArgumentTypeFailTest() {
        createValueConverter().checkArgumentClass(new Object(), String.class);
    }

    /**
     * {@link BaseValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertValueTest() throws ConvertionException {
        Assertions.assertThat(createValueConverter().convertValue(null, String.class)).isNull();

        Assertions.assertThat(createValueConverter().convertValue(100, Character.class)).isInstanceOf(Character.class);
        Assertions.assertThat(createValueConverter().convertValue(100, Character.class)).isEqualTo((char) 100);
        Assertions.assertThat(createValueConverter().convertValue(100000, Character.class)).isInstanceOf(Integer.class);
        Assertions.assertThat(createValueConverter().convertValue(100000, Character.class)).isEqualTo(100000);

        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1)).isInstanceOf(List.class);
        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1), Raw.<Integer>listAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(createValueConverter().convertValue(Arrays.asList(1, 2, 3, 4, 5), Map.class)).isInstanceOf(List.class);
    }

}
