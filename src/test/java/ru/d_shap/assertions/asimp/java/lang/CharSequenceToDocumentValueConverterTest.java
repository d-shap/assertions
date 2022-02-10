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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link CharSequenceToDocumentValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceToDocumentValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharSequenceToDocumentValueConverterTest() {
        super();
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().getValueClass()).isEqualTo(CharSequence.class);
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().getTargetClass()).isEqualTo(Document.class);
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element/>")).isInstanceOf(Document.class);
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element/>"), Raw.documentAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element/>")).as(Raw.documentAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element attr1='val1'><child>content</child></element>")).isInstanceOf(Document.class);
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element attr1='val1'><child>content</child></element>"), Raw.documentAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<element attr1='val1'><child>content</child></element>")).as(Raw.documentAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>")).isInstanceOf(Document.class);
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>"), Raw.documentAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><element attr1='val1'><child>content</child></element>")).as(Raw.documentAssertion()).hasProperties("element");

        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>")).isInstanceOf(Document.class);
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>"), Raw.documentAssertion()).hasProperties("aaa", "element");
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert("<?xml version='1.0'?><ns1:element xmlns:ns1='aaa' xmlns:ns2='bbb' xmlns:ns3='ccc' ns2:attr1='val1'><ns3:child>content</ns3:child></ns1:element>")).as(Raw.documentAssertion()).hasProperties("aaa", "element");

        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert(new StringBuilder("<element/>"))).isInstanceOf(Document.class);
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert(new StringBuilder("<element/>")), Raw.documentAssertion()).hasProperties("element");
        Assertions.assertThat(new CharSequenceToDocumentValueConverter().convert(new StringBuilder("<element/>"))).as(Raw.documentAssertion()).hasProperties("element");

        try {
            new CharSequenceToDocumentValueConverter().convert("<element>");
            Assertions.fail("CharSequenceToDocumentValueConverter test fail");
        } catch (ConversionException ex) {
            Assertions.assertThat(ex).messageMatches(".*XML document structures must start and end within the same entity.");
            Assertions.assertThat(ex).hasCause(SAXException.class);
        }
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new CharSequenceToDocumentValueConverter().convert(null);
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new CharSequenceToDocumentValueConverter().convert(new Object());
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new CharSequenceToDocumentValueConverter().convert("<element/>", new Object());
    }

    /**
     * {@link CharSequenceToDocumentValueConverter} class test.
     */
    @Test
    public void stderrTest() {
        PrintStream stderr = System.err;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream, true, ENCODING_UTF_8);
                System.setErr(printStream);
                try {
                    String xml = "<?xml version='1.0'?>\n";
                    xml += "<document xmlns:ns1='http://example.com'>";
                    xml += "<ns1:element>value</ns1:element>";
                    xml += "<document>";
                    new CharSequenceToDocumentValueConverter().convert(xml);
                    Assertions.fail("CharSequenceToDocumentValueConverter test fail");
                } catch (ConversionException ex) {
                    Assertions.assertThat(ex).messageMatches(".*XML document structures must start and end within the same entity.");
                    Assertions.assertThat(ex).hasCause(SAXException.class);
                }
                String message = new String(byteArrayOutputStream.toByteArray(), ENCODING_UTF_8);
                Assertions.assertThat(message).isBlank();
            } catch (UnsupportedEncodingException ex) {
                Assertions.fail(ex.getMessage());
            }
        } finally {
            System.setErr(stderr);
        }
    }

}
