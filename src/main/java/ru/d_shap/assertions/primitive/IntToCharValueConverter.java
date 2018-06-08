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
 * Value converter for the int to char.
 *
 * @author Dmitry Shapovalov
 */
public class IntToCharValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public IntToCharValueConverter() {
        super();
    }

    @Override
    protected final Class<?> getValueClass() {
        return Integer.class;
    }

    @Override
    protected final Class<?> getTargetClass() {
        return Character.class;
    }

    @Override
    protected final boolean canConvert(final Object value) {
        int code = (int) value;
        char symbol = (char) code;
        return code == symbol;
    }

    @Override
    protected final Object convert(final Object value) {
        return (char) (int) value;
    }

}
