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
package ru.d_shap.assertions.core;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the string.
 *
 * @author Dmitry Shapovalov
 */
public class StringAssertion extends ReferenceAssertion {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(String.class);

    private static final int PATTERN_FLAGS = Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;

    /**
     * Create new object.
     */
    public StringAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (!"".equals(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_EMPTY);
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null && !"".equals(getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NULL_OR_EMPTY);
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if ("".equals(getActual())) {
            throw createAssertionError(Messages.Fail.IS_NOT_EMPTY);
        }
    }

    /**
     * Check if the actual value is blank.
     */
    public final void isBlank() {
        checkInitialized();
        checkActualIsNotNull();
        for (int i = 0; i < ((String) getActual()).length(); i++) {
            if (!Character.isWhitespace(((String) getActual()).charAt(i))) {
                throw createAssertionErrorWithActual(Messages.Fail.IS_BLANK);
            }
        }
    }

    /**
     * Check if the actual value is null or blank.
     */
    public final void isNullOrBlank() {
        checkInitialized();
        if (getActual() != null) {
            for (int i = 0; i < ((String) getActual()).length(); i++) {
                if (!Character.isWhitespace(((String) getActual()).charAt(i))) {
                    throw createAssertionErrorWithActual(Messages.Fail.IS_NULL_OR_BLANK);
                }
            }
        }
    }

    /**
     * Check if the actual value is NOT blank.
     */
    public final void isNotBlank() {
        checkInitialized();
        checkActualIsNotNull();
        boolean blank = true;
        for (int i = 0; i < ((String) getActual()).length(); i++) {
            if (!Character.isWhitespace(((String) getActual()).charAt(i))) {
                blank = false;
                break;
            }
        }
        if (blank) {
            throw createAssertionError(Messages.Fail.IS_NOT_BLANK);
        }
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!((String) getActual()).equalsIgnoreCase(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_SAME, expected);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (getActual().equals(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).equalsIgnoreCase(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_DIFFERENT);
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        if (((String) getActual()).compareTo(expected) <= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
        }
    }

    /**
     * Check if the actual value is greater than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        if (((String) getActual()).compareToIgnoreCase(expected) <= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER, expected);
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).compareTo(expected) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).compareToIgnoreCase(expected) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_GREATER_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        if (((String) getActual()).compareTo(expected) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
        }
    }

    /**
     * Check if the actual value is less than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        if (((String) getActual()).compareToIgnoreCase(expected) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS, expected);
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).compareTo(expected) > 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).compareToIgnoreCase(expected) > 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_LESS_OR_EQUAL, expected);
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRange(final String expectedFrom, final String expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        checkArgumentIsNotEmptyFalse("".equals(expectedTo));
        if (((String) getActual()).compareTo(expectedFrom) < 0 || ((String) getActual()).compareTo(expectedTo) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        checkArgumentIsNotEmptyFalse("".equals(expectedTo));
        if (((String) getActual()).compareToIgnoreCase(expectedFrom) < 0 || ((String) getActual()).compareToIgnoreCase(expectedTo) >= 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRange(final String expectedFrom, final String expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        checkArgumentIsNotEmptyTrue("".equals(expectedTo));
        if (((String) getActual()).compareTo(expectedFrom) >= 0 && ((String) getActual()).compareTo(expectedTo) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value is NOT in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom);
        checkArgumentIsNotNull(expectedTo);
        checkArgumentIsNotEmptyTrue("".equals(expectedTo));
        if (((String) getActual()).compareToIgnoreCase(expectedFrom) >= 0 && ((String) getActual()).compareToIgnoreCase(expectedTo) < 0) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_IN_RANGE, expectedFrom, expectedTo);
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        if (!((String) getActual()).contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS, expected);
        }
    }

    /**
     * Check if the actual value contains the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void containsIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (!matcher.find()) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS, expected);
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        if (((String) getActual()).contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_CONTAIN, expected);
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotContainIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (matcher.find()) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_CONTAIN, expected);
        }
    }

    /**
     * Check if the actual value is part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isPartOf(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!expected.contains((String) getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_PART_OF, expected);
        }
    }

    /**
     * Check if the actual value is part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isPartOfIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Matcher matcher = Pattern.compile((String) getActual(), PATTERN_FLAGS).matcher(expected);
        if (!matcher.find()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_PART_OF, expected);
        }
    }

    /**
     * Check if the actual value is NOT part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOf(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (expected.contains((String) getActual())) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_PART_OF, expected);
        }
    }

    /**
     * Check if the actual value is NOT part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOfIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        Matcher matcher = Pattern.compile((String) getActual(), PATTERN_FLAGS).matcher(expected);
        if (matcher.find()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NOT_PART_OF, expected);
        }
    }

    /**
     * Check if the actual value matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void matches(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!((String) getActual()).matches(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.MATCHES, expected);
        }
    }

    /**
     * Check if the actual value does NOT match the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotMatch(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((String) getActual()).matches(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_MATCH, expected);
        }
    }

    /**
     * Check if the actual value starts with the expected value.
     *
     * @param expected the expected value.
     */
    public final void startsWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        if (!((String) getActual()).startsWith(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.STARTS_WITH, expected);
        }
    }

