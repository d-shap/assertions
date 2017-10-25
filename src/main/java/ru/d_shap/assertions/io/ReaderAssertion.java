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

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.array.CharArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the reader.
 *
 * @author Dmitry Shapovalov
 */
public class ReaderAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public ReaderAssertion(final Reader actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value does not contain any more chars.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        new IntAssertion(readActual(), getFailDescription(Messages.Check.ACTUAL_READER_READ)).isLessThanOrEqualTo(-1);
    }

    private int readActual() {
        try {
            Reader actual = (Reader) getActual();
            return actual.read();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Make assertion about the chars read from the actual.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray() {
        checkActualIsNotNull();
        try {
            Reader actual = (Reader) getActual();
            StringWriter writer = new StringWriter();
            while (true) {
                int read = actual.read();
                if (read < 0) {
                    break;
                }
                writer.write(read);
            }
            return new CharArrayAssertion(writer.toString().toCharArray(), getFailDescription(Messages.Check.ACTUAL_READER_READ));
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Make assertion about the chars read from the actual.
     *
     * @param length the number of chars to read from the actual.
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray(final int length) {
        checkActualIsNotNull();
        checkArgumentIsValid(length > 0);
        try {
            Reader actual = (Reader) getActual();
            StringWriter writer = new StringWriter(length);
            int count = 0;
            while (count < length) {
                int read = actual.read();
                if (read < 0) {
                    break;
                }
                writer.write(read);
                count++;
            }
            return new CharArrayAssertion(writer.toString().toCharArray(), getFailDescription(Messages.Check.ACTUAL_READER_READ));
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
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        char[] expectedChars = ValueConverter.toCharArray(expected);
        toCharArray().containsExactlyInOrder(expectedChars);
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

}
