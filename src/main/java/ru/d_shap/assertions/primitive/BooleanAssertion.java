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
package ru.d_shap.assertions.primitive;

import ru.d_shap.assertions.BaseAssertion;

/**
 * Assertions for the boolean primitive value.
 *
 * @author Dmitry Shapovalov
 */
public class BooleanAssertion extends BaseAssertion {

    private final boolean _actual;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the error message.
     */
    public BooleanAssertion(final boolean actual, final String message) {
        super(message);
        _actual = actual;
    }

    /**
     * Check if the actual value is true.
     */
    public final void isTrue() {
        if (!_actual) {
            fail(null);
        }
    }

    /**
     * Check if the actual value is false.
     */
    public final void isFalse() {
        if (_actual) {
            fail(null);
        }
    }

}
