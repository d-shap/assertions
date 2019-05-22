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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void actualValueValidatorTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToElementTest() throws Exception {
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
            initialize(Raw.documentAssertion(), null).isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToStringTest() throws Exception {
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
            initialize(Raw.documentAssertion(), null).isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToElementTest() throws Exception {
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
            initialize(Raw.documentAssertion(), null).isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isNotEqualTo(createDocument("<element/>"));
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
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
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo((Document) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToStringTest() throws Exception {
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
            initialize(Raw.documentAssertion(), null).isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.documentAssertion(), null, "Message").isNotEqualTo("<element/>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
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
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo((String) null);
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>")).isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Argument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
        }
        try {
            initialize(Raw.documentAssertion(), createDocument("<element/>"), "Message").isNotEqualTo("<element>");
            Assertions.fail("DocumentAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().startsWith("Message.\n\tArgument should be valid: expected.\n\tThe argument's value should be the valid XML.\n\t");
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        initialize(Raw.documentAssertion(), createDocument("<element/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.documentAssertion(), createDocument("<element xmlns='aaa'/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameMatcherTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasQualifiedNameTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesLocalNameTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() throws Exception {
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

}
