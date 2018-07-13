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
import java.util.List;

/**
 * Fail description entry.
 *
 * @author Dmitry Shapovalov
 */
final class FailDescriptionEntry {

    private final String _message;

    private final Object[] _arguments;

    private final boolean _checkLastSymbol;

    FailDescriptionEntry(final String message, final Object[] arguments, final boolean checkLastSymbol) {
        super();
        _message = message;
        _arguments = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            _arguments[i] = String.valueOf(arguments[i]);
        }
        _checkLastSymbol = checkLastSymbol;
    }

    void addFormattedMessage(final List<String> formattedMessages) {
        if (_message == null || "".equals(_message)) {
            return;
        }
        String formattedMessage = MessageFormat.format(_message, _arguments);
        if (_checkLastSymbol && !formattedMessage.endsWith(".") && !formattedMessage.endsWith("?") && !formattedMessage.endsWith("!")) {
            formattedMessage += ".";
        }
        formattedMessages.add(formattedMessage);
    }

}
