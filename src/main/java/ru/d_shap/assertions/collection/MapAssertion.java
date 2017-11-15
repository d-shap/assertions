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
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the map.
 *
 * @author Dmitry Shapovalov
 */
public class MapAssertion extends ReferenceAssertion {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(Map.class);

    /**
     * Create new object.
     */
    public MapAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (!((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_EMPTY);
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null && !((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NULL_OR_EMPTY);
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (((Map<?, ?>) getActual()).isEmpty()) {
            throw createAssertionError(Messages.Fail.IS_NOT_EMPTY);
        }
    }

    /**
     * Make assertion about the actual keys.
     *
     * @return the assertion.
     */
    public final SetAssertion toKeys() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(new SetAssertion(), ((Map<?, ?>) getActual()).keySet(), Messages.Check.ACTUAL_KEYS);
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
    public final void containsAllKeys(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toKeys().containsAll(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected keys exactly.
     *
     * @param expected the expected keys.
     */
    public final void containsKeysExactly(final Object... expected) {
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
    public final void containsKeysExactly(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        toKeys().containsExactly(expectedArray);
    }

    /**
     * Check if the actual value contains any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsAnyKey(final Object... expected) {
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
    public final void containsAnyKey(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyFalse(expectedArray.length == 0);
        toKeys().containsAny(expectedArray);
    }

    /**
     * Check if the actual value does NOT contain any of the expected keys.
     *
     * @param expected the expected keys.
     */
    public final void containsNoKey(final Object... expected) {
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
    public final void containsNoKey(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toKeys().containsNone(expectedArray);
    }

    /**
     * Make assertion about the actual values.
     *
     * @return the assertion.
     */
    public final CollectionAssertion toValues() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(new CollectionAssertion(), ((Map<?, ?>) getActual()).values(), Messages.Check.ACTUAL_VALUES);
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
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createEntrySetAssertion().containsAll(expected.entrySet());
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Map<?, ?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createEntrySetAssertion().containsExactly(expected.entrySet());
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Map<?, ?> expected) {
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
    public final void containsNone(final Map<?, ?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createEntrySetAssertion().containsNone(expected.entrySet());
    }

    private SetAssertion createEntrySetAssertion() {
        return initializeAssertion(new SetAssertion(), ((Map<?, ?>) getActual()).entrySet());
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(new IntAssertion(), ((Map<?, ?>) getActual()).size(), Messages.Check.ACTUAL_VALUE_SIZE);
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
