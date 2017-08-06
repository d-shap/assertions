///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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
package ru.d_shap.assertions.nio;

import java.nio.Buffer;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all buffer type assertions.
 *
 * @param <T> the buffer element type.
 * @author Dmitry Shapovalov
 */
abstract class BufferAssertion<T> extends ReferenceAssertion {

    BufferAssertion(final Buffer actual, final String message) {
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

    final void doContains(final T expected) {
        checkActualIsNotNull();
        createCollectionAssertion().contains(expected);
    }

    final void doDoesNotContain(final T expected) {
        checkActualIsNotNull();
        createCollectionAssertion().doesNotContain(expected);
    }

    @SafeVarargs
    final void doContainsAll(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAll((Object[]) expected);
    }

    final void doContainsAll(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAll(expected);
    }

    @SafeVarargs
    final void doContainsAllInOrder(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAllInOrder((Object[]) expected);
    }

    final void doContainsAllInOrder(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAllInOrder(expected);
    }

    @SafeVarargs
    final void doContainsExactly(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactly((Object[]) expected);
    }

    final void doContainsExactly(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactly(expected);
    }

    @SafeVarargs
    final void doContainsExactlyInOrder(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactlyInOrder((Object[]) expected);
    }

    final void doContainsExactlyInOrder(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsExactlyInOrder(expected);
    }

    @SafeVarargs
    final void doContainsAny(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAny((Object[]) expected);
    }

    final void doContainsAny(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsAny(expected);
    }

    @SafeVarargs
    final void doContainsNone(final T... expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsNone((Object[]) expected);
    }

    final void doContainsNone(final Iterable<T> expected) {
        checkActualIsNotNull();
        createCollectionAssertion().containsNone(expected);
    }

    /**
     * Make assertion about the actual value position.
     *
     * @return the assertion.
     */
    public final IntAssertion toPosition() {
        checkActualIsNotNull();
        return new IntAssertion(((Buffer) getActual()).position(), getMessage());
    }

    /**
     * Check if the actual value position is equal to the expected position.
     *
     * @param expected the expected position.
     */
    public final void hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value limit.
     *
     * @return the assertion.
     */
    public final IntAssertion toLimit() {
        checkActualIsNotNull();
        return new IntAssertion(((Buffer) getActual()).limit(), getMessage());
    }

    /**
     * Check if the actual value limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     */
    public final void hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value capacity.
     *
     * @return the assertion.
     */
    public final IntAssertion toCapacity() {
        checkActualIsNotNull();
        return new IntAssertion(((Buffer) getActual()).capacity(), getMessage());
    }

    /**
     * Check if the actual value capacity is equal to the expected capacity.
     *
     * @param expected the expected capacity.
     */
    public final void hasCapacity(final int expected) {
        toCapacity().isEqualTo(expected);
    }

    /**
     * Check if the actual value properties is equal to the expected properties.
     *
     * @param expectedPosition the expected position.
     * @param expectedLimit    the expected limit.
     * @param expectedCapacity the expected capacity.
     */
    public final void hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
        hasPosition(expectedPosition);
        hasLimit(expectedLimit);
        hasCapacity(expectedCapacity);
    }

    /**
     * Make assertion about the actual value remaining.
     *
     * @return the assertion.
     */
    public final IntAssertion toRemaining() {
        checkActualIsNotNull();
        return new IntAssertion(((Buffer) getActual()).remaining(), getMessage());
    }

    /**
     * Check if the actual value remaining is equal to the expected remaining.
     *
     * @param expected the expected remaining.
     */
    public final void hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
    }

    /**
     * Check if the actual value is direct.
     */
    public final void isDirect() {
        checkActualIsNotNull();
        if (!((Buffer) getActual()).isDirect()) {
            throw createAssertionError(FailMessages.getIsDirect());
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public final void isNotDirect() {
        checkActualIsNotNull();
        if (((Buffer) getActual()).isDirect()) {
            throw createAssertionError(FailMessages.getIsNotDirect());
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public final void isReadOnly() {
        checkActualIsNotNull();
        if (!((Buffer) getActual()).isReadOnly()) {
            throw createAssertionError(FailMessages.getIsReadOnly());
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public final void isNotReadOnly() {
        checkActualIsNotNull();
        if (!((Buffer) getActual()).isReadOnly()) {
            throw createAssertionError(FailMessages.getIsReadOnly());
        }
    }

    abstract CollectionAssertion createCollectionAssertion();

    @Override
    protected final String asString(final Object value) {
        return null;
    }

}
