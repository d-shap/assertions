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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;

import javax.xml.XMLConstants;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.util.DataHelper;
import ru.d_shap.assertions.util.ReflectionException;
import ru.d_shap.assertions.util.ReflectionHelper;

/**
 * Base class for all tests.
 *
 * @author Dmitry Shapovalov
 */
public class AssertionTest {

    protected static final String ENCODING_UTF_8 = StandardCharsets.UTF_8.name();

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
     *
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
     * @param arguments the message arguments.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <U>       the generic type of the actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the initialized assertion.
     */
    protected final <W, U extends W, S extends BaseAssertion<W>> S initialize(final S assertion, final U actual, final String message, final Object... arguments) {
        assertion.initialize(actual, message, arguments);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
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
     * @param arguments the message arguments.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the initialized assertion.
     */
    @SuppressWarnings("unchecked")
    protected final <W, S extends BaseAssertion<W>> S initializeWithRawActual(final S assertion, final Object actual, final String message, final Object... arguments) {
        assertion.initialize((W) actual, message, arguments);
        return assertion;
    }

    /**
     * Clear the actual value of  the specified assertion.
     *
     * @param assertion the specified assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion with null actual value.
     */
    protected final <W, S extends BaseAssertion<W>> S clearActual(final S assertion) {
        try {
            Field field = ReflectionHelper.getField(BaseAssertion.class, "_actual");
            ReflectionHelper.setAccessible(field);
            field.set(assertion, null);
            return assertion;
        } catch (ReflectionException ex) {
            throw new AssertionError(ex.getCause());
        } catch (IllegalAccessException ex) {
            throw new AssertionError(ex);
        }
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
     * Create hash set object.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     *
     * @return the created object.
     */
    @SafeVarargs
    protected final <E> Set<E> createHashSet(final E... values) {
        return DataHelper.createHashSet(values);
    }

    /**
     * Create duplicate set object.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     *
     * @return the created object.
     */
    @SafeVarargs
    protected final <E> Set<E> createDuplicateSet(final E... values) {
        Set<E> set = new DuplicateSet<>();
        List<E> list = Arrays.asList(values);
        set.addAll(list);
        return set;
    }

    /**
     * Create tree set object.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     *
     * @return the created object.
     */
    @SafeVarargs
    protected final <E> SortedSet<E> createTreeSet(final E... values) {
        return DataHelper.createTreeSet(values);
    }

    /**
     * Create hash map object.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap() {
        return DataHelper.createHashMap();
    }

    /**
     * Create hash map object.
     *
     * @param key   the key.
     * @param value the value.
     * @param <K>   the generic type of the key.
     * @param <V>   the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key, final V value) {
        return DataHelper.createHashMap(key, value);
    }

    /**
     * Create hash map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2) {
        return DataHelper.createHashMap(key1, value1, key2, value2);
    }

    /**
     * Create hash map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        return DataHelper.createHashMap(key1, value1, key2, value2, key3, value3);
    }

    /**
     * Create hash map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        return DataHelper.createHashMap(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    /**
     * Create hash map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        return DataHelper.createHashMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Create duplicate map object.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap() {
        Map<K, V> map = new DuplicateMap<>();
        return map;
    }

    /**
     * Create duplicate map object.
     *
     * @param key   the key.
     * @param value the value.
     * @param <K>   the generic type of the key.
     * @param <V>   the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap(final K key, final V value) {
        Map<K, V> map = createDuplicateMap();
        map.put(key, value);
        return map;
    }

    /**
     * Create duplicate map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap(final K key1, final V value1, final K key2, final V value2) {
        Map<K, V> map = createDuplicateMap(key1, value1);
        map.put(key2, value2);
        return map;
    }

    /**
     * Create duplicate map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        Map<K, V> map = createDuplicateMap(key1, value1, key2, value2);
        map.put(key3, value3);
        return map;
    }

    /**
     * Create duplicate map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        Map<K, V> map = createDuplicateMap(key1, value1, key2, value2, key3, value3);
        map.put(key4, value4);
        return map;
    }

    /**
     * Create duplicate map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> Map<K, V> createDuplicateMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        Map<K, V> map = createDuplicateMap(key1, value1, key2, value2, key3, value3, key4, value4);
        map.put(key5, value5);
        return map;
    }

    /**
     * Create tree map object.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap() {
        return DataHelper.createTreeMap();
    }

    /**
     * Create tree map object.
     *
     * @param key   the key.
     * @param value the value.
     * @param <K>   the generic type of the key.
     * @param <V>   the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key, final V value) {
        return DataHelper.createTreeMap(key, value);
    }

    /**
     * Create tree map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2) {
        return DataHelper.createTreeMap(key1, value1, key2, value2);
    }

    /**
     * Create tree map object.
     *
     * @param key1   the key.
     * @param value1 the value.
     * @param key2   the key.
     * @param value2 the value.
     * @param key3   the key.
     * @param value3 the value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        return DataHelper.createTreeMap(key1, value1, key2, value2, key3, value3);
    }

    /**
     * Create tree map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        return DataHelper.createTreeMap(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    /**
     * Create tree map object.
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
     *
     * @return the created object.
     */
    protected final <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        return DataHelper.createTreeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Create date object.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    protected final Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return DataHelper.createDate(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Create date object.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    protected final Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        return DataHelper.createDate(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Create calendar object in the default time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    protected final Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return DataHelper.createCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Create calendar object in the default time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    protected final Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        return DataHelper.createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Create calendar object in the specified time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     * @param timeZoneId the time zone ID.
     *
     * @return the created object.
     */
    protected final Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return DataHelper.createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, timeZoneId);
    }

    /**
     * Create calendar object in the specified time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     * @param timeZoneId  the time zone ID.
     *
     * @return the created object.
     */
    protected final Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        return DataHelper.createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond, timeZoneId);
    }

