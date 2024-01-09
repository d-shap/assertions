///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.util;

import java.util.List;
import java.util.ListIterator;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the list iterator.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class ListIteratorAssertion<E> extends ReferenceAssertion<ListIteratorAssertion<E>, ListIterator<E>> {

    /**
     * Create new object.
     */
    public ListIteratorAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<ListIterator<E>> getActualValueClass() {
        return (Class<ListIterator<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return ListIterator.class;
    }

    /**
     * Check if the actual value has next value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> hasNextValue() {
        checkActualIsNotNull();
        if (!getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_NEXT_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value does not have next value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> doesNotHaveNextValue() {
        checkActualIsNotNull();
        if (getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_NEXT_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value has previous value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> hasPreviousValue() {
        checkActualIsNotNull();
        if (!getActual().hasPrevious()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_PREVIOUS_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value does not have previous value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> doesNotHavePreviousValue() {
        checkActualIsNotNull();
        if (getActual().hasPrevious()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_PREVIOUS_VALUE).build();
        }
        return this;
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toNextList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class, 0, true);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL_NEXT);
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param count the number of elements to get from the list iterator.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toNextList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        List<E> list = convertValue(getActual(), null, List.class, count, true);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT_NEXT, count);
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toNextList(final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, 0, true);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL_NEXT);
        return this;
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param count   the number of elements to get from the list iterator.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toNextList(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, count, true);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT_NEXT, count);
        return this;
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toPreviousList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class, 0, false);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL_PREVIOUS);
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param count the number of elements to get from the list iterator.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toPreviousList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        List<E> list = convertValue(getActual(), null, List.class, count, false);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT_PREVIOUS, count);
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toPreviousList(final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, 0, false);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL_PREVIOUS);
        return this;
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param count   the number of elements to get from the list iterator.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toPreviousList(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, count, false);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT_PREVIOUS, count);
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> isEmpty() {
        toNextList().isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> isNullOrEmpty() {
        if (getActual() != null) {
            toNextList().isNullOrEmpty();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> isNotEmpty() {
        toNextList().isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value's next element is equal to the expected value from the current position.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> isNextElementEqualTo(final E expected) {
        areNextElementsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> areNextElementsEqualTo(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toNextList(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> areNextElementsEqualTo(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toNextList(expectedList.size()).containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value's previous element is equal to the expected value from the current position.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> isPreviousElementEqualTo(final E expected) {
        arePreviousElementsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> arePreviousElementsEqualTo(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toPreviousList(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> arePreviousElementsEqualTo(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toPreviousList(expectedList.size()).containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position and does not contain any more values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> areAllElementsEqualTo(final E... expected) {
        containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position and does not contain any more values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> areAllElementsEqualTo(final Iterable<E> expected) {
        containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> contains(final E expected) {
        toNextList().contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> doesNotContain(final E expected) {
        toNextList().doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsAll(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toNextList().containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsAll(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toNextList().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsAllInOrder(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toNextList().containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsAllInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toNextList().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsExactly(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNextList().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsExactly(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNextList().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsExactlyInOrder(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNextList().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsExactlyInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNextList().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsAny(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", false);
        toNextList().containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsAny(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", false);
        toNextList().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final ListIteratorAssertion<E> containsNone(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toNextList().containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> containsNone(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toNextList().containsNone(expectedList);
        return this;
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public IntAssertion toSize() {
        return toNextList().toSize();
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toSize(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        toNextList().toSize(matcher);
        return this;
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> hasSize(final int expected) {
        toNextList().hasSize(expected);
        return this;
    }

}
