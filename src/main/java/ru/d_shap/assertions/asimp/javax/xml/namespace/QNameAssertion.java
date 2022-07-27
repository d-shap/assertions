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
public final class QNameAssertion extends ReferenceAssertion<QName> {

    /**
     * Create new object.
     */
    public QNameAssertion() {
        super();
    }

    @Override
    protected Class<QName> getActualValueClass() {
        return QName.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion isEqualTo(final QName expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion isNotEqualTo(final QName expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toNamespaceURI() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getNamespaceURI(), Messages.Check.NAMESPACE_URI);
    }

    /**
     * Make assertion about the actual value's namespace URI.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion toNamespaceURI(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getNamespaceURI(), matcher, Messages.Check.NAMESPACE_URI);
        return this;
    }

    /**
     * Check if the actual value's namespace URI is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion hasNamespaceURI(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toNamespaceURI().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toPrefix() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getPrefix(), Messages.Check.PREFIX);
    }

    /**
     * Make assertion about the actual value's prefix.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion toPrefix(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getPrefix(), matcher, Messages.Check.PREFIX);
        return this;
    }

    /**
     * Check if the actual value's prefix is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion hasPrefix(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toPrefix().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's local part.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toLocalPart() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getLocalPart(), Messages.Check.LOCAL_PART);
    }

    /**
     * Make assertion about the actual value's local part.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion toLocalPart(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getLocalPart(), matcher, Messages.Check.LOCAL_PART);
        return this;
    }

    /**
     * Check if the actual value's local part is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion hasLocalPart(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toLocalPart().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalPart the expected local part.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion hasProperties(final String expectedLocalPart) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLocalPart, "expectedLocalPart");
        hasNamespaceURI(XMLConstants.NULL_NS_URI);
        hasLocalPart(expectedLocalPart);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalPart    the expected local part.
     *
     * @return current object for the chain call.
     */
    public QNameAssertion hasProperties(final String expectedNamespaceURI, final String expectedLocalPart) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedNamespaceURI, "expectedNamespaceURI");
        checkArgumentIsNotNull(expectedLocalPart, "expectedLocalPart");
        hasNamespaceURI(expectedNamespaceURI);
        hasLocalPart(expectedLocalPart);
        return this;
    }

}
