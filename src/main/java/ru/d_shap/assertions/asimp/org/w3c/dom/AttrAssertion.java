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

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the attr.
 *
 * @author Dmitry Shapovalov
 */
public final class AttrAssertion extends ReferenceAssertion<Attr> {

    /**
     * Create new object.
     */
    public AttrAssertion() {
        super();
    }

    @Override
    protected Class<Attr> getActualValueClass() {
        return Attr.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isEqualTo(final Attr expected) {
        createNodeAssertion().isEqualTo(expected);
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void isNotEqualTo(final Attr expected) {
        createNodeAssertion().isNotEqualTo(expected);
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
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getName(), Messages.Check.QUALIFIED_NAME);
    }

    /**
     * Make assertion about the actual value's qualified name.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toQualifiedName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getName(), matcher, Messages.Check.QUALIFIED_NAME);
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
     * Make assertion about the actual value's value.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toValue() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getValue(), Messages.Check.VALUE);
    }

    /**
     * Make assertion about the actual value's value.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toValue(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getValue(), matcher, Messages.Check.VALUE);
    }

    /**
     * Check if the actual value's value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public void hasValue(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toValue().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalName the expected local name.
     * @param expectedValue     the expected value.
     */
    public void hasProperties(final String expectedLocalName, final String expectedValue) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLocalName, "expectedLocalName");
        checkArgumentIsNotNull(expectedValue, "expectedValue");
        toNamespaceURI().isNull();
        hasLocalName(expectedLocalName);
        hasValue(expectedValue);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalName    the expected local name.
     * @param expectedValue        the expected value.
     */
    public void hasProperties(final String expectedNamespaceURI, final String expectedLocalName, final String expectedValue) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedNamespaceURI, "expectedNamespaceURI");
        checkArgumentIsNotNull(expectedLocalName, "expectedLocalName");
        checkArgumentIsNotNull(expectedValue, "expectedValue");
        hasNamespaceURI(expectedNamespaceURI);
        hasLocalName(expectedLocalName);
        hasValue(expectedValue);
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

}
