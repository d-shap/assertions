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
package ru.d_shap.assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * Fail description.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescription {

    private final List<String> _messages;

    private boolean _actualDefined;

    private String _actual;

    private boolean _expectedDefined;

    private String _expected;

    private Throwable _throwable;

    /**
     * Create new object.
     */
    FailDescription() {
        super();
        _messages = new ArrayList<>();
        _actualDefined = false;
        _actual = null;
        _expectedDefined = false;
        _expected = null;
        _throwable = null;
    }

    /**
     * Create new object.
     *
     * @param message the message.
     */
    FailDescription(final String message) {
        this();
        addMessage(message, true);
    }

    /**
     * Create new object.
     *
     * @param failDescription the fail description.
     */
    FailDescription(final FailDescription failDescription) {
        this();
        if (failDescription != null) {
            _messages.addAll(failDescription._messages);
        }
    }

    /**
     * Create new object.
     *
     * @param failDescription the fail description.
     * @param message         the message.
     */
    FailDescription(final FailDescription failDescription, final String message) {
        this(failDescription);
        addMessage(message, true);
    }

    private void addMessage(final String message, final boolean checkLastSymbol) {
        if (message != null && !"".equals(message)) {
            if (checkLastSymbol) {
                if (message.endsWith(".") || message.endsWith("?") || message.endsWith("!")) {
                    _messages.add(message);
                } else {
                    _messages.add(message + ".");
                }
            } else {
                _messages.add(message);
            }
        }
    }

    /**
     * Add the actual value of the assertion to the fail description.
     *
     * @param assertion the assertion.
     * @return current object for the chain call.
     */
    FailDescription addActual(final BaseAssertion assertion) {
        _actualDefined = true;
        Object actual = assertion.getActual();
        String actualStr;
        if (actual == null) {
            actualStr = null;
        } else {
            actualStr = assertion.asString(actual);
        }
        _actual = "<" + actualStr + ">";
        return this;
    }

    /**
     * Add the expected value of the assertion to the fail description.
     *
     * @param assertion the assertion.
     * @param expected  the expected value of the assertion.
     * @return current object for the chain call.
     */
    FailDescription addExpected(final BaseAssertion assertion, final Object expected) {
        _expectedDefined = true;
        String expectedStr;
        if (expected == null) {
            expectedStr = null;
        } else {
            expectedStr = assertion.asString(expected);
        }
        _expected = "<" + expectedStr + ">";
        return this;
    }

    /**
     * Add the expected value range of the assertion to the fail description.
     *
     * @param assertion    the assertion.
     * @param expectedFrom the lower bound of the expected value range of the assertion.
     * @param expectedTo   the upper bound of the expected value range of the assertion.
     * @return current object for the chain call.
     */
    FailDescription addExpected(final BaseAssertion assertion, final Object expectedFrom, final Object expectedTo) {
        _expectedDefined = true;
        String expectedFromStr;
        if (expectedFrom == null) {
            expectedFromStr = null;
        } else {
            expectedFromStr = assertion.asString(expectedFrom);
        }
        String expectedToStr;
        if (expectedTo == null) {
            expectedToStr = null;
        } else {
            expectedToStr = assertion.asString(expectedTo);
        }
        _expected = "<" + expectedFromStr + ":" + expectedToStr + ">";
        return this;
    }

    /**
     * Add the throwabe to the fail description.
     *
     * @param throwable the throwabe.
     * @return current object for the chain call.
     */
    FailDescription addThrowable(final Throwable throwable) {
        _throwable = throwable;
        return this;
    }

    /**
     * Create the assertion error based on the fail description.
     *
     * @return the assertion error.
     */
    AssertionError createAssertionError() {
        boolean messageAdded = addValuesMessage();
        String fullMessage = getFullMessage();
        removeLastMessage(messageAdded);
        return new AssertionError(fullMessage, _throwable);
    }

    private boolean addValuesMessage() {
        if (_actualDefined) {
            if (_expectedDefined) {
                addMessage("Expected:" + _expected + " but was:" + _actual, false);
                return true;
            } else {
                addMessage("Actual:" + _actual, false);
                return true;
            }
        } else {
            if (_expectedDefined) {
                addMessage("Expected:" + _expected, false);
                return true;
            } else {
                return false;
            }
        }
    }

    private String getFullMessage() {
        StringBuilder fullMessage = new StringBuilder();
        for (int i = 0; i < _messages.size(); i++) {
            if (i > 0) {
                fullMessage.append(" ");
            }
            fullMessage.append(_messages.get(i));
        }
        return fullMessage.toString();
    }

    private void removeLastMessage(final boolean messageAdded) {
        if (messageAdded) {
            _messages.remove(_messages.size() - 1);
        }
    }

}
