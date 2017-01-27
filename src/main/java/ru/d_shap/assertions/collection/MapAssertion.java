///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the map.
 *
 * @author Dmitry Shapovalov
 */
public class MapAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual map.
     * @param message the assertion message.
     */
    public MapAssertion(final Map<?, ?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (!((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && !((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsNullOrEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsNotEmpty());
        }
    }

    /**
     * Make assertion about the actual keys.
     *
     * @return the assertion.
     */
    public final SetAssertion toKeys() {
        checkActualIsNotNull();
        return new SetAssertion(((Map<?, ?>) getActual()).keySet(), getMessage());
    }

    /**
     * Check if the actual value contains the expected key.
     *
     * @param expected the expected key.
     */
    public final void containsKey(final Object expected) {
        toKeys().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected key.
     *
     * @param expected the expected key.
     */
    public final void doesNotContainKey(final Object expected) {
        toKeys().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAllKeys(final Object... expected) {
        toKeys().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAllKeys(final Iterable<?> expected) {
        toKeys().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    public final void containsKeysExactly(final Object... expected) {
        toKeys().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    public final void containsKeysExactly(final Iterable<?> expected) {
        toKeys().containsExactly(expected);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAnyKey(final Object... expected) {
        toKeys().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAnyKey(final Iterable<?> expected) {
        toKeys().containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsNoKey(final Object... expected) {
        toKeys().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsNoKey(final Iterable<?> expected) {
        toKeys().containsNone(expected);
    }

    /**
     * Make assertion about the actual values.
     *
     * @return the assertion.
     */
    public final CollectionAssertion toValues() {
        checkActualIsNotNull();
        return new CollectionAssertion(((Map<?, ?>) getActual()).values(), getMessage());
    }

    /**
     * Check if the actual value contains the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     */
    public final void containsEntry(final Object expectedKey, final Object expectedValue) {
        Map<Object, Object> expected = new HashMap<>();
        expected.put(expectedKey, expectedValue);
        containsAll(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected entry.
     *
     * @param expectedKey   the key of the expected entry.
     * @param expectedValue the value of the expected entry.
     */
    public final void doesNotContainEntry(final Object expectedKey, final Object expectedValue) {
        Map<Object, Object> expected = new HashMap<>();
        expected.put(expectedKey, expectedValue);
        containsNone(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Map<?, ?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new SetAssertion(((Map<?, ?>) getActual()).entrySet(), getMessage()).containsAll(expected.entrySet());
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Map<?, ?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new SetAssertion(((Map<?, ?>) getActual()).entrySet(), getMessage()).containsExactly(expected.entrySet());
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Map<?, ?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new SetAssertion(((Map<?, ?>) getActual()).entrySet(), getMessage()).containsAny(expected.entrySet());
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Map<?, ?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new SetAssertion(((Map<?, ?>) getActual()).entrySet(), getMessage()).containsNone(expected.entrySet());
    }

    /**
     * Make assertion about the actual map size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return new IntAssertion(((Map<?, ?>) getActual()).size(), getMessage());
    }

    /**
     * Check if the actual value size is equal to the expected map size.
     *
     * @param expected the expected map size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

}
