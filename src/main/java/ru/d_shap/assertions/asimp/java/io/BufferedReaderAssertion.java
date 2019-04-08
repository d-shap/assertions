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
package ru.d_shap.assertions.asimp.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.CharArrayAssertion;
import ru.d_shap.assertions.asimp.primitive.LongAssertion;

/**
 * Assertions for the buffered reader.
 *
 * @author Dmitry Shapovalov
 */
public class BufferedReaderAssertion extends ReferenceAssertion<BufferedReader> {

    /**
     * Create new object.
     */
    public BufferedReaderAssertion() {
        super();
    }

    @Override
    protected final Class<BufferedReader> getActualValueClass() {
        return BufferedReader.class;
    }

    /**
     * Check if the actual value does not contain any more chars.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        try {
            int nextChar = readChar();
            if (nextChar >= 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Check if the actual value contains more chars.
     */
    public final void isNotCompleted() {
        checkActualIsNotNull();
        try {
            int nextChar = readChar();
            if (nextChar < 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    private int readChar() throws IOException {
        return getActual().read();
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray() {
        checkActualIsNotNull();
        char[] nextChars = convertValue(getActual(), char[].class);
        return initializeAssertion(Raw.charArrayAssertion(), nextChars, Messages.Check.CHARS_ALL);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param count the number of chars to read from the actual.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        char[] nextChars = convertValue(getActual(), char[].class, count);
        return initializeAssertion(Raw.charArrayAssertion(), nextChars, Messages.Check.CHARS_COUNT, count);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toCharArray(final Matcher<Character[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        char[] nextChars = convertValue(getActual(), char[].class);
        Character[] nextObjects = convertValue(nextChars, Character[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.CHARS_ALL);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     * @param count   the number of chars to read from the actual.
     */
    public final void toCharArray(final int count, final Matcher<Character[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        checkArgumentIsNotNull(matcher);
        char[] nextChars = convertValue(getActual(), char[].class, count);
        Character[] nextObjects = convertValue(nextChars, Character[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.CHARS_COUNT, count);
    }

    /**
     * Check if the actual value's next char is equal to the expected char from the current position.
     *
     * @param expected the expected char.
     */
    public final void isNextCharEqualTo(final int expected) {
        checkActualIsNotNull();
        try {
            int nextChar = readChar();
            initializeAssertion(Raw.intAssertion(), nextChar, Messages.Check.NEXT_CHAR).isEqualTo(expected);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
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
        List<Character> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toCharArray(expectedList.size()).containsExactlyInOrder(expectedList);
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
        List<Character> expectedList = convertValue(expected, List.class);
        toCharArray().containsExactlyInOrder(expectedList);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final LongAssertion toLength() {
        checkActualIsNotNull();
        try {
            return initializeAssertion(Raw.longAssertion(), getLength(), Messages.Check.LENGTH);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLength(final Matcher<Long> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        try {
            matcherAssertion(getLength(), matcher, Messages.Check.LENGTH);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    private long getLength() throws IOException {
        int read;
        long length = 0;
        while (true) {
            read = getActual().read();
            if (read < 0) {
                break;
            }
            length++;
        }
        return length;
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final long expected) {
        toLength().isEqualTo(expected);
    }

}
