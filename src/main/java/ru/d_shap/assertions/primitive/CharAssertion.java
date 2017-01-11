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

    private final char _actual;

    /**
     * Create new object.
     *
     * @param actual  the actual char value.
     * @param message the assertion message.
     */
    public CharAssertion(final char actual, final String message) {
        super(message);
        _actual = actual;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final char expected) {
        if (_actual != expected) {
            throw createAssertionError(FailMessages.getSame(charToString(_actual), charToString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final char expected) {
        if (_actual == expected) {
            throw createAssertionError(FailMessages.getDifferent(charToString(_actual)));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final char expected) {
        if (_actual <= expected) {
            throw createAssertionError(FailMessages.getGreater(charToString(_actual), charToString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final char expected) {
        if (_actual < expected) {
            throw createAssertionError(FailMessages.getGreaterOrEqual(charToString(_actual), charToString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final char expected) {
        if (_actual >= expected) {
            throw createAssertionError(FailMessages.getLess(charToString(_actual), charToString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final char expected) {
        if (_actual > expected) {
            throw createAssertionError(FailMessages.getLessOrEqual(charToString(_actual), charToString(expected)));
        }
    }

    private String charToString(final char value) {
        return value + "(" + (int) value + ")";
    }

}
