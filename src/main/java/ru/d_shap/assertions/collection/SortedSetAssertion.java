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
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the sorted set.
 *
 * @param <E> the generic type of the sorted set element.
 * @author Dmitry Shapovalov
 */
public class SortedSetAssertion<E> extends ReferenceAssertion<SortedSet<E>> {

    /**
     * Create new object.
     */
    public SortedSetAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<SortedSet<E>> getActualValueClass() {
        return (Class<SortedSet<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedSet.class;
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
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS, expected);
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_CONTAIN, expected);
        }
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param element upper element (exclusive) of the head set.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toHeadSet(final E element) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(element);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().headSet(element), Messages.Check.ACTUAL_HEAD_ELEMENT + ": " + element);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param count the number of elements to get from the head.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toHeadSet(final int count) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        if (getActual().size() <= count) {
            return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual(), Messages.Check.ACTUAL_HEAD_COUNT + ": " + count);
        } else {
            E element = getNthElement(count + 1);
            return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().headSet(element), Messages.Check.ACTUAL_HEAD_COUNT + ": " + count);
        }
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param element lower element (inclusive) of the tail set.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toTailSet(final E element) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(element);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().tailSet(element), Messages.Check.ACTUAL_TAIL_ELEMENT + ": " + element);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param count the number of elements to get from the tail.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toTailSet(final int count) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        if (getActual().size() <= count) {
            return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual(), Messages.Check.ACTUAL_TAIL_COUNT + ": " + count);
        } else {
            E element = getNthElement(getActual().size() - count);
            return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().tailSet(element), Messages.Check.ACTUAL_TAIL_COUNT + ": " + count);
        }
    }

    private E getNthElement(final int count) {
        Iterator<E> iterator = getActual().iterator();
        for (int i = count - 2; i >= 0; i--) {
            iterator.next();
        }
        return iterator.next();
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAll(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        createListAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        createListAssertion().containsAll(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAllInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        createListAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        createListAssertion().containsAllInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactly(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createListAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        createListAssertion().containsExactly(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactlyInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        createListAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        createListAssertion().containsExactlyInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAny(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.length == 0);
        createListAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyFalse(expectedArray.length == 0);
        createListAssertion().containsAny(expectedArray);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsNone(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        createListAssertion().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        E[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        createListAssertion().containsNone(expectedArray);
    }

    private ListAssertion<E> createListAssertion() {
        List<E> list = new ArrayList<>(getActual());
        return initializeAssertion(Raw.<E>listAssertion(), list);
    }

    /**
     * Make assertion about the actual value size.
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
