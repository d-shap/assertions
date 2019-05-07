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

import javax.xml.XMLConstants;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ValueConverter;

/**
 * Tests for {@link AttrAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class AttrAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public AttrAssertionTest() {
        super();
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void actualValueValidatorTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"));

        try {
            initializeWithRawActual(Raw.attrAssertion(), new Object());
            Assertions.fail("AttrAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Attr> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.attrAssertion(), new Object(), "Message");
            Assertions.fail("AttrAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Attr> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).isEqualTo(createAttr("<element attr='val'/>"));
        initialize(Raw.attrAssertion(), createAttr("<element attr1='val1'/>")).isEqualTo(createAttr("<element attr1='val1'/>"));

        try {
            Raw.attrAssertion().isEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).isEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").isEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).isEqualTo(createAttr("<element attr='val2'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<attr=val2> but was:<attr=val1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").isEqualTo(createAttr("<element attr='val2'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<attr=val2> but was:<attr=val1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr1='val'/>")).isEqualTo(createAttr("<element attr2='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<attr2=val> but was:<attr1=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr1='val'/>"), "Message").isEqualTo(createAttr("<element attr2='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<attr2=val> but was:<attr1=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).isEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<attr=val> but was:<{aaa}attr=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").isEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<attr=val> but was:<{aaa}attr=val>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).isNotEqualTo(createAttr("<element attr='val2'/>"));
        initialize(Raw.attrAssertion(), createAttr("<element attr1='val'/>")).isNotEqualTo(createAttr("<element attr2='val'/>"));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).isNotEqualTo(createAttr("<element attr='val'/>"));

        try {
            Raw.attrAssertion().isNotEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).isNotEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").isNotEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).isNotEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<attr=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").isNotEqualTo(createAttr("<element attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<attr=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).isNotEqualTo(createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{aaa}attr=val>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").isNotEqualTo(createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{aaa}attr=val>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toNamespaceURI().isNull();
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toNamespaceURI().isNull();
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toNamespaceURI().isEqualTo("aaa");

        try {
            Raw.attrAssertion().toNamespaceURI();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toNamespaceURI();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toNamespaceURI();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toNamespaceURI().isEqualTo("bbb");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toNamespaceURI(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toNamespaceURI(Matchers.is(Matchers.equalTo("aaa")));

        try {
            Raw.attrAssertion().toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toNamespaceURI(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toNamespaceURI(Matchers.equalTo("bbb"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\nExpected: \"bbb\"\n     but: was \"aaa\"");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNamespaceURI("aaa");

        try {
            Raw.attrAssertion().hasNamespaceURI("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasNamespaceURI("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasNamespaceURI("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasNamespaceURI(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasNamespaceURI("bbb");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasNamespaceURI("bbb");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's namespace URI.\n\tActual and expected values should be the same.\n\tExpected:<bbb> but was:<aaa>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toPrefix().isNull();
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toPrefix().isNull();
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toPrefix().isEqualTo("ns1");

        try {
            Raw.attrAssertion().toPrefix();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toPrefix();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toPrefix();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toPrefix().isEqualTo("ns2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toPrefix().isEqualTo("ns2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toPrefix(Matchers.is(Matchers.isEmptyOrNullString()));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toPrefix(Matchers.is(Matchers.equalTo("ns1")));

        try {
            Raw.attrAssertion().toPrefix(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toPrefix(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toPrefix(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toPrefix(Matchers.equalTo("ns2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\nExpected: \"ns2\"\n     but: was \"ns1\"");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasPrefix("ns1");

        try {
            Raw.attrAssertion().hasPrefix("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasPrefix("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasPrefix("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasPrefix(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasPrefix("ns2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasPrefix("ns2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's prefix.\n\tActual and expected values should be the same.\n\tExpected:<ns2> but was:<ns1>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toLocalName().isEqualTo("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toLocalName().isEqualTo("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toLocalName().isEqualTo("attr");

        try {
            Raw.attrAssertion().toLocalName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toLocalName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toLocalName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toLocalName().isEqualTo("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toLocalName().isEqualTo("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toLocalName(Matchers.is(Matchers.equalTo("attr")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toLocalName(Matchers.is(Matchers.equalTo("attr")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toLocalName(Matchers.is(Matchers.equalTo("attr")));

        try {
            Raw.attrAssertion().toLocalName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toLocalName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toLocalName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toLocalName(Matchers.equalTo("bttr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\nExpected: \"bttr\"\n     but: was \"attr\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toLocalName(Matchers.equalTo("bttr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\nExpected: \"bttr\"\n     but: was \"attr\"");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasLocalName("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).hasLocalName("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasLocalName("attr");

        try {
            Raw.attrAssertion().hasLocalName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasLocalName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasLocalName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasLocalName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasLocalName("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasLocalName("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toQualifiedName().isEqualTo("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toQualifiedName().isEqualTo("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toQualifiedName().isEqualTo("ns1:attr");

        try {
            Raw.attrAssertion().toQualifiedName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toQualifiedName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toQualifiedName();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).toQualifiedName().isEqualTo("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").toQualifiedName().isEqualTo("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toQualifiedName().isEqualTo("ns2:attr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:attr> but was:<ns1:attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toQualifiedName().isEqualTo("ns2:attr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:attr> but was:<ns1:attr>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameMatcherTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("attr")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("attr")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toQualifiedName(Matchers.is(Matchers.equalTo("ns1:attr")));

        try {
            Raw.attrAssertion().toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toQualifiedName(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).toQualifiedName(Matchers.equalTo("bttr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"bttr\"\n     but: was \"attr\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").toQualifiedName(Matchers.equalTo("bttr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"bttr\"\n     but: was \"attr\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toQualifiedName(Matchers.equalTo("ns2:attr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\nExpected: \"ns2:attr\"\n     but: was \"ns1:attr\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").toQualifiedName(Matchers.equalTo("ns2:attr"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\nExpected: \"ns2:attr\"\n     but: was \"ns1:attr\"");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasQualifiedNameTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasQualifiedName("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).hasQualifiedName("attr");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasQualifiedName("ns1:attr");

        try {
            Raw.attrAssertion().hasQualifiedName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasQualifiedName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasQualifiedName("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasQualifiedName(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>")).hasQualifiedName("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val'/>"), "Message").hasQualifiedName("bttr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<bttr> but was:<attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasQualifiedName("ns2:attr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:attr> but was:<ns1:attr>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>"), "Message").hasQualifiedName("ns2:attr");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's qualified name.\n\tActual and expected values should be the same.\n\tExpected:<ns2:attr> but was:<ns1:attr>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toValueTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toValue().isEqualTo("val1");
        initialize(Raw.attrAssertion(), createAttr("<element attr='val2'/>")).toValue().isEqualTo("val2");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toValue().isEqualTo("val");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toValue().isEqualTo("val");

        try {
            Raw.attrAssertion().toValue();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toValue();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toValue();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toValue().isEqualTo("val2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toValue().isEqualTo("val2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toValueMatcherTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toValue(Matchers.is(Matchers.equalTo("val1")));
        initialize(Raw.attrAssertion(), createAttr("<element attr='val2'/>")).toValue(Matchers.is(Matchers.equalTo("val2")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).toValue(Matchers.is(Matchers.equalTo("val")));
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).toValue(Matchers.is(Matchers.equalTo("val")));

        try {
            Raw.attrAssertion().toValue(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toValue(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toValue(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).toValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").toValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).toValue(Matchers.equalTo("val2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\nExpected: \"val2\"\n     but: was \"val1\"");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").toValue(Matchers.equalTo("val2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value.\nExpected: \"val2\"\n     but: was \"val1\"");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasValueTest() throws Exception {
        initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasValue("val1");
        initialize(Raw.attrAssertion(), createAttr("<element attr='val2'/>")).hasValue("val2");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' attr='val'/>")).hasValue("val");
        initialize(Raw.attrAssertion(), createAttr("<element xmlns:ns1='aaa' ns1:attr='val'/>")).hasValue("val");

        try {
            Raw.attrAssertion().hasValue("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasValue("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasValue("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null).hasValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), null, "Message").hasValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasValue(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>")).hasValue("val2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            initialize(Raw.attrAssertion(), createAttr("<element attr='val1'/>"), "Message").hasValue("val2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNullTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isSameAsTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotSameAsTest() throws Exception {
        // TODO
    }

    private Attr createAttr(final String element) throws Exception {
        Document document = ValueConverter.convert(element, Document.class);
        Element documentElement = document.getDocumentElement();
        Attr attr = (Attr) documentElement.getAttributes().item(0);
        if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(attr.getNamespaceURI())) {
            return (Attr) documentElement.getAttributes().item(1);
        } else {
            return attr;
        }
    }

}
