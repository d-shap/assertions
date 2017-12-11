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
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
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
     * Create uninitialized base assertion.
     *
     * @return the initialized assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion() {
        return new BaseAssertionImpl();
    }

    /**
     * Create initialized base assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion(final Object actual) {
        return initialize(createBaseAssertion(), actual);
    }

    /**
     * Create initialized base assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    protected final BaseAssertion<Object> createBaseAssertion(final Object actual, final String message) {
        return initialize(createBaseAssertion(), actual, message);
    }

    /**
     * Create uninitialized reference assertion.
     *
     * @return the initialized assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion() {
        return new ReferenceAssertionImpl();
    }

    /**
     * Create initialized reference assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion(final Object actual) {
        return initialize(createReferenceAssertion(), actual);
    }

    /**
     * Create initialized reference assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    protected final ReferenceAssertion<Object> createReferenceAssertion(final Object actual, final String message) {
        return initialize(createReferenceAssertion(), actual, message);
    }

    /**
     * Create the object with the private field with null value.
     *
     * @return the object with the private field with null value.
     */
    protected final NullFieldClass createNullFieldClass() {
        return new NullFieldClass();
    }

    /**
     * Create the object with initialized private fields.
     *
     * @return the object with initialized private fields.
     */
    protected final PrivateFieldsClass createPrivateFieldsClass() {
        return new PrivateFieldsClass(this);
    }

    /**
     * Create new hash set with the values.
     *
     * @param values the values.
     * @return the hash set.
     */
    protected final Set<String> createHashSet(final String... values) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList(values));
        return set;
    }

    /**
     * Create new tree set with the values.
     *
     * @param values the values.
     * @return the tree set.
     */
    protected final SortedSet<String> createTreeSet(final String... values) {
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.addAll(Arrays.asList(values));
        return sortedSet;
    }

    /**
     * Create new empty hash map.
     *
     * @return the hash map.
     */
    protected final Map<String, String> createHashMap() {
        Map<String, String> map = new LinkedHashMap<>();
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key   the key.
     * @param value the value.
     * @return the hash map.
     */
    protected final Map<String, String> createHashMap(final String key, final String value) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(key, value);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the first key.
     * @param value1 the first value.
     * @param key2   the second key.
     * @param value2 the second value.
     * @return the hash map.
     */
    protected final Map<String, String> createHashMap(final String key1, final String value1, final String key2, final String value2) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key1   the first key.
     * @param value1 the first value.
     * @param key2   the second key.
     * @param value2 the second value.
     * @param key3   the third key.
     * @param value3 the third value.
     * @return the hash map.
     */
    protected final Map<String, String> createHashMap(final String key1, final String value1, final String key2, final String value2, final String key3, final String value3) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        return map;
    }

    /**
     * Create new empty tree map.
     *
     * @return the tree map.
     */
    protected final SortedMap<String, String> createTreeMap() {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key   the key.
     * @param value the value.
     * @return the tree map.
     */
    protected final SortedMap<String, String> createTreeMap(final String key, final String value) {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put(key, value);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the first key.
     * @param value1 the first value.
     * @param key2   the second key.
     * @param value2 the second value.
     * @return the tree map.
     */
    protected final SortedMap<String, String> createTreeMap(final String key1, final String value1, final String key2, final String value2) {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        return sortedMap;
    }

    /**
     * Create new tree map with the values.
     *
     * @param key1   the first key.
     * @param value1 the first value.
     * @param key2   the second key.
     * @param value2 the second value.
     * @param key3   the third key.
     * @param value3 the third value.
     * @return the tree map.
     */
    protected final SortedMap<String, String> createTreeMap(final String key1, final String value1, final String key2, final String value2, final String key3, final String value3) {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put(key1, value1);
        sortedMap.put(key2, value2);
        sortedMap.put(key3, value3);
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
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class BaseAssertionImpl extends BaseAssertion<Object> {

        BaseAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class ReferenceAssertionImpl extends ReferenceAssertion<Object> {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class NullFieldClass {

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
    public static final class PrivateFieldsClass {

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
     * Test enum.
     *
     * @author Dmitry Shapovalov
     */
    public enum Values {

        VALUE_1, VALUE_2, VALUE_3

    }

}
