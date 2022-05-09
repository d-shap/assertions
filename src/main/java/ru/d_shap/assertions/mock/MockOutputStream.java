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
package ru.d_shap.assertions.mock;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The output stream mock.
 *
 * @author Dmitry Shapovalov
 */
public final class MockOutputStream extends OutputStream implements IsCloseable {

    private final byte[] _content;

    private int _position;

    private final IOException _writeException;

    private final IOException _flushException;

    private final IOException _closeException;

    private boolean _isClosed;

    MockOutputStream(final int size, final IOException writeException, final IOException flushException, final IOException closeException) {
        super();
        _content = new byte[size];
        _position = 0;
        _writeException = writeException;
        _flushException = flushException;
        _closeException = closeException;
        _isClosed = false;
    }

    @Override
    public void write(final int value) throws IOException {
        doWrite(value);
    }

    @Override
    public void write(final byte[] buffer, final int offset, final int length) throws IOException {
        if (buffer == null) {
            throw new NullPointerException("buffer is null");
        }
        if (offset < 0 || offset >= buffer.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (length < 0 || offset + length > buffer.length) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }
        if (length == 0) {
            return;
        }

        int value;
        int to = offset + length;
        for (int i = offset; i < to; i++) {
            value = buffer[i];
            doWrite(value);
        }
    }

    private void doWrite(final int value) throws IOException {
        checkAndThrowException(_writeException, true);
        _content[_position] = (byte) value;
        _position++;
    }

    @Override
    public void flush() throws IOException {
        checkAndThrowException(_flushException, true);
    }

    @Override
    public void close() throws IOException {
        if (!_isClosed) {
            flush();
        }
        _isClosed = true;
        checkAndThrowException(_closeException, false);
    }

    private void checkAndThrowException(final IOException exception, final boolean afterFullWrite) throws IOException {
        if (exception == null) {
            return;
        }
        if (!afterFullWrite || _content.length == _position) {
            throw exception;
        }
    }

    /**
     * Get the content writtent to this stream.
     *
     * @return the content writtent to this stream.
     */
    public byte[] getContent() {
        byte[] result = new byte[_position];
        System.arraycopy(_content, 0, result, 0, _position);
        return result;
    }

    @Override
    public boolean isClosed() {
        return _isClosed;
    }

}
