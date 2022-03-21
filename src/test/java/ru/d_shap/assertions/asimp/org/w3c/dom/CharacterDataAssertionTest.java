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
import org.w3c.dom.CharacterData;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharacterDataAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharacterDataAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharacterDataAssertionTest() {
        super();
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.characterDataAssertion(), createCharacterData("text"));

        try {
            initializeWithRawActual(Raw.characterDataAssertion(), new Object());
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.CharacterData> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.characterDataAssertion(), new Object(), "Message");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.CharacterData> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.characterDataAssertion(), null).isEqualTo(null);
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).isEqualTo(createCharacterData("text"));
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).isEqualTo(createCharacterData("<!-- comment -->"));
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>")).isEqualTo(createCharacterData("<![CDATA[<element>value<element>]]>"));

        try {
            Raw.characterDataAssertion().isEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).isEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").isEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").isEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1")).isEqualTo(createCharacterData("text2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1"), "Message").isEqualTo(createCharacterData("text2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment1 -->")).isEqualTo(createCharacterData("<!-- comment2 -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<!-- comment2 -->> but was:<<!-- comment1 -->>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment1 -->"), "Message").isEqualTo(createCharacterData("<!-- comment2 -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<!-- comment2 -->> but was:<<!-- comment1 -->>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value1<element>]]>")).isEqualTo(createCharacterData("<![CDATA[<element>value2<element>]]>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<![CDATA[<element>value2<element>]]>> but was:<<![CDATA[<element>value1<element>]]>>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value1<element>]]>"), "Message").isEqualTo(createCharacterData("<![CDATA[<element>value2<element>]]>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<![CDATA[<element>value2<element>]]>> but was:<<![CDATA[<element>value1<element>]]>>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).isEqualTo(createCharacterData("<!-- comment -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<!-- comment -->> but was:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").isEqualTo(createCharacterData("<!-- comment -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<!-- comment -->> but was:<text>");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.characterDataAssertion(), null).isNotEqualTo(createCharacterData("text"));
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).isNotEqualTo(null);
        initialize(Raw.characterDataAssertion(), createCharacterData("text1")).isNotEqualTo(createCharacterData("text2"));
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment1 -->")).isNotEqualTo(createCharacterData("<!-- comment2 -->"));
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value1<element>]]>")).isNotEqualTo(createCharacterData("<![CDATA[<element>value2<element>]]>"));
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).isNotEqualTo(createCharacterData("<!-- comment -->"));
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).isNotEqualTo(createCharacterData("<![CDATA[<element>value<element>]]>"));
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).isNotEqualTo(createCharacterData("<![CDATA[<element>value<element>]]>"));

        try {
            Raw.characterDataAssertion().isNotEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).isNotEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").isNotEqualTo(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).isNotEqualTo(createCharacterData("<!-- comment -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->"), "Message").isNotEqualTo(createCharacterData("<!-- comment -->"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<!-- comment -->>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>")).isNotEqualTo(createCharacterData("<![CDATA[<element>value<element>]]>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<![CDATA[<element>value<element>]]>>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>"), "Message").isNotEqualTo(createCharacterData("<![CDATA[<element>value<element>]]>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<![CDATA[<element>value<element>]]>>");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void toDataTest() {
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).toData().isEqualTo("text");
        initialize(Raw.characterDataAssertion(), createCharacterData("<!--comment-->")).toData().isEqualTo("comment");
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).toData().isEqualTo(" comment ");
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>")).toData().isEqualTo("<element>value<element>");
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).toData().isEqualTo(" <element> value <element> ");

        try {
            Raw.characterDataAssertion().toData();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).toData();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").toData();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1")).toData().isEqualTo("text2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1"), "Message").toData().isEqualTo("text2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).toData().isEqualTo("comment");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<comment> but was:< comment >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->"), "Message").toData().isEqualTo("comment");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<comment> but was:< comment >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).toData().isEqualTo("<element>value<element>");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<<element>value<element>> but was:< <element> value <element> >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>"), "Message").toData().isEqualTo("<element>value<element>");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<<element>value<element>> but was:< <element> value <element> >");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void toDataMatcherTest() {
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).toData(Matchers.is(Matchers.equalTo("text")));
        initialize(Raw.characterDataAssertion(), createCharacterData("<!--comment-->")).toData(Matchers.is(Matchers.equalTo("comment")));
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).toData(Matchers.is(Matchers.equalTo(" comment ")));
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>")).toData(Matchers.is(Matchers.equalTo("<element>value<element>")));
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).toData(Matchers.is(Matchers.equalTo(" <element> value <element> ")));

        try {
            Raw.characterDataAssertion().toData(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).toData(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").toData(Matchers.equalTo(""));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).toData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").toData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).toData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").toData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1")).toData(Matchers.equalTo("text2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\nExpected: \"text2\"\n     but: was \"text1\"");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1"), "Message").toData(Matchers.equalTo("text2"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\nExpected: \"text2\"\n     but: was \"text1\"");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).toData(Matchers.equalTo("comment"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\nExpected: \"comment\"\n     but: was \" comment \"");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->"), "Message").toData(Matchers.equalTo("comment"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\nExpected: \"comment\"\n     but: was \" comment \"");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).toData(Matchers.equalTo("<element>value<element>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\nExpected: \"<element>value<element>\"\n     but: was \" <element> value <element> \"");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>"), "Message").toData(Matchers.equalTo("<element>value<element>"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\nExpected: \"<element>value<element>\"\n     but: was \" <element> value <element> \"");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void hasDataTest() {
        initialize(Raw.characterDataAssertion(), createCharacterData("text")).hasData("text");
        initialize(Raw.characterDataAssertion(), createCharacterData("<!--comment-->")).hasData("comment");
        initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).hasData(" comment ");
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[<element>value<element>]]>")).hasData("<element>value<element>");
        initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).hasData(" <element> value <element> ");

        try {
            Raw.characterDataAssertion().hasData("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).hasData("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").hasData("");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null).hasData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), null, "Message").hasData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).hasData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").hasData(null);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1")).hasData("text2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text1"), "Message").hasData("text2");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<text2> but was:<text1>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->")).hasData("comment");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<comment> but was:< comment >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<!-- comment -->"), "Message").hasData("comment");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<comment> but was:< comment >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>")).hasData("<element>value<element>");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<<element>value<element>> but was:< <element> value <element> >");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("<![CDATA[ <element> value <element> ]]>"), "Message").hasData("<element>value<element>");
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<<element>value<element>> but was:< <element> value <element> >");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.characterDataAssertion(), null).isNull();

        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text")).isNull();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), createCharacterData("text"), "Message").isNull();
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<text>");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        CharacterData value = createCharacterData("text");
        initialize(Raw.characterDataAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.characterDataAssertion(), value).isSameAs(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<text> but was:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), value, "Message").isSameAs(createCharacterData("text"));
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<text> but was:<text>");
        }
    }

    /**
     * {@link CharacterDataAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        CharacterData value = createCharacterData("text");
        initialize(Raw.characterDataAssertion(), value).isNotSameAs(createCharacterData("text"));

        try {
            initialize(Raw.characterDataAssertion(), value).isNotSameAs(value);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<text>");
        }
        try {
            initialize(Raw.characterDataAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharacterDataAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<text>");
        }
    }

}
