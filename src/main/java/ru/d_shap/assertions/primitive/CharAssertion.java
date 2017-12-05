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
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
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
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
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
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
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
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
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
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
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
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRange(final int expectedFrom, final int expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRange(final int expectedFrom, final int expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is the alphabetic symbol.
     */
    public final void isAlphabetic() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isAlphabetic(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_ALPHABETIC);
        }
    }

    /**
     * Check if the actual value is the digit.
     */
    public final void isDigit() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isDigit(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIGIT);
        }
    }

    /**
     * Check if the actual value is the letter.
     */
    public final void isLetter() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLetter(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LETTER);
        }
    }

    /**
     * Check if the actual value is the letter or the digit.
     */
    public final void isLetterOrDigit() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLetterOrDigit(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LETTER_OR_DIGIT);
        }
    }

    /**
     * Check if the actual value is the control symbol.
     */
    public final void isControl() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isISOControl(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_CONTROL_SYMBOL);
        }
    }

    /**
     * Check if the actual value is the lower case symbol.
     */
    public final void isLowerCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isLowerCase(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LOWER_CASE);
        }
    }

    /**
     * Check if the actual value is the upper case symbol.
     */
    public final void isUpperCase() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isUpperCase(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_UPPER_CASE);
        }
    }

    /**
     * Check if the actual value is the whitespace symbol.
     */
    public final void isWhitespace() {
        checkInitialized();
        checkActualIsNotNull();
        if (!Character.isWhitespace(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_WHITESPACE);
        }
    }

    @Override
    protected final String asString(final Object value) {
        if (value instanceof Character) {
            return asSymbolAndCodeString((char) value, (char) value);
        } else if (value instanceof Integer) {
            int code = (int) value;
            char symbol = (char) code;
            if (symbol == code) {
                return asSymbolAndCodeString(symbol, code);
            } else {
                return asCodeString(code);
            }
        } else {
            return value.toString();
        }
    }

    private String asSymbolAndCodeString(final char symbol, final int code) {
        if (Character.isLetterOrDigit(symbol)) {
            return symbol + "(" + code + ")";
        } else {
            return asCodeString(code);
        }
    }

    private String asCodeString(final int code) {
        return " (" + code + ")";
    }

}
