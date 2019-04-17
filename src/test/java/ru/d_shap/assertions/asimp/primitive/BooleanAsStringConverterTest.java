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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link BooleanAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanAsStringConverterTest() {
        super();
    }

    /**
     * {@link BooleanAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new BooleanAsStringConverter().getValueClass()).isEqualTo(Boolean.class);
    }

    /**
     * {@link BooleanAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new BooleanAsStringConverter().asString(true)).isEqualTo("T");
        Assertions.assertThat(new BooleanAsStringConverter().asString(Boolean.TRUE)).isEqualTo("T");
        Assertions.assertThat(new BooleanAsStringConverter().asString(false)).isEqualTo("F");
        Assertions.assertThat(new BooleanAsStringConverter().asString(Boolean.FALSE)).isEqualTo("F");
    }

    /**
     * {@link BooleanAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new BooleanAsStringConverter().asString(null);
    }

    /**
     * {@link BooleanAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new BooleanAsStringConverter().asString(new Object());
    }

}
