///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
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
import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Fail description entry.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionEntry {

    private final MessageFormat _messageFormat;

    private final boolean _isSimpleMessage;

    private final Object[] _arguments;

    private final boolean _checkLastSymbol;

    FailDescriptionEntry(final String message, final Object[] arguments, final boolean checkLastSymbol) {
        super();
        _messageFormat = getMessageFormat(message, arguments);
        _isSimpleMessage = Messages.SIMPLE_MESSAGE.equals(message);
        _arguments = arguments;
        _checkLastSymbol = checkLastSymbol;
    }

    private MessageFormat getMessageFormat(final String message, final Object[] arguments) {
        MessageFormat messageFormat;
        int formatLength;
        if (isEmptyString(message)) {
            messageFormat = null;
            formatLength = 0;
        } else {
            messageFormat = new MessageFormat(message);
            Format[] formats = messageFormat.getFormatsByArgumentIndex();
            formatLength = formats.length;
        }
        if (formatLength != arguments.length) {
            throw new ArrayIndexOutOfBoundsException(arguments.length);
        }
        return messageFormat;
    }

    private boolean isEmptyString(final String str) {
        return str == null || "".equals(str);
    }

    void addFormattedMessage(final List<String> formattedMessages) throws ConversionException {
        if (_messageFormat == null) {
            return;
        }
        String[] stringArguments = getStringArguments(_arguments);
        if (_isSimpleMessage && (_arguments[0] == null || isEmptyString(stringArguments[0]))) {
            return;
        }

        String formattedMessage = _messageFormat.format(stringArguments);
        if (_checkLastSymbol && !formattedMessage.endsWith(".") && !formattedMessage.endsWith("?") && !formattedMessage.endsWith("!")) {
            formattedMessage += ".";
        }
        formattedMessages.add(formattedMessage);
    }

    private String[] getStringArguments(final Object[] arguments) throws ConversionException {
        String[] stringArguments = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            stringArguments[i] = AsStringConverter.asString(arguments[i]);
        }
        return stringArguments;
    }

}
