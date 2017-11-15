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

import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the char sequence.
 *
 * @author Dmitry Shapovalov
 */
public class CharSequenceAssertion extends ReferenceAssertion {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(CharSequence.class);

    /**
     * Create new object.
     */
    public CharSequenceAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createStringAssertion().isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotEmpty();
    }

    /**
     * Check if the actual value is blank.
     */
    public final void isBlank() {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isBlank();
    }

    /**
     * Check if the actual value is null or blank.
     */
    public final void isNullOrBlank() {
        checkInitialized();
        if (getActual() != null) {
            createStringAssertion().isNullOrBlank();
        }
    }

    /**
     * Check if the actual value is NOT blank.
     */
    public final void isNotBlank() {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotBlank();
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isGreaterThan(expected);
    }

    /**
     * Check if the actual value is greater than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanIgnoreCase(expected);
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanOrEqualTo(expected);
    }

    /**
     * Check if the actual value is greater than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualToIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isGreaterThanOrEqualToIgnoreCase(expected);
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isLessThan(expected);
    }

    /**
     * Check if the actual value is less than the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isLessThanIgnoreCase(expected);
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isLessThanOrEqualTo(expected);
    }

    /**
     * Check if the actual value is less than or equal to the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualToIgnoreCase(final String expected) {
        checkInitialized();
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
        checkInitialized();
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
        checkInitialized();
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
        checkInitialized();
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
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotInRangeIgnoreCase(expectedFrom, expectedTo);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().contains(expected);
    }

    /**
     * Check if the actual value contains the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void containsIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().containsIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotContain(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotContainIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotContainIgnoreCase(expected);
    }

    /**
     * Check if the actual value is part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isPartOf(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isPartOf(expected);
    }

    /**
     * Check if the actual value is part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isPartOfIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isPartOfIgnoreCase(expected);
    }

    /**
     * Check if the actual value is NOT part of the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOf(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotPartOf(expected);
    }

    /**
     * Check if the actual value is NOT part of the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void isNotPartOfIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().isNotPartOfIgnoreCase(expected);
    }

    /**
     * Check if the actual value matches the expected value.
     *
     * @param expected the expected value.
     */
    public final void matches(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().matches(expected);
    }

    /**
     * Check if the actual value does NOT match the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotMatch(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotMatch(expected);
    }

    /**
     * Check if the actual value starts with the expected value.
     *
     * @param expected the expected value.
     */
    public final void startsWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().startsWith(expected);
    }

    /**
     * Check if the actual value starts with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void startsWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().startsWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT start with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotStartWith(expected);
    }

    /**
     * Check if the actual value does NOT start with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotStartWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotStartWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value ends with the expected value.
     *
     * @param expected the expected value.
     */
    public final void endsWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().endsWith(expected);
    }

    /**
     * Check if the actual value ends with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void endsWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().endsWithIgnoreCase(expected);
    }

    /**
     * Check if the actual value does NOT end with the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWith(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotEndWith(expected);
    }

    /**
     * Check if the actual value does NOT end with the expected value ignoring case.
     *
     * @param expected the expected value.
     */
    public final void doesNotEndWithIgnoreCase(final String expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().doesNotEndWithIgnoreCase(expected);
    }

    /**
     * Make assertion about the actual value length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkInitialized();
        checkActualIsNotNull();
        return createStringAssertion().toLength();
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createStringAssertion().hasLength(expected);
    }

    /**
     * Make assertion about the actual value tokens.
     *
     * @return the assertion.
     */
    public final ListAssertion toTokens() {
        checkInitialized();
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
        checkInitialized();
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
        checkInitialized();
        checkActualIsNotNull();
        return createStringAssertion().toTokens(delimiters, returnDelimiters);
    }

    private StringAssertion createStringAssertion() {
        return initializeAssertion(Raw.stringAssertion(), getActual().toString());
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
