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

import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the throwable.
 *
 * @author Dmitry Shapovalov
 */
public class ThrowableAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public ThrowableAssertion(final Throwable actual, final String message) {
        super(actual, message);
    }

    /**
     * Make assertion about the message of the throwable.
     *
     * @return the assertion.
     */
    public final StringAssertion toMessage() {
        checkActualIsNotNull();
        return new StringAssertion(((Throwable) getActual()).getMessage(), getMessage());
    }

    /**
     * Check if the message of the throwable has the expected value.
     *
     * @param message the expected value.
     */
    public final void hasMessage(final String message) {
        toMessage().isEqualTo(message);
    }

    /**
     * Make assertion about the cause of the throwable.
     *
     * @return the assertion.
     */
    public final ThrowableAssertion toCause() {
        checkActualIsNotNull();
        return new ThrowableAssertion(((Throwable) getActual()).getCause(), getMessage());
    }

    /**
     * Check if the cause of the throwable is instance of the expected class.
     *
     * @param clazz the expected class.
     */
    public final void isCauseInstanceOf(final Class<?> clazz) {
        toCause().isInstanceOf(clazz);
    }

    /**
     * Check if the message of the cause of the throwable has the expected value.
     *
     * @param message the expected value.
     */
    public final void hasCauseMessage(final String message) {
        toCause().hasMessage(message);
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
