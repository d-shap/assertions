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

import org.hamcrest.Matcher;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.converter.ConversionExceptionHolder;

/**
 * Assertions for the document.
 *
 * @author Dmitry Shapovalov
 */
public final class DocumentAssertion extends ReferenceAssertion<Document> {

    /**
     * Create new object.
     */
    public DocumentAssertion() {
        super();
    }

    @Override
    protected Class<Document> getActualValueClass() {
        return Document.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isEqualTo(final Document expected) {
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
            Document expectedDocument = convertValue(expected, conversionExceptionHolder, Document.class);
            checkArgumentIsValid(conversionExceptionHolder, "expected", Messages.Fail.Argument.IS_VALID_XML);
            createNodeAssertion().isEqualTo(expectedDocument);
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isNotEqualTo(final Document expected) {
        createNodeAssertion().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isNotEqualTo(final String expected) {
        ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
        Document expectedDocument = convertValue(expected, conversionExceptionHolder, Document.class);
        checkArgumentIsValid(conversionExceptionHolder, "expected", Messages.Fail.Argument.IS_VALID_XML);
        createNodeAssertion().isNotEqualTo(expectedDocument);
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toNamespaceURI() {
        checkActualIsNotNull();
        return createElementAssertion().toNamespaceURI();
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toNamespaceURI(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toNamespaceURI(matcher);
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasNamespaceURI(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasNamespaceURI(expected);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toPrefix() {
        checkActualIsNotNull();
        return createElementAssertion().toPrefix();
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toPrefix(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toPrefix(matcher);
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasPrefix(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasPrefix(expected);
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toLocalName() {
        checkActualIsNotNull();
        return createElementAssertion().toLocalName();
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toLocalName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toLocalName(matcher);
    }

    /**
     * Check if the actual value's local name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasLocalName(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasLocalName(expected);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toQualifiedName() {
        checkActualIsNotNull();
        return createElementAssertion().toQualifiedName();
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toQualifiedName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toQualifiedName(matcher);
    }

    /**
     * Check if the actual value's qualified name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasQualifiedName(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasQualifiedName(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalName the expected local name.
     */
    public void hasProperties(final String expectedLocalName) {
        checkActualIsNotNull();
        createElementAssertion().hasProperties(expectedLocalName);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalName    the expected local name.
     */
    public void hasProperties(final String expectedNamespaceURI, final String expectedLocalName) {
        checkActualIsNotNull();
        createElementAssertion().hasProperties(expectedNamespaceURI, expectedLocalName);
    }

    /**
     * Check if the actual value has the specified attribute.
     *
     * @param localName the specified local name.
     */
    public void hasAttribute(final String localName) {
        checkActualIsNotNull();
        createElementAssertion().hasAttribute(localName);
    }

    /**
     * Check if the actual value has the specified attribute.
     *
     * @param namespaceURI the specified namespace URI.
     * @param localName    the specified local name.
     */
    public void hasAttribute(final String namespaceURI, final String localName) {
        checkActualIsNotNull();
        createElementAssertion().hasAttribute(namespaceURI, localName);
    }

    /**
     * Check if the actual value has NOT the specified attribute.
     *
     * @param localName the specified local name.
     */
    public void hasNotAttribute(final String localName) {
        checkActualIsNotNull();
        createElementAssertion().hasNotAttribute(localName);
    }

    /**
     * Check if the actual value has NOT the specified attribute.
     *
     * @param namespaceURI the specified namespace URI.
     * @param localName    the specified local name.
     */
    public void hasNotAttribute(final String namespaceURI, final String localName) {
        checkActualIsNotNull();
        createElementAssertion().hasNotAttribute(namespaceURI, localName);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     *
     * @return the assertion.
     */
    public AttrAssertion toAttribute(final String localName) {
        checkActualIsNotNull();
        return createElementAssertion().toAttribute(localName);
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
        checkActualIsNotNull();
        return createElementAssertion().toAttribute(namespaceURI, localName);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     * @param matcher   the hamcrest matcher.
     */
    public void toAttribute(final String localName, final Matcher<? super Attr> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toAttribute(localName, matcher);
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
        createElementAssertion().toAttribute(namespaceURI, localName, matcher);
    }

    /**
     * Check if the actual value has the specified attribute with the specified value.
     *
     * @param localName the local name of the actual value's attribute.
     * @param value     the value of the actual value's attribute.
     */
    public void hasAttributeValue(final String localName, final String value) {
        checkActualIsNotNull();
        createElementAssertion().hasAttributeValue(localName, value);
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
        createElementAssertion().hasAttributeValue(namespaceURI, localName, value);
    }

    /**
     * Check if the actual value has NOT the specified attribute with the specified value.
     *
     * @param localName the local name of the actual value's attribute.
     * @param value     the value of the actual value's attribute.
     */
    public void hasNotAttributeValue(final String localName, final String value) {
        checkActualIsNotNull();
        createElementAssertion().hasNotAttributeValue(localName, value);
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
        createElementAssertion().hasNotAttributeValue(namespaceURI, localName, value);
    }

    /**
     * Check if the actual value has child nodes.
     */
    public void hasChildNodes() {
        checkActualIsNotNull();
        createElementAssertion().hasChildNodes();
    }

    /**
     * Check if the actual value has NOT child nodes.
     */
    public void hasNotChildNodes() {
        checkActualIsNotNull();
        createElementAssertion().hasNotChildNodes();
    }

    /**
     * Make assertion about the actual value's child nodes count.
     *
     * @return the assertion.
     */
    public IntAssertion toChildNodesCount() {
        checkActualIsNotNull();
        return createElementAssertion().toChildNodesCount();
    }

    /**
     * Make assertion about the actual value's child nodes count.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toChildNodesCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toChildNodesCount(matcher);
    }

    /**
     * Check if the actual value's child nodes count is equal to the expected count.
     *
     * @param expected the expected count.
     */
    public void hasChildNodesCount(final int expected) {
        checkActualIsNotNull();
        createElementAssertion().hasChildNodesCount(expected);
    }

    /**
     * Make assertion about the actual value's child elements count.
     *
     * @return the assertion.
     */
    public IntAssertion toChildElementsCount() {
        checkActualIsNotNull();
        return createElementAssertion().toChildElementsCount();
    }

    /**
     * Make assertion about the actual value's child elements count.
     *
     * @param matcher the expected count.
     */
    public void toChildElementsCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toChildElementsCount(matcher);
    }

    /**
     * Check if the actual value's child elements count is equal to the expected count.
     *
     * @param expected the expected count.
     */
    public void hasChildElementsCount(final int expected) {
        checkActualIsNotNull();
        createElementAssertion().hasChildElementsCount(expected);
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

    private ElementAssertion createElementAssertion() {
        return initializeAssertion(Raw.elementAssertion(), getActual().getDocumentElement());
    }

}
