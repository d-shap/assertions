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
    public void checkArgumentsLengthTest() {
        ConverterArgumentHelper.checkArgumentsLength(new Object[0], 0);
        ConverterArgumentHelper.checkArgumentsLength(new Object[0], 1);
        ConverterArgumentHelper.checkArgumentsLength(new Object[1], 1);
        ConverterArgumentHelper.checkArgumentsLength(new Object[0], 2);
        ConverterArgumentHelper.checkArgumentsLength(new Object[1], 2);
        ConverterArgumentHelper.checkArgumentsLength(new Object[2], 2);

        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[0], -1);
            Assertions.fail("ConverterArgumentHelper test fail");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 0");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[1], -1);
            Assertions.fail("ConverterArgumentHelper test fail");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[1], 0);
            Assertions.fail("ConverterArgumentHelper test fail");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 1");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], -1);
            Assertions.fail("ConverterArgumentHelper test fail");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], 0);
            Assertions.fail("ConverterArgumentHelper test fail");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("Array index out of range: 2");
        }
        try {
            ConverterArgumentHelper.checkArgumentsLength(new Object[2], 1);
            Assertions.fail("ConverterArgumentHelper test fail");
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
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[0], -1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[0], 0, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[0], 1, Object.class, "default")).isEqualTo("default");

        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, -1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 0, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 0, String.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{null}, 2, Object.class, "default")).isEqualTo("default");

        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, -1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 0, Object.class, "default")).isEqualTo("value");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 0, String.class, "default")).isEqualTo("value");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{"value"}, 2, Object.class, "default")).isEqualTo("default");

        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5}, -1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5}, 0, Object.class, "default")).isEqualTo(5);
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5}, 1, Object.class, "default")).isEqualTo("default");
        Assertions.assertThat(ConverterArgumentHelper.getArgument(new Object[]{5}, 2, Object.class, "default")).isEqualTo("default");
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = ClassCastException.class)
    public void getArgumentWrongClassFailTest() {
        ConverterArgumentHelper.getArgument(new Object[]{new Object()}, 0, String.class, "default");
    }

}
