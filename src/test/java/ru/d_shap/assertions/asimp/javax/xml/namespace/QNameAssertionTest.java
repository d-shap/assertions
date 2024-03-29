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

import javax.xml.namespace.QName;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link QNameAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class QNameAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public QNameAssertionTest() {
        super();
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.qnameAssertion(), new QName("local"));

        try {
            initializeWithRawActual(Raw.qnameAssertion(), new Object());
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.namespace.QName> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.qnameAssertion(), new Object(), "Message");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.namespace.QName> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.qnameAssertion(), null).isEqualTo(null);
        initialize(Raw.qnameAssertion(), new QName("local")).isEqualTo(new QName("local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isEqualTo(new QName("namespace", "local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).isEqualTo(new QName("namespace", "local", "ns"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).isEqualTo(new QName("namespace", "local", "ns2"));
        initialize(Raw.qnameAssertion(), new QName("local")).isNotNull().isEqualTo(new QName("local")).isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().isEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).isEqualTo(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").isEqualTo(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).isEqualTo(new QName("local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").isEqualTo(new QName("local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1")).isEqualTo(new QName("namespace", "local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<{namespace}local2> but was:<{namespace}local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1"), "Message").isEqualTo(new QName("namespace", "local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<{namespace}local2> but was:<{namespace}local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).isEqualTo(new QName("namespace2", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<{namespace2}local> but was:<{namespace1}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").isEqualTo(new QName("namespace2", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<{namespace2}local> but was:<{namespace1}local>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.qnameAssertion(), null).isNotEqualTo(new QName("local"));
        initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(null);
        initialize(Raw.qnameAssertion(), new QName("local1")).isNotEqualTo(new QName("local2"));
        initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(new QName("namespace", "local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local1")).isNotEqualTo(new QName("namespace", "local2"));
        initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).isNotEqualTo(new QName("namespace2", "local"));
        initialize(Raw.qnameAssertion(), new QName("local1")).isNotNull().isNotEqualTo(new QName("local2")).isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().isNotEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isNotEqualTo(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").isNotEqualTo(new QName("local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotEqualTo(new QName("namespace", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").isNotEqualTo(new QName("namespace", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).isNotEqualTo(new QName("namespace", "local", "ns2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1"), "Message").isNotEqualTo(new QName("namespace", "local", "ns2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{namespace}local>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toNamespaceURITest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toNamespaceURI().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("", "local")).toNamespaceURI().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).toNamespaceURI().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toNamespaceURI().isEqualTo("namespace");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().toNamespaceURI().isEqualTo("namespace");

        try {
            Raw.qnameAssertion().toNamespaceURI();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toNamespaceURI();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toNamespaceURI()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").toNamespaceURI()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).toNamespaceURI().isEqualTo("namespace2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").toNamespaceURI().isEqualTo("namespace2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toNamespaceURIMatcherTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toNamespaceURI(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("", "local")).toNamespaceURI(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName(null, "local")).toNamespaceURI(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toNamespaceURI(Matchers.is(Matchers.equalTo("namespace")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().toNamespaceURI(Matchers.is(Matchers.equalTo("namespace"))).isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").toNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).toNamespaceURI(Matchers.equalTo("namespace2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"namespace2\"\n     but: was \"namespace1\"");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").toNamespaceURI(Matchers.equalTo("namespace2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"namespace2\"\n     but: was \"namespace1\"");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasNamespaceURITest() {
        initialize(Raw.qnameAssertion(), new QName("local")).hasNamespaceURI("");
        initialize(Raw.qnameAssertion(), new QName("", "local")).hasNamespaceURI("");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).hasNamespaceURI("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasNamespaceURI("namespace");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().hasNamespaceURI("namespace").isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().hasNamespaceURI("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasNamespaceURI("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").hasNamespaceURI(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).hasNamespaceURI("namespace2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").hasNamespaceURI("namespace2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toPrefixTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toPrefix().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("", "local")).toPrefix().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).toPrefix().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toPrefix().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "")).toPrefix().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).toPrefix().isEqualTo("ns");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).isNotNull().toPrefix().isEqualTo("ns");

        try {
            Raw.qnameAssertion().toPrefix();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toPrefix();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toPrefix();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toPrefix()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").toPrefix()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).toPrefix().isEqualTo("ns2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1"), "Message").toPrefix().isEqualTo("ns2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toPrefixMatcherTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toPrefix(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("", "local")).toPrefix(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName(null, "local")).toPrefix(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toPrefix(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "")).toPrefix(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).toPrefix(Matchers.is(Matchers.equalTo("ns")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).isNotNull().toPrefix(Matchers.is(Matchers.equalTo("ns"))).isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().toPrefix(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toPrefix(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toPrefix(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).toPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns"), "Message").toPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1"), "Message").toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPrefixTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).hasPrefix("");
        initialize(Raw.qnameAssertion(), new QName("", "local")).hasPrefix("");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).hasPrefix("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasPrefix("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "")).hasPrefix("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).hasPrefix("ns");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).isNotNull().hasPrefix("ns").isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().hasPrefix("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasPrefix("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasPrefix("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).hasPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns"), "Message").hasPrefix(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).hasPrefix("ns2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1"), "Message").hasPrefix("ns2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toLocalPartTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toLocalPart().isEqualTo("local");
        initialize(Raw.qnameAssertion(), new QName("")).toLocalPart().isEqualTo("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toLocalPart().isEqualTo("local");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().toLocalPart().isEqualTo("local");

        try {
            Raw.qnameAssertion().toLocalPart();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toLocalPart();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toLocalPart();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("local")).toLocalPart()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.qnameAssertion(), new QName("local"), "Message").toLocalPart()).isEqualTo("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).toLocalPart().isEqualTo("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").toLocalPart().isEqualTo("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toLocalPartMatcherTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).toLocalPart(Matchers.is(Matchers.equalTo("local")));
        initialize(Raw.qnameAssertion(), new QName("")).toLocalPart(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).toLocalPart(Matchers.is(Matchers.equalTo("local")));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().toLocalPart(Matchers.is(Matchers.equalTo("local"))).isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().toLocalPart(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toLocalPart(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toLocalPart(Matchers.equalTo(""));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).toLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").toLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).toLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").toLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).toLocalPart(Matchers.equalTo("local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\nExpected: \"local2\"\n     but: was \"local1\"");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").toLocalPart(Matchers.equalTo("local2"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\nExpected: \"local2\"\n     but: was \"local1\"");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasLocalPartTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).hasLocalPart("local");
        initialize(Raw.qnameAssertion(), new QName("")).hasLocalPart("");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasLocalPart("local");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasLocalPart("local");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().hasLocalPart("local").isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().hasLocalPart("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasLocalPart("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasLocalPart("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).hasLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").hasLocalPart(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).hasLocalPart("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").hasLocalPart("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPropertiesLocalPartTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).hasProperties("local");
        initialize(Raw.qnameAssertion(), new QName("", "local")).hasProperties("local");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).hasProperties("local");
        initialize(Raw.qnameAssertion(), new QName("")).hasProperties("");
        initialize(Raw.qnameAssertion(), new QName("local")).isNotNull().hasProperties("local").isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().hasProperties("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasProperties("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasProperties("");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasProperties(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasProperties(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).hasProperties(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalPart.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").hasProperties(null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalPart.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).hasProperties("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").hasProperties("local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasProperties("local");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<> but was:<namespace>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").hasProperties("local");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<> but was:<namespace>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalPartTest() {
        initialize(Raw.qnameAssertion(), new QName("local")).hasProperties("", "local");
        initialize(Raw.qnameAssertion(), new QName("", "local")).hasProperties("", "local");
        initialize(Raw.qnameAssertion(), new QName(null, "local")).hasProperties("", "local");
        initialize(Raw.qnameAssertion(), new QName("")).hasProperties("", "");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).hasProperties("namespace", "local");
        initialize(Raw.qnameAssertion(), new QName("namespace", "")).hasProperties("namespace", "");
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotNull().hasProperties("namespace", "local").isInstanceOf(QName.class);

        try {
            Raw.qnameAssertion().hasProperties("", "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasProperties("", "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasProperties("", "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).hasProperties(null, "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").hasProperties(null, "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).hasProperties(null, "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").hasProperties(null, "");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).hasProperties(null, null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").hasProperties(null, null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).hasProperties("", null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalPart.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").hasProperties("", null);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalPart.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1")).hasProperties("namespace", "local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1"), "Message").hasProperties("namespace", "local2");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).hasProperties("namespace2", "local");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").hasProperties("namespace2", "local");
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<namespace2> but was:<namespace1>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.qnameAssertion(), null).isNull();

        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNull();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").isNull();
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<{namespace}local>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        QName value = new QName("namespace", "local");
        initialize(Raw.qnameAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.qnameAssertion(), value).isSameAs(new QName("namespace", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<{namespace}local> but was:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), value, "Message").isSameAs(new QName("namespace", "local"));
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<{namespace}local> but was:<{namespace}local>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        QName value = new QName("namespace", "local");
        initialize(Raw.qnameAssertion(), value).isNotSameAs(new QName("namespace", "local"));

        try {
            initialize(Raw.qnameAssertion(), value).isNotSameAs(value);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(QNameAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<{namespace}local>");
        }
    }

}
