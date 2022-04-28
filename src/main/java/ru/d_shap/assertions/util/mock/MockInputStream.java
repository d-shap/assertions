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
package ru.d_shap.assertions.util.mock;

import java.io.IOException;
import java.io.InputStream;

import ru.d_shap.assertions.util.IsCloseable;

/**
 * Mock object for the input stream.
 *
 * @author Dmitry Shapovalov
 */
public final class MockInputStream extends InputStream implements IsCloseable {

    private final byte[] _content;

    private int _position;

    private final IOException _availableException;

    private final IOException _readException;

    private final IOException _closeException;

    private boolean _isClosed;

    /**
     * Create new object.
     *
     * @param content            the content to read from stream.
     * @param availableException exception to throw when available byte count is checked.
     * @param readException      exception to throw when bytes are read.
     * @param closeException     exception to throw when stream is closed.
     */
    public MockInputStream(final byte[] content, final IOException availableException, final IOException readException, final IOException closeException) {
        super();
        _content = content;
        _position = 0;
        _availableException = availableException;
        _readException = readException;
        _closeException = closeException;
        _isClosed = false;
    }

    @Override
    public int available() throws IOException {
        checkAndThrowException(_availableException);
        return _content.length - _position;
    }

    @Override
    public int read() throws IOException {
        checkAndThrowException(_readException);
        if (_position < _content.length) {
            byte result = _content[_position];
            _position++;
            return result;
        } else {
            return -1;
        }
    }

    @Override
    public int read(final byte[] buffer, final int from, final int to) throws IOException {
        checkAndThrowException(_readException);
        if (_position < _content.length) {
            int length = to - from;
            int available = _content.length - _position;
            length = Math.min(length, available);
            System.arraycopy(_content, _position, buffer, from, length);
            _position += length;
            return length;
        } else {
            return -1;
        }
    }

    @Override
    public void close() throws IOException {
        _isClosed = true;
        checkAndThrowException(_closeException);
    }

    private void checkAndThrowException(final IOException exception) throws IOException {
        if (exception == null) {
            return;
        }
        if (_content == null || _content.length == _position) {
            throw exception;
        }
    }

    @Override
    public boolean isClosed() {
        return _isClosed;
    }

}
