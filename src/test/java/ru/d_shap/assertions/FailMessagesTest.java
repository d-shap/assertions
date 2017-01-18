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

import org.junit.Test;

/**
 * Tests for {@link FailMessages}.
 *
 * @author Dmitry Shapovalov
 */
public final class FailMessagesTest {

    /**
     * Test class constructor.
     */
    public FailMessagesTest() {
        super();
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(FailMessages.class).hasOnePrivateConstructor();
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsTrueTest() {
        Assertions.assertThat(FailMessages.getIsTrue()).isEqualTo("Value should be true.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsFalseTest() {
        Assertions.assertThat(FailMessages.getIsFalse()).isEqualTo("Value should be false.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsSameTest() {
        Assertions.assertThat(FailMessages.getIsSame(null, null)).isEqualTo("Values should be the same. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsSame("val1", "val2")).isEqualTo("Values should be the same. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsSame("test1", "test2")).isEqualTo("Values should be the same. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsDifferentTest() {
        Assertions.assertThat(FailMessages.getIsDifferent(null)).isEqualTo("Values should be different. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsDifferent("val1")).isEqualTo("Values should be different. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsDifferent("test1")).isEqualTo("Values should be different. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsGreaterTest() {
        Assertions.assertThat(FailMessages.getIsGreater(null, null)).isEqualTo("Value should be greater then the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsGreater("val1", "val2")).isEqualTo("Value should be greater then the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsGreater("test1", "test2")).isEqualTo("Value should be greater then the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsGreaterOrEqualTest() {
        Assertions.assertThat(FailMessages.getIsGreaterOrEqual(null, null)).isEqualTo("Value should be greater then or equal to the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsGreaterOrEqual("val1", "val2")).isEqualTo("Value should be greater then or equal to the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsGreaterOrEqual("test1", "test2")).isEqualTo("Value should be greater then or equal to the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLessTest() {
        Assertions.assertThat(FailMessages.getIsLess(null, null)).isEqualTo("Value should be less then the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsLess("val1", "val2")).isEqualTo("Value should be less then the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsLess("test1", "test2")).isEqualTo("Value should be less then the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLessOrEqualTest() {
        Assertions.assertThat(FailMessages.getIsLessOrEqual(null, null)).isEqualTo("Value should be less then or equal to the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsLessOrEqual("val1", "val2")).isEqualTo("Value should be less then or equal to the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsLessOrEqual("test1", "test2")).isEqualTo("Value should be less then or equal to the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsZeroTest() {
        Assertions.assertThat(FailMessages.getIsZero(null)).isEqualTo("Value should be zero. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsZero("val1")).isEqualTo("Value should be zero. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsZero("test1")).isEqualTo("Value should be zero. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNonZeroTest() {
        Assertions.assertThat(FailMessages.getIsNonZero()).isEqualTo("Value should not be zero.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsPositiveInfinityTest() {
        Assertions.assertThat(FailMessages.getIsPositiveInfinity(null)).isEqualTo("Value should be positive infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsPositiveInfinity("val1")).isEqualTo("Value should be positive infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsPositiveInfinity("test1")).isEqualTo("Value should be positive infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNegativeInfinityTest() {
        Assertions.assertThat(FailMessages.getIsNegativeInfinity(null)).isEqualTo("Value should be negative infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNegativeInfinity("val1")).isEqualTo("Value should be negative infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNegativeInfinity("test1")).isEqualTo("Value should be negative infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsInfinityTest() {
        Assertions.assertThat(FailMessages.getIsInfinity(null)).isEqualTo("Value should be infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsInfinity("val1")).isEqualTo("Value should be infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsInfinity("test1")).isEqualTo("Value should be infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNaNTest() {
        Assertions.assertThat(FailMessages.getIsNaN(null)).isEqualTo("Value should be NaN. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNaN("val1")).isEqualTo("Value should be NaN. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNaN("test1")).isEqualTo("Value should be NaN. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotNaNTest() {
        Assertions.assertThat(FailMessages.getIsNotNaN()).isEqualTo("Value should not be NaN.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsFiniteTest() {
        Assertions.assertThat(FailMessages.getIsFinite(null)).isEqualTo("Value should be finite. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsFinite("val1")).isEqualTo("Value should be finite. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsFinite("test1")).isEqualTo("Value should be finite. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsAlphabeticTest() {
        Assertions.assertThat(FailMessages.getIsAlphabetic(null)).isEqualTo("Character should be the alphabetic symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsAlphabetic("val1")).isEqualTo("Character should be the alphabetic symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsAlphabetic("test1")).isEqualTo("Character should be the alphabetic symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsDigitTest() {
        Assertions.assertThat(FailMessages.getIsDigit(null)).isEqualTo("Character should be the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsDigit("val1")).isEqualTo("Character should be the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsDigit("test1")).isEqualTo("Character should be the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLetterTest() {
        Assertions.assertThat(FailMessages.getIsLetter(null)).isEqualTo("Character should be the letter. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLetter("val1")).isEqualTo("Character should be the letter. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLetter("test1")).isEqualTo("Character should be the letter. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLetterOrDigitTest() {
        Assertions.assertThat(FailMessages.getIsLetterOrDigit(null)).isEqualTo("Character should be the letter or the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLetterOrDigit("val1")).isEqualTo("Character should be the letter or the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLetterOrDigit("test1")).isEqualTo("Character should be the letter or the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsControlTest() {
        Assertions.assertThat(FailMessages.getIsControl(null)).isEqualTo("Character should be the control symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsControl("val1")).isEqualTo("Character should be the control symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsControl("test1")).isEqualTo("Character should be the control symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLowerCaseTest() {
        Assertions.assertThat(FailMessages.getIsLowerCase(null)).isEqualTo("Character should be the lower case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLowerCase("val1")).isEqualTo("Character should be the lower case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLowerCase("test1")).isEqualTo("Character should be the lower case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsUpperCaseTest() {
        Assertions.assertThat(FailMessages.getIsUpperCase(null)).isEqualTo("Character should be the upper case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsUpperCase("val1")).isEqualTo("Character should be the upper case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsUpperCase("test1")).isEqualTo("Character should be the upper case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsWhitespaceTest() {
        Assertions.assertThat(FailMessages.getIsWhitespace(null)).isEqualTo("Character should be the whitespace symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsWhitespace("val1")).isEqualTo("Character should be the whitespace symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsWhitespace("test1")).isEqualTo("Character should be the whitespace symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNullTest() {
        Assertions.assertThat(FailMessages.getIsNull(null)).isEqualTo("Object should be null. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNull("val1")).isEqualTo("Object should be null. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNull("test1")).isEqualTo("Object should be null. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotNullTest() {
        Assertions.assertThat(FailMessages.getIsNotNull()).isEqualTo("Object should not be null.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getArrayIsEmptyTest() {
        Assertions.assertThat(FailMessages.getArrayIsEmpty(null)).isEqualTo("Array should be empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getArrayIsEmpty("val1")).isEqualTo("Array should be empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getArrayIsEmpty("test1")).isEqualTo("Array should be empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getArrayIsNotEmptyTest() {
        Assertions.assertThat(FailMessages.getArrayIsNotEmpty()).isEqualTo("Array should not be empty.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getClassIsSubtypeOfTest() {
        Assertions.assertThat(FailMessages.getClassIsSubtypeOf(null, null)).isEqualTo("Class should be the subtype of the expected class. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getClassIsSubtypeOf("val1", "val2")).isEqualTo("Class should be the subtype of the expected class. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getClassIsSubtypeOf("test1", "test2")).isEqualTo("Class should be the subtype of the expected class. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getClassIsNotSubtypeOfTest() {
        Assertions.assertThat(FailMessages.getClassIsNotSubtypeOf(null, null)).isEqualTo("Class should not be the subtype of the expected class. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getClassIsNotSubtypeOf("val1", "val2")).isEqualTo("Class should not be the subtype of the expected class. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getClassIsNotSubtypeOf("test1", "test2")).isEqualTo("Class should not be the subtype of the expected class. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getConstructorIsDefaultTest() {
        Assertions.assertThat(FailMessages.getConstructorIsDefault(null)).isEqualTo("Class should have one default constructor. Actual:<null>");
        Assertions.assertThat(FailMessages.getConstructorIsDefault("val1")).isEqualTo("Class should have one default constructor. Actual:<val1>");
        Assertions.assertThat(FailMessages.getConstructorIsDefault("test1")).isEqualTo("Class should have one default constructor. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getConstructorIsNotAccessibleTest() {
        Assertions.assertThat(FailMessages.getConstructorIsNotAccessible(null)).isEqualTo("Class constructor should not be acccessible. Actual:<null>");
        Assertions.assertThat(FailMessages.getConstructorIsNotAccessible("val1")).isEqualTo("Class constructor should not be acccessible. Actual:<val1>");
        Assertions.assertThat(FailMessages.getConstructorIsNotAccessible("test1")).isEqualTo("Class constructor should not be acccessible. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsEnumClassTest() {
        Assertions.assertThat(FailMessages.getIsEnumClass(null)).isEqualTo("Class should be the enum class. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsEnumClass("val1")).isEqualTo("Class should be the enum class. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsEnumClass("test1")).isEqualTo("Class should be the enum class. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringContainsTest() {
        Assertions.assertThat(FailMessages.getStringContains(null, null)).isEqualTo("String should contain the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringContains("val1", "val2")).isEqualTo("String should contain the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringContains("test1", "test2")).isEqualTo("String should contain the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringDoesNotContainTest() {
        Assertions.assertThat(FailMessages.getStringDoesNotContain(null, null)).isEqualTo("String should not contain the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringDoesNotContain("val1", "val2")).isEqualTo("String should not contain the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringDoesNotContain("test1", "test2")).isEqualTo("String should not contain the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringIsPartOfTest() {
        Assertions.assertThat(FailMessages.getStringIsPartOf(null, null)).isEqualTo("String should be the part of the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringIsPartOf("val1", "val2")).isEqualTo("String should be the part of the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringIsPartOf("test1", "test2")).isEqualTo("String should be the part of the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringIsNotPartOfTest() {
        Assertions.assertThat(FailMessages.getStringIsNotPartOf(null, null)).isEqualTo("String should not be the part of the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringIsNotPartOf("val1", "val2")).isEqualTo("String should not be the part of the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringIsNotPartOf("test1", "test2")).isEqualTo("String should not be the part of the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringMatchesTest() {
        Assertions.assertThat(FailMessages.getStringMatches(null, null)).isEqualTo("String should match the expected regexp. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringMatches("val1", "val2")).isEqualTo("String should match the expected regexp. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringMatches("test1", "test2")).isEqualTo("String should match the expected regexp. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringDoesNotMatchTest() {
        Assertions.assertThat(FailMessages.getStringDoesNotMatch(null, null)).isEqualTo("String should not match the expected regexp. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringDoesNotMatch("val1", "val2")).isEqualTo("String should not match the expected regexp. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringDoesNotMatch("test1", "test2")).isEqualTo("String should not match the expected regexp. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringStartsWithTest() {
        Assertions.assertThat(FailMessages.getStringStartsWith(null, null)).isEqualTo("String should start with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringStartsWith("val1", "val2")).isEqualTo("String should start with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringStartsWith("test1", "test2")).isEqualTo("String should start with the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringDoesNotStartWithTest() {
        Assertions.assertThat(FailMessages.getStringDoesNotStartWith(null, null)).isEqualTo("String should not start with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringDoesNotStartWith("val1", "val2")).isEqualTo("String should not start with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringDoesNotStartWith("test1", "test2")).isEqualTo("String should not start with the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringEndsWithTest() {
        Assertions.assertThat(FailMessages.getStringEndsWith(null, null)).isEqualTo("String should end with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringEndsWith("val1", "val2")).isEqualTo("String should end with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringEndsWith("test1", "test2")).isEqualTo("String should end with the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringDoesNotEndWithTest() {
        Assertions.assertThat(FailMessages.getStringDoesNotEndWith(null, null)).isEqualTo("String should not end with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringDoesNotEndWith("val1", "val2")).isEqualTo("String should not end with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringDoesNotEndWith("test1", "test2")).isEqualTo("String should not end with the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionIsEmptyTest() {
        Assertions.assertThat(FailMessages.getCollectionIsEmpty(null)).isEqualTo("Collection should be empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getCollectionIsEmpty("val1")).isEqualTo("Collection should be empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getCollectionIsEmpty("test1")).isEqualTo("Collection should be empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionIsNotEmptyTest() {
        Assertions.assertThat(FailMessages.getCollectionIsNotEmpty()).isEqualTo("Collection should not be empty.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsTest() {
        Assertions.assertThat(FailMessages.getCollectionContains(null, null)).isEqualTo("Collection should contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContains("val1", "val2")).isEqualTo("Collection should contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContains("test1", "test2")).isEqualTo("Collection should contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionDoesNotContainTest() {
        Assertions.assertThat(FailMessages.getCollectionDoesNotContain(null, null)).isEqualTo("Collection should not contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionDoesNotContain("val1", "val2")).isEqualTo("Collection should not contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionDoesNotContain("test1", "test2")).isEqualTo("Collection should not contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsAllTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsAll(null, null)).isEqualTo("Collection should contain all of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsAll("val1", "val2")).isEqualTo("Collection should contain all of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsAll("test1", "test2")).isEqualTo("Collection should contain all of the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsAllInAnyOrderTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsAllInAnyOrder(null, null)).isEqualTo("Collection should contain all of the expected values in any order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsAllInAnyOrder("val1", "val2")).isEqualTo("Collection should contain all of the expected values in any order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsAllInAnyOrder("test1", "test2")).isEqualTo("Collection should contain all of the expected values in any order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsExactlyTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsExactly(null, null)).isEqualTo("Collection should contain exactly the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsExactly("val1", "val2")).isEqualTo("Collection should contain exactly the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsExactly("test1", "test2")).isEqualTo("Collection should contain exactly the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsExactlyInAnyOrderTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsExactlyInAnyOrder(null, null)).isEqualTo("Collection should contain exactly the expected values in any order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsExactlyInAnyOrder("val1", "val2")).isEqualTo("Collection should contain exactly the expected values in any order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsExactlyInAnyOrder("test1", "test2")).isEqualTo("Collection should contain exactly the expected values in any order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsAnyTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsAny(null, null)).isEqualTo("Collection should contain any of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsAny("val1", "val2")).isEqualTo("Collection should contain any of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsAny("test1", "test2")).isEqualTo("Collection should contain any of the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionContainsNoneTest() {
        Assertions.assertThat(FailMessages.getCollectionContainsNone(null, null)).isEqualTo("Collection should not contain any of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionContainsNone("val1", "val2")).isEqualTo("Collection should not contain any of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionContainsNone("test1", "test2")).isEqualTo("Collection should not contain any of the expected values. Expected:<test2> but was:<test1>");
    }

}
