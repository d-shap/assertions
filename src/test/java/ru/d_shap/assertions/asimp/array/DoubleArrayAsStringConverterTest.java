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
package ru.d_shap.assertions.asimp.array;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DoubleArrayAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayAsStringConverterTest() {
        super();
    }

    /**
     * {@link DoubleArrayAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleArrayAsStringConverter().getValueClass()).isEqualTo(double[].class);
    }

    /**
     * {@link DoubleArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new DoubleArrayAsStringConverter().asString(new double[]{})).isEqualTo("<EMPTY>");
        Assertions.assertThat(new DoubleArrayAsStringConverter().asString(new double[]{1.0})).isEqualTo("[1.0]");
        Assertions.assertThat(new DoubleArrayAsStringConverter().asString(new double[]{1.0, 2.0})).isEqualTo("[1.0, 2.0]");
        Assertions.assertThat(new DoubleArrayAsStringConverter().asString(new double[]{1.0, 2.0, 3.0, 4.0})).isEqualTo("[1.0, 2.0, 3.0, 4.0]");
    }

    /**
     * {@link DoubleArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new DoubleArrayAsStringConverter().asString(null);
    }

    /**
     * {@link DoubleArrayAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new DoubleArrayAsStringConverter().asString(new Object());
    }

}
