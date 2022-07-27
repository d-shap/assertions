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

import java.nio.ByteBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.ByteArrayAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the byte buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAssertion extends ReferenceAssertion<ByteBuffer> {

    /**
     * Create new object.
     */
    public ByteBufferAssertion() {
        super();
    }

    @Override
    protected Class<ByteBuffer> getActualValueClass() {
        return ByteBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isEmpty() {
        createByteArrayAssertion(false).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isRewindAndEmpty() {
        createByteArrayAssertion(true).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isNullOrEmpty() {
        createByteArrayAssertion(false).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isRewindAndNullOrEmpty() {
        createByteArrayAssertion(true).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isNotEmpty() {
        createByteArrayAssertion(false).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isRewindAndNotEmpty() {
        createByteArrayAssertion(true).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion contains(final int expected) {
        createByteArrayAssertion(false).contains((byte) expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContains(final int expected) {
        createByteArrayAssertion(true).contains((byte) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion doesNotContain(final int expected) {
        createByteArrayAssertion(false).doesNotContain((byte) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndDoesNotContain(final int expected) {
        createByteArrayAssertion(true).doesNotContain((byte) expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAll(final byte... expected) {
        createByteArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAll(final int... expected) {
        createByteArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAll(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAll(final byte... expected) {
        createByteArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAll(final int... expected) {
        createByteArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAll(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAllInOrder(final byte... expected) {
        createByteArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAllInOrder(final int... expected) {
        createByteArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAllInOrder(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAllInOrder(final byte... expected) {
        createByteArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAllInOrder(final int... expected) {
        createByteArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAllInOrder(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactly(final byte... expected) {
        createByteArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactly(final int... expected) {
        createByteArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactly(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactly(final byte... expected) {
        createByteArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactly(final int... expected) {
        createByteArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactly(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactlyInOrder(final byte... expected) {
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactlyInOrder(final int... expected) {
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsExactlyInOrder(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactlyInOrder(final byte... expected) {
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactlyInOrder(final int... expected) {
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsExactlyInOrder(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAny(final byte... expected) {
        createByteArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAny(final int... expected) {
        createByteArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsAny(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAny(final byte... expected) {
        createByteArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAny(final int... expected) {
        createByteArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsAny(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsNone(final byte... expected) {
        createByteArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsNone(final int... expected) {
        createByteArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion containsNone(final Iterable<Byte> expected) {
        createByteArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsNone(final byte... expected) {
        createByteArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsNone(final int... expected) {
        createByteArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion rewindAndContainsNone(final Iterable<Byte> expected) {
        createByteArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        return createByteArrayAssertion(false).toHexString();
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
        return createByteArrayAssertion(false).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion toHexString(final Matcher<? super String> matcher) {
        createByteArrayAssertion(false).toHexString(matcher);
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
    public ByteBufferAssertion toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createByteArrayAssertion(false).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toRewindAndHexString() {
        return createByteArrayAssertion(true).toHexString();
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
        return createByteArrayAssertion(true).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion toRewindAndHexString(final Matcher<? super String> matcher) {
        createByteArrayAssertion(true).toHexString(matcher);
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
    public ByteBufferAssertion toRewindAndHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createByteArrayAssertion(true).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion hasHexString(final String expected) {
        createByteArrayAssertion(false).hasHexString(expected);
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
    public ByteBufferAssertion hasHexString(final int from, final int to, final String expected) {
        createByteArrayAssertion(false).hasHexString(from, to, expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion hasRewindAndHexString(final String expected) {
        createByteArrayAssertion(true).hasHexString(expected);
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
    public ByteBufferAssertion hasRewindAndHexString(final int from, final int to, final String expected) {
        createByteArrayAssertion(true).hasHexString(from, to, expected);
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
    public ByteBufferAssertion toPosition(final Matcher<? super Integer> matcher) {
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
    public ByteBufferAssertion hasPosition(final int expected) {
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
    public ByteBufferAssertion toLimit(final Matcher<? super Integer> matcher) {
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
    public ByteBufferAssertion hasLimit(final int expected) {
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
    public ByteBufferAssertion toCapacity(final Matcher<? super Integer> matcher) {
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
    public ByteBufferAssertion hasCapacity(final int expected) {
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
    public ByteBufferAssertion hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
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
    public ByteBufferAssertion toRemaining(final Matcher<? super Integer> matcher) {
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
    public ByteBufferAssertion hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is direct.
     *
     * @return current object for the chain call.
     */
    public ByteBufferAssertion isDirect() {
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
    public ByteBufferAssertion isNotDirect() {
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
    public ByteBufferAssertion isReadOnly() {
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
    public ByteBufferAssertion isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
        return this;
    }

    private ByteArrayAssertion createByteArrayAssertion(final boolean rewind) {
        byte[] bytes = convertValue(getActual(), null, byte[].class, rewind);
        return initializeAssertion(Raw.byteArrayAssertion(), bytes);
    }

}
