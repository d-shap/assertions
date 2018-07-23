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
package ru.d_shap.assertions.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;

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
        checkInitialized();
        checkActualIsNotNull();
        int nextByte = convertValue(getActual(), Integer.class);
        initializeAssertion(Raw.intAssertion(), nextByte, Messages.Check.ACTUAL_VALUE_BYTE).isLessThan(0);
    }

    /**
     * Check if the actual value contains more bytes.
     */
    public final void isNotCompleted() {
        checkInitialized();
        checkActualIsNotNull();
        int nextByte = convertValue(getActual(), Integer.class);
        initializeAssertion(Raw.intAssertion(), nextByte, Messages.Check.ACTUAL_VALUE_BYTE).isGreaterThanOrEqualTo(0);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final ByteArrayAssertion toByteArray() {
        checkInitialized();
        checkActualIsNotNull();
        byte[] nextBytes = convertValue(getActual(), byte[].class, 0);
        return initializeAssertion(Raw.byteArrayAssertion(), nextBytes, Messages.Check.ACTUAL_VALUE_BYTES_ALL);
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @param count the number of bytes to read from the actual.
     * @return the assertion.
     */
    public final ByteArrayAssertion toByteArray(final int count) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0);
        byte[] nextBytes = convertValue(getActual(), byte[].class, count);
        return initializeAssertion(Raw.byteArrayAssertion(), nextBytes, Messages.Check.ACTUAL_VALUE_BYTES_COUNT, count);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toByteArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        toByteArray(expected.length).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<Byte> expectedList = convertValue(expected, List.class);
        checkArgumentIsNotEmptyTrue(expectedList.isEmpty());
        toByteArray(expectedList.size()).containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toByteArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        toByteArray().containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<Byte> expectedList = convertValue(expected, List.class);
        toByteArray().containsExactlyInOrder(expectedList);
    }

    /**
     * Make assertion about the actual value's available.
     *
     * @return the assertion.
     */
    public final IntAssertion toAvailable() {
        try {
            checkInitialized();
            checkActualIsNotNull();
            return initializeAssertion(Raw.intAssertion(), getActual().available(), Messages.Check.ACTUAL_VALUE_AVAILABLE);
        } catch (IOException ex) {
            throw getAssertionErrorBuilder().addMessage(ex).addThrowable(ex).build();
        }
    }

    /**
     * Check if the actual value available is equal to the expected available.
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
        checkInitialized();
        checkActualIsNotNull();
        long length = convertValue(getActual(), Long.class);
        return initializeAssertion(Raw.longAssertion(), length, Messages.Check.ACTUAL_VALUE_LENGTH);
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final long expected) {
        toLength().isEqualTo(expected);
    }

}
