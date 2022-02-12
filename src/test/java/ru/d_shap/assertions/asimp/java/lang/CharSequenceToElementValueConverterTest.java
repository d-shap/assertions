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
package ru.d_shap.assertions.asimp.java.lang;

import org.junit.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link CharSequenceToElementValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceToElementValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharSequenceToElementValueConverterTest() {
        super();
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharSequenceToElementValueConverter().getValueClass()).isEqualTo(CharSequence.class);
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharSequenceToElementValueConverter().getTargetClass()).isEqualTo(Element.class);
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element/>")).isInstanceOf(Element.class);
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element/>"), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element/>")).as(Raw.elementAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element attr1='val1'><child>content</child></element>")).isInstanceOf(Element.class);
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element attr1='val1'><child>content</child></element>"), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<element attr1='val1'><child>content</child></element>")).as(Raw.elementAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>")).isInstanceOf(Element.class);
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>"), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>")).as(Raw.elementAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>")).isInstanceOf(Element.class);
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>"), Raw.elementAssertion()).hasProperties("aaa", "element");
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>")).as(Raw.elementAssertion()).hasProperties("aaa", "element");

        Assertions.assertThat(new CharSequenceToElementValueConverter().convert(new StringBuilder("<element/>"))).isInstanceOf(Element.class);
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert(new StringBuilder("<element/>")), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToElementValueConverter().convert(new StringBuilder("<element/>"))).as(Raw.elementAssertion()).hasProperties("element");

        try {
            new CharSequenceToElementValueConverter().convert("<element>");
            Assertions.fail("CharSequenceToElementValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).messageContains("XML document structures must start and end within the same entity.");
            Assertions.assertThat(ex).hasCause(SAXException.class);
        }
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new CharSequenceToElementValueConverter().convert(null);
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new CharSequenceToElementValueConverter().convert(new Object());
    }

    /**
     * {@link CharSequenceToElementValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new CharSequenceToElementValueConverter().convert("<element/>", new Object());
    }

}
