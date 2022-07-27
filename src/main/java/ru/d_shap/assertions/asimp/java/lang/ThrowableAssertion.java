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
     */
    public void toMessage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getMessage(), matcher, Messages.Check.MESSAGE);
    }

    /**
     * Check if the message of the throwable is null.
     */
    public void messageIsNull() {
        toMessage().isNull();
    }

    /**
     * Check if the message of the throwable is NOT null.
     */
    public void messageIsNotNull() {
        toMessage().isNotNull();
    }

    /**
     * Check if the message of the throwable is empty.
     */
    public void messageIsEmpty() {
        toMessage().isEmpty();
    }

    /**
     * Check if the message of the throwable is null or empty.
     */
    public void messageIsNullOrEmpty() {
        toMessage().isNullOrEmpty();
    }

    /**
     * Check if the message of the throwable is NOT empty.
     */
    public void messageIsNotEmpty() {
        toMessage().isNotEmpty();
    }

    /**
     * Check if the message of the throwable is blank.
     */
    public void messageIsBlank() {
        toMessage().isBlank();
    }

    /**
     * Check if the message of the throwable is null or blank.
     */
    public void messageIsNullOrBlank() {
        toMessage().isNullOrBlank();
    }

    /**
     * Check if the message of the throwable is NOT blank.
     */
    public void messageIsNotBlank() {
        toMessage().isNotBlank();
    }

    /**
     * Check if the message of the throwable has the expected value.
     *
     * @param expected the expected value.
     */
    public void hasMessage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().isEqualTo(expected);
    }

    /**
     * Check if the message of the throwable contains the expected value.
     *
     * @param expected the expected value.
     */
    public void messageContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().contains(expected);
    }

    /**
     * Check if the message of the throwable contains the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public void messageContainsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().containsIgnoreCase(expected);
    }

    /**
     * Check if the message of the throwable matches the expected value.
     *
     * @param expected the expected value.
     */
    public void messageMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toMessage().matches(expected);
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
     */
    public void toCause(final Matcher<? super Throwable> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getCause(), matcher, Messages.Check.CAUSE);
    }

    /**
     * Check if the cause of the throwable is null.
     */
    public void causeIsNull() {
        toCause().isNull();
    }

    /**
     * Check if the cause of the throwable is NOT null.
     */
    public void causeIsNotNull() {
        toCause().isNotNull();
    }

    /**
     * Check if the cause of the throwable is instance of the expected class.
     *
     * @param expected the expected class.
     */
    public void hasCause(final Class<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().isInstanceOf(expected);
    }

    /**
     * Check if the causes of the throwable is instance of the expected classes.
     *
     * @param expected the expected classes.
     */
    public void hasCauses(final Class<?>... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        for (Class<?> clazz : expected) {
            checkArgumentIsNotNull(clazz, "expected");
        }
        hasCauses(0, expected);
    }

    private void hasCauses(final int idx, final Class<?>... expected) {
        if (idx < expected.length) {
            toCause().isInstanceOf(expected[idx]);
            toCause().hasCauses(idx + 1, expected);
        }
    }

    /**
     * Check if the message of the cause of the throwable is null.
     */
    public void causeMessageIsNull() {
        toCause().messageIsNull();
    }

    /**
     * Check if the message of the cause of the throwable is NOT null.
     */
    public void causeMessageIsNotNull() {
        toCause().messageIsNotNull();
    }

    /**
     * Check if the message of the cause of the throwable is empty.
     */
    public void causeMessageIsEmpty() {
        toCause().messageIsEmpty();
    }

    /**
     * Check if the message of the cause of the throwable is null or empty.
     */
    public void causeMessageIsNullOrEmpty() {
        toCause().messageIsNullOrEmpty();
    }

    /**
     * Check if the message of the cause of the throwable is NOT empty.
     */
    public void causeMessageIsNotEmpty() {
        toCause().messageIsNotEmpty();
    }

    /**
     * Check if the message of the cause of the throwable is blank.
     */
    public void causeMessageIsBlank() {
        toCause().messageIsBlank();
    }

    /**
     * Check if the message of the cause of the throwable is null or blank.
     */
    public void causeMessageIsNullOrBlank() {
        toCause().messageIsNullOrBlank();
    }

    /**
     * Check if the message of the cause of the throwable is NOT blank.
     */
    public void causeMessageIsNotBlank() {
        toCause().messageIsNotBlank();
    }

    /**
     * Check if the message of the cause of the throwable has the expected value.
     *
     * @param expected the expected value.
     */
    public void hasCauseMessage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().hasMessage(expected);
    }

    /**
     * Check if the message of the cause of the throwable contains the expected value.
     *
     * @param expected the expected value.
     */
    public void causeMessageContains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageContains(expected);
    }

    /**
     * Check if the message of the cause of the throwable contains the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public void causeMessageContainsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageContainsIgnoreCase(expected);
    }

    /**
     * Check if the message of the cause of the throwable matches the expected value.
     *
     * @param expected the expected value.
     */
    public void causeMessageMatches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCause().messageMatches(expected);
    }

}
