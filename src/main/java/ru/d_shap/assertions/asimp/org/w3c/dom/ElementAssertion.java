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
import org.w3c.dom.Element;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the element.
 *
 * @author Dmitry Shapovalov
 */
public class ElementAssertion extends ReferenceAssertion<Element> {

    /**
     * Create new object.
     */
    public ElementAssertion() {
        super();
    }

    @Override
    protected final Class<Element> getActualValueClass() {
        return Element.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Element expected) {
        createNodeAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Element expected) {
        createNodeAssertion().isNotEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toNamespaceURI() {
        return createNodeAssertion().toNamespaceURI();
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toNamespaceURI(final Matcher<String> matcher) {
        createNodeAssertion().toNamespaceURI(matcher);
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasNamespaceURI(final String expected) {
        createNodeAssertion().hasNamespaceURI(expected);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toPrefix() {
        return createNodeAssertion().toPrefix();
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toPrefix(final Matcher<String> matcher) {
        createNodeAssertion().toPrefix(matcher);
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasPrefix(final String expected) {
        createNodeAssertion().hasPrefix(expected);
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toLocalName() {
        return createNodeAssertion().toLocalName();
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLocalName(final Matcher<String> matcher) {
        createNodeAssertion().toLocalName(matcher);
    }

    /**
     * Check if the actual value's local name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasLocalName(final String expected) {
        createNodeAssertion().hasLocalName(expected);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toQualifiedName() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getTagName(), Messages.Check.QUALIFIED_NAME);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toQualifiedName(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getTagName(), matcher, Messages.Check.QUALIFIED_NAME);
    }

    /**
     * Check if the actual value's qualified name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasQualifiedName(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toQualifiedName().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param localName the expected local name.
     */
    public void hasProperties(final String localName) {
        toNamespaceURI().isNull();
        hasLocalName(localName);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param namespaceURI the expected namespace URI.
     * @param localName    the expected local name.
     */
    public void hasProperties(final String namespaceURI, final String localName) {
        hasNamespaceURI(namespaceURI);
        hasLocalName(localName);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     *
     * @return the assertion.
     */
    public final AttrAssertion toAttr(final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        return initializeAssertion(Raw.attrAssertion(), getActual().getAttributeNode(localName), Messages.Check.ATTRIBUTE);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     *
     * @return the assertion.
     */
    public final AttrAssertion toAttr(final String namespaceURI, final String localName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        return initializeAssertion(Raw.attrAssertion(), getActual().getAttributeNodeNS(namespaceURI, localName), Messages.Check.ATTRIBUTE);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param localName the local name of the actual value's attribute.
     * @param matcher   the hamcrest matcher.
     */
    public final void toAttr(final String localName, final Matcher<Attr> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getAttributeNode(localName), matcher, Messages.Check.ATTRIBUTE);
    }

    /**
     * Make assertion about the actual value's attribute.
     *
     * @param namespaceURI the namespace URI of the actual value's attribute.
     * @param localName    the local name of the actual value's attribute.
     * @param matcher      the hamcrest matcher.
     */
    public final void toAttr(final String namespaceURI, final String localName, final Matcher<Attr> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(namespaceURI, "namespaceURI");
        checkArgumentIsNotNull(localName, "localName");
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getAttributeNodeNS(namespaceURI, localName), matcher, Messages.Check.ATTRIBUTE);
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

}
