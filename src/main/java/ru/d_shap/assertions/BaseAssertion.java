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
     * Make another type assertion about the same actual.
     *
     * @param clazz class of the assertion.
     * @param <T>   type of the assertion.
     * @return the assertion.
     */
    public final <T extends BaseAssertion> T as(final Class<T> clazz) {
        try {
            List<Constructor<T>> constructors = getConstructors(clazz);
            if (constructors.size() == 1) {
                Constructor<T> constructor = constructors.get(0);
                return constructor.newInstance(_actual, _message);
            } else {
                throw new WrongAssertionClassError(clazz, _actual.getClass());
            }
        } catch (IllegalAccessException ex) {
            throw new WrongAssertionClassError(clazz, ex);
        } catch (InvocationTargetException ex) {
            throw new WrongAssertionClassError(clazz, ex);
        } catch (InstantiationException ex) {
            throw new WrongAssertionClassError(clazz, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends BaseAssertion> List<Constructor<T>> getConstructors(final Class<T> clazz) {
        List<Constructor<T>> result = new ArrayList<>();
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 2 && isCompatibleTypes(parameterTypes[0]) && parameterTypes[1].isAssignableFrom(String.class)) {
                result.add((Constructor<T>) constructor);
            }
        }
        return result;
    }

    private boolean isCompatibleTypes(final Class<?> clazz) {
        return clazz.isAssignableFrom(_actual.getClass()) || isActualToPrimitiveAssignable(clazz);
    }

    private boolean isActualToPrimitiveAssignable(final Class<?> clazz) {
        return isActualToPrimitiveByteAssignable(clazz) || isActualToPrimitiveShortAssignable(clazz) || isActualToPrimitiveIntAssignable(clazz) || isActualToPrimitiveLongAssignable(clazz) || isActualToPrimitiveFloatAssignable(clazz) || isActualToPrimitiveDoubleAssignable(clazz) || isActualToPrimitiveBooleanAssignable(clazz) || isActualToPrimitiveCharAssignable(clazz);
    }

    private boolean isActualToPrimitiveByteAssignable(final Class<?> clazz) {
        return _actual.getClass().equals(Byte.class) && clazz.equals(byte.class);
    }

    private boolean isActualToPrimitiveShortAssignable(final Class<?> clazz) {
        return (_actual.getClass().equals(Byte.class) || _actual.getClass().equals(Short.class)) && clazz.equals(short.class);
    }

    private boolean isActualToPrimitiveIntAssignable(final Class<?> clazz) {
        return (_actual.getClass().equals(Byte.class) || _actual.getClass().equals(Short.class) || _actual.getClass().equals(Integer.class) || _actual.getClass().equals(Character.class)) && clazz.equals(int.class);
    }

    private boolean isActualToPrimitiveLongAssignable(final Class<?> clazz) {
        return (_actual.getClass().equals(Byte.class) || _actual.getClass().equals(Short.class) || _actual.getClass().equals(Integer.class) || _actual.getClass().equals(Long.class) || _actual.getClass().equals(Character.class)) && clazz.equals(long.class);
    }

    private boolean isActualToPrimitiveFloatAssignable(final Class<?> clazz) {
        return (_actual.getClass().equals(Byte.class) || _actual.getClass().equals(Short.class) || _actual.getClass().equals(Integer.class) || _actual.getClass().equals(Long.class) || _actual.getClass().equals(Float.class) || _actual.getClass().equals(Character.class)) && clazz.equals(float.class);
    }

    private boolean isActualToPrimitiveDoubleAssignable(final Class<?> clazz) {
        return (_actual.getClass().equals(Byte.class) || _actual.getClass().equals(Short.class) || _actual.getClass().equals(Integer.class) || _actual.getClass().equals(Long.class) || _actual.getClass().equals(Float.class) || _actual.getClass().equals(Double.class) || _actual.getClass().equals(Character.class)) && clazz.equals(double.class);
    }

    private boolean isActualToPrimitiveBooleanAssignable(final Class<?> clazz) {
        return _actual.getClass().equals(Boolean.class) && clazz.equals(boolean.class);
    }

    private boolean isActualToPrimitiveCharAssignable(final Class<?> clazz) {
        return _actual.getClass().equals(Character.class) && clazz.equals(char.class);
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
        String fullMessage = getFullAssertionMessage(_message, failMessage);
        return new AssertionError(fullMessage);
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
        String fullMessage = getFullAssertionMessage(_message, failMessage);
        if ("".equals(fullMessage)) {
            if (throwable == null) {
                return new AssertionError(fullMessage);
            } else {
                return new AssertionError(throwable);
            }
        } else {
            return new AssertionError(fullMessage, throwable);
        }
    }

    private static String getFullAssertionMessage(final String assertionMessage, final String failMessage) {
        String fullMessage = getAssertionMessagePart(assertionMessage);
        if (failMessage != null && !"".equals(failMessage)) {
            if (!"".equals(fullMessage)) {
                fullMessage += " ";
            }
            fullMessage += failMessage;
        }
        return fullMessage;
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
