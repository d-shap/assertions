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

import org.junit.Test;

/**
 * Tests for {@link ValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverterTest {

    /**
     * Test class constructor.
     */
    public ValueConverterTest() {
        super();
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ValueConverter.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toByteListTest() {
        Assertions.assertThat(ValueConverter.toByteList()).isEmpty();
        Assertions.assertThat(ValueConverter.toByteList((byte) 1, (byte) 2, (byte) 3)).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
        Assertions.assertThat(ValueConverter.toByteList(new ArrayList<Byte>())).isEmpty();
        Assertions.assertThat(ValueConverter.toByteList(Arrays.asList((byte) 1, (byte) 2, (byte) 3))).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toShortListTest() {
        Assertions.assertThat(ValueConverter.toShortList()).isEmpty();
        Assertions.assertThat(ValueConverter.toShortList((short) 1, (short) 2, (short) 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
        Assertions.assertThat(ValueConverter.toShortList(new ArrayList<Short>())).isEmpty();
        Assertions.assertThat(ValueConverter.toShortList(Arrays.asList((short) 1, (short) 2, (short) 3))).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toIntegerListTest() {
        Assertions.assertThat(ValueConverter.toIntegerList()).isEmpty();
        Assertions.assertThat(ValueConverter.toIntegerList(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.toIntegerList(new ArrayList<Integer>())).isEmpty();
        Assertions.assertThat(ValueConverter.toIntegerList(Arrays.asList(1, 2, 3))).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toLongListTest() {
        Assertions.assertThat(ValueConverter.toLongList()).isEmpty();
        Assertions.assertThat(ValueConverter.toLongList(1L, 2L, 3L)).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertThat(ValueConverter.toLongList(new ArrayList<Long>())).isEmpty();
        Assertions.assertThat(ValueConverter.toLongList(Arrays.asList(1L, 2L, 3L))).containsExactlyInOrder(1L, 2L, 3L);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toFloatListTest() {
        Assertions.assertThat(ValueConverter.toFloatList()).isEmpty();
        Assertions.assertThat(ValueConverter.toFloatList(1.0f, 2.0f, 3.0f)).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertThat(ValueConverter.toFloatList(new ArrayList<Float>())).isEmpty();
        Assertions.assertThat(ValueConverter.toFloatList(Arrays.asList(1.0f, 2.0f, 3.0f))).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toDoubleListTest() {
        Assertions.assertThat(ValueConverter.toDoubleList()).isEmpty();
        Assertions.assertThat(ValueConverter.toDoubleList(1.0, 2.0, 3.0)).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertThat(ValueConverter.toDoubleList(new ArrayList<Double>())).isEmpty();
        Assertions.assertThat(ValueConverter.toDoubleList(Arrays.asList(1.0, 2.0, 3.0))).containsExactlyInOrder(1.0, 2.0, 3.0);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toBooleanListTest() {
        Assertions.assertThat(ValueConverter.toBooleanList()).isEmpty();
        Assertions.assertThat(ValueConverter.toBooleanList(true, true, false)).containsExactlyInOrder(true, true, false);
        Assertions.assertThat(ValueConverter.toBooleanList(new ArrayList<Boolean>())).isEmpty();
        Assertions.assertThat(ValueConverter.toBooleanList(Arrays.asList(true, true, false))).containsExactlyInOrder(true, true, false);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toCharacterListTest() {
        Assertions.assertThat(ValueConverter.toCharacterList()).isEmpty();
        Assertions.assertThat(ValueConverter.toCharacterList('1', '2', '3')).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(ValueConverter.toCharacterList(new ArrayList<Character>())).isEmpty();
        Assertions.assertThat(ValueConverter.toCharacterList(Arrays.asList('1', '2', '3'))).containsExactlyInOrder('1', '2', '3');
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toObjectListTest() {
        Assertions.assertThat(ValueConverter.toObjectList()).isEmpty();
        Assertions.assertThat(ValueConverter.toObjectList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(ValueConverter.toObjectList(new ArrayList<String>())).isEmpty();
        Assertions.assertThat(ValueConverter.toObjectList(Arrays.asList("1", "2", "3"))).containsExactlyInOrder("1", "2", "3");
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toByteObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toByteObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toByteObjectArray((byte) 1, (byte) 2, (byte) 3)).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
        Assertions.assertThat(ValueConverter.toByteObjectArray(new int[0])).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toByteObjectArray(1, 2, 3)).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toShortObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toShortObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toShortObjectArray((short) 1, (short) 2, (short) 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
        Assertions.assertThat(ValueConverter.toShortObjectArray(new int[0])).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toShortObjectArray(1, 2, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toIntegerObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toIntegerObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toIntegerObjectArray(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toLongObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toLongObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toLongObjectArray(1L, 2L, 3L)).containsExactlyInOrder(1L, 2L, 3L);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toFloatObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toFloatObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toFloatObjectArray(1.0f, 2.0f, 3.0f)).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toDoubleObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toDoubleObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toDoubleObjectArray(1.0, 2.0, 3.0)).containsExactlyInOrder(1.0, 2.0, 3.0);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toBooleanObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toBooleanObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toBooleanObjectArray(true, true, false)).containsExactlyInOrder(true, true, false);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toCharacterObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toCharacterObjectArray()).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toCharacterObjectArray('1', '2', '3')).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(ValueConverter.toCharacterObjectArray(new int[0])).containsExactlyInOrder();
        Assertions.assertThat(ValueConverter.toCharacterObjectArray(49, 50, 51)).containsExactlyInOrder('1', '2', '3');
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toByteArrayTest() {
        Assertions.assertThat(ValueConverter.toByteArray(new ArrayList<Byte>())).isEmpty();
        Assertions.assertThat(ValueConverter.toByteArray(Arrays.asList((byte) 1, (byte) 2, (byte) 3))).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.toByteArray((Iterable<Byte>) new ArrayList<Byte>())).isEmpty();
        Assertions.assertThat(ValueConverter.toByteArray((Iterable<Byte>) Arrays.asList((byte) 1, (byte) 2, (byte) 3))).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toShortArrayTest() {
        Assertions.assertThat(ValueConverter.toShortArray(new ArrayList<Short>())).isEmpty();
        Assertions.assertThat(ValueConverter.toShortArray(Arrays.asList((short) 1, (short) 2, (short) 3))).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.toShortArray((Iterable<Short>) new ArrayList<Short>())).isEmpty();
        Assertions.assertThat(ValueConverter.toShortArray((Iterable<Short>) Arrays.asList((short) 1, (short) 2, (short) 3))).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toIntArrayTest() {
        Assertions.assertThat(ValueConverter.toIntArray(new ArrayList<Integer>())).isEmpty();
        Assertions.assertThat(ValueConverter.toIntArray(Arrays.asList(1, 2, 3))).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.toIntArray((Iterable<Integer>) new ArrayList<Integer>())).isEmpty();
        Assertions.assertThat(ValueConverter.toIntArray((Iterable<Integer>) Arrays.asList(1, 2, 3))).containsExactlyInOrder(1, 2, 3);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toLongArrayTest() {
        Assertions.assertThat(ValueConverter.toLongArray(new ArrayList<Long>())).isEmpty();
        Assertions.assertThat(ValueConverter.toLongArray(Arrays.asList(1L, 2L, 3L))).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertThat(ValueConverter.toLongArray((Iterable<Long>) new ArrayList<Long>())).isEmpty();
        Assertions.assertThat(ValueConverter.toLongArray((Iterable<Long>) Arrays.asList(1L, 2L, 3L))).containsExactlyInOrder(1L, 2L, 3L);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toFloatArrayTest() {
        Assertions.assertThat(ValueConverter.toFloatArray(new ArrayList<Float>())).isEmpty();
        Assertions.assertThat(ValueConverter.toFloatArray(Arrays.asList(1.0f, 2.0f, 3.0f))).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertThat(ValueConverter.toFloatArray((Iterable<Float>) new ArrayList<Float>())).isEmpty();
        Assertions.assertThat(ValueConverter.toFloatArray((Iterable<Float>) Arrays.asList(1.0f, 2.0f, 3.0f))).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toDoubleArrayTest() {
        Assertions.assertThat(ValueConverter.toDoubleArray(new ArrayList<Double>())).isEmpty();
        Assertions.assertThat(ValueConverter.toDoubleArray(Arrays.asList(1.0, 2.0, 3.0))).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertThat(ValueConverter.toDoubleArray((Iterable<Double>) new ArrayList<Double>())).isEmpty();
        Assertions.assertThat(ValueConverter.toDoubleArray((Iterable<Double>) Arrays.asList(1.0, 2.0, 3.0))).containsExactlyInOrder(1.0, 2.0, 3.0);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toBooleanArrayTest() {
        Assertions.assertThat(ValueConverter.toBooleanArray(new ArrayList<Boolean>())).isEmpty();
        Assertions.assertThat(ValueConverter.toBooleanArray(Arrays.asList(true, true, false))).containsExactlyInOrder(true, true, false);
        Assertions.assertThat(ValueConverter.toBooleanArray((Iterable<Boolean>) new ArrayList<Boolean>())).isEmpty();
        Assertions.assertThat(ValueConverter.toBooleanArray((Iterable<Boolean>) Arrays.asList(true, true, false))).containsExactlyInOrder(true, true, false);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toCharArrayTest() {
        Assertions.assertThat(ValueConverter.toCharArray(new ArrayList<Character>())).isEmpty();
        Assertions.assertThat(ValueConverter.toCharArray(Arrays.asList('1', '2', '3'))).containsExactlyInOrder(49, 50, 51);
        Assertions.assertThat(ValueConverter.toCharArray((Iterable<Character>) new ArrayList<Character>())).isEmpty();
        Assertions.assertThat(ValueConverter.toCharArray((Iterable<Character>) Arrays.asList('1', '2', '3'))).containsExactlyInOrder(49, 50, 51);
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void toObjectArrayTest() {
        Assertions.assertThat(ValueConverter.toObjectArray(new ArrayList<String>())).isEmpty();
        Assertions.assertThat(ValueConverter.toObjectArray(Arrays.asList("1", "2", "3"))).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(ValueConverter.toObjectArray((Iterable<String>) new ArrayList<String>())).isEmpty();
        Assertions.assertThat(ValueConverter.toObjectArray((Iterable<String>) Arrays.asList("1", "2", "3"))).containsExactlyInOrder("1", "2", "3");
    }

}
