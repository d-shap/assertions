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

import java.nio.CharBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.CharArrayAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the char buffer.
 *
 * @author Dmitry Shapovalov
 */
public class CharBufferAssertion extends ReferenceAssertion<CharBuffer> {

    /**
     * Create new object.
     */
    public CharBufferAssertion() {
        super();
    }

    @Override
    protected final Class<CharBuffer> getActualValueClass() {
        return CharBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        createCharArrayAssertion(false).isEmpty();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isRewindAndEmpty() {
        createCharArrayAssertion(true).isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        createCharArrayAssertion(false).isNullOrEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isRewindAndNullOrEmpty() {
        createCharArrayAssertion(true).isNullOrEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        createCharArrayAssertion(false).isNotEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isRewindAndNotEmpty() {
        createCharArrayAssertion(true).isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final int expected) {
        createCharArrayAssertion(false).contains((char) expected);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndContains(final int expected) {
        createCharArrayAssertion(true).contains((char) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final int expected) {
        createCharArrayAssertion(false).doesNotContain((char) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndDoesNotContain(final int expected) {
        createCharArrayAssertion(true).doesNotContain((char) expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final char... expected) {
        createCharArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final int... expected) {
        createCharArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final char... expected) {
        createCharArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final int... expected) {
        createCharArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final char... expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final int... expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final char... expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final int... expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final char... expected) {
        createCharArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final int... expected) {
        createCharArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final char... expected) {
        createCharArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final int... expected) {
        createCharArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final char... expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final int... expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final char... expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final int... expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final char... expected) {
        createCharArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final int... expected) {
        createCharArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final char... expected) {
        createCharArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final int... expected) {
        createCharArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final char... expected) {
        createCharArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final int... expected) {
        createCharArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final char... expected) {
        createCharArrayAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final int... expected) {
        createCharArrayAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsNone(expected);
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @return the assertion.
     */
    public final IntAssertion toPosition() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().position(), Messages.Check.POSITION);
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toPosition(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().position(), matcher, Messages.Check.POSITION);
    }

    /**
     * Check if the actual value's position is equal to the expected position.
     *
     * @param expected the expected position.
     */
    public final void hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @return the assertion.
     */
    public final IntAssertion toLimit() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().limit(), Messages.Check.LIMIT);
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLimit(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().limit(), matcher, Messages.Check.LIMIT);
    }

    /**
     * Check if the actual value's limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     */
    public final void hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @return the assertion.
     */
    public final IntAssertion toCapacity() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().capacity(), Messages.Check.CAPACITY);
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toCapacity(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().capacity(), matcher, Messages.Check.CAPACITY);
    }

    /**
     * Check if the actual value's capacity is equal to the expected capacity.
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
     * Make assertion about the actual value's remaining.
     *
     * @return the assertion.
     */
    public final IntAssertion toRemaining() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().remaining(), Messages.Check.REMAINING);
    }

    /**
     * Make assertion about the actual value's remaining.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toRemaining(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().remaining(), matcher, Messages.Check.REMAINING);
    }

    /**
     * Check if the actual value's remaining is equal to the expected remaining.
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
        if (!getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public final void isNotDirect() {
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public final void isReadOnly() {
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_READ_ONLY).build();
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public final void isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
    }

    private CharArrayAssertion createCharArrayAssertion(final boolean rewind) {
        char[] chars = convertValue(getActual(), char[].class, rewind);
        return initializeAssertion(Raw.charArrayAssertion(), chars);
    }

}
