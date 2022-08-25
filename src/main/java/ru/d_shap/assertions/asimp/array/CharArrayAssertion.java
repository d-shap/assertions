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
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.CharAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the char array.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayAssertion extends ReferenceAssertion<CharArrayAssertion, char[]> {

    /**
     * Create new object.
     */
    public CharArrayAssertion() {
        super();
    }

    @Override
    protected Class<char[]> getActualValueClass() {
        return char[].class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public CharArrayAssertion isEmpty() {
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
    public CharArrayAssertion isNullOrEmpty() {
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
    public CharArrayAssertion isNotEmpty() {
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
    public CharArrayAssertion contains(final int expected) {
        createIterableAssertion().contains((char) expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharArrayAssertion doesNotContain(final int expected) {
        createIterableAssertion().doesNotContain((char) expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public CharArrayAssertion containsAll(final char... expected) {
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
    public CharArrayAssertion containsAll(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsAll(final Iterable<Character> expected) {
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
    public CharArrayAssertion containsAllInOrder(final char... expected) {
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
    public CharArrayAssertion containsAllInOrder(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsAllInOrder(final Iterable<Character> expected) {
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
    public CharArrayAssertion containsExactly(final char... expected) {
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
    public CharArrayAssertion containsExactly(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsExactly(final Iterable<Character> expected) {
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
    public CharArrayAssertion containsExactlyInOrder(final char... expected) {
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
    public CharArrayAssertion containsExactlyInOrder(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsExactlyInOrder(final Iterable<Character> expected) {
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
    public CharArrayAssertion containsAny(final char... expected) {
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
    public CharArrayAssertion containsAny(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsAny(final Iterable<Character> expected) {
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
    public CharArrayAssertion containsNone(final char... expected) {
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
    public CharArrayAssertion containsNone(final int... expected) {
        Object expectedChars = convertValue(expected, null, char[].class);
        List<Object> expectedList = convertValue(expectedChars, null, List.class);
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
    public CharArrayAssertion containsNone(final Iterable<Character> expected) {
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
    public CharArrayAssertion toLength(final Matcher<? super Integer> matcher) {
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
    public CharArrayAssertion hasLength(final int expected) {
        toLength().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public CharAssertion toMin() {
        checkActualIsNotNull();
        Character minValue = getMinValue();
        return initializeAssertion(Raw.charAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharArrayAssertion toMin(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character minValue = getMinValue();
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
    public CharArrayAssertion hasMin(final int expected) {
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
    public CharArrayAssertion hasMin(final Character expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    private Character getMinValue() {
        char[] actual = getActual();
        int length = actual.length;
        if (length == 0) {
            return null;
        }
        char result = actual[0];
        for (int i = 1; i < length; i++) {
            result = (char) Math.min(result, actual[i]);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public CharAssertion toMax() {
        checkActualIsNotNull();
        Character maxValue = getMaxValue();
        return initializeAssertion(Raw.charAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharArrayAssertion toMax(final Matcher<? super Character> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Character maxValue = getMaxValue();
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
    public CharArrayAssertion hasMax(final int expected) {
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
    public CharArrayAssertion hasMax(final Character expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    private Character getMaxValue() {
        char[] actual = getActual();
        int length = actual.length;
        if (length == 0) {
            return null;
        }
        char result = actual[0];
        for (int i = 1; i < length; i++) {
            result = (char) Math.max(result, actual[i]);
        }
        return result;
    }

}
