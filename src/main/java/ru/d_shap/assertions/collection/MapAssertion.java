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

import java.util.HashMap;
import java.util.Map;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toKeys().containsAll(expectedArray);
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toKeys().containsAllInOrder(expectedArray);
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        toKeys().containsExactly(expectedArray);
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        toKeys().containsExactlyInOrder(expectedArray);
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyFalse(expectedArray.length == 0);
        toKeys().containsAny(expectedArray);
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
        K[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toKeys().containsNone(expectedArray);
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
     * @param expected the expected values.
     */
    public final void containsAll(final Map<K, V> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createEntrySetAssertion().containsAll(expected.entrySet());
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
        createEntrySetAssertion().containsAllInOrder(expected.entrySet());
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
        createEntrySetAssertion().containsExactly(expected.entrySet());
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
        createEntrySetAssertion().containsExactlyInOrder(expected.entrySet());
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
        createEntrySetAssertion().containsAny(expected.entrySet());
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
        createEntrySetAssertion().containsNone(expected.entrySet());
    }

    private SetAssertion<Map.Entry<K, V>> createEntrySetAssertion() {
        return initializeAssertion(Raw.<Map.Entry<K, V>>setAssertion(), getActual().entrySet());
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

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
