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
package ru.d_shap.assertions.asimp.array;

import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.HexString;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the int array.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAssertion extends ReferenceAssertion<IntArrayAssertion, int[]> {

    /**
     * Create new object.
     */
    public IntArrayAssertion() {
        super();
    }

    @Override
    protected Class<int[]> getActualValueClass() {
        return int[].class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion isEmpty() {
        checkActualIsNotNull();
        if (getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion isNullOrEmpty() {
        if (getActual() != null && getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().length == 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion contains(final int expected) {
        createIterableAssertion().contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion doesNotContain(final int expected) {
        createIterableAssertion().doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAll(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAll(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAllInOrder(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAllInOrder(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsExactly(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsExactly(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsExactlyInOrder(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsExactlyInOrder(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAny(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsAny(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsNone(final int... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion containsNone(final Iterable<Integer> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
        return this;
    }

    private IterableAssertion<Object> createIterableAssertion() {
        List<Object> list = convertValue(getActual(), null, List.class);
        return initializeAssertion(Raw.iterableAssertion(), list);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public IntAssertion toLength() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().length, Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion toLength(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().length, matcher, Messages.Check.LENGTH);
        return this;
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasLength(final int expected) {
        toLength().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        checkActualIsNotNull();
        HexString hexString = convertValue(getActual(), null, HexString.class, 0, getActual().length);
        return initializeAssertion(Raw.charSequenceAssertion(), hexString.toString(), Messages.Check.HEX_REPRESENTATION);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from the index of the first array element (inclusive) for the hex representation.
     * @param to   the index of the last array element (exclusive) for the hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString(final int from, final int to) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(from <= getActual().length, "from", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsValid(to >= from, "to", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_MINIMUM_VALUE, from);
        checkArgumentIsValid(to <= getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        HexString hexString = convertValue(getActual(), null, HexString.class, from, to);
        return initializeAssertion(Raw.charSequenceAssertion(), hexString.toString(), Messages.Check.HEX_REPRESENTATION_PART, from, to);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion toHexString(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        HexString hexString = convertValue(getActual(), null, HexString.class, 0, getActual().length);
        matcherAssertion(hexString.toString(), matcher, Messages.Check.HEX_REPRESENTATION);
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first array element (inclusive) for the hex representation.
     * @param to      the index of the last array element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(from <= getActual().length, "from", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsValid(to >= from, "to", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_MINIMUM_VALUE, from);
        checkArgumentIsValid(to <= getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsNotNull(matcher, "matcher");
        HexString hexString = convertValue(getActual(), null, HexString.class, from, to);
        matcherAssertion(hexString.toString(), matcher, Messages.Check.HEX_REPRESENTATION_PART, from, to);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasHexString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toHexString().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first array element (inclusive) for the hex representation.
     * @param to       the index of the last array element (exclusive) for the hex representation.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasHexString(final int from, final int to, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(from <= getActual().length, "from", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsValid(to >= from, "to", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_MINIMUM_VALUE, from);
        checkArgumentIsValid(to <= getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_OR_EQUAL_TO_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsNotNull(expected, "expected");
        toHexString(from, to).isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public IntAssertion toMin() {
        checkActualIsNotNull();
        Integer minValue = getMinValue();
        return initializeAssertion(Raw.intAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion toMin(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer minValue = getMinValue();
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasMin(final int expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasMin(final Integer expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    private Integer getMinValue() {
        int[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        int result = actual[0];
        for (int value : actual) {
            result = Math.min(result, value);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public IntAssertion toMax() {
        checkActualIsNotNull();
        Integer maxValue = getMaxValue();
        return initializeAssertion(Raw.intAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion toMax(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Integer maxValue = getMaxValue();
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasMax(final int expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public IntArrayAssertion hasMax(final Integer expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    private Integer getMaxValue() {
        int[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        int result = actual[0];
        for (int value : actual) {
            result = Math.max(result, value);
        }
        return result;
    }

}
