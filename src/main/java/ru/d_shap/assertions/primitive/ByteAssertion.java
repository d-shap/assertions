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

import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.FailMessages;

/**
 * Assertions for the byte.
 *
 * @author Dmitry Shapovalov
 */
public class ByteAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public ByteAssertion(final byte actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final int expected) {
        if ((Byte) getActual() != expected) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final int expected) {
        if ((Byte) getActual() == expected) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final int expected) {
        if ((Byte) getActual() <= expected) {
            throw createAssertionError(FailMessages.getIsGreater(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final int expected) {
        if ((Byte) getActual() < expected) {
            throw createAssertionError(FailMessages.getIsGreaterOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final int expected) {
        if ((Byte) getActual() >= expected) {
            throw createAssertionError(FailMessages.getIsLess(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final int expected) {
        if ((Byte) getActual() > expected) {
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
        if ((Byte) getActual() < expectedFrom || (Byte) getActual() >= expectedTo) {
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
        if ((Byte) getActual() >= expectedFrom && (Byte) getActual() < expectedTo) {
            throw createAssertionError(FailMessages.getIsNotInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

}
