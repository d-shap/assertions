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

/**
 * Assertions for the throwable.
 *
 * @author Dmitry Shapovalov
 */
public final class ThrowableAssertion extends ReferenceAssertion<Throwable> {

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
     * Make assertion about the actual throwable cause.
     *
     * @return the assertion.
     */
    public ThrowableAssertion toCause() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.throwableAssertion(), getActual().getCause(), Messages.Check.CAUSE);
    }

    /**
     * Make assertion about the actual throwable cause.
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

}
