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
 * Tests for {@link ByteAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteAsStringConverterTest() {
        super();
    }

    /**
     * {@link ByteAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteAsStringConverter().getValueClass()).isEqualTo(Byte.class);
    }

    /**
     * {@link ByteAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new ByteAsStringConverter().asString((byte) 1)).isEqualTo("1b");
        Assertions.assertThat(new ByteAsStringConverter().asString((byte) 100)).isEqualTo("100b");
        Assertions.assertThat(new ByteAsStringConverter().asString((byte) 127)).isEqualTo("127b");
        Assertions.assertThat(new ByteAsStringConverter().asString((byte) -100)).isEqualTo("-100b");
        Assertions.assertThat(new ByteAsStringConverter().asString((byte) -128)).isEqualTo("-128b");
    }

    /**
     * {@link ByteAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new ByteAsStringConverter().asString(null);
    }

    /**
     * {@link ByteAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new ByteAsStringConverter().asString(new Object());
    }

}
