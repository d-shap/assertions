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
    public void getArgumentIsNotNullTest() {
        Assertions.assertThat(FailMessages.getArgumentIsNotNull()).isEqualTo("Argument should not be null.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getArgumentIsNotEmptyTest() {
        Assertions.assertThat(FailMessages.getArgumentIsNotEmpty()).isEqualTo("Argument should not be empty.");
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
    public void getIsInRangeTest() {
        Assertions.assertThat(FailMessages.getIsInRange(null, null, null)).isEqualTo("Value should be in the expected range. Expected:<null:null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsInRange("val1", "val2", "val3")).isEqualTo("Value should be in the expected range. Expected:<val2:val3> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsInRange("test1", "test2", "test3")).isEqualTo("Value should be in the expected range. Expected:<test2:test3> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotInRangeTest() {
        Assertions.assertThat(FailMessages.getIsNotInRange(null, null, null)).isEqualTo("Value should not be in the expected range. Expected:<null:null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsNotInRange("val1", "val2", "val3")).isEqualTo("Value should not be in the expected range. Expected:<val2:val3> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsNotInRange("test1", "test2", "test3")).isEqualTo("Value should not be in the expected range. Expected:<test2:test3> but was:<test1>");
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
        Assertions.assertThat(FailMessages.getIsAlphabetic(null)).isEqualTo("Value should be the alphabetic symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsAlphabetic("val1")).isEqualTo("Value should be the alphabetic symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsAlphabetic("test1")).isEqualTo("Value should be the alphabetic symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsDigitTest() {
        Assertions.assertThat(FailMessages.getIsDigit(null)).isEqualTo("Value should be the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsDigit("val1")).isEqualTo("Value should be the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsDigit("test1")).isEqualTo("Value should be the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLetterTest() {
        Assertions.assertThat(FailMessages.getIsLetter(null)).isEqualTo("Value should be the letter. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLetter("val1")).isEqualTo("Value should be the letter. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLetter("test1")).isEqualTo("Value should be the letter. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLetterOrDigitTest() {
        Assertions.assertThat(FailMessages.getIsLetterOrDigit(null)).isEqualTo("Value should be the letter or the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLetterOrDigit("val1")).isEqualTo("Value should be the letter or the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLetterOrDigit("test1")).isEqualTo("Value should be the letter or the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsControlTest() {
        Assertions.assertThat(FailMessages.getIsControl(null)).isEqualTo("Value should be the control symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsControl("val1")).isEqualTo("Value should be the control symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsControl("test1")).isEqualTo("Value should be the control symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsLowerCaseTest() {
        Assertions.assertThat(FailMessages.getIsLowerCase(null)).isEqualTo("Value should be the lower case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsLowerCase("val1")).isEqualTo("Value should be the lower case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsLowerCase("test1")).isEqualTo("Value should be the lower case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsUpperCaseTest() {
        Assertions.assertThat(FailMessages.getIsUpperCase(null)).isEqualTo("Value should be the upper case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsUpperCase("val1")).isEqualTo("Value should be the upper case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsUpperCase("test1")).isEqualTo("Value should be the upper case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsWhitespaceTest() {
        Assertions.assertThat(FailMessages.getIsWhitespace(null)).isEqualTo("Value should be the whitespace symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsWhitespace("val1")).isEqualTo("Value should be the whitespace symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsWhitespace("test1")).isEqualTo("Value should be the whitespace symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNullTest() {
        Assertions.assertThat(FailMessages.getIsNull(null)).isEqualTo("Value should be null. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNull("val1")).isEqualTo("Value should be null. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNull("test1")).isEqualTo("Value should be null. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotNullTest() {
        Assertions.assertThat(FailMessages.getIsNotNull()).isEqualTo("Value should not be null.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsEmptyTest() {
        Assertions.assertThat(FailMessages.getIsEmpty(null)).isEqualTo("Value should be empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsEmpty("val1")).isEqualTo("Value should be empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsEmpty("test1")).isEqualTo("Value should be empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNullOrEmptyTest() {
        Assertions.assertThat(FailMessages.getIsNullOrEmpty(null)).isEqualTo("Value should be null or empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNullOrEmpty("val1")).isEqualTo("Value should be null or empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNullOrEmpty("test1")).isEqualTo("Value should be null or empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotEmptyTest() {
        Assertions.assertThat(FailMessages.getIsNotEmpty()).isEqualTo("Value should not be empty.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsBlankTest() {
        Assertions.assertThat(FailMessages.getIsBlank(null)).isEqualTo("Value should be blank. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsBlank("val1")).isEqualTo("Value should be blank. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsBlank("test1")).isEqualTo("Value should be blank. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNullOrBlankTest() {
        Assertions.assertThat(FailMessages.getIsNullOrBlank(null)).isEqualTo("Value should be null or blank. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsNullOrBlank("val1")).isEqualTo("Value should be null or blank. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsNullOrBlank("test1")).isEqualTo("Value should be null or blank. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotBlankTest() {
        Assertions.assertThat(FailMessages.getIsNotBlank()).isEqualTo("Value should not be blank.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsSubtypeOfTest() {
        Assertions.assertThat(FailMessages.getIsSubtypeOf(null, null)).isEqualTo("Value should be the subtype of the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsSubtypeOf("val1", "val2")).isEqualTo("Value should be the subtype of the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsSubtypeOf("test1", "test2")).isEqualTo("Value should be the subtype of the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotSubtypeOfTest() {
        Assertions.assertThat(FailMessages.getIsNotSubtypeOf(null, null)).isEqualTo("Value should not be the subtype of the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsNotSubtypeOf("val1", "val2")).isEqualTo("Value should not be the subtype of the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsNotSubtypeOf("test1", "test2")).isEqualTo("Value should not be the subtype of the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsConstructorDefaultTest() {
        Assertions.assertThat(FailMessages.getIsConstructorDefault(null)).isEqualTo("Value should have one default constructor. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsConstructorDefault("val1")).isEqualTo("Value should have one default constructor. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsConstructorDefault("test1")).isEqualTo("Value should have one default constructor. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsConstructorNotAccessibleTest() {
        Assertions.assertThat(FailMessages.getIsConstructorNotAccessible(null)).isEqualTo("Value constructor should not be acccessible. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsConstructorNotAccessible("val1")).isEqualTo("Value constructor should not be acccessible. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsConstructorNotAccessible("test1")).isEqualTo("Value constructor should not be acccessible. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsEnumTest() {
        Assertions.assertThat(FailMessages.getIsEnum(null)).isEqualTo("Value should be the enum. Actual:<null>");
        Assertions.assertThat(FailMessages.getIsEnum("val1")).isEqualTo("Value should be the enum. Actual:<val1>");
        Assertions.assertThat(FailMessages.getIsEnum("test1")).isEqualTo("Value should be the enum. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsTest() {
        Assertions.assertThat(FailMessages.getContains(null, null)).isEqualTo("Value should contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContains("val1", "val2")).isEqualTo("Value should contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContains("test1", "test2")).isEqualTo("Value should contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDoesNotContainTest() {
        Assertions.assertThat(FailMessages.getDoesNotContain(null, null)).isEqualTo("Value should not contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getDoesNotContain("val1", "val2")).isEqualTo("Value should not contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getDoesNotContain("test1", "test2")).isEqualTo("Value should not contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsAllTest() {
        Assertions.assertThat(FailMessages.getContainsAll(null, null)).isEqualTo("Value should contain all of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsAll("val1", "val2")).isEqualTo("Value should contain all of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsAll("test1", "test2")).isEqualTo("Value should contain all of the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsAllInOrderTest() {
        Assertions.assertThat(FailMessages.getContainsAllInOrder(null, null)).isEqualTo("Value should contain all of the expected values in the specified order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsAllInOrder("val1", "val2")).isEqualTo("Value should contain all of the expected values in the specified order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsAllInOrder("test1", "test2")).isEqualTo("Value should contain all of the expected values in the specified order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsExactlyTest() {
        Assertions.assertThat(FailMessages.getContainsExactly(null, null)).isEqualTo("Value should contain all of the expected values exactly. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsExactly("val1", "val2")).isEqualTo("Value should contain all of the expected values exactly. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsExactly("test1", "test2")).isEqualTo("Value should contain all of the expected values exactly. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsExactlyInOrderTest() {
        Assertions.assertThat(FailMessages.getContainsExactlyInOrder(null, null)).isEqualTo("Value should contain all of the expected values exactly in the specified order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsExactlyInOrder("val1", "val2")).isEqualTo("Value should contain all of the expected values exactly in the specified order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsExactlyInOrder("test1", "test2")).isEqualTo("Value should contain all of the expected values exactly in the specified order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsAnyTest() {
        Assertions.assertThat(FailMessages.getContainsAny(null, null)).isEqualTo("Value should contain any of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsAny("val1", "val2")).isEqualTo("Value should contain any of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsAny("test1", "test2")).isEqualTo("Value should contain any of the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getContainsNoneTest() {
        Assertions.assertThat(FailMessages.getContainsNone(null, null)).isEqualTo("Value should not contain any of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getContainsNone("val1", "val2")).isEqualTo("Value should not contain any of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getContainsNone("test1", "test2")).isEqualTo("Value should not contain any of the expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsPartOfTest() {
        Assertions.assertThat(FailMessages.getIsPartOf(null, null)).isEqualTo("Value should be the part of the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsPartOf("val1", "val2")).isEqualTo("Value should be the part of the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsPartOf("test1", "test2")).isEqualTo("Value should be the part of the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getIsNotPartOfTest() {
        Assertions.assertThat(FailMessages.getIsNotPartOf(null, null)).isEqualTo("Value should not be the part of the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getIsNotPartOf("val1", "val2")).isEqualTo("Value should not be the part of the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getIsNotPartOf("test1", "test2")).isEqualTo("Value should not be the part of the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getMatchesTest() {
        Assertions.assertThat(FailMessages.getMatches(null, null)).isEqualTo("Value should match the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getMatches("val1", "val2")).isEqualTo("Value should match the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getMatches("test1", "test2")).isEqualTo("Value should match the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDoesNotMatchTest() {
        Assertions.assertThat(FailMessages.getDoesNotMatch(null, null)).isEqualTo("Value should not match the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getDoesNotMatch("val1", "val2")).isEqualTo("Value should not match the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getDoesNotMatch("test1", "test2")).isEqualTo("Value should not match the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStartsWithTest() {
        Assertions.assertThat(FailMessages.getStartsWith(null, null)).isEqualTo("Value should start with the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStartsWith("val1", "val2")).isEqualTo("Value should start with the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStartsWith("test1", "test2")).isEqualTo("Value should start with the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDoesNotStartWithTest() {
        Assertions.assertThat(FailMessages.getDoesNotStartWith(null, null)).isEqualTo("Value should not start with the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getDoesNotStartWith("val1", "val2")).isEqualTo("Value should not start with the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getDoesNotStartWith("test1", "test2")).isEqualTo("Value should not start with the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getEndsWithTest() {
        Assertions.assertThat(FailMessages.getEndsWith(null, null)).isEqualTo("Value should end with the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getEndsWith("val1", "val2")).isEqualTo("Value should end with the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getEndsWith("test1", "test2")).isEqualTo("Value should end with the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDoesNotEndWithTest() {
        Assertions.assertThat(FailMessages.getDoesNotEndWith(null, null)).isEqualTo("Value should not end with the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getDoesNotEndWith("val1", "val2")).isEqualTo("Value should not end with the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getDoesNotEndWith("test1", "test2")).isEqualTo("Value should not end with the expected value. Expected:<test2> but was:<test1>");
    }

}
