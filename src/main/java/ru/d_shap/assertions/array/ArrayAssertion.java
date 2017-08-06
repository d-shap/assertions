///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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

import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all array type assertions.
 *
 * @param <T> the array element type.
 * @author Dmitry Shapovalov
 */
abstract class ArrayAssertion<T> extends ReferenceAssertion {

    ArrayAssertion(final Object actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        createCollectionAssertion().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null) {
            createCollectionAssertion().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        createCollectionAssertion().isNotEmpty();
    }

    final void doContains(final T expected) {
        checkActualIsNotNull();
        createCollectionAssertion().contains(expected);
    }

    final void doDoesNotContain(final T expected) {
        checkActualIsNotNull();
        createCollectionAssertion().doesNotContain(expected);
    }

    @SafeVarargs
    final void doContainsAll(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAll((Object[]) expected);
    }

    final void doContainsAll(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAll(expected);
    }

    @SafeVarargs
    final void doContainsAllInOrder(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAllInOrder((Object[]) expected);
    }

    final void doContainsAllInOrder(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAllInOrder(expected);
    }

    @SafeVarargs
    final void doContainsExactly(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactly((Object[]) expected);
    }

    final void doContainsExactly(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactly(expected);
    }

    @SafeVarargs
    final void doContainsExactlyInOrder(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactlyInOrder((Object[]) expected);
    }

    final void doContainsExactlyInOrder(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactlyInOrder(expected);
    }

    @SafeVarargs
    final void doContainsAny(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAny((Object[]) expected);
    }

    final void doContainsAny(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAny(expected);
    }

    @SafeVarargs
    final void doContainsNone(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsNone((Object[]) expected);
    }

    final void doContainsNone(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkActualIsNotNull();
        return createCollectionAssertion().toSize();
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        checkActualIsNotNull();
        createCollectionAssertion().hasSize(expected);
    }

    protected abstract CollectionAssertion createCollectionAssertion();

    @Override
    protected final String asString(final Object value) {
        return null;
    }

}
