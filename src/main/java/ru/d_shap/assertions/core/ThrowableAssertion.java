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
 * Assertions for the throwable.
 *
 * @author Dmitry Shapovalov
 */
public class ThrowableAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public ThrowableAssertion(final Throwable actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Make assertion about the actual throwable message.
     *
     * @return the assertion.
     */
    public final StringAssertion toMessage() {
        checkActualIsNotNull();
        return new StringAssertion(((Throwable) getActual()).getMessage(), getFailDescription(Messages.Check.ACTUAL_THROWABLE_MESSAGE));
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
     * Make assertion about the actual throwable cause.
     *
     * @return the assertion.
     */
    public final ThrowableAssertion toCause() {
        checkActualIsNotNull();
        return new ThrowableAssertion(((Throwable) getActual()).getCause(), getFailDescription(Messages.Check.ACTUAL_THROWABLE_CAUSE));
    }

    /**
     * Check if the cause of the throwable is instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isCauseInstanceOf(final Class<?> expected) {
        toCause().isInstanceOf(expected);
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
    protected final String asString(final Object value, final boolean actual) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

}
