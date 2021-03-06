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
package ru.d_shap.assertions.asimp;

import java.lang.reflect.AccessibleObject;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.PrivateAccessor;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.ClassAssertion;
import ru.d_shap.assertions.asimp.java.lang.ObjectAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Base class for all reference type assertions.
 *
 * @param <T> the generic type of the actual value.
 *
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
        if (getActual() != null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    public final void isNotNull() {
        checkActualIsNotNull();
    }

    /**
     * Check if the actual value is the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isSameAs(final T expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotSameAs(final T expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Make assertion about the actual value's class.
     *
     * @return the assertion.
     */
    public final ClassAssertion toClass() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.classAssertion(), getActual().getClass(), Messages.Check.CLASS);
    }

    /**
     * Make assertion about the actual value's class.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toClass(final Matcher<Class<?>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getClass(), matcher, Messages.Check.CLASS);
    }

    /**
     * Check if the actual value has the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasClass(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isEqualTo(expected);
    }

    /**
     * Check if the actual value has NOT the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasNotClass(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isInstanceOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isSubtypeOf(expected);
    }

    /**
     * Check if the actual value is NOT the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isNotInstanceOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isNotSubtypeOf(expected);
    }

    /**
     * Make assertion about the actual value's string representation.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toToString() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().toString(), Messages.Check.TO_STRING);
    }

    /**
     * Make assertion about the actual value's string representation.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toToString(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().toString(), matcher, Messages.Check.TO_STRING);
    }

    /**
     * Check if the string representation of the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasToString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().isEqualTo(expected);
    }

    /**
     * Check if the string representation of the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void toStringContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().contains(expected);
    }

    /**
     * Check if the string representation of the actual value matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void toStringMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().matches(expected);
    }

    /**
     * Make assertion about the actual value's hash code.
     *
     * @return the assertion.
     */
    public final IntAssertion toHashCode() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().hashCode(), Messages.Check.HASH_CODE);
    }

    /**
     * Make assertion about the actual value's hash code.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toHashCode(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().hashCode(), matcher, Messages.Check.HASH_CODE);
    }

    /**
     * Check if the actual value's hash code is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasHashCode(final int expected) {
        toHashCode().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's field.
     *
     * @param fieldName the field name.
     *
     * @return the assertion.
     */
    public final ObjectAssertion toField(final String fieldName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        try {
            Object fieldValue = PrivateAccessor.getFieldValue(getActual(), fieldName);
            return initializeAssertion(Raw.objectAssertion(), fieldValue, Messages.Check.FIELD, fieldName);
        } catch (ReflectiveOperationException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_FIELD).addExpected(fieldName).build();
        }
    }

    /**
     * Make assertion of the specified type about the actual value's field.
     *
     * @param fieldName the field name.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public final <W, S extends BaseAssertion<W>> S toField(final String fieldName, final S assertion) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        checkArgumentIsNotNull(assertion, "assertion");
        return toField(fieldName).as(assertion);
    }

    /**
     * Make assertion about the actual value's field.
     *
     * @param fieldName the field name.
     * @param matcher   the hamcrest matcher.
     */
    @SuppressWarnings("unchecked")
    public final void toField(final String fieldName, final Matcher<?> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        checkArgumentIsNotNull(matcher, "matcher");
        try {
            Object fieldValue = PrivateAccessor.getFieldValue(getActual(), fieldName);
            matcherAssertion(fieldValue, (Matcher<Object>) matcher, Messages.Check.FIELD, fieldName);
        } catch (ReflectiveOperationException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_FIELD).addExpected(fieldName).build();
        }
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
