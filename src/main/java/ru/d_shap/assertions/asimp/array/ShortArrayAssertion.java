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
import ru.d_shap.assertions.asimp.primitive.ShortAssertion;

/**
 * Assertions for the short array.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAssertion extends ReferenceAssertion<ShortArrayAssertion, short[]> {

    /**
     * Create new object.
     */
    public ShortArrayAssertion() {
        super();
    }

    @Override
    protected Class<short[]> getActualValueClass() {
        return short[].class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public ShortArrayAssertion isEmpty() {
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
    public ShortArrayAssertion isNullOrEmpty() {
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
    public ShortArrayAssertion isNotEmpty() {
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
    public ShortArrayAssertion contains(final int expected) {
        createIterableAssertion().contains((short) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public ShortArrayAssertion doesNotContain(final int expected) {
        createIterableAssertion().doesNotContain((short) expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public ShortArrayAssertion containsAll(final short... expected) {
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
    public ShortArrayAssertion containsAll(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsAll(final Iterable<Short> expected) {
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
    public ShortArrayAssertion containsAllInOrder(final short... expected) {
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
    public ShortArrayAssertion containsAllInOrder(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsAllInOrder(final Iterable<Short> expected) {
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
    public ShortArrayAssertion containsExactly(final short... expected) {
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
    public ShortArrayAssertion containsExactly(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsExactly(final Iterable<Short> expected) {
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
    public ShortArrayAssertion containsExactlyInOrder(final short... expected) {
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
    public ShortArrayAssertion containsExactlyInOrder(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsExactlyInOrder(final Iterable<Short> expected) {
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
    public ShortArrayAssertion containsAny(final short... expected) {
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
    public ShortArrayAssertion containsAny(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsAny(final Iterable<Short> expected) {
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
    public ShortArrayAssertion containsNone(final short... expected) {
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
    public ShortArrayAssertion containsNone(final int... expected) {
        Object expectedShorts = convertValue(expected, null, short[].class);
        List<Object> expectedList = convertValue(expectedShorts, null, List.class);
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
    public ShortArrayAssertion containsNone(final Iterable<Short> expected) {
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
    public ShortArrayAssertion toLength(final Matcher<? super Integer> matcher) {
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
    public ShortArrayAssertion hasLength(final int expected) {
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
    public ShortArrayAssertion toHexString(final Matcher<? super String> matcher) {
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
    public ShortArrayAssertion toHexString(final int from, final int to, final Matcher<? super String> matcher) {
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
    public ShortArrayAssertion hasHexString(final String expected) {
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
    public ShortArrayAssertion hasHexString(final int from, final int to, final String expected) {
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
    public ShortAssertion toMin() {
        checkActualIsNotNull();
        Short minValue = getMinValue();
        return initializeAssertion(Raw.shortAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ShortArrayAssertion toMin(final Matcher<? super Short> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Short minValue = getMinValue();
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
    public ShortArrayAssertion hasMin(final int expected) {
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
    public ShortArrayAssertion hasMin(final Short expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    private Short getMinValue() {
        short[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        short result = actual[0];
        for (short value : actual) {
            result = (short) Math.min(result, value);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public ShortAssertion toMax() {
        checkActualIsNotNull();
        Short maxValue = getMaxValue();
        return initializeAssertion(Raw.shortAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ShortArrayAssertion toMax(final Matcher<? super Short> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Short maxValue = getMaxValue();
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
    public ShortArrayAssertion hasMax(final int expected) {
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
    public ShortArrayAssertion hasMax(final Short expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    private Short getMaxValue() {
        short[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        short result = actual[0];
        for (short value : actual) {
            result = (short) Math.max(result, value);
        }
        return result;
    }

}
