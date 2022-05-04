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
        if (content == null) {
            _content = new char[0];
        } else {
            _content = content;
        }
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
        return doRead(_readException);
    }

    @Override
    public int read(final char[] buffer, final int offset, final int length) throws IOException {
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
            return 0;
        }

        int count = 0;
        int read;
        int to = offset + length;
        for (int i = offset; i < to; i++) {
            read = doRead(_readException);
            if (read < 0) {
                break;
            }
            buffer[i] = (char) read;
            count++;
        }
        if (count == 0) {
            return -1;
        } else {
            return count;
        }
    }

    private int doRead(final IOException exception) throws IOException {
        checkAndThrowException(exception, true);
        if (_position < _content.length) {
            char result = _content[_position];
            _position++;
            return result;
        } else {
            return -1;
        }
    }

    @Override
    public long skip(final long count) throws IOException {
        long skipped = 0;
        int read;
        for (long i = 0; i < count; i++) {
            read = doRead(_skipException);
            if (read < 0) {
                break;
            }
            skipped++;
        }
        return skipped;
    }

    @Override
    public void close() throws IOException {
        _isClosed = true;
        checkAndThrowException(_closeException, false);
    }

    private void checkAndThrowException(final IOException exception, final boolean afterFullRead) throws IOException {
        if (exception == null) {
            return;
        }
        if (!afterFullRead || _content.length == _position) {
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
