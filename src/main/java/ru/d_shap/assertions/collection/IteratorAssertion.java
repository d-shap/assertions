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

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the iterator.
 *
 * @author Dmitry Shapovalov
 */
public class IteratorAssertion extends ReferenceAssertion {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(Iterator.class);

    /**
     * Create new object.
     */
    public IteratorAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Make assertion about the iterator elements.
     *
     * @return the assertion.
     */
    public final ListAssertion toList() {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> list = new ArrayList<>();
        while (((Iterator<?>) getActual()).hasNext()) {
            Object element = ((Iterator<?>) getActual()).next();
            list.add(element);
        }
        return initializeAssertion(Raw.listAssertion(), list, Messages.Check.ACTUAL_ITERATOR_ELEMENTS);
    }

    /**
     * Make assertion about the iterator elements.
     *
     * @param size the number of elements to get from the iterator.
     * @return the assertion.
     */
    public final ListAssertion toList(final int size) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsValid(size > 0);
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < size && ((Iterator<?>) getActual()).hasNext(); i++) {
            Object element = ((Iterator<?>) getActual()).next();
            list.add(element);
        }
        return initializeAssertion(Raw.listAssertion(), list, Messages.Check.ACTUAL_ITERATOR_ELEMENTS);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        toList().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            toList().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        toList().isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     */
    public final void isNextElementsEqualTo(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toList(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     */
    public final void isNextElementsEqualTo(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toList(expectedArray.length).containsExactlyInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        toList().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        toList().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toList().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toList().containsAll(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toList().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toList().containsAllInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toList().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        toList().containsExactly(expectedArray);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toList().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        toList().containsExactlyInOrder(expectedArray);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.length == 0);
        toList().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyFalse(expectedArray.length == 0);
        toList().containsAny(expectedArray);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toList().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Object[] expectedArray = ValueConverter.toObjectArray(expected);
        checkArgumentIsNotEmptyTrue(expectedArray.length == 0);
        toList().containsNone(expectedArray);
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        return toList().toSize();
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toList().hasSize(expected);
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
