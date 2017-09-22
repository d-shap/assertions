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

        public static final String ACTUAL_VALUE_CLASS = "Check value class";

        public static final String ACTUAL_VALUE_TO_STRING = "Check value string representation";

        public static final String ACTUAL_VALUE_HASH_CODE = "Check value hash code";

        public static final String ACTUAL_VALUE_FIELD = "Check value field";

        public static final String ACTUAL_VALUE_LENGTH = "Check value length";

        public static final String ACTUAL_VALUE_SIZE = "Check value size";

        public static final String ACTUAL_KEYS = "Check keys";

        public static final String ACTUAL_VALUES = "Check values";

        public static final String ACTUAL_VALUE_TOKENS = "Check value tokens";

        public static final String ACTUAL_THROWABLE_MESSAGE = "Check throwable message";

        public static final String ACTUAL_THROWABLE_CAUSE = "Check throwable cause";

        public static final String ACTUAL_ENUM_VALUE_COUNT = "Check enum value count";

        public static final String ACTUAL_STREAM_BYTE_READ = "Check input stream byte read";

        public static final String ACTUAL_READER_CHAR_READ = "Check reader char read";

        public static final String ACTUAL_BUFFER_POSITION = "Check buffer position";

        public static final String ACTUAL_BUFFER_LIMIT = "Check buffer limit";

        public static final String ACTUAL_BUFFER_CAPACITY = "Check buffer capacity";

        public static final String ACTUAL_BUFFER_REMAINING = "Check buffer remaining";

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

        public static final String ARGUMENT_IS_NOT_NULL = "Argument should not be null";

        public static final String ARGUMENT_IS_NOT_EMPTY_TRUE = "Argument should not be empty. The result is always true";

        public static final String ARGUMENT_IS_NOT_EMPTY_FALSE = "Argument should not be empty. The result is always false";

        public static final String IS_TRUE = "Value should be true";

        public static final String IS_FALSE = "Value should be false";

        public static final String IS_SAME = "Values should be the same";

        public static final String IS_DIFFERENT = "Values should be different";

        public static final String IS_GREATER = "Value should be greater then the expected";

        public static final String IS_GREATER_OR_EQUAL = "Value should be greater then or equal to the expected";

        public static final String IS_LESS = "Value should be less then the expected";

        public static final String IS_LESS_OR_EQUAL = "Value should be less then or equal to the expected";

        public static final String IS_IN_RANGE = "Value should be in the expected range";

        public static final String IS_NOT_IN_RANGE = "Value should not be in the expected range";

        public static final String IS_ZERO = "Value should be zero";

        public static final String IS_NON_ZERO = "Value should not be zero";

        public static final String IS_POSITIVE_INFINITY = "Value should be positive infinity";

        public static final String IS_NEGATIVE_INFINITY = "Value should be negative infinity";

        public static final String IS_INFINITY = "Value should be infinity";

        public static final String IS_NAN = "Value should be NaN";

        public static final String IS_NOT_NAN = "Value should not be NaN";

        public static final String IS_FINITE = "Value should be finite";

        public static final String IS_ALPHABETIC = "Value should be the alphabetic symbol";

        public static final String IS_DIGIT = "Value should be the digit";

        public static final String IS_LETTER = "Value should be the letter";

        public static final String IS_LETTER_OR_DIGIT = "Value should be the letter or the digit";

        public static final String IS_CONTROL_SYMBOL = "Value should be the control symbol";

        public static final String IS_LOWER_CASE = "Value should be the lower case symbol";

        public static final String IS_UPPER_CASE = "Value should be the upper case symbol";

        public static final String IS_WHITESPACE = "Value should be the whitespace symbol";

        public static final String IS_NULL = "Value should be null";

        public static final String IS_NOT_NULL = "Value should not be null";

        public static final String IS_EMPTY = "Value should be empty";

        public static final String IS_NULL_OR_EMPTY = "Value should be null or empty";

        public static final String IS_NOT_EMPTY = "Value should not be empty";

        public static final String IS_BLANK = "Value should be blank";

        public static final String IS_NULL_OR_BLANK = "Value should be null or blank";

        public static final String IS_NOT_BLANK = "Value should not be blank";

        public static final String IS_SUBTYPE_OF = "Value should be the subtype of the expected value";

        public static final String IS_NOT_SUBTYPE_OF = "Value should not be the subtype of the expected value";

        public static final String IS_CONSTRUCTOR_DEFAULT = "Value should have one default constructor";

        public static final String IS_CONSTRUCTOR_NOT_ACCESSIBLE = "Value constructor should not be acccessible";

        public static final String IS_ENUM = "Value should be the enum";

        public static final String CONTAINS = "Value should contain the expected value";

        public static final String DOES_NOT_CONTAIN = "Value should not contain the expected value";

        public static final String CONTAINS_ALL = "Value should contain all of the expected values";

        public static final String CONTAINS_ALL_IN_ORDER = "Value should contain all of the expected values in the specified order";

        public static final String CONTAINS_EXACTLY = "Value should contain all of the expected values exactly";

        public static final String CONTAINS_EXACTLY_IN_ORDER = "Value should contain all of the expected values exactly in the specified order";

        public static final String CONTAINS_ANY = "Value should contain any of the expected values";

        public static final String CONTAINS_NONE = "Value should not contain any of the expected values";

        public static final String IS_PART_OF = "Value should be the part of the expected value";

        public static final String IS_NOT_PART_OF = "Value should not be the part of the expected value";

        public static final String MATCHES = "Value should match the expected value";

        public static final String DOES_NOT_MATCH = "Value should not match the expected value";

        public static final String STARTS_WITH = "Value should start with the expected value";

        public static final String DOES_NOT_START_WITH = "Value should not start with the expected value";

        public static final String ENDS_WITH = "Value should end with the expected value";

        public static final String DOES_NOT_END_WITH = "Value should not end with the expected value";

        public static final String IS_DIRECT = "Value should be direct";

        public static final String IS_NOT_DIRECT = "Value should not be direct";

        public static final String IS_READ_ONLY = "Value should be read only";

        public static final String IS_NOT_READ_ONLY = "Value should not be read only";

        public static final String CONTAINS_FIELD = "Value should contain the expected field";

        private Fail() {
            super();
        }

    }

}
