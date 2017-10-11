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

import java.util.Iterator;
import java.util.List;

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the iterator.
 *
 * @author Dmitry Shapovalov
 */
public class IteratorAssertion extends ReferenceAssertion {

    private final IteratorCollector<?> _iteratorCollector;

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public IteratorAssertion(final Iterator<?> actual, final FailDescription failDescription) {
        super(actual, failDescription);
        _iteratorCollector = new IteratorCollector<>(actual);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        createListAssertion().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null) {
            createListAssertion().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        createListAssertion().isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     */
    public final void isNextElementsEqualTo(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        createListAssertion(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     */
    public final void isNextElementsEqualTo(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        createListAssertion(expectedArray.length).containsExactlyInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        checkActualIsNotNull();
        createListAssertion().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        checkActualIsNotNull();
        createListAssertion().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        checkActualIsNotNull();
        createListAssertion().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<?> expected) {
        checkActualIsNotNull();
        createListAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return createListAssertion().toSize();
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        checkActualIsNotNull();
        createListAssertion().hasSize(expected);
    }

    private ListAssertion createListAssertion() {
        List<?> list = _iteratorCollector.getAsList();
        return new ListAssertion(list, getFailDescription());
    }

    private ListAssertion createListAssertion(final int size) {
        List<?> list = _iteratorCollector.getAsList(size);
        return new ListAssertion(list, getFailDescription());
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

}
