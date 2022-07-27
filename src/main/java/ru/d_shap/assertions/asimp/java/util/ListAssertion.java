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
import java.util.RandomAccess;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the list.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class ListAssertion<E> extends ReferenceAssertion<ListAssertion<E>, List<E>> {

    /**
     * Create new object.
     */
    public ListAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<List<E>> getActualValueClass() {
        return (Class<List<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return List.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public ListAssertion<E> isEmpty() {
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
    public ListAssertion<E> isNullOrEmpty() {
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
    public ListAssertion<E> isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is the random access list.
     *
     * @return current object for the chain call.
     */
    public ListAssertion<E> isRandomAccess() {
        toClass().isSubtypeOf(RandomAccess.class);
        return this;
    }

    /**
     * Check if the actual value is NOT the random access list.
     *
     * @return current object for the chain call.
     */
    public ListAssertion<E> isNotRandomAccess() {
        toClass().isNotSubtypeOf(RandomAccess.class);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ListAssertion<E> contains(final E expected) {
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
    public ListAssertion<E> doesNotContain(final E expected) {
        checkActualIsNotNull();
        if (getActual().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
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
    public final ListAssertion<E> containsAll(final E... expected) {
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
    public ListAssertion<E> containsAll(final Iterable<E> expected) {
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
    public final ListAssertion<E> containsAllInOrder(final E... expected) {
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
    public ListAssertion<E> containsAllInOrder(final Iterable<E> expected) {
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
    public final ListAssertion<E> containsExactly(final E... expected) {
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
    public ListAssertion<E> containsExactly(final Iterable<E> expected) {
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
    public final ListAssertion<E> containsExactlyInOrder(final E... expected) {
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
    public ListAssertion<E> containsExactlyInOrder(final Iterable<E> expected) {
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
    public final ListAssertion<E> containsAny(final E... expected) {
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
    public ListAssertion<E> containsAny(final Iterable<E> expected) {
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
    public final ListAssertion<E> containsNone(final E... expected) {
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
    public ListAssertion<E> containsNone(final Iterable<E> expected) {
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
    public ListAssertion<E> toSize(final Matcher<? super Integer> matcher) {
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
    public ListAssertion<E> hasSize(final int expected) {
        toSize().isEqualTo(expected);
        return this;
    }

    private IterableAssertion<E> createIterableAssertion() {
        return initializeAssertion(Raw.<E>iterableAssertion(), getActual());
    }

}
