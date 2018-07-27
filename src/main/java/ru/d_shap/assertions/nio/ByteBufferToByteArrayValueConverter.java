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
package ru.d_shap.assertions.nio;

import java.nio.ByteBuffer;

import ru.d_shap.assertions.BaseValueConverter;
import ru.d_shap.assertions.ConvertionException;

/**
 * Value converter from the byte buffer to the byte array.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferToByteArrayValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public ByteBufferToByteArrayValueConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return ByteBuffer.class;
    }

    @Override
    protected Class<?> getTargetClass() {
        return byte[].class;
    }

    @Override
    protected boolean canConvert(final Object value, final Object... arguments) throws ConvertionException {
        checkValueClass(value);
        return true;
    }

    @Override
    protected Object convert(final Object value, final Object... arguments) throws ConvertionException {
        checkValueClass(value);
        boolean rewind = (Boolean) arguments[0];
        int position = ((ByteBuffer) value).position();
        if (rewind) {
            ((ByteBuffer) value).rewind();
        }
        byte[] result = new byte[((ByteBuffer) value).remaining()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((ByteBuffer) value).get();
        }
        ((ByteBuffer) value).position(position);
        return result;
    }

}
