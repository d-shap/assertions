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
import ru.d_shap.assertions.asimp.primitive.CharAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the char buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferAssertion extends ReferenceAssertion<CharBufferAssertion, CharBuffer> {

    /**
     * Create new object.
     */
    public CharBufferAssertion() {
        super();
    }

    @Override
    protected Class<CharBuffer> getActualValueClass() {
        return CharBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isEmpty() {
        createCharArrayAssertion(false).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isRewindAndEmpty() {
        createCharArrayAssertion(true).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isNullOrEmpty() {
        createCharArrayAssertion(false).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isRewindAndNullOrEmpty() {
        createCharArrayAssertion(true).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isNotEmpty() {
        createCharArrayAssertion(false).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isRewindAndNotEmpty() {
        createCharArrayAssertion(true).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion contains(final int expected) {
        createCharArrayAssertion(false).contains((char) expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContains(final int expected) {
        createCharArrayAssertion(true).contains((char) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion doesNotContain(final int expected) {
        createCharArrayAssertion(false).doesNotContain((char) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndDoesNotContain(final int expected) {
        createCharArrayAssertion(true).doesNotContain((char) expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAll(final char... expected) {
        createCharArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAll(final int... expected) {
        createCharArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAll(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAll(final char... expected) {
        createCharArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAll(final int... expected) {
        createCharArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAll(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAllInOrder(final char... expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAllInOrder(final int... expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAllInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAllInOrder(final char... expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAllInOrder(final int... expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAllInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactly(final char... expected) {
        createCharArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactly(final int... expected) {
        createCharArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactly(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactly(final char... expected) {
        createCharArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactly(final int... expected) {
        createCharArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactly(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactlyInOrder(final char... expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactlyInOrder(final int... expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsExactlyInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactlyInOrder(final char... expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactlyInOrder(final int... expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsExactlyInOrder(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAny(final char... expected) {
        createCharArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAny(final int... expected) {
        createCharArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsAny(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAny(final char... expected) {
        createCharArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAny(final int... expected) {
        createCharArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsAny(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsNone(final char... expected) {
        createCharArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsNone(final int... expected) {
        createCharArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion containsNone(final Iterable<Character> expected) {
        createCharArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsNone(final char... expected) {
        createCharArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsNone(final int... expected) {
        createCharArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion rewindAndContainsNone(final Iterable<Character> expected) {
        createCharArrayAssertion(true).containsNone(expected);
        return this;
    }

    private CharArrayAssertion createCharArrayAssertion(final boolean rewind) {
        char[] chars = convertValue(getActual(), null, char[].class, rewind);
        return initializeAssertion(Raw.charArrayAssertion(), chars);
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
    public CharBufferAssertion toPosition(final Matcher<? super Integer> matcher) {
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
    public CharBufferAssertion hasPosition(final int expected) {
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
    public CharBufferAssertion toLimit(final Matcher<? super Integer> matcher) {
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
    public CharBufferAssertion hasLimit(final int expected) {
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
    public CharBufferAssertion toCapacity(final Matcher<? super Integer> matcher) {
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
    public CharBufferAssertion hasCapacity(final int expected) {
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
    public CharBufferAssertion hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
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
    public CharBufferAssertion toRemaining(final Matcher<? super Integer> matcher) {
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
    public CharBufferAssertion hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is direct.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion isDirect() {
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
    public CharBufferAssertion isNotDirect() {
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
    public CharBufferAssertion isReadOnly() {
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
    public CharBufferAssertion isNotReadOnly() {
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
    public CharAssertion toMin() {
        checkActualIsNotNull();
        Character minValue = getMinValue(false);
        return initializeAssertion(Raw.charAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion toMin(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character minValue = getMinValue(false);
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public CharAssertion toRewindAndMin() {
        checkActualIsNotNull();
        Character minValue = getMinValue(true);
        return initializeAssertion(Raw.charAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion toRewindAndMin(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character minValue = getMinValue(true);
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
    public CharBufferAssertion hasMin(final int expected) {
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
    public CharBufferAssertion hasMin(final Character expected) {
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
    public CharBufferAssertion hasRewindAndMin(final int expected) {
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
    public CharBufferAssertion hasRewindAndMin(final Character expected) {
        toRewindAndMin().isEqualTo(expected);
        return this;
    }

    private Character getMinValue(final boolean rewind) {
        char[] actual = convertValue(getActual(), null, char[].class, rewind);
        if (actual.length == 0) {
            return null;
        }
        char result = actual[0];
        for (char value : actual) {
            result = (char) Math.min(result, value);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public CharAssertion toMax() {
        checkActualIsNotNull();
        Character maxValue = getMaxValue(false);
        return initializeAssertion(Raw.charAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion toMax(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character maxValue = getMaxValue(false);
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public CharAssertion toRewindAndMax() {
        checkActualIsNotNull();
        Character maxValue = getMaxValue(true);
        return initializeAssertion(Raw.charAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharBufferAssertion toRewindAndMax(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character maxValue = getMaxValue(true);
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
    public CharBufferAssertion hasMax(final int expected) {
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
    public CharBufferAssertion hasMax(final Character expected) {
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
    public CharBufferAssertion hasRewindAndMax(final int expected) {
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
    public CharBufferAssertion hasRewindAndMax(final Character expected) {
        toRewindAndMax().isEqualTo(expected);
        return this;
    }

    private Character getMaxValue(final boolean rewind) {
        char[] actual = convertValue(getActual(), null, char[].class, rewind);
        if (actual.length == 0) {
            return null;
        }
        char result = actual[0];
        for (char value : actual) {
            result = (char) Math.max(result, value);
        }
        return result;
    }

}
