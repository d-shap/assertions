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
package ru.d_shap.assertions;

/**
 * Fail messages for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class FailMessages {

    private static final String MSG_TRUE = "Value should be true.";

    private static final String MSG_FALSE = "Value should be false.";

    private static final String MSG_SAME = "Values should be the same.";

    private static final String MSG_DIFFERENT = "Values should be different.";

    private static final String MSG_GREATER = "Value should be greater then the expected.";

    private static final String MSG_GREATER_OR_EQUAL = "Value should be greater then or equal to the expected.";

    private static final String MSG_LESS = "Value should be less then the expected.";

    private static final String MSG_LESS_OR_EQUAL = "Value should be less then or equal to the expected.";

    private static final String MSG_ZERO = "Value should be zero.";

    private static final String MSG_NON_ZERO = "Value should not be zero.";

    private static final String MSG_POSITIVE_INFINITY = "Value should be positive infinity.";

    private static final String MSG_NEGATIVE_INFINITY = "Value should be negative infinity.";

    private static final String MSG_INFINITY = "Value should be infinity.";

    private static final String MSG_NAN = "Value should be NaN.";

    private static final String MSG_NOT_NAN = "Value should not be NaN.";

    private static final String MSG_FINITE = "Value should be finite.";

    private static final String MSG_ALPHABETIC = "Character should be the alphabetic symbol.";

    private static final String MSG_DIGIT = "Character should be the digit.";

    private static final String MSG_LETTER = "Character should be the letter.";

    private static final String MSG_LETTER_OR_DIGIT = "Character should be the letter or the digit.";

    private static final String MSG_CONTROL_SYMBOL = "Character should be the control symbol.";

    private static final String MSG_LOWER_CASE = "Character should be the lower case symbol.";

    private static final String MSG_UPPER_CASE = "Character should be the upper case symbol.";

    private static final String MSG_WHITESPACE = "Character should be the whitespace symbol.";

    private static final String MSG_NULL = "Value should be null.";

    private static final String MSG_NOT_NULL = "Value should not be null.";

    private static final String MSG_ARRAY_EMPTY = "Value should be the empty array.";

    private static final String MSG_ARRAY_NOT_EMPTY = "Value should not be the empty array.";

    private static final String MSG_CLASS_SUBTYPE = "Class should be the subtype of the expected class.";

    private static final String MSG_CLASS_NOT_SUBTYPE = "Class should not be the subtype of the expected class.";

    private static final String MSG_CONSTRUCTOR_DEFAULT = "Class should have one default constructor.";

    private static final String MSG_CONSTRUCTOR_NOT_ACCESSIBLE = "Class constructor should not be acccessible.";

    private static final String MSG_ENUM_CLASS = "Class should be the enum class.";

    private static final String MSG_STRING_CONTAINS = "String should contain the expected string.";

    private static final String MSG_STRING_NOT_CONTAINS = "String should not contain the expected string.";

    private static final String MSG_STRING_PART_OF = "String should be the part of the expected string.";

    private static final String MSG_STRING_NOT_PART_OF = "String should not be the part of the expected string.";

    private static final String MSG_STRING_MATCHES = "String should match the expected regexp.";

    private static final String MSG_STRING_NOT_MATCHES = "String should not match the expected regexp.";

    private static final String MSG_STRING_STARTS_WITH = "String should start with the expected string.";

    private static final String MSG_STRING_NOT_STARTS_WITH = "String should not start with the expected string.";

    private static final String MSG_STRING_ENDS_WITH = "String should end with the expected string.";

    private static final String MSG_STRING_NOT_ENDS_WITH = "String should not end with the expected string.";

    private FailMessages() {
        super();
    }

    /**
     * Get the fail message if the actual value should be true.
     *
     * @return the fail message.
     */
    public static String getTrue() {
        return MSG_TRUE;
    }

    /**
     * Get the fail message if the actual value should be false.
     *
     * @return the fail message.
     */
    public static String getFalse() {
        return MSG_FALSE;
    }

    /**
     * Get the fail message if the actual value and the expected value should be the same.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getSame(final String actual, final String expected) {
        return MSG_SAME + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value and the expected value should be different.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getDifferent(final String actual) {
        return MSG_DIFFERENT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be greater than the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getGreater(final String actual, final String expected) {
        return MSG_GREATER + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be greater than or equal to the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getGreaterOrEqual(final String actual, final String expected) {
        return MSG_GREATER_OR_EQUAL + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less than the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getLess(final String actual, final String expected) {
        return MSG_LESS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less than or equal to the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getLessOrEqual(final String actual, final String expected) {
        return MSG_LESS_OR_EQUAL + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be zero.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getZero(final String actual) {
        return MSG_ZERO + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be zero.
     *
     * @return the fail message.
     */
    public static String getNonZero() {
        return MSG_NON_ZERO;
    }

    /**
     * Get the fail message if the actual value should be positive infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getPositiveInfinity(final String actual) {
        return MSG_POSITIVE_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be negative infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getNegativeInfinity(final String actual) {
        return MSG_NEGATIVE_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getInfinity(final String actual) {
        return MSG_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be not-a-number.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getNaN(final String actual) {
        return MSG_NAN + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be not-a-number.
     *
     * @return the fail message.
     */
    public static String getNotNaN() {
        return MSG_NOT_NAN;
    }

    /**
     * Get the fail message if the actual value should be finite.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getFinite(final String actual) {
        return MSG_FINITE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the alphabetic symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getAlphabetic(final String actual) {
        return MSG_ALPHABETIC + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the digit.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getDigit(final String actual) {
        return MSG_DIGIT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the letter.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getLetter(final String actual) {
        return MSG_LETTER + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the letter or the digit.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getLetterOrDigit(final String actual) {
        return MSG_LETTER_OR_DIGIT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the control symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getControl(final String actual) {
        return MSG_CONTROL_SYMBOL + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the lower case symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getLowerCase(final String actual) {
        return MSG_LOWER_CASE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the upper case symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getUpperCase(final String actual) {
        return MSG_UPPER_CASE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the whitespace symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getWhitespace(final String actual) {
        return MSG_WHITESPACE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be null.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getNull(final String actual) {
        return MSG_NULL + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be null.
     *
     * @return the fail message.
     */
    public static String getNotNull() {
        return MSG_NOT_NULL;
    }

    /**
     * Get the fail message if the actual value should be the empty array.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getArrayEmpty(final String actual) {
        return MSG_ARRAY_EMPTY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be the empty array.
     *
     * @return the fail message.
     */
    public static String getArrayNotEmpty() {
        return MSG_ARRAY_NOT_EMPTY;
    }

    /**
     * Get the fail message if the actual class should be the subtype of the expected class.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getClassSubtype(final String actual, final String expected) {
        return MSG_CLASS_SUBTYPE + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual class should not be the subtype of the expected class.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getClassNotSubtype(final String actual, final String expected) {
        return MSG_CLASS_NOT_SUBTYPE + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual class should have the default constructor.
     *
     * @return the fail message.
     */
    public static String getConstructorDefault() {
        return MSG_CONSTRUCTOR_DEFAULT;
    }

    /**
     * Get the fail message if the actual class constructor should not be accessible.
     *
     * @return the fail message.
     */
    public static String getConstructorNotAccessible() {
        return MSG_CONSTRUCTOR_NOT_ACCESSIBLE;
    }

    /**
     * Get the fail message if the actual class should be the enum class.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getEnumClass(final String actual) {
        return MSG_ENUM_CLASS + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual string should contain the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringContains(final String actual, final String expected) {
        return MSG_STRING_CONTAINS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not contain the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringNotContains(final String actual, final String expected) {
        return MSG_STRING_NOT_CONTAINS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should be the part of the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringPartOf(final String actual, final String expected) {
        return MSG_STRING_PART_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not be the part of the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringNotPartOf(final String actual, final String expected) {
        return MSG_STRING_NOT_PART_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should match the expected regexp.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringMatches(final String actual, final String expected) {
        return MSG_STRING_MATCHES + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not match the expected regexp.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringNotMatches(final String actual, final String expected) {
        return MSG_STRING_NOT_MATCHES + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should start with the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringStartsWith(final String actual, final String expected) {
        return MSG_STRING_STARTS_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not start with the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringNotStartsWith(final String actual, final String expected) {
        return MSG_STRING_NOT_STARTS_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should end with the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringEndsWith(final String actual, final String expected) {
        return MSG_STRING_ENDS_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not end with the expected string.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getStringNotEndsWith(final String actual, final String expected) {
        return MSG_STRING_NOT_ENDS_WITH + " " + getValueMessagePart(actual, expected);
    }

    private static String getValueMessagePart(final String actual) {
        return "Actual:<" + actual + ">";
    }

    private static String getValueMessagePart(final String actual, final String expected) {
        return "Expected:<" + expected + "> but was:<" + actual + ">";
    }

}
