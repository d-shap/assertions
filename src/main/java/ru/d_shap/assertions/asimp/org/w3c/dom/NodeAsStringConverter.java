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

import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;

/**
 * Value to string converter for the node.
 *
 * @author Dmitry Shapovalov
 */
public final class NodeAsStringConverter implements AsStringConverterProvider {

    private static final TransformerFactory TRANSFORMER_FACTORY = TransformerFactory.newInstance();

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
        transform(source, result);
        return writer.toString();
    }

    void transform(final Source source, final Result result) {
        try {
            Transformer transformer = TRANSFORMER_FACTORY.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setErrorListener(new NoopErrorListener());
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            throw new ConversionException(ex);
        }
    }

    /**
     * Error listener to prevent output to system error stream.
     *
     * @author Dmitry Shapovalov
     */
    static final class NoopErrorListener implements ErrorListener {

        NoopErrorListener() {
            super();
        }

        @Override
        public void warning(final TransformerException exception) {
            // Ignore
        }

        @Override
        public void error(final TransformerException exception) {
            // Ignore
        }

        @Override
        public void fatalError(final TransformerException exception) {
            // Ignore
        }

    }

}
