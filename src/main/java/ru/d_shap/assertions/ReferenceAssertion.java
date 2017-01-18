///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

/**
 * Base class for all reference type assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class ReferenceAssertion extends BaseAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual object.
     * @param message the assertion message.
     */
    protected ReferenceAssertion(final Object actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual object is null.
     */
    public final void isNull() {
        if (getActual() != null) {
            throw createAssertionError(FailMessages.getIsNull(actualAsString()));
        }
    }

    /**
     * Check if the actual object is NOT null.
     */
    public final void isNotNull() {
        if (getActual() == null) {
            throw createAssertionError(FailMessages.getIsNotNull());
        }
    }

    /**
     * Check is the actual object is the same as the expected object.
     *
     * @param expected the expected object.
     */
    public final void isSameAs(final Object expected) {
        if (getActual() != expected) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check is the actual object is NOT the same as the expected object.
     *
     * @param expected the expected object.
     */
    public final void isNotSameAs(final Object expected) {
        if (getActual() == expected) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Make assertion about the objects class.
     *
     * @return the assertion.
     */
    public final ClassAssertion toClass() {
        return new ClassAssertion(getActual().getClass(), getMessage());
    }

    /**
     * Check if the actual object is instance of the expected class.
     *
     * @param clazz the expected class.
     */
    public final void isInstanceOf(final Class<?> clazz) {
        toClass().isSubtypeOf(clazz);
    }

}
