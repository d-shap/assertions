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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Base class for all tests.
 *
 * @author Dmitry Shapovalov
 */
public class AssertionTest {

    /**
     * Test class constructor.
     */
    protected AssertionTest() {
        super();
    }

    /**
     * Initialize the specified assertion with the actual value.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initialize(final S assertion, final U actual) {
        assertion.initialize(actual);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initialize(final S assertion, final U actual, final String message) {
        assertion.initialize(actual, message);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    @SuppressWarnings("unchecked")
    protected final <W, S extends BaseAssertion<W>> S initializeWithRawActual(final S assertion, final Object actual) {
        assertion.initialize((W) actual);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the initialized assertion.
     */
    @SuppressWarnings("unchecked")
    protected final <W, S extends BaseAssertion<W>> S initializeWithRawActual(final S assertion, final Object actual, final String message) {
        assertion.initialize((W) actual, message);
        return assertion;
    }

    /**
     * Clear the actual value of  the specified assertion.
     *
     * @param assertion the specified assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     * @return the assertion with null actual value.
     */
    protected final <W, S extends BaseAssertion<W>> S clearActual(final S assertion) {
        try {
            Field field = BaseAssertion.class.getDeclaredField("_actual");
            PrivateAccessor.setAccessible(field);
            field.set(assertion, null);
            return assertion;
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Create the uninitialized base assertion.
     *
     * @return the uninitialized base assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion() {
        return new BaseAssertionImpl();
    }

    /**
     * Create the initialized base assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized base assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion(final Object actual) {
        return initialize(createBaseAssertion(), actual);
    }

    /**
     * Create the initialized base assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized base assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion(final Object actual, final String message) {
        return initialize(createBaseAssertion(), actual, message);
    }

    /**
     * Create the uninitialized reference assertion.
     *
     * @return the uninitialized reference assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion() {
        return new ReferenceAssertionImpl();
    }

    /**
     * Create the initialized reference assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized reference assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion(final Object actual) {
        return initialize(createReferenceAssertion(), actual);
    }

    /**
     * Create the initialized reference assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized reference assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion(final Object actual, final String message) {
        return initialize(createReferenceAssertion(), actual, message);
    }

    /**
     * Create the actual value validator.
     *
     * @param valid true if the value is valid.
     * @return the actual value validator.
     */
    protected final BaseActualValueValidator createActualValueValidator(final boolean valid) {
        return new BaseActualValueValidatorImpl(valid);
    }

    /**
     * Create the value converter.
     *
     * @return the value converter.
     */
    protected final BaseValueConverter createValueConverter() {
        return new BaseValueConverterImpl();
    }

    /**
     * Create the value to string converter.
     *
     * @return the value to string converter.
     */
    protected final BaseAsStringConverter createAsStringConverter() {
        return new BaseAsStringConverterImpl();
    }

    /**
     * Create the object with the private field with null value.
     *
     * @return the object with the private field with null value.
     */
    protected final Object createNullFieldClass() {
        return new NullFieldClass();
    }

    /**
     * Create the object with initialized private fields.
     *
     * @return the object with initialized private fields.
     */
    protected final Object createPrivateFieldsClass() {
        return new PrivateFieldsClass(this);
    }

    /**
     * Create new iterable with the values.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     * @return the iterable.
     */
    @SafeVarargs
    protected final <E> Iterable<E> createIterable(final E... values) {
        List<E> list = Arrays.asList(values);
        return new IterableImpl<>(list);
    }

    /**
     * Create new iterator with the values.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     * @return the iterator.
     */
    @SafeVarargs
    protected final <E> Iterator<E> createIterator(final E... values) {
        List<E> list = Arrays.asList(values);
        return new IteratorImpl<>(list);
    }

    /**
     * Create new hash set with the values.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     * @return the hash set.
     */
    @SafeVarargs
    protected final <E> Set<E> createHashSet(final E... values) {
        List<E> list = Arrays.asList(values);
        return new LinkedHashSet<>(list);
    }

    /**
     * Create new tree set with the values.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     * @return the tree set.
     */
    @SafeVarargs
    protected final <E> SortedSet<E> createTreeSet(final E... values) {
        SortedSet<E> sortedSet = new TreeSet<>(new NullFirstComparator<E>());
        sortedSet.addAll(Arrays.asList(values));
        return sortedSet;
    }

    /**
     * Create new empty hash map.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap() {
        Map<K, V> map = new LinkedHashMap<>();
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key   the key.
     * @param value the value.
     * @param <K>   the generic type of the key.
     * @param <V>   the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key, final V value) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key, value);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param key4   the key.
     * @param value4 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        map.put(key4, value4);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param key4   the key.
     * @param value4 the value.
     * @param key5   the key.
     * @param value5 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the hash map.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        map.put(key4, value4);
        map.put(key5, value5);
        return map;
    }

    /**
     * Create new empty tree map.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap() {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key   the key.
     * @param value the value.
     * @param <K>   the generic type of the key.
     * @param <V>   the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key, final V value) {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        sortedMap.put(key, value);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2) {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        sortedMap.put(key3, value3);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param key4   the key.
     * @param value4 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        sortedMap.put(key3, value3);
        sortedMap.put(key4, value4);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param key4   the key.
     * @param value4 the value.
     * @param key5   the key.
     * @param value5 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     * @return the tree map.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        sortedMap.put(key3, value3);
        sortedMap.put(key4, value4);
        sortedMap.put(key5, value5);
        return sortedMap;
    }

    /**
     * Create the byte buffer.
     *
     * @param values the buffer values.
     * @return the byte buffer.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values) {
        return createByteBuffer(values, 0);
    }

    /**
     * Create the byte buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the byte buffer.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values, final int position) {
        return createByteBuffer(values, position, getByteBufferSize(values));
    }

    /**
     * Create the byte buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the byte buffer.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit) {
        return createByteBuffer(values, position, limit, getByteBufferSize(values));
    }

    /**
     * Create the byte buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the byte buffer.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            for (byte value : values) {
                byteBuffer.put(value);
            }
            byteBuffer.position(position);
            byteBuffer.limit(limit);
            return byteBuffer;
        }
    }

    private int getByteBufferSize(final byte[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the short buffer.
     *
     * @param values the buffer values.
     * @return the short buffer.
     */
    protected final ShortBuffer createShortBuffer(final short[] values) {
        return createShortBuffer(values, 0);
    }

    /**
     * Create the short buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the short buffer.
     */
    protected final ShortBuffer createShortBuffer(final short[] values, final int position) {
        return createShortBuffer(values, position, getShortBufferSize(values));
    }

    /**
     * Create the short buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the short buffer.
     */
    protected final ShortBuffer createShortBuffer(final short[] values, final int position, final int limit) {
        return createShortBuffer(values, position, limit, getShortBufferSize(values));
    }

    /**
     * Create the short buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the short buffer.
     */
    protected final ShortBuffer createShortBuffer(final short[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 2);
            ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
            for (short value : values) {
                shortBuffer.put(value);
            }
            shortBuffer.position(position);
            shortBuffer.limit(limit);
            return shortBuffer;
        }
    }

    private int getShortBufferSize(final short[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the int buffer.
     *
     * @param values the buffer values.
     * @return the int buffer.
     */
    protected final IntBuffer createIntBuffer(final int[] values) {
        return createIntBuffer(values, 0);
    }

    /**
     * Create the int buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the int buffer.
     */
    protected final IntBuffer createIntBuffer(final int[] values, final int position) {
        return createIntBuffer(values, position, getIntBufferSize(values));
    }

    /**
     * Create the int buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the int buffer.
     */
    protected final IntBuffer createIntBuffer(final int[] values, final int position, final int limit) {
        return createIntBuffer(values, position, limit, getIntBufferSize(values));
    }

    /**
     * Create the int buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the int buffer.
     */
    protected final IntBuffer createIntBuffer(final int[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
            IntBuffer intBuffer = byteBuffer.asIntBuffer();
            for (int value : values) {
                intBuffer.put(value);
            }
            intBuffer.position(position);
            intBuffer.limit(limit);
            return intBuffer;
        }
    }

    private int getIntBufferSize(final int[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the long buffer.
     *
     * @param values the buffer values.
     * @return the long buffer.
     */
    protected final LongBuffer createLongBuffer(final long[] values) {
        return createLongBuffer(values, 0);
    }

    /**
     * Create the long buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the long buffer.
     */
    protected final LongBuffer createLongBuffer(final long[] values, final int position) {
        return createLongBuffer(values, position, getLongBufferSize(values));
    }

    /**
     * Create the long buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the long buffer.
     */
    protected final LongBuffer createLongBuffer(final long[] values, final int position, final int limit) {
        return createLongBuffer(values, position, limit, getLongBufferSize(values));
    }

    /**
     * Create the long buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the long buffer.
     */
    protected final LongBuffer createLongBuffer(final long[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 8);
            LongBuffer longBuffer = byteBuffer.asLongBuffer();
            for (long value : values) {
                longBuffer.put(value);
            }
            longBuffer.position(position);
            longBuffer.limit(limit);
            return longBuffer;
        }
    }

    private int getLongBufferSize(final long[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the float buffer.
     *
     * @param values the buffer values.
     * @return the float buffer.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values) {
        return createFloatBuffer(values, 0);
    }

    /**
     * Create the float buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the float buffer.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values, final int position) {
        return createFloatBuffer(values, position, getFloatBufferSize(values));
    }

    /**
     * Create the float buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the float buffer.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit) {
        return createFloatBuffer(values, position, limit, getFloatBufferSize(values));
    }

    /**
     * Create the float buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the float buffer.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
            FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
            for (float value : values) {
                floatBuffer.put(value);
            }
            floatBuffer.position(position);
            floatBuffer.limit(limit);
            return floatBuffer;
        }
    }

    private int getFloatBufferSize(final float[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the double buffer.
     *
     * @param values the buffer values.
     * @return the double buffer.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values) {
        return createDoubleBuffer(values, 0);
    }

    /**
     * Create the double buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the double buffer.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values, final int position) {
        return createDoubleBuffer(values, position, getDoubleBufferSize(values));
    }

    /**
     * Create the double buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the double buffer.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit) {
        return createDoubleBuffer(values, position, limit, getDoubleBufferSize(values));
    }

    /**
     * Create the double buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the double buffer.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 8);
            DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
            for (double value : values) {
                doubleBuffer.put(value);
            }
            doubleBuffer.position(position);
            doubleBuffer.limit(limit);
            return doubleBuffer;
        }
    }

    private int getDoubleBufferSize(final double[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Create the char buffer.
     *
     * @param values the buffer values.
     * @return the char buffer.
     */
    protected final CharBuffer createCharBuffer(final char[] values) {
        return createCharBuffer(values, 0);
    }

    /**
     * Create the char buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the char buffer.
     */
    protected final CharBuffer createCharBuffer(final char[] values, final int position) {
        return createCharBuffer(values, position, getCharBufferSize(values));
    }

    /**
     * Create the char buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the char buffer.
     */
    protected final CharBuffer createCharBuffer(final char[] values, final int position, final int limit) {
        return createCharBuffer(values, position, limit, getCharBufferSize(values));
    }

    /**
     * Create the char buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     * @return the char buffer.
     */
    protected final CharBuffer createCharBuffer(final char[] values, final int position, final int limit, final int capacity) {
        if (values == null) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 2);
            CharBuffer charBuffer = byteBuffer.asCharBuffer();
            for (char value : values) {
                charBuffer.put(value);
            }
            charBuffer.position(position);
            charBuffer.limit(limit);
            return charBuffer;
        }
    }

    private int getCharBufferSize(final char[] values) {
        if (values == null) {
            return 0;
        } else {
            return values.length;
        }
    }

    /**
     * Get the formatted message.
     *
     * @param message         the message.
     * @param arguments       the message arguments.
     * @param checkLastSymbol true to check the last symbol.
     * @return the formatted message.
     */
    protected final List<String> getFormattedMessages(final String message, final Object[] arguments, final boolean checkLastSymbol) {
        FailDescriptionEntry failDescriptionEntry = new FailDescriptionEntry(message, arguments, checkLastSymbol);
        return getFormattedMessages(failDescriptionEntry);
    }

    /**
     * Get the formatted message.
     *
     * @param failDescriptionEntry the fail description entry.
     * @return the formatted message.
     */
    protected final List<String> getFormattedMessages(final FailDescriptionEntry failDescriptionEntry) {
        List<String> formattedMessages = new ArrayList<>();
        failDescriptionEntry.addFormattedMessage(formattedMessages);
        return formattedMessages;
    }

    /**
     * Get the fail description entries for the fail description values.
     *
     * @param failDescriptionValues the fail description values
     * @return the fail description entries
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    protected final List<FailDescriptionEntry> getFailDescriptionEntries(final FailDescriptionValues failDescriptionValues) throws ConversionException {
        List<FailDescriptionEntry> failDescriptionEntries = new ArrayList<>();
        failDescriptionValues.addFailDescriptionEntry(failDescriptionEntries);
        return failDescriptionEntries;
    }

    /**
     * Create the input stream.
     *
     * @return the input stream.
     */
    protected final InputStream createErrorInputStream() {
        return new ErrorInputStream();
    }

    /**
     * Create the reader.
     *
     * @return the reader.
     */
    protected final Reader createErrorReader() {
        return new ErrorReader();
    }

    /**
     * Create the class A instance.
     *
     * @return the class A instance.
     */
    protected final ClassA createClassA() {
        return new ClassA();
    }

    /**
     * Create the class B instance.
     *
     * @return the class B instance.
     */
    protected final ClassB createClassB() {
        return new ClassB();
    }

    /**
     * Create the class C instance.
     *
     * @return the class C instance.
     */
    protected final ClassC createClassC() {
        return new ClassC();
    }

    /**
     * Create hamcrest matcher for the class A.
     *
     * @return hamcrest matcher for the class A.
     */
    protected final MatcherA createMatcherA() {
        return new MatcherA();
    }

    /**
     * Create hamcrest matcher for the class B.
     *
     * @return hamcrest matcher for the class B.
     */
    protected final MatcherB createMatcherB() {
        return new MatcherB();
    }

    /**
     * Create hamcrest matcher for the class C.
     *
     * @return hamcrest matcher for the class C.
     */
    protected final MatcherC createMatcherC() {
        return new MatcherC();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionImpl extends BaseAssertion<Object> {

        BaseAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ReferenceAssertionImpl extends ReferenceAssertion<Object> {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseActualValueValidatorImpl extends BaseActualValueValidator {

        private final boolean _valid;

        BaseActualValueValidatorImpl(final boolean valid) {
            super();
            _valid = valid;
        }

        @Override
        protected boolean isValid(final Object actual) {
            return _valid;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseValueConverterImpl extends BaseValueConverter {

        BaseValueConverterImpl() {
            super();
        }

        @Override
        protected Class<?> getValueClass() {
            return String.class;
        }

        @Override
        protected Class<?> getTargetClass() {
            return String.class;
        }

        @Override
        protected void checkArguments(final Object... arguments) {
            // Ignore
        }

        @Override
        protected boolean canConvertToTargetClass(final Object value, final Object... arguments) throws ConversionException {
            return true;
        }

        @Override
        protected Object convertToTargetClass(final Object value, final Object... arguments) throws ConversionException {
            return value;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAsStringConverterImpl extends BaseAsStringConverter {

        BaseAsStringConverterImpl() {
            super();
        }

        @Override
        protected Class<?> getValueClass() {
            return Object.class;
        }

        @Override
        protected String convertToString(final Object value) throws ConversionException {
            return convertValueToString(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class NullFieldClass {

        private Object _field;

        NullFieldClass() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivateFieldsClass {

        private final byte _byte;

        private final Byte _byteObj;

        private final short _short;

        private final Short _shortObj;

        private final int _int;

        private final Integer _intObj;

        private final long _long;

        private final Long _longObj;

        private final float _float;

        private final Float _floatObj;

        private final double _double;

        private final Double _doubleObj;

        private final boolean _boolean;

        private final Boolean _booleanObj;

        private final char _char;

        private final Character _charObj;

        private final Object _object;

        private final byte[] _byteArray;

        private final short[] _shortArray;

        private final int[] _intArray;

        private final long[] _longArray;

        private final float[] _floatArray;

        private final double[] _doubleArray;

        private final boolean[] _booleanArray;

        private final char[] _charArray;

        private final String[] _objectArray;

        private final Class<?> _class;

        private final CharSequence _charSequence;

        private final String _string;

        private final Comparable<Integer> _comparable;

        private final Iterable<String> _iterable;

        private final Throwable _throwable;

        private final Iterator<String> _iterator;

        private final List<String> _list;

        private final Set<String> _set;

        private final SortedSet<String> _sortedSet;

        private final Map<String, String> _map;

        private final SortedMap<String, String> _sortedMap;

        private final InputStream _inputStream;

        private final Reader _reader;

        private final ByteBuffer _byteBuffer;

        private final ShortBuffer _shortBuffer;

        private final IntBuffer _intBuffer;

        private final LongBuffer _longBuffer;

        private final FloatBuffer _floatBuffer;

        private final DoubleBuffer _doubleBuffer;

        private final CharBuffer _charBuffer;

        PrivateFieldsClass(final AssertionTest assertionTest) {
            super();
            _byte = 5;
            _byteObj = 5;
            _short = 5;
            _shortObj = 5;
            _int = 5;
            _intObj = 5;
            _long = 5L;
            _longObj = 5L;
            _float = 5.0f;
            _floatObj = 5.0f;
            _double = 5.0;
            _doubleObj = 5.0;
            _boolean = true;
            _booleanObj = true;
            _char = '5';
            _charObj = '5';
            _object = new StringBuilder("value");
            _byteArray = new byte[]{1, 2, 3};
            _shortArray = new short[]{1, 2, 3};
            _intArray = new int[]{1, 2, 3};
            _longArray = new long[]{1L, 2L, 3L};
            _floatArray = new float[]{1.0f, 2.0f, 3.0f};
            _doubleArray = new double[]{1.0, 2.0, 3.0};
            _booleanArray = new boolean[]{true, true, false};
            _charArray = new char[]{'1', '2', '3'};
            _objectArray = new String[]{"1", "2", "3"};
            _class = String.class;
            _charSequence = new StringBuilder("test");
            _string = "test";
            _comparable = Integer.valueOf("5");
            _iterable = Arrays.asList("1", "2", "3");
            _throwable = new AssertionError("error");
            _iterator = Arrays.asList("1", "2", "3").iterator();
            _list = Arrays.asList("1", "2", "3");
            _set = assertionTest.createHashSet("1", "2", "3");
            _sortedSet = assertionTest.createTreeSet("1", "2", "3");
            _map = assertionTest.createHashMap("1", "val1", "2", "val2", "3", "val3");
            _sortedMap = assertionTest.createTreeMap("1", "val1", "2", "val2", "3", "val3");
            _inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
            _reader = new StringReader("123");
            _byteBuffer = assertionTest.createByteBuffer(new byte[]{1, 2});
            _shortBuffer = assertionTest.createShortBuffer(new short[]{1, 2});
            _intBuffer = assertionTest.createIntBuffer(new int[]{1, 2});
            _longBuffer = assertionTest.createLongBuffer(new long[]{1L, 2L});
            _floatBuffer = assertionTest.createFloatBuffer(new float[]{1.0f, 2.0f});
            _doubleBuffer = assertionTest.createDoubleBuffer(new double[]{1.0f, 2.0f});
            _charBuffer = assertionTest.createCharBuffer(new char[]{'1', '2'});
        }

    }

    /**
     * Test class.
     *
     * @param <E> the generic type of the element.
     * @author Dmitry Shapovalov
     */
    private static final class IterableImpl<E> implements Iterable<E> {

        private final List<E> _list;

        IterableImpl(final List<E> list) {
            super();
            _list = list;
        }

        @Override
        public Iterator<E> iterator() {
            return _list.iterator();
        }

    }

    /**
     * Test class.
     *
     * @param <E> the generic type of the element.
     * @author Dmitry Shapovalov
     */
    private static final class IteratorImpl<E> implements Iterator<E> {

        private final Iterator<E> _iterator;

        IteratorImpl(final List<E> list) {
            super();
            _iterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return _iterator.hasNext();
        }

        @Override
        public E next() {
            return _iterator.next();
        }

        @Override
        public void remove() {
            _iterator.remove();
        }

    }

    /**
     * Test class.
     *
     * @param <E> the generic type of the element.
     * @author Dmitry Shapovalov
     */
    private static final class NullFirstComparator<E> implements Comparator<E> {

        NullFirstComparator() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        public int compare(final E obj1, final E obj2) {
            if (obj1 == null && obj2 == null) {
                return 0;
            } else if (obj1 == null && obj2 != null) {
                return -1;
            } else if (obj1 != null && obj2 == null) {
                return 1;
            } else if (obj1 instanceof Comparable) {
                return ((Comparable<E>) obj1).compareTo(obj2);
            } else {
                return 0;
            }
        }

    }

    /**
     * Test enum.
     *
     * @author Dmitry Shapovalov
     */
    public enum Values {

        VALUE_1, VALUE_2, VALUE_3

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorInputStream extends InputStream {

        ErrorInputStream() {
            super();
        }

        @Override
        public int available() throws IOException {
            throw new IOException("available exception");
        }

        @Override
        public int read() throws IOException {
            throw new IOException("read exception");
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorReader extends Reader {

        ErrorReader() {
            super();
        }

        @Override
        public int read() throws IOException {
            throw new IOException("read exception");
        }

        @Override
        public int read(final char[] buffer, final int from, final int to) throws IOException {
            throw new IOException("read exception");
        }

        @Override
        public void close() throws IOException {
            // Ignore
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static class ClassA {

        ClassA() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static class ClassB extends ClassA {

        ClassB() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static class ClassC extends ClassB {

        ClassC() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class MatcherA extends TypeSafeMatcher<ClassA> {

        MatcherA() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassA classA) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class MatcherB extends TypeSafeMatcher<ClassB> {

        MatcherB() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassB classB) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class MatcherC extends TypeSafeMatcher<ClassC> {

        MatcherC() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassC classB) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class PrivateFieldClass {

        private final String _value;

        /**
         * Create new object.
         */
        public PrivateFieldClass() {
            super();
            _value = "value";
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class PrivateMethodClass {

        /**
         * Create new object.
         */
        public PrivateMethodClass() {
            super();
        }

        private String getValue() {
            return "value";
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class PrivateConstructorClass {

        private PrivateConstructorClass() {
            super();
        }

    }

}
