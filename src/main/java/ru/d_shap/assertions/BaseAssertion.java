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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion {

    private final Object _actual;

    private final String _message;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    protected BaseAssertion(final Object actual, final String message) {
        super();
        _actual = actual;
        _message = message;
    }

    /**
     * Make assertion of specified type about the same actual.
     *
     * @param assertionClass class of the assertion.
     * @param <T>            type of the assertion.
     * @return the assertion.
     */
    public final <T extends BaseAssertion> T as(final Class<T> assertionClass) {
        checkArgumentIsNotNull(assertionClass);
        try {
            List<Constructor<T>> constructors = getConstructors(assertionClass);
            if (constructors.size() == 1) {
                Constructor<T> constructor = constructors.get(0);
                return constructor.newInstance(_actual, _message);
            } else {
                if (_actual == null) {
                    throw new WrongAssertionClassError(assertionClass);
                } else {
                    throw new WrongAssertionClassError(assertionClass, _actual.getClass());
                }
            }
        } catch (InvocationTargetException ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof AssertionError) {
                throw (AssertionError) cause;
            } else {
                throw new WrongAssertionClassError(assertionClass, ex);
            }
        } catch (ReflectiveOperationException ex) {
            throw new WrongAssertionClassError(assertionClass, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends BaseAssertion> List<Constructor<T>> getConstructors(final Class<T> assertionClass) {
        List<Constructor<T>> constructors = new ArrayList<>();
        for (Constructor constructor : assertionClass.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 2 && isCompatibleTypes(_actual, parameterTypes[0]) && parameterTypes[1].isAssignableFrom(String.class)) {
                constructors.add((Constructor<T>) constructor);
            }
        }
        return constructors;
    }

    static boolean isCompatibleTypes(final Object actual, final Class<?> targetClass) {
        return actual == null && !targetClass.isPrimitive() || actual != null && (targetClass.isAssignableFrom(actual.getClass()) || isActualToPrimitiveAssignable(actual.getClass(), targetClass));
    }

    private static boolean isActualToPrimitiveAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return isActualToPrimitiveByteAssignable(actualClass, targetClass) || isActualToPrimitiveShortAssignable(actualClass, targetClass) || isActualToPrimitiveIntAssignable(actualClass, targetClass) || isActualToPrimitiveLongAssignable(actualClass, targetClass) || isActualToPrimitiveFloatAssignable(actualClass, targetClass) || isActualToPrimitiveDoubleAssignable(actualClass, targetClass) || isActualToPrimitiveBooleanAssignable(actualClass, targetClass) || isActualToPrimitiveCharAssignable(actualClass, targetClass);
    }

    private static boolean isActualToPrimitiveByteAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return actualClass.equals(Byte.class) && targetClass.equals(byte.class);
    }

    private static boolean isActualToPrimitiveShortAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return (actualClass.equals(Byte.class) || actualClass.equals(Short.class)) && targetClass.equals(short.class);
    }

    private static boolean isActualToPrimitiveIntAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return (actualClass.equals(Byte.class) || actualClass.equals(Short.class) || actualClass.equals(Integer.class) || actualClass.equals(Character.class)) && targetClass.equals(int.class);
    }

    private static boolean isActualToPrimitiveLongAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return (actualClass.equals(Byte.class) || actualClass.equals(Short.class) || actualClass.equals(Integer.class) || actualClass.equals(Long.class) || actualClass.equals(Character.class)) && targetClass.equals(long.class);
    }

    private static boolean isActualToPrimitiveFloatAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return (actualClass.equals(Byte.class) || actualClass.equals(Short.class) || actualClass.equals(Integer.class) || actualClass.equals(Long.class) || actualClass.equals(Float.class) || actualClass.equals(Character.class)) && targetClass.equals(float.class);
    }

    private static boolean isActualToPrimitiveDoubleAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return (actualClass.equals(Byte.class) || actualClass.equals(Short.class) || actualClass.equals(Integer.class) || actualClass.equals(Long.class) || actualClass.equals(Float.class) || actualClass.equals(Double.class) || actualClass.equals(Character.class)) && targetClass.equals(double.class);
    }

    private static boolean isActualToPrimitiveBooleanAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return actualClass.equals(Boolean.class) && targetClass.equals(boolean.class);
    }

    private static boolean isActualToPrimitiveCharAssignable(final Class<?> actualClass, final Class<?> targetClass) {
        return actualClass.equals(Character.class) && targetClass.equals(char.class);
    }

    /**
     * Get the actual value.
     *
     * @return the actual value.
     */
    protected final Object getActual() {
        return _actual;
    }

    /**
     * Get the assertion message.
     *
     * @return the assertion message.
     */
    protected final String getMessage() {
        return _message;
    }

    /**
     * Check if the actual value is NOT null.
     */
    protected final void checkActualIsNotNull() {
        if (_actual == null) {
            throw createAssertionError(FailMessages.getIsNotNull());
        }
    }

    /**
     * Check if the argument is NOT null.
     *
     * @param argument the argument.
     */
    protected final void checkArgumentIsNotNull(final Object argument) {
        if (argument == null) {
            throw createAssertionError(FailMessages.getArgumentIsNotNull());
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always true.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyTrue(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(FailMessages.getArgumentIsNotEmptyTrue());
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always false.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyFalse(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(FailMessages.getArgumentIsNotEmptyFalse());
        }
    }

    /**
     * Create new assertion error.
     *
     * @param failMessage the fail message.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String failMessage) {
        return createAssertionError(failMessage, null);
    }

    /**
     * Create new assertion error.
     *
     * @param throwable the cause of the failure.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Throwable throwable) {
        return createAssertionError(null, throwable);
    }

    /**
     * Create new assertion error.
     *
     * @param failMessage the fail message.
     * @param throwable   the cause of the failure.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String failMessage, final Throwable throwable) {
        String fullMessage = getFullAssertionMessage(_message, failMessage, throwable);
        if (throwable == null) {
            return new AssertionError(fullMessage);
        } else {
            return new AssertionError(fullMessage, throwable);
        }
    }

    private static String getFullAssertionMessage(final String assertionMessage, final String failMessage, final Throwable throwable) {
        String assertionMessagePart = getAssertionMessagePart(assertionMessage);
        String failMessagePart = getFailMessagePart(failMessage, throwable);
        if ("".equals(failMessagePart)) {
            return assertionMessagePart;
        } else {
            if ("".equals(assertionMessagePart)) {
                return failMessagePart;
            } else {
                return assertionMessagePart + " " + failMessagePart;
            }
        }
    }

    private static String getAssertionMessagePart(final String assertionMessage) {
        if (assertionMessage == null || "".equals(assertionMessage)) {
            return "";
        } else {
            if (assertionMessage.endsWith(".")) {
                return assertionMessage;
            } else {
                return assertionMessage + ".";
            }
        }
    }

    private static String getFailMessagePart(final String failMessage, final Throwable throwable) {
        if (failMessage == null || "".equals(failMessage)) {
            if (throwable == null) {
                return "";
            } else {
                return throwable.toString();
            }
        } else {
            return failMessage;
        }
    }

    /**
     * Get the string representation of the actual value.
     *
     * @return the string representation of the actual value.
     */
    protected final String actualAsString() {
        return asString(_actual);
    }

    /**
     * Get the string representation of the value.
     *
     * @param value the value.
     * @return the string representation of the value.
     */
    protected abstract String asString(Object value);

}
