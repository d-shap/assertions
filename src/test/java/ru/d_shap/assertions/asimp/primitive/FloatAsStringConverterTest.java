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
 * Tests for {@link FloatAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatAsStringConverterTest() {
        super();
    }

    /**
     * {@link FloatAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new FloatAsStringConverter().getValueClass()).isEqualTo(Float.class);
    }

    /**
     * {@link FloatAsStringConverter} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatAsStringConverter().asString(0.99f)).isEqualTo("0.99f");
        Assertions.assertThat(new FloatAsStringConverter().asString(1.0f)).isEqualTo("1.0f");
        Assertions.assertThat(new FloatAsStringConverter().asString(5000.0f)).isEqualTo("5000.0f");
        Assertions.assertThat(new FloatAsStringConverter().asString(5000000.0f)).isEqualTo("5000000.0f");
        Assertions.assertThat(new FloatAsStringConverter().asString(0.001f)).isEqualTo("0.001f");
        Assertions.assertThat(new FloatAsStringConverter().asString(0.0001f)).isEqualTo("1.0E-4f");
        Assertions.assertThat(new FloatAsStringConverter().asString(-0.99f)).isEqualTo("-0.99f");
        Assertions.assertThat(new FloatAsStringConverter().asString(-5000.0f)).isEqualTo("-5000.0f");
        Assertions.assertThat(new FloatAsStringConverter().asString(-5000000.0f)).isEqualTo("-5000000.0f");
        Assertions.assertThat(new FloatAsStringConverter().asString(-0.001f)).isEqualTo("-0.001f");
        Assertions.assertThat(new FloatAsStringConverter().asString(-0.0001f)).isEqualTo("-1.0E-4f");
        Assertions.assertThat(new FloatAsStringConverter().asString(Float.NaN)).isEqualTo("NaN");
        Assertions.assertThat(new FloatAsStringConverter().asString(Float.POSITIVE_INFINITY)).isEqualTo("Infinity");
        Assertions.assertThat(new FloatAsStringConverter().asString(Float.NEGATIVE_INFINITY)).isEqualTo("-Infinity");
    }

    /**
     * {@link FloatAsStringConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() {
        new FloatAsStringConverter().asString(null);
    }

    /**
     * {@link FloatAsStringConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() {
        new FloatAsStringConverter().asString(new Object());
    }

}
