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
package ru.d_shap.assertions.nio;

import java.nio.Buffer;
import java.util.List;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all buffer type assertions.
 *
 * @param <T> the generic type of the actual value.
 * @param <E> the generic type of the element.
 * @author Dmitry Shapovalov
 */
abstract class BufferAssertion<T extends Buffer, E> extends ReferenceAssertion<T> {

    BufferAssertion() {
        super();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).isEmpty();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isRewindAndEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createListAssertion(false).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isRewindAndNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createListAssertion(true).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).isNotEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isRewindAndNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).isNotEmpty();
    }

    final void doContains(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).contains(expected);
    }

    final void doRewindAndContains(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).contains(expected);
    }

    final void doDoesNotContain(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).doesNotContain(expected);
    }

    final void doRewindAndDoesNotContain(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).doesNotContain(expected);
    }

    @SafeVarargs
    final void doContainsAll(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAll(expected);
    }

    final void doContainsAll(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAll(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsAll(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAll(expected);
    }

    final void doRewindAndContainsAll(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAll(expected);
    }

    @SafeVarargs
    final void doContainsAllInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAllInOrder(expected);
    }

    final void doContainsAllInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAllInOrder(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsAllInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAllInOrder(expected);
    }

    final void doRewindAndContainsAllInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAllInOrder(expected);
    }

    @SafeVarargs
    final void doContainsExactly(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsExactly(expected);
    }

    final void doContainsExactly(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsExactly(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsExactly(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsExactly(expected);
    }

    final void doRewindAndContainsExactly(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsExactly(expected);
    }

    @SafeVarargs
    final void doContainsExactlyInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsExactlyInOrder(expected);
    }

    final void doContainsExactlyInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsExactlyInOrder(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsExactlyInOrder(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsExactlyInOrder(expected);
    }

    final void doRewindAndContainsExactlyInOrder(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsExactlyInOrder(expected);
    }

    @SafeVarargs
    final void doContainsAny(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAny(expected);
    }

    final void doContainsAny(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsAny(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsAny(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAny(expected);
    }

    final void doRewindAndContainsAny(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsAny(expected);
    }

    @SafeVarargs
    final void doContainsNone(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsNone(expected);
    }

    final void doContainsNone(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(false).containsNone(expected);
    }

    @SafeVarargs
    final void doRewindAndContainsNone(final E... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsNone(expected);
    }

    final void doRewindAndContainsNone(final Iterable<E> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion(true).containsNone(expected);
    }

    /**
     * Make assertion about the actual buffer's position.
     *
     * @return the assertion.
     */
    public final IntAssertion toPosition() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().position(), Messages.Check.ACTUAL_VALUE_POSITION);
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
     * Make assertion about the actual buffer's limit.
     *
     * @return the assertion.
     */
    public final IntAssertion toLimit() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().limit(), Messages.Check.ACTUAL_VALUE_LIMIT);
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
     * Make assertion about the actual buffer's capacity.
     *
     * @return the assertion.
     */
    public final IntAssertion toCapacity() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().capacity(), Messages.Check.ACTUAL_VALUE_CAPACITY);
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
     * Make assertion about the actual buffer's remaining.
     *
     * @return the assertion.
     */
    public final IntAssertion toRemaining() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().remaining(), Messages.Check.ACTUAL_VALUE_REMAINING);
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
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isDirect()) {
            throw createAssertionError(Messages.Fail.IS_DIRECT);
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public final void isNotDirect() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw createAssertionError(Messages.Fail.IS_NOT_DIRECT);
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public final void isReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw createAssertionError(Messages.Fail.IS_READ_ONLY);
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public final void isNotReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw createAssertionError(Messages.Fail.IS_NOT_READ_ONLY);
        }
    }

    private ListAssertion<E> createListAssertion(final boolean rewind) {
        List<E> list = createList(getActual(), rewind);
        return initializeAssertion(Raw.<E>listAssertion(), list);
    }

    abstract List<E> createList(Object value, boolean rewind);

}
