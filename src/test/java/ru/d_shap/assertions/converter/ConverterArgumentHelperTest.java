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
    public void checkValueClassTest() {
        ConverterArgumentHelper.checkValueClass("", String.class);
        ConverterArgumentHelper.checkValueClass("", Object.class);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = NullPointerException.class)
    public void checkValueClassNullFailTest() {
        ConverterArgumentHelper.checkValueClass(null, String.class);
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test(expected = ClassCastException.class)
    public void checkValueClassWrongClassFailTest() {
        ConverterArgumentHelper.checkValueClass(new Object(), String.class);
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
    public void checkArgumentClassTest() {
        // TODO
    }

    /**
     * {@link ConverterArgumentHelper} class test.
     */
    @Test
    public void getArgumentTest() {
        // TODO
    }

}
