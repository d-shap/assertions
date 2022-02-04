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
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.asimp.primitive.LongAssertion;

/**
 * Assertions for the input stream.
 *
 * @author Dmitry Shapovalov
 */
public class InputStreamAssertion extends ReferenceAssertion<InputStream> {

    /**
     * Create new object.
     */
    public InputStreamAssertion() {
        super();
    }

    @Override
    protected final Class<InputStream> getActualValueClass() {
        return InputStream.class;
    }

    /**
     * Check if the actual value does not contain any more bytes.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        try {
            int nextByte = getActual().read();
            if (nextByte >= 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Check if the actual value contains more bytes.
     */
    public final void isNotCompleted() {
        checkActualIsNotNull();
        try {
            int nextByte = getActual().read();
            if (nextByte < 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_COMPLETED).build();
            }
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final ByteArrayAssertion toByteArray() {
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
    public final ByteArrayAssertion toByteArray(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, count);
        return initializeAssertion(Raw.byteArrayAssertion(), nextBytes, Messages.Check.BYTES_COUNT, count);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toByteArray(final Matcher<Byte[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, 0);
        Byte[] nextObjects = convertValue(nextBytes, null, Byte[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.BYTES_ALL);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param count   the number of bytes to read from the actual.
     * @param matcher the hamcrest matcher.
     */
    public final void toByteArray(final int count, final Matcher<Byte[]> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        byte[] nextBytes = convertValue(getActual(), null, byte[].class, count);
        Byte[] nextObjects = convertValue(nextBytes, null, Byte[].class);
        matcherAssertion(nextObjects, matcher, Messages.Check.BYTES_COUNT, count);
    }

    /**
     * Check if the actual value's next byte is equal to the expected byte from the current position.
     *
     * @param expected the expected byte.
     */
    public final void isNextByteEqualTo(final int expected) {
        isNextBytesEqualTo(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toByteArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.length == 0, "expected", true);
        toByteArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<Byte> expectedList = convertValue(expected, null, List.class);
        checkArgumentIsNotEmpty(expectedList.isEmpty(), "expected", true);
        toByteArray(expectedList.size()).containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toByteArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toByteArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        List<Byte> expectedList = convertValue(expected, null, List.class);
        toByteArray().containsExactlyInOrder(expectedList);
    }

    /**
     * Make assertion about the actual value's available.
     *
     * @return the assertion.
     */
    public final IntAssertion toAvailable() {
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
     */
    public final void toAvailable(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        try {
            int available = getActual().available();
            matcherAssertion(available, matcher, Messages.Check.AVAILABLE);
        } catch (IOException ex) {
            throw createWrapperAssertionError(ex);
        }
    }

    /**
     * Check if the actual value's available is equal to the expected available.
     *
     * @param expected the expected available.
     */
    public final void hasAvailable(final int expected) {
        toAvailable().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final LongAssertion toLength() {
        checkActualIsNotNull();
        long length = getLength();
        return initializeAssertion(Raw.longAssertion(), length, Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLength(final Matcher<Long> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        long length = getLength();
        matcherAssertion(length, matcher, Messages.Check.LENGTH);
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
     */
    public final void hasLength(final long expected) {
        toLength().isEqualTo(expected);
    }

}
