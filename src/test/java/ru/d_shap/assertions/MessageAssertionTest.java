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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for {@link MessageAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class MessageAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MessageAssertionTest() {
        super();
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteAssertionTest() {
        Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that((Byte) null).isNull();
        Assertions.assertWithMessage("Test message").that(Byte.valueOf((byte) 5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.byteAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that((byte) 5, Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.byteAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byte", Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteObj", Raw.byteAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((byte) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that((byte) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage(null).that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void shortAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that((Short) null).isNull();
        Assertions.assertWithMessage("Test message").that(Short.valueOf((short) 5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.shortAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that((short) 5, Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.shortAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_short", Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortObj", Raw.shortAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((short) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that((short) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage(null).that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void intAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that((Integer) null).isNull();
        Assertions.assertWithMessage("Test message").that(Integer.valueOf(5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.intAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5, Raw.intAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.intAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_int", Raw.intAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intObj", Raw.intAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage(null).that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void longAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5L).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that((Long) null).isNull();
        Assertions.assertWithMessage("Test message").that(Long.valueOf(5L)).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(null, Raw.longAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5L, Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.longAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_long", Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longObj", Raw.longAssertion()).isEqualTo(5L);

        try {
            Assertions.assertWithMessage(null).that(5L).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(5L).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5L).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage(null).that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void floatAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that((Float) null).isNull();
        Assertions.assertWithMessage("Test message").that(Float.valueOf(5.0f)).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(null, Raw.floatAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5.0f, Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.floatAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_float", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatObj", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertWithMessage(null).that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage(null).that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void doubleAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that((Double) null).isNull();
        Assertions.assertWithMessage("Test message").that(Double.valueOf(5.0)).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(null, Raw.doubleAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5.0, Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.doubleAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_double", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleObj", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertWithMessage(null).that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage(null).that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void booleanAssertionTest() {
        Assertions.assertWithMessage("Test message").that(true).isTrue();
        Assertions.assertWithMessage("Test message").that((Boolean) null).isNull();
        Assertions.assertWithMessage("Test message").that(Boolean.TRUE).isTrue();
        Assertions.assertWithMessage("Test message").that(null, Raw.booleanAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(true, Raw.booleanAssertion()).isTrue();
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.booleanAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_boolean", Raw.booleanAssertion()).isTrue();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanObj", Raw.booleanAssertion()).isTrue();

        try {
            Assertions.assertWithMessage(null).that(true).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("").that(true).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(true).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be false.");
        }
        try {
            Assertions.assertWithMessage(null).that(Boolean.TRUE).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("").that(Boolean.TRUE).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Boolean.TRUE).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be false.");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charAssertionTest() {
        Assertions.assertWithMessage("Test message").that('5').isEqualTo('5');
        Assertions.assertWithMessage("Test message").that((Character) null).isNull();
        Assertions.assertWithMessage("Test message").that(Character.valueOf('5')).isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(null, Raw.charAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that('5', Raw.charAssertion()).isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.charAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_char", Raw.charAssertion()).isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charObj", Raw.charAssertion()).isEqualTo('5');

        try {
            Assertions.assertWithMessage(null).that('5').isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("").that('5').isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("Test message").that('5').isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage(null).that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("").that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectAssertionTest() {
        Object object = new StringBuilder("value");
        Assertions.assertWithMessage("Test message").that((Object) null).isNull();
        Assertions.assertWithMessage("Test message").that(object).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertWithMessage("Test message").that(null, Raw.objectAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(object, Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field").isNull();
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.objectAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_object", Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));

        try {
            Assertions.assertWithMessage(null).that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            Assertions.assertWithMessage("").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be different. Actual:<value>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((byte[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, Raw.byteArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}, Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.byteArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteArray", Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, Raw.shortArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}, Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.shortArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortArray", Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((int[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, Raw.intArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}, Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.intArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intArray", Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((long[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertWithMessage("Test message").that(null, Raw.longArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}, Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.longArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longArray", Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);

        try {
            Assertions.assertWithMessage(null).that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((float[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertWithMessage("Test message").that(null, Raw.floatArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}, Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.floatArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatArray", Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

        try {
            Assertions.assertWithMessage(null).that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((double[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertWithMessage("Test message").that(null, Raw.doubleArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}, Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.doubleArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleArray", Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);

        try {
            Assertions.assertWithMessage(null).that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((boolean[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false);
        Assertions.assertWithMessage("Test message").that(null, Raw.booleanArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}, Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.booleanArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanArray", Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);

        try {
            Assertions.assertWithMessage(null).that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>");
        }
        try {
            Assertions.assertWithMessage("").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((char[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3');
        Assertions.assertWithMessage("Test message").that(null, Raw.charArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}, Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.charArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charArray", Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');

        try {
            Assertions.assertWithMessage(null).that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Object[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.objectArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}, Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.objectArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_objectArray", Raw.objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void classAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Class<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(Object.class);
        Assertions.assertWithMessage("Test message").that(null, Raw.classAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(String.class, Raw.classAssertion()).isSubtypeOf(Object.class);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.classAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_class", Raw.classAssertion()).isSubtypeOf(Object.class);

        try {
            Assertions.assertWithMessage(null).that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charSequenceAssertionTest() {
        Assertions.assertWithMessage("Test message").that((CharSequence) null).isNull();
        Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(4);
        Assertions.assertWithMessage("Test message").that(null, Raw.charSequenceAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new StringBuilder("test"), Raw.charSequenceAssertion()).hasLength(4);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charSequence", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertWithMessage("Test message").that((String) null).isNull();
        Assertions.assertWithMessage("Test message").that("test").hasLength(4);
        Assertions.assertWithMessage("Test message").that(null, Raw.stringAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that("test", Raw.stringAssertion()).hasLength(4);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.stringAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_string", Raw.stringAssertion()).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void comparableAssertionTest() {
        Comparable<?> comparable = Integer.valueOf("5");
        Assertions.assertWithMessage("Test message").that((Comparable<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.comparableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(comparable, Raw.comparableAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.comparableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_comparable", Raw.comparableAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iterableAssertionTest() {
        Iterable<?> iterable = Arrays.asList("1", "2", "3");
        Assertions.assertWithMessage("Test message").that((Iterable<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(iterable).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, Raw.iterableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(iterable, Raw.iterableAssertion()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.iterableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterable", Raw.iterableAssertion()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void throwableAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Throwable) null).isNull();
        Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(Error.class);
        Assertions.assertWithMessage("Test message").that(null, Raw.throwableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new AssertionError("error"), Raw.throwableAssertion()).isInstanceOf(Error.class);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.throwableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_throwable", Raw.throwableAssertion()).isInstanceOf(Error.class);

        try {
            Assertions.assertWithMessage(null).that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void collectionAssertionTest() {
        Collection<?> collection = Arrays.asList("1", "2", "3");
        Assertions.assertWithMessage("Test message").that((Collection<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(collection).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.collectionAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(collection, Raw.collectionAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.collectionAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_collection").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_collection", Raw.collectionAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Iterator<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.iteratorAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator(), Raw.iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.iteratorAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterator", Raw.iteratorAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertWithMessage("Test message").that((List<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.listAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3"), Raw.listAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.listAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_list", Raw.listAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void setAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Set<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.setAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3")), Raw.setAssertion()).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.setAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_set", Raw.setAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void mapAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Map<?, ?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, Raw.mapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3"), Raw.mapAssertion()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.mapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_map", Raw.mapAssertion()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertWithMessage("Test message").that((InputStream) null).isNull();
        Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);
        Assertions.assertWithMessage("Test message").that(null, Raw.inputStreamAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3}), Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.inputStreamAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_inputStream", Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertWithMessage(null).that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Reader) null).isNull();
        Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('1', '2');
        Assertions.assertWithMessage("Test message").that(null, Raw.readerAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new StringReader("123"), Raw.readerAssertion()).isNextCharsEqualTo('1', '2');
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.readerAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_reader", Raw.readerAssertion()).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertWithMessage(null).that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((ByteBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, Raw.byteBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createByteBuffer(new byte[]{1, 2}), Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.byteBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteBuffer", Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((ShortBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, Raw.shortBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createShortBuffer(new short[]{1, 2}), Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.shortBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortBuffer", Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((IntBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, Raw.intBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createIntBuffer(new int[]{1, 2}), Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.intBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intBuffer", Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((LongBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(1L, 2L);
        Assertions.assertWithMessage("Test message").that(null, Raw.longBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createLongBuffer(new long[]{1L, 2L}), Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.longBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longBuffer", Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);

        try {
            Assertions.assertWithMessage(null).that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((FloatBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertWithMessage("Test message").that(null, Raw.floatBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createFloatBuffer(new float[]{1.0f, 2.0f}), Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.floatBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatBuffer", Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        try {
            Assertions.assertWithMessage(null).that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((DoubleBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(null, Raw.doubleBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0, 2.0}), Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.doubleBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleBuffer", Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);

        try {
            Assertions.assertWithMessage(null).that(createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((CharBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(49, 50);
        Assertions.assertWithMessage("Test message").that(null, Raw.charBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createCharBuffer(new char[]{'1', '2'}), Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", Raw.charBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charBuffer", Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);

        try {
            Assertions.assertWithMessage(null).that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class NullFieldClass {

        private Object _field;

        NullFieldClass() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivateFieldsClass {

        private byte _byte = 5;

        private Byte _byteObj = 5;

        private short _short = 5;

        private Short _shortObj = 5;

        private int _int = 5;

        private Integer _intObj = 5;

        private long _long = 5L;

        private Long _longObj = 5L;

        private float _float = 5.0f;

        private Float _floatObj = 5.0f;

        private double _double = 5.0;

        private Double _doubleObj = 5.0;

        private boolean _boolean = true;

        private Boolean _booleanObj = true;

        private char _char = '5';

        private Character _charObj = '5';

        private Object _object = new StringBuilder("value");

        private byte[] _byteArray = new byte[]{1, 2, 3};

        private short[] _shortArray = new short[]{1, 2, 3};

        private int[] _intArray = new int[]{1, 2, 3};

        private long[] _longArray = new long[]{1L, 2L, 3L};

        private float[] _floatArray = new float[]{1.0f, 2.0f, 3.0f};

        private double[] _doubleArray = new double[]{1.0, 2.0, 3.0};

        private boolean[] _booleanArray = new boolean[]{true, true, false};

        private char[] _charArray = new char[]{'1', '2', '3'};

        private Object[] _objectArray = new Object[]{"1", "2", "3"};

        private Class<?> _class = String.class;

        private CharSequence _charSequence = new StringBuilder("test");

        private String _string = "test";

        private Comparable<?> _comparable = Integer.valueOf("5");

        private Iterable<?> _iterable = Arrays.asList("1", "2", "3");

        private Throwable _throwable = new AssertionError("error");

        private Collection<?> _collection = Arrays.asList("1", "2", "3");

        private Iterator<?> _iterator = Arrays.asList("1", "2", "3").iterator();

        private List<?> _list = Arrays.asList("1", "2", "3");

        private Set<?> _set = new HashSet<>(Arrays.asList("1", "2", "3"));

        private Map<String, String> _map = createHashMap("1", "val1", "2", "val2", "3", "val3");

        private InputStream _inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});

        private Reader _reader = new StringReader("123");

        private ByteBuffer _byteBuffer = createByteBuffer(new byte[]{1, 2});

        private ShortBuffer _shortBuffer = createShortBuffer(new short[]{1, 2});

        private IntBuffer _intBuffer = createIntBuffer(new int[]{1, 2});

        private LongBuffer _longBuffer = createLongBuffer(new long[]{1L, 2L});

        private FloatBuffer _floatBuffer = createFloatBuffer(new float[]{1.0f, 2.0f});

        private DoubleBuffer _doubleBuffer = createDoubleBuffer(new double[]{1.0f, 2.0f});

        private CharBuffer _charBuffer = createCharBuffer(new char[]{'1', '2'});

        PrivateFieldsClass() {
            super();
        }

    }

}
