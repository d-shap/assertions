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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Class to make the private class elements accessible.
 *
 * @author Dmitry Shapovalov
 */
public final class PrivateAccessor {

    private PrivateAccessor() {
        super();
    }

    /**
     * Get the specified field.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @param <T>       the generic type of the class.
     *
     * @return the specified field.
     *
     * @throws NoSuchFieldException if the specified field can not be found.
     */
    @SuppressWarnings("unchecked")
    public static <T> Field getField(final T object, final String fieldName) throws NoSuchFieldException {
        return getField((Class<T>) object.getClass(), object, fieldName);
    }

    /**
     * Get the specified field.
     *
     * @param clazz     the class.
     * @param object    the object or null for static field.
     * @param fieldName the field name.
     * @param <T>       the generic type of the class.
     *
     * @return the specified field.
     *
     * @throws NoSuchFieldException if the specified field can not be found.
     */
    public static <T> Field getField(final Class<T> clazz, final T object, final String fieldName) throws NoSuchFieldException {
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
        throw noSuchFieldException;
    }

    /**
     * Get the value of the specified field.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @param <T>       the generic type of the class.
     *
     * @return the value of the specified field.
     *
     * @throws NoSuchFieldException   if the specified field can not be found.
     * @throws IllegalAccessException if the specified field is not accessible.
     */
    public static <T> Object getFieldValue(final T object, final String fieldName) throws NoSuchFieldException, IllegalAccessException {
        return getField(object, fieldName).get(object);
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
     *
     * @throws NoSuchFieldException   if the specified field can not be found.
     * @throws IllegalAccessException if the specified field is not accessible.
     */
    public static <T> Object getFieldValue(final Class<T> clazz, final T object, final String fieldName) throws NoSuchFieldException, IllegalAccessException {
        return getField(clazz, object, fieldName).get(object);
    }

    /**
     * Get the specified method.
     *
     * @param object         the object.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param <T>            the generic type of the class.
     *
     * @return the specified method.
     *
     * @throws NoSuchMethodException if the specified method can not be found.
     */
    @SuppressWarnings("unchecked")
    public static <T> Method getMethod(final T object, final String methodName, final Class<?>... parameterTypes) throws NoSuchMethodException {
        return getMethod((Class<T>) object.getClass(), object, methodName, parameterTypes);
    }

    /**
     * Get the specified method.
     *
     * @param clazz          the class.
     * @param object         the object or null for static method.
     * @param methodName     the method name.
     * @param parameterTypes the method parameter types.
     * @param <T>            the generic type of the class.
     *
     * @return the specified method.
     *
     * @throws NoSuchMethodException if the specified method can not be found.
     */
    public static <T> Method getMethod(final Class<T> clazz, final T object, final String methodName, final Class<?>... parameterTypes) throws NoSuchMethodException {
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
        throw noSuchMethodException;
    }

    /**
     * Get the specified constructor.
     *
     * @param clazz          the class.
     * @param parameterTypes the constructor parameter types.
     * @param <T>            the generic type of the class.
     *
     * @return the specified constructor.
     *
     * @throws NoSuchMethodException if the specified constructor can not be found.
     */
    public static <T> Constructor<T> getConstructor(final Class<T> clazz, final Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
        setAccessible(constructor);
        return constructor;
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
