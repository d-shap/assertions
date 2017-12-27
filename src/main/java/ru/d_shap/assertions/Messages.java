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
 * Messages for all assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class Messages {

    private Messages() {
        super();
    }

    /**
     * Check messages for all assertions.
     *
     * @author Dmitry Shapovalov
     */
    public static final class Check {

        public static final String ACTUAL_VALUE_CLASS = "Check actual value's class";

        public static final String ACTUAL_VALUE_TO_STRING = "Check actual value's string representation";

        public static final String ACTUAL_VALUE_HASH_CODE = "Check actual value's hash code";

        public static final String ACTUAL_VALUE_FIELD = "Check actual value's field";

        public static final String ACTUAL_VALUE_LENGTH = "Check actual value's length";

        public static final String ACTUAL_VALUE_SIZE = "Check actual value's size";

        public static final String ACTUAL_VALUE_ELEMENTS_ALL = "Check all actual value's elements";

        public static final String ACTUAL_VALUE_ELEMENTS_COUNT = "Check next N actual value's elements";

        public static final String ACTUAL_VALUE_HEAD_ELEMENT = "Check actual value's head elements up to element";

        public static final String ACTUAL_VALUE_HEAD_COUNT = "Check actual value's N head elements";

        public static final String ACTUAL_VALUE_TAIL_ELEMENT = "Check actual value's tail elements from element";

        public static final String ACTUAL_VALUE_TAIL_COUNT = "Check actual value's N tail elements";

        public static final String ACTUAL_VALUE_KEYS = "Check actual value's keys";

        public static final String ACTUAL_VALUE_VALUES = "Check actual value's values";

        public static final String ACTUAL_VALUE_TOKENS = "Check actual value's tokens";

        public static final String ACTUAL_VALUE_MESSAGE = "Check actual value's message";

        public static final String ACTUAL_VALUE_CAUSE = "Check actual value's cause";

        public static final String ACTUAL_VALUE_CONSTANT_COUNT = "Check actual value's constant count";

        public static final String ACTUAL_VALUE_BYTE = "Check next actual value's byte";

        public static final String ACTUAL_VALUE_BYTES_ALL = "Check all actual value's bytes";

        public static final String ACTUAL_VALUE_BYTES_COUNT = "Check next N actual value's bytes";

        public static final String ACTUAL_VALUE_CHAR = "Check next actual value's char";

        public static final String ACTUAL_VALUE_CHARS_ALL = "Check all actual value's chars";

        public static final String ACTUAL_VALUE_CHARS_COUNT = "Check next N actual value's chars";

        public static final String ACTUAL_VALUE_POSITION = "Check actual value's position";

        public static final String ACTUAL_VALUE_LIMIT = "Check actual value's limit";

        public static final String ACTUAL_VALUE_CAPACITY = "Check actual value's capacity";

        public static final String ACTUAL_VALUE_REMAINING = "Check actual value's remaining";

        private Check() {
            super();
        }

    }

    /**
     * Fail messages for all assertions.
     *
     * @author Dmitry Shapovalov
     */
    public static final class Fail {

        public static final String ASSERTION_IS_INITIALIZED = "Assertion should be initialized";

        public static final String ASSERTION_IS_NOT_INITIALIZED = "Assertion should not be initialized";

        public static final String ASSERTION_MATCHES = "Actual value should match the assertion";

        public static final String ARGUMENT_IS_NOT_NULL = "Argument should not be null";

        public static final String ARGUMENT_IS_NOT_EMPTY_TRUE = "Argument should not be empty. The result is always true";

        public static final String ARGUMENT_IS_NOT_EMPTY_FALSE = "Argument should not be empty. The result is always false";

        public static final String ARGUMENT_IS_VALID = "Argument should be valid";

        public static final String IS_TRUE = "Actual value should be true";

        public static final String IS_FALSE = "Actual value should be false";

        public static final String IS_SAME = "Actual and expected values should be the same";

        public static final String IS_SAME_IGNORE_CASE = "Actual and expected values should be the same ignoring case";

        public static final String IS_DIFFERENT = "Actual and expected values should be different";

        public static final String IS_DIFFERENT_IGNORE_CASE = "Actual and expected values should be different ignoring case";

        public static final String IS_GREATER = "Actual value should be greater then the expected";

        public static final String IS_GREATER_IGNORE_CASE = "Actual value should be greater then the expected ignoring case";

        public static final String IS_GREATER_OR_EQUAL = "Actual value should be greater then or equal to the expected";

        public static final String IS_GREATER_OR_EQUAL_IGNORE_CASE = "Actual value should be greater then or equal to the expected ignoring case";

        public static final String IS_LESS = "Actual value should be less then the expected";

        public static final String IS_LESS_IGNORE_CASE = "Actual value should be less then the expected ignoring case";

        public static final String IS_LESS_OR_EQUAL = "Actual value should be less then or equal to the expected";

        public static final String IS_LESS_OR_EQUAL_IGNORE_CASE = "Actual value should be less then or equal to the expected ignoring case";

        public static final String IS_IN_RANGE = "Actual value should be in the expected range";

        public static final String IS_IN_RANGE_IGNORE_CASE = "Actual value should be in the expected range ignoring case";

        public static final String IS_NOT_IN_RANGE = "Actual value should not be in the expected range";

        public static final String IS_NOT_IN_RANGE_IGNORE_CASE = "Actual value should not be in the expected range ignoring case";

        public static final String IS_ZERO = "Actual value should be zero";

        public static final String IS_NON_ZERO = "Actual value should not be zero";

        public static final String IS_POSITIVE_INFINITY = "Actual value should be positive infinity";

        public static final String IS_NEGATIVE_INFINITY = "Actual value should be negative infinity";

        public static final String IS_INFINITY = "Actual value should be infinity";

        public static final String IS_NAN = "Actual value should be NaN";

        public static final String IS_NOT_NAN = "Actual value should not be NaN";

        public static final String IS_FINITE = "Actual value should be finite";

        public static final String IS_ALPHABETIC = "Actual value should be the alphabetic symbol";

        public static final String IS_DIGIT = "Actual value should be the digit";

        public static final String IS_LETTER = "Actual value should be the letter";

        public static final String IS_LETTER_OR_DIGIT = "Actual value should be the letter or the digit";

        public static final String IS_CONTROL_SYMBOL = "Actual value should be the control symbol";

        public static final String IS_LOWER_CASE = "Actual value should be the lower case symbol";

        public static final String IS_UPPER_CASE = "Actual value should be the upper case symbol";

        public static final String IS_WHITESPACE = "Actual value should be the whitespace symbol";

        public static final String IS_NULL = "Actual value should be null";

        public static final String IS_NOT_NULL = "Actual value should not be null";

        public static final String IS_EMPTY = "Actual value should be empty";

        public static final String IS_NULL_OR_EMPTY = "Actual value should be null or empty";

        public static final String IS_NOT_EMPTY = "Actual value should not be empty";

        public static final String IS_BLANK = "Actual value should be blank";

        public static final String IS_NULL_OR_BLANK = "Actual value should be null or blank";

        public static final String IS_NOT_BLANK = "Actual value should not be blank";

        public static final String IS_SUBTYPE_OF = "Actual value should be the subtype of the expected value";

        public static final String IS_NOT_SUBTYPE_OF = "Actual value should not be the subtype of the expected value";

        public static final String IS_CONSTRUCTOR_DEFAULT = "Actual value should have one default constructor";

        public static final String IS_CONSTRUCTOR_NOT_ACCESSIBLE = "Actual value's constructor should not be acccessible";

        public static final String CONTAINS = "Actual value should contain the expected value";

        public static final String CONTAINS_IGNORE_CASE = "Actual value should contain the expected value ignoring case";

        public static final String DOES_NOT_CONTAIN = "Actual value should not contain the expected value";

        public static final String DOES_NOT_CONTAIN_IGNORE_CASE = "Actual value should not contain the expected value ignoring case";

        public static final String CONTAINS_ALL = "Actual value should contain all of the expected values";

        public static final String CONTAINS_ALL_IN_ORDER = "Actual value should contain all of the expected values in the specified order";

        public static final String CONTAINS_EXACTLY = "Actual value should contain all of the expected values exactly";

        public static final String CONTAINS_EXACTLY_IN_ORDER = "Actual value should contain all of the expected values exactly in the specified order";

        public static final String CONTAINS_ANY = "Actual value should contain any of the expected values";

        public static final String CONTAINS_NONE = "Actual value should not contain any of the expected values";

        public static final String IS_PART_OF = "Actual value should be the part of the expected value";

        public static final String IS_PART_OF_IGNORE_CASE = "Actual value should be the part of the expected value ignoring case";

        public static final String IS_NOT_PART_OF = "Actual value should not be the part of the expected value";

        public static final String IS_NOT_PART_OF_IGNORE_CASE = "Actual value should not be the part of the expected value ignoring case";

        public static final String MATCHES = "Actual value should match the expected value";

        public static final String DOES_NOT_MATCH = "Actual value should not match the expected value";

        public static final String STARTS_WITH = "Actual value should start with the expected value";

        public static final String STARTS_WITH_IGNORE_CASE = "Actual value should start with the expected value ignoring case";

        public static final String DOES_NOT_START_WITH = "Actual value should not start with the expected value";

        public static final String DOES_NOT_START_WITH_IGNORE_CASE = "Actual value should not start with the expected value ignoring case";

        public static final String ENDS_WITH = "Actual value should end with the expected value";

        public static final String ENDS_WITH_IGNORE_CASE = "Actual value should end with the expected value ignoring case";

        public static final String DOES_NOT_END_WITH = "Actual value should not end with the expected value";

        public static final String DOES_NOT_END_WITH_IGNORE_CASE = "Actual value should not end with the expected value ignoring case";

        public static final String IS_DIRECT = "Actual value should be direct";

        public static final String IS_NOT_DIRECT = "Actual value should not be direct";

        public static final String IS_READ_ONLY = "Actual value should be read only";

        public static final String IS_NOT_READ_ONLY = "Actual value should not be read only";

        public static final String CONTAINS_FIELD = "Actual value should contain the expected field";

        private Fail() {
            super();
        }

    }

}
