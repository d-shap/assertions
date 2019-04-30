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
package ru.d_shap.assertions.asimp.javax.xml.namespace;

import javax.xml.namespace.QName;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link QNameAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class QNameAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public QNameAssertionTest() {
        super();
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.qnameAssertion(), new QName("value"));

        try {
            initializeWithRawActual(Raw.qnameAssertion(), new Object());
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.namespace.QName> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.qnameAssertion(), new Object(), "Message");
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<javax.xml.namespace.QName> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toNamespaceURITest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toNamespaceURIMatcherTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasNamespaceURITest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toPrefixTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toPrefixMatcherTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPrefixTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toLocalPartTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void toLocalPartMatcherTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasLocalPartTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPropertiesLocalPartTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void hasPropertiesNamespaceURIAndLocalPartTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
