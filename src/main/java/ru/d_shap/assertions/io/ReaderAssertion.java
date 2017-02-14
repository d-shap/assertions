///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.ReferenceAssertion;
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
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public ReaderAssertion(final Reader actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value does not contain any more chars.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        new IntAssertion(actualAsInt(), getMessage()).isLessThan(0);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final char... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new CharArrayAssertion(actualAsCharArray(expected.length), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new CharArrayAssertion(actualAsCharArray(expected.length), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final Iterable<Character> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        char[] expectedChars = iterableToArray(expected);
        new CharArrayAssertion(actualAsCharArray(expectedChars.length), getMessage()).containsExactlyInOrder(expectedChars);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final char... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new CharArrayAssertion(actualAsCharArray(expected.length + 1), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new CharArrayAssertion(actualAsCharArray(expected.length + 1), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final Iterable<Character> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        char[] expectedChars = iterableToArray(expected);
        new CharArrayAssertion(actualAsCharArray(expectedChars.length + 1), getMessage()).containsExactlyInOrder(expectedChars);
    }

    private int actualAsInt() {
        try {
            Reader actual = (Reader) getActual();
            return actual.read();
        } catch (IOException ex) {
            throw createAssertionError(ex);
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
            throw createAssertionError(ex);
        }
    }

    private char[] iterableToArray(final Iterable<Character> expected) {
        List<Character> list = new ArrayList<>();
        for (Character value : expected) {
            list.add(value);
        }
        char[] chars = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return chars;
    }

    @Override
    protected final String asString(final Object value) {
        return null;
    }

}
