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
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toValueTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toValueMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link AttrAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasValueTest() throws Exception {
        // TODO
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
