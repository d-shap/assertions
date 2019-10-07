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
package ru.d_shap.assertions.asimp.java.lang;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;

/**
 * Value to string converter for the iterable.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAsStringConverter implements AsStringConverterProvider {

    /**
     * Create new object.
     */
    public IterableAsStringConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Iterable.class;
    }

    @Override
    public String asString(final Object value) throws ConversionException {
        Iterable<?> castedValue = ConverterArgumentHelper.getValue(value, Iterable.class);

        StringBuilder result = new StringBuilder();
        result.append('[');
        boolean first = true;
        for (Object element : castedValue) {
            if (first) {
                first = false;
            } else {
                result.append(", ");
            }
            result.append(AsStringConverter.asString(element));
        }
        result.append(']');
        if (first) {
            return Messages.EMPTY;
        } else {
            return result.toString();
        }
    }

}
