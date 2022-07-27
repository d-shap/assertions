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
import java.util.SortedSet;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the sorted set.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class SortedSetAssertion<E> extends ReferenceAssertion<SortedSet<E>> {

    /**
     * Create new object.
     */
    public SortedSetAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<SortedSet<E>> getActualValueClass() {
        return (Class<SortedSet<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedSet.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> isEmpty() {
        checkActualIsNotNull();
        if (!getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> isNullOrEmpty() {
        if (getActual() != null && !getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> contains(final E expected) {
        checkActualIsNotNull();
        if (!getActual().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> doesNotContain(final E expected) {
        checkActualIsNotNull();
        if (getActual().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param element upper element (exclusive) of the head set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<E> toHeadSet(final E element) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getHeadSet(element), Messages.Check.ELEMENTS_HEAD_ELEMENT, element);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param count the number of elements to get from the head.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<E> toHeadSet(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getHeadSet(count), Messages.Check.ELEMENTS_HEAD_COUNT, count);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param element upper element (exclusive) of the head set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> toHeadSet(final E element, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getHeadSet(element), matcher, Messages.Check.ELEMENTS_HEAD_ELEMENT, element);
        return this;
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param count   the number of elements to get from the head.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> toHeadSet(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getHeadSet(count), matcher, Messages.Check.ELEMENTS_HEAD_COUNT, count);
        return this;
    }

    private SortedSet<E> getHeadSet(final E element) {
        return getActual().headSet(element);
    }

    private SortedSet<E> getHeadSet(final int count) {
        if (getActual().size() <= count) {
            return getActual();
        } else {
            E element = getNthElement(count + 1);
            return getActual().headSet(element);
        }
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param element lower element (inclusive) of the tail set.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<E> toTailSet(final E element) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getTailSet(element), Messages.Check.ELEMENTS_TAIL_ELEMENT, element);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param count the number of elements to get from the tail.
     *
     * @return the assertion.
     */
    public SortedSetAssertion<E> toTailSet(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getTailSet(count), Messages.Check.ELEMENTS_TAIL_COUNT, count);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param element lower element (inclusive) of the tail set.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> toTailSet(final E element, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getTailSet(element), matcher, Messages.Check.ELEMENTS_TAIL_ELEMENT, element);
        return this;
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param count   the number of elements to get from the tail.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> toTailSet(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getTailSet(count), matcher, Messages.Check.ELEMENTS_TAIL_COUNT, count);
        return this;
    }

    private SortedSet<E> getTailSet(final E element) {
        return getActual().tailSet(element);
    }

    private SortedSet<E> getTailSet(final int count) {
        if (getActual().size() <= count) {
            return getActual();
        } else {
            E element = getNthElement(getActual().size() - count + 1);
            return getActual().tailSet(element);
        }
    }

    private E getNthElement(final int count) {
        Iterator<E> iterator = getActual().iterator();
        for (int i = count - 2; i >= 0; i--) {
            iterator.next();
        }
        return iterator.next();
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final SortedSetAssertion<E> containsAll(final E... expected) {
        createIterableAssertion().containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsAll(final Iterable<E> expected) {
        createIterableAssertion().containsAll(expected);
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
    public final SortedSetAssertion<E> containsAllInOrder(final E... expected) {
        createIterableAssertion().containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsAllInOrder(final Iterable<E> expected) {
        createIterableAssertion().containsAllInOrder(expected);
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
    public final SortedSetAssertion<E> containsExactly(final E... expected) {
        createIterableAssertion().containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsExactly(final Iterable<E> expected) {
        createIterableAssertion().containsExactly(expected);
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
    public final SortedSetAssertion<E> containsExactlyInOrder(final E... expected) {
        createIterableAssertion().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsExactlyInOrder(final Iterable<E> expected) {
        createIterableAssertion().containsExactlyInOrder(expected);
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
    public final SortedSetAssertion<E> containsAny(final E... expected) {
        createIterableAssertion().containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsAny(final Iterable<E> expected) {
        createIterableAssertion().containsAny(expected);
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
    public final SortedSetAssertion<E> containsNone(final E... expected) {
        createIterableAssertion().containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> containsNone(final Iterable<E> expected) {
        createIterableAssertion().containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public IntAssertion toSize() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> toSize(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().size(), matcher, Messages.Check.SIZE);
        return this;
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     *
     * @return current object for the chain call.
     */
    public SortedSetAssertion<E> hasSize(final int expected) {
        toSize().isEqualTo(expected);
        return this;
    }

    private IterableAssertion<E> createIterableAssertion() {
        return initializeAssertion(Raw.<E>iterableAssertion(), getActual());
    }

}
