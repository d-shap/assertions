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
        initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo("<element/>");
        initialize(Raw.elementAssertion(), createElement("<element></element>")).isEqualTo("<element/>");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).isEqualTo("<element attr2='val2' attr1='val1'/>");
        initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>")).isEqualTo("<element><child>text</child></element>");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>")).isEqualTo("<element xmlns='aaa'>text</element>");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");

        try {
            Raw.elementAssertion().isEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>")).isEqualTo("<element2/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>"), "Message").isEqualTo("<element2/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo("<element>content</element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo("<element>content</element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo("<element attr='val'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo("<element attr='val'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).isEqualTo("<element xmlns:ns1='aaa'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").isEqualTo("<element xmlns:ns1='aaa'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToElementTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element1/>")).isNotEqualTo(createElement("<element2/>"));
        initialize(Raw.elementAssertion(), createElement("<element1></element1>")).isNotEqualTo(createElement("<element2/>"));
        initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo(createElement("<element>content</element>"));
        initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo(createElement("<element attr='val'/>"));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).isNotEqualTo(createElement("<element xmlns:ns1='aaa'/>"));

        Element element11 = (Element) createElement("<element xmlns:ns1='aaa'><ns1:child>text</ns1:child></element>").getChildNodes().item(0);
        Element element12 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element11).isNotEqualTo(element12);

        Element element2 = createElement("<element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns1:child>text</ns1:child><ns2:child>text</ns2:child></element>");
        Element element21 = (Element) element2.getChildNodes().item(0);
        Element element22 = (Element) element2.getChildNodes().item(1);
        initialize(Raw.elementAssertion(), element21).isNotEqualTo(element22);

        Element element3 = createElement("<element xmlns:ns1='aaa' xmlns:ns2='aaa'><ns1:child>text</ns1:child><ns2:child>text</ns2:child></element>");
        Element element31 = (Element) element3.getChildNodes().item(0);
        Element element32 = (Element) element3.getChildNodes().item(1);
        initialize(Raw.elementAssertion(), element31).isNotEqualTo(element32);

        try {
            Raw.elementAssertion().isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isNotEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isNotEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>")).isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>"), "Message").isNotEqualTo(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1'/>")).isNotEqualTo(createElement("<element attr1='val1'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1'/>"), "Message").isNotEqualTo(createElement("<element attr1='val1'/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>")).isNotEqualTo(createElement("<element><child>text</child></element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>"), "Message").isNotEqualTo(createElement("<element><child>text</child></element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>")).isNotEqualTo(createElement("<element xmlns='aaa'>text</element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>"), "Message").isNotEqualTo(createElement("<element xmlns='aaa'>text</element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isNotEqualTo(createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"), "Message").isNotEqualTo(createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToStringTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element1/>")).isNotEqualTo("<element2/>");
        initialize(Raw.elementAssertion(), createElement("<element1></element1>")).isNotEqualTo("<element2/>");
        initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo("<element>content</element>");
        initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo("<element attr='val'/>");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).isNotEqualTo("<element xmlns:ns1='aaa'/>");

        try {
            Raw.elementAssertion().isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).isNotEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isNotEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>")).isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>"), "Message").isNotEqualTo("<element/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1'/>")).isNotEqualTo("<element attr1='val1'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1'/>"), "Message").isNotEqualTo("<element attr1='val1'/>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>")).isNotEqualTo("<element><child>text</child></element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child>text</child></element>"), "Message").isNotEqualTo("<element><child>text</child></element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>")).isNotEqualTo("<element xmlns='aaa'>text</element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'>text</element>"), "Message").isNotEqualTo("<element xmlns='aaa'>text</element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isNotEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"), "Message").isNotEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toNamespaceURI().isNull();
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI().isEqualTo("aaa");

        Element element1 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element1).toNamespaceURI().isEqualTo("aaa");

        Element element2 = (Element) createElement("<ns1:element xmlns:ns1='aaa'><ns1:child>text</ns1:child></ns1:element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element2).toNamespaceURI().isEqualTo("aaa");

        try {
            Raw.elementAssertion().toNamespaceURI();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toNamespaceURI();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));

        try {
            Raw.elementAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasNamespaceURI("aaa");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasNamespaceURI("aaa");

        try {
            Raw.elementAssertion().hasNamespaceURI("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNamespaceURI("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNamespaceURI(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasNamespaceURI("bbb");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").hasNamespaceURI("bbb");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toPrefix().isNull();
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toPrefix().isNull();
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns1");

        Element element1 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element1).toPrefix().isNull();

        Element element2 = (Element) createElement("<ns1:element xmlns:ns1='aaa'><ns1:child>text</ns1:child></ns1:element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element2).toPrefix().isEqualTo("ns1");

        try {
            Raw.elementAssertion().toPrefix();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toPrefix();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toPrefix();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix().isEqualTo("ns2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.is(Matchers.equalTo("ns1")));

        try {
            Raw.elementAssertion().toPrefix(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toPrefix(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toPrefix(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns1");

        try {
            Raw.elementAssertion().hasPrefix("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasPrefix("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasPrefix("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasPrefix(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasPrefix("ns2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
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
