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

/**
 * Assertions for the comparable.
 *
 * @param <E> the generic type of the comparable.
 * @author Dmitry Shapovalov
 */
public class ComparableAssertion<E> extends ReferenceAssertion<Comparable<E>> {

    /**
     * Create new object.
     */
    public ComparableAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<Comparable<E>> getActualValueClass() {
        return (Class<Comparable<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Comparable.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) != 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) == 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) <= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final E expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().compareTo(expected) > 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRange(final E expectedFrom, final E expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (getActual().compareTo(expectedFrom) < 0 || getActual().compareTo(expectedTo) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRange(final E expectedFrom, final E expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (getActual().compareTo(expectedFrom) >= 0 && getActual().compareTo(expectedTo) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
