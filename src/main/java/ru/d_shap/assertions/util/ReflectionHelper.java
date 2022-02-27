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
package ru.d_shap.assertions.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

import ru.d_shap.assertions.converter.ValueConverter;

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
                return currentClazz.getDeclaredField(fieldName);
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
        return getFieldValue(field, object, true);
    }

    static <T> Object getFieldValue(final Field field, final T object, final boolean setAccessible) {
        try {
            if (setAccessible) {
                setAccessible(field);
            }
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
                return currentClazz.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException ex) {
                if (noSuchMethodException == null) {
                    noSuchMethodException = ex;
                }
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
        return callMethod(method, object, true, arguments);
    }

    static <T> Object callMethod(final Method method, final T object, final boolean setAccessible, final Object[] arguments) {
        try {
            if (setAccessible) {
                setAccessible(method);
            }
            return method.invoke(object, arguments);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified method.
     *
     * @param object         the object.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     * @param <T>            the generic type of the class.
     *
     * @return the result of the method call.
     */
    public static <T> Object callMethod(final T object, final String methodName, final Class<?>[] parameterTypes, final Object[] arguments) {
        Method method = getMethod(object, methodName, parameterTypes);
        return callMethod(method, object, arguments);
    }

    /**
     * Call the specified method.
     * Method with primitive parameters will not be called, use the overloaded method with parameter types.
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
        return callMethod(object, methodName, parameterTypes, arguments);
    }

    /**
     * Call the specified method.
     *
     * @param clazz          the class.
     * @param object         the object or null for static method.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param arguments      the arguments used to call the method.
     * @param <T>            the generic type of the class.
     *
     * @return the result of the method call.
     */
    public static <T> Object callMethod(final Class<T> clazz, final T object, final String methodName, final Class<?>[] parameterTypes, final Object[] arguments) {
        Method method = getMethod(clazz, methodName, parameterTypes);
        return callMethod(method, object, arguments);
    }

    /**
     * Call the specified method.
     * Method with primitive parameters will not be called, use the overloaded method with parameter types.
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
        return callMethod(clazz, object, methodName, parameterTypes, arguments);
    }

    /**
     * Get all class constructors.
     *
     * @param clazz the class.
     * @param <T>   the generic type of the class.
     *
     * @return all class constructors.
     */
    @SuppressWarnings("unchecked")
    public static <T> Constructor<T>[] getConstructors(final Class<T> clazz) {
        return (Constructor<T>[]) clazz.getDeclaredConstructors();
    }

    /**
     * Get the specified class constructor.
     *
     * @param clazz          the class.
     * @param parameterTypes the constructor parameter types.
     * @param <T>            the generic type of the class.
     *
     * @return the specified class constructor.
     */
    public static <T> Constructor<T> getConstructor(final Class<T> clazz, final Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified class constructor.
     *
     * @param constructor the specified class constructor.
     * @param arguments   the arguments used to call the constructor.
     * @param <T>         the generic type of the class.
     *
     * @return the object created.
     */
    public static <T> T callConstructor(final Constructor<T> constructor, final Object... arguments) {
        return callConstructor(constructor, true, arguments);
    }

    static <T> T callConstructor(final Constructor<T> constructor, final boolean setAccessible, final Object[] arguments) {
        try {
            if (setAccessible) {
                setAccessible(constructor);
            }
            return constructor.newInstance(arguments);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException ex) {
            throw new ReflectionException(ex);
        }
    }

    /**
     * Call the specified class constructor.
     *
     * @param clazz          the class.
     * @param parameterTypes the constructor parameter types.
     * @param arguments      the arguments used to call the constructor.
     * @param <T>            the generic type of the class.
     *
     * @return the object created.
     */
    public static <T> T callConstructor(final Class<T> clazz, final Class<?>[] parameterTypes, final Object[] arguments) {
        Constructor<T> constructor = getConstructor(clazz, parameterTypes);
        return callConstructor(constructor, arguments);
    }

    /**
     * Call the specified class constructor.
     * Constructor with primitive parameters will not be called, use the overloaded method with parameter types.
     *
     * @param clazz     the class.
     * @param arguments the arguments used to call the constructor.
     * @param <T>       the generic type of the class.
     *
     * @return the object created.
     */
    public static <T> T callConstructor(final Class<T> clazz, final Object... arguments) {
        Class<?>[] parameterTypes = getParameterTypes(arguments);
        return callConstructor(clazz, parameterTypes, arguments);
    }

    /**
     * Get the parameter types for the specified arguments.
     *
     * @param arguments the specified arguments.
     *
     * @return the parameter types.
     */
    public static Class<?>[] getParameterTypes(final Object... arguments) {
        return ValueConverter.convert(arguments, Class[].class);
    }

    /**
     * Make the private class element accessible.
     *
     * @param accessibleObject the private class element.
     */
    public static void setAccessible(final AccessibleObject accessibleObject) {
        AccessController.doPrivileged(new PrivilegedAccessAction(accessibleObject));
    }

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
