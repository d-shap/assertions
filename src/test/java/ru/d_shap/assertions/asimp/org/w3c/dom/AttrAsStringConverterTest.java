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

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.converter.ValueConverter;

/**
 * Tests for {@link AttrAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class AttrAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public AttrAsStringConverterTest() {
        super();
    }

    /**
     * {@link AttrAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new AttrAsStringConverter().getValueClass()).isEqualTo(Attr.class);
    }

    /**
     * {@link AttrAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element attr='val'/>"))).isEqualTo("attr=val");
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element attr1='val'/>"))).isEqualTo("attr1=val");
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element attr='val1'/>"))).isEqualTo("attr=val1");
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element attr=\"val\"/>"))).isEqualTo("attr=val");
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element xmlns:ns1='http://example.com' ns1:attr='val'/>"))).isEqualTo("{http://example.com}attr=val");
        Assertions.assertThat(new AttrAsStringConverter().asString(createAttr("<element xmlns:ns1='http://example.com' attr='ns1:val'/>"))).isEqualTo("attr=ns1:val");
    }

    /**
     * {@link AttrAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new AttrAsStringConverter().asString(null);
    }

    /**
     * {@link AttrAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new AttrAsStringConverter().asString(new Object());
    }

    private Attr createAttr(final String element) throws Exception {
        Document document = ValueConverter.convert(element, Document.class);
        Element documentElement = document.getDocumentElement();
        return (Attr) documentElement.getAttributes().item(0);
    }

}
