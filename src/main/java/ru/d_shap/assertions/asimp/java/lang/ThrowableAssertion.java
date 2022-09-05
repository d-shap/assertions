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
package ru.d_shap.assertions.asimp.java.lang;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the throwable.
 *
 * @author Dmitry Shapovalov
 */
public final class ThrowableAssertion extends ReferenceAssertion<ThrowableAssertion, Throwable> {

    /**
     * Create new object.
     */
    public ThrowableAssertion() {
        super();
    }

    @Override
    protected Class<Throwable> getActualValueClass() {
        return Throwable.class;
    }

    /**
     * Make assertion about the actual throwable message.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toMessage() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getMessage(), Messages.Check.MESSAGE);
    }

    /**
     * Make assertion about the actual throwable message.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion toMessage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getMessage(), matcher, Messages.Check.MESSAGE);
        return this;
    }

    /**
     * Check if the message of the throwable is null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNull() {
        toMessage().isNull();
        return this;
    }

    /**
     * Check if the message of the throwable is NOT null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNotNull() {
        toMessage().isNotNull();
        return this;
    }

    /**
     * Check if the message of the throwable is empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsEmpty() {
        toMessage().isEmpty();
        return this;
    }

    /**
     * Check if the message of the throwable is null or empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNullOrEmpty() {
        toMessage().isNullOrEmpty();
        return this;
    }

    /**
     * Check if the message of the throwable is NOT empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNotEmpty() {
        toMessage().isNotEmpty();
        return this;
    }

    /**
     * Check if the message of the throwable is blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsBlank() {
        toMessage().isBlank();
        return this;
    }

    /**
     * Check if the message of the throwable is null or blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNullOrBlank() {
        toMessage().isNullOrBlank();
        return this;
    }

    /**
     * Check if the message of the throwable is NOT blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageIsNotBlank() {
        toMessage().isNotBlank();
        return this;
    }

    /**
     * Check if the message of the throwable has the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasMessage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the message of the throwable contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().contains(expected);
        return this;
    }

    /**
     * Check if the message of the throwable contains the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageContainsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().containsIgnoreCase(expected);
        return this;
    }

    /**
     * Check if the message of the throwable matches the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion messageMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().matches(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's cause.
     *
     * @return the assertion.
     */
    public ThrowableAssertion toCause() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.throwableAssertion(), getActual().getCause(), Messages.Check.CAUSE);
    }

    /**
     * Make assertion about the actual value's cause.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion toCause(final Matcher<? super Throwable> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getCause(), matcher, Messages.Check.CAUSE);
        return this;
    }

    /**
     * Check if the cause of the throwable is null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeIsNull() {
        toCause().isNull();
        return this;
    }

    /**
     * Check if the cause of the throwable is NOT null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeIsNotNull() {
        toCause().isNotNull();
        return this;
    }

    /**
     * Check if the cause of the throwable is instance of the expected class.
     *
     * @param expected the expected class.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasCause(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().isInstanceOf(expected);
        return this;
    }

    /**
     * Check if the causes of the throwable is instance of the expected classes.
     *
     * @param expected the expected classes.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasCauses(final Class<?>... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        for (Class<?> clazz : expected) {
            checkArgumentIsNotNull(clazz, "expected");
        }
        hasCauses(0, expected);
        return this;
    }

    private void hasCauses(final int idx, final Class<?>... expected) {
        if (idx < expected.length) {
            toCause().isInstanceOf(expected[idx]);
            toCause().hasCauses(idx + 1, expected);
        }
    }

    /**
     * Check if the message of the cause of the throwable is null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNull() {
        toCause().messageIsNull();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is NOT null.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNotNull() {
        toCause().messageIsNotNull();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsEmpty() {
        toCause().messageIsEmpty();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is null or empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNullOrEmpty() {
        toCause().messageIsNullOrEmpty();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is NOT empty.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNotEmpty() {
        toCause().messageIsNotEmpty();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsBlank() {
        toCause().messageIsBlank();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is null or blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNullOrBlank() {
        toCause().messageIsNullOrBlank();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable is NOT blank.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageIsNotBlank() {
        toCause().messageIsNotBlank();
        return this;
    }

    /**
     * Check if the message of the cause of the throwable has the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasCauseMessage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().hasMessage(expected);
        return this;
    }

    /**
     * Check if the message of the cause of the throwable contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageContains(expected);
        return this;
    }

    /**
     * Check if the message of the cause of the throwable contains the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageContainsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageContainsIgnoreCase(expected);
        return this;
    }

    /**
     * Check if the message of the cause of the throwable matches the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion causeMessageMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageMatches(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's suppressed count.
     *
     * @return the assertion.
     */
    public IntAssertion toSuppressedCount() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getSuppressed().length, Messages.Check.SUPPRESSED_COUNT);
    }

    /**
     * Make assertion about the actual value's suppressed count.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion toSuppressedCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getSuppressed().length, matcher, Messages.Check.SUPPRESSED_COUNT);
        return this;
    }

    /**
     * Check if the actual value's suppressed count is equal to the expected suppressed count.
     *
     * @param expected the expected suppressed count.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasSuppressedCount(final int expected) {
        toSuppressedCount().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's suppressed.
     *
     * @param idx the index of suppressed.
     *
     * @return the assertion.
     */
    public ThrowableAssertion toSuppressed(final int idx) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        return initializeAssertion(Raw.throwableAssertion(), getActual().getSuppressed()[idx], Messages.Check.SUPPRESSED, idx);
    }

    /**
     * Make assertion about the actual value's suppressed.
     *
     * @param idx     the index of suppressed.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion toSuppressed(final int idx, final Matcher<? super Throwable> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getSuppressed()[idx], matcher, Messages.Check.SUPPRESSED, idx);
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is null.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNull(final int idx) {
        toSuppressed(idx).messageIsNull();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is NOT null.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNotNull(final int idx) {
        toSuppressed(idx).messageIsNotNull();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is empty.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsEmpty(final int idx) {
        toSuppressed(idx).messageIsEmpty();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is null or empty.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNullOrEmpty(final int idx) {
        toSuppressed(idx).messageIsNullOrEmpty();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is NOT empty.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNotEmpty(final int idx) {
        toSuppressed(idx).messageIsNotEmpty();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is blank.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsBlank(final int idx) {
        toSuppressed(idx).messageIsBlank();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is null or blank.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNullOrBlank(final int idx) {
        toSuppressed(idx).messageIsNullOrBlank();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed is NOT blank.
     *
     * @param idx the index of suppressed.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageIsNotBlank(final int idx) {
        toSuppressed(idx).messageIsNotBlank();
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed has the expected value.
     *
     * @param idx      the index of suppressed.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion hasSuppressedMessage(final int idx, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        checkArgumentIsNotNull(expected, "expected");
        toSuppressed(idx).hasMessage(expected);
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed contains the expected value.
     *
     * @param idx      the index of suppressed.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageContains(final int idx, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        checkArgumentIsNotNull(expected, "expected");
        toSuppressed(idx).messageContains(expected);
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed contains the expected value ignoring case.
     *
     * @param idx      the index of suppressed.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageContainsIgnoreCase(final int idx, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        checkArgumentIsNotNull(expected, "expected");
        toSuppressed(idx).messageContainsIgnoreCase(expected);
        return this;
    }

    /**
     * Check if the message of the actual value's suppressed matches the expected value.
     *
     * @param idx      the index of suppressed.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ThrowableAssertion suppressedMessageMatches(final int idx, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(idx >= 0, "idx", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(idx < getActual().getSuppressed().length, "idx", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().getSuppressed().length);
        checkArgumentIsNotNull(expected, "expected");
        toSuppressed(idx).messageMatches(expected);
        return this;
    }

}