    /**
     * Create calendar object in the UTC time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    protected final Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return DataHelper.createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Create calendar object in the UTC time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    protected final Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        return DataHelper.createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Create byte buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values) {
        return createByteBuffer(values, 0);
    }

    /**
     * Create byte buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values, final int position) {
        return createByteBuffer(values, position, getByteBufferSize(values));
    }

    /**
     * Create byte buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit) {
        return createByteBuffer(values, position, limit, getByteBufferSize(values));
    }

    /**
     * Create byte buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create short buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final ShortBuffer createShortBuffer(final short[] values) {
        return createShortBuffer(values, 0);
    }

    /**
     * Create short buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final ShortBuffer createShortBuffer(final short[] values, final int position) {
        return createShortBuffer(values, position, getShortBufferSize(values));
    }

    /**
     * Create short buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final ShortBuffer createShortBuffer(final short[] values, final int position, final int limit) {
        return createShortBuffer(values, position, limit, getShortBufferSize(values));
    }

    /**
     * Create short buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create int buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final IntBuffer createIntBuffer(final int[] values) {
        return createIntBuffer(values, 0);
    }

    /**
     * Create int buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final IntBuffer createIntBuffer(final int[] values, final int position) {
        return createIntBuffer(values, position, getIntBufferSize(values));
    }

    /**
     * Create int buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final IntBuffer createIntBuffer(final int[] values, final int position, final int limit) {
        return createIntBuffer(values, position, limit, getIntBufferSize(values));
    }

    /**
     * Create int buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create long buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final LongBuffer createLongBuffer(final long[] values) {
        return createLongBuffer(values, 0);
    }

    /**
     * Create long buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final LongBuffer createLongBuffer(final long[] values, final int position) {
        return createLongBuffer(values, position, getLongBufferSize(values));
    }

    /**
     * Create long buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final LongBuffer createLongBuffer(final long[] values, final int position, final int limit) {
        return createLongBuffer(values, position, limit, getLongBufferSize(values));
    }

    /**
     * Create long buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create float buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values) {
        return createFloatBuffer(values, 0);
    }

    /**
     * Create float buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values, final int position) {
        return createFloatBuffer(values, position, getFloatBufferSize(values));
    }

    /**
     * Create float buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit) {
        return createFloatBuffer(values, position, limit, getFloatBufferSize(values));
    }

    /**
     * Create float buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create double buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values) {
        return createDoubleBuffer(values, 0);
    }

    /**
     * Create double buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values, final int position) {
        return createDoubleBuffer(values, position, getDoubleBufferSize(values));
    }

    /**
     * Create double buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit) {
        return createDoubleBuffer(values, position, limit, getDoubleBufferSize(values));
    }

    /**
     * Create double buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create char buffer object.
     *
     * @param values the buffer values.
     *
     * @return the created object.
     */
    protected final CharBuffer createCharBuffer(final char[] values) {
        return createCharBuffer(values, 0);
    }

