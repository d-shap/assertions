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

import java.nio.FloatBuffer;

import ru.d_shap.assertions.BaseValueConverter;
import ru.d_shap.assertions.ConvertionException;

/**
 * Value converter from the float buffer to the float array.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferToFloatArrayValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public FloatBufferToFloatArrayValueConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return FloatBuffer.class;
    }

    @Override
    protected Class<?> getTargetClass() {
        return float[].class;
    }

    @Override
    protected boolean canConvert(final Object value, final Object... arguments) throws ConvertionException {
        return true;
    }

    @Override
    protected Object convert(final Object value, final Object... arguments) throws ConvertionException {
        boolean rewind = (Boolean) arguments[0];
        int position = ((FloatBuffer) value).position();
        if (rewind) {
            ((FloatBuffer) value).rewind();
        }
        float[] result = new float[((FloatBuffer) value).remaining()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((FloatBuffer) value).get();
        }
        ((FloatBuffer) value).position(position);
        return result;
    }

}
