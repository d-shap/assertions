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

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Value to string converter for the node.
 *
 * @author Dmitry Shapovalov
 */
public final class NodeAsStringConverter implements AsStringConverterProvider {

    /**
     * Create new object.
     */
    public NodeAsStringConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Node.class;
    }

    @Override
    public String asString(final Object value) {
        Node castedValue = ConverterArgumentHelper.getValue(value, Node.class);

        Source source = new DOMSource(castedValue);
        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        Transformer transformer = DataHelper.createTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            throw new ConversionException(ex);
        }
        return writer.toString();
    }

}
