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
package ru.d_shap.assertions.primitive;

import ru.d_shap.assertions.BaseValueConverter;

/**
 * Value converter from the int to the byte.
 *
 * @author Dmitry Shapovalov
 */
public class IntToByteValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public IntToByteValueConverter() {
        super();
    }

    @Override
    protected final Class<?> getValueClass() {
        return Integer.class;
    }

    @Override
    protected final Class<?> getTargetClass() {
        return Byte.class;
    }

    @Override
    protected final boolean canConvert(final Object value) {
        int intValue = (int) value;
        byte byteValue = (byte) intValue;
        return intValue == byteValue;
    }

    @Override
    protected final Object convert(final Object value) {
        return (byte) (int) value;
    }

}