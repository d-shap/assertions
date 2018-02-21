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
package ru.d_shap.assertions.io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.array.CharArrayAssertion;

/**
 * Assertions for the reader.
 *
 * @author Dmitry Shapovalov
 */
public class ReaderAssertion extends ReferenceAssertion<Reader> {

    /**
     * Create new object.
     */
    public ReaderAssertion() {
        super();
    }

    @Override
    protected final Class<Reader> getActualValueClass() {
        return Reader.class;
    }

    /**
     * Check if the actual value does not contain any more chars.
     */
    public final void isCompleted() {
        checkInitialized();
        checkActualIsNotNull();
        initializeAssertion(Raw.intAssertion(), readActual(), Messages.Check.ACTUAL_VALUE_CHAR).isLessThan(0);
    }

    /**
     * Check if the actual value contains more chars.
     */
    public final void isNotCompleted() {
        checkInitialized();
        checkActualIsNotNull();
        initializeAssertion(Raw.intAssertion(), readActual(), Messages.Check.ACTUAL_VALUE_CHAR).isGreaterThanOrEqualTo(0);
    }

    private int readActual() {
        try {
            return getActual().read();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray() {
        checkInitialized();
        checkActualIsNotNull();
        try {
            StringWriter writer = new StringWriter();
            while (true) {
                int read = getActual().read();
                if (read < 0) {
                    break;
                }
                writer.write(read);
            }
            return initializeAssertion(Raw.charArrayAssertion(), writer.toString().toCharArray(), Messages.Check.ACTUAL_VALUE_CHARS_ALL);
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param count the number of chars to read from the actual.
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray(final int count) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        try {
            StringWriter writer = new StringWriter(count);
            int readCount = 0;
            while (readCount < count) {
                int read = getActual().read();
                if (read < 0) {
                    break;
                }
                writer.write(read);
                readCount++;
            }
            return initializeAssertion(Raw.charArrayAssertion(), writer.toString().toCharArray(), Messages.Check.ACTUAL_VALUE_CHARS_COUNT, count);
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final char... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toCharArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toCharArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final Iterable<Character> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        char[] expectedChars = ValueConverter.toCharArray(expected);
        checkArgumentIsNotEmptyTrue(expectedChars.length == 0);
        toCharArray(expectedChars.length).containsExactlyInOrder(expectedChars);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final char... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toCharArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toCharArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final Iterable<Character> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        char[] expectedChars = ValueConverter.toCharArray(expected);
        toCharArray().containsExactlyInOrder(expectedChars);
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
