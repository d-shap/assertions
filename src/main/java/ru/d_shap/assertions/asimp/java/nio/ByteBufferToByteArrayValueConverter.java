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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;

import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the byte buffer to the byte array.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferToByteArrayValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public ByteBufferToByteArrayValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return ByteBuffer.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return byte[].class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        ByteBuffer castedValue = ConverterArgumentHelper.getValue(value, ByteBuffer.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        boolean castedRewind = ConverterArgumentHelper.getArgument(arguments, 0, Boolean.class);

        int position = castedValue.position();
        if (castedRewind) {
            castedValue.rewind();
        }
        byte[] result = new byte[castedValue.remaining()];
        for (int i = 0; i < result.length; i++) {
            result[i] = castedValue.get();
        }
        castedValue.position(position);
        return result;
    }

}
