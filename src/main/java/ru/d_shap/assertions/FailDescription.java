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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Fail description.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescription {

    private static final String VALUE_ACTUAL_AND_EXPECTED = "Expected:{1} but was:{0}";

    private static final String VALUE_ACTUAL = "Actual:{0}";

    private static final String VALUE_EXPECTED = "Expected:{0}";

    private static final String MESSAGE_SEPARATOR = "\n\t";

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
        addMessage(message, true, (Object[]) null);
    }

    /**
     * Create new object.
     *
     * @param failDescription the fail description.
     */
    FailDescription(final FailDescription failDescription) {
        this();
        _messages.addAll(failDescription._messages);
    }

    /**
     * Create new object.
     *
     * @param failDescription the fail description.
     * @param message         the message.
     */
    FailDescription(final FailDescription failDescription, final String message) {
        this(failDescription);
        addMessage(message, true, (Object[]) null);
    }

    /**
     * Create new object.
     *
     * @param failDescription the fail description.
     * @param message         the message.
     * @param arguments       the message arguments.
     */
    FailDescription(final FailDescription failDescription, final String message, final Object... arguments) {
        this(failDescription);
        addMessage(message, true, arguments);
    }

    private void addMessage(final String message, final boolean checkLastSymbol, final Object... arguments) {
        String fullMessage = getFullMessage(message, checkLastSymbol, arguments);
        if (!"".equals(fullMessage)) {
            _messages.add(fullMessage);
        }
    }

    static String getFullMessage(final String message) {
        return getFullMessage(message, true, (Object[]) null);
    }

    private static String getFullMessage(final String message, final boolean checkLastSymbol, final Object... arguments) {
        if (message == null || "".equals(message)) {
            return "";
        }

        String[] argumentStrArray;
        if (arguments == null) {
            argumentStrArray = new String[0];
        } else {
            argumentStrArray = new String[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                argumentStrArray[i] = String.valueOf(arguments[i]);
            }
        }
        String fullMessage = MessageFormat.format(message, (Object[]) argumentStrArray);

        if (checkLastSymbol) {
            if (fullMessage.endsWith(".") || fullMessage.endsWith("?") || fullMessage.endsWith("!")) {
                return fullMessage;
            } else {
                return fullMessage + ".";
            }
        } else {
            return fullMessage;
        }
    }

    /**
     * Add the actual value of the assertion to the fail description.
     *
     * @param assertion the assertion.
     * @return current object for the chain call.
     */
    FailDescription addActual(final BaseAssertion<?> assertion) {
        _actualDefined = true;
        Object actual = assertion.getActual();
        String actualStr;
        if (actual == null) {
            actualStr = null;
        } else {
            actualStr = asString(actual);
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
    FailDescription addExpected(final BaseAssertion<?> assertion, final Object expected) {
        _expectedDefined = true;
        String expectedStr;
        if (expected == null) {
            expectedStr = null;
        } else {
            expectedStr = asString(expected);
        }
        _expected = "<" + expectedStr + ">";
        return this;
    }

    /**
     * Add the expected value range of the assertion to the fail description.
     *
     * @param assertion    the assertion.
     * @param expectedFrom the lower (inclusive) bound of the expected value range of the assertion.
     * @param expectedTo   the upper (exclusive) bound of the expected value range of the assertion.
     * @return current object for the chain call.
     */
    FailDescription addExpected(final BaseAssertion<?> assertion, final Object expectedFrom, final Object expectedTo) {
        _expectedDefined = true;
        String expectedFromStr;
        if (expectedFrom == null) {
            expectedFromStr = null;
        } else {
            expectedFromStr = asString(expectedFrom);
        }
        String expectedToStr;
        if (expectedTo == null) {
            expectedToStr = null;
        } else {
            expectedToStr = asString(expectedTo);
        }
        _expected = "<" + expectedFromStr + ":" + expectedToStr + ">";
        return this;
    }

    private String asString(final Object value) {
        return AsStringConverter.asString(value);
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
        String assertionErrorMessage = getAssertionErrorMessage();
        removeLastMessage(messageAdded);
        return new AssertionError(assertionErrorMessage, _throwable);
    }

    private boolean addValuesMessage() {
        if (_actualDefined) {
            if (_expectedDefined) {
                addMessage(VALUE_ACTUAL_AND_EXPECTED, false, _actual, _expected);
                return true;
            } else {
                addMessage(VALUE_ACTUAL, false, _actual);
                return true;
            }
        } else {
            if (_expectedDefined) {
                addMessage(VALUE_EXPECTED, false, _expected);
                return true;
            } else {
                return false;
            }
        }
    }

    private String getAssertionErrorMessage() {
        StringBuilder assertionErrorMessage = new StringBuilder();
        for (int i = 0; i < _messages.size(); i++) {
            if (i > 0) {
                assertionErrorMessage.append(MESSAGE_SEPARATOR);
            }
            assertionErrorMessage.append(_messages.get(i));
        }
        return assertionErrorMessage.toString();
    }

    private void removeLastMessage(final boolean messageAdded) {
        if (messageAdded) {
            _messages.remove(_messages.size() - 1);
        }
    }

}
