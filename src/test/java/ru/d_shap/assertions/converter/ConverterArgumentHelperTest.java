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
package ru.d_shap.assertions.converter;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ConverterArgumentHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConverterArgumentHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConverterArgumentHelperTest() {
        super();
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ConverterArgumentHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void getValueTest() {
        Assertions.assertThat(ConverterArgumentHelper.getValue("value", String.class)).isInstanceOf(String.class);
        Assertions.assertThat(ConverterArgumentHelper.getValue("value", String.class)).isEqualTo("value");

        Assertions.assertThat(ConverterArgumentHelper.getValue("value", Object.class)).isInstanceOf(String.class);
        Assertions.assertThat(ConverterArgumentHelper.getValue("value", Object.class)).isInstanceOf(Object.class);
        Assertions.assertThat(ConverterArgumentHelper.getValue("value", Object.class)).isEqualTo("value");

        Assertions.assertThat(ConverterArgumentHelper.getValue(new Object(), Object.class)).isInstanceOf(Object.class);
        Assertions.assertThat(ConverterArgumentHelper.getValue(new Object(), Object.class)).isNotNull();
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = NullPointerException.class)
    public void getValueNullFailTest() {
        ConverterArgumentHelper.getValue(null, String.class);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = ClassCastException.class)
    public void getValueWrongClassFailTest() {
        ConverterArgumentHelper.getValue(new Object(), String.class);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toByteObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((byte[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new byte[]{})).hasClass(Byte[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new byte[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new byte[]{1, 2, 3})).hasClass(Byte[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new byte[]{1, 2, 3})).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toShortObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((short[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new short[]{})).hasClass(Short[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new short[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new short[]{1, 2, 3})).hasClass(Short[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new short[]{1, 2, 3})).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toIntegerObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((int[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new int[]{})).hasClass(Integer[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new int[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new int[]{1, 2, 3})).hasClass(Integer[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new int[]{1, 2, 3})).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toLongObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((long[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new long[]{})).hasClass(Long[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new long[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new long[]{1L, 2L, 3L})).hasClass(Long[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new long[]{1L, 2L, 3L})).containsExactlyInOrder(1L, 2L, 3L);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toFloatObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((float[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new float[]{})).hasClass(Float[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new float[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new float[]{1.0f, 2.0f, 3.0f})).hasClass(Float[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new float[]{1.0f, 2.0f, 3.0f})).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toDoubleObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((double[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new double[]{})).hasClass(Double[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new double[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new double[]{1.0, 2.0, 3.0})).hasClass(Double[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new double[]{1.0, 2.0, 3.0})).containsExactlyInOrder(1.0, 2.0, 3.0);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toBooleanObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((boolean[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new boolean[]{})).hasClass(Boolean[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new boolean[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new boolean[]{true, true, false})).hasClass(Boolean[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new boolean[]{true, true, false})).containsExactlyInOrder(true, true, false);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void toCharacterObjectArrayTest() {
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray((char[]) null)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new char[]{})).hasClass(Character[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new char[]{})).containsExactlyInOrder();
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new char[]{'1', '2', '3'})).hasClass(Character[].class);
        Assertions.assertThat(ConverterArgumentHelper.toObjectArray(new char[]{'1', '2', '3'})).containsExactlyInOrder('1', '2', '3');
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void checkArgumentsLengthTest() {
        ConverterArgumentHelper.checkArgumentsLength(new Object[0], 0);
        ConverterArgumentHelper.checkArgumentsLength(new Object[1], 1);
        ConverterArgumentHelper.checkArgumentsLength(new Object[2], 2);

        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[0], -1);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 0");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[0], 1);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 0");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[1], -1);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[1], 0);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[1], 2);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], -1);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], 0);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], 1);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], 3);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = NullPointerException.class)
    public void checkArgumentsLengthNullFailTest() {
        ConverterArgumentHelper.checkArgumentsLength(null, 0);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void getArgumentTest() {
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 0, Object.class)).isNull();
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 0, String.class)).isNull();

        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 0, Object.class)).isEqualTo("value");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 0, String.class)).isEqualTo("value");

        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 0, Object.class)).isEqualTo(5);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 0, Integer.class)).isEqualTo(5);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 1, Object.class)).isEqualTo(7);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 1, Integer.class)).isEqualTo(7);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 2, Object.class)).isEqualTo(9);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5, 7, 9}, 2, Integer.class)).isEqualTo(9);

        try {
            ConverterArgumentHelper.getArgument(new Object[]{new Object()}, -1, String.class);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.getArgument(new Object[]{new Object()}, 1, String.class);
            Assertions.fail(ConverterArgumentHelper.class);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = NullPointerException.class)
    public void getArgumentNull1FailTest() {
        ConverterArgumentHelper.getArgument(null, 0, Object.class);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = ClassCastException.class)
    public void getArgumentWrongClassFailTest() {
        ConverterArgumentHelper.getArgument(new Object[]{new Object()}, 0, String.class);
    }

}
