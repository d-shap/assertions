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
import java.io.Writer;

/**
 * The writer mock.
 *
 * @author Dmitry Shapovalov
 */
public final class MockWriter extends Writer implements IsCloseable {

    private final char[] _content;

    private int _position;

    private final IOException _writeException;

    private final IOException _flushException;

    private final IOException _closeException;

    private boolean _isClosed;

    MockWriter(final int contentSize, final IOException writeException, final IOException flushException, final IOException closeException) {
        super();
        _content = new char[Math.max(0, contentSize)];
        _position = 0;
        _writeException = writeException;
        _flushException = flushException;
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
    public void write(final int value) throws IOException {
        doWrite(value);
    }

    @Override
    public void write(final char[] buffer, final int offset, final int length) throws IOException {
        if (buffer == null) {
            throw new NullPointerException("buffer is null");
        }
        if (offset < 0 || offset > buffer.length || length > 0 && offset == buffer.length) {
            throw new IndexOutOfBoundsException("offset is out of bounds");
        }
        if (length < 0 || offset + length > buffer.length) {
            throw new IndexOutOfBoundsException("length is out of bounds");
        }

        int value;
        int to = offset + length;
        for (int i = offset; i < to; i++) {
            value = buffer[i];
            doWrite(value);
        }
    }

    @Override
    public void write(final String value) throws IOException {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
        write(value.toCharArray(), 0, value.length());
    }

    @Override
    public void write(final String value, final int offset, final int length) throws IOException {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
        write(value.toCharArray(), offset, length);
    }

    private void doWrite(final int value) throws IOException {
        checkAndThrowException(_writeException, true);
        if (_position < _content.length) {
            _content[_position] = (char) value;
            _position++;
        }
    }

    @Override
    public void flush() throws IOException {
        checkAndThrowException(_flushException, true);
    }

    @Override
    public void close() throws IOException {
        boolean isClosed = _isClosed;
        _isClosed = true;
        if (!isClosed) {
            flush();
        }
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
    public char[] getContent() {
        char[] result = new char[_position];
        System.arraycopy(_content, 0, result, 0, _position);
        return result;
    }

    @Override
    public boolean isClosed() {
        return _isClosed;
    }

    /**
     * Builder for writer mock.
     */
    public static final class Builder {

        private int _contentSize;

        private IOException _writeException;

        private IOException _flushException;

        private IOException _closeException;

        Builder() {
            super();
            _contentSize = 0;
            _writeException = null;
            _flushException = null;
            _closeException = null;
        }

        /**
         * Set content size.
         *
         * @param contentSize content size.
         *
         * @return current object for the chain call.
         */
        public Builder setContentSize(final int contentSize) {
            _contentSize = contentSize;
            return this;
        }

        /**
         * Set exception for write call.
         *
         * @param exception exception for write call.
         *
         * @return current object for the chain call.
         */
        public Builder setWriteException(final IOException exception) {
            _writeException = exception;
            return this;
        }

        /**
         * Set exception for write call.
         *
         * @param exceptionMessage exception message for write call.
         *
         * @return current object for the chain call.
         */
        public Builder setWriteException(final String exceptionMessage) {
            _writeException = new IOException(exceptionMessage);
            return this;
        }

        /**
         * Set exception for flush call.
         *
         * @param exception exception for flush call.
         *
         * @return current object for the chain call.
         */
        public Builder setFlushException(final IOException exception) {
            _flushException = exception;
            return this;
        }

        /**
         * Set exception for flush call.
         *
         * @param exceptionMessage exception message for flush call.
         *
         * @return current object for the chain call.
         */
        public Builder setFlushException(final String exceptionMessage) {
            _flushException = new IOException(exceptionMessage);
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
        public Writer buildWriter() {
            return new MockWriter(_contentSize, _writeException, _flushException, _closeException);
        }

    }

}
