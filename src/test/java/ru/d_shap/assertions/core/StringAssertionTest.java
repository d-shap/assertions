///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link StringAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class StringAssertionTest {

    /**
     * Test class constructor.
     */
    public StringAssertionTest() {
        super();
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new StringAssertion("value", null).isEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", null).isEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", null).isEqualTo("значение");

        try {
            new StringAssertion("value1", null).isEqualTo("value2");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new StringAssertion("value", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", null).isEqualTo("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new StringAssertion("value", null).isNotEqualTo("значение");
        new StringAssertion("value", null).isNotEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", null).isNotEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("value");

        try {
            new StringAssertion("value", null).isNotEqualTo("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new StringAssertion("значение", null).isNotEqualTo("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        new StringAssertion("valUe", null).isEqualToIgnoreCase("vALue");
        new StringAssertion("ЗНАЧЕНИЕ", null).isEqualToIgnoreCase("значение");
        new StringAssertion("значение", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");

        try {
            new StringAssertion("value1", null).isEqualToIgnoreCase("value2");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new StringAssertion("value", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isEqualToIgnoreCase("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>");
        }
        try {
            new StringAssertion("ЗнаЧеНИЕ", null).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        new StringAssertion("vaLUe", null).isNotEqualToIgnoreCase("знАЧенИЕ");
        new StringAssertion("VAluE", null).isNotEqualToIgnoreCase("ЗНачЕНие");
        new StringAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("vaLUe");
        new StringAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("VAluE");

        try {
            new StringAssertion("value", null).isNotEqualToIgnoreCase("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new StringAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>");
        }
        try {
            new StringAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsTest() {
        new StringAssertion("value", null).contains("val");
        new StringAssertion("value", null).contains("alu");
        new StringAssertion("value", null).contains("lue");
        new StringAssertion("значение", null).contains("знач");
        new StringAssertion("значение", null).contains("ен");
        new StringAssertion("значение", null).contains("ие");

        try {
            new StringAssertion("value", null).contains("VAL");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<VAL> but was:<value>");
        }
        try {
            new StringAssertion("value", null).contains("v.*ue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<v.*ue> but was:<value>");
        }
        try {
            new StringAssertion("value", null).contains("знач");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<знач> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).contains("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<value> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notContainsTest() {
        new StringAssertion("value", null).notContains("vaue");
        new StringAssertion("value", null).notContains("VAL");
        new StringAssertion("value", null).notContains("UE");
        new StringAssertion("значение", null).notContains("ЗНАЧ");
        new StringAssertion("значение", null).notContains("кени");
        new StringAssertion("значение", null).notContains("НИЕ");

        try {
            new StringAssertion("value", null).notContains("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).notContains("alu");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<alu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).notContains("lue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<lue> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).notContains("знач");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<знач> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).notContains("ение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<ение> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        new StringAssertion("value", null).containsIgnoreCase("VAL");
        new StringAssertion("VAlUE", null).containsIgnoreCase("aLu");
        new StringAssertion("VAlue", null).containsIgnoreCase("luE");
        new StringAssertion("значение", null).containsIgnoreCase("ЗНАЧ");
        new StringAssertion("ЗНАчЕнИЕ", null).containsIgnoreCase("еН");
        new StringAssertion("ЗНАЧЕние", null).containsIgnoreCase("Ие");

        try {
            new StringAssertion("value", null).containsIgnoreCase("VAE");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<VAE> but was:<value>");
        }
        try {
            new StringAssertion("vaLUe", null).containsIgnoreCase("v.*ue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<v.*ue> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLue", null).containsIgnoreCase("зНАч");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<зНАч> but was:<vaLue>");
        }
        try {
            new StringAssertion("знАЧЕние", null).containsIgnoreCase("valUE");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should contain the expected string. Expected:<valUE> but was:<знАЧЕние>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notContainsIgnoreCaseTest() {
        new StringAssertion("value", null).notContainsIgnoreCase("vaUE");
        new StringAssertion("valUE", null).notContainsIgnoreCase("1VAL");
        new StringAssertion("valUE", null).notContainsIgnoreCase("UE1");
        new StringAssertion("знАчеНие", null).notContainsIgnoreCase("ЗНАН");
        new StringAssertion("знАчеНие", null).notContainsIgnoreCase("кени");
        new StringAssertion("знАчеНие", null).notContainsIgnoreCase("чИЕ");

        try {
            new StringAssertion("vaLUe", null).notContainsIgnoreCase("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<val> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLUe", null).notContainsIgnoreCase("VAL");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<VAL> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLUe", null).notContainsIgnoreCase("lUE");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<lUE> but was:<vaLUe>");
        }
        try {
            new StringAssertion("зНАчеНИе", null).notContainsIgnoreCase("знач");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<знач> but was:<зНАчеНИе>");
        }
        try {
            new StringAssertion("зНАчеНИе", null).notContainsIgnoreCase("еНИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not contain the expected string. Expected:<еНИе> but was:<зНАчеНИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        new StringAssertion("val", null).isPartOf("value");
        new StringAssertion("alu", null).isPartOf("value");
        new StringAssertion("lue", null).isPartOf("value");
        new StringAssertion("знач", null).isPartOf("значение");
        new StringAssertion("ен", null).isPartOf("значение");
        new StringAssertion("ие", null).isPartOf("значение");

        try {
            new StringAssertion("VAL", null).isPartOf("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<value> but was:<VAL>");
        }
        try {
            new StringAssertion("vue", null).isPartOf("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<value> but was:<vue>");
        }
        try {
            new StringAssertion("ЗнАЧ", null).isPartOf("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<значение> but was:<ЗнАЧ>");
        }
        try {
            new StringAssertion("чача", null).isPartOf("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<значение> but was:<чача>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        new StringAssertion("vae", null).isNotPartOf("value");
        new StringAssertion("aLu", null).isNotPartOf("value");
        new StringAssertion("vue", null).isNotPartOf("value");
        new StringAssertion("знаач", null).isNotPartOf("значение");
        new StringAssertion("еНИ", null).isNotPartOf("значение");
        new StringAssertion("чие", null).isNotPartOf("значение");

        try {
            new StringAssertion("val", null).isNotPartOf("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<value> but was:<val>");
        }
        try {
            new StringAssertion("lue", null).isNotPartOf("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<value> but was:<lue>");
        }
        try {
            new StringAssertion("знач", null).isNotPartOf("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<значение> but was:<знач>");
        }
        try {
            new StringAssertion("ение", null).isNotPartOf("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<значение> but was:<ение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        new StringAssertion("vAl", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("Alu", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("luE", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("знАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("Ен", null).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("иЕ", null).isPartOfIgnoreCase("зНАчеНИе");

        try {
            new StringAssertion("VAe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<vaLUe> but was:<VAe>");
        }
        try {
            new StringAssertion("vUe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<vaLUe> but was:<vUe>");
        }
        try {
            new StringAssertion("ЗАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            new StringAssertion("чача", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should be the part of the expected string. Expected:<зНАчеНИе> but was:<чача>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        new StringAssertion("vAe", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("aLe", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("vuE", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("знААч", null).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("еНе", null).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("чИЕ", null).isNotPartOfIgnoreCase("знАченИе");

        try {
            new StringAssertion("VAL", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<vaLUe> but was:<VAL>");
        }
        try {
            new StringAssertion("LuE", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<vaLUe> but was:<LuE>");
        }
        try {
            new StringAssertion("зНАч", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<знАченИе> but was:<зНАч>");
        }
        try {
            new StringAssertion("ЕниЕ", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not be the part of the expected string. Expected:<знАченИе> but was:<ЕниЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void matchesTest() {
        new StringAssertion("value", null).matches("v.*e");
        new StringAssertion("value", null).matches("v[aA].{2}[eE]");
        new StringAssertion("value", null).matches("\\w+");
        new StringAssertion("value", null).matches("\\w{4,6}");
        new StringAssertion("значение", null).matches("\\p{L}+");

        try {
            new StringAssertion("value", null).matches("\\d+");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should match the expected regexp. Expected:<\\d+> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).matches("\\w+");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should match the expected regexp. Expected:<\\w+> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notMatchesTest() {
        new StringAssertion("value", null).notMatches("valu.+e");
        new StringAssertion("value", null).notMatches("v[zZ].{2}[eE]");
        new StringAssertion("value", null).notMatches("\\s\\w+");
        new StringAssertion("value", null).notMatches("\\w{8}");
        new StringAssertion("значение", null).notMatches("\\w+");

        try {
            new StringAssertion("value", null).notMatches("\\w+");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not match the expected regexp. Expected:<\\w+> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).notMatches("\\p{L}{8}");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not match the expected regexp. Expected:<\\p{L}{8}> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        new StringAssertion("value", null).startsWith("va");
        new StringAssertion("value", null).startsWith("val");
        new StringAssertion("value", null).startsWith("value");
        new StringAssertion("значение", null).startsWith("зна");
        new StringAssertion("значение", null).startsWith("значе");
        new StringAssertion("значение", null).startsWith("значение");

        try {
            new StringAssertion("value", null).startsWith("lue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<lue> but was:<value>");
        }
        try {
            new StringAssertion("value", null).startsWith("Val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<Val> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).startsWith("ачен");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<ачен> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).startsWith("Знач");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<Знач> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notStartsWithTest() {
        new StringAssertion("value", null).notStartsWith("VA");
        new StringAssertion("value", null).notStartsWith("VaL");
        new StringAssertion("value", null).notStartsWith("vale");
        new StringAssertion("значение", null).notStartsWith("ЗНА");
        new StringAssertion("значение", null).notStartsWith("Знач");
        new StringAssertion("значение", null).notStartsWith("чение");

        try {
            new StringAssertion("value", null).notStartsWith("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).notStartsWith("valu");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).notStartsWith("зн");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<зн> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).notStartsWith("значен");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<значен> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("vA");
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("VAl");
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("vaLUe");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНа");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНаче");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНачение");

        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase("lUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<lUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase("Vau");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<Vau> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("аЧен");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("Значи");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should start with the expected string. Expected:<Значи> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notStartsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).notStartsWithIgnoreCase("Vu");
        new StringAssertion("vAlUe", null).notStartsWithIgnoreCase("Vue");
        new StringAssertion("vAlUe", null).notStartsWithIgnoreCase("ale");
        new StringAssertion("знАчЕнИе", null).notStartsWithIgnoreCase("НА");
        new StringAssertion("знАчЕнИе", null).notStartsWithIgnoreCase("Знч");
        new StringAssertion("знАчЕнИе", null).notStartsWithIgnoreCase("чние");

        try {
            new StringAssertion("vAlUe", null).notStartsWithIgnoreCase("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<val> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).notStartsWithIgnoreCase("VALUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<VALUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).notStartsWithIgnoreCase("зн");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<зн> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).notStartsWithIgnoreCase("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not start with the expected string. Expected:<значение> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        new StringAssertion("value", null).endsWith("alue");
        new StringAssertion("value", null).endsWith("lue");
        new StringAssertion("value", null).endsWith("ue");
        new StringAssertion("значение", null).endsWith("ачение");
        new StringAssertion("значение", null).endsWith("ние");
        new StringAssertion("значение", null).endsWith("е");

        try {
            new StringAssertion("value", null).endsWith("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).endsWith("LuE");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<LuE> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).endsWith("значе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<значе> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).endsWith("ЧенИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<ЧенИе> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notEndsWithTest() {
        new StringAssertion("value", null).notEndsWith("aLue");
        new StringAssertion("value", null).notEndsWith("vue");
        new StringAssertion("value", null).notEndsWith("val");
        new StringAssertion("значение", null).notEndsWith("ачЕниЕ");
        new StringAssertion("значение", null).notEndsWith("зние");
        new StringAssertion("значение", null).notEndsWith("зна");

        try {
            new StringAssertion("value", null).notEndsWith("value");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).notEndsWith("alue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<alue> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).notEndsWith("значение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<значение> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).notEndsWith("ие");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<ие> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("vaLue");
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("Lue");
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("E");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("значеНИЕ");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("чеНИЕ");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("Е");
        new StringAssertion("aaaxxxxx", null).endsWithIgnoreCase("xxx");

        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase("val");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<val> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase("vUe");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<vUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАчЕ");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАИе");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should end with the expected string. Expected:<знАИе> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void notEndsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).notEndsWithIgnoreCase("aLe");
        new StringAssertion("vAlUe", null).notEndsWithIgnoreCase("vue");
        new StringAssertion("vAlUe", null).notEndsWithIgnoreCase("val");
        new StringAssertion("знАчЕнИе", null).notEndsWithIgnoreCase("зачЕниЕ");
        new StringAssertion("знАчЕнИе", null).notEndsWithIgnoreCase("зние");
        new StringAssertion("знАчЕнИе", null).notEndsWithIgnoreCase("зна");

        try {
            new StringAssertion("vAlUe", null).notEndsWithIgnoreCase("vaLue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<vaLue> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).notEndsWithIgnoreCase("aLue");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<aLue> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).notEndsWithIgnoreCase("знАчение");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).notEndsWithIgnoreCase("е");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<е> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("aaaxxxxx", null).notEndsWithIgnoreCase("xxx");
            Assertions.fail("String assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String should not end with the expected string. Expected:<xxx> but was:<aaaxxxxx>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new StringAssertion("vAlUe", null).toLength().isEqualTo(5);
        new StringAssertion("vAlUe", null).toLength().isGreaterThan(3);
        new StringAssertion("vAlUe", null).toLength().isLessThan(7);

        new StringAssertion("знАчЕнИе", null).toLength().isEqualTo(8);
        new StringAssertion("знАчЕнИе", null).toLength().isGreaterThan(5);
        new StringAssertion("знАчЕнИе", null).toLength().isLessThan(10);
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new StringAssertion("vAlUe", null).hasLength(5);
        new StringAssertion("знАчЕнИе", null).hasLength(8);
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString("vAlUe")).isEqualTo("vAlUe");
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString("знАчЕнИе")).isEqualTo("знАчЕнИе");
    }

}
