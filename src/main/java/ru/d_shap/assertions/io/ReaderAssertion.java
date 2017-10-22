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
        new IntAssertion(actualAsInt(), getFailDescription(Messages.Check.ACTUAL_READER_CHAR_READ)).isLessThanOrEqualTo(-1);
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
        new CharArrayAssertion(actualAsCharArray(expected.length), getFailDescription()).containsExactlyInOrder(expected);
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
        new CharArrayAssertion(actualAsCharArray(expected.length), getFailDescription()).containsExactlyInOrder(expected);
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
        new CharArrayAssertion(actualAsCharArray(expectedChars.length), getFailDescription()).containsExactlyInOrder(expectedChars);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final char... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new CharArrayAssertion(actualAsCharArray(expected.length + 1), getFailDescription()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new CharArrayAssertion(actualAsCharArray(expected.length + 1), getFailDescription()).containsExactlyInOrder(expected);
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
        checkArgumentIsNotEmptyTrue(expectedChars.length == 0);
        new CharArrayAssertion(actualAsCharArray(expectedChars.length + 1), getFailDescription()).containsExactlyInOrder(expectedChars);
    }

    private int actualAsInt() {
        try {
            Reader actual = (Reader) getActual();
            return actual.read();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    private char[] actualAsCharArray(final int length) {
        try {
            Reader actual = (Reader) getActual();
            StringWriter writer = new StringWriter(length);
            int count = 0;
            while (true) {
                int read = actual.read();
                if (read < 0) {
                    break;
                }
                writer.write(read);
                count++;
                if (count >= length) {
                    break;
                }
            }
            return writer.toString().toCharArray();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        return null;
    }

}
