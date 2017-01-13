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

/**
 * Base class for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public abstract class BaseAssertion {

    private final String _message;

    /**
     * Create new object.
     *
     * @param message the assertion message.
     */
    protected BaseAssertion(final String message) {
        super();
        _message = message;
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
            if (throwable == null) {
                return new AssertionError(fullMessage);
            } else {
                return new AssertionError(fullMessage, throwable);
            }
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
     * Get the string representation of the object.
     *
     * @param value the object to get the string representation.
     * @return the string representation of the object.
     */
    protected abstract String asString(Object value);

}
