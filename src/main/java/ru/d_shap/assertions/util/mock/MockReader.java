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
import java.io.Reader;

import ru.d_shap.assertions.util.IsCloseable;

/**
 * Mock object for the reader.
 *
 * @author Dmitry Shapovalov
 */
public final class MockReader extends Reader implements IsCloseable {

    private final char[] _content;

    private int _position;

    private final IOException _readException;

    private final IOException _skipException;

    private final IOException _closeException;

    private boolean _isClosed;

    /**
     * Create new object.
     *
     * @param content        the content to read from stream.
     * @param readException  exception to throw when bytes are read.
     * @param skipException  exception to throw when bytes are skipped.
     * @param closeException exception to throw when stream is closed.
     */
    public MockReader(final char[] content, final IOException readException, final IOException skipException, final IOException closeException) {
        super();
        _content = content;
        _position = 0;
        _readException = readException;
        _skipException = skipException;
        _closeException = closeException;
        _isClosed = false;
    }

    @Override
    public int read() throws IOException {
        checkAndThrowException(_readException);
        if (_position < _content.length) {
            char result = _content[_position];
            _position++;
            return result;
        } else {
            return -1;
        }
    }

    @Override
    public int read(final char[] buffer, final int from, final int to) throws IOException {
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
    public long skip(final long count) throws IOException {
        checkAndThrowException(_skipException);
        int length = (int) count;
        int available = _content.length - _position;
        if (length > available) {
            _position = _content.length;
            return available;
        } else {
            _position += length;
            return length;
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
