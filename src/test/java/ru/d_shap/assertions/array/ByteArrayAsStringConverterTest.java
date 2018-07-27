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
package ru.d_shap.assertions.array;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;

/**
 * Tests for {@link ByteArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayAsStringConverterTest {

    /**
     * Test class constructor.
     */
    public ByteArrayAsStringConverterTest() {
        super();
    }

    /**
     * {@link ByteArrayAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteArrayAsStringConverter().getValueClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link ByteArrayAsStringConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConvertionException {
        Assertions.assertThat(new ByteArrayAsStringConverter().asString(new byte[]{})).isEqualTo("[]");
        Assertions.assertThat(new ByteArrayAsStringConverter().asString(new byte[]{1})).isEqualTo("[1]");
        Assertions.assertThat(new ByteArrayAsStringConverter().asString(new byte[]{1, 2})).isEqualTo("[1, 2]");
        Assertions.assertThat(new ByteArrayAsStringConverter().asString(new byte[]{1, 2, 3, 4})).isEqualTo("[1, 2, 3, 4]");
    }

    /**
     * {@link ByteArrayAsStringConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws ConvertionException {
        new ByteArrayAsStringConverter().asString(null);
    }

    /**
     * {@link ByteArrayAsStringConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws ConvertionException {
        new ByteArrayAsStringConverter().asString(new Object());
    }

}
