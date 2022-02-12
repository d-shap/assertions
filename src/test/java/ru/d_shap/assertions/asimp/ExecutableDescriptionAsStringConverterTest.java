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
 * Tests for {@link ExecutableDescriptionAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ExecutableDescriptionAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ExecutableDescriptionAsStringConverterTest() {
        super();
    }

    /**
     * {@link ExecutableDescriptionAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().getValueClass()).isEqualTo(ExecutableDescription.class);
    }

    /**
     * {@link ExecutableDescriptionAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription(null))).isEqualTo("<NULL>()");
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name"))).isEqualTo("name()");

        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name", (Class<?>) null))).isEqualTo("name(<NULL>)");
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name", String.class))).isEqualTo("name(java.lang.String)");
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name", String.class, int.class))).isEqualTo("name(java.lang.String, int)");
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name", Date.class, int.class, String.class))).isEqualTo("name(java.util.Date, int, java.lang.String)");
        Assertions.assertThat(new ExecutableDescriptionAsStringConverter().asString(new ExecutableDescription("name", Integer.class))).isEqualTo("name(java.lang.Integer)");
    }

    /**
     * {@link ExecutableDescriptionAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new ExecutableDescriptionAsStringConverter().asString(null);
    }

    /**
     * {@link ExecutableDescriptionAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new ExecutableDescriptionAsStringConverter().asString(new Object());
    }

}
