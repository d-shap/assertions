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
public final class IteratorAssertion<E> extends ReferenceAssertion<IteratorAssertion<E>, Iterator<E>> {

    /**
     * Create new object.
     */
    public IteratorAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<Iterator<E>> getActualValueClass() {
        return (Class<Iterator<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Iterator.class;
    }

    /**
     * Check if the actual value has next value.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> hasNextValue() {
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
    public IteratorAssertion<E> doesNotHaveNextValue() {
        checkActualIsNotNull();
        if (getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_NEXT_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value does not contain any more elements.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isCompleted() {
        checkActualIsNotNull();
        if (getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_COMPLETED).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains more elements.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isNotCompleted() {
        checkActualIsNotNull();
        if (!getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_COMPLETED).build();
        }
        return this;
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class, 0);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL);
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param count the number of elements to get from the iterator.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        List<E> list = convertValue(getActual(), null, List.class, count);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT_NEXT, count);
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> toList(final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, 0);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL);
        return this;
    }

    /**
     * Make assertion about the iterator elements from the current position.
     *
     * @param count   the number of elements to get from the iterator.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> toList(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, count);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT_NEXT, count);
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isEmpty() {
        toList().isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isNullOrEmpty() {
        if (getActual() != null) {
            toList().isNullOrEmpty();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isNotEmpty() {
        toList().isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value's next element is equal to the expected value from the current position.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> isNextElementEqualTo(final E expected) {
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
    public final IteratorAssertion<E> areNextElementsEqualTo(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toList(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected values from the current position.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> areNextElementsEqualTo(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toList(expectedList.size()).containsExactlyInOrder(expectedList);
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
    public final IteratorAssertion<E> areAllElementsEqualTo(final E... expected) {
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
    public IteratorAssertion<E> areAllElementsEqualTo(final Iterable<E> expected) {
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
    public IteratorAssertion<E> contains(final E expected) {
        toList().contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> doesNotContain(final E expected) {
        toList().doesNotContain(expected);
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
    public final IteratorAssertion<E> containsAll(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toList().containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsAll(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toList().containsAll(expectedList);
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
    public final IteratorAssertion<E> containsAllInOrder(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toList().containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsAllInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toList().containsAllInOrder(expectedList);
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
    public final IteratorAssertion<E> containsExactly(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toList().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsExactly(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toList().containsExactly(expected);
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
    public final IteratorAssertion<E> containsExactlyInOrder(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toList().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsExactlyInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toList().containsExactlyInOrder(expected);
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
    public final IteratorAssertion<E> containsAny(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", false);
        toList().containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsAny(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", false);
        toList().containsAny(expectedList);
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
    public final IteratorAssertion<E> containsNone(final E... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toList().containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> containsNone(final Iterable<E> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<E> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toList().containsNone(expectedList);
        return this;
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public IntAssertion toSize() {
        return toList().toSize();
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> toSize(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        toList().toSize(matcher);
        return this;
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     *
     * @return current object for the chain call.
     */
    public IteratorAssertion<E> hasSize(final int expected) {
        toList().hasSize(expected);
        return this;
    }

}
