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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * The reader mock.
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

    MockReader(final char[] content, final IOException readException, final IOException skipException, final IOException closeException) {
        super();
        _content = content;
        _position = 0;
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

    /**
     * Builder for the reader mock.
     */
    public static final class Builder {

        private char[] _content;

        private IOException _readException;

        private IOException _skipException;

        private IOException _closeException;

        Builder() {
            super();
            _content = null;
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
        public Builder setContent(final char[] content) {
            _content = content;
            return this;
        }

        /**
         * Set content.
         *
         * @param content content.
         *
         * @return current object for the chain call.
         */
        public Builder setContent(final String content) {
            _content = content.toCharArray();
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
        public Reader buildReader() {
            return new MockReader(_content, _readException, _skipException, _closeException);
        }

        /**
         * Build new mock object.
         *
         * @return the created mock object.
         */
        public BufferedReader buildBufferedReader() {
            Reader reader = buildReader();
            return new BufferedReader(reader);
        }

    }

}
