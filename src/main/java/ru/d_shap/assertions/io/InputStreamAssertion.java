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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.utils.ValueConverter;

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
        initializeAssertion(Raw.intAssertion(), readActual(), Messages.Check.ACTUAL_VALUE_BYTE).isLessThan(0);
    }

    /**
     * Check if the actual value contains more bytes.
     */
    public final void isNotCompleted() {
        checkInitialized();
        checkActualIsNotNull();
        initializeAssertion(Raw.intAssertion(), readActual(), Messages.Check.ACTUAL_VALUE_BYTE).isGreaterThanOrEqualTo(0);
    }

    private int readActual() {
        try {
            return getActual().read();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Make assertion about the bytes read from the actual from the current position.
     *
     * @return the assertion.
     */
    public final ByteArrayAssertion toByteArray() {
        checkInitialized();
        checkActualIsNotNull();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                int read = getActual().read();
                if (read < 0) {
                    break;
                }
                baos.write(read);
            }
            return initializeAssertion(Raw.byteArrayAssertion(), baos.toByteArray(), Messages.Check.ACTUAL_VALUE_BYTES_ALL);
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
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
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(count);
            int readCount = 0;
            while (readCount < count) {
                int read = getActual().read();
                if (read < 0) {
                    break;
                }
                baos.write(read);
                readCount++;
            }
            return initializeAssertion(Raw.byteArrayAssertion(), baos.toByteArray(), Messages.Check.ACTUAL_VALUE_BYTES_COUNT, count);
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
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
        byte[] expectedBytes = ValueConverter.toByteArray(expected);
        checkArgumentIsNotEmptyTrue(expectedBytes.length == 0);
        toByteArray(expectedBytes.length).containsExactlyInOrder(expectedBytes);
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
        byte[] expectedBytes = ValueConverter.toByteArray(expected);
        toByteArray().containsExactlyInOrder(expectedBytes);
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
            throw createAssertionError(ex.toString(), ex);
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
        try {
            long length = 0;
            while (true) {
                int read = getActual().read();
                if (read < 0) {
                    break;
                }
                length++;
            }
            return initializeAssertion(Raw.longAssertion(), length, Messages.Check.ACTUAL_VALUE_LENGTH);
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final long expected) {
        toLength().isEqualTo(expected);
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
