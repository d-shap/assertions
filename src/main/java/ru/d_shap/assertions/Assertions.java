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
package ru.d_shap.assertions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.hamcrest.Matcher;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.d_shap.assertions.asimp.array.BooleanArrayAssertion;
import ru.d_shap.assertions.asimp.array.ByteArrayAssertion;
import ru.d_shap.assertions.asimp.array.CharArrayAssertion;
import ru.d_shap.assertions.asimp.array.DoubleArrayAssertion;
import ru.d_shap.assertions.asimp.array.FloatArrayAssertion;
import ru.d_shap.assertions.asimp.array.IntArrayAssertion;
import ru.d_shap.assertions.asimp.array.LongArrayAssertion;
import ru.d_shap.assertions.asimp.array.ObjectArrayAssertion;
import ru.d_shap.assertions.asimp.array.ShortArrayAssertion;
import ru.d_shap.assertions.asimp.java.io.BufferedReaderAssertion;
import ru.d_shap.assertions.asimp.java.io.InputStreamAssertion;
import ru.d_shap.assertions.asimp.java.io.ReaderAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.ClassAssertion;
import ru.d_shap.assertions.asimp.java.lang.ComparableAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.java.lang.ObjectAssertion;
import ru.d_shap.assertions.asimp.java.lang.ThrowableAssertion;
import ru.d_shap.assertions.asimp.java.nio.ByteBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.CharBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.DoubleBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.FloatBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.IntBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.LongBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.ShortBufferAssertion;
import ru.d_shap.assertions.asimp.java.util.CalendarAssertion;
import ru.d_shap.assertions.asimp.java.util.DateAssertion;
import ru.d_shap.assertions.asimp.java.util.IteratorAssertion;
import ru.d_shap.assertions.asimp.java.util.ListAssertion;
import ru.d_shap.assertions.asimp.java.util.LocaleAssertion;
import ru.d_shap.assertions.asimp.java.util.MapAssertion;
import ru.d_shap.assertions.asimp.java.util.SetAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedMapAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedSetAssertion;
import ru.d_shap.assertions.asimp.java.util.TimeZoneAssertion;
import ru.d_shap.assertions.asimp.javax.xml.datatype.XMLGregorianCalendarAssertion;
import ru.d_shap.assertions.asimp.javax.xml.namespace.QNameAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.AttrAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.CharacterDataAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.DocumentAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.ElementAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.NodeAssertion;
import ru.d_shap.assertions.asimp.predicate.AndPredicate;
import ru.d_shap.assertions.asimp.predicate.IdentityPredicate;
import ru.d_shap.assertions.asimp.predicate.NotPredicate;
import ru.d_shap.assertions.asimp.predicate.OrPredicate;
import ru.d_shap.assertions.asimp.predicate.XorPredicate;
import ru.d_shap.assertions.asimp.primitive.BooleanAssertion;
import ru.d_shap.assertions.asimp.primitive.ByteAssertion;
import ru.d_shap.assertions.asimp.primitive.CharAssertion;
import ru.d_shap.assertions.asimp.primitive.DoubleAssertion;
import ru.d_shap.assertions.asimp.primitive.FloatAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.asimp.primitive.LongAssertion;
import ru.d_shap.assertions.asimp.primitive.ShortAssertion;
import ru.d_shap.assertions.fail.AssertionErrorBuilder;

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
     * Make assertion about the date.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DateAssertion assertThat(final Date actual) {
        DateAssertion assertion = Raw.dateAssertion();
        ((BaseAssertion<Date>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the calendar.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CalendarAssertion assertThat(final Calendar actual) {
        CalendarAssertion assertion = Raw.calendarAssertion();
        ((BaseAssertion<Calendar>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the time zone.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static TimeZoneAssertion assertThat(final TimeZone actual) {
        TimeZoneAssertion assertion = Raw.timeZoneAssertion();
        ((BaseAssertion<TimeZone>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the locale.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static LocaleAssertion assertThat(final Locale actual) {
        LocaleAssertion assertion = Raw.localeAssertion();
        ((BaseAssertion<Locale>) assertion).initialize(actual);
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
     * Make assertion about the buffered reader.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static BufferedReaderAssertion assertThat(final BufferedReader actual) {
        BufferedReaderAssertion assertion = Raw.bufferedReaderAssertion();
        ((BaseAssertion<BufferedReader>) assertion).initialize(actual);
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
     * Make assertion about the XML gregorian calendar.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static XMLGregorianCalendarAssertion assertThat(final XMLGregorianCalendar actual) {
        XMLGregorianCalendarAssertion assertion = Raw.xmlGregorianCalendarAssertion();
        ((BaseAssertion<XMLGregorianCalendar>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the qname.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static QNameAssertion assertThat(final QName actual) {
        QNameAssertion assertion = Raw.qnameAssertion();
        ((BaseAssertion<QName>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the node.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static NodeAssertion assertThat(final Node actual) {
        NodeAssertion assertion = Raw.nodeAssertion();
        ((BaseAssertion<Node>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the element.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static ElementAssertion assertThat(final Element actual) {
        ElementAssertion assertion = Raw.elementAssertion();
        ((BaseAssertion<Element>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the document.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static DocumentAssertion assertThat(final Document actual) {
        DocumentAssertion assertion = Raw.documentAssertion();
        ((BaseAssertion<Document>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the attr.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static AttrAssertion assertThat(final Attr actual) {
        AttrAssertion assertion = Raw.attrAssertion();
        ((BaseAssertion<Attr>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Make assertion about the character data.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public static CharacterDataAssertion assertThat(final CharacterData actual) {
        CharacterDataAssertion assertion = Raw.characterDataAssertion();
        ((BaseAssertion<CharacterData>) assertion).initialize(actual);
        return assertion;
    }

    /**
     * Invoke the assertion invoker.
     *
     * @param assertionInvoker the assertion invoker.
     */
    public static void assertThat(final AssertionInvoker assertionInvoker) {
        IdentityPredicate predicate = new IdentityPredicate();
        ((BaseAssertion<AssertionInvoker>) predicate).initialize(assertionInvoker);
        predicate.invoke();
    }

    /**
     * Create AND predicate to join the assertion invokers.
     *
     * @param assertionInvokers the assertion invokers.
     *
     * @return the predicate.
     */
    public static AssertionInvoker and(final AssertionInvoker... assertionInvokers) {
        AndPredicate predicate = new AndPredicate();
        ((BaseAssertion<AssertionInvoker[]>) predicate).initialize(assertionInvokers);
        return predicate;
    }

    /**
     * Create OR predicate to join the assertion invokers.
     *
     * @param assertionInvokers the assertion invokers.
     *
     * @return the predicate.
     */
    public static AssertionInvoker or(final AssertionInvoker... assertionInvokers) {
        OrPredicate predicate = new OrPredicate();
        ((BaseAssertion<AssertionInvoker[]>) predicate).initialize(assertionInvokers);
        return predicate;
    }

    /**
     * Create XOR predicate to join the assertion invokers.
     *
     * @param assertionInvokers the assertion invokers.
     *
     * @return the predicate.
     */
    public static AssertionInvoker xor(final AssertionInvoker... assertionInvokers) {
        XorPredicate predicate = new XorPredicate();
        ((BaseAssertion<AssertionInvoker[]>) predicate).initialize(assertionInvokers);
        return predicate;
    }

    /**
     * Create NOT predicate to join the assertion invoker.
     *
     * @param assertionInvoker the assertion invoker.
     *
     * @return the predicate.
     */
    public static AssertionInvoker not(final AssertionInvoker assertionInvoker) {
        NotPredicate predicate = new NotPredicate();
        ((BaseAssertion<AssertionInvoker>) predicate).initialize(assertionInvoker);
        return predicate;
    }

    /**
     * Fail a test.
     *
     * @param message the fail message.
     */
    public static void fail(final String message) {
        throw AssertionErrorBuilder.getInstance().addMessage(Messages.SIMPLE_MESSAGE, message).build();
    }

    /**
     * Fail a test.
     *
     * @param message   the fail message.
     * @param throwable the throwabe.
     */
    public static void fail(final String message, final Throwable throwable) {
        throw AssertionErrorBuilder.getInstance().addMessage(Messages.SIMPLE_MESSAGE, message).addThrowable(throwable).build();
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
