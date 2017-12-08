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
package ru.d_shap.assertions.array;

import java.util.List;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all array type assertions.
 *
 * @param <T> the generic type of the actual value.
 * @param <E> the generic type of the element.
 * @author Dmitry Shapovalov
 */
abstract class ArrayAssertion<T, E> extends ReferenceAssertion<T> {

    ArrayAssertion() {
        super();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createListAssertion().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().isNotEmpty();
    }

    final void doContains(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().contains(expected);
    }

    final void doDoesNotContain(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().doesNotContain(expected);
    }

    @SafeVarargs
    final void doContainsAll(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAll(expected);
    }

    final void doContainsAll(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAll(expected);
    }

    @SafeVarargs
    final void doContainsAllInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAllInOrder(expected);
    }

    final void doContainsAllInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAllInOrder(expected);
    }

    @SafeVarargs
    final void doContainsExactly(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsExactly(expected);
    }

    final void doContainsExactly(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsExactly(expected);
    }

    @SafeVarargs
    final void doContainsExactlyInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsExactlyInOrder(expected);
    }

    final void doContainsExactlyInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsExactlyInOrder(expected);
    }

    @SafeVarargs
    final void doContainsAny(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAny(expected);
    }

    final void doContainsAny(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsAny(expected);
    }

    @SafeVarargs
    final void doContainsNone(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsNone(expected);
    }

    final void doContainsNone(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkInitialized();
        checkActualIsNotNull();
        List<E> list = createList(getActual());
        return initializeAssertion(Raw.intAssertion(), list.size(), Messages.Check.ACTUAL_VALUE_LENGTH);
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

    private ListAssertion<E> createListAssertion() {
        List<E> list = createList(getActual());
        return initializeAssertion(Raw.<E>listAssertion(), list);
    }

    abstract List<E> createList(Object value);

}
