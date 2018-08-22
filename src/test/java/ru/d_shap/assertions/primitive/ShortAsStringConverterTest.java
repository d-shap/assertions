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
package ru.d_shap.assertions.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;

/**
 * Tests for {@link ShortAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortAsStringConverterTest() {
        super();
    }

    /**
     * {@link ShortAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortAsStringConverter().getValueClass()).isEqualTo(Short.class);
    }

    /**
     * {@link ShortAsStringConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConversionException {
        Assertions.assertThat(new ShortAsStringConverter().asString((short) 1)).isEqualTo("1s");
        Assertions.assertThat(new ShortAsStringConverter().asString((short) 100)).isEqualTo("100s");
        Assertions.assertThat(new ShortAsStringConverter().asString((short) 127)).isEqualTo("127s");
        Assertions.assertThat(new ShortAsStringConverter().asString((short) 32767)).isEqualTo("32767s");
        Assertions.assertThat(new ShortAsStringConverter().asString((short) -100)).isEqualTo("-100s");
        Assertions.assertThat(new ShortAsStringConverter().asString((short) -32768)).isEqualTo("-32768s");
    }

    /**
     * {@link ShortAsStringConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws ConversionException {
        new ShortAsStringConverter().asString(null);
    }

    /**
     * {@link ShortAsStringConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws ConversionException {
        new ShortAsStringConverter().asString(new Object());
    }

}