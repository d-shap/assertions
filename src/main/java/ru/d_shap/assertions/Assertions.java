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

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.array.BooleanArrayAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.array.CharArrayAssertion;
import ru.d_shap.assertions.array.DoubleArrayAssertion;
import ru.d_shap.assertions.array.FloatArrayAssertion;
import ru.d_shap.assertions.array.IntArrayAssertion;
import ru.d_shap.assertions.array.LongArrayAssertion;
import ru.d_shap.assertions.array.ObjectArrayAssertion;
import ru.d_shap.assertions.array.ShortArrayAssertion;
import ru.d_shap.assertions.collection.IteratorAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.collection.SortedMapAssertion;
import ru.d_shap.assertions.collection.SortedSetAssertion;
import ru.d_shap.assertions.core.CharSequenceAssertion;
import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.ComparableAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;
import ru.d_shap.assertions.core.ThrowableAssertion;
import ru.d_shap.assertions.io.InputStreamAssertion;
import ru.d_shap.assertions.io.ReaderAssertion;
import ru.d_shap.assertions.nio.ByteBufferAssertion;
import ru.d_shap.assertions.nio.CharBufferAssertion;
import ru.d_shap.assertions.nio.DoubleBufferAssertion;
import ru.d_shap.assertions.nio.FloatBufferAssertion;
import ru.d_shap.assertions.nio.IntBufferAssertion;
import ru.d_shap.assertions.nio.LongBufferAssertion;
import ru.d_shap.assertions.nio.ShortBufferAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.ByteAssertion;
import ru.d_shap.assertions.primitive.CharAssertion;
import ru.d_shap.assertions.primitive.DoubleAssertion;
import ru.d_shap.assertions.primitive.FloatAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.primitive.ShortAssertion;

