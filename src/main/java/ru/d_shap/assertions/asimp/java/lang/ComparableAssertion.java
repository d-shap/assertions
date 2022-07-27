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
package ru.d_shap.assertions.asimp.java.lang;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.asimp.ReferenceAssertion;

/**
 * Assertions for the comparable.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class ComparableAssertion<E> extends ReferenceAssertion<Comparable<E>> {

    /**
     * Create new object.
     */
    public ComparableAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<Comparable<E>> getActualValueClass() {
        return (Class<Comparable<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Comparable.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ComparableAssertion<E> isEqualTo(final E expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (getActual().compareTo(expected) != 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
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
    public ComparableAssertion<E> isNotEqualTo(final E expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().compareTo(expected) == 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
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
    public ComparableAssertion<E> isGreaterThan(final E expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) <= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
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
    public ComparableAssertion<E> isGreaterThanOrEqualTo(final E expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
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
    public ComparableAssertion<E> isLessThan(final E expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
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
    public ComparableAssertion<E> isLessThanOrEqualTo(final E expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) > 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
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
    public ComparableAssertion<E> isInRange(final E expectedFrom, final E expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) < 0 || getActual().compareTo(expectedTo) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
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
    public ComparableAssertion<E> isNotInRange(final E expectedFrom, final E expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) >= 0 && getActual().compareTo(expectedTo) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

}
