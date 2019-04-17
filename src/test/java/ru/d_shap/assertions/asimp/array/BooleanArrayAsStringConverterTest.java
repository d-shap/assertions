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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link BooleanArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayAsStringConverterTest() {
        super();
    }

    /**
     * {@link BooleanArrayAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new BooleanArrayAsStringConverter().getValueClass()).isEqualTo(boolean[].class);
    }

    /**
     * {@link BooleanArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{})).isEqualTo("[]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true})).isEqualTo("[T]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true, false})).isEqualTo("[T, F]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true, true, false, false})).isEqualTo("[T, T, F, F]");
    }

    /**
     * {@link BooleanArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new BooleanArrayAsStringConverter().asString(null);
    }

    /**
     * {@link BooleanArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new BooleanArrayAsStringConverter().asString(new Object());
    }

}
