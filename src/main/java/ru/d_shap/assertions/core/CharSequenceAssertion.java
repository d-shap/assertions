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

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the char sequence.
 *
 * @author Dmitry Shapovalov
 */
public class CharSequenceAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public CharSequenceAssertion(final CharSequence actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        createStringAssertion().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null) {
            createStringAssertion().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        createStringAssertion().isNotEmpty();
    }

    /**
     * Check if the actual value is blank.
     */
    public final void isBlank() {
        checkActualIsNotNull();
        createStringAssertion().isBlank();
    }

    /**
     * Check if the actual value is null or blank.
     */
    public final void isNullOrBlank() {
        if (getActual() != null) {
            createStringAssertion().isNullOrBlank();
        }
    }

    /**
     * Check if the actual value is NOT blank.
     */
    public final void isNotBlank() {
        checkActualIsNotNull();
        createStringAssertion().isNotBlank();
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isNotEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isGreaterThan(expected);
    }

    /**
     * Check if the actual value is greater than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanIgnoreCase(expected);
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanOrEqualTo(expected);
    }

    /**
     * Check if the actual value is greater than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanOrEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isLessThan(expected);
    }

    /**
     * Check if the actual value is less than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isLessThanIgnoreCase(expected);
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isLessThanOrEqualTo(expected);
    }

    /**
     * Check if the actual value is less than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualToIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isLessThanOrEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRange(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        createStringAssertion().isInRange(expectedFrom, expectedTo);
    }

    /**
     * Check if the actual value is in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        createStringAssertion().isInRangeIgnoreCase(expectedFrom, expectedTo);
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRange(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        createStringAssertion().isNotInRange(expectedFrom, expectedTo);
    }

    /**
     * Check if the actual value is NOT in the expected range ignoring case.
     *
     * @param expectedFrom the expected lower bound of the range.
     * @param expectedTo   the expected upper bound of the range.
     */
    public final void isNotInRangeIgnoreCase(final String expectedFrom, final String expectedTo) {
        checkActualIsNotNull();
        createStringAssertion().isNotInRangeIgnoreCase(expectedFrom, expectedTo);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().contains(expected);
    }

    /**
     * Check if the actual value contains the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void containsIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().containsIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotContain(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotContainIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotContainIgnoreCase(expected);
    }

    /**
     * Check if the actual value is part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isPartOf(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isPartOf(expected);
    }

    /**
     * Check if the actual value is part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isPartOfIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isPartOfIgnoreCase(expected);
    }

    /**
     * Check if the actual value is NOT part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOf(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isNotPartOf(expected);
    }

    /**
     * Check if the actual value is NOT part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOfIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().isNotPartOfIgnoreCase(expected);
    }

    /**
     * Check if the actual value matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void matches(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().matches(expected);
    }

    /**
     * Check if the actual value does NOT match the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotMatch(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotMatch(expected);
    }

    /**
     * Check if the actual value starts with the expected value.
     *
     * @param expected the expected value.
     */
    public final void startsWith(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().startsWith(expected);
    }

    /**
     * Check if the actual value starts with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void startsWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().startsWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT start with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWith(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotStartWith(expected);
    }

    /**
     * Check if the actual value does NOT start with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotStartWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value ends with the expected value.
     *
     * @param expected the expected value.
     */
    public final void endsWith(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().endsWith(expected);
    }

    /**
     * Check if the actual value ends with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void endsWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().endsWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT end with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWith(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotEndWith(expected);
    }

    /**
     * Check if the actual value does NOT end with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWithIgnoreCase(final String expected) {
        checkActualIsNotNull();
        createStringAssertion().doesNotEndWithIgnoreCase(expected);
    }

    /**
     * Make assertion about the actual value length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkActualIsNotNull();
        return createStringAssertion().toLength();
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        checkActualIsNotNull();
        createStringAssertion().hasLength(expected);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @return the assertion.
     */
    public final ListAssertion toTokens() {
        checkActualIsNotNull();
        return createStringAssertion().toTokens();
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @param delimiters the delimiters.
     * @return the assertion.
     */
    public final ListAssertion toTokens(final String delimiters) {
        checkActualIsNotNull();
        return createStringAssertion().toTokens(delimiters);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @param delimiters       the delimiters.
     * @param returnDelimiters whether to return the delimiters as tokens.
     * @return the assertion.
     */
    public final ListAssertion toTokens(final String delimiters, final boolean returnDelimiters) {
        checkActualIsNotNull();
        return createStringAssertion().toTokens(delimiters, returnDelimiters);
    }

    private StringAssertion createStringAssertion() {
        return new StringAssertion(getActual().toString(), getFailDescription());
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

}
