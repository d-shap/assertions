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
package ru.d_shap.assertions.core;

import java.util.Map;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;

/**
 * Tests for {@link ClassAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ClassAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ClassAsStringConverterTest() {
        super();
    }

    /**
     * {@link ClassAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ClassAsStringConverter().getValueClass()).isEqualTo(Class.class);
    }

    /**
     * {@link ClassAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConversionException {
        Assertions.assertThat(new ClassAsStringConverter().asString(Object.class)).isEqualTo("java.lang.Object");
        Assertions.assertThat(new ClassAsStringConverter().asString(Boolean.class)).isEqualTo("java.lang.Boolean");
        Assertions.assertThat(new ClassAsStringConverter().asString(Map.class)).isEqualTo("java.util.Map");
        Assertions.assertThat(new ClassAsStringConverter().asString(ClassAsStringConverter.class)).isEqualTo("ru.d_shap.assertions.core.ClassAsStringConverter");
    }

    /**
     * {@link ClassAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws ConversionException {
        new ClassAsStringConverter().asString(null);
    }

    /**
     * {@link ClassAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws ConversionException {
        new ClassAsStringConverter().asString(new Object());
    }

}
