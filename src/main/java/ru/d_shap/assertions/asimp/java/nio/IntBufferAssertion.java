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

import java.nio.IntBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.IntArrayAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the int buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferAssertion extends ReferenceAssertion<IntBufferAssertion, IntBuffer> {

    /**
     * Create new object.
     */
    public IntBufferAssertion() {
        super();
    }

    @Override
    protected Class<IntBuffer> getActualValueClass() {
        return IntBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isEmpty() {
        createIntArrayAssertion(false).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isRewindAndEmpty() {
        createIntArrayAssertion(true).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isNullOrEmpty() {
        createIntArrayAssertion(false).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isRewindAndNullOrEmpty() {
        createIntArrayAssertion(true).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isNotEmpty() {
        createIntArrayAssertion(false).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isRewindAndNotEmpty() {
        createIntArrayAssertion(true).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion contains(final int expected) {
        createIntArrayAssertion(false).contains(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContains(final int expected) {
        createIntArrayAssertion(true).contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion doesNotContain(final int expected) {
        createIntArrayAssertion(false).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndDoesNotContain(final int expected) {
        createIntArrayAssertion(true).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAll(final int... expected) {
        createIntArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAll(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAll(final int... expected) {
        createIntArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAll(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAllInOrder(final int... expected) {
        createIntArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAllInOrder(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAllInOrder(final int... expected) {
        createIntArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAllInOrder(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsExactly(final int... expected) {
        createIntArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsExactly(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsExactly(final int... expected) {
        createIntArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsExactly(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsExactlyInOrder(final int... expected) {
        createIntArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsExactlyInOrder(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsExactlyInOrder(final int... expected) {
        createIntArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsExactlyInOrder(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAny(final int... expected) {
        createIntArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsAny(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAny(final int... expected) {
        createIntArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsAny(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsNone(final int... expected) {
        createIntArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion containsNone(final Iterable<Integer> expected) {
        createIntArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsNone(final int... expected) {
        createIntArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion rewindAndContainsNone(final Iterable<Integer> expected) {
        createIntArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        return createIntArrayAssertion(false).toHexString();
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
        return createIntArrayAssertion(false).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toHexString(final Matcher<? super String> matcher) {
        createIntArrayAssertion(false).toHexString(matcher);
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
    public IntBufferAssertion toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createIntArrayAssertion(false).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toRewindAndHexString() {
        return createIntArrayAssertion(true).toHexString();
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
        return createIntArrayAssertion(true).toHexString(from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toRewindAndHexString(final Matcher<? super String> matcher) {
        createIntArrayAssertion(true).toHexString(matcher);
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
    public IntBufferAssertion toRewindAndHexString(final int from, final int to, final Matcher<? super String> matcher) {
        createIntArrayAssertion(true).toHexString(from, to, matcher);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasHexString(final String expected) {
        createIntArrayAssertion(false).hasHexString(expected);
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
    public IntBufferAssertion hasHexString(final int from, final int to, final String expected) {
        createIntArrayAssertion(false).hasHexString(from, to, expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasRewindAndHexString(final String expected) {
        createIntArrayAssertion(true).hasHexString(expected);
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
    public IntBufferAssertion hasRewindAndHexString(final int from, final int to, final String expected) {
        createIntArrayAssertion(true).hasHexString(from, to, expected);
        return this;
    }

    private IntArrayAssertion createIntArrayAssertion(final boolean rewind) {
        int[] ints = convertValue(getActual(), null, int[].class, rewind);
        return initializeAssertion(Raw.intArrayAssertion(), ints);
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
    public IntBufferAssertion toPosition(final Matcher<? super Integer> matcher) {
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
    public IntBufferAssertion hasPosition(final int expected) {
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
    public IntBufferAssertion toLimit(final Matcher<? super Integer> matcher) {
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
    public IntBufferAssertion hasLimit(final int expected) {
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
    public IntBufferAssertion toCapacity(final Matcher<? super Integer> matcher) {
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
    public IntBufferAssertion hasCapacity(final int expected) {
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
    public IntBufferAssertion hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
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
    public IntBufferAssertion toRemaining(final Matcher<? super Integer> matcher) {
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
    public IntBufferAssertion hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is direct.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion isDirect() {
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
    public IntBufferAssertion isNotDirect() {
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
    public IntBufferAssertion isReadOnly() {
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
    public IntBufferAssertion isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public IntAssertion toMin() {
        checkActualIsNotNull();
        Integer minValue = getMinValue(false);
        return initializeAssertion(Raw.intAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toMin(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer minValue = getMinValue(false);
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public IntAssertion toRewindAndMin() {
        checkActualIsNotNull();
        Integer minValue = getMinValue(true);
        return initializeAssertion(Raw.intAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toRewindAndMin(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer minValue = getMinValue(true);
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasMin(final int expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasMin(final Integer expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasRewindAndMin(final int expected) {
        toRewindAndMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasRewindAndMin(final Integer expected) {
        toRewindAndMin().isEqualTo(expected);
        return this;
    }

    private Integer getMinValue(final boolean rewind) {
        int[] actual = convertValue(getActual(), null, int[].class, rewind);
        int length = actual.length;
        if (length == 0) {
            return null;
        }
        int result = actual[0];
        for (int i = 1; i < length; i++) {
            result = Math.min(result, actual[i]);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public IntAssertion toMax() {
        checkActualIsNotNull();
        Integer maxValue = getMaxValue(false);
        return initializeAssertion(Raw.intAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toMax(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer maxValue = getMaxValue(false);
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public IntAssertion toRewindAndMax() {
        checkActualIsNotNull();
        Integer maxValue = getMaxValue(true);
        return initializeAssertion(Raw.intAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion toRewindAndMax(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer maxValue = getMaxValue(true);
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasMax(final int expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasMax(final Integer expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasRewindAndMax(final int expected) {
        toRewindAndMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntBufferAssertion hasRewindAndMax(final Integer expected) {
        toRewindAndMax().isEqualTo(expected);
        return this;
    }

    private Integer getMaxValue(final boolean rewind) {
        int[] actual = convertValue(getActual(), null, int[].class, rewind);
        int length = actual.length;
        if (length == 0) {
            return null;
        }
        int result = actual[0];
        for (int i = 1; i < length; i++) {
            result = Math.max(result, actual[i]);
        }
        return result;
    }

}