    /**
     * Create char buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     *
     * @return the created object.
     */
    protected final CharBuffer createCharBuffer(final char[] values, final int position) {
        return createCharBuffer(values, position, getCharBufferSize(values));
    }

    /**
     * Create char buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     *
     * @return the created object.
     */
    protected final CharBuffer createCharBuffer(final char[] values, final int position, final int limit) {
        return createCharBuffer(values, position, limit, getCharBufferSize(values));
    }

    /**
     * Create char buffer object.
     *
     * @param values   the buffer values.
     * @param position the initial buffer position.
     * @param limit    the buffer limit.
     * @param capacity the buffer capacity.
     *
     * @return the created object.
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
     * Create input stream object.
     *
     * @return the created object.
     */
    protected final InputStream createErrorInputStream() {
        return new ErrorInputStream();
    }

    /**
     * Create reader object.
     *
     * @return the created object.
     */
    protected final Reader createErrorReader() {
        return new ErrorReader();
    }

    /**
     * Create buffered reader object.
     *
     * @return the created object.
     */
    protected final BufferedReader createErrorBufferedReader() {
        return new BufferedReader(createErrorReader());
    }

    /**
     * Create XML calendar object in the default time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return DataHelper.createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Create XML calendar object in the default time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        return DataHelper.createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Create XML calendar object in the specified time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     * @param timeZoneId the time zone ID.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return DataHelper.createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, timeZoneId);
    }

    /**
     * Create XML calendar object in the specified time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     * @param timeZoneId  the time zone ID.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        return DataHelper.createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond, timeZoneId);
    }

    /**
     * Create XML calendar object in the UTC time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return DataHelper.createUtcXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Create XML calendar object in the UTC time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    protected final XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        return DataHelper.createUtcXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Create node object.
     *
     * @param content the content.
     *
     * @return the created object.
     */
    protected final Node createNode(final String content) {
        String enclosedContent = "<element>" + content + "</element>";
        Element element = createElement(enclosedContent);
        return element.getFirstChild();
    }

    /**
     * Create element object.
     *
     * @param content the content.
     *
     * @return the created object.
     */
    protected final Element createElement(final String content) {
        return ValueConverter.convert(content, Element.class);
    }

    /**
     * Create document object.
     *
     * @param content the content.
     *
     * @return the created object.
     */
    protected final Document createDocument(final String content) {
        return ValueConverter.convert(content, Document.class);
    }

