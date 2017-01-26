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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the iterator.
 *
 * @author Dmitry Shapovalov
 */
public class IteratorAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public IteratorAssertion(final Iterator<?> actual, final String message) {
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

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        checkActualIsNotNull();
        createCollectionAssertion().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        checkActualIsNotNull();
        createCollectionAssertion().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in any order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInAnyOrder(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAllInAnyOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in any order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInAnyOrder(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactlyInAnyOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual collection size.
     *
     * @return assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return createCollectionAssertion().toSize();
    }

    /**
     * Check if the actual value size is equal to the expected collection size.
     *
     * @param expected the expected collection size.
     */
    public final void hasSize(final int expected) {
        checkActualIsNotNull();
        createCollectionAssertion().hasSize(expected);
    }

    private CollectionAssertion createCollectionAssertion() {
        Iterator<?> iterator = (Iterator<?>) getActual();
        List<Object> result = new LinkedList<>();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            result.add(item);
        }
        return new ListAssertion(result, getMessage());
    }

    @Override
    protected final String asString(final Object value) {
        return null;
    }

}
