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
import org.w3c.dom.Document;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DocumentAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DocumentAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DocumentAssertionTest() {
        super();
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>"));

        try {
            initializeWithRawActual(Raw.documentAssertion(), new Object());
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Document> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.documentAssertion(), new Object(), "Message");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Document> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isEqualToElementTest() {
        initialize(Raw.documentAssertion(), null).isEqualTo((Document) null);
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo(createDocument("<element/>"));
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).isEqualTo(createDocument("<element/>"));
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).isEqualTo(createDocument("<element attr2='val2' attr1='val1'/>"));
        initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>")).isEqualTo(createDocument("<element><child>text</child></element>"));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>")).isEqualTo(createDocument("<element xmlns='aaa'>text</element>"));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isEqualTo(createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));

        try {
            Raw.documentAssertion().isEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).isEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>")).isEqualTo(createDocument("<element2/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>"), "Message").isEqualTo(createDocument("<element2/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo(createDocument("<element>content</element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo(createDocument("<element>content</element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo(createDocument("<element attr='val'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo(createDocument("<element attr='val'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).isEqualTo(createDocument("<element xmlns:ns1='aaa'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").isEqualTo(createDocument("<element xmlns:ns1='aaa'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isEqualToStringTest() {
        initialize(Raw.documentAssertion(), null).isEqualTo((String) null);
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo("<element/>");
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).isEqualTo("<element/>");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).isEqualTo("<element attr2='val2' attr1='val1'/>");
        initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>")).isEqualTo("<element><child>text</child></element>");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>")).isEqualTo("<element xmlns='aaa'>text</element>");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");

        try {
            Raw.documentAssertion().isEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).isEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), null).isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>")).isEqualTo("<element2/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>"), "Message").isEqualTo("<element2/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element2/>> but was:<<element1/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo("<element>content</element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo("<element>content</element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element>content</element>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo("<element attr='val'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo("<element attr='val'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element attr=\"val\"/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).isEqualTo("<element xmlns:ns1='aaa'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").isEqualTo("<element xmlns:ns1='aaa'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<element xmlns:ns1=\"aaa\"/>> but was:<<element xmlns=\"aaa\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isNotEqualToElementTest() {
        initialize(Raw.documentAssertion(), null).isNotEqualTo(createDocument("<element/>"));
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo((Document) null);
        initialize(Raw.documentAssertion(), createDocument("<element1/>")).isNotEqualTo(createDocument("<element2/>"));
        initialize(Raw.documentAssertion(), createDocument("<element1></element1>")).isNotEqualTo(createDocument("<element2/>"));
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo(createDocument("<element>content</element>"));
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo(createDocument("<element attr='val'/>"));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).isNotEqualTo(createDocument("<element xmlns:ns1='aaa'/>"));

        try {
            Raw.documentAssertion().isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).isNotEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isNotEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>")).isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>"), "Message").isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1'/>")).isNotEqualTo(createDocument("<element attr1='val1'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1'/>"), "Message").isNotEqualTo(createDocument("<element attr1='val1'/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>")).isNotEqualTo(createDocument("<element><child>text</child></element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>"), "Message").isNotEqualTo(createDocument("<element><child>text</child></element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>")).isNotEqualTo(createDocument("<element xmlns='aaa'>text</element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>"), "Message").isNotEqualTo(createDocument("<element xmlns='aaa'>text</element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isNotEqualTo(createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"), "Message").isNotEqualTo(createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isNotEqualToStringTest() {
        initialize(Raw.documentAssertion(), null).isNotEqualTo("<element/>");
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo((String) null);
        initialize(Raw.documentAssertion(), createDocument("<element1/>")).isNotEqualTo("<element2/>");
        initialize(Raw.documentAssertion(), createDocument("<element1></element1>")).isNotEqualTo("<element2/>");
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo("<element>content</element>");
        initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo("<element attr='val'/>");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).isNotEqualTo("<element xmlns:ns1='aaa'/>");

        try {
            Raw.documentAssertion().isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).isNotEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isNotEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t.*");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>")).isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>"), "Message").isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1'/>")).isNotEqualTo("<element attr1='val1'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1'/>"), "Message").isNotEqualTo("<element attr1='val1'/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element attr1=\"val1\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>")).isNotEqualTo("<element><child>text</child></element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child>text</child></element>"), "Message").isNotEqualTo("<element><child>text</child></element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element><child>text</child></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>")).isNotEqualTo("<element xmlns='aaa'>text</element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'>text</element>"), "Message").isNotEqualTo("<element xmlns='aaa'>text</element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<element xmlns=\"aaa\">text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>")).isNotEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>"), "Message").isNotEqualTo("<ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb'><ns2:child>text</ns2:child></ns1:element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<ns1:element xmlns:ns1=\"aaa\" xmlns:ns2=\"bbb\"><ns2:child>text</ns2:child></ns1:element>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toNamespaceURITest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toNamespaceURI().isNull();
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("aaa");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI().isEqualTo("aaa");

        try {
            Raw.documentAssertion().toNamespaceURI();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toNamespaceURI();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toNamespaceURIMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toNamespaceURI(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));

        try {
            Raw.documentAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNamespaceURITest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasNamespaceURI("aaa");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasNamespaceURI("aaa");

        try {
            Raw.documentAssertion().hasNamespaceURI("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNamespaceURI("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNamespaceURI(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasNamespaceURI("bbb");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").hasNamespaceURI("bbb");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toPrefixTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toPrefix().isNull();
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toPrefix().isNull();
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns1");

        try {
            Raw.documentAssertion().toPrefix();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toPrefix();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toPrefix();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toPrefix().isEqualTo("ns2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix().isEqualTo("ns2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toPrefixMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toPrefix(Matchers.is(Matchers.emptyOrNullString()));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.is(Matchers.equalTo("ns1")));

        try {
            Raw.documentAssertion().toPrefix(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toPrefix(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toPrefix(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasPrefixTest() {
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns1");

        try {
            Raw.documentAssertion().hasPrefix("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasPrefix("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasPrefix("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasPrefix(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasPrefix("ns2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasPrefix("ns2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toLocalName().isEqualTo("element");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toLocalName().isEqualTo("element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toLocalName().isEqualTo("element");

        try {
            Raw.documentAssertion().toLocalName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toLocalName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toLocalName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).toLocalName().isEqualTo("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").toLocalName().isEqualTo("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toLocalNameMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toLocalName(Matchers.is(Matchers.equalTo("element")));

        try {
            Raw.documentAssertion().toLocalName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toLocalName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toLocalName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).toLocalName(Matchers.equalTo("element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").toLocalName(Matchers.equalTo("element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasLocalName("element");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasLocalName("element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasLocalName("element");

        try {
            Raw.documentAssertion().hasLocalName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasLocalName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasLocalName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasLocalName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).hasLocalName("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").hasLocalName("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toQualifiedNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toQualifiedName().isEqualTo("element");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toQualifiedName().isEqualTo("element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns1:element");

        try {
            Raw.documentAssertion().toQualifiedName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toQualifiedName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toQualifiedName();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).toQualifiedName().isEqualTo("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").toQualifiedName().isEqualTo("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns2:element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").toQualifiedName().isEqualTo("ns2:element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>")).toQualifiedName().isEqualTo("ns1:element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toQualifiedName().isEqualTo("ns1:element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toQualifiedNameMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toQualifiedName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("element")));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("ns1:element")));

        try {
            Raw.documentAssertion().toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).toQualifiedName(Matchers.equalTo("element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"element2\"\n     but: was \"element1\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.equalTo("ns2:element"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"ns2:element\"\n     but: was \"ns1:element\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("ns2:element"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"ns2:element\"\n     but: was \"ns1:element\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>")).toQualifiedName(Matchers.equalTo("ns1:element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"ns1:element2\"\n     but: was \"ns1:element1\"");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").toQualifiedName(Matchers.equalTo("ns1:element2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"ns1:element2\"\n     but: was \"ns1:element1\"");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasQualifiedNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasQualifiedName("element");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasQualifiedName("element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasQualifiedName("ns1:element");

        try {
            Raw.documentAssertion().hasQualifiedName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasQualifiedName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasQualifiedName("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasQualifiedName(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>")).hasQualifiedName("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1 xmlns='aaa'/>"), "Message").hasQualifiedName("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasQualifiedName("ns2:element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasQualifiedName("ns2:element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:element> but was:<ns1:element>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>")).hasQualifiedName("ns1:element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasQualifiedName("ns1:element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns1:element2> but was:<ns1:element1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasPropertiesLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasProperties("element");
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasProperties("element");
        initialize(Raw.documentAssertion(), createDocument("<element2/>")).hasProperties("element2");
        initialize(Raw.documentAssertion(), createDocument("<element>content</element>")).hasProperties("element");

        try {
            Raw.documentAssertion().hasProperties("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasProperties("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasProperties("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasProperties(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasProperties(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasProperties(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasProperties(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>")).hasProperties("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element1/>"), "Message").hasProperties("element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasProperties("element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").hasProperties("element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual value should be null.\n\tActual:<aaa>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.documentAssertion(), createDocument("<ns2:element xmlns:ns2='aaa'/>")).hasProperties("aaa", "element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='bbb'/>")).hasProperties("bbb", "element");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element2 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");

        try {
            Raw.documentAssertion().hasProperties("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasProperties("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasProperties("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasProperties(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasProperties(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasProperties(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasProperties(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasProperties(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasProperties(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedNamespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasProperties("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasProperties("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedLocalName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasProperties("bbb", "element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasProperties("bbb", "element");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>")).hasProperties("aaa", "element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element1 xmlns:ns1='aaa'/>"), "Message").hasProperties("aaa", "element2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasAttributeLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasAttribute("attr");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasAttribute("attr1");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasAttribute("attr2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasAttribute("xmlns");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasAttribute("xmlns:ns1");

        try {
            Raw.documentAssertion().hasAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).hasAttribute("attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>"), "Message").hasAttribute("attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("aaa", "attr");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttribute("aaa", "attr1");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttribute("aaa", "attr2");

        try {
            Raw.documentAssertion().hasAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttribute("bbb", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttribute("bbb", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasAttribute("aaa", "attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").hasAttribute("aaa", "attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNotAttributeLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute("attr");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).hasNotAttribute("attr2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("attr");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("ns2:attr");

        try {
            Raw.documentAssertion().hasNotAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasNotAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<attr> but was:<<element attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>"), "Message").hasNotAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<attr> but was:<<element attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasNotAttribute("attr1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<attr1> but was:<<element attr1=\"val1\" attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>"), "Message").hasNotAttribute("attr1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<attr1> but was:<<element attr1=\"val1\" attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasNotAttribute("xmlns");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<xmlns> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>"), "Message").hasNotAttribute("xmlns");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<xmlns> but was:<<element xmlns=\"aaa\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttribute("xmlns:ns1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<xmlns:ns1> but was:<<ns1:element xmlns:ns1=\"aaa\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>"), "Message").hasNotAttribute("xmlns:ns1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<xmlns:ns1> but was:<<ns1:element xmlns:ns1=\"aaa\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNotAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute("aaa", "attr");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("bbb", "attr");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasNotAttribute("aaa", "attr2");

        try {
            Raw.documentAssertion().hasNotAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttribute(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttribute("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttribute("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttribute("aaa", "attr1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the expected attribute.\n\tExpected:<{aaa}attr1> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val1\" ns1:attr2=\"val2\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>"), "Message").hasNotAttribute("aaa", "attr1");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the expected attribute.\n\tExpected:<{aaa}attr1> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val1\" ns1:attr2=\"val2\"/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toAttributeLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toAttribute("attr").hasValue("val");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).toAttribute("attr1").hasValue("val1");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).toAttribute("attr2").hasValue("val2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toAttribute("xmlns").hasValue("aaa");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toAttribute("xmlns:ns1").hasValue("aaa");

        try {
            Raw.documentAssertion().toAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute("");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).toAttribute("attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>"), "Message").toAttribute("attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>")).toAttribute("attr").hasValue("val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>"), "Message").toAttribute("attr").hasValue("val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toAttributeNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("aaa", "attr").hasValue("val");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr1").hasValue("val1");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr2").hasValue("val2");

        try {
            Raw.documentAssertion().toAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, (String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, (String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("", (String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("", (String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("aaa", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("bbb", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("bbb", "attr");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).toAttribute("aaa", "attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").toAttribute("aaa", "attr2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).toAttribute("aaa", "attr").hasValue("val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").toAttribute("aaa", "attr").hasValue("val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toAttributeLocalNameMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toAttribute("attr", new MatcherAttributeValue("val"));
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).toAttribute("attr1", new MatcherAttributeValue("val1"));
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).toAttribute("attr2", new MatcherAttributeValue("val2"));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toAttribute("xmlns", new MatcherAttributeValue("aaa"));
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).toAttribute("xmlns:ns1", new MatcherAttributeValue("aaa"));

        try {
            Raw.documentAssertion().toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute("", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, (Matcher<Attr>) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, (Matcher<Attr>) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("", (Matcher<Attr>) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("", (Matcher<Attr>) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).toAttribute("attr2", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>"), "Message").toAttribute("attr2", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>")).toAttribute("attr", new MatcherAttributeValue("val2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\nExpected: val2\n     but: was <attr=\"val1\">");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>"), "Message").toAttribute("attr", new MatcherAttributeValue("val2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\nExpected: val2\n     but: was <attr=\"val1\">");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toAttributeNamespaceURIAndLocalNameMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("aaa", "attr", new MatcherAttributeValue("val"));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr1", new MatcherAttributeValue("val1"));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).toAttribute("aaa", "attr2", new MatcherAttributeValue("val2"));

        try {
            Raw.documentAssertion().toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute("", "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, "", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute(null, null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute(null, null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("", null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("", null, new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toAttribute("aaa", "attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toAttribute("aaa", "attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toAttribute("bbb", "attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toAttribute("bbb", "attr", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).toAttribute("aaa", "attr2", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").toAttribute("aaa", "attr2", new MatcherAttributeValue(""));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).toAttribute("aaa", "attr", new MatcherAttributeValue("val2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\nExpected: val2\n     but: was <ns1:attr=\"val1\">");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").toAttribute("aaa", "attr", new MatcherAttributeValue("val2"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\nExpected: val2\n     but: was <ns1:attr=\"val1\">");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasAttributeValueLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasAttributeValue("attr", "val");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasAttributeValue("attr1", "val1");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasAttributeValue("attr2", "val2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasAttributeValue("xmlns", "aaa");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasAttributeValue("xmlns:ns1", "aaa");

        try {
            Raw.documentAssertion().hasAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).hasAttributeValue("attr2", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>"), "Message").hasAttributeValue("attr2", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr2> but was:<<element attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>")).hasAttributeValue("attr", "val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>"), "Message").hasAttributeValue("attr", "val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasAttributeValueNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("aaa", "attr", "val");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttributeValue("aaa", "attr1", "val1");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasAttributeValue("aaa", "attr2", "val2");

        try {
            Raw.documentAssertion().hasAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue(null, null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue(null, null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("", null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("", null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasAttributeValue("aaa", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasAttributeValue("aaa", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasAttributeValue("bbb", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasAttributeValue("bbb", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{bbb}attr> but was:<<element xmlns:ns1=\"aaa\" ns1:attr=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasAttributeValue("aaa", "attr2", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>"), "Message").hasAttributeValue("aaa", "attr2", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the expected attribute.\n\tExpected:<{aaa}attr2> but was:<<element xmlns:ns1=\"aaa\" ns1:attr1=\"val\"/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).hasAttributeValue("aaa", "attr", "val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>"), "Message").hasAttributeValue("aaa", "attr", "val2");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNotAttributeValueLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("attr", "val");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val'/>")).hasNotAttributeValue("attr2", "val");
        initialize(Raw.documentAssertion(), createDocument("<element attr='val1'/>")).hasNotAttributeValue("attr", "val2");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasNotAttributeValue("attr1", "val2");
        initialize(Raw.documentAssertion(), createDocument("<element attr1='val1' attr2='val2'/>")).hasNotAttributeValue("attr2", "val1");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).hasNotAttributeValue("xmlns", "bbb");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttributeValue("xmlns:ns2", "aaa");
        initialize(Raw.documentAssertion(), createDocument("<ns1:element xmlns:ns1='aaa'/>")).hasNotAttributeValue("xmlns:ns1", "bbb");

        try {
            Raw.documentAssertion().hasNotAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttributeValue("", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue(null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue(null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue("", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasNotAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>"), "Message").hasNotAttributeValue("attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("ns1:attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: ns1:attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttributeValue("ns1:attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: ns1:attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNotAttributeValueNamespaceURIAndLocalNameTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("aaa", "attr", "val");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("bbb", "attr", "val");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val'/>")).hasNotAttributeValue("aaa", "attr2", "val");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val1'/>")).hasNotAttributeValue("aaa", "attr", "val2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttributeValue("aaa", "attr1", "val2");
        initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr1='val1' ns1:attr2='val2'/>")).hasNotAttributeValue("aaa", "attr2", "val1");

        try {
            Raw.documentAssertion().hasNotAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttributeValue("", "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue(null, "", "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue(null, null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue(null, null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: namespaceURI.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("", null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue("", null, "");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue("", null, null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: localName.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotAttributeValue("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasNotAttributeValue("", "", null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: value.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNotAttributeValue("aaa", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNotAttributeValue("aaa", "attr", "val");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's attribute: {aaa}attr.\n\tCheck actual value's value.\n\tActual and expected values should be different.\n\tActual:<val>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasChildNodesTest() {
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).hasChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).hasChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).hasChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).hasChildNodes();

        try {
            Raw.documentAssertion().hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>")).hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the child nodes.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element></element>"), "Message").hasChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the child nodes.\n\tActual:<<element/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasNotChildNodesTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasNotChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasNotChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).hasNotChildNodes();
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'></element>")).hasNotChildNodes();

        try {
            Raw.documentAssertion().hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element>text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element>text</element>"), "Message").hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element>text</element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element><child/><child/><child/></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>"), "Message").hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element><child/><child/><child/></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the child nodes.\n\tActual:<<element><?procinstr?></element>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>"), "Message").hasNotChildNodes();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the child nodes.\n\tActual:<<element><?procinstr?></element>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toChildNodesCountTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).toChildNodesCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildNodesCount().isEqualTo(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).toChildNodesCount().isEqualTo(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount().isEqualTo(5);
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).toChildNodesCount().isEqualTo(1);
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).toChildNodesCount().isEqualTo(1);

        try {
            Raw.documentAssertion().toChildNodesCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildNodesCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildNodesCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount().isEqualTo(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildNodesCount().isEqualTo(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toChildNodesCountMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(5)));
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).toChildNodesCount(Matchers.is(Matchers.equalTo(1)));

        try {
            Raw.documentAssertion().toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildNodesCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildNodesCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildNodesCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildNodesCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toChildNodesCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildNodesCount(Matchers.equalTo(2));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\nExpected: <2>\n     but: was <5>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildNodesCount(Matchers.equalTo(2));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\nExpected: <2>\n     but: was <5>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasChildNodesCountTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasChildNodesCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasChildNodesCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).hasChildNodesCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).hasChildNodesCount(1);
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).hasChildNodesCount(1);
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildNodesCount(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).hasChildNodesCount(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).hasChildNodesCount(5);
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).hasChildNodesCount(1);
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).hasChildNodesCount(1);

        try {
            Raw.documentAssertion().hasChildNodesCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasChildNodesCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasChildNodesCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).hasChildNodesCount(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").hasChildNodesCount(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child nodes count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<5>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toChildElementsCountTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildElementsCount().isEqualTo(0);
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).toChildElementsCount().isEqualTo(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount().isEqualTo(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).toChildElementsCount().isEqualTo(1);
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).toChildElementsCount().isEqualTo(0);

        try {
            Raw.documentAssertion().toChildElementsCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildElementsCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildElementsCount();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount().isEqualTo(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildElementsCount().isEqualTo(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void toChildElementsCountMatcherTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).toChildElementsCount(Matchers.is(Matchers.equalTo(0)));

        try {
            Raw.documentAssertion().toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildElementsCount(Matchers.equalTo(0));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null).toChildElementsCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").toChildElementsCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).toChildElementsCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").toChildElementsCount(null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).toChildElementsCount(Matchers.equalTo(2));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\nExpected: <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").toChildElementsCount(Matchers.equalTo(2));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\nExpected: <2>\n     but: was <3>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void hasChildElementsCountTest() {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element attr='val'/>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element></element>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element> </element>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element>text</element>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element><![CDATA[text1]]>text2<![CDATA[text3]]></element>")).hasChildElementsCount(0);
        initialize(Raw.documentAssertion(), createDocument("<element><child/><child/><child/></element>")).hasChildElementsCount(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).hasChildElementsCount(3);
        initialize(Raw.documentAssertion(), createDocument("<element><child><child/><child/></child></element>")).hasChildElementsCount(1);
        initialize(Raw.documentAssertion(), createDocument("<element><?procinstr?></element>")).hasChildElementsCount(0);

        try {
            Raw.documentAssertion().hasChildElementsCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.documentAssertion(), null).hasChildElementsCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").hasChildElementsCount(0);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>")).hasChildElementsCount(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element><child/>text1<child/>text2<child/></element>"), "Message").hasChildElementsCount(2);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's child elements count.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.documentAssertion(), null).isNull();

        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNull();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNull();
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<element/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Document value = createDocument("<element/>");
        initialize(Raw.documentAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.documentAssertion(), value).isSameAs(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), value, "Message").isSameAs(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<<element/>> but was:<<element/>>");
        }
    }

    /**
     * {@link DocumentAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Document value = createDocument("<element/>");
        initialize(Raw.documentAssertion(), value).isNotSameAs(createDocument("<element/>"));

        try {
            initialize(Raw.documentAssertion(), value).isNotSameAs(value);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<<element/>>");
        }
        try {
            initialize(Raw.documentAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DocumentAssertion test fail");
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
