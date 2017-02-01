///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.FailMessages;

/**
 * Assertions for the char.
 *
 * @author Dmitry Shapovalov
 */
public class CharAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public CharAssertion(final char actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final int expected) {
        if ((Character) getActual() != expected) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final int expected) {
        if ((Character) getActual() == expected) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final int expected) {
        if ((Character) getActual() <= expected) {
            throw createAssertionError(FailMessages.getIsGreater(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final int expected) {
        if ((Character) getActual() < expected) {
            throw createAssertionError(FailMessages.getIsGreaterOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final int expected) {
        if ((Character) getActual() >= expected) {
            throw createAssertionError(FailMessages.getIsLess(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final int expected) {
        if ((Character) getActual() > expected) {
            throw createAssertionError(FailMessages.getIsLessOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    public final void isInRange(final int expectedFrom, final int expectedTo) {
        if ((Character) getActual() < expectedFrom || (Character) getActual() >= expectedTo) {
            throw createAssertionError(FailMessages.getIsInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    public final void isNotInRange(final int expectedFrom, final int expectedTo) {
        if ((Character) getActual() >= expectedFrom && (Character) getActual() < expectedTo) {
            throw createAssertionError(FailMessages.getIsNotInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    /**
     * Check if the actual value is the alphabetic symbol.
     */
    public final void isAlphabetic() {
        if (!Character.isAlphabetic((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsAlphabetic(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the digit.
     */
    public final void isDigit() {
        if (!Character.isDigit((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsDigit(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the letter.
     */
    public final void isLetter() {
        if (!Character.isLetter((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsLetter(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the letter or the digit.
     */
    public final void isLetterOrDigit() {
        if (!Character.isLetterOrDigit((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsLetterOrDigit(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the control symbol.
     */
    public final void isControl() {
        if (!Character.isISOControl((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsControl(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the lower case symbol.
     */
    public final void isLowerCase() {
        if (!Character.isLowerCase((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsLowerCase(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the upper case symbol.
     */
    public final void isUpperCase() {
        if (!Character.isUpperCase((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsUpperCase(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the whitespace symbol.
     */
    public final void isWhitespace() {
        if (!Character.isWhitespace((Character) getActual())) {
            throw createAssertionError(FailMessages.getIsWhitespace(actualAsString()));
        }
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
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
                return String.valueOf(value);
            }
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
