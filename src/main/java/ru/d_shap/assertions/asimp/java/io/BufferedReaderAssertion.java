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
public final class BufferedReaderAssertion extends ReferenceAssertion<BufferedReader> {

    /**
     * Create new object.
     */
    public BufferedReaderAssertion() {
        super();
    }

    @Override
    protected Class<BufferedReader> getActualValueClass() {
        return BufferedReader.class;
    }

    /**
     * Check if the actual value does not contain any more chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isCompleted() {
        createReaderAssertion().isCompleted();
        return this;
    }

    /**
     * Check if the actual value contains more chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNotCompleted() {
        createReaderAssertion().isNotCompleted();
        return this;
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @return the assertion.
     */
    public CharArrayAssertion toCharArray() {
        return createReaderAssertion().toCharArray();
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param count the number of chars to read from the actual.
     *
     * @return the assertion.
     */
    public CharArrayAssertion toCharArray(final int count) {
        return createReaderAssertion().toCharArray(count);
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toCharArray(final Matcher<? super Character[]> matcher) {
        createReaderAssertion().toCharArray(matcher);
        return this;
    }

    /**
     * Make assertion about the chars read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     * @param count   the number of chars to read from the actual.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toCharArray(final int count, final Matcher<? super Character[]> matcher) {
        createReaderAssertion().toCharArray(count, matcher);
        return this;
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @return the assertion.
     */
    public ObjectArrayAssertion<String> toStringArray() {
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
    public ObjectArrayAssertion<String> toStringArray(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        String[] nextStrings = convertValue(getActual(), null, String[].class, count);
        return initializeAssertion(Raw.<String>objectArrayAssertion(), nextStrings, Messages.Check.LINES_COUNT, count);
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toStringArray(final Matcher<? super String[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        String[] nextStrings = convertValue(getActual(), null, String[].class, 0);
        matcherAssertion(nextStrings, matcher, Messages.Check.LINES_ALL);
        return this;
    }

    /**
     * Make assertion about the lines read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     * @param count   the number of lines to read from the actual.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toStringArray(final int count, final Matcher<? super String[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        String[] nextStrings = convertValue(getActual(), null, String[].class, count);
        matcherAssertion(nextStrings, matcher, Messages.Check.LINES_COUNT, count);
        return this;
    }

    /**
     * Check if the actual value's next char is equal to the expected char from the current position.
     *
     * @param expected the expected char.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextCharEqualTo(final int expected) {
        createReaderAssertion().isNextCharEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextCharsEqualTo(final char... expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextCharsEqualTo(final int... expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextCharsEqualTo(final Iterable<Character> expected) {
        createReaderAssertion().isNextCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isAllCharsEqualTo(final char... expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isAllCharsEqualTo(final int... expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected chars from the current position and does not contain any more chars.
     *
     * @param expected the expected chars.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isAllCharsEqualTo(final Iterable<Character> expected) {
        createReaderAssertion().isAllCharsEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's next line is equal to the expected string from the current position.
     *
     * @param expected the expected string.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextLineEqualTo(final String expected) {
        isNextLinesEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected strings from the current position.
     *
     * @param expected the expected strings.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextLinesEqualTo(final String... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toStringArray(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected strings from the current position.
     *
     * @param expected the expected strings.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isNextLinesEqualTo(final Iterable<String> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<String> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toStringArray(expectedList.size()).containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains the expected strings from the current position and does not contain any more strings.
     *
     * @param expected the expected strings.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isAllLinesEqualTo(final String... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toStringArray().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected strings from the current position and does not contain any more strings.
     *
     * @param expected the expected strings.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion isAllLinesEqualTo(final Iterable<String> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<String> expectedList = convertValue(expected, null, List.class);
        toStringArray().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public LongAssertion toLength() {
        return createReaderAssertion().toLength();
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toLength(final Matcher<? super Long> matcher) {
        createReaderAssertion().toLength(matcher);
        return this;
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion hasLength(final long expected) {
        createReaderAssertion().hasLength(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's lines length.
     *
     * @return the assertion.
     */
    public LongAssertion toLinesLength() {
        checkActualIsNotNull();
        long linesLength = getLinesLength();
        return initializeAssertion(Raw.longAssertion(), linesLength, Messages.Check.LINES_LENGTH);
    }

    /**
     * Make assertion about the actual value's lines length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion toLinesLength(final Matcher<? super Long> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        long linesLength = getLinesLength();
        matcherAssertion(linesLength, matcher, Messages.Check.LINES_LENGTH);
        return this;
    }

    private long getLinesLength() {
        try {
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
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Check if the actual value's lines length is equal to the expected lines length.
     *
     * @param expected the expected lines length.
     *
     * @return current object for the chain call.
     */
    public BufferedReaderAssertion hasLinesLength(final long expected) {
        toLinesLength().isEqualTo(expected);
        return this;
    }

    private ReaderAssertion createReaderAssertion() {
        return initializeAssertion(Raw.readerAssertion(), getActual());
    }

}