/**
 * Entry point of all assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class Assertions {

    private Assertions() {
        super();
    }

    /**
     * Make assertion with the assertion message.
     *
     * @param message the assertion message.
     *
     * @return the assertion.
     */
    public static MessageAssertion assertWithMessage(final String message) {
        return new MessageAssertion(message);
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ByteAssertion assertThat(final byte actual) {
        ByteAssertion assertion = Raw.byteAssertion();
        ((BaseAssertion<Byte>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ByteAssertion assertThat(final Byte actual) {
        ByteAssertion assertion = Raw.byteAssertion();
        ((BaseAssertion<Byte>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ShortAssertion assertThat(final short actual) {
        ShortAssertion assertion = Raw.shortAssertion();
        ((BaseAssertion<Short>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ShortAssertion assertThat(final Short actual) {
        ShortAssertion assertion = Raw.shortAssertion();
        ((BaseAssertion<Short>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static IntAssertion assertThat(final int actual) {
        IntAssertion assertion = Raw.intAssertion();
        ((BaseAssertion<Integer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static IntAssertion assertThat(final Integer actual) {
        IntAssertion assertion = Raw.intAssertion();
        ((BaseAssertion<Integer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static LongAssertion assertThat(final long actual) {
        LongAssertion assertion = Raw.longAssertion();
        ((BaseAssertion<Long>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static LongAssertion assertThat(final Long actual) {
        LongAssertion assertion = Raw.longAssertion();
        ((BaseAssertion<Long>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static FloatAssertion assertThat(final float actual) {
        FloatAssertion assertion = Raw.floatAssertion();
        ((BaseAssertion<Float>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static FloatAssertion assertThat(final Float actual) {
        FloatAssertion assertion = Raw.floatAssertion();
        ((BaseAssertion<Float>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DoubleAssertion assertThat(final double actual) {
        DoubleAssertion assertion = Raw.doubleAssertion();
        ((BaseAssertion<Double>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DoubleAssertion assertThat(final Double actual) {
        DoubleAssertion assertion = Raw.doubleAssertion();
        ((BaseAssertion<Double>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static BooleanAssertion assertThat(final boolean actual) {
        BooleanAssertion assertion = Raw.booleanAssertion();
        ((BaseAssertion<Boolean>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static BooleanAssertion assertThat(final Boolean actual) {
        BooleanAssertion assertion = Raw.booleanAssertion();
        ((BaseAssertion<Boolean>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharAssertion assertThat(final char actual) {
        CharAssertion assertion = Raw.charAssertion();
        ((BaseAssertion<Character>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharAssertion assertThat(final Character actual) {
        CharAssertion assertion = Raw.charAssertion();
        ((BaseAssertion<Character>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the object.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ObjectAssertion assertThat(final Object actual) {
        ObjectAssertion assertion = Raw.objectAssertion();
        ((BaseAssertion<Object>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion of specified type about the object.
     *
     * @param actual    the actual value.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public static <W, S extends BaseAssertion<W>> S assertThat(final Object actual, final S assertion) {
        return assertThat(actual).as(assertion);
    }

    /**
     * Make assertion about the object with the hamcrest matcher.
     *
     * @param actual  the actual value.
     * @param matcher the hamcrest matcher.
     * @param <W>     the generic type of the matcher's actual value.
     * @param <U>     the generic type of the actual value.
     */
    public static <W, U extends W> void assertThat(final U actual, final Matcher<W> matcher) {
        HamcrestMatcher.matcherAssertion(actual, matcher);
    }

    /**
     * Make assertion about the object's field.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     *
     * @return the assertion.
     */
    public static ObjectAssertion assertThat(final Object actual, final String fieldName) {
        return assertThat(actual).toField(fieldName);
    }

    /**
     * Make assertion of specified type about the object's field.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public static <W, S extends BaseAssertion<W>> S assertThat(final Object actual, final String fieldName, final S assertion) {
        return assertThat(actual).toField(fieldName, assertion);
    }

    /**
     * Make assertion about the object's field with the hamcrest matcher.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     * @param matcher   the hamcrest matcher.
     * @param <W>       the generic type of the matcher's actual value.
     */
    public static <W> void assertThat(final Object actual, final String fieldName, final Matcher<W> matcher) {
        assertThat(actual).toField(fieldName, matcher);
    }

    /**
     * Make assertion about the byte array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ByteArrayAssertion assertThat(final byte[] actual) {
        ByteArrayAssertion assertion = Raw.byteArrayAssertion();
        ((BaseAssertion<byte[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the short array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ShortArrayAssertion assertThat(final short[] actual) {
        ShortArrayAssertion assertion = Raw.shortArrayAssertion();
        ((BaseAssertion<short[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the int array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static IntArrayAssertion assertThat(final int[] actual) {
        IntArrayAssertion assertion = Raw.intArrayAssertion();
        ((BaseAssertion<int[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the long array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static LongArrayAssertion assertThat(final long[] actual) {
        LongArrayAssertion assertion = Raw.longArrayAssertion();
        ((BaseAssertion<long[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the float array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static FloatArrayAssertion assertThat(final float[] actual) {
        FloatArrayAssertion assertion = Raw.floatArrayAssertion();
        ((BaseAssertion<float[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the double array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DoubleArrayAssertion assertThat(final double[] actual) {
        DoubleArrayAssertion assertion = Raw.doubleArrayAssertion();
        ((BaseAssertion<double[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the boolean array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static BooleanArrayAssertion assertThat(final boolean[] actual) {
        BooleanArrayAssertion assertion = Raw.booleanArrayAssertion();
        ((BaseAssertion<boolean[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the char array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharArrayAssertion assertThat(final char[] actual) {
        CharArrayAssertion assertion = Raw.charArrayAssertion();
        ((BaseAssertion<char[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the object array.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> ObjectArrayAssertion<E> assertThat(final E[] actual) {
        ObjectArrayAssertion<E> assertion = Raw.objectArrayAssertion();
        ((BaseAssertion<E[]>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the class.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ClassAssertion assertThat(final Class<?> actual) {
        ClassAssertion assertion = Raw.classAssertion();
        ((BaseAssertion<Class<?>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the char sequence.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharSequenceAssertion assertThat(final CharSequence actual) {
        CharSequenceAssertion assertion = Raw.charSequenceAssertion();
        ((BaseAssertion<CharSequence>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the string.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharSequenceAssertion assertThat(final String actual) {
        CharSequenceAssertion assertion = Raw.charSequenceAssertion();
        ((BaseAssertion<CharSequence>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the comparable.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> ComparableAssertion<E> assertThat(final Comparable<E> actual) {
        ComparableAssertion<E> assertion = Raw.comparableAssertion();
        ((BaseAssertion<Comparable<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the iterable.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> IterableAssertion<E> assertThat(final Iterable<E> actual) {
        IterableAssertion<E> assertion = Raw.iterableAssertion();
        ((BaseAssertion<Iterable<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the throwable.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ThrowableAssertion assertThat(final Throwable actual) {
        ThrowableAssertion assertion = Raw.throwableAssertion();
        ((BaseAssertion<Throwable>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the iterator.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> IteratorAssertion<E> assertThat(final Iterator<E> actual) {
        IteratorAssertion<E> assertion = Raw.iteratorAssertion();
        ((BaseAssertion<Iterator<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the list.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> ListAssertion<E> assertThat(final List<E> actual) {
        ListAssertion<E> assertion = Raw.listAssertion();
        ((BaseAssertion<List<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the set.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> SetAssertion<E> assertThat(final Set<E> actual) {
        SetAssertion<E> assertion = Raw.setAssertion();
        ((BaseAssertion<Set<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the sorted set.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> SortedSetAssertion<E> assertThat(final SortedSet<E> actual) {
        SortedSetAssertion<E> assertion = Raw.sortedSetAssertion();
        ((BaseAssertion<SortedSet<E>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the map.
     *
     * @param actual the actual value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the assertion.
     */
    public static <K, V> MapAssertion<K, V> assertThat(final Map<K, V> actual) {
        MapAssertion<K, V> assertion = Raw.mapAssertion();
        ((BaseAssertion<Map<K, V>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the sorted map.
     *
     * @param actual the actual value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the assertion.
     */
    public static <K, V> SortedMapAssertion<K, V> assertThat(final SortedMap<K, V> actual) {
        SortedMapAssertion<K, V> assertion = Raw.sortedMapAssertion();
        ((BaseAssertion<SortedMap<K, V>>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the input stream.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static InputStreamAssertion assertThat(final InputStream actual) {
        InputStreamAssertion assertion = Raw.inputStreamAssertion();
        ((BaseAssertion<InputStream>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the reader.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ReaderAssertion assertThat(final Reader actual) {
        ReaderAssertion assertion = Raw.readerAssertion();
        ((BaseAssertion<Reader>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the byte buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ByteBufferAssertion assertThat(final ByteBuffer actual) {
        ByteBufferAssertion assertion = Raw.byteBufferAssertion();
        ((BaseAssertion<ByteBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the short buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ShortBufferAssertion assertThat(final ShortBuffer actual) {
        ShortBufferAssertion assertion = Raw.shortBufferAssertion();
        ((BaseAssertion<ShortBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the int buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static IntBufferAssertion assertThat(final IntBuffer actual) {
        IntBufferAssertion assertion = Raw.intBufferAssertion();
        ((BaseAssertion<IntBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the long buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static LongBufferAssertion assertThat(final LongBuffer actual) {
        LongBufferAssertion assertion = Raw.longBufferAssertion();
        ((BaseAssertion<LongBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the float buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static FloatBufferAssertion assertThat(final FloatBuffer actual) {
        FloatBufferAssertion assertion = Raw.floatBufferAssertion();
        ((BaseAssertion<FloatBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the double buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DoubleBufferAssertion assertThat(final DoubleBuffer actual) {
        DoubleBufferAssertion assertion = Raw.doubleBufferAssertion();
        ((BaseAssertion<DoubleBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the char buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharBufferAssertion assertThat(final CharBuffer actual) {
        CharBufferAssertion assertion = Raw.charBufferAssertion();
        ((BaseAssertion<CharBuffer>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Fail a test.
     *
     * @param failMessage the fail message.
     */
    public static void fail(final String failMessage) {
        throw AssertionErrorBuilder.getInstance().addMessage(Messages.SIMPLE_MESSAGE, failMessage).build();
    }

    /**
     * Fail a test.
     *
     * @param failMessage the fail message.
     * @param throwable   the throwabe.
     */
    public static void fail(final String failMessage, final Throwable throwable) {
        throw AssertionErrorBuilder.getInstance().addMessage(Messages.SIMPLE_MESSAGE, failMessage).addThrowable(throwable).build();
    }

    /**
     * Fail a test.
     *
     * @param throwable the throwabe.
     */
    public static void fail(final Throwable throwable) {
        throw AssertionErrorBuilder.getInstance().addThrowable(throwable).build();
    }

}
