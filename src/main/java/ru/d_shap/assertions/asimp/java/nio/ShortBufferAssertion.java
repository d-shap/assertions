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

import java.nio.ShortBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.ShortArrayAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the short buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAssertion extends ReferenceAssertion<ShortBuffer> {

    /**
     * Create new object.
     */
    public ShortBufferAssertion() {
        super();
    }

    @Override
    protected Class<ShortBuffer> getActualValueClass() {
        return ShortBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public void isEmpty() {
        createShortBufferAssertion(false).isEmpty();
    }

    /**
     * Check if the actual value is empty.
     */
    public void isRewindAndEmpty() {
        createShortBufferAssertion(true).isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public void isNullOrEmpty() {
        createShortBufferAssertion(false).isNullOrEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public void isRewindAndNullOrEmpty() {
        createShortBufferAssertion(true).isNullOrEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public void isNotEmpty() {
        createShortBufferAssertion(false).isNotEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public void isRewindAndNotEmpty() {
        createShortBufferAssertion(true).isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public void contains(final int expected) {
        createShortBufferAssertion(false).contains((short) expected);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public void rewindAndContains(final int expected) {
        createShortBufferAssertion(true).contains((short) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public void doesNotContain(final int expected) {
        createShortBufferAssertion(false).doesNotContain((short) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public void rewindAndDoesNotContain(final int expected) {
        createShortBufferAssertion(true).doesNotContain((short) expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAll(final short... expected) {
        createShortBufferAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAll(final int... expected) {
        createShortBufferAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAll(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAll(final short... expected) {
        createShortBufferAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAll(final int... expected) {
        createShortBufferAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAll(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsAllInOrder(final short... expected) {
        createShortBufferAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsAllInOrder(final int... expected) {
        createShortBufferAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsAllInOrder(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAllInOrder(final short... expected) {
        createShortBufferAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAllInOrder(final int... expected) {
        createShortBufferAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAllInOrder(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void containsExactly(final short... expected) {
        createShortBufferAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void containsExactly(final int... expected) {
        createShortBufferAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void containsExactly(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactly(final short... expected) {
        createShortBufferAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactly(final int... expected) {
        createShortBufferAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactly(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsExactlyInOrder(final short... expected) {
        createShortBufferAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsExactlyInOrder(final int... expected) {
        createShortBufferAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void containsExactlyInOrder(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactlyInOrder(final short... expected) {
        createShortBufferAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactlyInOrder(final int... expected) {
        createShortBufferAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsExactlyInOrder(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAny(final short... expected) {
        createShortBufferAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAny(final int... expected) {
        createShortBufferAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsAny(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAny(final short... expected) {
        createShortBufferAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAny(final int... expected) {
        createShortBufferAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsAny(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsNone(final short... expected) {
        createShortBufferAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsNone(final int... expected) {
        createShortBufferAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void containsNone(final Iterable<Short> expected) {
        createShortBufferAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsNone(final short... expected) {
        createShortBufferAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsNone(final int... expected) {
        createShortBufferAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public void rewindAndContainsNone(final Iterable<Short> expected) {
        createShortBufferAssertion(true).containsNone(expected);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        return createShortBufferAssertion(false).toHexString();
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
        return createShortBufferAssertion(false).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toHexString(final Matcher<? super String> matcher) {
        createShortBufferAssertion(false).toHexString(matcher);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first buffer element (inclusive) for the hex representation.
     * @param to      the index of the last buffer element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     */
    public void toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createShortBufferAssertion(false).toHexString(from, to, matcher);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toRewindAndHexString() {
        return createShortBufferAssertion(true).toHexString();
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
        return createShortBufferAssertion(true).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toRewindAndHexString(final Matcher<? super String> matcher) {
        createShortBufferAssertion(true).toHexString(matcher);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first buffer element (inclusive) for the hex representation.
     * @param to      the index of the last buffer element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     */
    public void toRewindAndHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createShortBufferAssertion(true).toHexString(from, to, matcher);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasHexString(final String expected) {
        createShortBufferAssertion(false).hasHexString(expected);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first buffer element (inclusive) for the hex representation.
     * @param to       the index of the last buffer element (exclusive) for the hex representation.
     * @param expected the expected value.
     */
    public void hasHexString(final int from, final int to, final String expected) {
        createShortBufferAssertion(false).hasHexString(from, to, expected);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasRewindAndHexString(final String expected) {
        createShortBufferAssertion(true).hasHexString(expected);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first buffer element (inclusive) for the hex representation.
     * @param to       the index of the last buffer element (exclusive) for the hex representation.
     * @param expected the expected value.
     */
    public void hasRewindAndHexString(final int from, final int to, final String expected) {
        createShortBufferAssertion(true).hasHexString(from, to, expected);
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
     */
    public void toPosition(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().position(), matcher, Messages.Check.POSITION);
    }

    /**
     * Check if the actual value's position is equal to the expected position.
     *
     * @param expected the expected position.
     */
    public void hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
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
     */
    public void toLimit(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().limit(), matcher, Messages.Check.LIMIT);
    }

    /**
     * Check if the actual value's limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     */
    public void hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
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
     */
    public void toCapacity(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().capacity(), matcher, Messages.Check.CAPACITY);
    }

    /**
     * Check if the actual value's capacity is equal to the expected capacity.
     *
     * @param expected the expected capacity.
     */
    public void hasCapacity(final int expected) {
        toCapacity().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedPosition the expected position.
     * @param expectedLimit    the expected limit.
     * @param expectedCapacity the expected capacity.
     */
    public void hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
        hasPosition(expectedPosition);
        hasLimit(expectedLimit);
        hasCapacity(expectedCapacity);
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
     */
    public void toRemaining(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().remaining(), matcher, Messages.Check.REMAINING);
    }

    /**
     * Check if the actual value's remaining is equal to the expected remaining.
     *
     * @param expected the expected remaining.
     */
    public void hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
    }

    /**
     * Check if the actual value is direct.
     */
    public void isDirect() {
        checkActualIsNotNull();
        if (!getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public void isNotDirect() {
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public void isReadOnly() {
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_READ_ONLY).build();
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public void isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
    }

    private ShortArrayAssertion createShortBufferAssertion(final boolean rewind) {
        short[] shorts = convertValue(getActual(), null, short[].class, rewind);
        return initializeAssertion(Raw.shortArrayAssertion(), shorts);
    }

}
