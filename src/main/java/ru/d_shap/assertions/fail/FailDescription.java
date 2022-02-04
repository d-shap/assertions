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

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.Messages;

/**
 * Fail description.
 *
 * @author Dmitry Shapovalov
 */
public final class FailDescription {

    private final List<FailDescriptionEntry> _failDescriptionEntries;

    /**
     * Create new object.
     */
    public FailDescription() {
        super();
        _failDescriptionEntries = new ArrayList<>();
    }

    /**
     * Create new object.
     *
     * @param message   the message template.
     * @param arguments the message arguments.
     */
    public FailDescription(final String message, final Object... arguments) {
        this();
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
    }

    /**
     * Create new object.
     *
     * @param failDescriptionEntry the fail description entry.
     */
    public FailDescription(final FailDescriptionEntry failDescriptionEntry) {
        this();
        _failDescriptionEntries.add(failDescriptionEntry);
    }

    /**
     * Create new object.
     *
     * @param failDescription the base fail description.
     */
    public FailDescription(final FailDescription failDescription) {
        this();
        if (failDescription != null) {
            _failDescriptionEntries.addAll(failDescription._failDescriptionEntries);
        }
    }

    /**
     * Create new object.
     *
     * @param failDescription the base fail description.
     * @param message         the message template.
     * @param arguments       the message arguments.
     */
    public FailDescription(final FailDescription failDescription, final String message, final Object... arguments) {
        this(failDescription);
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
    }

    /**
     * Create new object.
     *
     * @param failDescription      the base fail description.
     * @param failDescriptionEntry the fail description entry.
     */
    public FailDescription(final FailDescription failDescription, final FailDescriptionEntry failDescriptionEntry) {
        this(failDescription);
        _failDescriptionEntries.add(failDescriptionEntry);
    }

    /**
     * Get the full fail message.
     *
     * @return the full fail message.
     */
    public String getFullMessage() {
        List<String> formattedMessages = new ArrayList<>();
        for (FailDescriptionEntry failDescriptionEntry : _failDescriptionEntries) {
            failDescriptionEntry.addFormattedMessage(formattedMessages);
        }

        StringBuilder fullMessage = new StringBuilder();
        for (int i = 0; i < formattedMessages.size(); i++) {
            if (i > 0) {
                fullMessage.append(Messages.SEPARATOR);
            }
            fullMessage.append(formattedMessages.get(i));
        }
        return fullMessage.toString();
    }

}
