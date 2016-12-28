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
 * Assertions for the object.
 *
 * @author Dmitry Shapovalov
 */
public class ReferenceAssertion extends BaseAssertion {

    private final Object _actual;

    /**
     * Create new object.
     *
     * @param actual  the actual object.
     * @param message the assertion message.
     */
    protected ReferenceAssertion(final Object actual, final String message) {
        super(message);
        _actual = actual;
    }

    /**
     * Get the actual object.
     *
     * @return the actual object.
     */
    protected final Object getActual() {
        return _actual;
    }

    /**
     * Check if the actual object is null.
     */
    public final void isNull() {
        if (_actual != null) {
            fail(FailMessages.getNull(String.valueOf(_actual)));
        }
    }

    /**
     * Check if the actual object is NOT null.
     */
    public final void isNotNull() {
        if (_actual == null) {
            fail(FailMessages.getNotNull());
        }
    }

    /**
     * Check is the actual object is the same as the expected object.
     *
     * @param expected the expected object.
     */
    public final void isSameAs(final Object expected) {
        if (_actual != expected) {
            fail(FailMessages.getSame(String.valueOf(_actual), String.valueOf(expected)));
        }
    }

    /**
     * Check is the actual object is NOT the same as the expected object.
     *
     * @param expected the expected object.
     */
    public final void isNotSameAs(final Object expected) {
        if (_actual == expected) {
            fail(FailMessages.getDifferent(String.valueOf(_actual)));
        }
    }

    /**
     * Make assertion about the objects class.
     *
     * @return assertion.
     */
    public final ClassAssertion toClass() {
        return new ClassAssertion(getClass(), getMessage());
    }

}
