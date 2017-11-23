///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ObjectAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectAssertionTest() {
        super();
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.objectAssertion(), "value").isEqualTo("value");

        try {
            initialize(Raw.objectAssertion(), null).isEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), null, "Message").isEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value").isEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.objectAssertion(), "value1", "Message").isEqualTo("value2");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.objectAssertion(), "value1").isNotEqualTo("value2");
        initialize(Raw.objectAssertion(), "value2").isNotEqualTo("value1");

        try {
            initialize(Raw.objectAssertion(), null).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), null, "Message").isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value").isNotEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isNotEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value").isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<value>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.objectAssertion(), null).isNull();

        try {
            initialize(Raw.objectAssertion(), "value").isNull();
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isNull();
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<value>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object value = new Object();
        initialize(Raw.objectAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.objectAssertion(), value).isSameAs(new Object());
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.lang.Object@.*> but was:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value, "Message").isSameAs(new Object());
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.lang.Object@.*> but was:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value).isSameAs("test");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.lang.Object@.*>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Object value = new Object();
        initialize(Raw.objectAssertion(), value).isNotSameAs(new Object());
        initialize(Raw.objectAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.objectAssertion(), value).isNotSameAs(value);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.lang.Object@.*>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.objectAssertion(), new Object()).asString(null));
            Assertions.fail("ObjectAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.objectAssertion(), new Object()).asString("value")).isEqualTo("value");
        Assertions.assertThat(initialize(Raw.objectAssertion(), new Object()).asString(1)).isEqualTo("1");
        Assertions.assertThat(initialize(Raw.objectAssertion(), new Object()).asString(new StringBuilder("builder"))).isEqualTo("builder");
    }

}
