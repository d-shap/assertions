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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link LongAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongAsStringConverterTest() {
        super();
    }

    /**
     * {@link LongAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongAsStringConverter().getValueClass()).isEqualTo(Long.class);
    }

    /**
     * {@link LongAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new LongAsStringConverter().asString(1L)).isEqualTo("1L");
        Assertions.assertThat(new LongAsStringConverter().asString(10L)).isEqualTo("10L");
        Assertions.assertThat(new LongAsStringConverter().asString(1000000L)).isEqualTo("1000000L");
        Assertions.assertThat(new LongAsStringConverter().asString(-10L)).isEqualTo("-10L");
        Assertions.assertThat(new LongAsStringConverter().asString(-1000000L)).isEqualTo("-1000000L");
    }

    /**
     * {@link LongAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new LongAsStringConverter().asString(null);
    }

    /**
     * {@link LongAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new LongAsStringConverter().asString(new Object());
    }

}
