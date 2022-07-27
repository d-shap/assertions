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
package ru.d_shap.assertions.asimp.java.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.util.ListAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the char sequence.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceAssertion extends ReferenceAssertion<CharSequenceAssertion, CharSequence> {

    private static final int PATTERN_FLAGS = Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;

    /**
     * Create new object.
     */
    public CharSequenceAssertion() {
        super();
    }

    @Override
    protected Class<CharSequence> getActualValueClass() {
        return CharSequence.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isEmpty() {
        checkActualIsNotNull();
        if (!"".equals(getActual().toString())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNullOrEmpty() {
        if (getActual() != null && !"".equals(getActual().toString())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotEmpty() {
        checkActualIsNotNull();
        if ("".equals(getActual().toString())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is blank.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isBlank() {
        checkActualIsNotNull();
        for (int i = 0; i < getActual().length(); i++) {
            if (!Character.isWhitespace(getActual().charAt(i))) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_BLANK).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is null or blank.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNullOrBlank() {
        if (getActual() != null) {
            for (int i = 0; i < getActual().length(); i++) {
                if (!Character.isWhitespace(getActual().charAt(i))) {
                    throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_BLANK).addActual().build();
                }
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT blank.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotBlank() {
        checkActualIsNotNull();
        boolean blank = true;
        for (int i = 0; i < getActual().length(); i++) {
            if (!Character.isWhitespace(getActual().charAt(i))) {
                blank = false;
                break;
            }
        }
        if (blank) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_BLANK).build();
        }
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isEqualTo(final String expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().toString().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isEqualToIgnoreCase(final String expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().toString().equalsIgnoreCase(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME_IGNORE_CASE).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotEqualTo(final String expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().toString().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotEqualToIgnoreCase(final String expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().toString().equalsIgnoreCase(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT_IGNORE_CASE).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isGreaterThan(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        if (getActual().toString().compareTo(expected) <= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isGreaterThanIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        if (getActual().toString().compareToIgnoreCase(expected) <= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isGreaterThanOrEqualTo(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().toString().compareTo(expected) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isGreaterThanOrEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().toString().compareToIgnoreCase(expected) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isLessThan(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        if (getActual().toString().compareTo(expected) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isLessThanIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        if (getActual().toString().compareToIgnoreCase(expected) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isLessThanOrEqualTo(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().toString().compareTo(expected) > 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isLessThanOrEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().toString().compareToIgnoreCase(expected) > 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isInRange(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        checkArgumentIsNotEmpty("".equals(expectedTo), "expectedTo", false);
        if (getActual().toString().compareTo(expectedFrom) < 0 || getActual().toString().compareTo(expectedTo) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        checkArgumentIsNotEmpty("".equals(expectedTo), "expectedTo", false);
        if (getActual().toString().compareToIgnoreCase(expectedFrom) < 0 || getActual().toString().compareToIgnoreCase(expectedTo) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE_IGNORE_CASE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotInRange(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        checkArgumentIsNotEmpty("".equals(expectedTo), "expectedTo", true);
        if (getActual().toString().compareTo(expectedFrom) >= 0 && getActual().toString().compareTo(expectedTo) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        checkArgumentIsNotEmpty("".equals(expectedTo), "expectedTo", true);
        if (getActual().toString().compareToIgnoreCase(expectedFrom) >= 0 && getActual().toString().compareToIgnoreCase(expectedTo) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE_IGNORE_CASE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion contains(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        if (!getActual().toString().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion containsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        if (!matcher.find()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotContain(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        if (getActual().toString().contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotContainIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        if (matcher.find()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is part of the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isPartOf(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!expected.contains(getActual().toString())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_PART_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is part of the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isPartOfIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        Matcher matcher = Pattern.compile(getActual().toString(), PATTERN_FLAGS).matcher(expected);
        if (!matcher.find()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_PART_OF_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT part of the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotPartOf(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (expected.contains(getActual().toString())) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_PART_OF).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT part of the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion isNotPartOfIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        Matcher matcher = Pattern.compile(getActual().toString(), PATTERN_FLAGS).matcher(expected);
        if (matcher.find()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_PART_OF_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value matches the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion matches(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().toString().matches(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.MATCHES).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT match the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotMatch(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().toString().matches(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_MATCH).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value starts with the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion startsWith(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        if (!getActual().toString().startsWith(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.STARTS_WITH).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value starts with the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion startsWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        if (!matcher.find() || matcher.start() != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.STARTS_WITH_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT start with the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotStartWith(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        if (getActual().toString().startsWith(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_START_WITH).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT start with the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotStartWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        if (matcher.find() && matcher.start() == 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_START_WITH_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value ends with the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion endsWith(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        if (!getActual().toString().endsWith(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.ENDS_WITH).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value ends with the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion endsWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", true);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        int lastIndexStart = 0;
        int lastIndexEnd = -1;
        while (matcher.find(lastIndexStart)) {
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (lastIndexEnd != getActual().length()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.ENDS_WITH_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT end with the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotEndWith(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        if (getActual().toString().endsWith(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_END_WITH).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT end with the expected value ignoring case.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion doesNotEndWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty("".equals(expected), "expected", false);
        Matcher matcher = Pattern.compile(expected, PATTERN_FLAGS).matcher(getActual());
        int lastIndexStart = 0;
        int lastIndexEnd = -1;
        while (matcher.find(lastIndexStart)) {
            lastIndexStart = matcher.start() + 1;
            lastIndexEnd = matcher.end();
        }
        if (lastIndexEnd == getActual().length()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_END_WITH_IGNORE_CASE).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public IntAssertion toLength() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().length(), Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion toLength(final org.hamcrest.Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().length(), matcher, Messages.Check.LENGTH);
        return this;
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion hasLength(final int expected) {
        toLength().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @return the assertion.
     */
    public ListAssertion<String> toTokens() {
        checkActualIsNotNull();
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString());
        return initializeAssertion(Raw.<String>listAssertion(), getTokens(stringTokenizer), Messages.Check.TOKENS);
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @param delimiters the delimiters.
     *
     * @return the assertion.
     */
    public ListAssertion<String> toTokens(final String delimiters) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters, "delimiters");
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString(), delimiters);
        return initializeAssertion(Raw.<String>listAssertion(), getTokens(stringTokenizer), Messages.Check.TOKENS);
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @param delimiters       the delimiters.
     * @param returnDelimiters whether to return the delimiters as tokens.
     *
     * @return the assertion.
     */
    public ListAssertion<String> toTokens(final String delimiters, final boolean returnDelimiters) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters, "delimiters");
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString(), delimiters, returnDelimiters);
        return initializeAssertion(Raw.<String>listAssertion(), getTokens(stringTokenizer), Messages.Check.TOKENS);
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion toTokens(final org.hamcrest.Matcher<Iterable<String>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString());
        matcherAssertion(getTokens(stringTokenizer), matcher, Messages.Check.TOKENS);
        return this;
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @param delimiters the delimiters.
     * @param matcher    the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion toTokens(final String delimiters, final org.hamcrest.Matcher<Iterable<String>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters, "delimiters");
        checkArgumentIsNotNull(matcher, "matcher");
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString(), delimiters);
        matcherAssertion(getTokens(stringTokenizer), matcher, Messages.Check.TOKENS);
        return this;
    }

    /**
     * Make assertion about the actual value's tokens.
     *
     * @param delimiters       the delimiters.
     * @param returnDelimiters whether to return the delimiters as tokens.
     * @param matcher          the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharSequenceAssertion toTokens(final String delimiters, final boolean returnDelimiters, final org.hamcrest.Matcher<Iterable<String>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(delimiters, "delimiters");
        checkArgumentIsNotNull(matcher, "matcher");
        StringTokenizer stringTokenizer = new StringTokenizer(getActual().toString(), delimiters, returnDelimiters);
        matcherAssertion(getTokens(stringTokenizer), matcher, Messages.Check.TOKENS);
        return this;
    }

    private List<String> getTokens(final StringTokenizer stringTokenizer) {
        List<String> tokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            tokens.add(token);
        }
        return tokens;
    }

}
