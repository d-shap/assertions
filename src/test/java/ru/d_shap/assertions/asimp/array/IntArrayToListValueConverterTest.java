///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.array;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToListValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{}), Raw.<Integer>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{})).as(Raw.<Integer>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2})).isInstanceOf(List.class);
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2}), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2})).as(Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);

        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2, 3, 4})).isInstanceOf(List.class);
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2, 3, 4}), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(new IntArrayToListValueConverter().convert(new int[]{1, 2, 3, 4})).as(Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IntArrayToListValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IntArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new IntArrayToListValueConverter().convert(new int[]{}, new Object());
    }

}
