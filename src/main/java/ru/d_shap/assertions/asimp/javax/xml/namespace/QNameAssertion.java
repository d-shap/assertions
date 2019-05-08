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
package ru.d_shap.assertions.asimp.javax.xml.namespace;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the qname.
 *
 * @author Dmitry Shapovalov
 */
public class QNameAssertion extends ReferenceAssertion<QName> {

    /**
     * Create new object.
     */
    public QNameAssertion() {
        super();
    }

    @Override
    protected final Class<QName> getActualValueClass() {
        return QName.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final QName expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final QName expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toNamespaceURI() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getNamespaceURI(), Messages.Check.NAMESPACE_URI);
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toNamespaceURI(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getNamespaceURI(), matcher, Messages.Check.NAMESPACE_URI);
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasNamespaceURI(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNamespaceURI().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toPrefix() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getPrefix(), Messages.Check.PREFIX);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toPrefix(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getPrefix(), matcher, Messages.Check.PREFIX);
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasPrefix(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toPrefix().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's local part.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toLocalPart() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getLocalPart(), Messages.Check.LOCAL_PART);
    }

    /**
     * Make assertion about the actual value's local part.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLocalPart(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getLocalPart(), matcher, Messages.Check.LOCAL_PART);
    }

    /**
     * Check if the actual value's local part is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasLocalPart(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toLocalPart().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalPart the expected local part.
     */
    public void hasProperties(final String expectedLocalPart) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLocalPart, "expectedLocalPart");
        hasNamespaceURI(XMLConstants.NULL_NS_URI);
        hasLocalPart(expectedLocalPart);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalPart    the expected local part.
     */
    public void hasProperties(final String expectedNamespaceURI, final String expectedLocalPart) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedNamespaceURI, "expectedNamespaceURI");
        checkArgumentIsNotNull(expectedLocalPart, "expectedLocalPart");
        hasNamespaceURI(expectedNamespaceURI);
        hasLocalPart(expectedLocalPart);
    }

}
