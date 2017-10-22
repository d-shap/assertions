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

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the input stream.
 *
 * @author Dmitry Shapovalov
 */
public class InputStreamAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public InputStreamAssertion(final InputStream actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value does not contain any more bytes.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        new IntAssertion(actualAsInt(), getFailDescription(Messages.Check.ACTUAL_STREAM_BYTE_READ)).isLessThanOrEqualTo(-1);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expected.length), getFailDescription()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expected.length), getFailDescription()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        byte[] expectedBytes = ValueConverter.toByteArray(expected);
        checkArgumentIsNotEmptyTrue(expectedBytes.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expectedBytes.length), getFailDescription()).containsExactlyInOrder(expectedBytes);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expected.length + 1), getFailDescription()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expected.length + 1), getFailDescription()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        byte[] expectedBytes = ValueConverter.toByteArray(expected);
        checkArgumentIsNotEmptyTrue(expectedBytes.length == 0);
        new ByteArrayAssertion(actualAsByteArray(expectedBytes.length + 1), getFailDescription()).containsExactlyInOrder(expectedBytes);
    }

    private int actualAsInt() {
        try {
            InputStream actual = (InputStream) getActual();
            return actual.read();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    private byte[] actualAsByteArray(final int length) {
        try {
            InputStream actual = (InputStream) getActual();
            ByteArrayOutputStream baos = new ByteArrayOutputStream(length);
            int count = 0;
            while (true) {
                int read = actual.read();
                if (read < 0) {
                    break;
                }
                baos.write(read);
                count++;
                if (count >= length) {
                    break;
                }
            }
            return baos.toByteArray();
        } catch (IOException ex) {
            throw createAssertionError(ex.toString(), ex);
        }
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        return null;
    }

}