    /**
     * Create attr object.
     *
     * @param content the content.
     *
     * @return the created object.
     */
    protected final Attr createAttr(final String content) {
        Element element = createElement(content);
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            if (!XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(attr.getNamespaceURI())) {
                return attr;
            }
        }
        return null;
    }

    /**
     * Create character data object.
     *
     * @param content the content.
     *
     * @return the created object.
     */
    protected final CharacterData createCharacterData(final String content) {
        return (CharacterData) createNode(content);
    }

    private static final class NullFieldClass {

        private Object _field;

        NullFieldClass() {
            super();
        }

    }

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

        private final Date _date;

        private final Calendar _calendar;

        private final TimeZone _timeZone;

        private final InputStream _inputStream;

        private final Reader _reader;

        private final BufferedReader _bufferedReader;

        private final ByteBuffer _byteBuffer;

        private final ShortBuffer _shortBuffer;

        private final IntBuffer _intBuffer;

        private final LongBuffer _longBuffer;

        private final FloatBuffer _floatBuffer;

        private final DoubleBuffer _doubleBuffer;

        private final CharBuffer _charBuffer;

        private final XMLGregorianCalendar _xmlGregorianCalendar;

        private final QName _qname;

        private final Node _node;

        private final Element _element;

        private final Document _document;

        private final Attr _attr;

        private final CharacterData _characterData;

        PrivateFieldsClass(final AssertionTest assertionTest) {
            super();
            try {
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
                _date = assertionTest.createDate(2020, Calendar.JULY, 11, 15, 23, 47);
                _calendar = assertionTest.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
                _timeZone = TimeZone.getTimeZone("GMT");
                _inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
                _reader = new StringReader("123");
                _bufferedReader = new BufferedReader(new StringReader("1\n2\n3"));
                _byteBuffer = assertionTest.createByteBuffer(new byte[]{1, 2});
                _shortBuffer = assertionTest.createShortBuffer(new short[]{1, 2});
                _intBuffer = assertionTest.createIntBuffer(new int[]{1, 2});
                _longBuffer = assertionTest.createLongBuffer(new long[]{1L, 2L});
                _floatBuffer = assertionTest.createFloatBuffer(new float[]{1.0f, 2.0f});
                _doubleBuffer = assertionTest.createDoubleBuffer(new double[]{1.0f, 2.0f});
                _charBuffer = assertionTest.createCharBuffer(new char[]{'1', '2'});
                _xmlGregorianCalendar = assertionTest.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
                _qname = new QName("local");
                _node = assertionTest.createNode("<node>content</node>");
                _element = assertionTest.createElement("<element>content</element>");
                _document = assertionTest.createDocument("<document>content</document>");
                _attr = assertionTest.createAttr("<element attr='val'/>");
                _characterData = assertionTest.createCharacterData("<!-- character data -->");
            } catch (Exception ex) {
                throw new AssertionError(ex);
            }
        }

        byte getByte() {
            return _byte;
        }

        Byte getByteObj() {
            return _byteObj;
        }

        short getShort() {
            return _short;
        }

        Short getShortObj() {
            return _shortObj;
        }

        int getInt() {
            return _int;
        }

        Integer getIntObj() {
            return _intObj;
        }

        long getLong() {
            return _long;
        }

        Long getLongObj() {
            return _longObj;
        }

        float getFloat() {
            return _float;
        }

        Float getFloatObj() {
            return _floatObj;
        }

        double getDouble() {
            return _double;
        }

        Double getDoubleObj() {
            return _doubleObj;
        }

        boolean getBoolean() {
            return _boolean;
        }

        Boolean getBooleanObj() {
            return _booleanObj;
        }

        char getChar() {
            return _char;
        }

        Character getCharObj() {
            return _charObj;
        }

        Object getObject() {
            return _object;
        }

        byte[] getByteArray() {
            return _byteArray;
        }

        short[] getShortArray() {
            return _shortArray;
        }

        int[] getIntArray() {
            return _intArray;
        }

        long[] getLongArray() {
            return _longArray;
        }

        float[] getFloatArray() {
            return _floatArray;
        }

        double[] getDoubleArray() {
            return _doubleArray;
        }

        boolean[] getBooleanArray() {
            return _booleanArray;
        }

        char[] getCharArray() {
            return _charArray;
        }

        String[] getObjectArray() {
            return _objectArray;
        }

        Class<?> getClassObj() {
            return _class;
        }

        CharSequence getCharSequence() {
            return _charSequence;
        }

        String getString() {
            return _string;
        }

        Comparable<Integer> getComparable() {
            return _comparable;
        }

        Iterable<String> getIterable() {
            return _iterable;
        }

        Throwable getThrowable() {
            return _throwable;
        }

        Iterator<String> getIterator() {
            return _iterator;
        }

        List<String> getList() {
            return _list;
        }

        Set<String> getSet() {
            return _set;
        }

        SortedSet<String> getSortedSet() {
            return _sortedSet;
        }

        Map<String, String> getMap() {
            return _map;
        }

        SortedMap<String, String> getSortedMap() {
            return _sortedMap;
        }

        Date getDate() {
            return _date;
        }

        Calendar getCalendar() {
            return _calendar;
        }

        TimeZone getTimeZone() {
            return _timeZone;
        }

        InputStream getInputStream() {
            return _inputStream;
        }

        Reader getReader() {
            return _reader;
        }

        BufferedReader getBufferedReader() {
            return _bufferedReader;
        }

        ByteBuffer getByteBuffer() {
            return _byteBuffer;
        }

        ShortBuffer getShortBuffer() {
            return _shortBuffer;
        }

        IntBuffer getIntBuffer() {
            return _intBuffer;
        }

        LongBuffer getLongBuffer() {
            return _longBuffer;
        }

        FloatBuffer getFloatBuffer() {
            return _floatBuffer;
        }

        DoubleBuffer getDoubleBuffer() {
            return _doubleBuffer;
        }

        CharBuffer getCharBuffer() {
            return _charBuffer;
        }

        XMLGregorianCalendar getXmlGregorianCalendar() {
            return _xmlGregorianCalendar;
        }

        QName getQname() {
            return _qname;
        }

        Node getNode() {
            return _node;
        }

        Element getElement() {
            return _element;
        }

        Document getDocument() {
            return _document;
        }

        Attr getAttr() {
            return _attr;
        }

        CharacterData getCharacterData() {
            return _characterData;
        }

    }

    private static final class DuplicateSet<E> implements Set<E> {

        private final List<E> _elements;

        DuplicateSet() {
            super();
            _elements = new ArrayList<>();
        }

        @Override
        public int size() {
            return _elements.size();
        }

        @Override
        public boolean isEmpty() {
            return _elements.isEmpty();
        }

        @Override
        public boolean contains(final Object element) {
            return _elements.contains(element);
        }

        @Override
        public Iterator<E> iterator() {
            return _elements.iterator();
        }

        @Override
        public Object[] toArray() {
            return _elements.toArray(new Object[0]);
        }

        @Override
        public <T> T[] toArray(final T[] array) {
            return null;
        }

        @Override
        public boolean add(final E element) {
            _elements.add(element);
            return false;
        }

        @Override
        public boolean remove(final Object element) {
            return false;
        }

        @Override
        public boolean containsAll(final Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            for (E element : collection) {
                add(element);
            }
            return false;
        }

        @Override
        public boolean retainAll(final Collection<?> collection) {
            return false;
        }

        @Override
        public boolean removeAll(final Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {
            _elements.clear();
        }

    }

    private static final class DuplicateMap<K, V> implements Map<K, V> {

        private final List<K> _keys;

        private final List<V> _values;

        private final Map<K, Integer> _indices;

        DuplicateMap() {
            super();
            _keys = new ArrayList<>();
            _values = new ArrayList<>();
            _indices = new HashMap<>();
        }

        @Override
        public int size() {
            return _keys.size();
        }

        @Override
        public boolean isEmpty() {
            return _keys.isEmpty();
        }

        @Override
        public boolean containsKey(final Object key) {
            return false;
        }

        @Override
        public boolean containsValue(final Object value) {
            return false;
        }

        @Override
        public V get(final Object key) {
            int index = _indices.get(key);
            return _values.get(index);
        }

        @Override
        public V put(final K key, final V value) {
            _keys.add(key);
            _values.add(value);
            _indices.put(key, _keys.size() - 1);
            return null;
        }

        @Override
        public V remove(final Object key) {
            return null;
        }

        @Override
        public void putAll(final Map<? extends K, ? extends V> map) {

        }

        @Override
        public void clear() {
            _keys.clear();
            _values.clear();
            _indices.clear();
        }

        @Override
        public Set<K> keySet() {
            DuplicateSet<K> set = new DuplicateSet<>();
            set.addAll(_keys);
            return set;
        }

        @Override
        public Collection<V> values() {
            return _values;
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            DuplicateSet<Entry<K, V>> set = new DuplicateSet<>();
            for (int i = 0; i < _keys.size(); i++) {
                Entry<K, V> entry = new DuplicateMapEntry<>(_keys.get(i), _values.get(i));
                set.add(entry);
            }
            return set;
        }

    }

    private static final class DuplicateMapEntry<K, V> implements Map.Entry<K, V> {

        private final K _key;

        private final V _value;

        DuplicateMapEntry(final K key, final V value) {
            super();
            _key = key;
            _value = value;
        }

        @Override
        public K getKey() {
            return _key;
        }

        @Override
        public V getValue() {
            return _value;
        }

        @Override
        public V setValue(final V value) {
            return null;
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
        public void close() {
            // Ignore
        }

    }

}
