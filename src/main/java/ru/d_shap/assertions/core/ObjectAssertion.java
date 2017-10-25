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

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the object.
 *
 * @author Dmitry Shapovalov
 */
public class ObjectAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public ObjectAssertion(final Object actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

}
