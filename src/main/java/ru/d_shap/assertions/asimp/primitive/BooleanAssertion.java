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
package ru.d_shap.assertions.asimp.primitive;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.asimp.ReferenceAssertion;

/**
 * Assertions for the boolean.
 *
 * @author Dmitry Shapovalov
 */
public class BooleanAssertion extends ReferenceAssertion<Boolean> {

    /**
     * Create new object.
     */
    public BooleanAssertion() {
        super();
    }

    @Override
    protected final Class<Boolean> getActualValueClass() {
        return Boolean.class;
    }

    /**
     * Check if the actual value is true.
     */
    public final void isTrue() {
        checkActualIsNotNull();
        if (!getActual()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_TRUE).build();
        }
    }

    /**
     * Check if the actual value is false.
     */
    public final void isFalse() {
        checkActualIsNotNull();
        if (getActual()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_FALSE).build();
        }
    }

}
