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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to convert the actual and the expected values to another type.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverter {

    private ValueConverter() {
        super();
    }

    /**
     * Convert the byte array to the byte list.
     *
     * @param array the byte array.
     * @return the byte list.
     */
    public static List<Byte> toByteList(final byte... array) {
        List<Byte> list = new ArrayList<>(array.length);
        for (byte value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the byte iterable to the byte list.
     *
     * @param iterable the byte iterable.
     * @return the byte list.
     */
    public static List<Byte> toByteList(final Iterable<Byte> iterable) {
        List<Byte> list = new ArrayList<>();
        for (Byte value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the short array to the short list.
     *
     * @param array the short array.
     * @return the short list.
     */
    public static List<Short> toShortList(final short... array) {
        List<Short> list = new ArrayList<>(array.length);
        for (short value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the short iterable to the short list.
     *
     * @param iterable the short iterable.
     * @return the short list.
     */
    public static List<Short> toShortList(final Iterable<Short> iterable) {
        List<Short> list = new ArrayList<>();
        for (Short value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the int array to the integer list.
     *
     * @param array the int array.
     * @return the integer list.
     */
    public static List<Integer> toIntegerList(final int... array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the integer iterable to the integer list.
     *
     * @param iterable the integer iterable.
     * @return the integer list.
     */
    public static List<Integer> toIntegerList(final Iterable<Integer> iterable) {
        List<Integer> list = new ArrayList<>();
        for (Integer value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the long array to the long list.
     *
     * @param array the long array.
     * @return the long list.
     */
    public static List<Long> toLongList(final long... array) {
        List<Long> list = new ArrayList<>(array.length);
        for (long value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the long iterable to the long list.
     *
     * @param iterable the long iterable.
     * @return the long list.
     */
    public static List<Long> toLongList(final Iterable<Long> iterable) {
        List<Long> list = new ArrayList<>();
        for (Long value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the float array to the float list.
     *
     * @param array the float array.
     * @return the float list.
     */
    public static List<Float> toFloatList(final float... array) {
        List<Float> list = new ArrayList<>(array.length);
        for (float value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the float iterable to the float list.
     *
     * @param iterable the float iterable.
     * @return the float list.
     */
    public static List<Float> toFloatList(final Iterable<Float> iterable) {
        List<Float> list = new ArrayList<>();
        for (Float value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the double array to the double list.
     *
     * @param array the double array.
     * @return the double list.
     */
    public static List<Double> toDoubleList(final double... array) {
        List<Double> list = new ArrayList<>(array.length);
        for (double value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the double iterable to the double list.
     *
     * @param iterable the double iterable.
     * @return the double list.
     */
    public static List<Double> toDoubleList(final Iterable<Double> iterable) {
        List<Double> list = new ArrayList<>();
        for (Double value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the boolean array to the boolean list.
     *
     * @param array the boolean array.
     * @return the boolean list.
     */
    public static List<Boolean> toBooleanList(final boolean... array) {
        List<Boolean> list = new ArrayList<>(array.length);
        for (boolean value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the boolean iterable to the boolean list.
     *
     * @param iterable the boolean iterable.
     * @return the boolean list.
     */
    public static List<Boolean> toBooleanList(final Iterable<Boolean> iterable) {
        List<Boolean> list = new ArrayList<>();
        for (Boolean value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the char array to the character list.
     *
     * @param array the char array.
     * @return the character list.
     */
    public static List<Character> toCharacterList(final char... array) {
        List<Character> list = new LinkedList<>();
        for (char value : array) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the character iterable to the character list.
     *
     * @param iterable the character iterable.
     * @return the character list.
     */
    public static List<Character> toCharacterList(final Iterable<Character> iterable) {
        List<Character> list = new ArrayList<>();
        for (Character value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the object array to the object list.
     *
     * @param array the object array.
     * @param <E>   the generic type of the element.
     * @return the object list.
     */
    @SafeVarargs
    public static <E> List<E> toObjectList(final E... array) {
        return Arrays.asList(array);
    }

    /**
     * Convert the object iterable to the object list.
     *
     * @param iterable the object iterable.
     * @param <E>      the generic type of the element.
     * @return the object list.
     */
    public static <E> List<E> toObjectList(final Iterable<E> iterable) {
        List<E> list = new ArrayList<>();
        for (E value : iterable) {
            list.add(value);
        }
        return list;
    }

    /**
     * Convert the byte array to the byte object array.
     *
     * @param array the byte array.
     * @return the byte object array.
     */
    public static Byte[] toByteObjectArray(final byte... array) {
        Byte[] list = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the int array to the byte object array.
     *
     * @param array the int array.
     * @return the byte object array.
     */
    public static Byte[] toByteObjectArray(final int... array) {
        Byte[] list = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = (byte) array[i];
        }
        return list;
    }

    /**
     * Convert the short array to the short object array.
     *
     * @param array the short array.
     * @return the short object array.
     */
    public static Short[] toShortObjectArray(final short... array) {
        Short[] list = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the int array to the short object array.
     *
     * @param array the int array.
     * @return the short object array.
     */
    public static Short[] toShortObjectArray(final int... array) {
        Short[] list = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = (short) array[i];
        }
        return list;
    }

    /**
     * Convert the int array to the integer object array.
     *
     * @param array the int array.
     * @return the integer object array.
     */
    public static Integer[] toIntegerObjectArray(final int... array) {
        Integer[] list = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the long array to the long object array.
     *
     * @param array the long array.
     * @return the long object array.
     */
    public static Long[] toLongObjectArray(final long... array) {
        Long[] list = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the float array to the float object array.
     *
     * @param array the float array.
     * @return the float object array.
     */
    public static Float[] toFloatObjectArray(final float... array) {
        Float[] list = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the double array to the double object array.
     *
     * @param array the double array.
     * @return the double object array.
     */
    public static Double[] toDoubleObjectArray(final double... array) {
        Double[] list = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the boolean array to the boolean object array.
     *
     * @param array the boolean array.
     * @return the boolean object array.
     */
    public static Boolean[] toBooleanObjectArray(final boolean... array) {
        Boolean[] list = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the char array to the character object array.
     *
     * @param array the char array.
     * @return the character object array.
     */
    public static Character[] toCharacterObjectArray(final char... array) {
        Character[] list = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = array[i];
        }
        return list;
    }

    /**
     * Convert the int array to the character object array.
     *
     * @param array the int array.
     * @return the character object array.
     */
    public static Character[] toCharacterObjectArray(final int... array) {
        Character[] list = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = (char) array[i];
        }
        return list;
    }

    /**
     * Convert the byte list to the byte array.
     *
     * @param list the byte list.
     * @return the byte array.
     */
    public static byte[] toByteArray(final List<Byte> list) {
        byte[] array = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the byte iterable to the byte array.
     *
     * @param iterable the byte iterable.
     * @return the byte array.
     */
    public static byte[] toByteArray(final Iterable<Byte> iterable) {
        List<Byte> list = toByteList(iterable);
        return toByteArray(list);
    }

    /**
     * Convert the short list to the short array.
     *
     * @param list the short list.
     * @return the short array.
     */
    public static short[] toShortArray(final List<Short> list) {
        short[] array = new short[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the short iterable to the short array.
     *
     * @param iterable the short iterable.
     * @return the short array.
     */
    public static short[] toShortArray(final Iterable<Short> iterable) {
        List<Short> list = toShortList(iterable);
        return toShortArray(list);
    }

    /**
     * Convert the integer list to the int array.
     *
     * @param list the integer list.
     * @return the int array.
     */
    public static int[] toIntArray(final List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the integer iterable to the int array.
     *
     * @param iterable the integer iterable.
     * @return the int array.
     */
    public static int[] toIntArray(final Iterable<Integer> iterable) {
        List<Integer> list = toIntegerList(iterable);
        return toIntArray(list);
    }

    /**
     * Convert the long list to the long array.
     *
     * @param list the long list.
     * @return the long array.
     */
    public static long[] toLongArray(final List<Long> list) {
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the long iterable to the long array.
     *
     * @param iterable the long iterable.
     * @return the long array.
     */
    public static long[] toLongArray(final Iterable<Long> iterable) {
        List<Long> list = toLongList(iterable);
        return toLongArray(list);
    }

    /**
     * Convert the float list to the float array.
     *
     * @param list the float list.
     * @return the float array.
     */
    public static float[] toFloatArray(final List<Float> list) {
        float[] array = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the float iterable to the float array.
     *
     * @param iterable the float iterable.
     * @return the float array.
     */
    public static float[] toFloatArray(final Iterable<Float> iterable) {
        List<Float> list = toFloatList(iterable);
        return toFloatArray(list);
    }

    /**
     * Convert the double list to the double array.
     *
     * @param list the double list.
     * @return the double array.
     */
    public static double[] toDoubleArray(final List<Double> list) {
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the double iterable to the double array.
     *
     * @param iterable the double iterable.
     * @return the double array.
     */
    public static double[] toDoubleArray(final Iterable<Double> iterable) {
        List<Double> list = toDoubleList(iterable);
        return toDoubleArray(list);
    }

    /**
     * Convert the boolean list to the boolean array.
     *
     * @param list the boolean list.
     * @return the boolean array.
     */
    public static boolean[] toBooleanArray(final List<Boolean> list) {
        boolean[] array = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the boolean iterable to the boolean array.
     *
     * @param iterable the boolean iterable.
     * @return the boolean array.
     */
    public static boolean[] toBooleanArray(final Iterable<Boolean> iterable) {
        List<Boolean> list = toBooleanList(iterable);
        return toBooleanArray(list);
    }

    /**
     * Convert the character list to the char array.
     *
     * @param list the character list.
     * @return the char array.
     */
    public static char[] toCharArray(final List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Convert the character iterable to the char array.
     *
     * @param iterable the character iterable.
     * @return the char array.
     */
    public static char[] toCharArray(final Iterable<Character> iterable) {
        List<Character> list = toCharacterList(iterable);
        return toCharArray(list);
    }

    /**
     * Convert the object list to the object array. The result array shoud be used only to read values.
     *
     * @param list the object list.
     * @param <E>  the generic type of the element.
     * @return the object array.
     */
    @SuppressWarnings("unchecked")
    public static <E> E[] toObjectArray(final List<E> list) {
        Object[] array = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return (E[]) array;
    }

    /**
     * Convert the object iterable to the object array. The result array shoud be used only to read values.
     *
     * @param iterable the object iterable.
     * @param <E>      the generic type of the element.
     * @return the object array.
     */
    public static <E> E[] toObjectArray(final Iterable<E> iterable) {
        List<E> list = toObjectList(iterable);
        return toObjectArray(list);
    }

}
