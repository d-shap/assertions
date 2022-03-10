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
package ru.d_shap.assertions.asimp.primitive;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.asimp.ReferenceAssertion;

/**
 * Assertions for the double.
 *
 * @author Dmitry Shapovalov
 */
public class DoubleAssertion extends ReferenceAssertion<Double> {

    private static final double DEFAULT_DELTA = 1.0e-11f;

    /**
     * Create new object.
     */
    public DoubleAssertion() {
        super();
    }

    @Override
    protected final Class<Double> getActualValueClass() {
        return Double.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final double expected) {
        isEqualTo(expected, DEFAULT_DELTA);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Double expected) {
        isEqualTo(expected, DEFAULT_DELTA);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final double expected, final double delta) {
        checkActualIsNotNull();
        if (Math.abs(expected - getActual()) > delta) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).addDelta(delta).build();
        }
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final Double expected, final double delta) {
        if (expected == null) {
            isNull();
        } else {
            isEqualTo(expected.doubleValue(), delta);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final double expected) {
        isNotEqualTo(expected, DEFAULT_DELTA);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Double expected) {
        isNotEqualTo(expected, DEFAULT_DELTA);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final double expected, final double delta) {
        checkActualIsNotNull();
        if (Math.abs(expected - getActual()) <= delta) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().addDelta(delta).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final Double expected, final double delta) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null) {
                isNotEqualTo(expected.doubleValue(), delta);
            }
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final double expected) {
        checkActualIsNotNull();
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final Double expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isGreaterThan(expected.doubleValue());
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final double expected) {
        checkActualIsNotNull();
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final Double expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isGreaterThanOrEqualTo(expected.doubleValue());
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final double expected) {
        checkActualIsNotNull();
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final Double expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isLessThan(expected.doubleValue());
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final double expected) {
        checkActualIsNotNull();
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final Double expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isLessThanOrEqualTo(expected.doubleValue());
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final double expectedFrom, final double expectedTo) {
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final Double expectedFrom, final Double expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        isInRange(expectedFrom.doubleValue(), expectedTo.doubleValue());
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final double expectedFrom, final double expectedTo) {
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final Double expectedFrom, final Double expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        isNotInRange(expectedFrom.doubleValue(), expectedTo.doubleValue());
    }

    /**
     * Check if the actual value is zero.
     */
    public final void isZero() {
        checkActualIsNotNull();
        if (getActual() != 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_ZERO).addActual().build();
        }
    }

    /**
     * Check if the actual value is not zero.
     */
    public final void isNonZero() {
        checkActualIsNotNull();
        if (getActual() == 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NON_ZERO).build();
        }
    }

    /**
     * Check if the actual value is positive infinity.
     */
    public final void isPositiveInfinity() {
        checkActualIsNotNull();
        if (getActual() != Double.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_POSITIVE_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is negative infinity.
     */
    public final void isNegativeInfinity() {
        checkActualIsNotNull();
        if (getActual() != Double.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NEGATIVE_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is infinity.
     */
    public final void isInfinity() {
        checkActualIsNotNull();
        if (!getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NaN.
     */
    public final void isNaN() {
        checkActualIsNotNull();
        if (!getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NAN).addActual().build();
        }
    }

    /**
     * Check if the actual value is not NaN.
     */
    public final void isNotNaN() {
        checkActualIsNotNull();
        if (getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NAN).build();
        }
    }

    /**
     * Check if the actual value is finite value.
     */
    public final void isFinite() {
        checkActualIsNotNull();
        if (getActual().isNaN() || getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_FINITE).addActual().build();
        }
    }

}
