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
public final class DoubleAssertion extends ReferenceAssertion<DoubleAssertion, Double> {

    private static final double DEFAULT_DELTA = 1.0e-11f;

    /**
     * Create new object.
     */
    public DoubleAssertion() {
        super();
    }

    @Override
    protected Class<Double> getActualValueClass() {
        return Double.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isEqualTo(final double expected) {
        isEqualTo(expected, DEFAULT_DELTA);
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isEqualTo(final Double expected) {
        isEqualTo(expected, DEFAULT_DELTA);
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isEqualTo(final double expected, final double delta) {
        if (Double.isNaN(expected)) {
            isNaN();
        } else if (expected == Double.POSITIVE_INFINITY) {
            isPositiveInfinity();
        } else if (expected == Double.NEGATIVE_INFINITY) {
            isNegativeInfinity();
        } else {
            isFinite();
            if (Math.abs(expected - getActual()) > delta) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpectedWithDelta(expected, delta).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isEqualTo(final Double expected, final double delta) {
        if (expected == null) {
            isNull();
        } else {
            isEqualTo(expected.doubleValue(), delta);
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotEqualTo(final double expected) {
        isNotEqualTo(expected, DEFAULT_DELTA);
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotEqualTo(final Double expected) {
        isNotEqualTo(expected, DEFAULT_DELTA);
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotEqualTo(final double expected, final double delta) {
        if (Double.isNaN(expected)) {
            if (getActual() != null && getActual().isNaN()) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NAN).build();
            }
        } else if (expected == Double.POSITIVE_INFINITY) {
            if (getActual() != null && getActual() == Double.POSITIVE_INFINITY) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_POSITIVE_INFINITY).build();
            }
        } else if (expected == Double.NEGATIVE_INFINITY) {
            if (getActual() != null && getActual() == Double.NEGATIVE_INFINITY) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NEGATIVE_INFINITY).build();
            }
        } else {
            if (getActual() != null && Math.abs(expected - getActual()) <= delta) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActualWithDelta(delta).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotEqualTo(final Double expected, final double delta) {
        if (expected == null) {
            isNotNull();
        } else {
            isNotEqualTo(expected.doubleValue(), delta);
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isGreaterThan(final double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isGreaterThan(final Double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isGreaterThan(expected.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isGreaterThanOrEqualTo(final double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isGreaterThanOrEqualTo(final Double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isGreaterThanOrEqualTo(expected.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isLessThan(final double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isLessThan(final Double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isLessThan(expected.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isLessThanOrEqualTo(final double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isLessThanOrEqualTo(final Double expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isLessThanOrEqualTo(expected.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isInRange(final double expectedFrom, final double expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isInRange(final Double expectedFrom, final Double expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        isInRange(expectedFrom.doubleValue(), expectedTo.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotInRange(final double expectedFrom, final double expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotInRange(final Double expectedFrom, final Double expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        isNotInRange(expectedFrom.doubleValue(), expectedTo.doubleValue());
        return this;
    }

    /**
     * Check if the actual value is zero.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isZero() {
        checkActualIsNotNull();
        if (getActual() != 0.0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_ZERO).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT zero.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotZero() {
        checkActualIsNotNull();
        if (getActual() == 0.0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_ZERO).build();
        }
        return this;
    }

    /**
     * Check if the actual value is positive infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isPositiveInfinity() {
        checkActualIsNotNull();
        if (getActual() != Double.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_POSITIVE_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT positive infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotPositiveInfinity() {
        checkActualIsNotNull();
        if (getActual() == Double.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_POSITIVE_INFINITY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is negative infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNegativeInfinity() {
        checkActualIsNotNull();
        if (getActual() != Double.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NEGATIVE_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT negative infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotNegativeInfinity() {
        checkActualIsNotNull();
        if (getActual() == Double.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NEGATIVE_INFINITY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isInfinity() {
        checkActualIsNotNull();
        if (!getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT infinity.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotInfinity() {
        checkActualIsNotNull();
        if (getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NaN.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNaN() {
        checkActualIsNotNull();
        if (!getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NAN).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT NaN.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotNaN() {
        checkActualIsNotNull();
        if (getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NAN).build();
        }
        return this;
    }

    /**
     * Check if the actual value is finite.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isFinite() {
        checkActualIsNotNull();
        if (getActual().isNaN() || getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_FINITE).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT finite.
     *
     * @return current object for the chain call.
     */
    public DoubleAssertion isNotFinite() {
        checkActualIsNotNull();
        if (!getActual().isNaN() && !getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_FINITE).addActual().build();
        }
        return this;
    }

}
