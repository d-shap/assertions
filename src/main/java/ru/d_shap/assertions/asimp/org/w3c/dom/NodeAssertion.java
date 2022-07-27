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
import org.w3c.dom.Node;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the node.
 *
 * @author Dmitry Shapovalov
 */
public final class NodeAssertion extends ReferenceAssertion<NodeAssertion, Node> {

    /**
     * Create new object.
     */
    public NodeAssertion() {
        super();
    }

    @Override
    protected Class<Node> getActualValueClass() {
        return Node.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public NodeAssertion isEqualTo(final Node expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().isEqualNode(expected)) {
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
    public NodeAssertion isNotEqualTo(final Node expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().isEqualNode(expected)) {
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
    public NodeAssertion toNamespaceURI(final Matcher<? super String> matcher) {
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
    public NodeAssertion hasNamespaceURI(final String expected) {
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
    public NodeAssertion toPrefix(final Matcher<? super String> matcher) {
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
    public NodeAssertion hasPrefix(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toPrefix().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toLocalName() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getLocalName(), Messages.Check.LOCAL_NAME);
    }

    /**
     * Make assertion about the actual value's local name.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public NodeAssertion toLocalName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getLocalName(), matcher, Messages.Check.LOCAL_NAME);
        return this;
    }

    /**
     * Check if the actual value's local name is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public NodeAssertion hasLocalName(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toLocalName().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLocalName the expected local name.
     *
     * @return current object for the chain call.
     */
    public NodeAssertion hasProperties(final String expectedLocalName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLocalName, "expectedLocalName");
        toNamespaceURI().isNull();
        hasLocalName(expectedLocalName);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedNamespaceURI the expected namespace URI.
     * @param expectedLocalName    the expected local name.
     *
     * @return current object for the chain call.
     */
    public NodeAssertion hasProperties(final String expectedNamespaceURI, final String expectedLocalName) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedNamespaceURI, "expectedNamespaceURI");
        checkArgumentIsNotNull(expectedLocalName, "expectedLocalName");
        hasNamespaceURI(expectedNamespaceURI);
        hasLocalName(expectedLocalName);
        return this;
    }

}
