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

    private static final String MSG_IS_TRUE = "Value should be true.";

    private static final String MSG_IS_FALSE = "Value should be false.";

    private static final String MSG_IS_SAME = "Values should be the same.";

    private static final String MSG_IS_DIFFERENT = "Values should be different.";

    private static final String MSG_IS_GREATER = "Value should be greater then the expected.";

    private static final String MSG_IS_GREATER_OR_EQUAL = "Value should be greater then or equal to the expected.";

    private static final String MSG_IS_LESS = "Value should be less then the expected.";

    private static final String MSG_IS_LESS_OR_EQUAL = "Value should be less then or equal to the expected.";

    private static final String MSG_IS_ZERO = "Value should be zero.";

    private static final String MSG_IS_NON_ZERO = "Value should not be zero.";

    private static final String MSG_IS_POSITIVE_INFINITY = "Value should be positive infinity.";

    private static final String MSG_IS_NEGATIVE_INFINITY = "Value should be negative infinity.";

    private static final String MSG_IS_INFINITY = "Value should be infinity.";

    private static final String MSG_IS_NAN = "Value should be NaN.";

    private static final String MSG_IS_NOT_NAN = "Value should not be NaN.";

    private static final String MSG_IS_FINITE = "Value should be finite.";

    private static final String MSG_IS_ALPHABETIC = "Character should be the alphabetic symbol.";

    private static final String MSG_IS_DIGIT = "Character should be the digit.";

    private static final String MSG_IS_LETTER = "Character should be the letter.";

    private static final String MSG_IS_LETTER_OR_DIGIT = "Character should be the letter or the digit.";

    private static final String MSG_IS_CONTROL_SYMBOL = "Character should be the control symbol.";

    private static final String MSG_IS_LOWER_CASE = "Character should be the lower case symbol.";

    private static final String MSG_IS_UPPER_CASE = "Character should be the upper case symbol.";

    private static final String MSG_IS_WHITESPACE = "Character should be the whitespace symbol.";

    private static final String MSG_IS_NULL = "Object should be null.";

    private static final String MSG_IS_NOT_NULL = "Object should not be null.";

    private static final String MSG_ARRAY_IS_EMPTY = "Array should be empty.";

    private static final String MSG_ARRAY_IS_NOT_EMPTY = "Array should not be empty.";

    private static final String MSG_CLASS_IS_SUBTYPE_OF = "Class should be the subtype of the expected class.";

    private static final String MSG_CLASS_IS_NOT_SUBTYPE_OF = "Class should not be the subtype of the expected class.";

    private static final String MSG_CONSTRUCTOR_IS_DEFAULT = "Class should have one default constructor.";

    private static final String MSG_CONSTRUCTOR_IS_NOT_ACCESSIBLE = "Class constructor should not be acccessible.";

    private static final String MSG_IS_ENUM_CLASS = "Class should be the enum class.";

    private static final String MSG_STRING_CONTAINS = "String should contain the expected string.";

    private static final String MSG_STRING_DOES_NOT_CONTAIN = "String should not contain the expected string.";

    private static final String MSG_STRING_IS_PART_OF = "String should be the part of the expected string.";

    private static final String MSG_STRING_IS_NOT_PART_OF = "String should not be the part of the expected string.";

    private static final String MSG_STRING_MATCHES = "String should match the expected regexp.";

    private static final String MSG_STRING_DOES_NOT_MATCH = "String should not match the expected regexp.";

    private static final String MSG_STRING_STARTS_WITH = "String should start with the expected string.";

    private static final String MSG_STRING_DOES_NOT_START_WITH = "String should not start with the expected string.";

    private static final String MSG_STRING_ENDS_WITH = "String should end with the expected string.";

    private static final String MSG_STRING_DOES_NOT_END_WITH = "String should not end with the expected string.";

    private static final String MSG_COLLECTION_IS_EMPTY = "Collection should be empty.";

    private static final String MSG_COLLECTION_IS_NOT_EMPTY = "Collection should not be empty.";

    private static final String MSG_COLLECTION_CONTAINS = "Collection should contain the expected value.";

    private static final String MSG_COLLECTION_DOES_NOT_CONTAIN = "Collection should not contain the expected value.";

    private static final String MSG_COLLECTION_CONTAINS_ALL = "Collection should contain all of the expected values.";

    private static final String MSG_COLLECTION_CONTAINS_ALL_IN_ANY_ORDER = "Collection should contain all of the expected values in any order.";

    private static final String MSG_COLLECTION_CONTAINS_EXACTLY = "Collection should contain the expected values exactly.";

    private static final String MSG_COLLECTION_CONTAINS_EXACTLY_IN_ANY_ORDER = "Collection should contain the expected values exactly in any order.";

    private static final String MSG_COLLECTION_CONTAINS_ANY = "Collection should contain any of the expected values.";

    private static final String MSG_COLLECTION_CONTAINS_NONE = "Collection should not contain any of the expected values.";

    private FailMessages() {
        super();
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
        return MSG_IS_SAME + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value and the expected value should be different.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsDifferent(final String actual) {
        return MSG_IS_DIFFERENT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be greater than the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsGreater(final String actual, final String expected) {
        return MSG_IS_GREATER + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be greater than or equal to the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsGreaterOrEqual(final String actual, final String expected) {
        return MSG_IS_GREATER_OR_EQUAL + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less than the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsLess(final String actual, final String expected) {
        return MSG_IS_LESS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be less than or equal to the expected value.
     *
     * @param actual   the actual value.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getIsLessOrEqual(final String actual, final String expected) {
        return MSG_IS_LESS_OR_EQUAL + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual value should be zero.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsZero(final String actual) {
        return MSG_IS_ZERO + " " + getValueMessagePart(actual);
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
        return MSG_IS_POSITIVE_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be negative infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNegativeInfinity(final String actual) {
        return MSG_IS_NEGATIVE_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be infinity.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsInfinity(final String actual) {
        return MSG_IS_INFINITY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should be not-a-number.
     *
     * @param actual the actual value.
     * @return the fail message.
     */
    public static String getIsNaN(final String actual) {
        return MSG_IS_NAN + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual value should not be not-a-number.
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
        return MSG_IS_FINITE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the alphabetic symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsAlphabetic(final String actual) {
        return MSG_IS_ALPHABETIC + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the digit.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsDigit(final String actual) {
        return MSG_IS_DIGIT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the letter.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsLetter(final String actual) {
        return MSG_IS_LETTER + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the letter or the digit.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsLetterOrDigit(final String actual) {
        return MSG_IS_LETTER_OR_DIGIT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the control symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsControl(final String actual) {
        return MSG_IS_CONTROL_SYMBOL + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the lower case symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsLowerCase(final String actual) {
        return MSG_IS_LOWER_CASE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the upper case symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsUpperCase(final String actual) {
        return MSG_IS_UPPER_CASE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual character should be the whitespace symbol.
     *
     * @param actual the actual character.
     * @return the fail message.
     */
    public static String getIsWhitespace(final String actual) {
        return MSG_IS_WHITESPACE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual object should be null.
     *
     * @param actual the actual object.
     * @return the fail message.
     */
    public static String getIsNull(final String actual) {
        return MSG_IS_NULL + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual object should not be null.
     *
     * @return the fail message.
     */
    public static String getIsNotNull() {
        return MSG_IS_NOT_NULL;
    }

    /**
     * Get the fail message if the actual array should be empty.
     *
     * @param actual the actual array.
     * @return the fail message.
     */
    public static String getArrayIsEmpty(final String actual) {
        return MSG_ARRAY_IS_EMPTY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual array should not be empty.
     *
     * @return the fail message.
     */
    public static String getArrayIsNotEmpty() {
        return MSG_ARRAY_IS_NOT_EMPTY;
    }

    /**
     * Get the fail message if the actual class should be the subtype of the expected class.
     *
     * @param actual   the actual class.
     * @param expected the expected class.
     * @return the fail message.
     */
    public static String getClassIsSubtypeOf(final String actual, final String expected) {
        return MSG_CLASS_IS_SUBTYPE_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual class should not be the subtype of the expected class.
     *
     * @param actual   the actual class.
     * @param expected the expected class.
     * @return the fail message.
     */
    public static String getClassIsNotSubtypeOf(final String actual, final String expected) {
        return MSG_CLASS_IS_NOT_SUBTYPE_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual class should have the default constructor.
     *
     * @param actual the actual class.
     * @return the fail message.
     */
    public static String getConstructorIsDefault(final String actual) {
        return MSG_CONSTRUCTOR_IS_DEFAULT + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual class constructor should not be accessible.
     *
     * @param actual the actual class.
     * @return the fail message.
     */
    public static String getConstructorIsNotAccessible(final String actual) {
        return MSG_CONSTRUCTOR_IS_NOT_ACCESSIBLE + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual class should be the enum class.
     *
     * @param actual the actual class.
     * @return the fail message.
     */
    public static String getIsEnumClass(final String actual) {
        return MSG_IS_ENUM_CLASS + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual string should contain the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringContains(final String actual, final String expected) {
        return MSG_STRING_CONTAINS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not contain the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringDoesNotContain(final String actual, final String expected) {
        return MSG_STRING_DOES_NOT_CONTAIN + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should be the part of the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringIsPartOf(final String actual, final String expected) {
        return MSG_STRING_IS_PART_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not be the part of the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringIsNotPartOf(final String actual, final String expected) {
        return MSG_STRING_IS_NOT_PART_OF + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should match the expected regexp.
     *
     * @param actual   the actual string.
     * @param expected the expected regexp.
     * @return the fail message.
     */
    public static String getStringMatches(final String actual, final String expected) {
        return MSG_STRING_MATCHES + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not match the expected regexp.
     *
     * @param actual   the actual string.
     * @param expected the expected regexp.
     * @return the fail message.
     */
    public static String getStringDoesNotMatch(final String actual, final String expected) {
        return MSG_STRING_DOES_NOT_MATCH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should start with the expected string.
     *
     * @param actual   the actual should.
     * @param expected the expected should.
     * @return the fail message.
     */
    public static String getStringStartsWith(final String actual, final String expected) {
        return MSG_STRING_STARTS_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not start with the expected string.
     *
     * @param actual   the actual should.
     * @param expected the expected should.
     * @return the fail message.
     */
    public static String getStringDoesNotStartWith(final String actual, final String expected) {
        return MSG_STRING_DOES_NOT_START_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should end with the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringEndsWith(final String actual, final String expected) {
        return MSG_STRING_ENDS_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual string should not end with the expected string.
     *
     * @param actual   the actual string.
     * @param expected the expected string.
     * @return the fail message.
     */
    public static String getStringDoesNotEndWith(final String actual, final String expected) {
        return MSG_STRING_DOES_NOT_END_WITH + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should be empty.
     *
     * @param actual the actual collection.
     * @return the fail message.
     */
    public static String getCollectionIsEmpty(final String actual) {
        return MSG_COLLECTION_IS_EMPTY + " " + getValueMessagePart(actual);
    }

    /**
     * Get the fail message if the actual collection should not be empty.
     *
     * @return the fail message.
     */
    public static String getCollectionIsNotEmpty() {
        return MSG_COLLECTION_IS_NOT_EMPTY;
    }

    /**
     * Get the fail message if the actual collection should contain the expected value.
     *
     * @param actual   the actual collection.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getCollectionContains(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should not contain the expected value.
     *
     * @param actual   the actual collection.
     * @param expected the expected value.
     * @return the fail message.
     */
    public static String getCollectionDoesNotContain(final String actual, final String expected) {
        return MSG_COLLECTION_DOES_NOT_CONTAIN + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should contain all of the expected values.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsAll(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_ALL + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should contain all of the expected values in any order.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsAllInAnyOrder(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_ALL_IN_ANY_ORDER + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should contain the expected values exactly.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsExactly(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_EXACTLY + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should contain the expected values exactly in any order.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsExactlyInAnyOrder(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_EXACTLY_IN_ANY_ORDER + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should contain any of the expected values.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsAny(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_ANY + " " + getValueMessagePart(actual, expected);
    }

    /**
     * Get the fail message if the actual collection should not contain any of the expected values.
     *
     * @param actual   the actual collection.
     * @param expected the expected values.
     * @return the fail message.
     */
    public static String getCollectionContainsNone(final String actual, final String expected) {
        return MSG_COLLECTION_CONTAINS_NONE + " " + getValueMessagePart(actual, expected);
    }

    private static String getValueMessagePart(final String actual) {
        return "Actual:<" + actual + ">";
    }

    private static String getValueMessagePart(final String actual, final String expected) {
        return "Expected:<" + expected + "> but was:<" + actual + ">";
    }

}
