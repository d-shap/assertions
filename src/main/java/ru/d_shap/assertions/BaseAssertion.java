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
package ru.d_shap.assertions;

/**
 * Base class for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion {

    private final Object _actual;

    private final String _message;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    protected BaseAssertion(final Object actual, final String message) {
        super();
        _actual = actual;
        _message = message;
    }

    /**
     * Get the actual value.
     *
     * @return the actual value.
     */
    protected final Object getActual() {
        return _actual;
    }

    /**
     * Get the assertion message.
     *
     * @return the assertion message.
     */
    protected final String getMessage() {
        return _message;
    }

    /**
     * Check if the actual value is NOT null.
     */
    protected final void checkActualIsNotNull() {
        if (_actual == null) {
            throw createAssertionError(FailMessages.getIsNotNull());
        }
    }

    /**
     * Check if the argument is NOT null.
     *
     * @param argument the argument.
     */
    protected final void checkArgumentIsNotNull(final Object argument) {
        if (argument == null) {
            throw createAssertionError(FailMessages.getArgumentIsNotNull());
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always true.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyTrue(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(FailMessages.getArgumentIsNotEmptyTrue());
        }
    }

    /**
     * Check if the argument is NOT empty because the result is always false.
     *
     * @param isEmpty is the argument empty.
     */
    protected final void checkArgumentIsNotEmptyFalse(final boolean isEmpty) {
        if (isEmpty) {
            throw createAssertionError(FailMessages.getArgumentIsNotEmptyFalse());
        }
    }

    /**
     * Create new assertion error.
     *
     * @param failMessage the fail message.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final String failMessage) {
        return createAssertionError(_message, failMessage);
    }

    static AssertionError createAssertionError(final String assertionMessage, final String failMessage) {
        String fullMessage = getAssertionMessagePart(assertionMessage);
        if (failMessage != null && !"".equals(failMessage)) {
            if (!"".equals(fullMessage)) {
                fullMessage += " ";
            }
            fullMessage += failMessage;
        }
        return new AssertionError(fullMessage);
    }

    /**
     * Create new assertion error.
     *
     * @param throwable cause of the failure.
     * @return the assertion error.
     */
    protected final AssertionError createAssertionError(final Throwable throwable) {
        String fullMessage = getAssertionMessagePart(_message);
        if ("".equals(fullMessage)) {
            if (throwable == null) {
                return new AssertionError();
            } else {
                return new AssertionError(throwable);
            }
        } else {
            return new AssertionError(fullMessage, throwable);
        }
    }

    private static String getAssertionMessagePart(final String assertionMessage) {
        if (assertionMessage == null || "".equals(assertionMessage)) {
            return "";
        } else {
            if (assertionMessage.endsWith(".")) {
                return assertionMessage;
            } else {
                return assertionMessage + ".";
            }
        }
    }

    /**
     * Get the string representation of the actual value.
     *
     * @return the string representation of the actual value.
     */
    protected final String actualAsString() {
        return asString(_actual);
    }

    /**
     * Get the string representation of the value.
     *
     * @param value the value.
     * @return the string representation of the value.
     */
    protected abstract String asString(Object value);

}
