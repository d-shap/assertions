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

    private static final String VALUE_ACTUAL = "Actual:{0}";

    private static final String VALUE_EXPECTED = "Expected:{0}";

    private static final String VALUE_ACTUAL_AND_EXPECTED = "Expected:{1} but was:{0}";

    private static final String MESSAGE_SEPARATOR = "\n\t";

    private final List<String> _messages;

    /**
     * Create new object.
     */
    FailDescription() {
        super();
        _messages = new ArrayList<>();
    }

    /**
     * Create new object.
     *
     * @param message   the message.
     * @param arguments the message arguments.
     */
    FailDescription(final String message, final Object... arguments) {
        this();
        addMessage(message, true, arguments);
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
     * @param arguments       the message arguments.
     */
    FailDescription(final FailDescription failDescription, final String message, final Object... arguments) {
        this(failDescription);
        addMessage(message, true, arguments);
    }

    private void addMessage(final String message, final boolean checkLastSymbol, final Object... arguments) {
        if (message == null || "".equals(message)) {
            return;
        }
        String[] argumentStrArray = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            argumentStrArray[i] = String.valueOf(arguments[i]);
        }
        String formattedMessage = MessageFormat.format(message, (Object[]) argumentStrArray);
        if (checkLastSymbol && !formattedMessage.endsWith(".") && !formattedMessage.endsWith("?") && !formattedMessage.endsWith("!")) {
            formattedMessage += ".";
        }
        _messages.add(formattedMessage);
    }

    String getFullMessage() {
        StringBuilder fullMessage = new StringBuilder();
        for (int i = 0; i < _messages.size(); i++) {
            if (i > 0) {
                fullMessage.append(MESSAGE_SEPARATOR);
            }
            fullMessage.append(_messages.get(i));
        }
        return fullMessage.toString();
    }

    AssertionError createAssertionError() {
        FailDescription failDescription = new FailDescription(this);
        return new AssertionError(failDescription.getFullMessage());
    }

    AssertionError createAssertionError(final String message) {
        FailDescription failDescription = new FailDescription(this, message);
        return new AssertionError(failDescription.getFullMessage());
    }

    AssertionError createAssertionError(final Object expected, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final String message, final Object expected, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final Object expectedFrom, final Object expectedTo, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final String message, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final Throwable throwable) {
        FailDescription failDescription = new FailDescription(this);
        return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
    }

    AssertionError createAssertionError(final String message, final Throwable throwable) {
        FailDescription failDescription = new FailDescription(this, message);
        return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
    }

    AssertionError createAssertionError(final Object expected, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final String message, final Object expected, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final Object expectedFrom, final Object expectedTo, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionError(final String message, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_EXPECTED, false, getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL, false, getValueMessage(actual, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL, false, getValueMessage(actual, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Object expected, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Object expected, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage());
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL, false, getValueMessage(actual, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL, false, getValueMessage(actual, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Object expected, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Object expected, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expected, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final Object actual, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    AssertionError createAssertionErrorWithActual(final String message, final Object actual, final Object expectedFrom, final Object expectedTo, final Class<?> valueClass, final Throwable throwable) {
        try {
            FailDescription failDescription = new FailDescription(this, message);
            failDescription.addMessage(VALUE_ACTUAL_AND_EXPECTED, false, getValueMessage(actual, valueClass), getValueMessage(expectedFrom, expectedTo, valueClass));
            return new AssertionError(failDescription.getFullMessage(), getThrowable(throwable));
        } catch (ConvertionException ex) {
            return new AssertionError(getFullMessage(), getThrowable(ex));
        }
    }

    private String getValueMessage(final Object object, final Class<?> valueClass) throws ConvertionException {
        String objectStr = AsStringConverter.asString(object, valueClass);
        return "<" + objectStr + ">";
    }

    private String getValueMessage(final Object objectFrom, final Object objectTo, final Class<?> valueClass) throws ConvertionException {
        String objectFromStr = AsStringConverter.asString(objectFrom, valueClass);
        String objectToStr = AsStringConverter.asString(objectTo, valueClass);
        return "<" + objectFromStr + ":" + objectToStr + ">";
    }

    private Throwable getThrowable(final Throwable throwable) {
        if (throwable instanceof ConvertionException) {
            return throwable.getCause();
        } else {
            return throwable;
        }
    }

}
