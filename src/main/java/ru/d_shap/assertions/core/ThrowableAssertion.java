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

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the throwable.
 *
 * @author Dmitry Shapovalov
 */
public class ThrowableAssertion extends ReferenceAssertion<Throwable> {

    /**
     * Create new object.
     */
    public ThrowableAssertion() {
        super();
    }

    @Override
    protected final Class<Throwable> getActualValueClass() {
        return Throwable.class;
    }

    /**
     * Make assertion about the actual throwable message.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toMessage() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getMessage(), Messages.Check.ACTUAL_VALUE_MESSAGE);
    }

    /**
     * Check if the message of the throwable has the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasMessage(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toMessage().isEqualTo(expected);
    }

    /**
     * Check if the message of the throwable matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void messageMatches(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toMessage().matches(expected);
    }

    /**
     * Make assertion about the actual throwable cause.
     *
     * @return the assertion.
     */
    public final ThrowableAssertion toCause() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.throwableAssertion(), getActual().getCause(), Messages.Check.ACTUAL_VALUE_CAUSE);
    }

    /**
     * Check if the cause of the throwable is instance of the expected class.
     *
     * @param expected the expected class.
     */
    public final void isCauseInstanceOf(final Class<?> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toCause().isInstanceOf(expected);
    }

    /**
     * Check if the message of the cause of the throwable has the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasCauseMessage(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toCause().hasMessage(expected);
    }

    /**
     * Check if the message of the cause of the throwable matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void causeMessageMatches(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toCause().messageMatches(expected);
    }

}
