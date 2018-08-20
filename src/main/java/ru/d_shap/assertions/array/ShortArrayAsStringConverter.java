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
package ru.d_shap.assertions.array;

import java.util.List;

import ru.d_shap.assertions.BaseAsStringConverter;
import ru.d_shap.assertions.ConversionException;

/**
 * Value to string converter for the short array.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAsStringConverter extends BaseAsStringConverter {

    /**
     * Create new object.
     */
    public ShortArrayAsStringConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return short[].class;
    }

    @Override
    protected String convertToString(final Object value) throws ConversionException {
        return convertValueToString(value, List.class);
    }

}
