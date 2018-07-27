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

import java.nio.ShortBuffer;

import ru.d_shap.assertions.BaseValueConverter;
import ru.d_shap.assertions.ConvertionException;

/**
 * Value converter from the short buffer to the short array.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferToShortArrayValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public ShortBufferToShortArrayValueConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return ShortBuffer.class;
    }

    @Override
    protected Class<?> getTargetClass() {
        return short[].class;
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
        int position = ((ShortBuffer) value).position();
        if (rewind) {
            ((ShortBuffer) value).rewind();
        }
        short[] result = new short[((ShortBuffer) value).remaining()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((ShortBuffer) value).get();
        }
        ((ShortBuffer) value).position(position);
        return result;
    }

}
