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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void actualValueValidatorTest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element/>"));

        try {
            initializeWithRawActual(Raw.nodeAssertion(), new Object());
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Node> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.nodeAssertion(), new Object(), "Message");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Node> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToTest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element/>"));
        initialize(Raw.nodeAssertion(), createNode("<element></element>")).isEqualTo(createNode("<element/>"));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).isEqualTo(createNode("<!-- comment -->"));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).isEqualTo(createNode("<?procinstr?>"));

        try {
            Raw.nodeAssertion().isEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>")).isEqualTo(createNode("<element2/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element1/>"), "Message").isEqualTo(createNode("<element2/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element>content</element>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<element>content</element>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<element attr='val'/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<element attr='val'/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isEqualTo(createNode("<?procinstr?>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<?procinstr?>> but was:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isEqualTo(createNode("<?procinstr?>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<?procinstr?>> but was:<<element/>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToTest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element1/>")).isNotEqualTo(createNode("<element2/>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element>content</element>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element attr='val'/>"));
        initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<?procinstr?>"));

        try {
            Raw.nodeAssertion().isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).isNotEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isNotEqualTo(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element></element>")).isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element></element>"), "Message").isNotEqualTo(createNode("<element/>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).isNotEqualTo(createNode("<!-- comment -->"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<!-- comment -->"), "Message").isNotEqualTo(createNode("<!-- comment -->"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).isNotEqualTo(createNode("<?procinstr?>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<?procinstr?>>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<?procinstr?>"), "Message").isNotEqualTo(createNode("<?procinstr?>"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<?procinstr?>>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI().isNull();
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toNamespaceURI().isNull();
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toNamespaceURI().isNull();

        try {
            Raw.nodeAssertion().toNamespaceURI();
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI();
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.nodeAssertion(), createNode("<!-- comment -->")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.nodeAssertion(), createNode("<?procinstr?>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));

        try {
            Raw.nodeAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).toNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).toNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").toNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
        initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasNamespaceURI("aaa");
        initialize(Raw.nodeAssertion(), createNode("<ns1:element xmlns:ns1='aaa'/>")).hasNamespaceURI("aaa");

        try {
            Raw.nodeAssertion().hasNamespaceURI("");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasNamespaceURI("");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null).hasNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>")).hasNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element/>"), "Message").hasNamespaceURI(null);
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>")).hasNamespaceURI("bbb");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.nodeAssertion(), createNode("<element xmlns='aaa'/>"), "Message").hasNamespaceURI("bbb");
            Assertions.fail("NodeAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNullTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isSameAsTest() throws Exception {
        // TODO
    }

    /**
     * {@link NodeAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotSameAsTest() throws Exception {
        // TODO
    }

}
