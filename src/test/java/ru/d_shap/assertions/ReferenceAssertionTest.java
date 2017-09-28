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
package ru.d_shap.assertions;

import org.junit.Test;

import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.StringAssertion;

/**
 * Tests for {@link ReferenceAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReferenceAssertionTest {

    /**
     * Test class constructor.
     */
    public ReferenceAssertionTest() {
        super();
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ReferenceAssertionImpl(null, new FailDescription()).isNull();

        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<reference>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotNullTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).isNotNull();
        new ReferenceAssertionImpl("reference", new FailDescription()).isNotNull();

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object object = new Object();
        new ReferenceAssertionImpl(object, new FailDescription()).isSameAs(object);

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<value>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).isNotSameAs(new Object());
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isNotSameAs(new StringBuilder("value"));

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).isNotSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new Object(), new FailDescription()).isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            new ReferenceAssertionImpl(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toClassTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).toClass().isSameAs(Object.class);
        new ReferenceAssertionImpl(new Object(), new FailDescription()).toClass().isSubtypeOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).toClass().isSameAs(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).toClass().isSubtypeOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).toClass().isSubtypeOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).toClass().isSubtypeOf(Object.class);

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).toClass();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasClassTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).hasClass(Object.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasClass(StringBuilder.class);

        try {
            new ReferenceAssertionImpl(new Object(), new FailDescription()).hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Values should be the same. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Values should be the same. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Values should be the same. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasNotClassTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).hasNotClass(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasNotClass(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasNotClass(Object.class);

        try {
            new ReferenceAssertionImpl(new Object(), new FailDescription()).hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Values should be different. Actual:<java.lang.Object>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Values should be different. Actual:<java.lang.StringBuilder>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isInstanceOfTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).isInstanceOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isInstanceOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isInstanceOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isInstanceOf(Object.class);

        try {
            new ReferenceAssertionImpl(new Object(), new FailDescription()).isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotInstanceOfTest() {
        new ReferenceAssertionImpl(new Object(), new FailDescription()).isNotInstanceOf(StringBuilder.class);

        try {
            new ReferenceAssertionImpl(new Object(), new FailDescription()).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Object>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), new FailDescription()).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toToStringTest() {
        new ReferenceAssertionImpl("reference", new FailDescription()).toToString().isEqualTo("reference");
        new ReferenceAssertionImpl("reference", new FailDescription()).toToString().startsWith("ref");
        new ReferenceAssertionImpl("reference", new FailDescription()).toToString().endsWith("ce");

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).toToString();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isToStringEqualToTest() {
        new ReferenceAssertionImpl("reference", new FailDescription()).isToStringEqualTo("reference");

        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value string representation. Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value string representation. Values should be the same. Expected:<value> but was:<reference>.");
        }
        try {
            new ReferenceAssertionImpl("reference", new FailDescription().addMessage("Message")).isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value string representation. Values should be the same. Expected:<value> but was:<reference>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toStringContainsTest() {
        new ReferenceAssertionImpl("reference", new FailDescription()).toStringContains("feren");

        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value string representation. Value should contain the expected value. Expected:<FEREN> but was:<reference>.");
        }
        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value string representation. Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", new FailDescription().addMessage("Message")).toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value string representation. Value should contain the expected value. Expected:<FEREN> but was:<reference>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toHashCodeTest() {
        new ReferenceAssertionImpl("reference", new FailDescription()).toHashCode().isEqualTo(-925155509);
        new ReferenceAssertionImpl("reference", new FailDescription()).toHashCode().isLessThan(0);
        new ReferenceAssertionImpl("reference", new FailDescription()).toHashCode().isNotInRange(1, 10);

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).toHashCode();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isHashCodeEqualToTest() {
        new ReferenceAssertionImpl("reference", new FailDescription()).isHashCodeEqualTo(-925155509);

        try {
            new ReferenceAssertionImpl("reference", new FailDescription()).isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value hash code. Values should be the same. Expected:<1> but was:<-925155509>.");
        }
        try {
            new ReferenceAssertionImpl("reference", new FailDescription().addMessage("Message")).isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value hash code. Values should be the same. Expected:<1> but was:<-925155509>.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldTest() {
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_nullField").isNull();
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_nullField", StringAssertion.class).isNull();
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_nullField", ClassAssertion.class).isNull();
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_parentField").isNotNull();
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_parentField").isEqualTo("parentField");
        new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("_parentField", StringAssertion.class).isEqualTo("parentField");

        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_nullField").isNull();
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_nullField", StringAssertion.class).isNull();
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_nullField", ClassAssertion.class).isNull();
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_parentField").isNotNull();
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_parentField").isEqualTo("parentField");
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_parentField", StringAssertion.class).isEqualTo("parentField");
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_childField").isNotNull();
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_childField").isEqualTo("childField");
        new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_childField", StringAssertion.class).isEqualTo("childField");

        try {
            new ReferenceAssertionImpl(null, new FailDescription()).toField("_parentField");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new ToFieldParentClass(), new FailDescription()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected field. Expected:<wrongFieldName>.");
        }
        try {
            new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected field. Expected:<wrongFieldName>.");
        }
        try {
            new ReferenceAssertionImpl(new ToFieldChildClass(), new FailDescription()).toField("_childField", ClassAssertion.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.ClassAssertion - class should have one constructor ClassAssertion(java.lang.String, java.lang.String)");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ReferenceAssertionImpl extends ReferenceAssertion {

        ReferenceAssertionImpl(final Object actual, final FailDescription failDescription) {
            super(actual, failDescription);
        }

        @Override
        protected String asString(final Object value, final boolean actual) {
            return value.toString();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToFieldParentClass {

        private String _nullField;

        private String _parentField = "parentField";

        ToFieldParentClass() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToFieldChildClass extends ToFieldParentClass {

        private String _childField = "childField";

        ToFieldChildClass() {
            super();
        }

    }

}
