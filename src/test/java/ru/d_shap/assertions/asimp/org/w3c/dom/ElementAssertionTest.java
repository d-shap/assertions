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

import org.junit.Test;
import org.w3c.dom.Element;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ElementAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ElementAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ElementAssertionTest() {
        super();
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void actualValueValidatorTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>"));

        try {
            initializeWithRawActual(Raw.elementAssertion(), new Object());
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Element> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.elementAssertion(), new Object(), "Message");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Element> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToElementTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo(createElement("<element/>"));
        initialize(Raw.elementAssertion(), createElement("<element></element>")).isEqualTo(createElement("<element/>"));
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).isEqualTo(createElement("<element attr2='val2' attr1='val1'/>"));
        initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>")).isEqualTo(createElement("<element><child>text</child></element>"));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>")).isEqualTo(createElement("<element xmlns='aaa'>text</element>"));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isEqualTo(createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));

        try {
            Raw.elementAssertion().isEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>")).isEqualTo(createElement("<element2/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>"), "Message").isEqualTo(createElement("<element2/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo(createElement("<element>content</element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo(createElement("<element>content</element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo(createElement("<element attr='val'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo(createElement("<element attr='val'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).isEqualTo(createElement("<element xmlns:ns1='aaa'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").isEqualTo(createElement("<element xmlns:ns1='aaa'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }

        try {
            Element element1 = (Element) createElement("<element xmlns:ns1='aaa'><ns1:child>text</ns1:child></element>").getChildNodes().item(0);
            Element element2 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
            initialize(Raw.elementAssertion(), element1).isEqualTo(element2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<child xmlns=\"aaa\">text</child>> but was:<<ns1:child xmlns:ns1=\"aaa\">text</ns1:child>>");
        }
        try {
            Element element = createElement("<element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns1:child>text</ns1:child><ns2:child>text</ns2:child></element>");
            Element element1 = (Element) element.getChildNodes().item(0);
            Element element2 = (Element) element.getChildNodes().item(1);
            initialize(Raw.elementAssertion(), element1).isEqualTo(element2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<ns2:child xmlns:ns2=\"bbb\">text</ns2:child>> but was:<<ns1:child xmlns:ns1=\"aaa\">text</ns1:child>>");
        }
        try {
            Element element = createElement("<element xmlns:ns1='aaa' xmlns:ns2='aaa'><ns1:child>text</ns1:child><ns2:child>text</ns2:child></element>");
            Element element1 = (Element) element.getChildNodes().item(0);
            Element element2 = (Element) element.getChildNodes().item(1);
            initialize(Raw.elementAssertion(), element1).isEqualTo(element2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<ns2:child xmlns:ns2=\"aaa\">text</ns2:child>> but was:<<ns1:child xmlns:ns1=\"aaa\">text</ns1:child>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToStringTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToElementTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToStringTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNullTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isSameAsTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotSameAsTest() throws Exception {
        // TODO
    }

}
