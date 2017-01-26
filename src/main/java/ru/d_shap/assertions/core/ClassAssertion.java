///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the class.
 *
 * @author Dmitry Shapovalov
 */
public class ClassAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public ClassAssertion(final Class<?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is the subtype of the expected class.
     *
     * @param clazz the expected class.
     */
    public final void isSubtypeOf(final Class<?> clazz) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(clazz);
        if (!clazz.isAssignableFrom((Class) getActual())) {
            throw createAssertionError(FailMessages.getIsSubtypeOf(actualAsString(), asString(clazz)));
        }
    }

    /**
     * Check if the actual value is NOT the subtype of the expected class.
     *
     * @param clazz the expected class.
     */
    public final void isNotSubtypeOf(final Class<?> clazz) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(clazz);
        if (clazz.isAssignableFrom((Class) getActual())) {
            throw createAssertionError(FailMessages.getIsNotSubtypeOf(actualAsString(), asString(clazz)));
        }
    }

    /**
     * Check if the actual value has one private no-arg constructor (utility class constructor).
     */
    public final void hasOnePrivateConstructor() {
        checkActualIsNotNull();
        Constructor[] constructors = ((Class<?>) getActual()).getDeclaredConstructors();
        if (constructors.length != 1) {
            throw createAssertionError(FailMessages.getIsConstructorDefault(actualAsString()));
        }
        Constructor constructor = constructors[0];
        if (constructor.getParameterTypes().length != 0) {
            throw createAssertionError(FailMessages.getIsConstructorDefault(actualAsString()));
        }
        int modifiers = constructor.getModifiers();
        if (!Modifier.isPrivate(modifiers)) {
            throw createAssertionError(FailMessages.getIsConstructorNotAccessible(actualAsString()));
        }
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw createAssertionError(ex);
        }
    }

    /**
     * Make assertion about the class as enum.
     *
     * @return the assertion.
     */
    public final EnumAssertion asEnum() {
        checkActualIsNotNull();
        Class<?> actualClass = (Class<?>) getActual();
        if (Enum.class.isAssignableFrom(actualClass)) {
            return new EnumAssertion(actualClass, getMessage());
        } else {
            throw createAssertionError(FailMessages.getIsEnum(actualAsString()));
        }
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            if (value instanceof Class) {
                return ((Class<?>) value).getName();
            } else {
                return String.valueOf(value);
            }
        }
    }

}
