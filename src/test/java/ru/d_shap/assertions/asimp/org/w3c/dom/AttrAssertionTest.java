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
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;
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

    private Attr createAttr(final String element) throws ConversionException {
        Document document = ValueConverter.convert(element, Document.class);
        Element documentElement = document.getDocumentElement();
        return (Attr) documentElement.getAttributes().item(0);
    }

}
