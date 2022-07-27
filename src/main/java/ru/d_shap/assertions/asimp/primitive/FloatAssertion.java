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
 * Assertions for the float.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatAssertion extends ReferenceAssertion<Float> {

    private static final float DEFAULT_DELTA = 1.0e-5f;

    /**
     * Create new object.
     */
    public FloatAssertion() {
        super();
    }

    @Override
    protected Class<Float> getActualValueClass() {
        return Float.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isEqualTo(final float expected) {
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
    public FloatAssertion isEqualTo(final Float expected) {
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
    public FloatAssertion isEqualTo(final float expected, final float delta) {
        if (Float.isNaN(expected)) {
            isNaN();
        } else if (expected == Float.POSITIVE_INFINITY) {
            isPositiveInfinity();
        } else if (expected == Float.NEGATIVE_INFINITY) {
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
    public FloatAssertion isEqualTo(final Float expected, final float delta) {
        if (expected == null) {
            isNull();
        } else {
            isEqualTo(expected.floatValue(), delta);
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
    public FloatAssertion isNotEqualTo(final float expected) {
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
    public FloatAssertion isNotEqualTo(final Float expected) {
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
    public FloatAssertion isNotEqualTo(final float expected, final float delta) {
        if (Float.isNaN(expected)) {
            if (getActual() != null && getActual().isNaN()) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NAN).build();
            }
        } else if (expected == Float.POSITIVE_INFINITY) {
            if (getActual() != null && getActual() == Float.POSITIVE_INFINITY) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_POSITIVE_INFINITY).build();
            }
        } else if (expected == Float.NEGATIVE_INFINITY) {
            if (getActual() != null && getActual() == Float.NEGATIVE_INFINITY) {
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
    public FloatAssertion isNotEqualTo(final Float expected, final float delta) {
        if (expected == null) {
            isNotNull();
        } else {
            isNotEqualTo(expected.floatValue(), delta);
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
    public FloatAssertion isGreaterThan(final float expected) {
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
    public FloatAssertion isGreaterThan(final Float expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isGreaterThan(expected.floatValue());
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isGreaterThanOrEqualTo(final float expected) {
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
    public FloatAssertion isGreaterThanOrEqualTo(final Float expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isGreaterThanOrEqualTo(expected.floatValue());
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isLessThan(final float expected) {
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
    public FloatAssertion isLessThan(final Float expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isLessThan(expected.floatValue());
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isLessThanOrEqualTo(final float expected) {
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
    public FloatAssertion isLessThanOrEqualTo(final Float expected) {
        isFinite();
        checkArgumentIsFinite(expected, "expected");
        isLessThanOrEqualTo(expected.floatValue());
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
    public FloatAssertion isInRange(final float expectedFrom, final float expectedTo) {
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
    public FloatAssertion isInRange(final Float expectedFrom, final Float expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        isInRange(expectedFrom.floatValue(), expectedTo.floatValue());
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
    public FloatAssertion isNotInRange(final float expectedFrom, final float expectedTo) {
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
    public FloatAssertion isNotInRange(final Float expectedFrom, final Float expectedTo) {
        isFinite();
        checkArgumentIsFinite(expectedFrom, "expectedFrom");
        checkArgumentIsFinite(expectedTo, "expectedTo");
        isNotInRange(expectedFrom.floatValue(), expectedTo.floatValue());
        return this;
    }

    /**
     * Check if the actual value is zero.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isZero() {
        checkActualIsNotNull();
        if (getActual() != 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_ZERO).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT zero.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isNotZero() {
        checkActualIsNotNull();
        if (getActual() == 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_ZERO).build();
        }
        return this;
    }

    /**
     * Check if the actual value is positive infinity.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isPositiveInfinity() {
        checkActualIsNotNull();
        if (getActual() != Float.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_POSITIVE_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT positive infinity.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isNotPositiveInfinity() {
        checkActualIsNotNull();
        if (getActual() == Float.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_POSITIVE_INFINITY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is negative infinity.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isNegativeInfinity() {
        checkActualIsNotNull();
        if (getActual() != Float.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NEGATIVE_INFINITY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT negative infinity.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isNotNegativeInfinity() {
        checkActualIsNotNull();
        if (getActual() == Float.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_NEGATIVE_INFINITY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is infinity.
     *
     * @return current object for the chain call.
     */
    public FloatAssertion isInfinity() {
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
    public FloatAssertion isNotInfinity() {
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
    public FloatAssertion isNaN() {
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
    public FloatAssertion isNotNaN() {
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
    public FloatAssertion isFinite() {
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
    public FloatAssertion isNotFinite() {
        checkActualIsNotNull();
        if (!getActual().isNaN() && !getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_FINITE).addActual().build();
        }
        return this;
    }

}
