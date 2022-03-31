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
 * Assertions for the byte array.
 *
 * @author Dmitry Shapovalov
 */
public class ByteArrayAssertion extends ReferenceAssertion<byte[]> {

    /**
     * Create new object.
     */
    public ByteArrayAssertion() {
        super();
    }

    @Override
    protected final Class<byte[]> getActualValueClass() {
        return byte[].class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().length == 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final int expected) {
        createIterableAssertion().contains((byte) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final int expected) {
        createIterableAssertion().doesNotContain((byte) expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsAny(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final byte... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final int... expected) {
        Object expectedBytes = convertValue(expected, null, byte[].class);
        List<Object> expectedList = convertValue(expectedBytes, null, List.class);
        createIterableAssertion().containsNone(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Byte> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().length, Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLength(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().length, matcher, Messages.Check.LENGTH);
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
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
     * @param to   the index of the lest array element (exclusive) for the hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString(final int from, final int to) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(to < getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().length);
        HexString hexString = convertValue(getActual(), null, HexString.class, from, to);
        return initializeAssertion(Raw.charSequenceAssertion(), hexString.toString(), Messages.Check.HEX_REPRESENTATION);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toHexString(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        HexString hexString = convertValue(getActual(), null, HexString.class, 0, getActual().length);
        matcherAssertion(hexString.toString(), matcher, Messages.Check.HEX_REPRESENTATION);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param from    the index of the first array element (inclusive) for the hex representation.
     * @param to      the index of the lest array element (exclusive) for the hex representation.
     * @param matcher the hamcrest matcher.
     */
    public void toHexString(final int from, final int to, final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(to < getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsNotNull(matcher, "matcher");
        HexString hexString = convertValue(getActual(), null, HexString.class, from, to);
        matcherAssertion(hexString.toString(), matcher, Messages.Check.HEX_REPRESENTATION);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasHexString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toHexString().isEqualTo(expected);
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param from     the index of the first array element (inclusive) for the hex representation.
     * @param to       the index of the lest array element (exclusive) for the hex representation.
     * @param expected the expected value.
     */
    public void hasHexString(final int from, final int to, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(from >= 0, "from", Messages.Fail.Argument.IS_GREATER_THAN_OR_EQUAL_TO_ZERO);
        checkArgumentIsValid(to < getActual().length, "to", Messages.Fail.Argument.IS_LESS_THAN_MAXIMUM_VALUE, getActual().length);
        checkArgumentIsNotNull(expected, "expected");
        toHexString(from, to).isEqualTo(expected);
    }

    private IterableAssertion<Object> createIterableAssertion() {
        List<Object> list = convertValue(getActual(), null, List.class);
        return initializeAssertion(Raw.iterableAssertion(), list);
    }

}
