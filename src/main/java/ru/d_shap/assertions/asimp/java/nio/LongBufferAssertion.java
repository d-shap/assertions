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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.LongBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.LongArrayAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the long buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferAssertion extends ReferenceAssertion<LongBufferAssertion, LongBuffer> {

    /**
     * Create new object.
     */
    public LongBufferAssertion() {
        super();
    }

    @Override
    protected Class<LongBuffer> getActualValueClass() {
        return LongBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isEmpty() {
        createLongBufferAssertion(false).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isRewindAndEmpty() {
        createLongBufferAssertion(true).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isNullOrEmpty() {
        createLongBufferAssertion(false).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isRewindAndNullOrEmpty() {
        createLongBufferAssertion(true).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isNotEmpty() {
        createLongBufferAssertion(false).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isRewindAndNotEmpty() {
        createLongBufferAssertion(true).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion contains(final long expected) {
        createLongBufferAssertion(false).contains(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContains(final long expected) {
        createLongBufferAssertion(true).contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion doesNotContain(final long expected) {
        createLongBufferAssertion(false).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndDoesNotContain(final long expected) {
        createLongBufferAssertion(true).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAll(final long... expected) {
        createLongBufferAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAll(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAll(final long... expected) {
        createLongBufferAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAll(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAllInOrder(final long... expected) {
        createLongBufferAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAllInOrder(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAllInOrder(final long... expected) {
        createLongBufferAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAllInOrder(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsExactly(final long... expected) {
        createLongBufferAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsExactly(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsExactly(final long... expected) {
        createLongBufferAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsExactly(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsExactlyInOrder(final long... expected) {
        createLongBufferAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsExactlyInOrder(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsExactlyInOrder(final long... expected) {
        createLongBufferAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsExactlyInOrder(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAny(final long... expected) {
        createLongBufferAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsAny(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAny(final long... expected) {
        createLongBufferAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsAny(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsNone(final long... expected) {
        createLongBufferAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion containsNone(final Iterable<Long> expected) {
        createLongBufferAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsNone(final long... expected) {
        createLongBufferAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion rewindAndContainsNone(final Iterable<Long> expected) {
        createLongBufferAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        return createLongBufferAssertion(false).toHexString();
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from the index of the first buffer element (inclusive) for the hex representation.
     * @param to   the index of the last buffer element (exclusive) for the hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString(final int from, final int to) {
        return createLongBufferAssertion(false).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toHexString(final Matcher<? super String> matcher) {
        createLongBufferAssertion(false).toHexString(matcher);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first buffer element (inclusive) for the hex representation.
     * @param to      the index of the last buffer element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createLongBufferAssertion(false).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toRewindAndHexString() {
        return createLongBufferAssertion(true).toHexString();
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from the index of the first buffer element (inclusive) for the hex representation.
     * @param to   the index of the last buffer element (exclusive) for the hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toRewindAndHexString(final int from, final int to) {
        return createLongBufferAssertion(true).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toRewindAndHexString(final Matcher<? super String> matcher) {
        createLongBufferAssertion(true).toHexString(matcher);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first buffer element (inclusive) for the hex representation.
     * @param to      the index of the last buffer element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toRewindAndHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createLongBufferAssertion(true).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasHexString(final String expected) {
        createLongBufferAssertion(false).hasHexString(expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first buffer element (inclusive) for the hex representation.
     * @param to       the index of the last buffer element (exclusive) for the hex representation.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasHexString(final int from, final int to, final String expected) {
        createLongBufferAssertion(false).hasHexString(from, to, expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasRewindAndHexString(final String expected) {
        createLongBufferAssertion(true).hasHexString(expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first buffer element (inclusive) for the hex representation.
     * @param to       the index of the last buffer element (exclusive) for the hex representation.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasRewindAndHexString(final int from, final int to, final String expected) {
        createLongBufferAssertion(true).hasHexString(from, to, expected);
        return this;
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @return the assertion.
     */
    public IntAssertion toPosition() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().position(), Messages.Check.POSITION);
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toPosition(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().position(), matcher, Messages.Check.POSITION);
        return this;
    }

    /**
     * Check if the actual value's position is equal to the expected position.
     *
     * @param expected the expected position.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @return the assertion.
     */
    public IntAssertion toLimit() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().limit(), Messages.Check.LIMIT);
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toLimit(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().limit(), matcher, Messages.Check.LIMIT);
        return this;
    }

    /**
     * Check if the actual value's limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @return the assertion.
     */
    public IntAssertion toCapacity() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().capacity(), Messages.Check.CAPACITY);
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toCapacity(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().capacity(), matcher, Messages.Check.CAPACITY);
        return this;
    }

    /**
     * Check if the actual value's capacity is equal to the expected capacity.
     *
     * @param expected the expected capacity.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasCapacity(final int expected) {
        toCapacity().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedPosition the expected position.
     * @param expectedLimit    the expected limit.
     * @param expectedCapacity the expected capacity.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
        hasPosition(expectedPosition);
        hasLimit(expectedLimit);
        hasCapacity(expectedCapacity);
        return this;
    }

    /**
     * Make assertion about the actual value's remaining.
     *
     * @return the assertion.
     */
    public IntAssertion toRemaining() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().remaining(), Messages.Check.REMAINING);
    }

    /**
     * Make assertion about the actual value's remaining.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion toRemaining(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().remaining(), matcher, Messages.Check.REMAINING);
        return this;
    }

    /**
     * Check if the actual value's remaining is equal to the expected remaining.
     *
     * @param expected the expected remaining.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is direct.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isDirect() {
        checkActualIsNotNull();
        if (!getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIRECT).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT direct.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isNotDirect() {
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_DIRECT).build();
        }
        return this;
    }

    /**
     * Check if the actual value is read only.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isReadOnly() {
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_READ_ONLY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT read only.
     *
     * @return current object for the chain call.
     */
    public LongBufferAssertion isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
        return this;
    }

    private LongArrayAssertion createLongBufferAssertion(final boolean rewind) {
        long[] longs = convertValue(getActual(), null, long[].class, rewind);
        return initializeAssertion(Raw.longArrayAssertion(), longs);
    }

}
