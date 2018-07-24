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

import java.nio.LongBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.array.LongArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the long buffer.
 *
 * @author Dmitry Shapovalov
 */
public class LongBufferAssertion extends ReferenceAssertion<LongBuffer> {

    /**
     * Create new object.
     */
    public LongBufferAssertion() {
        super();
    }

    @Override
    protected final Class<LongBuffer> getActualValueClass() {
        return LongBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).isEmpty();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isRewindAndEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createLongBufferAssertion(false).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isRewindAndNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createLongBufferAssertion(true).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).isNotEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isRewindAndNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).contains(expected);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndContains(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).doesNotContain(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndDoesNotContain(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final long... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final Iterable<Long> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createLongBufferAssertion(true).containsNone(expected);
    }

    private LongArrayAssertion createLongBufferAssertion(final boolean rewind) {
        long[] longs = convertValue(getActual(), long[].class, rewind);
        return initializeAssertion(Raw.longArrayAssertion(), longs);
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
     * Make assertion about the actual buffer's position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toPosition(final Matcher<Integer> matcher) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().position(), matcher, Messages.Check.ACTUAL_VALUE_POSITION);
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
     * Make assertion about the actual buffer's limit.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLimit(final Matcher<Integer> matcher) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().limit(), matcher, Messages.Check.ACTUAL_VALUE_LIMIT);
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
     * Make assertion about the actual buffer's capacity.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toCapacity(final Matcher<Integer> matcher) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().capacity(), matcher, Messages.Check.ACTUAL_VALUE_CAPACITY);
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
     * Make assertion about the actual buffer's remaining.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toRemaining(final Matcher<Integer> matcher) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().remaining(), matcher, Messages.Check.ACTUAL_VALUE_REMAINING);
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
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public final void isNotDirect() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public final void isReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_READ_ONLY).build();
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public final void isNotReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_READ_ONLY).build();
        }
    }

}
