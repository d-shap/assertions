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
 * Tests for {@link DoubleAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleAsStringConverterTest() {
        super();
    }

    /**
     * {@link DoubleAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleAsStringConverter().getValueClass()).isEqualTo(Double.class);
    }

    /**
     * {@link DoubleAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new DoubleAsStringConverter().asString(0.99)).isEqualTo("0.99");
        Assertions.assertThat(new DoubleAsStringConverter().asString(1.0)).isEqualTo("1.0");
        Assertions.assertThat(new DoubleAsStringConverter().asString(5000.0)).isEqualTo("5000.0");
        Assertions.assertThat(new DoubleAsStringConverter().asString(5000000.0)).isEqualTo("5000000.0");
        Assertions.assertThat(new DoubleAsStringConverter().asString(0.001)).isEqualTo("0.001");
        Assertions.assertThat(new DoubleAsStringConverter().asString(0.0001)).isEqualTo("1.0E-4");
        Assertions.assertThat(new DoubleAsStringConverter().asString(-0.99)).isEqualTo("-0.99");
        Assertions.assertThat(new DoubleAsStringConverter().asString(-5000.0)).isEqualTo("-5000.0");
        Assertions.assertThat(new DoubleAsStringConverter().asString(-5000000.0)).isEqualTo("-5000000.0");
        Assertions.assertThat(new DoubleAsStringConverter().asString(-0.001)).isEqualTo("-0.001");
        Assertions.assertThat(new DoubleAsStringConverter().asString(-0.0001)).isEqualTo("-1.0E-4");
        Assertions.assertThat(new DoubleAsStringConverter().asString(Double.NaN)).isEqualTo("NaN");
        Assertions.assertThat(new DoubleAsStringConverter().asString(Double.POSITIVE_INFINITY)).isEqualTo("Infinity");
        Assertions.assertThat(new DoubleAsStringConverter().asString(Double.NEGATIVE_INFINITY)).isEqualTo("-Infinity");
    }

    /**
     * {@link DoubleAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new DoubleAsStringConverter().asString(null);
    }

    /**
     * {@link DoubleAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new DoubleAsStringConverter().asString(new Object());
    }

}
