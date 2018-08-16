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
 * Assertions for the long.
 *
 * @author Dmitry Shapovalov
 */
public class LongAssertion extends ReferenceAssertion<Long> {

    /**
     * Create new object.
     */
    public LongAssertion() {
        super();
    }

    @Override
    protected final Class<Long> getActualValueClass() {
        return Long.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final long expected) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final long expectedFrom, final long expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final long expectedFrom, final long expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

}
