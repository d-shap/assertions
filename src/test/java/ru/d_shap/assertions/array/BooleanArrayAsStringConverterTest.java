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
 * Tests for {@link BooleanArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAsStringConverterTest {

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
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConvertionException {
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{})).isEqualTo("[]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true})).isEqualTo("[T]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true, false})).isEqualTo("[T, F]");
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new boolean[]{true, true, false, false})).isEqualTo("[T, T, F, F]");

        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(null)).isNull();
        Assertions.assertThat(new BooleanArrayAsStringConverter().asString(new Object())).startsWith("java.lang.Object@");
    }

}
