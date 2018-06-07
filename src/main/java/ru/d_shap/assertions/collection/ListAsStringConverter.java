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
package ru.d_shap.assertions.collection;

import java.util.List;

import ru.d_shap.assertions.BaseAsStringConverter;

/**
 * Value to string converter for the list.
 *
 * @author Dmitry Shapovalov
 */
public class ListAsStringConverter extends BaseAsStringConverter<List<?>> {

    /**
     * Create new object.
     */
    public ListAsStringConverter() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<List<?>> getValueClass() {
        Class<?> rawActualValueClass = List.class;
        return (Class<List<?>>) rawActualValueClass;
    }

    @Override
    protected final String asString(final Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        boolean first = true;
        for (Object element : (List<?>) value) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(getChildValueAsString(element));
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
