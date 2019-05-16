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
import org.w3c.dom.Document;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.converter.ConversionExceptionHolder;

/**
 * Assertions for the document.
 *
 * @author Dmitry Shapovalov
 */
public class DocumentAssertion extends ReferenceAssertion<Document> {

    /**
     * Create new object.
     */
    public DocumentAssertion() {
        super();
    }

    @Override
    protected final Class<Document> getActualValueClass() {
        return Document.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Document expected) {
        createNodeAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
        Document expectedDocument = convertValue(expected, conversionExceptionHolder, Document.class);
        checkArgumentIsValid(conversionExceptionHolder, "expected", Messages.Fail.Argument.IS_VALID_XML);
        createNodeAssertion().isEqualTo(expectedDocument);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Document expected) {
        createNodeAssertion().isNotEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
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
    public final CharSequenceAssertion toNamespaceURI() {
        checkActualIsNotNull();
        return createElementAssertion().toNamespaceURI();
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toNamespaceURI(final Matcher<String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toNamespaceURI(matcher);
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasNamespaceURI(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasNamespaceURI(expected);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toPrefix() {
        checkActualIsNotNull();
        return createElementAssertion().toPrefix();
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toPrefix(final Matcher<String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toPrefix(matcher);
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasPrefix(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasPrefix(expected);
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toLocalName() {
        checkActualIsNotNull();
        return createElementAssertion().toLocalName();
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLocalName(final Matcher<String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toLocalName(matcher);
    }

    /**
     * Check if the actual value's local name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasLocalName(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasLocalName(expected);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toQualifiedName() {
        checkActualIsNotNull();
        return createElementAssertion().toQualifiedName();
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toQualifiedName(final Matcher<String> matcher) {
        checkActualIsNotNull();
        createElementAssertion().toQualifiedName(matcher);
    }

    /**
     * Check if the actual value's qualified name is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasQualifiedName(final String expected) {
        checkActualIsNotNull();
        createElementAssertion().hasQualifiedName(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalName the expected local name.
     */
    public final void hasProperties(final String expectedLocalName) {
        checkActualIsNotNull();
        createElementAssertion().hasProperties(expectedLocalName);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalName    the expected local name.
     */
    public final void hasProperties(final String expectedNamespaceURI, final String expectedLocalName) {
        checkActualIsNotNull();
        createElementAssertion().hasProperties(expectedNamespaceURI, expectedLocalName);
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

    private ElementAssertion createElementAssertion() {
        return initializeAssertion(Raw.elementAssertion(), getActual().getDocumentElement());
    }

}
