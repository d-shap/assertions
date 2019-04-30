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
        initialize(Raw.qnameAssertion(), new QName("local"));

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
        initialize(Raw.qnameAssertion(), new QName("local")).isEqualTo(new QName("local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isEqualTo(new QName("namespace", "local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns")).isEqualTo(new QName("namespace", "local", "ns"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).isEqualTo(new QName("namespace", "local", "ns2"));

        try {
            Raw.qnameAssertion().isEqualTo(new QName("local"));
            Assertions.fail("qnameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).isEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").isEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1")).isEqualTo(new QName("local2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local1"), "Message").isEqualTo(new QName("local2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1")).isEqualTo(new QName("namespace", "local2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<{namespace}local2> but was:<{namespace}local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local1"), "Message").isEqualTo(new QName("namespace", "local2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<{namespace}local2> but was:<{namespace}local1>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).isEqualTo(new QName("namespace2", "local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<{namespace2}local> but was:<{namespace1}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace1", "local"), "Message").isEqualTo(new QName("namespace2", "local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<{namespace2}local> but was:<{namespace1}local>");
        }
    }

    /**
     * {@link QNameAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.qnameAssertion(), new QName("local1")).isNotEqualTo(new QName("local2"));
        initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(new QName("namespace", "local"));
        initialize(Raw.qnameAssertion(), new QName("namespace", "local1")).isNotEqualTo(new QName("namespace", "local2"));
        initialize(Raw.qnameAssertion(), new QName("namespace1", "local")).isNotEqualTo(new QName("namespace2", "local"));

        try {
            Raw.qnameAssertion().isNotEqualTo(new QName("local"));
            Assertions.fail("qnameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isNotEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isNotEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null).isNotEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").isNotEqualTo(null);
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local")).isNotEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("local"), "Message").isNotEqualTo(new QName("local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local")).isNotEqualTo(new QName("namespace", "local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local"), "Message").isNotEqualTo(new QName("namespace", "local"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1")).isNotEqualTo(new QName("namespace", "local", "ns2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<{namespace}local>");
        }
        try {
            initialize(Raw.qnameAssertion(), new QName("namespace", "local", "ns1"), "Message").isNotEqualTo(new QName("namespace", "local", "ns2"));
            Assertions.fail("QNameAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<{namespace}local>");
        }
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
