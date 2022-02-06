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
package ru.d_shap.assertions.data;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Helper class to perform reflection operations.
 *
 * @author Dmitry Shapovalov
 */
public final class ReflectionHelper {

    private ReflectionHelper() {
        super();
    }

    /**
     * Get the specified field.
     *
     * @param object    the object.
     * @param fieldName the field name.
     *
     * @return the specified field.
     */
    public static Field getField(final Object object, final String fieldName) {
        return getField(object.getClass(), fieldName);
    }

    /**
     * Get the specified field.
     *
     * @param clazz     the class.
     * @param fieldName the field name.
     *
     * @return the specified field.
     */
    public static Field getField(final Class<?> clazz, final String fieldName) {
        clazz.getName();
        Class<?> currentClazz = clazz;
        NoSuchFieldException noSuchFieldException = null;
        while (currentClazz != null) {
            try {
                Field field = currentClazz.getDeclaredField(fieldName);
                setAccessible(field);
                return field;
            } catch (NoSuchFieldException ex) {
                noSuchFieldException = ex;
                currentClazz = currentClazz.getSuperclass();
            }
        }
        throw new ReflectionException(noSuchFieldException);
    }

    /**
     * Get the value of the specified field.
     *
     * @param field  the specified field.
     * @param object the object or null for static field.
     * @param <T>    the generic type of the class.
     *
     * @return the value of the specified field.
     */
    public static <T> Object getFieldValue(final Field field, final T object) {
        try {
            return field.get(object);
        } catch (IllegalAccessException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Get the value of the specified field.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @param <T>       the generic type of the class.
     *
     * @return the value of the specified field.
     */
    public static <T> Object getFieldValue(final T object, final String fieldName) {
        Field field = getField(object, fieldName);
        return getFieldValue(field, object);
    }

    /**
     * Get the value of the specified field.
     *
     * @param clazz     the class.
     * @param object    the object or null for static field.
     * @param fieldName the field name.
     * @param <T>       the generic type of the class.
     *
     * @return the value of the specified field.
     */
    public static <T> Object getFieldValue(final Class<T> clazz, final T object, final String fieldName) {
        Field field = getField(clazz, fieldName);
        return getFieldValue(field, object);
    }

    /**
     * Get the specified method.
     *
     * @param object         the object.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     *
     * @return the specified method.
     */
    public static Method getMethod(final Object object, final String methodName, final Class<?>... parameterTypes) {
        return getMethod(object.getClass(), methodName, parameterTypes);
    }

    /**
     * Get the specified method.
     *
     * @param clazz          the class.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     *
     * @return the specified method.
     */
    public static Method getMethod(final Class<?> clazz, final String methodName, final Class<?>... parameterTypes) {
        clazz.getName();
        Class<?> currentClazz = clazz;
        NoSuchMethodException noSuchMethodException = null;
        while (currentClazz != null) {
            try {
                Method method = currentClazz.getDeclaredMethod(methodName, parameterTypes);
                setAccessible(method);
                return method;
            } catch (NoSuchMethodException ex) {
                noSuchMethodException = ex;
                currentClazz = currentClazz.getSuperclass();
            }
        }
        throw new ReflectionException(noSuchMethodException);
    }

    /**
     * Call the specified method.
     *
     * @param method    the specified method.
     * @param object    the object or null for static method.
     * @param arguments the arguments used to call the method.
     * @param <T>       the generic type of the class.
     *
     * @return the result of the method call.
     */
    public static <T> Object callMethod(final Method method, final T object, final Object... arguments) {
        try {
            return method.invoke(object, arguments);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified method.
     *
     * @param object     the object.
     * @param methodName the method name.
     * @param arguments  the arguments used to call the method.
     * @param <T>        the generic type of the class.
     *
     * @return the result of the method call.
     */
    public static <T> Object callMethod(final T object, final String methodName, final Object... arguments) {
        Class<?>[] parameterTypes = getParameterTypes(arguments);
        Method method = getMethod(object, methodName, parameterTypes);
        return callMethod(method, object, arguments);
    }

    /**
     * Call the specified method.
     *
     * @param clazz      the class.
     * @param object     the object or null for static method.
     * @param methodName the method name.
     * @param arguments  the arguments used to call the method.
     * @param <T>        the generic type of the class.
     *
     * @return the result of the method call.
     */
    public static <T> Object callMethod(final Class<T> clazz, final T object, final String methodName, final Object... arguments) {
        Class<?>[] parameterTypes = getParameterTypes(arguments);
        Method method = getMethod(clazz, methodName, parameterTypes);
        return callMethod(method, object, arguments);
    }

    private static Class<?>[] getParameterTypes(final Object... arguments) {
        Class<?>[] result = new Class[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            Object argument = arguments[i];
            result[i] = argument.getClass();
        }
        return result;
    }

    /**
     * Get the specified constructor.
     *
     * @param clazz          the class.
     * @param parameterTypes the constructor parameter types.
     * @param <T>            the generic type of the class.
     *
     * @return the specified constructor.
     */
    public static <T> Constructor<T> getConstructor(final Class<T> clazz, final Class<?>... parameterTypes) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
            setAccessible(constructor);
            return constructor;
        } catch (NoSuchMethodException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified constructor.
     *
     * @param constructor the specified constructor.
     * @param arguments   the arguments used to call the constructor.
     * @param <T>         the generic type of the class.
     *
     * @return the object created.
     */
    public static <T> T callConstructor(final Constructor<T> constructor, final Object... arguments) {
        try {
            return constructor.newInstance(arguments);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified constructor.
     *
     * @param clazz     the class.
     * @param arguments the arguments used to call the constructor.
     * @param <T>       the generic type of the class.
     *
     * @return the object created.
     */
    public static <T> T callConstructor(final Class<T> clazz, final Object... arguments) {
        Class<?>[] parameterTypes = getParameterTypes(arguments);
        Constructor<T> constructor = getConstructor(clazz, parameterTypes);
        return callConstructor(constructor, arguments);
    }

    /**
     * Make the private class element accessible.
     *
     * @param accessibleObject the private class element.
     */
    public static void setAccessible(final AccessibleObject accessibleObject) {
        AccessController.doPrivileged(new PrivilegedAccessAction(accessibleObject));
    }

    /**
     * Privileged action to make the private class element accessible.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivilegedAccessAction implements PrivilegedAction<Void> {

        private final AccessibleObject _accessibleObject;

        PrivilegedAccessAction(final AccessibleObject accessibleObject) {
            super();
            _accessibleObject = accessibleObject;
        }

        @Override
        public Void run() {
            _accessibleObject.setAccessible(true);
            return null;
        }

    }

}
