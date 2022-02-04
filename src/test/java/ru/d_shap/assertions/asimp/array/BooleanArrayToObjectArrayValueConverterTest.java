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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
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
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false}), Raw.objectArrayAssertion()).containsExactlyInOrder(true, false);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, false})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(true, false);

        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false})).isInstanceOf(Boolean[].class);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false}), Raw.objectArrayAssertion()).containsExactlyInOrder(true, true, false, false);
        Assertions.assertThat(new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{true, true, false, false})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(true, true, false, false);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new BooleanArrayToObjectArrayValueConverter().convert(null);
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new BooleanArrayToObjectArrayValueConverter().convert(new Object());
    }

    /**
     * {@link BooleanArrayToObjectArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new BooleanArrayToObjectArrayValueConverter().convert(new boolean[]{}, new Object());
    }

}
