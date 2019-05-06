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
import org.w3c.dom.Document;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link StringToDocumentValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class StringToDocumentValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public StringToDocumentValueConverterTest() {
        super();
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new StringToDocumentValueConverter().getValueClass()).isEqualTo(String.class);
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new StringToDocumentValueConverter().getTargetClass()).isEqualTo(Document.class);
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new StringToDocumentValueConverter().convert("<element/>")).isInstanceOf(Document.class);
        Assertions.assertThat(new StringToDocumentValueConverter().convert("<element/>"), Raw.documentAssertion()).hasProperties("element");
        Assertions.assertThat(new StringToDocumentValueConverter().convert("<element/>")).as(Raw.documentAssertion()).hasProperties("element");
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new StringToDocumentValueConverter().convert(null);
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new StringToDocumentValueConverter().convert(new Object());
    }

    /**
     * {@link StringToDocumentValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new StringToDocumentValueConverter().convert("<element/>", new Object());
    }

}
