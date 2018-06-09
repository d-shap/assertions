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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link EnumActualValueValidator}.
 *
 * @author Dmitry Shapovalov
 */
public final class EnumActualValueValidatorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public EnumActualValueValidatorTest() {
        super();
    }

    /**
     * {@link EnumActualValueValidator} class test.
     */
    @Test
    public void isValidTest() {
        Assertions.assertThat(new EnumActualValueValidator().isValid(Values.class)).isTrue();
        Assertions.assertThat(new EnumActualValueValidator().isValid(Object.class)).isFalse();
        Assertions.assertThat(new EnumActualValueValidator().isValid("value")).isFalse();
    }

}