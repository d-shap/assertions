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
public class BaseAssertion {

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
     * Fail a test.
     *
     * @param failMessage the fail message.
     */
    protected final void fail(final String failMessage) {
        String fullMessage = getAssertionMessagePart();
        if (failMessage != null && !"".equals(failMessage)) {
            fullMessage += failMessage;
        }
        throw new AssertionError(fullMessage);
    }

    private String getAssertionMessagePart() {
        if (_message == null || "".equals(_message)) {
            return "";
        } else {
            if (_message.endsWith(".")) {
                return _message + " ";
            } else {
                return _message + ". ";
            }
        }
    }

}
