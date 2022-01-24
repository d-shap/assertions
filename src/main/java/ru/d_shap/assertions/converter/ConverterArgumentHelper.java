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
     * Get the value, casted to the target class.
     *
     * @param value the value.
     * @param clazz the target class.
     * @param <T>   the generic type of the target class.
     *
     * @return the value, casted to the target class.
     */
    public static <T> T getValue(final Object value, final Class<T> clazz) {
        value.getClass();
        return clazz.cast(value);
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Byte[] toObjectArray(final byte[] array) {
        if (array == null) {
            return null;
        } else {
            Byte[] result = new Byte[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Short[] toObjectArray(final short[] array) {
        if (array == null) {
            return null;
        } else {
            Short[] result = new Short[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Integer[] toObjectArray(final int[] array) {
        if (array == null) {
            return null;
        } else {
            Integer[] result = new Integer[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Long[] toObjectArray(final long[] array) {
        if (array == null) {
            return null;
        } else {
            Long[] result = new Long[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Float[] toObjectArray(final float[] array) {
        if (array == null) {
            return null;
        } else {
            Float[] result = new Float[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Double[] toObjectArray(final double[] array) {
        if (array == null) {
            return null;
        } else {
            Double[] result = new Double[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Boolean[] toObjectArray(final boolean[] array) {
        if (array == null) {
            return null;
        } else {
            Boolean[] result = new Boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Convert the primitive array to the object array.
     *
     * @param array the primitive array.
     *
     * @return the object array.
     */
    public static Character[] toObjectArray(final char[] array) {
        if (array == null) {
            return null;
        } else {
            Character[] result = new Character[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    /**
     * Check the argument array length.
     *
     * @param arguments the argument array.
     * @param length    the length.
     */
    public static void checkArgumentsLength(final Object[] arguments, final int length) {
        if (arguments.length != length) {
            throw new ArrayIndexOutOfBoundsException(arguments.length);
        }
    }

    /**
     * Get the argument value, casted to the target class.
     *
     * @param arguments the argument array.
     * @param index     the index of the argument in the argument array.
     * @param clazz     the target class.
     * @param <T>       the generic type of the target class.
     *
     * @return the argument value, casted to the target class.
     */
    public static <T> T getArgument(final Object[] arguments, final int index, final Class<T> clazz) {
        if (index >= 0 && index < arguments.length) {
            Object value = arguments[index];
            return clazz.cast(value);
        } else {
            throw new ArrayIndexOutOfBoundsException(arguments.length);
        }
    }

}
