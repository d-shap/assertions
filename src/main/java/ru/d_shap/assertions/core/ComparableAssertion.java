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
package ru.d_shap.assertions.core;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the comparable.
 *
 * @param <T> the comparable type.
 * @author Dmitry Shapovalov
 */
public class ComparableAssertion<T> extends ReferenceAssertion {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(Comparable.class);

    /**
     * Create new object.
     */
    public ComparableAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isEqualTo(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) != 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isNotEqualTo(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) == 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isGreaterThan(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) <= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isGreaterThanOrEqualTo(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isLessThan(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isLessThanOrEqualTo(final T expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<T>) getActual()).compareTo(expected) > 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    @SuppressWarnings("unchecked")
    public final void isInRange(final T expectedFrom, final T expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (((Comparable<T>) getActual()).compareTo(expectedFrom) < 0 || ((Comparable<T>) getActual()).compareTo(expectedTo) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    @SuppressWarnings("unchecked")
    public final void isNotInRange(final T expectedFrom, final T expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (((Comparable<T>) getActual()).compareTo(expectedFrom) >= 0 && ((Comparable<T>) getActual()).compareTo(expectedTo) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
