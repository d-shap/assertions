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

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ValueConverter;

/**
 * Tests for {@link NodeAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class NodeAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public NodeAsStringConverterTest() {
        super();
    }

    /**
     * {@link NodeAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new NodeAsStringConverter().getValueClass()).isEqualTo(Node.class);
    }

    /**
     * {@link NodeAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<element/>"))).isEqualTo("<element/>");
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<element></element>"))).isEqualTo("<element/>");
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<element>aaa</element>"))).isEqualTo("<element>aaa</element>");
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<element attr='val'/>"))).isEqualTo("<element attr=\"val\"/>");
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<ns1:element xmlns:ns1='aaa'><!--comment--></ns1:element>"))).isEqualTo("<ns1:element xmlns:ns1=\"aaa\"><!--comment--></ns1:element>");
        Assertions.assertThat(new NodeAsStringConverter().asString(createNode("<ns1:element xmlns:ns1='aaa'><!--comment--><child>value</child></ns1:element>"))).isEqualTo("<ns1:element xmlns:ns1=\"aaa\"><!--comment--><child>value</child></ns1:element>");
    }

    /**
     * {@link NodeAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new NodeAsStringConverter().asString(null);
    }

    /**
     * {@link NodeAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new NodeAsStringConverter().asString(new Object());
    }

    private Node createNode(final String content) throws ConversionException {
        String element = "<element>" + content + "</element>";
        Document document = ValueConverter.convert(element, Document.class);
        Element documentElement = document.getDocumentElement();
        return documentElement.getFirstChild();
    }

}
