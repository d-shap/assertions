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
 * Assertions for the float.
 *
 * @author Dmitry Shapovalov
 */
public class FloatAssertion extends ReferenceAssertion<Float> {

    /**
     * Create new object.
     */
    public FloatAssertion() {
        super();
    }

    @Override
    protected final Class<Float> getActualValueClass() {
        return Float.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final float expected, final float delta) {
        checkInitialized();
        checkActualIsNotNull();
        if (Math.abs(expected - getActual()) > delta) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final float expected, final float delta) {
        checkInitialized();
        checkActualIsNotNull();
        if (Math.abs(expected - getActual()) <= delta) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final float expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final float expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final float expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final float expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final float expectedFrom, final float expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final float expectedFrom, final float expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is zero.
     */
    public final void isZero() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() != 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_ZERO).addActual().build();
        }
    }

    /**
     * Check if the actual value is not zero.
     */
    public final void isNonZero() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() == 0.0f) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NON_ZERO).addActual().build();
        }
    }

    /**
     * Check if the actual value is positive infinity.
     */
    public final void isPositiveInfinity() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() != Float.POSITIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_POSITIVE_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is negative infinity.
     */
    public final void isNegativeInfinity() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() != Float.NEGATIVE_INFINITY) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NEGATIVE_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is infinity.
     */
    public final void isInfinity() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_INFINITY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NaN.
     */
    public final void isNaN() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NAN).addActual().build();
        }
    }

    /**
     * Check if the actual value is not NaN.
     */
    public final void isNotNaN() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isNaN()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_NAN).addActual().build();
        }
    }

    /**
     * Check if the actual value is finite value.
     */
    public final void isFinite() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isNaN() || getActual().isInfinite()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_FINITE).addActual().build();
        }
    }

}
