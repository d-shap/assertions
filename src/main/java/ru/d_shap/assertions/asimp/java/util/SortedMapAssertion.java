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
public final class SortedMapAssertion<K, V> extends ReferenceAssertion<SortedMapAssertion<K, V>, SortedMap<K, V>> {

    /**
     * Create new object.
     */
    public SortedMapAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<SortedMap<K, V>> getActualValueClass() {
        return (Class<SortedMap<K, V>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedMap.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> isEmpty() {
        checkActualIsNotNull();
        if (!getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> isNullOrEmpty() {
        if (getActual() != null && !getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> isEqualTo(final SortedMap<K, V> expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> isNotEqualTo(final SortedMap<K, V> expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Make assertion about the actual keys.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<K> toKeys() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K>sortedSetAssertion(), (SortedSet<K>) getActual().keySet(), Messages.Check.KEYS);
    }

    /**
     * Make assertion about the actual keys.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toKeys(final Matcher<? super Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().keySet(), matcher, Messages.Check.KEYS);
        return this;
    }

    /**
     * Check if the actual value contains the expected key.
     *
     * @param expected the expected key.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsKey(final K expected) {
        toKeys().contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected key.
     *
     * @param expected the expected key.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> doesNotContainKey(final K expected) {
        toKeys().doesNotContain(expected);
        return this;
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param key upper key (exclusive) of the head key set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<K> toHeadKeys(final K key) {
        return toKeys().toHeadSet(key);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param count the number of keys to get from the head key set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<K> toHeadKeys(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return toKeys().toHeadSet(count);
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param key     upper key (exclusive) of the head key set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toHeadKeys(final K key, final Matcher<? super Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        toKeys().toHeadSet(key, matcher);
        return this;
    }

    /**
     * Make assertion about the head key set of the actual.
     *
     * @param count   the number of keys to get from the head key set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toHeadKeys(final int count, final Matcher<? super Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        toKeys().toHeadSet(count, matcher);
        return this;
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param key lower key (inclusive) of the tail key set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<K> toTailKeys(final K key) {
        return toKeys().toTailSet(key);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param count the number of keys to get from the tail key set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<K> toTailKeys(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return toKeys().toTailSet(count);
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param key     lower key (inclusive) of the tail key set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toTailKeys(final K key, final Matcher<? super Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        toKeys().toTailSet(key, matcher);
        return this;
    }

    /**
     * Make assertion about the tail key set of the actual.
     *
     * @param count   the number of keys to get from the tail key set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toTailKeys(final int count, final Matcher<? super Iterable<K>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        toKeys().toTailSet(count, matcher);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsAllKeys(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toKeys().containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllKeys(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<K> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toKeys().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsAllKeysInOrder(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toKeys().containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllKeysInOrder(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<K> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toKeys().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsKeysExactly(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toKeys().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsKeysExactly(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toKeys().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsKeysExactlyInOrder(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toKeys().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected keys exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsKeysExactlyInOrder(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toKeys().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsAnyKey(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", false);
        toKeys().containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAnyKey(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<K> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", false);
        toKeys().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedMapAssertion<K, V> containsNoKey(final K... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toKeys().containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNoKey(final Iterable<K> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<K> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toKeys().containsNone(expectedList);
        return this;
    }

    /**
     * Make assertion about the actual values.
     *
     * @return the assertion.
     */
    public IterableAssertion<V> toValues() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<V>iterableAssertion(), getActual().values(), Messages.Check.VALUES);
    }

    /**
     * Make assertion about the actual values.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toValues(final Matcher<? super Iterable<V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().values(), matcher, Messages.Check.VALUES);
        return this;
    }

    /**
     * Check if the actual value contains the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsEntry(final K expectedKey, final V expectedValue) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey, expectedValue);
        containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> doesNotContainEntry(final K expectedKey, final V expectedValue) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey, expectedValue);
        containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param key upper key (exclusive) of the head map.
     *
     * @return the assertion.
     */
    public SortedMapAssertion<K, V> toHeadMap(final K key) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getHeadMap(key), Messages.Check.ELEMENTS_HEAD_ELEMENT, key);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param count the number of elements to get from the head map.
     *
     * @return the assertion.
     */
    public SortedMapAssertion<K, V> toHeadMap(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getHeadMap(count), Messages.Check.ELEMENTS_HEAD_COUNT, count);
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param key     upper key (exclusive) of the head map.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toHeadMap(final K key, final Matcher<? super Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getHeadMap(key), matcher, Messages.Check.ELEMENTS_HEAD_ELEMENT, key);
        return this;
    }

    /**
     * Make assertion about the head map of the actual.
     *
     * @param count   the number of elements to get from the head map.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toHeadMap(final int count, final Matcher<? super Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getHeadMap(count), matcher, Messages.Check.ELEMENTS_HEAD_COUNT, count);
        return this;
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
    public SortedMapAssertion<K, V> toTailMap(final K key) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getTailMap(key), Messages.Check.ELEMENTS_TAIL_ELEMENT, key);
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param count the number of elements to get from the tail map.
     *
     * @return the assertion.
     */
    public SortedMapAssertion<K, V> toTailMap(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return initializeAssertion(Raw.<K, V>sortedMapAssertion(), getTailMap(count), Messages.Check.ELEMENTS_TAIL_COUNT, count);
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param key     lower key (inclusive) of the tail map.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toTailMap(final K key, final Matcher<? super Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getTailMap(key), matcher, Messages.Check.ELEMENTS_TAIL_ELEMENT, key);
        return this;
    }

    /**
     * Make assertion about the tail map of the actual.
     *
     * @param count   the number of elements to get from the tail map.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toTailMap(final int count, final Matcher<? super Map<? extends K, ? extends V>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getTailMap(count), matcher, Messages.Check.ELEMENTS_TAIL_COUNT, count);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAll(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAll(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAll(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAll(final Map<K, V> expected) {
        createMapAssertion().containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAllInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAllInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAllInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAllInOrder(final Map<K, V> expected) {
        createMapAssertion().containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly() {
        Map<K, V> expected = new LinkedHashMap<>();
        containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsExactly(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsExactly(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsExactly(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactly(final Map<K, V> expected) {
        createMapAssertion().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder() {
        Map<K, V> expected = new LinkedHashMap<>();
        containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsExactlyInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsExactlyInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsExactlyInOrder(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsExactlyInOrder(final Map<K, V> expected) {
        createMapAssertion().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsAny(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsAny(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsAny(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsAny(final Map<K, V> expected) {
        createMapAssertion().containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final K expectedKey1, final V expectedValue1) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expectedKey1   the key of the expected entry.
     * @param expectedValue1 the value of the expected entry.
     * @param expectedKey2   the key of the expected entry.
     * @param expectedValue2 the value of the expected entry.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        containsNone(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        containsNone(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        containsNone(expected);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final K expectedKey1, final V expectedValue1, final K expectedKey2, final V expectedValue2, final K expectedKey3, final V expectedValue3, final K expectedKey4, final V expectedValue4, final K expectedKey5, final V expectedValue5) {
        Map<K, V> expected = new LinkedHashMap<>();
        expected.put(expectedKey1, expectedValue1);
        expected.put(expectedKey2, expectedValue2);
        expected.put(expectedKey3, expectedValue3);
        expected.put(expectedKey4, expectedValue4);
        expected.put(expectedKey5, expectedValue5);
        containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> containsNone(final Map<K, V> expected) {
        createMapAssertion().containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public IntAssertion toSize() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> toSize(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().size(), matcher, Messages.Check.SIZE);
        return this;
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     *
     * @return current object for the chain call.
     */
    public SortedMapAssertion<K, V> hasSize(final int expected) {
        toSize().isEqualTo(expected);
        return this;
    }

    private MapAssertion<K, V> createMapAssertion() {
        return initializeAssertion(Raw.<K, V>mapAssertion(), getActual());
    }

}
