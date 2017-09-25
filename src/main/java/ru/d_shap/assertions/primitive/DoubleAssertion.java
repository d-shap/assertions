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
import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;

/**
 * Assertions for the double.
 *
 * @author Dmitry Shapovalov
 */
public class DoubleAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public DoubleAssertion(final double actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final double expected, final double delta) {
        if (Math.abs(expected - (Double) getActual()) > delta) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final double expected, final double delta) {
        if (Math.abs(expected - (Double) getActual()) <= delta) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final double expected) {
        if ((Double) getActual() <= expected) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final double expected) {
        if ((Double) getActual() < expected) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final double expected) {
        if ((Double) getActual() >= expected) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final double expected) {
        if ((Double) getActual() > expected) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRange(final double expectedFrom, final double expectedTo) {
        if ((Double) getActual() < expectedFrom || (Double) getActual() >= expectedTo) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRange(final double expectedFrom, final double expectedTo) {
        if ((Double) getActual() >= expectedFrom && (Double) getActual() < expectedTo) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is zero.
     */
    public final void isZero() {
        if ((Double) getActual() != 0.0f) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_ZERO);
        }
    }

    /**
     * Check if the actual value is not zero.
     */
    public final void isNonZero() {
        if ((Double) getActual() == 0.0f) {
            throw createAssertionError(Messages.Fail.IS_NON_ZERO);
        }
    }

    /**
     * Check if the actual value is positive infinity.
     */
    public final void isPositiveInfinity() {
        if ((Double) getActual() != Double.POSITIVE_INFINITY) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_POSITIVE_INFINITY);
        }
    }

    /**
     * Check if the actual value is negative infinity.
     */
    public final void isNegativeInfinity() {
        if ((Double) getActual() != Double.NEGATIVE_INFINITY) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NEGATIVE_INFINITY);
        }
    }

    /**
     * Check if the actual value is infinity.
     */
    public final void isInfinity() {
        if (!((Double) getActual()).isInfinite()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_INFINITY);
        }
    }

    /**
     * Check if the actual value is NaN.
     */
    public final void isNaN() {
        if (!((Double) getActual()).isNaN()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NAN);
        }
    }

    /**
     * Check if the actual value is not NaN.
     */
    public final void isNotNaN() {
        if (((Double) getActual()).isNaN()) {
            throw createAssertionError(Messages.Fail.IS_NOT_NAN);
        }
    }

    /**
     * Check if the actual value is finite value.
     */
    public final void isFinite() {
        if (((Double) getActual()).isNaN() || ((Double) getActual()).isInfinite()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_FINITE);
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
