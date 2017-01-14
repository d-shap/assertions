///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
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
 * Assertions for the char value.
 *
 * @author Dmitry Shapovalov
 */
public class CharAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual char value.
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
    public final void isEqualTo(final char expected) {
        if ((Character) getActual() != expected) {
            throw createAssertionError(FailMessages.getSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final char expected) {
        if ((Character) getActual() == expected) {
            throw createAssertionError(FailMessages.getDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final char expected) {
        if ((Character) getActual() <= expected) {
            throw createAssertionError(FailMessages.getGreater(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final char expected) {
        if ((Character) getActual() < expected) {
            throw createAssertionError(FailMessages.getGreaterOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final char expected) {
        if ((Character) getActual() >= expected) {
            throw createAssertionError(FailMessages.getLess(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final char expected) {
        if ((Character) getActual() > expected) {
            throw createAssertionError(FailMessages.getLessOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is the alphabetic symbol.
     */
    public final void isAlphabetic() {
        if (!Character.isAlphabetic((Character) getActual())) {
            throw createAssertionError(FailMessages.getAlphabetic(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the digit.
     */
    public final void isDigit() {
        if (!Character.isDigit((Character) getActual())) {
            throw createAssertionError(FailMessages.getDigit(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the letter.
     */
    public final void isLetter() {
        if (!Character.isLetter((Character) getActual())) {
            throw createAssertionError(FailMessages.getLetter(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the letter or the digit.
     */
    public final void isLetterOrDigit() {
        if (!Character.isLetterOrDigit((Character) getActual())) {
            throw createAssertionError(FailMessages.getLetterOrDigit(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the control symbol.
     */
    public final void isControl() {
        if (!Character.isISOControl((Character) getActual())) {
            throw createAssertionError(FailMessages.getControl(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the lower case symbol.
     */
    public final void isLowerCase() {
        if (!Character.isLowerCase((Character) getActual())) {
            throw createAssertionError(FailMessages.getLowerCase(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the upper case symbol.
     */
    public final void isUpperCase() {
        if (!Character.isUpperCase((Character) getActual())) {
            throw createAssertionError(FailMessages.getUpperCase(actualAsString()));
        }
    }

    /**
     * Check if the actual value is the whitespace symbol.
     */
    public final void isWhitespace() {
        if (!Character.isWhitespace((Character) getActual())) {
            throw createAssertionError(FailMessages.getWhitespace(actualAsString()));
        }
    }

    @Override
    protected final String asString(final Object value) {
        char symbol = (char) value;
        int code = (char) value;
        return symbol + "(" + code + ")";
    }

}
