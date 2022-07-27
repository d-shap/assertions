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
package ru.d_shap.assertions.asimp.java.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.util.ReflectionException;
import ru.d_shap.assertions.util.ReflectionHelper;

/**
 * Assertions for the class.
 *
 * @author Dmitry Shapovalov
 */
public final class ClassAssertion extends ReferenceAssertion<Class<?>> {

    /**
     * Create new object.
     */
    public ClassAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<Class<?>> getActualValueClass() {
        return (Class<Class<?>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Class.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isEqualTo(final Class<?> expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotEqualTo(final Class<?> expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is the subtype of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isSubtypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!expected.isAssignableFrom(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SUBTYPE_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT the subtype of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotSubtypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (expected.isAssignableFrom(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_SUBTYPE_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is the supertype of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isSupertypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().isAssignableFrom(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SUPERTYPE_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT the supertype of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotSupertypeOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().isAssignableFrom(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_SUPERTYPE_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is the interface type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isInterface() {
        checkActualIsNotNull();
        if (!getActual().isInterface()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_INTERCACE_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT the interface type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotInterface() {
        checkActualIsNotNull();
        if (getActual().isInterface()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_INTERCACE_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is the array type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isArray() {
        checkActualIsNotNull();
        if (!getActual().isArray()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_ARRAY_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT the array type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotArray() {
        checkActualIsNotNull();
        if (getActual().isArray()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_ARRAY_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is the enum type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isEnum() {
        checkActualIsNotNull();
        if (!getActual().isEnum()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_ENUM_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT the enum type.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion isNotEnum() {
        checkActualIsNotNull();
        if (getActual().isEnum()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_ENUM_TYPE).addActual().build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's component type.
     *
     * @return the assertion.
     */
    public ClassAssertion toComponentType() {
        isArray();
        return initializeAssertion(Raw.classAssertion(), getActual().getComponentType(), Messages.Check.COMPONENT_TYPE);
    }

    /**
     * Make assertion about the actual value's component type.
     *
     * @param matcher the hamcrest matcher.
     * @param <T>     the generic type of the actual value's component type.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public <T> ClassAssertion toComponentType(final Matcher<? super Class<T>> matcher) {
        isArray();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion((Class<T>) getActual().getComponentType(), matcher, Messages.Check.COMPONENT_TYPE);
        return this;
    }

    /**
     * Check if the actual value's component type is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion hasComponentType(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toComponentType().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value has one private no-arg constructor (utility class constructor).
     * Side-effect: invokes the private constractor for the code coverage.
     *
     * @return current object for the chain call.
     */
    public ClassAssertion hasOnePrivateConstructor() {
        checkActualIsNotNull();
        Constructor<?>[] constructors = ReflectionHelper.getConstructors(getActual());
        if (constructors.length != 1) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_CONSTRUCTOR_DEFAULT).addActual().build();
        }
        Constructor<?> constructor = constructors[0];
        if (constructor.getParameterTypes().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_CONSTRUCTOR_DEFAULT).addActual().build();
        }
        int modifiers = constructor.getModifiers();
        if (!Modifier.isPrivate(modifiers)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONSTRUCTOR_NOT_ACCESSIBLE).addActual().build();
        }
        try {
            ReflectionHelper.callConstructor(constructor);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONSTRUCTOR_CALLABLE).addActual().build();
        }
        return this;
    }

    /**
     * Make assertion about the class as enum.
     *
     * @return the assertion.
     */
    public EnumAssertion asEnum() {
        if (getActual() != null) {
            isEnum();
        }
        return as(Raw.enumAssertion());
    }

}
