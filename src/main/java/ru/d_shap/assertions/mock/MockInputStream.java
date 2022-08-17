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
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ValueConverter;

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
        if (content == null) {
            _content = new byte[0];
        } else {
            _content = content;
        }
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
        checkAndThrowException(_availableException, true);
        return _content.length - _position;
    }

    @Override
    public int read() throws IOException {
        int result = doRead(_readException);
        if (result == Integer.MIN_VALUE) {
            return -1;
        } else {
            return result & 255;
        }
    }

    @Override
    public int read(final byte[] buffer, final int offset, final int length) throws IOException {
        if (buffer == null) {
            throw new NullPointerException("buffer is null");
        }
        if (offset < 0 || offset > buffer.length || length > 0 && offset == buffer.length) {
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
            if (read == Integer.MIN_VALUE) {
                break;
            }
            buffer[i] = (byte) read;
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
            byte result = _content[_position];
            _position++;
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    @Override
    public long skip(final long count) throws IOException {
        long skipped = 0;
        int read;
        for (long i = 0; i < count; i++) {
            read = doRead(_skipException);
            if (read == Integer.MIN_VALUE) {
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
        public Builder setContent(final byte... content) {
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
        public Builder setContent(final int... content) {
            Object object = ValueConverter.convert(content, byte[].class);
            try {
                _content = (byte[]) object;
                return this;
            } catch (ClassCastException ex) {
                throw new ConversionException(ex);
            }
        }

        /**
         * Set content.
         *
         * @param content content.
         * @param charset charset to get bytes.
         *
         * @return current object for the chain call.
         */
        public Builder setContent(final String content, final Charset charset) {
            return setContent(content.getBytes(charset));
        }

        /**
         * Set content.
         *
         * @param content     content.
         * @param charsetName charset to get bytes.
         *
         * @return current object for the chain call.
         */
        public Builder setContent(final String content, final String charsetName) {
            try {
                return setContent(content.getBytes(charsetName));
            } catch (UnsupportedEncodingException ex) {
                throw new ConversionException(ex);
            }
        }

        /**
         * Set content.
         *
         * @param content content.
         *
         * @return current object for the chain call.
         */
        public Builder setContent(final String content) {
            return setContent(content, StandardCharsets.UTF_8);
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
         * @param check     if true then set exception.
         * @param exception exception for available call.
         *
         * @return current object for the chain call.
         */
        public Builder setAvailableException(final boolean check, final IOException exception) {
            if (check) {
                _availableException = exception;
            }
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
         * Set exception for available call.
         *
         * @param check            if true then set exception.
         * @param exceptionMessage exception message for available call.
         *
         * @return current object for the chain call.
         */
        public Builder setAvailableException(final boolean check, final String exceptionMessage) {
            if (check) {
                _availableException = new IOException(exceptionMessage);
            }
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
         * @param check     if true then set exception.
         * @param exception exception for read call.
         *
         * @return current object for the chain call.
         */
        public Builder setReadException(final boolean check, final IOException exception) {
            if (check) {
                _readException = exception;
            }
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
         * Set exception for read call.
         *
         * @param check            if true then set exception.
         * @param exceptionMessage exception message for read call.
         *
         * @return current object for the chain call.
         */
        public Builder setReadException(final boolean check, final String exceptionMessage) {
            if (check) {
                _readException = new IOException(exceptionMessage);
            }
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
         * @param check     if true then set exception.
         * @param exception exception for skip call.
         *
         * @return current object for the chain call.
         */
        public Builder setSkipException(final boolean check, final IOException exception) {
            if (check) {
                _skipException = exception;
            }
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
         * Set exception for skip call.
         *
         * @param check            if true then set exception.
         * @param exceptionMessage exception message for skip call.
         *
         * @return current object for the chain call.
         */
        public Builder setSkipException(final boolean check, final String exceptionMessage) {
            if (check) {
                _skipException = new IOException(exceptionMessage);
            }
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
         * @param check     if true then set exception.
         * @param exception exception for close call.
         *
         * @return current object for the chain call.
         */
        public Builder setCloseException(final boolean check, final IOException exception) {
            if (check) {
                _closeException = exception;
            }
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
         * Set exception for close call.
         *
         * @param check            if true then set exception.
         * @param exceptionMessage exception message for close call.
         *
         * @return current object for the chain call.
         */
        public Builder setCloseException(final boolean check, final String exceptionMessage) {
            if (check) {
                _closeException = new IOException(exceptionMessage);
            }
            return this;
        }

        /**
         * Build new mock object.
         *
         * @return the created mock object.
         */
        public InputStream buildInputStream() {
            return new MockInputStream(_content, _availableException, _readException, _skipException, _closeException);
        }

    }

}