    /**
     * Check if the actual value starts with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void startsWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (!matcher.find() || matcher.start() != 0) {
            throw createAssertionErrorWithActual(Messages.Fail.STARTS_WITH, expected);
        }
    }

    /**
     * Check if the actual value does NOT start with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        if (((String) getActual()).startsWith(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_START_WITH, expected);
        }
    }

    /**
     * Check if the actual value does NOT start with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        if (matcher.find() && matcher.start() == 0) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_START_WITH, expected);
        }
    }

    /**
     * Check if the actual value ends with the expected value.
     *
     * @param expected the expected value.
     */
    public final void endsWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        if (!((String) getActual()).endsWith(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.ENDS_WITH, expected);
        }
    }

    /**
     * Check if the actual value ends with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void endsWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        int lastIndexStart = 0;
        int lastIndexEnd = -1;
        while (matcher.find(lastIndexStart)) {
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (lastIndexEnd != ((String) getActual()).length()) {
            throw createAssertionErrorWithActual(Messages.Fail.ENDS_WITH, expected);
        }
    }

    /**
     * Check if the actual value does NOT end with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        if (((String) getActual()).endsWith(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_END_WITH, expected);
        }
    }

    /**
     * Check if the actual value does NOT end with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse("".equals(expected));
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher((String) getActual());
        int lastIndexStart = 0;
        int lastIndexEnd = -1;
        while (matcher.find(lastIndexStart)) {
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (lastIndexEnd == ((String) getActual()).length()) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_END_WITH, expected);
        }
    }

    /**
     * Make assertion about the actual value length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), ((String) getActual()).length(), Messages.Check.ACTUAL_VALUE_LENGTH);
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @return the assertion.
     */
    public final ListAssertion toTokens() {
        checkInitialized();
        checkActualIsNotNull();
        StringTokenizer stringTokenizer = new StringTokenizer((String) getActual());
        return toTokens(stringTokenizer);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @param delimiters the delimiters.
     * @return the assertion.
     */
    public final ListAssertion toTokens(final String delimiters) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters);
        StringTokenizer stringTokenizer = new StringTokenizer((String) getActual(), delimiters);
        return toTokens(stringTokenizer);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @param delimiters       the delimiters.
     * @param returnDelimiters whether to return the delimiters as tokens.
     * @return the assertion.
     */
    public final ListAssertion toTokens(final String delimiters, final boolean returnDelimiters) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters);
        StringTokenizer stringTokenizer = new StringTokenizer((String) getActual(), delimiters, returnDelimiters);
        return toTokens(stringTokenizer);
    }

    private ListAssertion toTokens(final StringTokenizer stringTokenizer) {
        List<String> tokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            tokens.add(token);
        }
        return initializeAssertion(Raw.listAssertion(), tokens, Messages.Check.ACTUAL_VALUE_TOKENS);
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
