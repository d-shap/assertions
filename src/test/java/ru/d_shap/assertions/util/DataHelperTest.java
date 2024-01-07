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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.mock.MockOutputStream;
import ru.d_shap.assertions.mock.MockWriter;

/**
 * Tests for {@link DataHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class DataHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DataHelperTest() {
        super();
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(DataHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createIterableTest() {
        Assertions.assertThat(DataHelper.createIterable((String[]) null)).isNullOrEmpty();
        Assertions.assertThat(DataHelper.createIterable((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createIterable("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createIterable(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createIterable(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3, 2, 1);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createIteratorTest() {
        Assertions.assertThat(DataHelper.createIterator((String[]) null)).isNullOrEmpty();
        Assertions.assertThat(DataHelper.createIterator((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createIterator("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createIterator(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createIterator(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3, 2, 1);

        Iterator<Integer> iterator = DataHelper.createIterator(1, 2, 3);
        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo(1);
        iterator.remove();
        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo(2);
        iterator.remove();
        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo(3);
        iterator.remove();
        Assertions.assertThat(iterator.hasNext()).isFalse();
        try {
            iterator.next();
            Assertions.fail(DataHelper.class);
        } catch (NoSuchElementException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            iterator.remove();
            Assertions.fail(DataHelper.class);
        } catch (IllegalStateException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createArrayListTest() {
        Assertions.assertThat(DataHelper.createArrayList((String[]) null)).isNull();
        Assertions.assertThat(DataHelper.createArrayList((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createArrayList("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createArrayList(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createArrayList(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3, 2, 1);
        Assertions.assertThat(DataHelper.createArrayList(1, 2, 3)).isInstanceOf(ArrayList.class);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createLinkedListTest() {
        Assertions.assertThat(DataHelper.createLinkedList((String[]) null)).isNull();
        Assertions.assertThat(DataHelper.createLinkedList((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createLinkedList("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createLinkedList(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createLinkedList(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3, 2, 1);
        Assertions.assertThat(DataHelper.createLinkedList(1, 2, 3)).isInstanceOf(LinkedList.class);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createHashSetTest() {
        Assertions.assertThat(DataHelper.createHashSet((String[]) null)).isNull();
        Assertions.assertThat(DataHelper.createHashSet((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createHashSet("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createHashSet(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createHashSet(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createHashSet("a", null, "c", null, "b", null)).containsExactlyInOrder("a", null, "c", "b");
        Assertions.assertThat(DataHelper.createHashSet(1, 2, 3)).isInstanceOf(LinkedHashSet.class);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTreeSetTest() {
        Assertions.assertThat(DataHelper.createTreeSet((String[]) null)).isNullOrEmpty();
        Assertions.assertThat(DataHelper.createTreeSet((String) null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createTreeSet("a", "b", "c")).containsExactlyInOrder("a", "b", "c");
        Assertions.assertThat(DataHelper.createTreeSet(1, 2, 3)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createTreeSet(1, 2, 3, 2, 1)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(DataHelper.createTreeSet("a", null, "c", null, "b", null)).containsExactlyInOrder(null, "a", "b", "c");
        Assertions.assertThat(DataHelper.createTreeSet(null, null)).containsExactlyInOrder((String) null);
        Assertions.assertThat(DataHelper.createTreeSet(null, "a")).containsExactlyInOrder(null, "a");
        Assertions.assertThat(DataHelper.createTreeSet("a", null)).containsExactlyInOrder(null, "a");
        Assertions.assertThat(DataHelper.createTreeSet("a", "b")).containsExactlyInOrder("a", "b");
        Assertions.assertThat(DataHelper.createTreeSet(1, 2, 3)).isInstanceOf(TreeSet.class);

        Object object11 = new IntHolder(1);
        Assertions.assertThat(DataHelper.createTreeSet(object11)).containsExactlyInOrder(object11);
        Object object12 = new IntHolder(2);
        Object object13 = new IntHolder(3);
        Assertions.assertThat(DataHelper.createTreeSet(object11, object12, object13)).containsExactlyInOrder(object11, object12, object13);
        Assertions.assertThat(DataHelper.createTreeSet(object11, null, object13, object12)).containsExactlyInOrder(null, object11, object12, object13);

        Object object21 = new IntHolder(-2);
        Object object22 = new IntHolder(-1);
        Object object23 = new IntHolder(1);
        Object object24 = new IntHolder(2);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object22)).containsExactlyInOrder(object21, object22);
        Assertions.assertThat(DataHelper.createTreeSet(object22, object21)).containsExactlyInOrder(object21, object22);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object23)).containsExactlyInOrder(object21, object23);
        Assertions.assertThat(DataHelper.createTreeSet(object23, object21)).containsExactlyInOrder(object21, object23);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object24)).containsExactlyInOrder(object21, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object24, object21)).containsExactlyInOrder(object21, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object22, object23)).containsExactlyInOrder(object22, object23);
        Assertions.assertThat(DataHelper.createTreeSet(object23, object22)).containsExactlyInOrder(object22, object23);
        Assertions.assertThat(DataHelper.createTreeSet(object22, object24)).containsExactlyInOrder(object22, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object24, object22)).containsExactlyInOrder(object22, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object23, object24)).containsExactlyInOrder(object23, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object24, object23)).containsExactlyInOrder(object23, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object22, object23, object24)).containsExactlyInOrder(object21, object22, object23, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object23, object22, object24)).containsExactlyInOrder(object21, object22, object23, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object24, object23, object22)).containsExactlyInOrder(object21, object22, object23, object24);
        Assertions.assertThat(DataHelper.createTreeSet(object21, object23, object24, object22)).containsExactlyInOrder(object21, object22, object23, object24);

        Object object31 = new StringHolder("a");
        Object object32 = new StringHolder("aaa");
        Object object33 = new StringHolder("aa");
        Assertions.assertThat(DataHelper.createTreeSet(object31, object32)).containsExactlyInOrder(object31, object32);
        Assertions.assertThat(DataHelper.createTreeSet(object32, object31)).containsExactlyInOrder(object31, object32);
        Assertions.assertThat(DataHelper.createTreeSet(object31, object33)).containsExactlyInOrder(object31, object33);
        Assertions.assertThat(DataHelper.createTreeSet(object33, object31)).containsExactlyInOrder(object31, object33);
        Assertions.assertThat(DataHelper.createTreeSet(object32, object33)).containsExactlyInOrder(object33, object32);
        Assertions.assertThat(DataHelper.createTreeSet(object33, object32)).containsExactlyInOrder(object33, object32);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createHashMapTest() {
        Assertions.assertThat(DataHelper.createHashMap()).containsExactlyInOrder();
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1")).containsExactlyInOrder("key1", "value1");
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder("key1", "value1", "key2", "value2");
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3");
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4");
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5");
        Assertions.assertThat(DataHelper.createHashMap("key1", "value1")).isInstanceOf(LinkedHashMap.class);

        Assertions.assertThat(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key1", "value3", "key4", "value4", "key2", "value5")).containsExactlyInOrder("key1", "value3", "key2", "value5", "key4", "value4");
        Assertions.assertThat(DataHelper.createHashMap(null, "value1", "key2", "value2", null, "value3", "key4", "value4", "key5", "value5")).containsExactlyInOrder(null, "value3", "key2", "value2", "key4", "value4", "key5", "value5");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTreeMapTest() {
        Assertions.assertThat(DataHelper.createTreeMap()).containsExactlyInOrder();
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1")).containsExactlyInOrder("key1", "value1");
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder("key1", "value1", "key2", "value2");
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3");
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4");
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5");
        Assertions.assertThat(DataHelper.createTreeMap("key3", "value3", "key5", "value5", "key1", "value1", "key4", "value4", "key2", "value2")).containsExactlyInOrder("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5");
        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1")).isInstanceOf(TreeMap.class);

        Assertions.assertThat(DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key1", "value3", "key4", "value4", "key2", "value5")).containsExactlyInOrder("key1", "value3", "key2", "value5", "key4", "value4");
        Assertions.assertThat(DataHelper.createTreeMap(null, "value1", "key2", "value2", null, "value3", "key4", "value4", "key5", "value5")).containsExactlyInOrder(null, "value3", "key2", "value2", "key4", "value4", "key5", "value5");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDateTest() {
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDateMillisecondTest() {
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createDate(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin");
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
            Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createCalendarMillisecondTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin");
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
        Assertions.assertThat(DataHelper.createCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarTest() {
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, "UTC");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC");
        Assertions.assertThat(DataHelper.createUtcCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC");
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 2 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        TimeZone timeZone = TimeZone.getDefault();
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 7 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 2 * 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 60 * 60 * 1000);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
            Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 0);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 2 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createXmlCalendarMillisecondTimeZoneIdTest() {
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "UTC")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "UTC")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "UTC")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 7 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 14, 21, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.AUGUST, 15, 22, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 16, 23, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Asia/Vientiane")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 0, 15, 6, 888);

        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 2 * 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 60 * 60 * 1000);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.FEBRUARY, 15, 3, 12, 3, 555);
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.AUGUST, 16, 3, 13, 4, 666);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.FEBRUARY, 17, 5, 14, 5, 777);
        Assertions.assertThat(DataHelper.createXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, "Europe/Berlin")).hasUtcDateAndTime(1322, Calendar.AUGUST, 18, 6, 15, 6, 888);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarTest() {
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 0, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 0, 0);
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createUtcXmlCalendarMillisecondTest() {
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555)).hasTimeZoneDateAndTime(2020, Calendar.FEBRUARY, 15, 4, 12, 3, 555, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(2020, Calendar.AUGUST, 16, 5, 13, 4, 666)).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 16, 5, 13, 4, 666, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777)).hasTimeZoneDateAndTime(1322, Calendar.FEBRUARY, 17, 6, 14, 5, 777, 0);
        Assertions.assertThat(DataHelper.createUtcXmlCalendar(1322, Calendar.AUGUST, 18, 7, 15, 6, 888)).hasTimeZoneDateAndTime(1322, Calendar.AUGUST, 18, 7, 15, 6, 888, 0);
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createInputStreamBuilderTest() throws Exception {
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).buildInputStream().skip(10)).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).buildInputStream().read()).isEqualTo(1);
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createOutputStreamBuilderTest() throws Exception {
        MockOutputStream outputStream = (MockOutputStream) DataHelper.createOutputStreamBuilder().setContentSize(10).buildOutputStream();
        outputStream.write(1);
        outputStream.write(2);
        outputStream.write(3);
        outputStream.write(4);
        outputStream.write(5);
        Assertions.assertThat(outputStream.getContent()).containsExactlyInOrder(1, 2, 3, 4, 5);
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createReaderBuilderTest() throws Exception {
        Assertions.assertThat(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader().skip(10)).isEqualTo(3);
        Assertions.assertThat(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader().read()).isEqualTo('1');
        Assertions.assertThat(DataHelper.createReaderBuilder().setContent("row1\nrow2").buildBufferedReader().readLine()).isEqualTo("row1");
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createWriterBuilderTest() throws Exception {
        MockWriter writer = (MockWriter) DataHelper.createWriterBuilder().setContentSize(10).buildWriter();
        writer.write('1');
        writer.write('2');
        writer.write('3');
        writer.write('4');
        writer.write('5');
        Assertions.assertThat(writer.getContent()).containsExactlyInOrder('1', '2', '3', '4', '5');
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDatatypeFactoryTest() {
        DatatypeFactory datatypeFactory = DataHelper.createDatatypeFactory();
        datatypeFactory.newXMLGregorianCalendar();

        try {
            DataHelper.createDatatypeFactory(new DatatypeFactoryCreatorFailImpl());
            Assertions.fail(DataHelper.class);
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(DatatypeConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void createDocumentBuilderFactoryTest() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DataHelper.createDocumentBuilderFactory();
        Assertions.assertThat(documentBuilderFactory.isNamespaceAware()).isTrue();
        Assertions.assertThat(documentBuilderFactory.isXIncludeAware()).isTrue();
        Assertions.assertThat(documentBuilderFactory.getFeature(XMLConstants.FEATURE_SECURE_PROCESSING)).isTrue();
        Assertions.assertThat(documentBuilderFactory.getFeature("http://apache.org/xml/features/disallow-doctype-decl")).isTrue();

        try {
            DataHelper.createDocumentBuilderFactory(new DocumentBuilderFactoryCreatorFailImpl());
            Assertions.fail(DataHelper.class);
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(ParserConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createDocumentBuilderTest() {
        DocumentBuilder documentBuilder = DataHelper.createDocumentBuilder();
        Assertions.assertThat(documentBuilder.isNamespaceAware()).isTrue();
        Assertions.assertThat(documentBuilder.isXIncludeAware()).isTrue();

        try {
            DataHelper.createDocumentBuilder(new DocumentBuilderCreatorFailImpl());
            Assertions.fail(DataHelper.class);
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(ParserConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTransformerFactoryTest() {
        TransformerFactory transformerFactory = DataHelper.createTransformerFactory();
        Assertions.assertThat(transformerFactory.getAttribute(XMLConstants.ACCESS_EXTERNAL_DTD)).isEqualTo("");
        Assertions.assertThat(transformerFactory.getAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET)).isEqualTo("");
        Assertions.assertThat(transformerFactory.getFeature(XMLConstants.FEATURE_SECURE_PROCESSING)).isTrue();

        try {
            DataHelper.createTransformerFactory(new TransformerFactoryCreatorFailImpl());
            Assertions.fail(DataHelper.class);
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(TransformerConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void createTransformerTest() {
        Transformer transformer = DataHelper.createTransformer();
        Assertions.assertThat(transformer.getErrorListener()).isInstanceOf(DataHelper.TransformerNoopErrorListener.class);

        try {
            DataHelper.createTransformer(new TransformerCreatorFailImpl());
            Assertions.fail(DataHelper.class);
        } catch (DataException ex) {
            Assertions.assertThat(ex).hasCause(TransformerConfigurationException.class);
            Assertions.assertThat(ex).hasCauseMessage("test exception");
        }
    }

    /**
     * {@link DataHelper} class test.
     */
    @Test
    public void transformerNoopErrorListenerTest() {
        new DataHelper.TransformerNoopErrorListener().warning(null);
        new DataHelper.TransformerNoopErrorListener().error(null);
        new DataHelper.TransformerNoopErrorListener().fatalError(null);
    }

    private static final class IntHolder {

        private final int _value;

        IntHolder(final int value) {
            super();
            _value = value;
        }

        @Override
        public boolean equals(final Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof IntHolder)) {
                return false;
            }
            return _value == ((IntHolder) object)._value;
        }

        @Override
        public int hashCode() {
            return _value;
        }

        @Override
        public String toString() {
            return String.valueOf(_value);
        }

    }

    private static final class StringHolder implements Comparable<StringHolder> {

        private final String _value;

        StringHolder(final String value) {
            super();
            _value = value;
        }

        @Override
        public boolean equals(final Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof StringHolder)) {
                return false;
            }
            return _value.equals(((StringHolder) object)._value);
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public int compareTo(final StringHolder stringHolder) {
            return _value.length() - stringHolder._value.length();
        }

        @Override
        public String toString() {
            return _value;
        }

    }

    private static final class DatatypeFactoryCreatorFailImpl implements DataHelper.DatatypeFactoryCreator {

        DatatypeFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public DatatypeFactory newDatatypeFactory() throws DatatypeConfigurationException {
            throw new DatatypeConfigurationException("test exception");
        }

    }

    private static final class DocumentBuilderFactoryCreatorFailImpl implements DataHelper.DocumentBuilderFactoryCreator {

        DocumentBuilderFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public DocumentBuilderFactory newDocumentBuilderFactory() throws ParserConfigurationException {
            throw new ParserConfigurationException("test exception");
        }

    }

    private static final class DocumentBuilderCreatorFailImpl implements DataHelper.DocumentBuilderCreator {

        DocumentBuilderCreatorFailImpl() {
            super();
        }

        @Override
        public DocumentBuilder newDocumentBuilder(final DocumentBuilderFactory documentBuilderFactory) throws ParserConfigurationException {
            throw new ParserConfigurationException("test exception");
        }

    }

    private static final class TransformerFactoryCreatorFailImpl implements DataHelper.TransformerFactoryCreator {

        TransformerFactoryCreatorFailImpl() {
            super();
        }

        @Override
        public TransformerFactory newTransformerFactory() throws TransformerConfigurationException {
            throw new TransformerConfigurationException("test exception");
        }

    }

    private static final class TransformerCreatorFailImpl implements DataHelper.TransformerCreator {

        TransformerCreatorFailImpl() {
            super();
        }

        @Override
        public Transformer newTransformer(final TransformerFactory transformerFactory) throws TransformerException {
            throw new TransformerConfigurationException("test exception");
        }

    }

}
