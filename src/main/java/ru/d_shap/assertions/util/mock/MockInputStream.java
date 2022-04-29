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
 * The input stream mock.
 *
 * @author Dmitry Shapovalov
 */
public final class MockInputStream extends InputStream implements IsCloseable {

    private final byte[] _content;

    private int _position;

    private final IOException _availableException;

    private final IOException _readException;

    private final IOException _skipException;

    private final IOException _closeException;

    private boolean _isClosed;

    MockInputStream(final byte[] content, final IOException availableException, final IOException readException, final IOException skipException, final IOException closeException) {
        super();
        _content = content;
        _position = 0;
        _availableException = availableException;
        _readException = readException;
        _skipException = skipException;
        _closeException = closeException;
        _isClosed = false;
    }

    /**
     * Create new builder for mock object.
     *
     * @return new builder for mock object.
     */
    public static Builder builder() {
        return new Builder();
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

    /**
     * Builder for the input stream mock.
     */
    public static final class Builder {

        private byte[] _content;

        private IOException _availableException;

        private IOException _readException;

        private IOException _skipException;

        private IOException _closeException;

        Builder() {
            super();
            _content = null;
            _availableException = null;
            _readException = null;
            _skipException = null;
            _closeException = null;
        }

        /**
         * Set content.
         *
         * @param content content.
         *
         * @return current object for the chain call.
         */
        public Builder setContent(final byte[] content) {
            _content = content;
            return this;
        }

        /**
         * Set exception for available call.
         *
         * @param exception exception for available call.
         *
         * @return current object for the chain call.
         */
        public Builder setAvailableException(final IOException exception) {
            _availableException = exception;
            return this;
        }

        /**
         * Set exception for available call.
         *
         * @param exceptionMessage exception message for available call.
         *
         * @return current object for the chain call.
         */
        public Builder setAvailableException(final String exceptionMessage) {
            _availableException = new IOException(exceptionMessage);
            return this;
        }

        /**
         * Set exception for read call.
         *
         * @param exception exception for read call.
         *
         * @return current object for the chain call.
         */
        public Builder setReadException(final IOException exception) {
            _readException = exception;
            return this;
        }

        /**
         * Set exception for read call.
         *
         * @param exceptionMessage exception message for read call.
         *
         * @return current object for the chain call.
         */
        public Builder setReadException(final String exceptionMessage) {
            _readException = new IOException(exceptionMessage);
            return this;
        }

        /**
         * Set exception for skip call.
         *
         * @param exception exception for skip call.
         *
         * @return current object for the chain call.
         */
        public Builder setSkipException(final IOException exception) {
            _skipException = exception;
            return this;
        }

        /**
         * Set exception for skip call.
         *
         * @param exceptionMessage exception message for skip call.
         *
         * @return current object for the chain call.
         */
        public Builder setSkipException(final String exceptionMessage) {
            _skipException = new IOException(exceptionMessage);
            return this;
        }

        /**
         * Set exception for close call.
         *
         * @param exception exception for close call.
         *
         * @return current object for the chain call.
         */
        public Builder setCloseException(final IOException exception) {
            _closeException = exception;
            return this;
        }

        /**
         * Set exception for close call.
         *
         * @param exceptionMessage exception message for close call.
         *
         * @return current object for the chain call.
         */
        public Builder setCloseException(final String exceptionMessage) {
            _closeException = new IOException(exceptionMessage);
            return this;
        }

        /**
         * Build new mock object.
         *
         * @return the created mock object.
         */
        public MockInputStream build() {
            return new MockInputStream(_content, _availableException, _readException, _skipException, _closeException);
        }

    }

}
