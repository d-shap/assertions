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
import java.util.SortedSet;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the sorted set.
 *
 * @param <E> the generic type of the element.
 * @author Dmitry Shapovalov
 */
public class SortedSetAssertion<E> extends ReferenceAssertion<SortedSet<E>> {

    /**
     * Create new object.
     */
    public SortedSetAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<SortedSet<E>> getActualValueClass() {
        return (Class<SortedSet<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedSet.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (!getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && !getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NULL_OR_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_EMPTY).build();
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final E expected) {
        checkActualIsNotNull();
        if (!getActual().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.CONTAINS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final E expected) {
        checkActualIsNotNull();
        if (getActual().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param element upper element (exclusive) of the head set.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toHeadSet(final E element) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().headSet(element), Messages.Check.HEAD_ELEMENT, element);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param count the number of elements to get from the head.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toHeadSet(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getHeadSet(count), Messages.Check.HEAD_COUNT, count);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param element upper element (exclusive) of the head set.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadSet(final E element, final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().headSet(element), matcher, Messages.Check.HEAD_ELEMENT, element);
    }

    /**
     * Make assertion about the head set of the actual.
     *
     * @param count   the number of elements to get from the head.
     * @param matcher the hamcrest matcher.
     */
    public final void toHeadSet(final int count, final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getHeadSet(count), matcher, Messages.Check.HEAD_COUNT, count);
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
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toTailSet(final E element) {
        checkActualIsNotNull();
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getActual().tailSet(element), Messages.Check.TAIL_ELEMENT, element);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param count the number of elements to get from the tail.
     * @return the assertion.
     */
    public final SortedSetAssertion<E> toTailSet(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        return initializeAssertion(Raw.<E>sortedSetAssertion(), getTailSet(count), Messages.Check.TAIL_COUNT, count);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param element lower element (inclusive) of the tail set.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailSet(final E element, final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().tailSet(element), matcher, Messages.Check.TAIL_ELEMENT, element);
    }

    /**
     * Make assertion about the tail set of the actual.
     *
     * @param count   the number of elements to get from the tail.
     * @param matcher the hamcrest matcher.
     */
    public final void toTailSet(final int count, final Matcher<Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getTailSet(count), matcher, Messages.Check.TAIL_COUNT, count);
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
     */
    @SafeVarargs
    public final void containsAll(final E... expected) {
        createSetAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<E> expected) {
        createSetAssertion().containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAllInOrder(final E... expected) {
        createSetAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<E> expected) {
        createSetAssertion().containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactly(final E... expected) {
        createSetAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<E> expected) {
        createSetAssertion().containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsExactlyInOrder(final E... expected) {
        createSetAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<E> expected) {
        createSetAssertion().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAny(final E... expected) {
        createSetAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<E> expected) {
        createSetAssertion().containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsNone(final E... expected) {
        createSetAssertion().containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<E> expected) {
        createSetAssertion().containsNone(expected);
    }

    private SetAssertion<E> createSetAssertion() {
        return initializeAssertion(Raw.<E>setAssertion(), getActual());
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSize(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().size(), matcher, Messages.Check.SIZE);
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

}
