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
package ru.d_shap.assertions.asimp;

import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ExecutableDescription}.
 *
 * @author Dmitry Shapovalov
 */
public final class ExecutableDescriptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ExecutableDescriptionTest() {
        super();
    }

    /**
     * {@link ExecutableDescription} class test.
     */
    @Test
    public void getNameTest() {
        Assertions.assertThat(new ExecutableDescription(null).getName()).isNull();
        Assertions.assertThat(new ExecutableDescription(null, String.class).getName()).isNull();
        Assertions.assertThat(new ExecutableDescription(null, (Class<?>) null).getName()).isNull();
        Assertions.assertThat(new ExecutableDescription("name").getName()).isEqualTo("name");
        Assertions.assertThat(new ExecutableDescription("name", String.class).getName()).isEqualTo("name");
        Assertions.assertThat(new ExecutableDescription("name", (Class<?>) null).getName()).isEqualTo("name");
    }

    /**
     * {@link ExecutableDescription} class test.
     */
    @Test
    public void getParameterTypesTest() {
        Assertions.assertThat(new ExecutableDescription("name").getParameterTypes()).containsExactlyInOrder();
        Assertions.assertThat(new ExecutableDescription("name", String.class).getParameterTypes()).containsExactlyInOrder(String.class);
        Assertions.assertThat(new ExecutableDescription("name", (Class<?>) null).getParameterTypes()).containsExactlyInOrder((Class<?>) null);
        Assertions.assertThat(new ExecutableDescription("name", String.class, int.class).getParameterTypes()).containsExactlyInOrder(String.class, int.class);
        Assertions.assertThat(new ExecutableDescription("name", Date.class, String.class, int.class).getParameterTypes()).containsExactlyInOrder(Date.class, String.class, int.class);
    }

}
