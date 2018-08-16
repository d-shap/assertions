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
package ru.d_shap.assertions.primitive;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the char.
 *
 * @author Dmitry Shapovalov
 */
public class CharAssertion extends ReferenceAssertion<Character> {

    /**
     * Create new object.
     */
    public CharAssertion() {
        super();
    }

    @Override
    protected final Class<Character> getActualValueClass() {
        return Character.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final int expectedFrom, final int expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final int expectedFrom, final int expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is the alphabetic symbol.
     */
    public final void isAlphabetic() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isAlphabetic(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_ALPHABETIC).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the alphabetic symbol.
     */
    public final void isNotAlphabetic() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isAlphabetic(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_ALPHABETIC).addActual().build();
        }
    }

    /**
     * Check if the actual value is the letter.
     */
    public final void isLetter() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLetter(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LETTER).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the letter.
     */
    public final void isNotLetter() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isLetter(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_LETTER).addActual().build();
        }
    }

    /**
     * Check if the actual value is the digit.
     */
    public final void isDigit() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isDigit(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_DIGIT).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the digit.
     */
    public final void isNotDigit() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isDigit(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_DIGIT).addActual().build();
        }
    }

    /**
     * Check if the actual value is the whitespace symbol.
     */
    public final void isWhitespace() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isWhitespace(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_WHITESPACE).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the whitespace symbol.
     */
    public final void isNotWhitespace() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isWhitespace(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_WHITESPACE).addActual().build();
        }
    }

    /**
     * Check if the actual value is the letter or the digit.
     */
    public final void isLetterOrDigit() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLetter(getActual()) && !Character.isDigit(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LETTER_OR_DIGIT).addActual().build();
        }
    }

    /**
     * Check if the actual value is the letter or the whitespace symbol.
     */
    public final void isLetterOrWhitespace() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLetter(getActual()) && !Character.isWhitespace(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LETTER_OR_WHITESPACE).addActual().build();
        }
    }

    /**
     * Check if the actual value is the control symbol.
     */
    public final void isControl() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isISOControl(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_CONTROL_SYMBOL).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the control symbol.
     */
    public final void isNotControl() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isISOControl(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_CONTROL_SYMBOL).addActual().build();
        }
    }

    /**
     * Check if the actual value is the lower case symbol.
     */
    public final void isLowerCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLowerCase(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LOWER_CASE).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the lower case symbol.
     */
    public final void isNotLowerCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isLowerCase(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_LOWER_CASE).addActual().build();
        }
    }

    /**
     * Check if the actual value is the upper case symbol.
     */
    public final void isUpperCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isUpperCase(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_UPPER_CASE).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT the upper case symbol.
     */
    public final void isNotUpperCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (Character.isUpperCase(getActual())) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_UPPER_CASE).addActual().build();
        }
    }

}
