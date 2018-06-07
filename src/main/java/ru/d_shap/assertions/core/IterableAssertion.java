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
package ru.d_shap.assertions.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the iterable.
 *
 * @param <E> the generic type of the element.
 * @author Dmitry Shapovalov
 */
public class IterableAssertion<E> extends ReferenceAssertion<Iterable<E>> {

    /**
     * Create new object.
     */
    public IterableAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<Iterable<E>> getActualValueClass() {
        return (Class<Iterable<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Iterable.class;
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

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().doesNotContain(expected);
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
        createListAssertion().containsAll(expected);
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
        createListAssertion().containsAllInOrder(expected);
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
        createListAssertion().containsExactly(expected);
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
        createListAssertion().containsExactlyInOrder(expected);
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
        createListAssertion().containsAny(expected);
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
        createListAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkInitialized();
        checkActualIsNotNull();
        return createListAssertion().toSize();
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().hasSize(expected);
    }

    private ListAssertion<E> createListAssertion() {
        List<E> list = new ArrayList<>();
        Iterator<E> iterator = getActual().iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            list.add(element);
        }
        return initializeAssertion(Raw.<E>listAssertion(), list);
    }

}
