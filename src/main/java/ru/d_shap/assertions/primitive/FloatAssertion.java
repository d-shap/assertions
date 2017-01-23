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
 * Assertions for the float.
 *
 * @author Dmitry Shapovalov
 */
public class FloatAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public FloatAssertion(final float actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final float expected, final float delta) {
        if (Float.compare(expected, (Float) getActual()) != 0 && Math.abs(expected - (Float) getActual()) > delta) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final float expected, final float delta) {
        if (Float.compare(expected, (Float) getActual()) == 0 || Math.abs(expected - (Float) getActual()) <= delta) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final float expected) {
        if ((Float) getActual() <= expected) {
            throw createAssertionError(FailMessages.getIsGreater(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final float expected) {
        if ((Float) getActual() < expected) {
            throw createAssertionError(FailMessages.getIsGreaterOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final float expected) {
        if ((Float) getActual() >= expected) {
            throw createAssertionError(FailMessages.getIsLess(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final float expected) {
        if ((Float) getActual() > expected) {
            throw createAssertionError(FailMessages.getIsLessOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    public final void isInRange(final float expectedFrom, final float expectedTo) {
        if ((Float) getActual() < expectedFrom || (Float) getActual() >= expectedTo) {
            throw createAssertionError(FailMessages.getIsInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    public final void isNotInRange(final float expectedFrom, final float expectedTo) {
        if ((Float) getActual() >= expectedFrom && (Float) getActual() < expectedTo) {
            throw createAssertionError(FailMessages.getIsNotInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    /**
     * Check if the actual value is zero.
     */
    public final void isZero() {
        if ((Float) getActual() != 0.0f) {
            throw createAssertionError(FailMessages.getIsZero(actualAsString()));
        }
    }

    /**
     * Check if the actual value is not zero.
     */
    public final void isNonZero() {
        if ((Float) getActual() == 0.0f) {
            throw createAssertionError(FailMessages.getIsNonZero());
        }
    }

    /**
     * Check if the actual value is positive infinity.
     */
    public final void isPositiveInfinity() {
        if ((Float) getActual() != Float.POSITIVE_INFINITY) {
            throw createAssertionError(FailMessages.getIsPositiveInfinity(actualAsString()));
        }
    }

    /**
     * Check if the actual value is negative infinity.
     */
    public final void isNegativeInfinity() {
        if ((Float) getActual() != Float.NEGATIVE_INFINITY) {
            throw createAssertionError(FailMessages.getIsNegativeInfinity(actualAsString()));
        }
    }

    /**
     * Check if the actual value is infinity.
     */
    public final void isInfinity() {
        if (!((Float) getActual()).isInfinite()) {
            throw createAssertionError(FailMessages.getIsInfinity(actualAsString()));
        }
    }

    /**
     * Check if the actual value is NaN.
     */
    public final void isNaN() {
        if (!((Float) getActual()).isNaN()) {
            throw createAssertionError(FailMessages.getIsNaN(actualAsString()));
        }
    }

    /**
     * Check if the actual value is not NaN.
     */
    public final void isNotNaN() {
        if (((Float) getActual()).isNaN()) {
            throw createAssertionError(FailMessages.getIsNotNaN());
        }
    }

    /**
     * Check if the actual value is finite value.
     */
    public final void isFinite() {
        if (((Float) getActual()).isNaN() || ((Float) getActual()).isInfinite()) {
            throw createAssertionError(FailMessages.getIsFinite(actualAsString()));
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
