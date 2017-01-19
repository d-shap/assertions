///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
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
package ru.d_shap.assertions.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the string.
 *
 * @author Dmitry Shapovalov
 */
public class StringAssertion extends ReferenceAssertion {

    private static final int PATTERN_FLAGS = Pattern.LITERAL + Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE;

    /**
     * Create new object.
     *
     * @param actual  the actual string.
     * @param message the assertion message.
     */
    public StringAssertion(final String actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual string is equal to the expected string.
     *
     * @param expected the expected string.
     */
    public final void isEqualTo(final String expected) {
        if (!getActual().equals(expected)) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is NOT equal to the expected string.
     *
     * @param expected the expected string.
     */
    public final void isNotEqualTo(final String expected) {
        if (getActual().equals(expected)) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual string is equal to the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void isEqualToIgnoreCase(final String expected) {
        if (!((String) getActual()).equalsIgnoreCase(expected)) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is NOT equal to the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void isNotEqualToIgnoreCase(final String expected) {
        if (((String) getActual()).equalsIgnoreCase(expected)) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Check if the actual string contains the expected string.
     *
     * @param expected the expected string.
     */
    public final void contains(final String expected) {
        if (!((String) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getStringContains(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT contain the expected string.
     *
     * @param expected the expected string.
     */
    public final void doesNotContain(final String expected) {
        if (((String) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getStringDoesNotContain(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string contains the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void containsIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (!matcher.find()) {
            throw createAssertionError(FailMessages.getStringContains(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT contain the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void doesNotContainIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (matcher.find()) {
            throw createAssertionError(FailMessages.getStringDoesNotContain(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is part of the expected string.
     *
     * @param expected the expected string.
     */
    public final void isPartOf(final String expected) {
        if (!expected.contains((String) getActual())) {
            throw createAssertionError(FailMessages.getStringIsPartOf(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is NOT part of the expected string.
     *
     * @param expected the expected string.
     */
    public final void isNotPartOf(final String expected) {
        if (expected.contains((String) getActual())) {
            throw createAssertionError(FailMessages.getStringIsNotPartOf(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is part of the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void isPartOfIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile((String) getActual(), PATTERN_FLAGS).matcher(expected);
        if (!matcher.find()) {
            throw createAssertionError(FailMessages.getStringIsPartOf(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string is NOT part of the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void isNotPartOfIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile((String) getActual(), PATTERN_FLAGS).matcher(expected);
        if (matcher.find()) {
            throw createAssertionError(FailMessages.getStringIsNotPartOf(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string matches the expected regexp.
     *
     * @param expected the expected regexp.
     */
    public final void matches(final String expected) {
        if (!((String) getActual()).matches(expected)) {
            throw createAssertionError(FailMessages.getStringMatches(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT match the expected regexp.
     *
     * @param expected the expected regexp.
     */
    public final void doesNotMatch(final String expected) {
        if (((String) getActual()).matches(expected)) {
            throw createAssertionError(FailMessages.getStringDoesNotMatch(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string starts with the expected string.
     *
     * @param expected the expected string.
     */
    public final void startsWith(final String expected) {
        if (!((String) getActual()).startsWith(expected)) {
            throw createAssertionError(FailMessages.getStringStartsWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT start with the expected string.
     *
     * @param expected the expected string.
     */
    public final void doesNotStartWith(final String expected) {
        if (((String) getActual()).startsWith(expected)) {
            throw createAssertionError(FailMessages.getStringDoesNotStartWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string starts with the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void startsWithIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (!matcher.find() || matcher.start() != 0) {
            throw createAssertionError(FailMessages.getStringStartsWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT start with the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void doesNotStartWithIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (matcher.find() && matcher.start() == 0) {
            throw createAssertionError(FailMessages.getStringDoesNotStartWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string ends with the expected string.
     *
     * @param expected the expected string.
     */
    public final void endsWith(final String expected) {
        if (!((String) getActual()).endsWith(expected)) {
            throw createAssertionError(FailMessages.getStringEndsWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT end with the expected string.
     *
     * @param expected the expected string.
     */
    public final void doesNotEndWith(final String expected) {
        if (((String) getActual()).endsWith(expected)) {
            throw createAssertionError(FailMessages.getStringDoesNotEndWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string ends with the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void endsWithIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        boolean found = false;
        int lastIndexStart = 0;
        int lastIndexEnd = 0;
        while (matcher.find(lastIndexStart)) {
            found = true;
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (!found || lastIndexEnd != ((String) getActual()).length()) {
            throw createAssertionError(FailMessages.getStringEndsWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual string does NOT end with the expected string ignoring case.
     *
     * @param expected the expected string.
     */
    public final void doesNotEndWithIgnoreCase(final String expected) {
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        boolean found = false;
        int lastIndexStart = 0;
        int lastIndexEnd = 0;
        while (matcher.find(lastIndexStart)) {
            found = true;
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (found && lastIndexEnd == ((String) getActual()).length()) {
            throw createAssertionError(FailMessages.getStringDoesNotEndWith(actualAsString(), asString(expected)));
        }
    }

    /**
     * Make assertion about the actual string length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        return new IntAssertion(((String) getActual()).length(), getMessage());
    }

    /**
     * Check if the actual string length is equal to the expected string length.
     *
     * @param expected the expected string length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            if (value instanceof String) {
                return (String) value;
            } else {
                return String.valueOf(value);
            }
        }
    }

}
