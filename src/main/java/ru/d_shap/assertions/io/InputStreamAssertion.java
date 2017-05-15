///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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
import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.ReferenceAssertion;
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
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public InputStreamAssertion(final InputStream actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value does not contain any more bytes.
     */
    public final void isCompleted() {
        checkActualIsNotNull();
        new IntAssertion(actualAsInt(), getMessage()).isLessThanOrEqualTo(-1);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new ByteArrayAssertion(actualAsByteArray(expected.length), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new ByteArrayAssertion(actualAsByteArray(expected.length), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position.
     *
     * @param expected the expected bytes.
     */
    public final void isNextBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        byte[] expectedBytes = iterableToArray(expected);
        new ByteArrayAssertion(actualAsByteArray(expectedBytes.length), getMessage()).containsExactlyInOrder(expectedBytes);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final byte... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new ByteArrayAssertion(actualAsByteArray(expected.length + 1), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final int... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        new ByteArrayAssertion(actualAsByteArray(expected.length + 1), getMessage()).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains the expected bytes from the current position and does not contain any more bytes.
     *
     * @param expected the expected bytes.
     */
    public final void isAllBytesEqualTo(final Iterable<Byte> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        byte[] expectedBytes = iterableToArray(expected);
        new ByteArrayAssertion(actualAsByteArray(expectedBytes.length + 1), getMessage()).containsExactlyInOrder(expectedBytes);
    }

    private int actualAsInt() {
        try {
            InputStream actual = (InputStream) getActual();
            return actual.read();
        } catch (IOException ex) {
            throw createAssertionError(ex);
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
            throw createAssertionError(ex);
        }
    }

    private byte[] iterableToArray(final Iterable<Byte> expected) {
        List<Byte> list = new ArrayList<>();
        for (Byte value : expected) {
            list.add(value);
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    @Override
    protected final String asString(final Object value) {
        return null;
    }

}
