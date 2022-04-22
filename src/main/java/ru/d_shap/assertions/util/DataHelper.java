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
package ru.d_shap.assertions.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 * Helper class to create objects of various types.
 *
 * @author Dmitry Shapovalov
 */
public final class DataHelper {

    public static final String TIMEZONE_UTC = "UTC";

    public static final String TIMEZONE_GMT = "GMT";

    private DataHelper() {
        super();
    }

    /**
     * Create iterable object.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     *
     * @return the created object.
     */
    @SafeVarargs
    public static <E> Iterable<E> createIterable(final E... values) {
        List<E> list = Arrays.asList(values);
        return new IterableImpl<>(list);
    }

    /**
     * Create iterator object.
     *
     * @param values the values.
     * @param <E>    the generic type of the element.
     *
     * @return the created object.
     */
    @SafeVarargs
    public static <E> Iterator<E> createIterator(final E... values) {
        List<E> list = Arrays.asList(values);
        return new IteratorImpl<>(list);
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
    public static <E> Set<E> createHashSet(final E... values) {
        List<E> list = Arrays.asList(values);
        return new LinkedHashSet<>(list);
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
    public static <E> SortedSet<E> createTreeSet(final E... values) {
        SortedSet<E> sortedSet = new TreeSet<>(new NullFirstComparator<E>());
        sortedSet.addAll(Arrays.asList(values));
        return sortedSet;
    }

    /**
     * Create hash map object.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     *
     * @return the created object.
     */
    public static <K, V> Map<K, V> createHashMap() {
        Map<K, V> map = new LinkedHashMap<>();
        return map;
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
    public static <K, V> Map<K, V> createHashMap(final K key, final V value) {
        Map<K, V> map = createHashMap();
        map.put(key, value);
        return map;
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
    public static <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2) {
        Map<K, V> map = createHashMap(key1, value1);
        map.put(key2, value2);
        return map;
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
    public static <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        Map<K, V> map = createHashMap(key1, value1, key2, value2);
        map.put(key3, value3);
        return map;
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
    public static <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        Map<K, V> map = createHashMap(key1, value1, key2, value2, key3, value3);
        map.put(key4, value4);
        return map;
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
    public static <K, V> Map<K, V> createHashMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        Map<K, V> map = createHashMap(key1, value1, key2, value2, key3, value3, key4, value4);
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
    public static <K, V> SortedMap<K, V> createTreeMap() {
        SortedMap<K, V> sortedMap = new TreeMap<>(new NullFirstComparator<K>());
        return sortedMap;
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
    public static <K, V> SortedMap<K, V> createTreeMap(final K key, final V value) {
        SortedMap<K, V> sortedMap = createTreeMap();
        sortedMap.put(key, value);
        return sortedMap;
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
    public static <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2) {
        SortedMap<K, V> sortedMap = createTreeMap(key1, value1);
        sortedMap.put(key2, value2);
        return sortedMap;
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
    public static <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3) {
        SortedMap<K, V> sortedMap = createTreeMap(key1, value1, key2, value2);
        sortedMap.put(key3, value3);
        return sortedMap;
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
    public static <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4) {
        SortedMap<K, V> sortedMap = createTreeMap(key1, value1, key2, value2, key3, value3);
        sortedMap.put(key4, value4);
        return sortedMap;
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
    public static <K, V> SortedMap<K, V> createTreeMap(final K key1, final V value1, final K key2, final V value2, final K key3, final V value3, final K key4, final V value4, final K key5, final V value5) {
        SortedMap<K, V> sortedMap = createTreeMap(key1, value1, key2, value2, key3, value3, key4, value4);
        sortedMap.put(key5, value5);
        return sortedMap;
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
    public static Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createDate(year, month, dayOfMonth, hourOfDay, minute, second, 0);
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
    public static Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar.getTime();
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
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
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
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = new GregorianCalendar();
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
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
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0, timeZoneId);
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
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        Calendar calendar = new GregorianCalendar();
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        calendar.setTimeZone(timeZone);
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
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
    public static Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
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
    public static Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
        Calendar calendar = new GregorianCalendar(timeZone);
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    private static void fillCalendarValues(final Calendar calendar, final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        GregorianCalendar calendar = (GregorianCalendar) createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return convertToXmlCalendar(calendar);
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0, timeZoneId);
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        GregorianCalendar calendar = (GregorianCalendar) createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond, timeZoneId);
        return convertToXmlCalendar(calendar);
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
    public static XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createUtcXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
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
    public static XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        GregorianCalendar calendar = (GregorianCalendar) createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return convertToXmlCalendar(calendar);
    }

    static XMLGregorianCalendar convertToXmlCalendar(final GregorianCalendar calendar) {
        DatatypeFactory datatypeFactory = createDatatypeFactory();
        return datatypeFactory.newXMLGregorianCalendar(calendar);
    }

    /**
     * Create XML Datatype Factory instance.
     *
     * @return XML Datatype Factory instance.
     */
    public static DatatypeFactory createDatatypeFactory() {
        DatatypeFactoryCreator datatypeFactoryCreator = new DatatypeFactoryCreatorImpl();
        return createDatatypeFactory(datatypeFactoryCreator);
    }

    static DatatypeFactory createDatatypeFactory(final DatatypeFactoryCreator datatypeFactoryCreator) {
        try {
            return datatypeFactoryCreator.newDatatypeFactory();
        } catch (DatatypeConfigurationException ex) {
            throw new DataException(ex);
        }
    }

    /**
     * Create XML Document Builder Factory instance.
     *
     * @return XML Document Builder Factory instance.
     */
    public static DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactoryCreator documentBuilderFactoryCreator = new DocumentBuilderFactoryCreatorImpl();
        return createDocumentBuilderFactory(documentBuilderFactoryCreator);
    }

    static DocumentBuilderFactory createDocumentBuilderFactory(final DocumentBuilderFactoryCreator documentBuilderFactoryCreator) {
        try {
            return documentBuilderFactoryCreator.newDocumentBuilderFactory();
        } catch (ParserConfigurationException ex) {
            throw new DataException(ex);
        }
    }

    /**
     * Create XML Document Builder instance.
     *
     * @return XML Document Builder instance.
     */
    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderCreator documentBuilderCreator = new DocumentBuilderCreatorImpl();
        return createDocumentBuilder(documentBuilderCreator);
    }

    static DocumentBuilder createDocumentBuilder(final DocumentBuilderCreator documentBuilderCreator) {
        try {
            DocumentBuilderFactory documentBuilderFactory = createDocumentBuilderFactory();
            return documentBuilderCreator.newDocumentBuilder(documentBuilderFactory);
        } catch (ParserConfigurationException ex) {
            throw new DataException(ex);
        }
    }

    /**
     * Create XML Transformer Factory instance.
     *
     * @return XML Transformer Factory instance.
     */
    public static TransformerFactory createTransformerFactory() {
        TransformerFactoryCreator transformerFactoryCreator = new TransformerFactoryCreatorImpl();
        return createTransformerFactory(transformerFactoryCreator);
    }

    static TransformerFactory createTransformerFactory(final TransformerFactoryCreator transformerFactoryCreator) {
        try {
            return transformerFactoryCreator.newTransformerFactory();
        } catch (TransformerConfigurationException ex) {
            throw new DataException(ex);
        }
    }

    /**
     * Create XML Transformer instance.
     *
     * @return XML Transformer instance.
     */
    public static Transformer createTransformer() {
        TransformerCreator transformerCreator = new TransformerCreatorImpl();
        return createTransformer(transformerCreator);
    }

    static Transformer createTransformer(final TransformerCreator transformerCreator) {
        try {
            TransformerFactory transformerFactory = createTransformerFactory();
            return transformerCreator.newTransformer(transformerFactory);
        } catch (TransformerException ex) {
            throw new DataException(ex);
        }
    }

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

    interface DatatypeFactoryCreator {

        /**
         * Create XML Datatype Factory instance.
         *
         * @return XML Datatype Factory instance.
         *
         * @throws DatatypeConfigurationException if creation exception occured.
         */
        DatatypeFactory newDatatypeFactory() throws DatatypeConfigurationException;

    }

    static final class DatatypeFactoryCreatorImpl implements DatatypeFactoryCreator {

        DatatypeFactoryCreatorImpl() {
            super();
        }

        @Override
        public DatatypeFactory newDatatypeFactory() throws DatatypeConfigurationException {
            return DatatypeFactory.newInstance();
        }

    }

    interface DocumentBuilderFactoryCreator {

        /**
         * Create XML Document Builder Factory instance.
         *
         * @return XML Document Builder Factory instance.
         *
         * @throws ParserConfigurationException if creation exception occured.
         */
        DocumentBuilderFactory newDocumentBuilderFactory() throws ParserConfigurationException;

    }

    static final class DocumentBuilderFactoryCreatorImpl implements DocumentBuilderFactoryCreator {

        DocumentBuilderFactoryCreatorImpl() {
            super();
        }

        @Override
        public DocumentBuilderFactory newDocumentBuilderFactory() throws ParserConfigurationException {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setXIncludeAware(true);
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            return documentBuilderFactory;
        }

    }

    interface DocumentBuilderCreator {

        /**
         * Create XML Document Builder instance.
         *
         * @param documentBuilderFactory XML Document Builder Factory instance.
         *
         * @return XML Document Builder instance.
         *
         * @throws ParserConfigurationException if creation exception occured.
         */
        DocumentBuilder newDocumentBuilder(DocumentBuilderFactory documentBuilderFactory) throws ParserConfigurationException;

    }

    static final class DocumentBuilderCreatorImpl implements DocumentBuilderCreator {

        DocumentBuilderCreatorImpl() {
            super();
        }

        @Override
        public DocumentBuilder newDocumentBuilder(final DocumentBuilderFactory documentBuilderFactory) throws ParserConfigurationException {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setErrorHandler(null);
            return documentBuilder;
        }

    }

    interface TransformerFactoryCreator {

        /**
         * Create XML Transformer Factory instance.
         *
         * @return XML Transformer Factory instance.
         *
         * @throws TransformerConfigurationException if creation exception occured.
         */
        TransformerFactory newTransformerFactory() throws TransformerConfigurationException;

    }

    static final class TransformerFactoryCreatorImpl implements TransformerFactoryCreator {

        TransformerFactoryCreatorImpl() {
            super();
        }

        @Override
        public TransformerFactory newTransformerFactory() throws TransformerConfigurationException {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            return transformerFactory;
        }

    }

    interface TransformerCreator {

        /**
         * Create XML Transformer instance.
         *
         * @param transformerFactory XML Transformer Factory instance.
         *
         * @return XML Transformer instance.
         *
         * @throws TransformerException if creation exception occured.
         */
        Transformer newTransformer(TransformerFactory transformerFactory) throws TransformerException;

    }

    static final class TransformerCreatorImpl implements TransformerCreator {

        TransformerCreatorImpl() {
            super();
        }

        @Override
        public Transformer newTransformer(final TransformerFactory transformerFactory) throws TransformerException {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setErrorListener(new TransformerNoopErrorListener());
            return transformer;
        }

    }

    static final class TransformerNoopErrorListener implements ErrorListener {

        TransformerNoopErrorListener() {
            super();
        }

        @Override
        public void warning(final TransformerException exception) {
            // Ignore
        }

        @Override
        public void error(final TransformerException exception) {
            // Ignore
        }

        @Override
        public void fatalError(final TransformerException exception) {
            // Ignore
        }

    }

}
