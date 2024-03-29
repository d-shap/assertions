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
package ru.d_shap.assertions.asimp.org.w3c.dom;

import javax.xml.namespace.QName;

import org.w3c.dom.Attr;

import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;

/**
 * Value to string converter for the attr.
 *
 * @author Dmitry Shapovalov
 */
public final class AttrAsStringConverter implements AsStringConverterProvider {

    /**
     * Create new object.
     */
    public AttrAsStringConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Attr.class;
    }

    @Override
    public String asString(final Object value) {
        Attr castedValue = ConverterArgumentHelper.getValue(value, Attr.class);

        QName qName = new QName(castedValue.getNamespaceURI(), castedValue.getLocalName());
        return qName + "=" + castedValue.getValue();
    }

}
