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

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Helper class to create XML Document.
 *
 * @author Dmitry Shapovalov
 */
public final class XmlDocumentBuilder {

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY;

    static {
        DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
        DOCUMENT_BUILDER_FACTORY.setNamespaceAware(true);
    }

    private XmlDocumentBuilder() {
        super();
    }

    /**
     * Parse the input string and create XML Document.
     *
     * @param str the input string.
     *
     * @return XML Document.
     *
     * @throws ParserConfigurationException if parser configuration exception occured.
     * @throws SAXException                 if the input string is not a valid XML Document.
     * @throws IOException                  if IO exception occured.
     */
    public static Document parse(final String str) throws ParserConfigurationException, SAXException, IOException {
        StringReader reader = new StringReader(str);
        InputSource inputSource = new InputSource(reader);
        return parse(inputSource);
    }

    /**
     * Parse the input source and create XML Document.
     *
     * @param inputSource the input source.
     *
     * @return XML Document.
     *
     * @throws ParserConfigurationException if parser configuration exception occured.
     * @throws SAXException                 if the input string is not a valid XML Document.
     * @throws IOException                  if IO exception occured.
     */
    public static Document parse(final InputSource inputSource) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
        documentBuilder.setErrorHandler(null);
        return documentBuilder.parse(inputSource);
    }

}
