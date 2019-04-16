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
package ru.d_shap.assertions.converter;

/**
 * Helper class to check converter arguments.
 *
 * @author Dmitry Shapovalov
 */
public final class ConverterArgumentHelper {

    private ConverterArgumentHelper() {
        super();
    }

    /**
     * Check the value class.
     *
     * @param value the value.
     * @param clazz the class.
     */
    public static void checkValueClass(final Object value, final Class<?> clazz) {
        value.getClass();
        clazz.cast(value);
    }

    /**
     * Check the argument array length.
     *
     * @param arguments the argument array.
     * @param length    the length.
     */
    public static void checkArgumentsLength(final Object[] arguments, final int length) {
        if (arguments.length > length) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
    }

    /**
     * Check the argument class.
     *
     * @param arguments the argument array.
     * @param index     the index of the argument in the argument array.
     * @param clazz     the class.
     */
    public static void checkArgumentClass(final Object[] arguments, final int index, final Class<?> clazz) {
        if (index >= 0 && index < arguments.length) {
            arguments[index].getClass();
            clazz.cast(arguments[index]);
        }
    }

    /**
     * Get the argument value.
     *
     * @param arguments    the argument array.
     * @param index        the index of the argument in the argument array.
     * @param clazz        the class.
     * @param defaultValue the default argument value, if argument is not provided.
     * @param <T>          the generic type of the argument.
     *
     * @return the argument value.
     */
    public static <T> T getArgument(final Object[] arguments, final int index, final Class<T> clazz, final T defaultValue) {
        if (index >= 0 && index < arguments.length) {
            Object value = arguments[index];
            if (value == null) {
                return defaultValue;
            } else if (clazz.isInstance(value)) {
                return clazz.cast(value);
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

}
