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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the map.
 *
 * @param <K> the generic type of the key.
 * @param <V> the generic type of the value.
 * @author Dmitry Shapovalov
 */
public class MapAssertion<K, V> extends ReferenceAssertion<Map<K, V>> {

    /**
     * Create new object.
     */
    public MapAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<Map<K, V>> getActualValueClass() {
        return (Class<Map<K, V>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Map.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_EMPTY);
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null && !getActual().isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NULL_OR_EMPTY);
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw createAssertionError(Messages.Fail.IS_NOT_EMPTY);
        }
    }

    /**
     * Make assertion about the actual keys.
     *
     * @return the assertion.
     */
    public final SetAssertion<K> toKeys() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.<K>setAssertion(), getActual().keySet(), Messages.Check.ACTUAL_VALUE_KEYS);
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
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAllKeys(final K... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toKeys().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAllKeys(final Iterable<K> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toKeys().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAllKeysInOrder(final K... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toKeys().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllKeysInOrder(final Iterable<K> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toKeys().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsKeysExactly(final K... expected) {
        checkInitialized();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toKeys().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsKeysExactlyInOrder(final K... expected) {
        checkInitialized();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toKeys().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsAnyKey(final K... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.length == 0);
        toKeys().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAnyKey(final Iterable<K> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyFalse(expectedList.isEmpty());
        toKeys().containsAny(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    @SafeVarargs
    public final void containsNoKey(final K... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toKeys().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsNoKey(final Iterable<K> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toKeys().containsNone(expectedList);
    }

    /**
     * Make assertion about the actual values.
     *
     * @return the assertion.
     */
    public final IterableAssertion<V> toValues() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.<V>iterableAssertion(), getActual().values(), Messages.Check.ACTUAL_VALUE_VALUES);
    }

    /**
     * Check if the actual value contains the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     */
    public final void containsEntry(final K expectedKey, final V expectedValue) {
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
        expected.put(expectedKey, expectedValue);
        containsNone(expected);
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx >= 0 && isValuesEqual(expected, expectedKey)) {
                actualKeysCopy.remove(idx);
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL, expected);
            }
        }
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx >= 0 && isValuesEqual(expected, expectedKey)) {
                actualKeysCopy = actualKeysCopy.subList(idx + 1, actualKeysCopy.size());
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL_IN_ORDER, expected);
            }
        }
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        int elementCount = 0;
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx >= 0 && isValuesEqual(expected, expectedKey)) {
                actualKeysCopy.remove(idx);
                elementCount++;
            }
        }
        if (!actualKeysCopy.isEmpty() || elementCount != expected.size()) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY, expected);
        }
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx == 0 && isValuesEqual(expected, expectedKey)) {
                actualKeysCopy.remove(idx);
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expected);
            }
        }
        if (!actualKeysCopy.isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expected);
        }
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.isEmpty());
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        boolean found = false;
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx >= 0 && isValuesEqual(expected, expectedKey)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ANY, expected);
        }
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        Map<K, V> expected = new HashMap<>();
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<K> actualKeysCopy = new ArrayList<>(getActual().keySet());
        for (K expectedKey : expected.keySet()) {
            int idx = actualKeysCopy.indexOf(expectedKey);
            if (idx >= 0 && isValuesEqual(expected, expectedKey)) {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_NONE, expected);
            }
        }
    }

    private boolean isValuesEqual(final Map<K, V> expected, final K key) {
        V actualValue = getActual().get(key);
        V expectedValue = expected.get(key);
        return actualValue == null && expectedValue == null || actualValue != null && actualValue.equals(expectedValue);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().size(), Messages.Check.ACTUAL_VALUE_SIZE);
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

}
