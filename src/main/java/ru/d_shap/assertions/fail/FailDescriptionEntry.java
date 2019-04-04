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
package ru.d_shap.assertions.fail;

import java.text.Format;
import java.text.MessageFormat;
import java.util.List;

import ru.d_shap.assertions.Messages;

/**
 * Fail description entry.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionEntry {

    private final MessageFormat _messageFormat;

    private final Object[] _arguments;

    private final boolean _checkLastSymbol;

    FailDescriptionEntry(final String message, final Object[] arguments, final boolean checkLastSymbol) {
        super();
        String[] stringArguments = getStringArguments(arguments);
        _messageFormat = getMessageFormat(message, stringArguments);
        _arguments = stringArguments;
        _checkLastSymbol = checkLastSymbol;
    }

    private String[] getStringArguments(final Object[] arguments) {
        String[] stringArguments = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i] == null) {
                stringArguments[i] = null;
            } else {
                stringArguments[i] = String.valueOf(arguments[i]);
            }
        }
        return stringArguments;
    }

    private MessageFormat getMessageFormat(final String message, final String[] stringArguments) {
        if (isEmptyString(message)) {
            return null;
        }
        MessageFormat messageFormat = new MessageFormat(message);
        Format[] formats = messageFormat.getFormatsByArgumentIndex();
        if (formats.length != stringArguments.length) {
            throw new ArrayIndexOutOfBoundsException(stringArguments.length);
        }
        if (Messages.SIMPLE_MESSAGE.equals(message) && isEmptyString(stringArguments[0])) {
            return null;
        } else {
            return messageFormat;
        }
    }

    private boolean isEmptyString(final String str) {
        return str == null || "".equals(str);
    }

    void addFormattedMessage(final List<String> formattedMessages) {
        if (_messageFormat == null) {
            return;
        }
        String formattedMessage = _messageFormat.format(_arguments);
        if (_checkLastSymbol && !formattedMessage.endsWith(".") && !formattedMessage.endsWith("?") && !formattedMessage.endsWith("!")) {
            formattedMessage += ".";
        }
        formattedMessages.add(formattedMessage);
    }

}
