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
package ru.d_shap.assertions.asimp.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.ByteArrayAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.asimp.primitive.LongAssertion;

/**
 * Assertions for the input stream.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamAssertion extends ReferenceAssertion<InputStreamAssertion, InputStream> {

    /**
     * Create new object.
     */
    public InputStreamAssertion() {
        super();
    }

    @Override
    protected Class<InputStream> getActualValueClass() {
        return InputStream.class;
    }

    /**
     * Check if the actual value does not contain any more bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion isCompleted() {
        checkActualIsNotNull();
        try {
            int nextByte = getActual().read();
            if (nextByte >= 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
        return this;
    }

    /**
     * Check if the actual value contains more bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion isNotCompleted() {
        checkActualIsNotNull();
        try {
            int nextByte = getActual().read();
            if (nextByte < 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
        return this;
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @return the assertion.
     */
    public ByteArrayAssertion toByteArray() {
        checkActualIsNotNull();
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, 0);
        return initializeAssertion(Raw.byteArrayAssertion(), nextBytes, Messages.Check.BYTES_ALL);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param count the number of bytes to read from the actual.
     *
     * @return the assertion.
     */
    public ByteArrayAssertion toByteArray(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, count);
        return initializeAssertion(Raw.byteArrayAssertion(), nextBytes, Messages.Check.BYTES_COUNT_NEXT, count);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toByteArray(final Matcher<? super Byte[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, 0);
        Byte[] nextObjects = convertValue(nextBytes, null, Byte[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.BYTES_ALL);
        return this;
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param count   the number of bytes to read from the actual.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toByteArray(final int count, final Matcher<? super Byte[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, count);
        Byte[] nextObjects = convertValue(nextBytes, null, Byte[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.BYTES_COUNT_NEXT, count);
        return this;
    }

    /**
     * Check if the actual value's next byte is equal to the expected byte from the current position.
     *
     * @param expected the expected byte.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion isNextByteEqualTo(final int expected) {
        areNextBytesEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areNextBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toByteArray(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areNextBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toByteArray(expected.length).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areNextBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<Byte> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toByteArray(expectedList.size()).containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areAllBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toByteArray().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areAllBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toByteArray().containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion areAllBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<Byte> expectedList = convertValue(expected, null, List.class);
        toByteArray().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Make assertion about the hex representation of the bytes read from the actual from the current position.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        return toByteArray().toHexString();
    }

    /**
     * Make assertion about the hex representation of the bytes read from the actual from the current position.
     *
     * @param count the number of bytes to read from the actual.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString(final int count) {
        return toByteArray(count).toHexString();
    }

    /**
     * Make assertion about the hex representation of the bytes read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toHexString(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        toByteArray().toHexString(matcher);
        return this;
    }

    /**
     * Make assertion about the hex representation of the bytes read from the actual from the current position.
     *
     * @param count   the number of bytes to read from the actual.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toHexString(final int count, final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        toByteArray(count).toHexString(matcher);
        return this;
    }

    /**
     * Check if the hex representation of the bytes read from the actual from the current position is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion hasHexString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toByteArray().hasHexString(expected);
        return this;
    }

    /**
     * Check if the hex representation of the bytes read from the actual from the current position is equal to the expected value.
     *
     * @param count    the number of bytes to read from the actual.
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion hasHexString(final int count, final String expected) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(expected, "expected");
        toByteArray(count).hasHexString(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's available.
     *
     * @return the assertion.
     */
    public IntAssertion toAvailable() {
        checkActualIsNotNull();
        try {
            int available = getActual().available();
            return initializeAssertion(Raw.intAssertion(), available, Messages.Check.AVAILABLE);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Make assertion about the actual value's available.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toAvailable(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        try {
            int available = getActual().available();
            matcherAssertion(available, matcher, Messages.Check.AVAILABLE);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
        return this;
    }

    /**
     * Check if the actual value's available is equal to the expected available.
     *
     * @param expected the expected available.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion hasAvailable(final int expected) {
        toAvailable().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public LongAssertion toLength() {
        checkActualIsNotNull();
        long length = getLength();
        return initializeAssertion(Raw.longAssertion(), length, Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion toLength(final Matcher<? super Long> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        long length = getLength();
        matcherAssertion(length, matcher, Messages.Check.LENGTH);
        return this;
    }

    private long getLength() {
        try {
            int read;
            long length = 0;
            while (true) {
                read = getActual().read();
                if (read < 0) {
                    break;
                }
                length++;
            }
            return length;
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     *
     * @return current object for the chain call.
     */
    public InputStreamAssertion hasLength(final long expected) {
        toLength().isEqualTo(expected);
        return this;
    }

}
