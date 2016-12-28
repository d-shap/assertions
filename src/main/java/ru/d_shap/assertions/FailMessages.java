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

    private static final String MSG_NULL = "Value should be null.";

    private static final String MSG_NOT_NULL = "Value should not be null.";

    private static final String MSG_ARRAY_EMPTY = "Value should be the empty array.";

    private static final String MSG_ARRAY_NOT_EMPTY = "Value should not be the empty array.";

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

    private static String getValueMessagePart(final String actual) {
        return "Actual:<" + actual + ">";
    }

    private static String getValueMessagePart(final String actual, final String expected) {
        return "Expected:<" + expected + "> but was:<" + actual + ">";
    }

}
