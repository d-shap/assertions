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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;
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
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public ClassAssertion(final Class<?> actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is the subtype of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isSubtypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!expected.isAssignableFrom((Class) getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SUBTYPE_OF, expected);
        }
    }

    /**
     * Check if the actual value is NOT the subtype of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isNotSubtypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (expected.isAssignableFrom((Class) getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_SUBTYPE_OF, expected);
        }
    }

    /**
     * Check if the actual value has one private no-arg constructor (utility class constructor).
     */
    public final void hasOnePrivateConstructor() {
        checkActualIsNotNull();
        Constructor[] constructors = ((Class<?>) getActual()).getDeclaredConstructors();
        if (constructors.length != 1) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_CONSTRUCTOR_DEFAULT);
        }
        Constructor constructor = constructors[0];
        if (constructor.getParameterTypes().length != 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_CONSTRUCTOR_DEFAULT);
        }
        int modifiers = constructor.getModifiers();
        if (!Modifier.isPrivate(modifiers)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_CONSTRUCTOR_NOT_ACCESSIBLE);
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
        return as(EnumAssertion.class);
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        if (value == null) {
            return null;
        } else {
            if (value instanceof Class) {
                return ((Class<?>) value).getName();
            } else {
                return value.toString();
            }
        }
    }

}
