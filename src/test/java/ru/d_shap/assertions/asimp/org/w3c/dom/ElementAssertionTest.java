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

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.w3c.dom.Attr;
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
     */
    @Test
    public void actualValueValidatorTest() {
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
     */
    @Test
    public void isEqualToElementTest() {
        initialize(Raw.elementAssertion(), null).isEqualTo((Element) null);
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
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo((Element) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
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
     */
    @Test
    public void isEqualToStringTest() {
        initialize(Raw.elementAssertion(), null).isEqualTo((String) null);
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
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo((String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), null).isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
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
     */
    @Test
    public void isNotEqualToElementTest() {
        initialize(Raw.elementAssertion(), null).isNotEqualTo(createElement("<element2/>"));
        initialize(Raw.elementAssertion(), createElement("<element1/>")).isNotEqualTo((Element) null);
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
     */
    @Test
    public void isNotEqualToStringTest() {
        initialize(Raw.elementAssertion(), null).isNotEqualTo("<element2/>");
        initialize(Raw.elementAssertion(), createElement("<element1/>")).isNotEqualTo((String) null);
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
            initialize(Raw.elementAssertion(), null).isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNotEqualTo("<element>");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
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
     */
    @Test
    public void toNamespaceURITest() {
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
     */
    @Test
    public void toNamespaceURIMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toNamespaceURI(Matchers.is(Matchers.emptyOrNullString()));
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
     */
    @Test
    public void hasNamespaceURITest() {
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
     */
    @Test
    public void toPrefixTest() {
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
     */
    @Test
    public void toPrefixMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
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
     */
    @Test
    public void hasPrefixTest() {
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
     */
    @Test
    public void toLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toLocalName().isEqualTo("element");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toLocalName().isEqualTo("element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toLocalName().isEqualTo("element");

        Element element1 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element1).toLocalName().isEqualTo("child");

        Element element2 = (Element) createElement("<ns1:element xmlns:ns1='aaa'><ns1:child>text</ns1:child></ns1:element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element2).toLocalName().isEqualTo("child");

        try {
            Raw.elementAssertion().toLocalName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toLocalName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toLocalName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).toLocalName().isEqualTo("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").toLocalName().isEqualTo("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toLocalNameMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));

        try {
            Raw.elementAssertion().toLocalName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toLocalName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toLocalName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).toLocalName(Matchers.equalTo("element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").toLocalName(Matchers.equalTo("element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasLocalName("element");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasLocalName("element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasLocalName("element");

        try {
            Raw.elementAssertion().hasLocalName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasLocalName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasLocalName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasLocalName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).hasLocalName("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").hasLocalName("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toQualifiedNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toQualifiedName().isEqualTo("element");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toQualifiedName().isEqualTo("element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns1:element");

        Element element1 = (Element) createElement("<element xmlns='aaa'><child>text</child></element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element1).toQualifiedName().isEqualTo("child");

        Element element2 = (Element) createElement("<ns1:element xmlns:ns1='aaa'><ns1:child>text</ns1:child></ns1:element>").getChildNodes().item(0);
        initialize(Raw.elementAssertion(), element2).toQualifiedName().isEqualTo("ns1:child");

        try {
            Raw.elementAssertion().toQualifiedName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toQualifiedName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toQualifiedName();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).toQualifiedName().isEqualTo("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").toQualifiedName().isEqualTo("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns2:element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").toQualifiedName().isEqualTo("ns2:element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns1:element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toQualifiedName().isEqualTo("ns1:element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toQualifiedNameMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toQualifiedName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("ns1:element")));

        try {
            Raw.elementAssertion().toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).toQualifiedName(Matchers.equalTo("element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.equalTo("ns2:element"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"ns2:element\"\n     but: was \"ns1:element\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("ns2:element"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"ns2:element\"\n     but: was \"ns1:element\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.equalTo("ns1:element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"ns1:element2\"\n     but: was \"ns1:element1\"");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("ns1:element2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"ns1:element2\"\n     but: was \"ns1:element1\"");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasQualifiedNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasQualifiedName("element");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasQualifiedName("element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasQualifiedName("ns1:element");

        try {
            Raw.elementAssertion().hasQualifiedName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasQualifiedName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasQualifiedName("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasQualifiedName(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>")).hasQualifiedName("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1 xmlns='aaa'/>"), "Message").hasQualifiedName("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasQualifiedName("ns2:element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasQualifiedName("ns2:element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>")).hasQualifiedName("ns1:element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasQualifiedName("ns1:element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasPropertiesLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasProperties("element");
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasProperties("element");
        initialize(Raw.elementAssertion(), createElement("<element2/>")).hasProperties("element2");
        initialize(Raw.elementAssertion(), createElement("<element>content</element>")).hasProperties("element");

        try {
            Raw.elementAssertion().hasProperties("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasProperties("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasProperties("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasProperties(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasProperties(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasProperties(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasProperties(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>")).hasProperties("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element1/>"), "Message").hasProperties("element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasProperties("element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").hasProperties("element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.elementAssertion(), createElement("<ns2:element xmlns:ns2='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='bbb'/>")).hasProperties("bbb", "element");
        initialize(Raw.elementAssertion(), createElement("<ns1:element2 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");

        try {
            Raw.elementAssertion().hasProperties("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasProperties("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasProperties("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasProperties(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasProperties(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasProperties(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasProperties(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasProperties(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasProperties(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasProperties("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasProperties("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("bbb", "element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasProperties("bbb", "element");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasProperties("aaa", "element2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasAttributeLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasAttribute("attr");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasAttribute("attr1");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasAttribute("attr2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasAttribute("xmlns");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasAttribute("xmlns:ns1");

        try {
            Raw.elementAssertion().hasAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).hasAttribute("attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>"), "Message").hasAttribute("attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("aaa", "attr");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttribute("aaa", "attr1");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttribute("aaa", "attr2");

        try {
            Raw.elementAssertion().hasAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("bbb", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttribute("bbb", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasAttribute("aaa", "attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").hasAttribute("aaa", "attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasNotAttributeLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute("attr");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).hasNotAttribute("attr2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("attr");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("ns2:attr");

        try {
            Raw.elementAssertion().hasNotAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasNotAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<attr> but was:<<element attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val'/>"), "Message").hasNotAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<attr> but was:<<element attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasNotAttribute("attr1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<attr1> but was:<<element attr1=\"val1\" attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>"), "Message").hasNotAttribute("attr1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<attr1> but was:<<element attr1=\"val1\" attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasNotAttribute("xmlns");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<xmlns> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>"), "Message").hasNotAttribute("xmlns");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<xmlns> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttribute("xmlns:ns1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<xmlns:ns1> but was:<<ns1:element xmlns:ns1=\"aaa\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasNotAttribute("xmlns:ns1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<xmlns:ns1> but was:<<ns1:element xmlns:ns1=\"aaa\"/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasNotAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute("aaa", "attr");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("bbb", "attr");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasNotAttribute("aaa", "attr2");

        try {
            Raw.elementAssertion().hasNotAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttribute(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttribute("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttribute("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttribute("aaa", "attr1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<{aaa}attr1> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val1\" ns1:attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>"), "Message").hasNotAttribute("aaa", "attr1");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<{aaa}attr1> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val1\" ns1:attr2=\"val2\"/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toAttributeLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toAttribute("attr").hasValue("val");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).toAttribute("attr1").hasValue("val1");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).toAttribute("attr2").hasValue("val2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toAttribute("xmlns").hasValue("aaa");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toAttribute("xmlns:ns1").hasValue("aaa");

        try {
            Raw.elementAssertion().toAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute("");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).toAttribute("attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>"), "Message").toAttribute("attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>")).toAttribute("attr").hasValue("val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>"), "Message").toAttribute("attr").hasValue("val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("aaa", "attr").hasValue("val");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr1").hasValue("val1");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr2").hasValue("val2");

        try {
            Raw.elementAssertion().toAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, (String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, (String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("", (String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("", (String) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("aaa", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("bbb", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("bbb", "attr");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).toAttribute("aaa", "attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").toAttribute("aaa", "attr2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).toAttribute("aaa", "attr").hasValue("val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").toAttribute("aaa", "attr").hasValue("val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toAttributeLocalNameMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toAttribute("attr", new MatcherAttributeValue("val"));
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).toAttribute("attr1", new MatcherAttributeValue("val1"));
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).toAttribute("attr2", new MatcherAttributeValue("val2"));
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).toAttribute("xmlns", new MatcherAttributeValue("aaa"));
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).toAttribute("xmlns:ns1", new MatcherAttributeValue("aaa"));

        try {
            Raw.elementAssertion().toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, (Matcher<Attr>) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, (Matcher<Attr>) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("", (Matcher<Attr>) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("", (Matcher<Attr>) null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).toAttribute("attr2", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>"), "Message").toAttribute("attr2", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>")).toAttribute("attr", new MatcherAttributeValue("val2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\nExpected: val2\n     but: was <attr=\"val1\">");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>"), "Message").toAttribute("attr", new MatcherAttributeValue("val2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\nExpected: val2\n     but: was <attr=\"val1\">");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toAttributeNamespaceURIAndLocalNameMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("aaa", "attr", new MatcherAttributeValue("val"));
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr1", new MatcherAttributeValue("val1"));
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr2", new MatcherAttributeValue("val2"));

        try {
            Raw.elementAssertion().toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute(null, null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute(null, null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("", null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("", null, new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toAttribute("aaa", "attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toAttribute("aaa", "attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("bbb", "attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("bbb", "attr", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).toAttribute("aaa", "attr2", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").toAttribute("aaa", "attr2", new MatcherAttributeValue(""));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).toAttribute("aaa", "attr", new MatcherAttributeValue("val2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\nExpected: val2\n     but: was <ns1:attr=\"val1\">");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").toAttribute("aaa", "attr", new MatcherAttributeValue("val2"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\nExpected: val2\n     but: was <ns1:attr=\"val1\">");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasAttributeValueLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasAttributeValue("attr", "val");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasAttributeValue("attr1", "val1");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasAttributeValue("attr2", "val2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasAttributeValue("xmlns", "aaa");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasAttributeValue("xmlns:ns1", "aaa");

        try {
            Raw.elementAssertion().hasAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).hasAttributeValue("attr2", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>"), "Message").hasAttributeValue("attr2", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>")).hasAttributeValue("attr", "val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>"), "Message").hasAttributeValue("attr", "val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasAttributeValueNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("aaa", "attr", "val");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttributeValue("aaa", "attr1", "val1");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttributeValue("aaa", "attr2", "val2");

        try {
            Raw.elementAssertion().hasAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue(null, null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue(null, null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("", null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("", null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasAttributeValue("aaa", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasAttributeValue("aaa", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("bbb", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttributeValue("bbb", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasAttributeValue("aaa", "attr2", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").hasAttributeValue("aaa", "attr2", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).hasAttributeValue("aaa", "attr", "val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").hasAttributeValue("aaa", "attr", "val2");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasNotAttributeValueLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("attr", "val");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val'/>")).hasNotAttributeValue("attr2", "val");
        initialize(Raw.elementAssertion(), createElement("<element attr='val1'/>")).hasNotAttributeValue("attr", "val2");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasNotAttributeValue("attr1", "val2");
        initialize(Raw.elementAssertion(), createElement("<element attr1='val1' attr2='val2'/>")).hasNotAttributeValue("attr2", "val1");
        initialize(Raw.elementAssertion(), createElement("<element xmlns='aaa'/>")).hasNotAttributeValue("xmlns", "bbb");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttributeValue("xmlns:ns2", "aaa");
        initialize(Raw.elementAssertion(), createElement("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttributeValue("xmlns:ns1", "bbb");

        try {
            Raw.elementAssertion().hasNotAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttributeValue("", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue(null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue(null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue("", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasNotAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element attr='val'/>"), "Message").hasNotAttributeValue("attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("ns1:attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: ns1:attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttributeValue("ns1:attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: ns1:attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasNotAttributeValueNamespaceURIAndLocalNameTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("aaa", "attr", "val");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("bbb", "attr", "val");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasNotAttributeValue("aaa", "attr2", "val");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).hasNotAttributeValue("aaa", "attr", "val2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttributeValue("aaa", "attr1", "val2");
        initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttributeValue("aaa", "attr2", "val1");

        try {
            Raw.elementAssertion().hasNotAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttributeValue("", "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue(null, "", "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue(null, null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue(null, null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("", null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue("", null, "");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue("", null, null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotAttributeValue("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasNotAttributeValue("", "", null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("aaa", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttributeValue("aaa", "attr", "val");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasChildNodesTest() {
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).hasChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).hasChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).hasChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).hasChildNodes();

        try {
            Raw.elementAssertion().hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>")).hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element></element>"), "Message").hasChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the child nodes.\n\tActual:<<element/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasNotChildNodesTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasNotChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasNotChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element></element>")).hasNotChildNodes();
        initialize(Raw.elementAssertion(), createElement("<element attr='val'></element>")).hasNotChildNodes();

        try {
            Raw.elementAssertion().hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element>text</element>")).hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element>text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element>text</element>"), "Message").hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element>text</element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element><child/><child/><child/></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>"), "Message").hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element><child/><child/><child/></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element><?procinstr?></element>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>"), "Message").hasNotChildNodes();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element><?procinstr?></element>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toChildNodesCountTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element></element>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildNodesCount().isEqualTo(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).toChildNodesCount().isEqualTo(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount().isEqualTo(5);
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).toChildNodesCount().isEqualTo(1);

        try {
            Raw.elementAssertion().toChildNodesCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildNodesCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildNodesCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount().isEqualTo(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildNodesCount().isEqualTo(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toChildNodesCountMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(5)));
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));

        try {
            Raw.elementAssertion().toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildNodesCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildNodesCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toChildNodesCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toChildNodesCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount(Matchers.equalTo(2));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\nExpected: <2>\n     but: was <5>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildNodesCount(Matchers.equalTo(2));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\nExpected: <2>\n     but: was <5>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasChildNodesCountTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasChildNodesCount(0);
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasChildNodesCount(0);
        initialize(Raw.elementAssertion(), createElement("<element></element>")).hasChildNodesCount(0);
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).hasChildNodesCount(1);
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).hasChildNodesCount(1);
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildNodesCount(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).hasChildNodesCount(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).hasChildNodesCount(5);
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).hasChildNodesCount(1);
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).hasChildNodesCount(1);

        try {
            Raw.elementAssertion().hasChildNodesCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasChildNodesCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasChildNodesCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).hasChildNodesCount(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").hasChildNodesCount(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toChildElementsCountTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element></element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).toChildElementsCount().isEqualTo(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount().isEqualTo(3);
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).toChildElementsCount().isEqualTo(1);
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).toChildElementsCount().isEqualTo(0);

        try {
            Raw.elementAssertion().toChildElementsCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildElementsCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildElementsCount();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount().isEqualTo(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildElementsCount().isEqualTo(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void toChildElementsCountMatcherTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));

        try {
            Raw.elementAssertion().toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null).toChildElementsCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").toChildElementsCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).toChildElementsCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").toChildElementsCount(null);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount(Matchers.equalTo(2));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\nExpected: <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildElementsCount(Matchers.equalTo(2));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\nExpected: <2>\n     but: was <3>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void hasChildElementsCountTest() {
        initialize(Raw.elementAssertion(), createElement("<element/>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element attr='val'/>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element></element>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element> </element>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element>text</element>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildElementsCount(0);
        initialize(Raw.elementAssertion(), createElement("<element><child/><child/><child/></element>")).hasChildElementsCount(3);
        initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).hasChildElementsCount(3);
        initialize(Raw.elementAssertion(), createElement("<element><child><child/><child/></child></element>")).hasChildElementsCount(1);
        initialize(Raw.elementAssertion(), createElement("<element><?procinstr?></element>")).hasChildElementsCount(0);

        try {
            Raw.elementAssertion().hasChildElementsCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.elementAssertion(), null).hasChildElementsCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), null, "Message").hasChildElementsCount(0);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>")).hasChildElementsCount(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element><child/>text1<child/>text2<child/></element>"), "Message").hasChildElementsCount(2);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.elementAssertion(), null).isNull();

        try {
            initialize(Raw.elementAssertion(), createElement("<element/>")).isNull();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), createElement("<element/>"), "Message").isNull();
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Element value = createElement("<element/>");
        initialize(Raw.elementAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.elementAssertion(), value).isSameAs(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), value, "Message").isSameAs(createElement("<element/>"));
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Element value = createElement("<element/>");
        initialize(Raw.elementAssertion(), value).isNotSameAs(createElement("<element/>"));

        try {
            initialize(Raw.elementAssertion(), value).isNotSameAs(value);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.elementAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<<element/>>");
        }
    }

    private static final class MatcherAttributeValue extends TypeSafeMatcher<Attr> {

        private final String _value;

        MatcherAttributeValue(final String value) {
            super();
            _value = value;
        }

        @Override
        protected boolean matchesSafely(final Attr attr) {
            return attr.getValue().equals(_value);
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText(_value);
        }

    }

}
