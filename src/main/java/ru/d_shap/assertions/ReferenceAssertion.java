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

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import ru.d_shap.assertions.core.CharSequenceAssertion;
import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all reference type assertions.
 *
 * @param <T> the generic type of the actual value.
 * @author Dmitry Shapovalov
 */
public abstract class ReferenceAssertion<T> extends BaseAssertion<T> {

    /**
     * Create new object.
     */
    protected ReferenceAssertion() {
        super();
    }

    /**
     * Check if the actual value is null.
     */
    public final void isNull() {
        checkInitialized();
        if (getActual() != null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NULL).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    public final void isNotNull() {
        checkInitialized();
        checkActualIsNotNull();
    }

    /**
     * Check if the actual value is the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isSameAs(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotSameAs(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Make assertion about the actual value's class.
     *
     * @return the assertion.
     */
    public final ClassAssertion toClass() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.classAssertion(), getActual().getClass(), Messages.Check.ACTUAL_VALUE_CLASS);
    }

    /**
     * Check if the actual value has the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasClass(final Class<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toClass().isEqualTo(expected);
    }

    /**
     * Check if the actual value has NOT the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasNotClass(final Class<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toClass().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isInstanceOf(final Class<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toClass().isSubtypeOf(expected);
    }

    /**
     * Check if the actual value is NOT the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isNotInstanceOf(final Class<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toClass().isNotSubtypeOf(expected);
    }

    /**
     * Make assertion about the actual value's string representation.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toToString() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().toString(), Messages.Check.ACTUAL_VALUE_TO_STRING);
    }

    /**
     * Check if the string representation of the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isToStringEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toToString().isEqualTo(expected);
    }

    /**
     * Check if the string representation of the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void toStringContains(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toToString().contains(expected);
    }

    /**
     * Make assertion about the actual value's hash code.
     *
     * @return the assertion.
     */
    public final IntAssertion toHashCode() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().hashCode(), Messages.Check.ACTUAL_VALUE_HASH_CODE);
    }

    /**
     * Check if the actual values hash code is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isHashCodeEqualTo(final int expected) {
        toHashCode().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's field.
     *
     * @param fieldName the field name.
     * @return the assertion.
     */
    public final ObjectAssertion toField(final String fieldName) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName);
        try {
            Field field = getField(fieldName);
            setAccessible(field);
            Object value = field.get(getActual());
            return initializeAssertion(Raw.objectAssertion(), value, Messages.Check.ACTUAL_VALUE_FIELD, fieldName);
        } catch (ReflectiveOperationException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.CONTAINS_FIELD).addExpected(fieldName).build();
        }
    }

    /**
     * Make assertion of the specified type about the actual value's field.
     *
     * @param fieldName the field name.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the assertion.
     */
    public final <W, S extends BaseAssertion<W>> S toField(final String fieldName, final S assertion) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(assertion);
        return toField(fieldName).as(assertion);
    }

    private Field getField(final String fieldName) throws NoSuchFieldException {
        Class<?> currentClass = getActual().getClass();
        NoSuchFieldException noSuchFieldException = null;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                noSuchFieldException = ex;
                currentClass = currentClass.getSuperclass();
            }
        }
        throw noSuchFieldException;
    }

    /**
     * Make the private class element accessible.
     *
     * @param accessibleObject the private class element.
     */
    protected final void setAccessible(final AccessibleObject accessibleObject) {
        PrivateAccessor.setAccessible(accessibleObject);
    }

}
