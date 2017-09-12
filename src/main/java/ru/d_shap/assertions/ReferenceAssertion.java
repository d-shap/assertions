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
package ru.d_shap.assertions;

import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.StringAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Base class for all reference type assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class ReferenceAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    protected ReferenceAssertion(final Object actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is null.
     */
    public final void isNull() {
        if (getActual() != null) {
            throw createAssertionError(FailMessages.getIsNull(actualAsString()));
        }
    }

    /**
     * Check if the actual value is NOT null.
     */
    public final void isNotNull() {
        checkActualIsNotNull();
    }

    /**
     * Check if the actual value is the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isSameAs(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual() != expected) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT the same as the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotSameAs(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual() == expected) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Make assertion about the value class.
     *
     * @return the assertion.
     */
    public final ClassAssertion toClass() {
        checkActualIsNotNull();
        return new ClassAssertion(getActual().getClass(), getMessage());
    }

    /**
     * Check if the actual value has the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasClass(final Class<?> expected) {
        toClass().isEqualTo(expected);
    }

    /**
     * Check if the actual value has NOT the expected class.
     *
     * @param expected the expected class.
     */
    public final void hasNotClass(final Class<?> expected) {
        toClass().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isInstanceOf(final Class<?> expected) {
        toClass().isSubtypeOf(expected);
    }

    /**
     * Check if the actual value is NOT the instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isNotInstanceOf(final Class<?> expected) {
        toClass().isNotSubtypeOf(expected);
    }

    /**
     * Check if the string representation of the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isToStringEqualTo(final String expected) {
        checkActualIsNotNull();
        new StringAssertion(getActual().toString(), getMessage()).isEqualTo(expected);
    }

    /**
     * Check if the string representation of the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void toStringContains(final String expected) {
        checkActualIsNotNull();
        new StringAssertion(getActual().toString(), getMessage()).contains(expected);
    }

    /**
     * Check if the actual values hash code is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isHashCodeEqualTo(final int expected) {
        checkActualIsNotNull();
        new IntAssertion(getActual().hashCode(), getMessage()).isEqualTo(expected);
    }

}
