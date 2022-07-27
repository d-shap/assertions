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

import org.hamcrest.Matcher;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.converter.ConversionExceptionHolder;

/**
 * Assertions for the element.
 *
 * @author Dmitry Shapovalov
 */
public final class ElementAssertion extends ReferenceAssertion<Element> {

    /**
     * Create new object.
     */
    public ElementAssertion() {
        super();
    }

    @Override
    protected Class<Element> getActualValueClass() {
        return Element.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isEqualTo(final Element expected) {
        createNodeAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isEqualTo(final String expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            Element expectedElement = convertValue(expected, conversionExceptionHolder, Element.class);
            checkArgumentIsValid(conversionExceptionHolder, "expected", Messages.Fail.Argument.IS_VALID_XML);
            createNodeAssertion().isEqualTo(expectedElement);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isNotEqualTo(final Element expected) {
        createNodeAssertion().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isNotEqualTo(final String expected) {
        ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
        Element expectedElement = convertValue(expected, conversionExceptionHolder, Element.class);
        checkArgumentIsValid(conversionExceptionHolder, "expected", Messages.Fail.Argument.IS_VALID_XML);
        createNodeAssertion().isNotEqualTo(expectedElement);
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toNamespaceURI() {
        return createNodeAssertion().toNamespaceURI();
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toNamespaceURI(final Matcher<? super String> matcher) {
        createNodeAssertion().toNamespaceURI(matcher);
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasNamespaceURI(final String expected) {
        createNodeAssertion().hasNamespaceURI(expected);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toPrefix() {
        return createNodeAssertion().toPrefix();
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toPrefix(final Matcher<? super String> matcher) {
        createNodeAssertion().toPrefix(matcher);
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasPrefix(final String expected) {
        createNodeAssertion().hasPrefix(expected);
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toLocalName() {
        return createNodeAssertion().toLocalName();
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toLocalName(final Matcher<? super String> matcher) {
        createNodeAssertion().toLocalName(matcher);
    }

    /**
     * Check if the actual value's local name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasLocalName(final String expected) {
        createNodeAssertion().hasLocalName(expected);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toQualifiedName() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getTagName(), Messages.Check.QUALIFIED_NAME);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toQualifiedName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getTagName(), matcher, Messages.Check.QUALIFIED_NAME);
    }

    /**
     * Check if the actual value's qualified name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasQualifiedName(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toQualifiedName().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalName the expected local name.
     */
    public void hasProperties(final String expectedLocalName) {
        createNodeAssertion().hasProperties(expectedLocalName);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalName    the expected local name.
     */
    public void hasProperties(final String expectedNamespaceURI, final String expectedLocalName) {
        createNodeAssertion().hasProperties(expectedNamespaceURI, expectedLocalName);
    }

    /**
     * Check if the actual value has the specified attribute.
     *
     * @param localName the specified local name.
     */
    public void hasAttribute(final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        if (getActual().getAttributeNode(localName) == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_ATTRIBUTE).addActual().addRawExpected(new QName(localName), QName.class).build();
        }
    }

    /**
     * Check if the actual value has the specified attribute.
     *
     * @param namespaceURI the specified namespace URI.
     * @param localName    the specified local name.
     */
    public void hasAttribute(final String namespaceURI, final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        if (getActual().getAttributeNodeNS(namespaceURI, localName) == null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_ATTRIBUTE).addActual().addRawExpected(new QName(namespaceURI, localName), QName.class).build();
        }
    }

    /**
     * Check if the actual value has NOT the specified attribute.
     *
     * @param localName the specified local name.
     */
    public void hasNotAttribute(final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        if (getActual().getAttributeNode(localName) != null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_NOT_ATTRIBUTE).addActual().addRawExpected(new QName(localName), QName.class).build();
        }
    }

    /**
     * Check if the actual value has NOT the specified attribute.
     *
     * @param namespaceURI the specified namespace URI.
     * @param localName    the specified local name.
     */
    public void hasNotAttribute(final String namespaceURI, final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        if (getActual().getAttributeNodeNS(namespaceURI, localName) != null) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_NOT_ATTRIBUTE).addActual().addRawExpected(new QName(namespaceURI, localName), QName.class).build();
        }
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     *
     * @return the assertion.
     */
    public AttrAssertion toAttribute(final String localName) {
        hasAttribute(localName);
        return initializeAssertion(Raw.attrAssertion(), getActual().getAttributeNode(localName), Messages.Check.ATTRIBUTE, new QName(localName));
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     *
     * @return the assertion.
     */
    public AttrAssertion toAttribute(final String namespaceURI, final String localName) {
        hasAttribute(namespaceURI, localName);
        return initializeAssertion(Raw.attrAssertion(), getActual().getAttributeNodeNS(namespaceURI, localName), Messages.Check.ATTRIBUTE, new QName(namespaceURI, localName));
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     * @param matcher   the hamcrest matcher.
     */
    public void toAttribute(final String localName, final Matcher<? super Attr> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(matcher, "matcher");
        hasAttribute(localName);
        matcherAssertion(getActual().getAttributeNode(localName), matcher, Messages.Check.ATTRIBUTE, new QName(localName));
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     * @param matcher      the hamcrest matcher.
     */
    public void toAttribute(final String namespaceURI, final String localName, final Matcher<? super Attr> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(matcher, "matcher");
        hasAttribute(namespaceURI, localName);
        matcherAssertion(getActual().getAttributeNodeNS(namespaceURI, localName), matcher, Messages.Check.ATTRIBUTE, new QName(namespaceURI, localName));
    }

    /**
     * Check if the actual value has the specified attribute with the specified value.
     *
     * @param localName the local name of the actual value's attribute.
     * @param value     the value of the actual value's attribute.
     */
    public void hasAttributeValue(final String localName, final String value) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(value, "value");
        toAttribute(localName).hasValue(value);
    }

    /**
     * Check if the actual value has the specified attribute with the specified value.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     * @param value        the value of the actual value's attribute.
     */
    public void hasAttributeValue(final String namespaceURI, final String localName, final String value) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(value, "value");
        toAttribute(namespaceURI, localName).hasValue(value);
    }

    /**
     * Check if the actual value has NOT the specified attribute with the specified value.
     *
     * @param localName the local name of the actual value's attribute.
     * @param value     the value of the actual value's attribute.
     */
    public void hasNotAttributeValue(final String localName, final String value) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(value, "value");
        if (getActual().getAttributeNode(localName) != null) {
            toAttribute(localName).toValue().isNotEqualTo(value);
        }
    }

    /**
     * Check if the actual value has NOT the specified attribute with the specified value.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     * @param value        the value of the actual value's attribute.
     */
    public void hasNotAttributeValue(final String namespaceURI, final String localName, final String value) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(value, "value");
        if (getActual().getAttributeNodeNS(namespaceURI, localName) != null) {
            toAttribute(namespaceURI, localName).toValue().isNotEqualTo(value);
        }
    }

    /**
     * Check if the actual value has child nodes.
     */
    public void hasChildNodes() {
        checkActualIsNotNull();
        if (!getActual().hasChildNodes()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_CHILD_NODES).addActual().build();
        }
    }

    /**
     * Check if the actual value has NOT child nodes.
     */
    public void hasNotChildNodes() {
        checkActualIsNotNull();
        if (getActual().hasChildNodes()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_NOT_CHILD_NODES).addActual().build();
        }
    }

    /**
     * Make assertion about the actual value's child nodes count.
     *
     * @return the assertion.
     */
    public IntAssertion toChildNodesCount() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getChildNodes().getLength(), Messages.Check.CHILD_NODES_COUNT);
    }

    /**
     * Make assertion about the actual value's child nodes count.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toChildNodesCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getChildNodes().getLength(), matcher, Messages.Check.CHILD_NODES_COUNT);
    }

    /**
     * Check if the actual value's child nodes count is equal to the expected count.
     *
     * @param expected the expected count.
     */
    public void hasChildNodesCount(final int expected) {
        toChildNodesCount().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's child elements count.
     *
     * @return the assertion.
     */
    public IntAssertion toChildElementsCount() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getChildElementsCount(), Messages.Check.CHILD_ELEMENTS_COUNT);
    }

    /**
     * Make assertion about the actual value's child elements count.
     *
     * @param matcher the expected count.
     */
    public void toChildElementsCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getChildElementsCount(), matcher, Messages.Check.CHILD_ELEMENTS_COUNT);
    }

    private int getChildElementsCount() {
        NodeList nodeList = getActual().getChildNodes();
        int count = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                count++;
            }
        }
        return count;
    }

    /**
     * Check if the actual value's child elements count is equal to the expected count.
     *
     * @param expected the expected count.
     */
    public void hasChildElementsCount(final int expected) {
        toChildElementsCount().isEqualTo(expected);
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

}
