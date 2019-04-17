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
package ru.d_shap.assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * Tests for {@link PrivateAccessor}.
 *
 * @author Dmitry Shapovalov
 */
public final class PrivateAccessorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public PrivateAccessorTest() {
        super();
    }

    /**
     * {@link PrivateAccessor} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(PrivateAccessor.class).hasOnePrivateConstructor();
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleFieldTest() throws Exception {
        PrivateFieldClass privateField = new PrivateFieldClass();
        Field field = privateField.getClass().getDeclaredField("_value");
        try {
            field.get(privateField);
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private final\"");
        }
        PrivateAccessor.setAccessible(field);
        Object value = field.get(privateField);
        Assertions.assertThat(value).isEqualTo("value");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleMethodTest() throws Exception {
        PrivateMethodClass privateMethod = new PrivateMethodClass();
        Method method = privateMethod.getClass().getDeclaredMethod("getValue");
        try {
            method.invoke(privateMethod);
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private\"");
        }
        PrivateAccessor.setAccessible(method);
        Object value = method.invoke(privateMethod);
        Assertions.assertThat(value).isEqualTo("value");
    }

    /**
     * {@link PrivateAccessor} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleConstructorTest() throws Exception {
        Constructor<PrivateConstructorClass> constructor = PrivateConstructorClass.class.getDeclaredConstructor();
        try {
            constructor.newInstance();
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private\"");
        }
        PrivateAccessor.setAccessible(constructor);
        PrivateConstructorClass privateConstructor = constructor.newInstance();
        Assertions.assertThat(privateConstructor).isNotNull();
    }

}
