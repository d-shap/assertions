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

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;

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
     * @param <T>       generic assertion type.
     * @return the initialized assertion.
     */
    public static <T extends BaseAssertion> T initialize(final T assertion, final Object actual) {
        assertion.initialize(actual);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <T>       generic assertion type.
     * @return the initialized assertion.
     */
    public static <T extends BaseAssertion> T initialize(final T assertion, final Object actual, final String message) {
        assertion.initialize(actual, message);
        return assertion;
    }

    /**
     * Create initialized base assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    public static BaseAssertion createBaseAssertion(final Object actual) {
        return initialize(new BaseAssertionImpl(), actual);
    }

    /**
     * Create initialized base assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    public final BaseAssertion createBaseAssertion(final Object actual, final String message) {
        return initialize(new BaseAssertionImpl(), actual, message);
    }

    /**
     * Create initialized reference assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    public static ReferenceAssertion createReferenceAssertion(final Object actual) {
        return initialize(new ReferenceAssertionImpl(), actual);
    }

    /**
     * Create initialized reference assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    public static ReferenceAssertion createReferenceAssertion(final Object actual, final String message) {
        return initialize(new ReferenceAssertionImpl(), actual, message);
    }

    /**
     * Create new empty hash map.
     *
     * @return the hash map.
     */
    public static Map<String, String> createHashMap() {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    /**
     * Create new hash map with the values.
     *
     * @param key   the key.
     * @param value the value.
     * @return the hash map.
     */
    public static Map<String, String> createHashMap(final String key, final String value) {
        Map<String, String> map = new HashMap<>();
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
    public static Map<String, String> createHashMap(final String key1, final String value1, final String key2, final String value2) {
        Map<String, String> map = new HashMap<>();
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
    public static Map<String, String> createHashMap(final String key1, final String value1, final String key2, final String value2, final String key3, final String value3) {
        Map<String, String> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);
        return map;
    }

    /**
     * Create the byte buffer.
     *
     * @param values the buffer values.
     * @return the byte buffer.
     */
    public static ByteBuffer createByteBuffer(final byte[] values) {
        return createByteBuffer(values, 0);
    }

    /**
     * Create the byte buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the byte buffer.
     */
    public static ByteBuffer createByteBuffer(final byte[] values, final int position) {
        return createByteBuffer(values, position, getSize(values));
    }

    /**
     * Create the byte buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the byte buffer.
     */
    public static ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit) {
        return createByteBuffer(values, position, limit, getSize(values));
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
    public static ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final byte[] values) {
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
    public static ShortBuffer createShortBuffer(final short[] values) {
        return createShortBuffer(values, 0);
    }

    /**
     * Create the short buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the short buffer.
     */
    public static ShortBuffer createShortBuffer(final short[] values, final int position) {
        return createShortBuffer(values, position, getSize(values));
    }

    /**
     * Create the short buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the short buffer.
     */
    public static ShortBuffer createShortBuffer(final short[] values, final int position, final int limit) {
        return createShortBuffer(values, position, limit, getSize(values));
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
    public static ShortBuffer createShortBuffer(final short[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final short[] values) {
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
    public static IntBuffer createIntBuffer(final int[] values) {
        return createIntBuffer(values, 0);
    }

    /**
     * Create the int buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the int buffer.
     */
    public static IntBuffer createIntBuffer(final int[] values, final int position) {
        return createIntBuffer(values, position, getSize(values));
    }

    /**
     * Create the int buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the int buffer.
     */
    public static IntBuffer createIntBuffer(final int[] values, final int position, final int limit) {
        return createIntBuffer(values, position, limit, getSize(values));
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
    public static IntBuffer createIntBuffer(final int[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final int[] values) {
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
    public static LongBuffer createLongBuffer(final long[] values) {
        return createLongBuffer(values, 0);
    }

    /**
     * Create the long buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the long buffer.
     */
    public static LongBuffer createLongBuffer(final long[] values, final int position) {
        return createLongBuffer(values, position, getSize(values));
    }

    /**
     * Create the long buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the long buffer.
     */
    public static LongBuffer createLongBuffer(final long[] values, final int position, final int limit) {
        return createLongBuffer(values, position, limit, getSize(values));
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
    public static LongBuffer createLongBuffer(final long[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final long[] values) {
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
    public static FloatBuffer createFloatBuffer(final float[] values) {
        return createFloatBuffer(values, 0);
    }

    /**
     * Create the float buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the float buffer.
     */
    public static FloatBuffer createFloatBuffer(final float[] values, final int position) {
        return createFloatBuffer(values, position, getSize(values));
    }

    /**
     * Create the float buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the float buffer.
     */
    public static FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit) {
        return createFloatBuffer(values, position, limit, getSize(values));
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
    public static FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final float[] values) {
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
    public static DoubleBuffer createDoubleBuffer(final double[] values) {
        return createDoubleBuffer(values, 0);
    }

    /**
     * Create the double buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the double buffer.
     */
    public static DoubleBuffer createDoubleBuffer(final double[] values, final int position) {
        return createDoubleBuffer(values, position, getSize(values));
    }

    /**
     * Create the double buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the double buffer.
     */
    public static DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit) {
        return createDoubleBuffer(values, position, limit, getSize(values));
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
    public static DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final double[] values) {
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
    public static CharBuffer createCharBuffer(final char[] values) {
        return createCharBuffer(values, 0);
    }

    /**
     * Create the char buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @return the char buffer.
     */
    public static CharBuffer createCharBuffer(final char[] values, final int position) {
        return createCharBuffer(values, position, getSize(values));
    }

    /**
     * Create the char buffer.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @return the char buffer.
     */
    public static CharBuffer createCharBuffer(final char[] values, final int position, final int limit) {
        return createCharBuffer(values, position, limit, getSize(values));
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
    public static CharBuffer createCharBuffer(final char[] values, final int position, final int limit, final int capacity) {
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

    private static int getSize(final char[] values) {
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
    public static final class BaseAssertionImpl extends BaseAssertion {

        BaseAssertionImpl() {
            super();
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
    public static final class ReferenceAssertionImpl extends ReferenceAssertion {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

}
