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
import java.util.List;
import java.util.RandomAccess;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the list.
 *
 * @param <E> the generic type of the element.
 * @author Dmitry Shapovalov
 */
public class ListAssertion<E> extends ReferenceAssertion<List<E>> {

    /**
     * Create new object.
     */
    public ListAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<List<E>> getActualValueClass() {
        return (Class<List<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return List.class;
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
     * Check if the actual value is the random access list.
     */
    public final void isRandomAccess() {
        toClass().isSubtypeOf(RandomAccess.class);
    }

    /**
     * Check if the actual value is NOT the random access list.
     */
    public final void isNotRandomAccess() {
        toClass().isNotSubtypeOf(RandomAccess.class);
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
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAll(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAll(expectedList);
    }

    private void containsAll(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> actualListCopy = new ArrayList<>(getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL, expected);
            }
        }
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
        List<?> expectedList = convertValue(expected, List.class);
        containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAllInOrder(expectedList);
    }

    private void containsAllInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> actualListCopy = new ArrayList<>(getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy = actualListCopy.subList(idx + 1, actualListCopy.size());
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL_IN_ORDER, expected);
            }
        }
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
        List<?> expectedList = convertValue(expected, List.class);
        containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactly(expectedList);
    }

    private void containsExactly(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        List<?> actualListCopy = new ArrayList<>(getActual());
        int elementCount = 0;
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
                elementCount++;
            }
        }
        if (!actualListCopy.isEmpty() || elementCount != expected.size()) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY, expected);
        }
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
        List<?> expectedList = convertValue(expected, List.class);
        containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactlyInOrder(expectedList);
    }

    private void containsExactlyInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        List<?> actualListCopy = new ArrayList<>(getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx == 0) {
                actualListCopy.remove(idx);
            } else {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expected);
            }
        }
        if (!actualListCopy.isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expected);
        }
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
        List<?> expectedList = convertValue(expected, List.class);
        containsAny(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAny(expectedList);
    }

    private void containsAny(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.isEmpty());
        List<?> actualListCopy = new ArrayList<>(getActual());
        boolean found = false;
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
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
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsNone(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsNone(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsNone(expectedList);
    }

    private void containsNone(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> actualListCopy = new ArrayList<>(getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_NONE, expected);
            }
        }
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
