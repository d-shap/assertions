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

import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.Node;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link NodeAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class NodeAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public NodeAssertionTest() {
        super();
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>"));

        try {
            initializeWithRawActual(Raw.nodeAssertion(), new Object());
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Node> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.nodeAssertion(), new Object(), "Message");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Node> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.nodeAssertion(), null).isEqualTo(null);
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element/>"));
        initialize(Raw.nodeAssertion(), createNode("<element></element>")).isEqualTo(createNode("<element/>"));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).isEqualTo(createNode("<!-- comment -->"));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).isEqualTo(createNode("<?procinstr?>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotNull().isEqualTo(createNode("<element/>")).isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().isEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>")).isEqualTo(createNode("<element2/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>"), "Message").isEqualTo(createNode("<element2/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element>content</element>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<element>content</element>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element attr='val'/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<element attr='val'/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<?procinstr?>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<?procinstr?>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<?procinstr?>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<?procinstr?>> but was:<<element/>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.nodeAssertion(), null).isNotEqualTo(createNode("<element/>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(null);
        initialize(Raw.nodeAssertion(), createNode("<element1/>")).isNotEqualTo(createNode("<element2/>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element>content</element>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element attr='val'/>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<?procinstr?>"));
        initialize(Raw.nodeAssertion(), createNode("<element1/>")).isNotNull().isNotEqualTo(createNode("<element2/>")).isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().isNotEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isNotEqualTo(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isNotEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element></element>")).isNotEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element></element>"), "Message").isNotEqualTo(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).isNotEqualTo(createNode("<!-- comment -->"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<!-- comment -->"), "Message").isNotEqualTo(createNode("<!-- comment -->"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).isNotEqualTo(createNode("<?procinstr?>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<?procinstr?>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<?procinstr?>"), "Message").isNotEqualTo(createNode("<?procinstr?>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<?procinstr?>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toNamespaceURITest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI().isNull();
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toNamespaceURI().isNull();
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toNamespaceURI().isNull();
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().toNamespaceURI().isEqualTo("aaa");

        try {
            Raw.nodeAssertion().toNamespaceURI();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("bbb");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").toNamespaceURI().isEqualTo("bbb");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toNamespaceURIMatcherTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toNamespaceURI(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toNamespaceURI(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().toNamespaceURI(Matchers.is(Matchers.equalTo("aaa"))).isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").toNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void hasNamespaceURITest() {
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasNamespaceURI("aaa");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasNamespaceURI("aaa");
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().hasNamespaceURI("aaa").isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().hasNamespaceURI("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasNamespaceURI("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasNamespaceURI(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasNamespaceURI("bbb");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").hasNamespaceURI("bbb");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toPrefixTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toPrefix().isNull();
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toPrefix().isNull();
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns1");
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toPrefix().isNull();
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toPrefix().isNull();
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).isNotNull().toPrefix().isEqualTo("ns1");

        try {
            Raw.nodeAssertion().toPrefix();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toPrefix();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toPrefix();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix().isEqualTo("ns2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toPrefixMatcherTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.is(Matchers.equalTo("ns1")));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).isNotNull().toPrefix(Matchers.is(Matchers.equalTo("ns1"))).isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().toPrefix(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toPrefix(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toPrefix(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).toPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").toPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void hasPrefixTest() {
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns1");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).isNotNull().hasPrefix("ns1").isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().hasPrefix("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasPrefix("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasPrefix("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasPrefix(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasPrefix("ns2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toLocalNameTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toLocalName().isEqualTo("element");
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toLocalName().isEqualTo("element");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toLocalName().isEqualTo("element");
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toLocalName().isNull();
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toLocalName().isNull();
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().toLocalName().isEqualTo("element");

        try {
            Raw.nodeAssertion().toLocalName();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toLocalName();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toLocalName();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>")).toLocalName().isEqualTo("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toLocalName().isEqualTo("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void toLocalNameMatcherTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toLocalName(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toLocalName(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().toLocalName(Matchers.is(Matchers.equalTo("element"))).isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().toLocalName(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toLocalName(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toLocalName(Matchers.equalTo(""));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).toLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").toLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>")).toLocalName(Matchers.equalTo("element2"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toLocalName(Matchers.equalTo("element2"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void hasLocalNameTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).hasLocalName("element");
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasLocalName("element");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasLocalName("element");
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).isNotNull().hasLocalName("element").isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().hasLocalName("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasLocalName("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasLocalName("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasLocalName(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>")).hasLocalName("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasLocalName("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void hasPropertiesLocalNameTest() {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).hasProperties("element");
        initialize(Raw.nodeAssertion(), createNode("<element attr='val'/>")).hasProperties("element");
        initialize(Raw.nodeAssertion(), createNode("<element2/>")).hasProperties("element2");
        initialize(Raw.nodeAssertion(), createNode("<element>content</element>")).hasProperties("element");
        initialize(Raw.nodeAssertion(), createNode("<element attr='val'/>")).isNotNull().hasProperties("element").isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().hasProperties("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasProperties("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasProperties("");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasProperties(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasProperties(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasProperties(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasProperties(null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>")).hasProperties("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>"), "Message").hasProperties("element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasProperties("element");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").hasProperties("element");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() {
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.nodeAssertion(), createNode("<ns2:element xmlns:ns2='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='bbb'/>")).hasProperties("bbb", "element");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element2 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).isNotNull().hasProperties("aaa", "element").isInstanceOf(Node.class);

        try {
            Raw.nodeAssertion().hasProperties("", "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasProperties("", "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasProperties("", "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasProperties(null, "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasProperties(null, "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasProperties(null, "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasProperties(null, "");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasProperties(null, null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasProperties(null, null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasProperties("", null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasProperties("", null);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("bbb", "element");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasProperties("bbb", "element");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasProperties("aaa", "element2");
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.nodeAssertion(), null).isNull();

        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isNull();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isNull();
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Node value = createNode("<element/>");
        initialize(Raw.nodeAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.nodeAssertion(), value).isSameAs(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), value, "Message").isSameAs(createNode("<element/>"));
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Node value = createNode("<element/>");
        initialize(Raw.nodeAssertion(), value).isNotSameAs(createNode("<element/>"));

        try {
            initialize(Raw.nodeAssertion(), value).isNotSameAs(value);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(NodeAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<<element/>>");
        }
    }

}
