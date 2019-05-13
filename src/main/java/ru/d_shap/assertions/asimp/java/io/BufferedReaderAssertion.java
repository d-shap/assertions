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
package ru.d_shap.assertions.asimp.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.CharArrayAssertion;
import ru.d_shap.assertions.asimp.array.ObjectArrayAssertion;
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
        createReaderAssertion().isCompleted();
    }

    /**
     * Check if the actual value contains more chars.
     */
    public final void isNotCompleted() {
        createReaderAssertion().isNotCompleted();
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray() {
        return createReaderAssertion().toCharArray();
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param count the number of chars to read from the actual.
     *
     * @return the assertion.
     */
    public final CharArrayAssertion toCharArray(final int count) {
        return createReaderAssertion().toCharArray(count);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toCharArray(final Matcher<Character[]> matcher) {
        createReaderAssertion().toCharArray(matcher);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     * @param count   the number of chars to read from the actual.
     */
    public final void toCharArray(final int count, final Matcher<Character[]> matcher) {
        createReaderAssertion().toCharArray(count, matcher);
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final ObjectArrayAssertion<String> toStringArray() {
        checkActualIsNotNull();
        String[] nextStrings = convertValue(getActual(), null, String[].class, 0);
        return initializeAssertion(Raw.<String>objectArrayAssertion(), nextStrings, Messages.Check.LINES_ALL);
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @param count the number of lines to read from the actual.
     *
     * @return the assertion.
     */
    public final ObjectArrayAssertion<String> toStringArray(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        String[] nextStrings = convertValue(getActual(), null, String[].class, count);
        return initializeAssertion(Raw.<String>objectArrayAssertion(), nextStrings, Messages.Check.LINES_COUNT, count);
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toStringArray(final Matcher<String[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        String[] nextStrings = convertValue(getActual(), null, String[].class, 0);
        matcherAssertion(nextStrings, matcher, Messages.Check.LINES_ALL);
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     * @param count   the number of lines to read from the actual.
     */
    public final void toStringArray(final int count, final Matcher<String[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        String[] nextStrings = convertValue(getActual(), null, String[].class, count);
        matcherAssertion(nextStrings, matcher, Messages.Check.LINES_COUNT, count);
    }

    /**
     * Check if the actual value's next char is equal to the expected char from the current position.
     *
     * @param expected the expected char.
     */
    public final void isNextCharEqualTo(final int expected) {
        createReaderAssertion().isNextCharEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final char... expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final int... expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     */
    public final void isNextCharsEqualTo(final Iterable<Character> expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final char... expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final int... expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     */
    public final void isAllCharsEqualTo(final Iterable<Character> expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
    }

    /**
     * Check if the actual value's next line is equal to the expected string from the current position.
     *
     * @param expected the expected string.
     */
    public final void isNextLineEqualTo(final String expected) {
        isNextLinesEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected strings from the current position.
     *
     * @param expected the expected strings.
     */
    public final void isNextLinesEqualTo(final String... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toStringArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected strings from the current position.
     *
     * @param expected the expected strings.
     */
    public final void isNextLinesEqualTo(final Iterable<String> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<String> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toStringArray(expectedList.size()).containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains the expected strings from the current position and does not contain any more strings.
     *
     * @param expected the expected strings.
     */
    public final void isAllLinesEqualTo(final String... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toStringArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected strings from the current position and does not contain any more strings.
     *
     * @param expected the expected strings.
     */
    public final void isAllLinesEqualTo(final Iterable<String> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<String> expectedList = convertValue(expected, null, List.class);
        toStringArray().containsExactlyInOrder(expectedList);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final LongAssertion toLength() {
        return createReaderAssertion().toLength();
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLength(final Matcher<Long> matcher) {
        createReaderAssertion().toLength(matcher);
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final long expected) {
        createReaderAssertion().hasLength(expected);
    }

    /**
     * Make assertion about the actual value's lines length.
     *
     * @return the assertion.
     */
    public final LongAssertion toLinesLength() {
        checkActualIsNotNull();
        try {
            long linesLength = getLinesLength();
            return initializeAssertion(Raw.longAssertion(), linesLength, Messages.Check.LINES_LENGTH);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Make assertion about the actual value's lines length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLinesLength(final Matcher<Long> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        try {
            long linesLength = getLinesLength();
            matcherAssertion(linesLength, matcher, Messages.Check.LINES_LENGTH);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    private long getLinesLength() throws IOException {
        String read;
        long length = 0;
        while (true) {
            read = getActual().readLine();
            if (read == null) {
                break;
            }
            length++;
        }
        return length;
    }

    /**
     * Check if the actual value's lines length is equal to the expected lines length.
     *
     * @param expected the expected lines length.
     */
    public final void hasLinesLength(final long expected) {
        toLinesLength().isEqualTo(expected);
    }

    private ReaderAssertion createReaderAssertion() {
        return initializeAssertion(Raw.readerAssertion(), getActual());
    }

}
