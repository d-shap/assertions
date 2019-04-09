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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the sorted map.
 *
 * @param <K> the generic type of the key.
 * @param <V> the generic type of the value.
 *
 * @author Dmitry Shapovalov
 */
public class SortedMapAssertion<K, V> extends ReferenceAssertion<SortedMap<K, V>> {

    /**
     * Create new object.
     */
    public SortedMapAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<SortedMap<K, V>> getActualValueClass() {
        return (Class<SortedMap<K, V>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedMap.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (!getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && !getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
    }

    /**
     * Make assertion about the actual keys.
     *
     * @return the assertion.
     */
    public final SortedSetAssertion<K> toKeys() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K>sortedSetAssertion(), (SortedSet<K>) getActual().keySet(), Messages.Check.KEYS);
    }

    /**
     * Make assertion about the actual keys.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toKeys(final Matcher<Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().keySet(), matcher, Messages.Check.KEYS);
    }

    /**
     * Check if the actual value contains the expected key.
     *
     * @param expected the expected key.
     */
    public final void containsKey(final K expected) {
        toKeys().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected key.
     *
     * @param expected the expected key.
     */
    public final void doesNotContainKey(final K expected) {
        toKeys().doesNotContain(expected);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param key upper key (exclusive) of the head key set.
     *
     * @return the assertion.
     */
    public final SortedSetAssertion<K> toHeadKeys(final K key) {
        return toKeys().toHeadSet(key);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param count the number of keys to get from the head key set.
     *
     * @return the assertion.
     */
    public final SortedSetAssertion<K> toHeadKeys(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return toKeys().toHeadSet(count);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param key     upper key (exclusive) of the head key set.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadKeys(final K key, final Matcher<Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        toKeys().toHeadSet(key, matcher);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param count   the number of keys to get from the head key set.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadKeys(final int count, final Matcher<Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        toKeys().toHeadSet(count, matcher);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param key lower key (inclusive) of the tail key set.
     *
     * @return the assertion.
     */
    public final SortedSetAssertion<K> toTailKeys(final K key) {
        return toKeys().toTailSet(key);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param count the number of keys to get from the tail key set.
     *
     * @return the assertion.
     */
    public final SortedSetAssertion<K> toTailKeys(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return toKeys().toTailSet(count);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param key     lower key (inclusive) of the tail key set.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailKeys(final K key, final Matcher<Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        toKeys().toTailSet(key, matcher);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param count   the number of keys to get from the tail key set.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailKeys(final int count, final Matcher<Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        toKeys().toTailSet(count, matcher);
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAllKeys(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0, true);
        toKeys().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAllKeys(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), true);
        toKeys().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAllKeysInOrder(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0, true);
        toKeys().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected keys.
     */
    public final void containsAllKeysInOrder(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), true);
        toKeys().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsKeysExactly(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toKeys().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    public final void containsKeysExactly(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        toKeys().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsKeysExactlyInOrder(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toKeys().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsKeysExactlyInOrder(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        toKeys().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAnyKey(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0, false);
        toKeys().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAnyKey(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), false);
        toKeys().containsAny(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsNoKey(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0, true);
        toKeys().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsNoKey(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), true);
        toKeys().containsNone(expectedList);
    }

    /**
     * Make assertion about the actual values.
     *
     * @return the assertion.
     */
    public final IterableAssertion<V> toValues() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<V>iterableAssertion(), getActual().values(), Messages.Check.VALUES);
    }

    /**
     * Make assertion about the actual values.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toValues(final Matcher<Iterable<V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().values(), matcher, Messages.Check.VALUES);
    }

    /**
     * Check if the actual value contains the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     */
    public final void containsEntry(final K expectedKey, final V expectedValue) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey, expectedValue);
        containsAll(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     */
    public final void doesNotContainEntry(final K expectedKey, final V expectedValue) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey, expectedValue);
        containsNone(expected);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param key upper key (exclusive) of the head map.
     *
     * @return the assertion.
     */
    public final SortedMapAssertion<K, V> toHeadMap(final K key) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getHeadMap(key), Messages.Check.HEAD_ELEMENT, key);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param count the number of elements to get from the head map.
     *
     * @return the assertion.
     */
    public final SortedMapAssertion<K, V> toHeadMap(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getHeadMap(count), Messages.Check.HEAD_COUNT, count);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param key     upper key (exclusive) of the head map.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadMap(final K key, final Matcher<Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getHeadMap(key), matcher, Messages.Check.HEAD_ELEMENT, key);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param count   the number of elements to get from the head map.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadMap(final int count, final Matcher<Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getHeadMap(count), matcher, Messages.Check.HEAD_COUNT, count);
    }

    private SortedMap<K, V> getHeadMap(final K key) {
        return getActual().headMap(key);
    }

    private SortedMap<K, V> getHeadMap(final int count) {
        if (getActual().size() <= count) {
            return getActual();
        } else {
            K key = getNthKey(count + 1);
            return getActual().headMap(key);
        }
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param key lower key (inclusive) of the tail map.
     *
     * @return the assertion.
     */
    public final SortedMapAssertion<K, V> toTailMap(final K key) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getTailMap(key), Messages.Check.TAIL_ELEMENT, key);
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param count the number of elements to get from the tail map.
     *
     * @return the assertion.
     */
    public final SortedMapAssertion<K, V> toTailMap(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getTailMap(count), Messages.Check.TAIL_COUNT, count);
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param key     lower key (inclusive) of the tail map.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailMap(final K key, final Matcher<Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getTailMap(key), matcher, Messages.Check.TAIL_ELEMENT, key);
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param count   the number of elements to get from the tail map.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailMap(final int count, final Matcher<Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getTailMap(count), matcher, Messages.Check.TAIL_COUNT, count);
    }

    private SortedMap<K, V> getTailMap(final K key) {
        return getActual().tailMap(key);
    }

    private SortedMap<K, V> getTailMap(final int count) {
        if (getActual().size() <= count) {
            return getActual();
        } else {
            K key = getNthKey(getActual().size() - count + 1);
            return getActual().tailMap(key);
        }
    }

    private K getNthKey(final int count) {
        Iterator<Map.Entry<K, V>> iterator = getActual().entrySet().iterator();
        for (int i = count - 2; i >= 0; i--) {
            iterator.next();
        }
        return iterator.next().getKey();
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsAll(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Map<K, V> expected) {
        createMapAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsAllInOrder(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Map<K, V> expected) {
        createMapAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     */
    public final void containsExactly() {
        Map<K, V> expected = new LinkedHashMap<>();
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsExactly(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Map<K, V> expected) {
        createMapAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     */
    public final void containsExactlyInOrder() {
        Map<K, V> expected = new LinkedHashMap<>();
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsExactlyInOrder(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Map<K, V> expected) {
        createMapAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsAny(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Map<K, V> expected) {
        createMapAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     */
    public final void containsNone(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     */
    public final void containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     */
    public final void containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     */
    public final void containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     * @param expectedKey3   the key of the expected entry.
     * @param expectedValue3 the value of the expected entry.
     * @param expectedKey4   the key of the expected entry.
     * @param expectedValue4 the value of the expected entry.
     * @param expectedKey5   the key of the expected entry.
     * @param expectedValue5 the value of the expected entry.
     */
    public final void containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Map<K, V> expected) {
        createMapAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSize(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().size(), matcher, Messages.Check.SIZE);
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

    private MapAssertion<K, V> createMapAssertion() {
        return initializeAssertion(Raw.<K, V>mapAssertion(), getActual());
    }

}
