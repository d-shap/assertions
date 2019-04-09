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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the iterator.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public class IteratorAssertion<E> extends ReferenceAssertion<Iterator<E>> {

    /**
     * Create new object.
     */
    public IteratorAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<Iterator<E>> getActualValueClass() {
        return (Class<Iterator<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Iterator.class;
    }

    /**
     * Check if the actual value does not contain any more elements.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        if (getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_COMPLETED).build();
        }
    }

    /**
     * Check if the actual value contains more elements.
     */
    public final void isNotCompleted() {
        checkActualIsNotNull();
        if (!getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_COMPLETED).build();
        }
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @return the assertion.
     */
    public final ListAssertion<E> toList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL);
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param count the number of elements to get from the iterator.
     *
     * @return the assertion.
     */
    public final ListAssertion<E> toList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        List<E> list = convertValue(getActual(), List.class, count);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT, count);
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toList(final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        List<E> list = convertValue(getActual(), List.class);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL);
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param count   the number of elements to get from the iterator.
     * @param matcher the hamcrest matcher.
     */
    public final void toList(final int count, final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        List<E> list = convertValue(getActual(), List.class, count);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT, count);
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
     * Check if the actual value's next element is equal to the expected value from the current position.
     *
     * @param expected the expected value.
     */
    public final void isNextElementEqualTo(final E expected) {
        isNotCompleted();
        E nextElement = getActual().next();
        initializeAssertion(Raw.objectAssertion(), nextElement, Messages.Check.NEXT_ELEMENT).isEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void isNextElementsEqualTo(final E... expected) {
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
    public final void isNextElementsEqualTo(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toList(expectedList.size()).containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains the expected values from the current position and does not contain any more values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void isAllElementsEqualTo(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toList().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected values from the current position and does not contain any more values.
     *
     * @param expected the expected values.
     */
    public final void isAllElementsEqualTo(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toList().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final E expected) {
        toList().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final E expected) {
        toList().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAll(final E... expected) {
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
    public final void containsAll(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toList().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAllInOrder(final E... expected) {
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
    public final void containsAllInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toList().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactly(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toList().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        toList().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactlyInOrder(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toList().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        toList().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAny(final E... expected) {
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
    public final void containsAny(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyFalse(expectedList.isEmpty());
        toList().containsAny(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsNone(final E... expected) {
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
    public final void containsNone(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<E> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toList().containsNone(expectedList);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        return toList().toSize();
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSize(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        toList().toSize(matcher);
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toList().hasSize(expected);
    }

}
