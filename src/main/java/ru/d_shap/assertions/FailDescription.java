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
public final class FailDescription {

    private final List<String> _messages;

    private String _actual;

    private String _expected;

    private Throwable _throwable;

    FailDescription() {
        super();
        _messages = new ArrayList<>();
        _actual = null;
        _expected = null;
        _throwable = null;
    }

    FailDescription(final String message) {
        super();
        _messages = new ArrayList<>();
        addMessage(message);
        _actual = null;
        _expected = null;
        _throwable = null;
    }

    /**
     * Add the message to the fail description.
     *
     * @param message the message.
     * @return current object for the chain call.
     */
    public FailDescription addMessage(final String message) {
        if (message != null && !"".equals(message)) {
            if (message.endsWith(".") || message.endsWith("?") || message.endsWith("!")) {
                _messages.add(message);
            } else {
                _messages.add(message + ".");
            }
        }
        return this;
    }

    /**
     * Add the actual value of the assertion to the fail description.
     *
     * @param assertion the assertion to get the actual value.
     * @return current object for the chain call.
     */
    public FailDescription addActual(final BaseAssertion assertion) {
        if (assertion.getActual() == null) {
            _actual = null;
        } else {
            _actual = "<" + assertion.actualAsString() + ">";
        }
        return this;
    }

    /**
     * Add the expected value of the assertion to the fail description.
     *
     * @param assertion the assertion.
     * @param expected  the expected value of the assertion.
     * @return current object for the chain call.
     */
    public FailDescription addExpected(final BaseAssertion assertion, final Object expected) {
        if (expected == null) {
            _expected = null;
        } else {
            _expected = "<" + assertion.asString(expected) + ">";
        }
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
    public FailDescription addExpected(final BaseAssertion assertion, final Object expectedFrom, final Object expectedTo) {
        if (expectedFrom == null || expectedTo == null) {
            _expected = null;
        } else {
            _expected = "<" + assertion.asString(expectedFrom) + ":" + assertion.asString(expectedTo) + ">";
        }
        return this;
    }

    /**
     * Add the throwabe to the fail description.
     *
     * @param message   the message.
     * @param throwable the throwabe.
     * @return current object for the chain call.
     */
    public FailDescription addThrowable(final String message, final Throwable throwable) {
        addMessage(message);
        _throwable = throwable;
        return this;
    }

    /**
     * Add the throwabe to the fail description.
     *
     * @param throwable the throwabe.
     * @return current object for the chain call.
     */
    public FailDescription addThrowable(final Throwable throwable) {
        addMessage(throwable.toString());
        _throwable = throwable;
        return this;
    }

    /**
     * Create the assertion error based on this fail description.
     *
     * @return the assertion error.
     */
    public AssertionError createAssertionError() {
        addValuesMessage();
        String fullMessage = getFullMessage();
        if (_throwable == null) {
            return new AssertionError(fullMessage);
        } else {
            return new AssertionError(fullMessage, _throwable);
        }
    }

    private void addValuesMessage() {
        if (_actual == null) {
            if (_expected != null) {
                addMessage("Expected:" + _expected);
            }
        } else {
            if (_expected == null) {
                addMessage("Actual:" + _actual);
            } else {
                addMessage("Expected:" + _expected + " but was:" + _actual);
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

}
