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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ElementAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ElementAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ElementAssertionTest() {
        super();
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void actualValueValidatorTest() throws Exception {
        initialize(Raw.elementAssertion(), createElement("<element/>"));

        try {
            initializeWithRawActual(Raw.elementAssertion(), new Object());
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Element> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.elementAssertion(), new Object(), "Message");
            Assertions.fail("ElementAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<org.w3c.dom.Element> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToElementTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isEqualToStringTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToElementTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotEqualToStringTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURITest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toNamespaceURIMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasNamespaceURITest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toPrefixMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPrefixTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLocalNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toQualifiedNameMatcherTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasQualifiedNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalNameTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNullTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isSameAsTest() throws Exception {
        // TODO
    }

    /**
     * {@link ElementAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isNotSameAsTest() throws Exception {
        // TODO
    }

}
