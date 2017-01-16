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
    public void getTrueTest() {
        Assertions.assertThat(FailMessages.getTrue()).isEqualTo("Value should be true.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getFalseTest() {
        Assertions.assertThat(FailMessages.getFalse()).isEqualTo("Value should be false.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getSameTest() {
        Assertions.assertThat(FailMessages.getSame(null, null)).isEqualTo("Values should be the same. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getSame("val1", "val2")).isEqualTo("Values should be the same. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getSame("test1", "test2")).isEqualTo("Values should be the same. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDifferentTest() {
        Assertions.assertThat(FailMessages.getDifferent(null)).isEqualTo("Values should be different. Actual:<null>");
        Assertions.assertThat(FailMessages.getDifferent("val1")).isEqualTo("Values should be different. Actual:<val1>");
        Assertions.assertThat(FailMessages.getDifferent("test1")).isEqualTo("Values should be different. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getGreaterTest() {
        Assertions.assertThat(FailMessages.getGreater(null, null)).isEqualTo("Value should be greater then the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getGreater("val1", "val2")).isEqualTo("Value should be greater then the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getGreater("test1", "test2")).isEqualTo("Value should be greater then the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getGreaterOrEqualTest() {
        Assertions.assertThat(FailMessages.getGreaterOrEqual(null, null)).isEqualTo("Value should be greater then or equal to the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getGreaterOrEqual("val1", "val2")).isEqualTo("Value should be greater then or equal to the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getGreaterOrEqual("test1", "test2")).isEqualTo("Value should be greater then or equal to the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getLessTest() {
        Assertions.assertThat(FailMessages.getLess(null, null)).isEqualTo("Value should be less then the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getLess("val1", "val2")).isEqualTo("Value should be less then the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getLess("test1", "test2")).isEqualTo("Value should be less then the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getLessOrEqualTest() {
        Assertions.assertThat(FailMessages.getLessOrEqual(null, null)).isEqualTo("Value should be less then or equal to the expected. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getLessOrEqual("val1", "val2")).isEqualTo("Value should be less then or equal to the expected. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getLessOrEqual("test1", "test2")).isEqualTo("Value should be less then or equal to the expected. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getZeroTest() {
        Assertions.assertThat(FailMessages.getZero(null)).isEqualTo("Value should be zero. Actual:<null>");
        Assertions.assertThat(FailMessages.getZero("val1")).isEqualTo("Value should be zero. Actual:<val1>");
        Assertions.assertThat(FailMessages.getZero("test1")).isEqualTo("Value should be zero. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNonZeroTest() {
        Assertions.assertThat(FailMessages.getNonZero()).isEqualTo("Value should not be zero.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getPositiveInfinityTest() {
        Assertions.assertThat(FailMessages.getPositiveInfinity(null)).isEqualTo("Value should be positive infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getPositiveInfinity("val1")).isEqualTo("Value should be positive infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getPositiveInfinity("test1")).isEqualTo("Value should be positive infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNegativeInfinityTest() {
        Assertions.assertThat(FailMessages.getNegativeInfinity(null)).isEqualTo("Value should be negative infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getNegativeInfinity("val1")).isEqualTo("Value should be negative infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getNegativeInfinity("test1")).isEqualTo("Value should be negative infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getInfinityTest() {
        Assertions.assertThat(FailMessages.getInfinity(null)).isEqualTo("Value should be infinity. Actual:<null>");
        Assertions.assertThat(FailMessages.getInfinity("val1")).isEqualTo("Value should be infinity. Actual:<val1>");
        Assertions.assertThat(FailMessages.getInfinity("test1")).isEqualTo("Value should be infinity. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNaNTest() {
        Assertions.assertThat(FailMessages.getNaN(null)).isEqualTo("Value should be NaN. Actual:<null>");
        Assertions.assertThat(FailMessages.getNaN("val1")).isEqualTo("Value should be NaN. Actual:<val1>");
        Assertions.assertThat(FailMessages.getNaN("test1")).isEqualTo("Value should be NaN. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNotNaNTest() {
        Assertions.assertThat(FailMessages.getNotNaN()).isEqualTo("Value should not be NaN.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getFiniteTest() {
        Assertions.assertThat(FailMessages.getFinite(null)).isEqualTo("Value should be finite. Actual:<null>");
        Assertions.assertThat(FailMessages.getFinite("val1")).isEqualTo("Value should be finite. Actual:<val1>");
        Assertions.assertThat(FailMessages.getFinite("test1")).isEqualTo("Value should be finite. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getAlphabeticTest() {
        Assertions.assertThat(FailMessages.getAlphabetic(null)).isEqualTo("Character should be the alphabetic symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getAlphabetic("val1")).isEqualTo("Character should be the alphabetic symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getAlphabetic("test1")).isEqualTo("Character should be the alphabetic symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getDigitTest() {
        Assertions.assertThat(FailMessages.getDigit(null)).isEqualTo("Character should be the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getDigit("val1")).isEqualTo("Character should be the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getDigit("test1")).isEqualTo("Character should be the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getLetterTest() {
        Assertions.assertThat(FailMessages.getLetter(null)).isEqualTo("Character should be the letter. Actual:<null>");
        Assertions.assertThat(FailMessages.getLetter("val1")).isEqualTo("Character should be the letter. Actual:<val1>");
        Assertions.assertThat(FailMessages.getLetter("test1")).isEqualTo("Character should be the letter. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getLetterOrDigitTest() {
        Assertions.assertThat(FailMessages.getLetterOrDigit(null)).isEqualTo("Character should be the letter or the digit. Actual:<null>");
        Assertions.assertThat(FailMessages.getLetterOrDigit("val1")).isEqualTo("Character should be the letter or the digit. Actual:<val1>");
        Assertions.assertThat(FailMessages.getLetterOrDigit("test1")).isEqualTo("Character should be the letter or the digit. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getControlTest() {
        Assertions.assertThat(FailMessages.getControl(null)).isEqualTo("Character should be the control symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getControl("val1")).isEqualTo("Character should be the control symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getControl("test1")).isEqualTo("Character should be the control symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getLowerCaseTest() {
        Assertions.assertThat(FailMessages.getLowerCase(null)).isEqualTo("Character should be the lower case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getLowerCase("val1")).isEqualTo("Character should be the lower case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getLowerCase("test1")).isEqualTo("Character should be the lower case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getUpperCaseTest() {
        Assertions.assertThat(FailMessages.getUpperCase(null)).isEqualTo("Character should be the upper case symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getUpperCase("val1")).isEqualTo("Character should be the upper case symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getUpperCase("test1")).isEqualTo("Character should be the upper case symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getWhitespaceTest() {
        Assertions.assertThat(FailMessages.getWhitespace(null)).isEqualTo("Character should be the whitespace symbol. Actual:<null>");
        Assertions.assertThat(FailMessages.getWhitespace("val1")).isEqualTo("Character should be the whitespace symbol. Actual:<val1>");
        Assertions.assertThat(FailMessages.getWhitespace("test1")).isEqualTo("Character should be the whitespace symbol. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNullTest() {
        Assertions.assertThat(FailMessages.getNull(null)).isEqualTo("Object should be null. Actual:<null>");
        Assertions.assertThat(FailMessages.getNull("val1")).isEqualTo("Object should be null. Actual:<val1>");
        Assertions.assertThat(FailMessages.getNull("test1")).isEqualTo("Object should be null. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getNotNullTest() {
        Assertions.assertThat(FailMessages.getNotNull()).isEqualTo("Object should not be null.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getArrayEmptyTest() {
        Assertions.assertThat(FailMessages.getArrayEmpty(null)).isEqualTo("Array should be empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getArrayEmpty("val1")).isEqualTo("Array should be empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getArrayEmpty("test1")).isEqualTo("Array should be empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getArrayNotEmptyTest() {
        Assertions.assertThat(FailMessages.getArrayNotEmpty()).isEqualTo("Array should not be empty.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getClassSubtypeTest() {
        Assertions.assertThat(FailMessages.getClassSubtype(null, null)).isEqualTo("Class should be the subtype of the expected class. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getClassSubtype("val1", "val2")).isEqualTo("Class should be the subtype of the expected class. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getClassSubtype("test1", "test2")).isEqualTo("Class should be the subtype of the expected class. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getClassNotSubtypeTest() {
        Assertions.assertThat(FailMessages.getClassNotSubtype(null, null)).isEqualTo("Class should not be the subtype of the expected class. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getClassNotSubtype("val1", "val2")).isEqualTo("Class should not be the subtype of the expected class. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getClassNotSubtype("test1", "test2")).isEqualTo("Class should not be the subtype of the expected class. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getConstructorDefaultTest() {
        Assertions.assertThat(FailMessages.getConstructorDefault(null)).isEqualTo("Class should have one default constructor. Actual:<null>");
        Assertions.assertThat(FailMessages.getConstructorDefault("val1")).isEqualTo("Class should have one default constructor. Actual:<val1>");
        Assertions.assertThat(FailMessages.getConstructorDefault("test1")).isEqualTo("Class should have one default constructor. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getConstructorNotAccessibleTest() {
        Assertions.assertThat(FailMessages.getConstructorNotAccessible(null)).isEqualTo("Class constructor should not be acccessible. Actual:<null>");
        Assertions.assertThat(FailMessages.getConstructorNotAccessible("val1")).isEqualTo("Class constructor should not be acccessible. Actual:<val1>");
        Assertions.assertThat(FailMessages.getConstructorNotAccessible("test1")).isEqualTo("Class constructor should not be acccessible. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getEnumClassTest() {
        Assertions.assertThat(FailMessages.getEnumClass(null)).isEqualTo("Class should be the enum class. Actual:<null>");
        Assertions.assertThat(FailMessages.getEnumClass("val1")).isEqualTo("Class should be the enum class. Actual:<val1>");
        Assertions.assertThat(FailMessages.getEnumClass("test1")).isEqualTo("Class should be the enum class. Actual:<test1>");
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
    public void getStringNotContainsTest() {
        Assertions.assertThat(FailMessages.getStringNotContains(null, null)).isEqualTo("String should not contain the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringNotContains("val1", "val2")).isEqualTo("String should not contain the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringNotContains("test1", "test2")).isEqualTo("String should not contain the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringPartOfTest() {
        Assertions.assertThat(FailMessages.getStringPartOf(null, null)).isEqualTo("String should be the part of the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringPartOf("val1", "val2")).isEqualTo("String should be the part of the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringPartOf("test1", "test2")).isEqualTo("String should be the part of the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getStringNotPartOfTest() {
        Assertions.assertThat(FailMessages.getStringNotPartOf(null, null)).isEqualTo("String should not be the part of the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringNotPartOf("val1", "val2")).isEqualTo("String should not be the part of the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringNotPartOf("test1", "test2")).isEqualTo("String should not be the part of the expected string. Expected:<test2> but was:<test1>");
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
    public void getStringNotMatchesTest() {
        Assertions.assertThat(FailMessages.getStringNotMatches(null, null)).isEqualTo("String should not match the expected regexp. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringNotMatches("val1", "val2")).isEqualTo("String should not match the expected regexp. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringNotMatches("test1", "test2")).isEqualTo("String should not match the expected regexp. Expected:<test2> but was:<test1>");
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
    public void getStringNotStartsWithTest() {
        Assertions.assertThat(FailMessages.getStringNotStartsWith(null, null)).isEqualTo("String should not start with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringNotStartsWith("val1", "val2")).isEqualTo("String should not start with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringNotStartsWith("test1", "test2")).isEqualTo("String should not start with the expected string. Expected:<test2> but was:<test1>");
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
    public void getStringNotEndsWithTest() {
        Assertions.assertThat(FailMessages.getStringNotEndsWith(null, null)).isEqualTo("String should not end with the expected string. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getStringNotEndsWith("val1", "val2")).isEqualTo("String should not end with the expected string. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getStringNotEndsWith("test1", "test2")).isEqualTo("String should not end with the expected string. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionEmptyTest() {
        Assertions.assertThat(FailMessages.getCollectionEmpty(null)).isEqualTo("Collection should be empty. Actual:<null>");
        Assertions.assertThat(FailMessages.getCollectionEmpty("val1")).isEqualTo("Collection should be empty. Actual:<val1>");
        Assertions.assertThat(FailMessages.getCollectionEmpty("test1")).isEqualTo("Collection should be empty. Actual:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionNotEmptyTest() {
        Assertions.assertThat(FailMessages.getCollectionNotEmpty()).isEqualTo("Collection should not be empty.");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasValueTest() {
        Assertions.assertThat(FailMessages.getCollectionHasValue(null, null)).isEqualTo("Collection should contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasValue("val1", "val2")).isEqualTo("Collection should contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasValue("test1", "test2")).isEqualTo("Collection should contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasNotValueTest() {
        Assertions.assertThat(FailMessages.getCollectionHasNotValue(null, null)).isEqualTo("Collection should not contain the expected value. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasNotValue("val1", "val2")).isEqualTo("Collection should not contain the expected value. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasNotValue("test1", "test2")).isEqualTo("Collection should not contain the expected value. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasAllValuesTest() {
        Assertions.assertThat(FailMessages.getCollectionHasAllValues(null, null)).isEqualTo("Collection should contain all expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasAllValues("val1", "val2")).isEqualTo("Collection should contain all expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasAllValues("test1", "test2")).isEqualTo("Collection should contain all expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasAllValuesInAnyOrderTest() {
        Assertions.assertThat(FailMessages.getCollectionHasAllValuesInAnyOrder(null, null)).isEqualTo("Collection should contain all expected values in any order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasAllValuesInAnyOrder("val1", "val2")).isEqualTo("Collection should contain all expected values in any order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasAllValuesInAnyOrder("test1", "test2")).isEqualTo("Collection should contain all expected values in any order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasExactValuesTest() {
        Assertions.assertThat(FailMessages.getCollectionHasExactValues(null, null)).isEqualTo("Collection should contain the exact expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasExactValues("val1", "val2")).isEqualTo("Collection should contain the exact expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasExactValues("test1", "test2")).isEqualTo("Collection should contain the exact expected values. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasExactValuesInAnyOrderTest() {
        Assertions.assertThat(FailMessages.getCollectionHasExactValuesInAnyOrder(null, null)).isEqualTo("Collection should contain the exact expected values in any order. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasExactValuesInAnyOrder("val1", "val2")).isEqualTo("Collection should contain the exact expected values in any order. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasExactValuesInAnyOrder("test1", "test2")).isEqualTo("Collection should contain the exact expected values in any order. Expected:<test2> but was:<test1>");
    }

    /**
     * {@link FailMessages} class test.
     */
    @Test
    public void getCollectionHasAnyValueTest() {
        Assertions.assertThat(FailMessages.getCollectionHasAnyValue(null, null)).isEqualTo("Collection should contain any of the expected values. Expected:<null> but was:<null>");
        Assertions.assertThat(FailMessages.getCollectionHasAnyValue("val1", "val2")).isEqualTo("Collection should contain any of the expected values. Expected:<val2> but was:<val1>");
        Assertions.assertThat(FailMessages.getCollectionHasAnyValue("test1", "test2")).isEqualTo("Collection should contain any of the expected values. Expected:<test2> but was:<test1>");
    }

}
