///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the comparable.
 *
 * @author Dmitry Shapovalov
 */
public class ComparableAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public ComparableAssertion(final Comparable<?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) != 0) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isNotEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) == 0) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isGreaterThan(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) <= 0) {
            throw createAssertionError(FailMessages.getIsGreater(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isGreaterThanOrEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) < 0) {
            throw createAssertionError(FailMessages.getIsGreaterOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isLessThan(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) >= 0) {
            throw createAssertionError(FailMessages.getIsLess(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    @SuppressWarnings("unchecked")
    public final void isLessThanOrEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Comparable<Object>) getActual()).compareTo(expected) > 0) {
            throw createAssertionError(FailMessages.getIsLessOrEqual(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    @SuppressWarnings("unchecked")
    public final void isInRange(final Object expectedFrom, final Object expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (((Comparable<Object>) getActual()).compareTo(expectedFrom) < 0 || ((Comparable<Object>) getActual()).compareTo(expectedTo) >= 0) {
            throw createAssertionError(FailMessages.getIsInRange(actualAsString(), asString(expectedFrom), asString(expectedTo)));
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     */
    @SuppressWarnings("unchecked")
    public final void isNotInRange(final Object expectedFrom, final Object expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        if (((Comparable<Object>) getActual()).compareTo(expectedFrom) >= 0 && ((Comparable<Object>) getActual()).compareTo(expectedTo) < 0) {
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
