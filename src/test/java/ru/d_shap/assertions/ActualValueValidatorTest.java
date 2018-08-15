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

import org.junit.Test;

/**
 * Tests for {@link ActualValueValidator}.
 *
 * @author Dmitry Shapovalov
 */
public final class ActualValueValidatorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ActualValueValidatorTest() {
        super();
    }

    /**
     * {@link ActualValueValidator} class test.
     */
    @Test
    public void isValidTest() {
        ActualValueValidator actualValueValidator1 = new ActualValueValidator();
        Assertions.assertThat(actualValueValidator1.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator1.isValid(new Object())).isTrue();

        ActualValueValidator actualValueValidator2 = new ActualValueValidator();
        actualValueValidator2.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator2.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator2.isValid(new Object())).isTrue();

        ActualValueValidator actualValueValidator3 = new ActualValueValidator();
        actualValueValidator3.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator3.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator3.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator3.isValid(new Object())).isTrue();

        ActualValueValidator actualValueValidator4 = new ActualValueValidator();
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator4.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator4.isValid(new Object())).isTrue();

        ActualValueValidator actualValueValidator5 = new ActualValueValidator();
        actualValueValidator5.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator5.addActualValueValidator(createActualValueValidator(false));
        actualValueValidator5.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator5.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator5.isValid(new Object())).isFalse();

        ActualValueValidator actualValueValidator6 = new ActualValueValidator();
        actualValueValidator6.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator6.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator6.addActualValueValidator(createActualValueValidator(false));
        Assertions.assertThat(actualValueValidator6.isValid(null)).isTrue();
        Assertions.assertThat(actualValueValidator6.isValid(new Object())).isFalse();
    }

}
