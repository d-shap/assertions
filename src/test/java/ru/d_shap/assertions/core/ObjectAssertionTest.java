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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link ObjectAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectAssertionTest {

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
        new ObjectAssertion("value", new FailDescription()).isEqualTo("value");

        try {
            new ObjectAssertion(null, new FailDescription()).isEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion(null, new FailDescription("Message")).isEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription("Message")).isEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new ObjectAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new ObjectAssertion("value1", new FailDescription("Message")).isEqualTo("value2");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value2> but was:<value1>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ObjectAssertion("value1", new FailDescription()).isNotEqualTo("value2");
        new ObjectAssertion("value2", new FailDescription()).isNotEqualTo("value1");

        try {
            new ObjectAssertion(null, new FailDescription()).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion(null, new FailDescription("Message")).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isNotEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription("Message")).isNotEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new ObjectAssertion("value", new FailDescription("Message")).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<value>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ObjectAssertion(null, new FailDescription()).isNull();

        try {
            new ObjectAssertion("value", new FailDescription()).isNull();
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<value>.");
        }
        try {
            new ObjectAssertion("value", new FailDescription("Message")).isNull();
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<value>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object value = new Object();
        new ObjectAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new ObjectAssertion(value, new FailDescription()).isSameAs(new Object());
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.lang.Object@.*> but was:<java.lang.Object@.*>.");
        }
        try {
            new ObjectAssertion(value, new FailDescription("Message")).isSameAs(new Object());
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.lang.Object@.*> but was:<java.lang.Object@.*>.");
        }
        try {
            new ObjectAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.lang.Object@.*>.");
        }
        try {
            new ObjectAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.lang.Object@.*>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Object value = new Object();
        new ObjectAssertion(value, new FailDescription()).isNotSameAs(new Object());
        new ObjectAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new ObjectAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.lang.Object@.*>.");
        }
        try {
            new ObjectAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.lang.Object@.*>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(null));
            Assertions.fail("ObjectAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString("value")).isEqualTo("value");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(1)).isEqualTo("1");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(new StringBuilder("builder"))).isEqualTo("builder");
    }

}
