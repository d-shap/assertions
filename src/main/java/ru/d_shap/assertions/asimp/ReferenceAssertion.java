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
import java.lang.reflect.Method;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.ClassAssertion;
import ru.d_shap.assertions.asimp.java.lang.ObjectAssertion;
import ru.d_shap.assertions.asimp.java.lang.ThrowableAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.util.ReflectionException;
import ru.d_shap.assertions.util.ReflectionHelper;
import ru.d_shap.assertions.util.SerializationException;
import ru.d_shap.assertions.util.SerializationHelper;

/**
 * Base class for all reference type assertions.
 *
 * @param <R> the generic type of the assertion class.
 * @param <T> the generic type of the actual value.
 *
 * @author Dmitry Shapovalov
 */
public abstract class ReferenceAssertion<R extends ReferenceAssertion<R, T>, T> extends BaseAssertion<T> {

    /**
     * Create new object.
     */
    protected ReferenceAssertion() {
        super();
    }

    /**
     * Check if the actual value is null.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isNull() {
        if (getActual() != null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL).addActual().build();
        }
        return (R) this;
    }

    /**
     * Check if the actual value is NOT null.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isNotNull() {
        checkActualIsNotNull();
        return (R) this;
    }

    /**
     * Check if the actual value is the same as the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isSameAs(final T expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME_REFERENCE).addActual().addExpected(expected).build();
        }
        return (R) this;
    }

    /**
     * Check if the actual value is NOT the same as the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isNotSameAs(final T expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT_REFERENCE).addActual().build();
        }
        return (R) this;
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
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toClass(final Matcher<? super Class<?>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getClass(), matcher, Messages.Check.CLASS);
        return (R) this;
    }

    /**
     * Check if the actual value has the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R hasClass(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isEqualTo(expected);
        return (R) this;
    }

    /**
     * Check if the actual value has NOT the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R hasNotClass(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isNotEqualTo(expected);
        return (R) this;
    }

    /**
     * Check if the actual value is the instance of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isInstanceOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isSubtypeOf(expected);
        return (R) this;
    }

    /**
     * Check if the actual value is NOT the instance of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isNotInstanceOf(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toClass().isNotSubtypeOf(expected);
        return (R) this;
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
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toToString(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().toString(), matcher, Messages.Check.TO_STRING);
        return (R) this;
    }

    /**
     * Check if the string representation of the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R hasToString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().isEqualTo(expected);
        return (R) this;
    }

    /**
     * Check if the string representation of the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toStringContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().contains(expected);
        return (R) this;
    }

    /**
     * Check if the string representation of the actual value matches the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toStringMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toToString().matches(expected);
        return (R) this;
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
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toHashCode(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().hashCode(), matcher, Messages.Check.HASH_CODE);
        return (R) this;
    }

    /**
     * Check if the actual value's hash code is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R hasHashCode(final int expected) {
        toHashCode().isEqualTo(expected);
        return (R) this;
    }

    /**
     * Check if the actual value is serializable.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isSerializable() {
        checkActualIsNotNull();
        try {
            SerializationHelper.serializeAndDeserialize(getActual());
        } catch (SerializationException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.IS_SERIALIZABLE).addActual().build();
        }
        return (R) this;
    }

    /**
     * Check if the actual value is NOT serializable.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R isNotSerializable() {
        checkActualIsNotNull();
        try {
            SerializationHelper.serializeAndDeserialize(getActual());
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_SERIALIZABLE).addActual().build();
        } catch (SerializationException ex) {
            // Ignore
        }
        return (R) this;
    }

    /**
     * Make assertion about the actual value's field value.
     *
     * @param fieldName the field name.
     *
     * @return the assertion.
     */
    public final ObjectAssertion toFieldValue(final String fieldName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        try {
            Object fieldValue = ReflectionHelper.getFieldValue(getActual(), fieldName);
            return initializeAssertion(Raw.objectAssertion(), fieldValue, Messages.Check.FIELD_VALUE, fieldName);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_FIELD).addExpected(fieldName).build();
        }
    }

    /**
     * Make assertion of the specified type about the actual value's field value.
     *
     * @param fieldName the field name.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public final <W, S extends BaseAssertion<W>> S toFieldValue(final String fieldName, final S assertion) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        checkArgumentIsNotNull(assertion, "assertion");
        return toFieldValue(fieldName).as(assertion);
    }

    /**
     * Make assertion about the actual value's field value.
     *
     * @param fieldName the field name.
     * @param matcher   the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toFieldValue(final String fieldName, final Matcher<?> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(fieldName, "fieldName");
        checkArgumentIsNotNull(matcher, "matcher");
        try {
            Object fieldValue = ReflectionHelper.getFieldValue(getActual(), fieldName);
            matcherAssertion(fieldValue, (Matcher<Object>) matcher, Messages.Check.FIELD_VALUE, fieldName);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_FIELD).addExpected(fieldName).build();
        }
        return (R) this;
    }

    /**
     * Make assertion about the actual value's method call result.
     *
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     *
     * @return the assertion.
     */
    public final ObjectAssertion toMethodCallResult(final String methodName, final Class<?>[] parameterTypes, final Object[] arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(parameterTypes, "parameterTypes");
        checkArgumentIsNotNull(arguments, "arguments");
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            Object methodCallResult = ReflectionHelper.callMethod(method, getActual(), arguments);
            return initializeAssertion(Raw.objectAssertion(), methodCallResult, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.METHOD_CALL_RESULT).addExpected(executableDescription).build();
        }
    }

    /**
     * Make assertion about the actual value's method call result.
     *
     * @param methodName the method name.
     * @param arguments  the arguments used to call the method.
     *
     * @return the assertion.
     */
    public final ObjectAssertion toMethodCallResult(final String methodName, final Object... arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(arguments, "arguments");
        Class<?>[] parameterTypes = ReflectionHelper.getParameterTypes(arguments);
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            Object methodCallResult = ReflectionHelper.callMethod(method, getActual(), arguments);
            return initializeAssertion(Raw.objectAssertion(), methodCallResult, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.METHOD_CALL_RESULT).addExpected(executableDescription).build();
        }
    }

    /**
     * Make assertion about the actual value's method call result.
     *
     * @param methodName     the method name.
     * @param assertion      the assertion.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     * @param <W>            the generic type of the assertion's actual value.
     * @param <S>            the generic type of the assertion.
     *
     * @return the assertion.
     */
    public final <W, S extends BaseAssertion<W>> S toMethodCallResult(final String methodName, final S assertion, final Class<?>[] parameterTypes, final Object[] arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(parameterTypes, "parameterTypes");
        checkArgumentIsNotNull(arguments, "arguments");
        checkArgumentIsNotNull(assertion, "assertion");
        return toMethodCallResult(methodName, parameterTypes, arguments).as(assertion);
    }

    /**
     * Make assertion of the specified type about the actual value's method call result.
     *
     * @param methodName the method name.
     * @param assertion  the assertion.
     * @param arguments  the arguments used to call the method.
     * @param <W>        the generic type of the assertion's actual value.
     * @param <S>        the generic type of the assertion.
     *
     * @return the assertion.
     */
    public final <W, S extends BaseAssertion<W>> S toMethodCallResult(final String methodName, final S assertion, final Object... arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(arguments, "arguments");
        checkArgumentIsNotNull(assertion, "assertion");
        return toMethodCallResult(methodName, arguments).as(assertion);
    }

    /**
     * Make assertion about the actual value's method call result.
     *
     * @param methodName     the method name.
     * @param matcher        the hamcrest matcher.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toMethodCallResult(final String methodName, final Matcher<?> matcher, final Class<?>[] parameterTypes, final Object[] arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(matcher, "matcher");
        checkArgumentIsNotNull(parameterTypes, "parameterTypes");
        checkArgumentIsNotNull(arguments, "arguments");
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            Object methodCallResult = ReflectionHelper.callMethod(method, getActual(), arguments);
            matcherAssertion(methodCallResult, (Matcher<Object>) matcher, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.METHOD_CALL_RESULT).addExpected(executableDescription).build();
        }
        return (R) this;
    }

    /**
     * Make assertion about the actual value's method call result.
     *
     * @param methodName the method name.
     * @param matcher    the hamcrest matcher.
     * @param arguments  the arguments used to call the method.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toMethodCallResult(final String methodName, final Matcher<?> matcher, final Object... arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(matcher, "matcher");
        checkArgumentIsNotNull(arguments, "arguments");
        Class<?>[] parameterTypes = ReflectionHelper.getParameterTypes(arguments);
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            Object methodCallResult = ReflectionHelper.callMethod(method, getActual(), arguments);
            matcherAssertion(methodCallResult, (Matcher<Object>) matcher, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.METHOD_CALL_RESULT).addExpected(executableDescription).build();
        }
        return (R) this;
    }

    /**
     * Make assertion about the actual value's method call exception.
     *
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     *
     * @return the assertion.
     */
    public final ThrowableAssertion toMethodCallException(final String methodName, final Class<?>[] parameterTypes, final Object[] arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(parameterTypes, "parameterTypes");
        checkArgumentIsNotNull(arguments, "arguments");
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            ReflectionHelper.callMethod(method, getActual(), arguments);
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.METHOD_CALL_EXCEPTION).addExpected(executableDescription).build();
        } catch (ReflectionException ex) {
            Throwable reflectiveOperationException = ex.getCause();
            Throwable cause = reflectiveOperationException.getCause();
            return initializeAssertion(Raw.throwableAssertion(), cause, Messages.Check.METHOD_CALL_EXCEPTION, executableDescription);
        }
    }

    /**
     * Make assertion about the actual value's method call exception.
     *
     * @param methodName the method name.
     * @param arguments  the arguments used to call the method.
     *
     * @return the assertion.
     */
    public final ThrowableAssertion toMethodCallException(final String methodName, final Object... arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(arguments, "arguments");
        Class<?>[] parameterTypes = ReflectionHelper.getParameterTypes(arguments);
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            ReflectionHelper.callMethod(method, getActual(), arguments);
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.METHOD_CALL_EXCEPTION).addExpected(executableDescription).build();
        } catch (ReflectionException ex) {
            Throwable reflectiveOperationException = ex.getCause();
            Throwable cause = reflectiveOperationException.getCause();
            return initializeAssertion(Raw.throwableAssertion(), cause, Messages.Check.METHOD_CALL_EXCEPTION, executableDescription);
        }
    }

    /**
     * Make assertion about the actual value's method call exception.
     *
     * @param methodName     the method name.
     * @param matcher        the hamcrest matcher.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toMethodCallException(final String methodName, final Matcher<? super Throwable> matcher, final Class<?>[] parameterTypes, final Object[] arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(matcher, "matcher");
        checkArgumentIsNotNull(parameterTypes, "parameterTypes");
        checkArgumentIsNotNull(arguments, "arguments");
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            ReflectionHelper.callMethod(method, getActual(), arguments);
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.METHOD_CALL_EXCEPTION).addExpected(executableDescription).build();
        } catch (ReflectionException ex) {
            Throwable reflectiveOperationException = ex.getCause();
            Throwable cause = reflectiveOperationException.getCause();
            matcherAssertion(cause, matcher, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        }
        return (R) this;
    }

    /**
     * Make assertion about the actual value's method call exception.
     *
     * @param methodName the method name.
     * @param matcher    the hamcrest matcher.
     * @param arguments  the arguments used to call the method.
     *
     * @return current object for the chain call.
     */
    @SuppressWarnings("unchecked")
    public final R toMethodCallException(final String methodName, final Matcher<? super Throwable> matcher, final Object... arguments) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(methodName, "methodName");
        checkArgumentIsNotNull(matcher, "matcher");
        checkArgumentIsNotNull(arguments, "arguments");
        Class<?>[] parameterTypes = ReflectionHelper.getParameterTypes(arguments);
        ExecutableDescription executableDescription = new ExecutableDescription(methodName, parameterTypes);
        Method method;
        try {
            method = ReflectionHelper.getMethod(getActual(), methodName, parameterTypes);
        } catch (ReflectionException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).addMessage(Messages.Fail.Actual.CONTAINS_METHOD).addExpected(executableDescription).build();
        }
        try {
            ReflectionHelper.callMethod(method, getActual(), arguments);
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.METHOD_CALL_EXCEPTION).addExpected(executableDescription).build();
        } catch (ReflectionException ex) {
            Throwable reflectiveOperationException = ex.getCause();
            Throwable cause = reflectiveOperationException.getCause();
            matcherAssertion(cause, matcher, Messages.Check.METHOD_CALL_RESULT, executableDescription);
        }
        return (R) this;
    }

    /**
     * Make the private class element accessible.
     *
     * @param accessibleObject the private class element.
     */
    protected final void setAccessible(final AccessibleObject accessibleObject) {
        ReflectionHelper.setAccessible(accessibleObject);
    }

}
