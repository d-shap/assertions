///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
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

    public static final String SIMPLE_MESSAGE = "{0}";

    public static final String SEPARATOR = "\n\t";

    public static final String NULL = "<NULL>";

    public static final String EMPTY = "<EMPTY>";

    private Messages() {
        super();
    }

    /**
     * Check messages.
     *
     * @author Dmitry Shapovalov
     */
    public static final class Check {

        public static final String CLASS = "Check actual value''s class.";

        public static final String TO_STRING = "Check actual value''s string representation.";

        public static final String HASH_CODE = "Check actual value''s hash code.";

        public static final String COMPONENT_TYPE = "Check actual value''s component type.";

        public static final String FIELD_VALUE = "Check actual value''s field value: {0}.";

        public static final String METHOD_CALL_RESULT = "Check actual value''s method call result: {0}.";

        public static final String METHOD_CALL_EXCEPTION = "Check actual value''s method call exception: {0}.";

        public static final String LENGTH = "Check actual value''s length.";

        public static final String SIZE = "Check actual value''s size.";

        public static final String HEX_REPRESENTATION = "Check actual value''s hex representation.";

        public static final String HEX_REPRESENTATION_PART = "Check actual value''s hex representation part: {0}:{1}.";

        public static final String MIN_VALUE = "Check actual value''s minimum value";

        public static final String MAX_VALUE = "Check actual value''s maximum value";

        public static final String ELEMENTS_ALL = "Check all actual value''s elements.";

        public static final String ELEMENTS_ALL_NEXT = "Check all next actual value''s elements.";

        public static final String ELEMENTS_ALL_PREVIOUS = "Check all previous actual value''s elements.";

        public static final String ELEMENTS_COUNT_NEXT = "Check next N actual value''s elements: {0}.";

        public static final String ELEMENTS_COUNT_PREVIOUS = "Check previous N actual value''s elements: {0}.";

        public static final String ELEMENTS_HEAD_ELEMENT = "Check actual value''s head elements up to element: {0}.";

        public static final String ELEMENTS_HEAD_COUNT = "Check actual value''s N head elements: {0}.";

        public static final String ELEMENTS_TAIL_ELEMENT = "Check actual value''s tail elements from element: {0}.";

        public static final String ELEMENTS_TAIL_COUNT = "Check actual value''s N tail elements: {0}.";

        public static final String KEYS = "Check actual value''s keys.";

        public static final String VALUE = "Check actual value''s value.";

        public static final String VALUE_COUNT = "Check actual value''s value count.";

        public static final String VALUES = "Check actual value''s values.";

        public static final String TOKENS = "Check actual value''s tokens.";

        public static final String MESSAGE = "Check actual value''s message.";

        public static final String CAUSE = "Check actual value''s cause.";

        public static final String SUPPRESSED_COUNT = "Check actual value''s suppressed count.";

        public static final String SUPPRESSED = "Check actual value''s suppressed at index: {0}.";

        public static final String YEAR = "Check actual value''s year.";

        public static final String MONTH = "Check actual value''s month.";

        public static final String WEEK_OF_YEAR = "Check actual value''s week of year.";

        public static final String WEEK_OF_MONTH = "Check actual value''s week of month.";

        public static final String DAY_OF_YEAR = "Check actual value''s day of year.";

        public static final String DAY_OF_MONTH = "Check actual value''s day of month.";

        public static final String DAY_OF_WEEK_IN_MONTH = "Check actual value''s day of week in month.";

        public static final String DAY_OF_WEEK = "Check actual value''s day of week.";

        public static final String AM_PM = "Check actual value''s AM/PM.";

        public static final String HOUR_OF_DAY = "Check actual value''s hour of day.";

        public static final String HOUR = "Check actual value''s hour.";

        public static final String MINUTE = "Check actual value''s minute.";

        public static final String SECOND = "Check actual value''s second.";

        public static final String MILLISECOND = "Check actual value''s millisecond.";

        public static final String ID = "Check actual value''s ID.";

        public static final String DISPLAY_NAME = "Check actual value''s display name.";

        public static final String RAW_OFFSET = "Check actual value''s raw offset.";

        public static final String ZONE_OFFSET = "Check actual value''s zone offset.";

        public static final String USE_DAYLIGHT_TIME = "Check actual value''s use daylight time.";

        public static final String DST_SAVINGS = "Check actual value''s DST savings.";

        public static final String DST_OFFSET = "Check actual value''s DST offset.";

        public static final String TIME_ZONE = "Check actual value''s time zone.";

        public static final String TIME_ZONE_DATE = "Check actual value''s date in time zone: {0}.";

        public static final String LANGUAGE = "Check actual value''s language.";

        public static final String DISPLAY_LANGUAGE = "Check actual value''s display language.";

        public static final String SCRIPT = "Check actual value''s script.";

        public static final String DISPLAY_SCRIPT = "Check actual value''s display script.";

        public static final String COUNTRY = "Check actual value''s country.";

        public static final String DISPLAY_COUNTRY = "Check actual value''s display country.";

        public static final String VARIANT = "Check actual value''s variant.";

        public static final String DISPLAY_VARIANT = "Check actual value''s display variant.";

        public static final String BYTES_ALL = "Check all actual value''s bytes.";

        public static final String BYTES_COUNT_NEXT = "Check next N actual value''s bytes: {0}.";

        public static final String CHARS_ALL = "Check all actual value''s chars.";

        public static final String CHARS_COUNT_NEXT = "Check next N actual value''s chars: {0}.";

        public static final String LINES_ALL = "Check all actual value''s lines.";

        public static final String LINES_COUNT_NEXT = "Check next N actual value''s lines: {0}.";

        public static final String LINES_LENGTH = "Check actual value''s lines length.";

        public static final String AVAILABLE = "Check actual value''s available.";

        public static final String POSITION = "Check actual value''s position.";

        public static final String LIMIT = "Check actual value''s limit.";

        public static final String CAPACITY = "Check actual value''s capacity.";

        public static final String REMAINING = "Check actual value''s remaining.";

        public static final String NAMESPACE_URI = "Check actual value''s namespace URI.";

        public static final String PREFIX = "Check actual value''s prefix.";

        public static final String LOCAL_PART = "Check actual value''s local part.";

        public static final String LOCAL_NAME = "Check actual value''s local name.";

        public static final String QUALIFIED_NAME = "Check actual value''s qualified name.";

        public static final String ATTRIBUTE = "Check actual value''s attribute: {0}.";

        public static final String DATA = "Check actual value''s data.";

        public static final String CHILD_NODES_COUNT = "Check actual value''s child nodes count.";

        public static final String CHILD_ELEMENTS_COUNT = "Check actual value''s child elements count.";

        private Check() {
            super();
        }

    }

    /**
     * Fail messages.
     *
     * @author Dmitry Shapovalov
     */
    public static final class Fail {

        public static final String TEST_FAIL_MESSAGE = "{0} test fail";

        private Fail() {
            super();
        }

        /**
         * Assertion fail messages.
         *
         * @author Dmitry Shapovalov
         */
        public static final class Assertion {

            public static final String IS_INITIALIZED = "Assertion should be initialized.";

            public static final String IS_NOT_INITIALIZED = "Assertion should not be initialized.";

            public static final String MATCHES = "Actual value should match the assertion.";

            public static final String IS_INSTANCE_OF = "Actual value should be the instance of the expected class.";

            private Assertion() {
                super();
            }

        }

        /**
         * Argument fail messages.
         *
         * @author Dmitry Shapovalov
         */
        public static final class Argument {

            public static final String IS_NOT_NULL = "Argument should not be null: {0}.";

            public static final String IS_NOT_EMPTY = "Argument should not be empty: {0}.";

            public static final String PROPERTY_IS_NOT_NULL = "Argument''s property should not be null: {0}{1}.";

            public static final String PROPERTY_IS_NOT_EMPTY = "Argument''s property should not be empty: {0}{1}.";

            public static final String IS_FINITE = "Argument should be finite: {0}.";

            public static final String IS_VALID = "Argument should be valid: {0}.";

            public static final String RESULT_IS_ALWAYS_TRUE = "The result is always true.";

            public static final String RESULT_IS_ALWAYS_FALSE = "The result is always false.";

            public static final String IS_GREATER_THAN_ZERO = "The argument''s value should be greater than zero.";

            public static final String IS_GREATER_THAN_OR_EQUAL_TO_ZERO = "The argument''s value should be greater than or equal to zero.";

            public static final String IS_GREATER_THAN_OR_EQUAL_TO_MINIMUM_VALUE = "The argument''s value should be greater than or equal to the minimum value: {0}.";

            public static final String IS_LESS_THAN_MAXIMUM_VALUE = "The argument''s value should be less than the maximum value: {0}.";

            public static final String IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE = "The argument''s value should be less than or equal to the maximum value: {0}.";

            public static final String IS_VALID_XML = "The argument''s value should be the valid XML.";

            private Argument() {
                super();
            }

        }

        /**
         * Predicate fail messages.
         *
         * @author Dmitry Shapovalov
         */
        public static final class Predicate {

            public static final String AND_IS_FALSE = "AND predicate failed";

            public static final String OR_IS_FALSE = "OR predicate failed";

            public static final String XOR_IS_FALSE = "XOR predicate failed";

            public static final String NOT_IS_FALSE = "NOT predicate failed";

            private Predicate() {
                super();
            }

        }

        /**
         * Actual fail messages.
         *
         * @author Dmitry Shapovalov
         */
        public static final class Actual {

            public static final String IS_TRUE = "Actual value should be true.";

            public static final String IS_FALSE = "Actual value should be false.";

            public static final String IS_SAME_REFERENCE = "Actual and expected values should point to the same object.";

            public static final String IS_SAME = "Actual and expected values should be the same.";

            public static final String IS_SAME_IGNORE_CASE = "Actual and expected values should be the same ignoring case.";

            public static final String IS_DIFFERENT_REFERENCE = "Actual and expected values should point to the different objects.";

            public static final String IS_DIFFERENT = "Actual and expected values should be different.";

            public static final String IS_DIFFERENT_IGNORE_CASE = "Actual and expected values should be different ignoring case.";

            public static final String IS_GREATER = "Actual value should be greater than the expected.";

            public static final String IS_GREATER_IGNORE_CASE = "Actual value should be greater than the expected ignoring case.";

            public static final String IS_GREATER_OR_EQUAL = "Actual value should be greater than or equal to the expected.";

            public static final String IS_GREATER_OR_EQUAL_IGNORE_CASE = "Actual value should be greater than or equal to the expected ignoring case.";

            public static final String IS_LESS = "Actual value should be less than the expected.";

            public static final String IS_LESS_IGNORE_CASE = "Actual value should be less than the expected ignoring case.";

            public static final String IS_LESS_OR_EQUAL = "Actual value should be less than or equal to the expected.";

            public static final String IS_LESS_OR_EQUAL_IGNORE_CASE = "Actual value should be less than or equal to the expected ignoring case.";

            public static final String IS_IN_RANGE = "Actual value should be in the expected range.";

            public static final String IS_IN_RANGE_IGNORE_CASE = "Actual value should be in the expected range ignoring case.";

            public static final String IS_NOT_IN_RANGE = "Actual value should not be in the expected range.";

            public static final String IS_NOT_IN_RANGE_IGNORE_CASE = "Actual value should not be in the expected range ignoring case.";

            public static final String IS_ZERO = "Actual value should be zero.";

            public static final String IS_NOT_ZERO = "Actual value should not be zero.";

            public static final String IS_POSITIVE_INFINITY = "Actual value should be positive infinity.";

            public static final String IS_NOT_POSITIVE_INFINITY = "Actual value should not be positive infinity.";

            public static final String IS_NEGATIVE_INFINITY = "Actual value should be negative infinity.";

            public static final String IS_NOT_NEGATIVE_INFINITY = "Actual value should not be negative infinity.";

            public static final String IS_INFINITY = "Actual value should be infinity.";

            public static final String IS_NOT_INFINITY = "Actual value should not be infinity.";

            public static final String IS_NAN = "Actual value should be NaN.";

            public static final String IS_NOT_NAN = "Actual value should not be NaN.";

            public static final String IS_FINITE = "Actual value should be finite.";

            public static final String IS_NOT_FINITE = "Actual value should not be finite.";

            public static final String IS_ALPHABETIC = "Actual value should be the alphabetic symbol.";

            public static final String IS_NOT_ALPHABETIC = "Actual value should not be the alphabetic symbol.";

            public static final String IS_LETTER = "Actual value should be the letter.";

            public static final String IS_NOT_LETTER = "Actual value should not be the letter.";

            public static final String IS_DIGIT = "Actual value should be the digit.";

            public static final String IS_NOT_DIGIT = "Actual value should not be the digit.";

            public static final String IS_WHITESPACE = "Actual value should be the whitespace symbol.";

            public static final String IS_NOT_WHITESPACE = "Actual value should not be the whitespace symbol.";

            public static final String IS_LETTER_OR_DIGIT = "Actual value should be the letter or the digit.";

            public static final String IS_LETTER_OR_WHITESPACE = "Actual value should be the letter or the whitespace symbol.";

            public static final String IS_CONTROL_SYMBOL = "Actual value should be the control symbol.";

            public static final String IS_NOT_CONTROL_SYMBOL = "Actual value should not be the control symbol.";

            public static final String IS_LOWER_CASE = "Actual value should be the lower case symbol.";

            public static final String IS_NOT_LOWER_CASE = "Actual value should not be the lower case symbol.";

            public static final String IS_UPPER_CASE = "Actual value should be the upper case symbol.";

            public static final String IS_NOT_UPPER_CASE = "Actual value should not be the upper case symbol.";

            public static final String IS_NULL = "Actual value should be null.";

            public static final String IS_NOT_NULL = "Actual value should not be null.";

            public static final String IS_EMPTY = "Actual value should be empty.";

            public static final String IS_NULL_OR_EMPTY = "Actual value should be null or empty.";

            public static final String IS_NOT_EMPTY = "Actual value should not be empty.";

            public static final String IS_BLANK = "Actual value should be blank.";

            public static final String IS_NULL_OR_BLANK = "Actual value should be null or blank.";

            public static final String IS_NOT_BLANK = "Actual value should not be blank.";

            public static final String PROPERTY_IS_NOT_NULL = "Actual value''s property should not be null: {0}.";

            public static final String IS_SUBTYPE_OF = "Actual value should be the subtype of the expected value.";

            public static final String IS_NOT_SUBTYPE_OF = "Actual value should not be the subtype of the expected value.";

            public static final String IS_SUPERTYPE_OF = "Actual value should be the supertype of the expected value.";

            public static final String IS_NOT_SUPERTYPE_OF = "Actual value should not be the supertype of the expected value.";

            public static final String IS_INTERCACE_TYPE = "Actual value should be the interface type.";

            public static final String IS_NOT_INTERCACE_TYPE = "Actual value should not be the interface type.";

            public static final String IS_ARRAY_TYPE = "Actual value should be the array type.";

            public static final String IS_NOT_ARRAY_TYPE = "Actual value should not be the array type.";

            public static final String IS_ENUM_TYPE = "Actual value should be the enum type.";

            public static final String IS_NOT_ENUM_TYPE = "Actual value should not be the enum type.";

            public static final String IS_CONSTRUCTOR_DEFAULT = "Actual value should have one default constructor.";

            public static final String CONSTRUCTOR_NOT_ACCESSIBLE = "Actual value''s constructor should not be acccessible.";

            public static final String CONSTRUCTOR_CALLABLE = "Actual value''s constructor should be callable.";

            public static final String CONTAINS = "Actual value should contain the expected value.";

            public static final String CONTAINS_IGNORE_CASE = "Actual value should contain the expected value ignoring case.";

            public static final String DOES_NOT_CONTAIN = "Actual value should not contain the expected value.";

            public static final String DOES_NOT_CONTAIN_IGNORE_CASE = "Actual value should not contain the expected value ignoring case.";

            public static final String CONTAINS_ALL = "Actual value should contain all of the expected values.";

            public static final String CONTAINS_ALL_IN_ORDER = "Actual value should contain all of the expected values in the specified order.";

            public static final String CONTAINS_EXACTLY = "Actual value should contain all of the expected values exactly.";

            public static final String CONTAINS_EXACTLY_IN_ORDER = "Actual value should contain all of the expected values exactly in the specified order.";

            public static final String CONTAINS_ANY = "Actual value should contain any of the expected values.";

            public static final String CONTAINS_NONE = "Actual value should not contain any of the expected values.";

            public static final String IS_PART_OF = "Actual value should be the part of the expected value.";

            public static final String IS_PART_OF_IGNORE_CASE = "Actual value should be the part of the expected value ignoring case.";

            public static final String IS_NOT_PART_OF = "Actual value should not be the part of the expected value.";

            public static final String IS_NOT_PART_OF_IGNORE_CASE = "Actual value should not be the part of the expected value ignoring case.";

            public static final String MATCHES = "Actual value should match the expected value.";

            public static final String DOES_NOT_MATCH = "Actual value should not match the expected value.";

            public static final String STARTS_WITH = "Actual value should start with the expected value.";

            public static final String STARTS_WITH_IGNORE_CASE = "Actual value should start with the expected value ignoring case.";

            public static final String DOES_NOT_START_WITH = "Actual value should not start with the expected value.";

            public static final String DOES_NOT_START_WITH_IGNORE_CASE = "Actual value should not start with the expected value ignoring case.";

            public static final String ENDS_WITH = "Actual value should end with the expected value.";

            public static final String ENDS_WITH_IGNORE_CASE = "Actual value should end with the expected value ignoring case.";

            public static final String DOES_NOT_END_WITH = "Actual value should not end with the expected value.";

            public static final String DOES_NOT_END_WITH_IGNORE_CASE = "Actual value should not end with the expected value ignoring case.";

            public static final String HAS_SAME_RULES = "Actual value should have the same rules as the expected.";

            public static final String DOES_NOT_HAVE_SAME_RULES = "Actual value should not have the same rules as the expected.";

            public static final String HAS_NEXT_VALUE = "Actual value should have next value.";

            public static final String DOES_NOT_HAVE_NEXT_VALUE = "Actual value should not have next value.";

            public static final String HAS_PREVIOUS_VALUE = "Actual value should have previous value.";

            public static final String DOES_NOT_HAVE_PREVIOUS_VALUE = "Actual value should not have previous value.";

            public static final String IS_COMPLETED = "Actual value should be completed.";

            public static final String IS_NOT_COMPLETED = "Actual value should not be completed.";

            public static final String IS_DIRECT = "Actual value should be direct.";

            public static final String IS_NOT_DIRECT = "Actual value should not be direct.";

            public static final String IS_READ_ONLY = "Actual value should be read only.";

            public static final String IS_NOT_READ_ONLY = "Actual value should not be read only.";

            public static final String IS_SERIALIZABLE = "Actual value should be serializable.";

            public static final String IS_NOT_SERIALIZABLE = "Actual value should not be serializable.";

            public static final String CONTAINS_FIELD = "Actual value should contain the expected field.";

            public static final String CONTAINS_METHOD = "Actual value should contain the expected method.";

            public static final String METHOD_CALL_RESULT = "Actual value should call the expected method.";

            public static final String METHOD_CALL_EXCEPTION = "Actual value should fail to call the expected method.";

            public static final String HAS_ATTRIBUTE = "Actual value should have the expected attribute.";

            public static final String HAS_NOT_ATTRIBUTE = "Actual value should not have the expected attribute.";

            public static final String HAS_CHILD_NODES = "Actual value should have the child nodes.";

            public static final String HAS_NOT_CHILD_NODES = "Actual value should not have the child nodes.";

            public static final String HAS_CHILD_ELEMENTS = "Actual value should have the child elements.";

            public static final String HAS_NOT_CHILD_ELEMENTS = "Actual value should not have the child elements.";

            private Actual() {
                super();
            }

        }

    }

    /**
     * Value messages.
     *
     * @author Dmitry Shapovalov
     */
    public static final class Value {

        public static final String ACTUAL = "Actual:{0}";

        public static final String EXPECTED = "Expected:{0}";

        public static final String ACTUAL_AND_EXPECTED = "Expected:{1} but was:{0}";

        private Value() {
            super();
        }

    }

}
