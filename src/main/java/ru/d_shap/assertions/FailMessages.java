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
package ru.d_shap.assertions;

/**
 * Fail messages for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class FailMessages {

    private static final String MSG_ARGUMENT_IS_NOT_NULL = "Argument should not be null.";

    private static final String MSG_ARGUMENT_IS_NOT_EMPTY_TRUE = "Argument should not be empty. The result is always true.";

    private static final String MSG_ARGUMENT_IS_NOT_EMPTY_FALSE = "Argument should not be empty. The result is always false.";

    private static final String MSG_IS_TRUE = "Value should be true.";

    private static final String MSG_IS_FALSE = "Value should be false.";

    private static final String MSG_IS_SAME = "Values should be the same.";

    private static final String MSG_IS_DIFFERENT = "Values should be different.";

    private static final String MSG_IS_GREATER = "Value should be greater then the expected.";

    private static final String MSG_IS_GREATER_OR_EQUAL = "Value should be greater then or equal to the expected.";

    private static final String MSG_IS_LESS = "Value should be less then the expected.";

    private static final String MSG_IS_LESS_OR_EQUAL = "Value should be less then or equal to the expected.";

    private static final String MSG_IS_IN_RANGE = "Value should be in the expected range.";

    private static final String MSG_IS_NOT_IN_RANGE = "Value should not be in the expected range.";

    private static final String MSG_IS_ZERO = "Value should be zero.";

    private static final String MSG_IS_NON_ZERO = "Value should not be zero.";

    private static final String MSG_IS_POSITIVE_INFINITY = "Value should be positive infinity.";

    private static final String MSG_IS_NEGATIVE_INFINITY = "Value should be negative infinity.";

    private static final String MSG_IS_INFINITY = "Value should be infinity.";

    private static final String MSG_IS_NAN = "Value should be NaN.";

    private static final String MSG_IS_NOT_NAN = "Value should not be NaN.";

    private static final String MSG_IS_FINITE = "Value should be finite.";

    private static final String MSG_IS_ALPHABETIC = "Value should be the alphabetic symbol.";

    private static final String MSG_IS_DIGIT = "Value should be the digit.";

    private static final String MSG_IS_LETTER = "Value should be the letter.";

    private static final String MSG_IS_LETTER_OR_DIGIT = "Value should be the letter or the digit.";

    private static final String MSG_IS_CONTROL_SYMBOL = "Value should be the control symbol.";

    private static final String MSG_IS_LOWER_CASE = "Value should be the lower case symbol.";

    private static final String MSG_IS_UPPER_CASE = "Value should be the upper case symbol.";

    private static final String MSG_IS_WHITESPACE = "Value should be the whitespace symbol.";

    private static final String MSG_IS_NULL = "Value should be null.";

    private static final String MSG_IS_NOT_NULL = "Value should not be null.";

    private static final String MSG_IS_EMPTY = "Value should be empty.";

    private static final String MSG_IS_NULL_OR_EMPTY = "Value should be null or empty.";

    private static final String MSG_IS_NOT_EMPTY = "Value should not be empty.";

    private static final String MSG_IS_BLANK = "Value should be blank.";

    private static final String MSG_IS_NULL_OR_BLANK = "Value should be null or blank.";

    private static final String MSG_IS_NOT_BLANK = "Value should not be blank.";

    private static final String MSG_IS_SUBTYPE_OF = "Value should be the subtype of the expected value.";

    private static final String MSG_IS_NOT_SUBTYPE_OF = "Value should not be the subtype of the expected value.";

    private static final String MSG_IS_CONSTRUCTOR_DEFAULT = "Value should have one default constructor.";

    private static final String MSG_IS_CONSTRUCTOR_NOT_ACCESSIBLE = "Value constructor should not be acccessible.";

    private static final String MSG_IS_ENUM = "Value should be the enum.";

    private static final String MSG_CONTAINS = "Value should contain the expected value.";

    private static final String MSG_DOES_NOT_CONTAIN = "Value should not contain the expected value.";

    private static final String MSG_CONTAINS_ALL = "Value should contain all of the expected values.";

    private static final String MSG_CONTAINS_ALL_IN_ORDER = "Value should contain all of the expected values in the specified order.";

    private static final String MSG_CONTAINS_EXACTLY = "Value should contain all of the expected values exactly.";

    private static final String MSG_CONTAINS_EXACTLY_IN_ORDER = "Value should contain all of the expected values exactly in the specified order.";

    private static final String MSG_CONTAINS_ANY = "Value should contain any of the expected values.";

    private static final String MSG_CONTAINS_NONE = "Value should not contain any of the expected values.";

    private static final String MSG_IS_PART_OF = "Value should be the part of the expected value.";

    private static final String MSG_IS_NOT_PART_OF = "Value should not be the part of the expected value.";

    private static final String MSG_MATCHES = "Value should match the expected value.";

    private static final String MSG_DOES_NOT_MATCH = "Value should not match the expected value.";

    private static final String MSG_STARTS_WITH = "Value should start with the expected value.";

    private static final String MSG_DOES_NOT_START_WITH = "Value should not start with the expected value.";

    private static final String MSG_ENDS_WITH = "Value should end with the expected value.";

    private static final String MSG_DOES_NOT_END_WITH = "Value should not end with the expected value.";

    private static final String MSG_IS_DIRECT = "Value should be direct.";

    private static final String MSG_IS_NOT_DIRECT = "Value should not be direct.";

    private static final String MSG_IS_READ_ONLY = "Value should be read only.";

    private static final String MSG_IS_NOT_READ_ONLY = "Value should not be read only.";

    private static final String MSG_CONTAINS_FIELD = "Value should contain the expected field.";

    private FailMessages() {
        super();
    }

    /**
     * Get the fail message if the argument should not be null.
     *
     * @return the fail message.
     */
    public static String getArgumentIsNotNull() {
        return MSG_ARGUMENT_IS_NOT_NULL;
    }

    /**
     * Get the fail message if the argument should not be empty because the result is always true.
     *
     * @return the fail message.
     */
    public static String getArgumentIsNotEmptyTrue() {
        return MSG_ARGUMENT_IS_NOT_EMPTY_TRUE;
    }

    /**
     * Get the fail message if the argument should not be empty because the result is always false.
     *
     * @return the fail message.
     */
    public static String getArgumentIsNotEmptyFalse() {
        return MSG_ARGUMENT_IS_NOT_EMPTY_FALSE;
    }

    /**
     * Get the fail message if the actual value should be true.
     *
     * @return the fail message.
     */
    public static String getIsTrue() {
        return MSG_IS_TRUE;
    }

    /**
     * Get the fail message if the actual value should be false.
     *
     * @return the fail message.
     */
    public static String getIsFalse() {
        return MSG_IS_FALSE;
    }

    /**
     * Get the fail message if the actual value and the expected value should be the same.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsSame(final String actual, final String expected) {
        return MSG_IS_SAME + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value and the expected value should be different.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsDifferent(final String actual) {
        return MSG_IS_DIFFERENT + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be greater then the expected.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsGreater(final String actual, final String expected) {
        return MSG_IS_GREATER + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be greater then or equal to the expected.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsGreaterOrEqual(final String actual, final String expected) {
        return MSG_IS_GREATER_OR_EQUAL + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less then the expected.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsLess(final String actual, final String expected) {
        return MSG_IS_LESS + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less then or equal to the expected.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsLessOrEqual(final String actual, final String expected) {
        return MSG_IS_LESS_OR_EQUAL + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be in the expected range.
     *
     * @param actual       the actual value.
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     * @return the fail message.
     */
    public static String getIsInRange(final String actual, final String expectedFrom, final String expectedTo) {
        return MSG_IS_IN_RANGE + " " + getActualValueMessagePart(actual, expectedFrom, expectedTo);
    }

    /**
     * Get the fail message if the actual value should not be in the expected range.
     *
     * @param actual       the actual value.
     * @param expectedFrom the expected left bound of the range.
     * @param expectedTo   the expected right bound of the range.
     * @return the fail message.
     */
    public static String getIsNotInRange(final String actual, final String expectedFrom, final String expectedTo) {
        return MSG_IS_NOT_IN_RANGE + " " + getActualValueMessagePart(actual, expectedFrom, expectedTo);
    }

    /**
     * Get the fail message if the actual value should be zero.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsZero(final String actual) {
        return MSG_IS_ZERO + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be zero.
     *
     * @return the fail message.
     */
    public static String getIsNonZero() {
        return MSG_IS_NON_ZERO;
    }

    /**
     * Get the fail message if the actual value should be positive infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsPositiveInfinity(final String actual) {
        return MSG_IS_POSITIVE_INFINITY + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be negative infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNegativeInfinity(final String actual) {
        return MSG_IS_NEGATIVE_INFINITY + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsInfinity(final String actual) {
        return MSG_IS_INFINITY + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be NaN.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNaN(final String actual) {
        return MSG_IS_NAN + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be NaN.
     *
     * @return the fail message.
     */
    public static String getIsNotNaN() {
        return MSG_IS_NOT_NAN;
    }

    /**
     * Get the fail message if the actual value should be finite.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsFinite(final String actual) {
        return MSG_IS_FINITE + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the alphabetic symbol.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsAlphabetic(final String actual) {
        return MSG_IS_ALPHABETIC + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the digit.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsDigit(final String actual) {
        return MSG_IS_DIGIT + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the letter.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsLetter(final String actual) {
        return MSG_IS_LETTER + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the letter or the digit.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsLetterOrDigit(final String actual) {
        return MSG_IS_LETTER_OR_DIGIT + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the control symbol.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsControl(final String actual) {
        return MSG_IS_CONTROL_SYMBOL + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the lower case symbol.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsLowerCase(final String actual) {
        return MSG_IS_LOWER_CASE + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the upper case symbol.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsUpperCase(final String actual) {
        return MSG_IS_UPPER_CASE + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the whitespace symbol.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsWhitespace(final String actual) {
        return MSG_IS_WHITESPACE + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be null.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNull(final String actual) {
        return MSG_IS_NULL + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be null.
     *
     * @return the fail message.
     */
    public static String getIsNotNull() {
        return MSG_IS_NOT_NULL;
    }

    /**
     * Get the fail message if the actual value should be empty.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsEmpty(final String actual) {
        return MSG_IS_EMPTY + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be null or empty.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNullOrEmpty(final String actual) {
        return MSG_IS_NULL_OR_EMPTY + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be empty.
     *
     * @return the fail message.
     */
    public static String getIsNotEmpty() {
        return MSG_IS_NOT_EMPTY;
    }

    /**
     * Get the fail message if the actual value should be blank.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsBlank(final String actual) {
        return MSG_IS_BLANK + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be null or blank.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNullOrBlank(final String actual) {
        return MSG_IS_NULL_OR_BLANK + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be blank.
     *
     * @return the fail message.
     */
    public static String getIsNotBlank() {
        return MSG_IS_NOT_BLANK;
    }

    /**
     * Get the fail message if the actual value should be the subtype of the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsSubtypeOf(final String actual, final String expected) {
        return MSG_IS_SUBTYPE_OF + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not be the subtype of the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsNotSubtypeOf(final String actual, final String expected) {
        return MSG_IS_NOT_SUBTYPE_OF + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should have one default constructor.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsConstructorDefault(final String actual) {
        return MSG_IS_CONSTRUCTOR_DEFAULT + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value constructor should not be acccessible.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsConstructorNotAccessible(final String actual) {
        return MSG_IS_CONSTRUCTOR_NOT_ACCESSIBLE + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be the enum.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsEnum(final String actual) {
        return MSG_IS_ENUM + " " + getActualValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should contain the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getContains(final String actual, final String expected) {
        return MSG_CONTAINS + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not contain the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getDoesNotContain(final String actual, final String expected) {
        return MSG_DOES_NOT_CONTAIN + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should contain all of the expected values.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsAll(final String actual, final String expected) {
        return MSG_CONTAINS_ALL + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should contain all of the expected values in the specified order.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsAllInOrder(final String actual, final String expected) {
        return MSG_CONTAINS_ALL_IN_ORDER + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should contain all of the expected values exactly.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsExactly(final String actual, final String expected) {
        return MSG_CONTAINS_EXACTLY + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should contain all of the expected values exactly in the specified order.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsExactlyInOrder(final String actual, final String expected) {
        return MSG_CONTAINS_EXACTLY_IN_ORDER + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should contain any of the expected values.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsAny(final String actual, final String expected) {
        return MSG_CONTAINS_ANY + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not contain any of the expected values.
     *
     * @param actual   the actual value.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getContainsNone(final String actual, final String expected) {
        return MSG_CONTAINS_NONE + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be the part of the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsPartOf(final String actual, final String expected) {
        return MSG_IS_PART_OF + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not be the part of the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsNotPartOf(final String actual, final String expected) {
        return MSG_IS_NOT_PART_OF + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should match the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getMatches(final String actual, final String expected) {
        return MSG_MATCHES + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not match the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getDoesNotMatch(final String actual, final String expected) {
        return MSG_DOES_NOT_MATCH + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should start with the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStartsWith(final String actual, final String expected) {
        return MSG_STARTS_WITH + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not start with the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getDoesNotStartWith(final String actual, final String expected) {
        return MSG_DOES_NOT_START_WITH + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should end with the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getEndsWith(final String actual, final String expected) {
        return MSG_ENDS_WITH + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should not end with the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getDoesNotEndWith(final String actual, final String expected) {
        return MSG_DOES_NOT_END_WITH + " " + getActualValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be direct.
     *
     * @return the fail message.
     */
    public static String getIsDirect() {
        return MSG_IS_DIRECT;
    }

    /**
     * Get the fail message if the actual value should not be direct.
     *
     * @return the fail message.
     */
    public static String getIsNotDirect() {
        return MSG_IS_NOT_DIRECT;
    }

    /**
     * Get the fail message if the actual value should be read only.
     *
     * @return the fail message.
     */
    public static String getIsReadOnly() {
        return MSG_IS_READ_ONLY;
    }

    /**
     * Get the fail message if the actual value should not be read only.
     *
     * @return the fail message.
     */
    public static String getIsNotReadOnly() {
        return MSG_IS_NOT_READ_ONLY;
    }

    /**
     * Get the fail message if the actual value should contain the expected field.
     *
     * @param expected the expected field.
     * @return the fail message.
     */
    public static String getContainsField(final String expected) {
        return MSG_CONTAINS_FIELD + " " + getExpectedValueMessagePart(expected);
    }

    private static String getActualValueMessagePart(final String actual) {
        return "Actual:<" + actual + ">";
    }

    private static String getActualValueMessagePart(final String actual, final String expected) {
        return "Expected:<" + expected + "> but was:<" + actual + ">";
    }

    private static String getActualValueMessagePart(final String actual, final String expectedFrom, final String expectedTo) {
        return "Expected:<" + expectedFrom + ":" + expectedTo + "> but was:<" + actual + ">";
    }

    private static String getExpectedValueMessagePart(final String expected) {
        return "Expected:<" + expected + ">";
    }

}
