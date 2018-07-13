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

    private static final String MESSAGE_SEPARATOR = "\n\t";

    private final List<FailDescriptionEntry> _failDescriptionEntries;

    FailDescription() {
        super();
        _failDescriptionEntries = new ArrayList<>();
    }

    FailDescription(final String message) {
        this();
        _failDescriptionEntries.add(new FailDescriptionEntry(message, new Object[0], true));
    }

    FailDescription(final String message, final Object[] arguments) {
        this();
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
    }

    FailDescription(final FailDescriptionEntry failDescriptionEntry) {
        this();
        _failDescriptionEntries.add(failDescriptionEntry);
    }

    FailDescription(final FailDescription failDescription) {
        this();
        if (failDescription != null) {
            _failDescriptionEntries.addAll(failDescription._failDescriptionEntries);
        }
    }

    FailDescription(final FailDescription failDescription, final String message) {
        this(failDescription);
        _failDescriptionEntries.add(new FailDescriptionEntry(message, new Object[0], true));
    }

    FailDescription(final FailDescription failDescription, final String message, final Object[] arguments) {
        this(failDescription);
        _failDescriptionEntries.add(new FailDescriptionEntry(message, arguments, true));
    }

    FailDescription(final FailDescription failDescription, final FailDescriptionEntry failDescriptionEntry) {
        this(failDescription);
        _failDescriptionEntries.add(failDescriptionEntry);
    }

    String getFullMessage() {
        List<String> formattedMessages = new ArrayList<>();
        for (FailDescriptionEntry failDescriptionEntry : _failDescriptionEntries) {
            failDescriptionEntry.addFormattedMessage(formattedMessages);
        }

        StringBuilder fullMessage = new StringBuilder();
        for (int i = 0; i < formattedMessages.size(); i++) {
            if (i > 0) {
                fullMessage.append(MESSAGE_SEPARATOR);
            }
            fullMessage.append(formattedMessages.get(i));
        }
        return fullMessage.toString();
    }

}
