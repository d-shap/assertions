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
 * Tests for {@link CharAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharAsStringConverterTest() {
        super();
    }

    /**
     * {@link CharAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharAsStringConverter().getValueClass()).isEqualTo(Character.class);
    }

    /**
     * {@link CharAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new CharAsStringConverter().asString('0')).isEqualTo("0(48)");
        Assertions.assertThat(new CharAsStringConverter().asString('1')).isEqualTo("1(49)");
        Assertions.assertThat(new CharAsStringConverter().asString('a')).isEqualTo("a(97)");
        Assertions.assertThat(new CharAsStringConverter().asString('A')).isEqualTo("A(65)");
        Assertions.assertThat(new CharAsStringConverter().asString('и')).isEqualTo("и(1080)");
        Assertions.assertThat(new CharAsStringConverter().asString('Ё')).isEqualTo("Ё(1025)");
        Assertions.assertThat(new CharAsStringConverter().asString('\n')).isEqualTo(" (10)");
        Assertions.assertThat(new CharAsStringConverter().asString((char) 10000)).isEqualTo(" (10000)");
    }

    /**
     * {@link CharAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new CharAsStringConverter().asString(null);
    }

    /**
     * {@link CharAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new CharAsStringConverter().asString(new Object());
    }

}
