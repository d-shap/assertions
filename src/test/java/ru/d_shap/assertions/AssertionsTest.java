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
 * Tests for {@link Assertions}.
 *
 * @author Dmitry Shapovalov
 */
public final class AssertionsTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public AssertionsTest() {
        super();
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(Assertions.class).hasOnePrivateConstructor();
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void assertWithMessageTest() {
        Assertions.assertWithMessage("Simple test").that(5).isEqualTo(5);

        try {
            Assertions.assertWithMessage("Simple test").that(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Simple test. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteAssertionTest() {
        Assertions.assertThat((byte) 5).isEqualTo(5);
        Assertions.assertThat((Byte) null).isNull();
        Assertions.assertThat(Byte.valueOf((byte) 5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.byteAssertion()).isNull();
        Assertions.assertThat((byte) 5, Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.byteAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byte", Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertThat(new PrivateFieldsClass(), "_byteObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteObj", Raw.byteAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat((byte) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertThat(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void shortAssertionTest() {
        Assertions.assertThat((short) 5).isEqualTo(5);
        Assertions.assertThat((Short) null).isNull();
        Assertions.assertThat(Short.valueOf((short) 5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.shortAssertion()).isNull();
        Assertions.assertThat((short) 5, Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.shortAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_short", Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertThat(new PrivateFieldsClass(), "_shortObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortObj", Raw.shortAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat((short) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertThat(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void intAssertionTest() {
        Assertions.assertThat(5).isEqualTo(5);
        Assertions.assertThat((Integer) null).isNull();
        Assertions.assertThat(Integer.valueOf(5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.intAssertion()).isNull();
        Assertions.assertThat(5, Raw.intAssertion()).isEqualTo(5);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.intAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_int", Raw.intAssertion()).isEqualTo(5);
        Assertions.assertThat(new PrivateFieldsClass(), "_intObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intObj", Raw.intAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertThat(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void longAssertionTest() {
        Assertions.assertThat(5L).isEqualTo(5L);
        Assertions.assertThat((Long) null).isNull();
        Assertions.assertThat(Long.valueOf(5L)).isEqualTo(5L);
        Assertions.assertThat(null, Raw.longAssertion()).isNull();
        Assertions.assertThat(5L, Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.longAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_long", Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertThat(new PrivateFieldsClass(), "_longObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longObj", Raw.longAssertion()).isEqualTo(5L);

        try {
            Assertions.assertThat(5L).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertThat(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void floatAssertionTest() {
        Assertions.assertThat(5.0f).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat((Float) null).isNull();
        Assertions.assertThat(Float.valueOf(5.0f)).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(null, Raw.floatAssertion()).isNull();
        Assertions.assertThat(5.0f, Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.floatAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_float", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(new PrivateFieldsClass(), "_floatObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatObj", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertThat(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertThat(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void doubleAssertionTest() {
        Assertions.assertThat(5.0).isEqualTo(5.0, 0.001);
        Assertions.assertThat((Double) null).isNull();
        Assertions.assertThat(Double.valueOf(5.0)).isEqualTo(5.0, 0.001);
        Assertions.assertThat(null, Raw.doubleAssertion()).isNull();
        Assertions.assertThat(5.0, Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.doubleAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_double", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleObj", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertThat(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
        try {
            Assertions.assertThat(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void booleanAssertionTest() {
        Assertions.assertThat(true).isTrue();
        Assertions.assertThat((Boolean) null).isNull();
        Assertions.assertThat(Boolean.TRUE).isTrue();
        Assertions.assertThat(null, Raw.booleanAssertion()).isNull();
        Assertions.assertThat(true, Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.booleanAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_boolean", Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanObj", Raw.booleanAssertion()).isTrue();

        try {
            Assertions.assertThat(true).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertThat(Boolean.TRUE).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charAssertionTest() {
        Assertions.assertThat('5').isEqualTo('5');
        Assertions.assertThat((Character) null).isNull();
        Assertions.assertThat(Character.valueOf('5')).isEqualTo('5');
        Assertions.assertThat(null, Raw.charAssertion()).isNull();
        Assertions.assertThat('5', Raw.charAssertion()).isEqualTo('5');
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.charAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_char", Raw.charAssertion()).isEqualTo('5');
        Assertions.assertThat(new PrivateFieldsClass(), "_charObj").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charObj", Raw.charAssertion()).isEqualTo('5');

        try {
            Assertions.assertThat('5').isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertThat(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void objectAssertionTest() {
        Object object = new StringBuilder("value");
        Assertions.assertThat((Object) null).isNull();
        Assertions.assertThat(object).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertThat(null, Raw.objectAssertion()).isNull();
        Assertions.assertThat(object, Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertThat(new NullFieldClass(), "_field").isNull();
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.objectAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_object", Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));

        try {
            Assertions.assertThat(object).isNotEqualTo(object);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteArrayAssertionTest() {
        Assertions.assertThat((byte[]) null).isNull();
        Assertions.assertThat(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(null, Raw.byteArrayAssertion()).isNull();
        Assertions.assertThat(new byte[]{1, 2, 3}, Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.byteArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteArray", Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertThat(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void shortArrayAssertionTest() {
        Assertions.assertThat((short[]) null).isNull();
        Assertions.assertThat(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(null, Raw.shortArrayAssertion()).isNull();
        Assertions.assertThat(new short[]{1, 2, 3}, Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.shortArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortArray", Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertThat(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void intArrayAssertionTest() {
        Assertions.assertThat((int[]) null).isNull();
        Assertions.assertThat(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(null, Raw.intArrayAssertion()).isNull();
        Assertions.assertThat(new int[]{1, 2, 3}, Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.intArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intArray", Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertThat(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void longArrayAssertionTest() {
        Assertions.assertThat((long[]) null).isNull();
        Assertions.assertThat(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertThat(null, Raw.longArrayAssertion()).isNull();
        Assertions.assertThat(new long[]{1L, 2L, 3L}, Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.longArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longArray", Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);

        try {
            Assertions.assertThat(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void floatArrayAssertionTest() {
        Assertions.assertThat((float[]) null).isNull();
        Assertions.assertThat(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertThat(null, Raw.floatArrayAssertion()).isNull();
        Assertions.assertThat(new float[]{1.0f, 2.0f, 3.0f}, Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.floatArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatArray", Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

        try {
            Assertions.assertThat(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void doubleArrayAssertionTest() {
        Assertions.assertThat((double[]) null).isNull();
        Assertions.assertThat(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertThat(null, Raw.doubleArrayAssertion()).isNull();
        Assertions.assertThat(new double[]{1.0, 2.0, 3.0}, Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.doubleArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleArray", Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);

        try {
            Assertions.assertThat(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void booleanArrayAssertionTest() {
        Assertions.assertThat((boolean[]) null).isNull();
        Assertions.assertThat(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false);
        Assertions.assertThat(null, Raw.booleanArrayAssertion()).isNull();
        Assertions.assertThat(new boolean[]{true, true, false}, Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.booleanArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanArray", Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);

        try {
            Assertions.assertThat(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charArrayAssertionTest() {
        Assertions.assertThat((char[]) null).isNull();
        Assertions.assertThat(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(null, Raw.charArrayAssertion()).isNull();
        Assertions.assertThat(new char[]{'1', '2', '3'}, Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.charArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charArray", Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');

        try {
            Assertions.assertThat(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        Assertions.assertThat((String[]) null).isNull();
        Assertions.assertThat(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>objectArrayAssertion()).isNull();
        Assertions.assertThat(new String[]{"1", "2", "3"}, Raw.<String>objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>objectArrayAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_objectArray", Raw.<String>objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void classAssertionTest() {
        Assertions.assertThat((Class<String>) null).isNull();
        Assertions.assertThat(String.class).isSubtypeOf(Object.class);
        Assertions.assertThat(null, Raw.classAssertion()).isNull();
        Assertions.assertThat(String.class, Raw.classAssertion()).isSubtypeOf(Object.class);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.classAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_class", Raw.classAssertion()).isSubtypeOf(Object.class);

        try {
            Assertions.assertThat(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charSequenceAssertionTest() {
        Assertions.assertThat((CharSequence) null).isNull();
        Assertions.assertThat(new StringBuilder("test")).hasLength(4);
        Assertions.assertThat(null, Raw.charSequenceAssertion()).isNull();
        Assertions.assertThat(new StringBuilder("test"), Raw.charSequenceAssertion()).hasLength(4);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charSequence", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertThat(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertThat((String) null).isNull();
        Assertions.assertThat("test").hasLength(4);
        Assertions.assertThat(null, Raw.stringAssertion()).isNull();
        Assertions.assertThat("test", Raw.stringAssertion()).hasLength(4);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.stringAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_string", Raw.stringAssertion()).hasLength(4);

        try {
            Assertions.assertThat("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void comparableAssertionTest() {
        Comparable<Integer> comparable = Integer.valueOf("5");
        Assertions.assertThat((Comparable<Integer>) null).isNull();
        Assertions.assertThat(comparable).isEqualTo(5);
        Assertions.assertThat(null, Raw.<Integer>comparableAssertion()).isNull();
        Assertions.assertThat(comparable, Raw.<Integer>comparableAssertion()).isEqualTo(5);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<Integer>comparableAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_comparable", Raw.<Integer>comparableAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat(comparable).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void iterableAssertionTest() {
        Iterable<String> iterable = Arrays.asList("1", "2", "3");
        Assertions.assertThat((Iterable<String>) null).isNull();
        Assertions.assertThat(iterable).hasSize(3);
        Assertions.assertThat(null, Raw.<String>iterableAssertion()).isNull();
        Assertions.assertThat(iterable, Raw.<String>iterableAssertion()).hasSize(3);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>iterableAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterable", Raw.<String>iterableAssertion()).hasSize(3);

        try {
            Assertions.assertThat(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void throwableAssertionTest() {
        Assertions.assertThat((Throwable) null).isNull();
        Assertions.assertThat(new AssertionError("error")).isInstanceOf(Error.class);
        Assertions.assertThat(null, Raw.throwableAssertion()).isNull();
        Assertions.assertThat(new AssertionError("error"), Raw.throwableAssertion()).isInstanceOf(Error.class);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.throwableAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_throwable", Raw.throwableAssertion()).isInstanceOf(Error.class);

        try {
            Assertions.assertThat(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void collectionAssertionTest() {
        Collection<String> collection = Arrays.asList("1", "2", "3");
        Assertions.assertThat((Collection<String>) null).isNull();
        Assertions.assertThat(collection).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>collectionAssertion()).isNull();
        Assertions.assertThat(collection, Raw.<String>collectionAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>collectionAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_collection").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_collection", Raw.<String>collectionAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Assertions.assertThat((Iterator<String>) null).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3").iterator(), Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterator", Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertThat((List<String>) null).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>listAssertion()).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3"), Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>listAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_list", Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void setAssertionTest() {
        Assertions.assertThat((Set<String>) null).isNull();
        Assertions.assertThat(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(new HashSet<>(Arrays.asList("1", "2", "3")), Raw.<String>setAssertion()).containsExactly("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_set", Raw.<String>setAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertThat(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void mapAssertionTest() {
        Assertions.assertThat((Map<String, String>) null).isNull();
        Assertions.assertThat(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertThat(null, Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertThat(createHashMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>mapAssertion()).hasSize(3);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_map", Raw.<String, String>mapAssertion()).hasSize(3);

        try {
            Assertions.assertThat(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertThat((InputStream) null).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);
        Assertions.assertThat(null, Raw.inputStreamAssertion()).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3}), Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.inputStreamAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_inputStream", Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertThat((Reader) null).isNull();
        Assertions.assertThat(new StringReader("123")).isNextCharsEqualTo('1', '2');
        Assertions.assertThat(null, Raw.readerAssertion()).isNull();
        Assertions.assertThat(new StringReader("123"), Raw.readerAssertion()).isNextCharsEqualTo('1', '2');
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.readerAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_reader", Raw.readerAssertion()).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertThat(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteBufferAssertionTest() {
        Assertions.assertThat((ByteBuffer) null).isNull();
        Assertions.assertThat(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, Raw.byteBufferAssertion()).isNull();
        Assertions.assertThat(createByteBuffer(new byte[]{1, 2}), Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.byteBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteBuffer", Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void shortBufferAssertionTest() {
        Assertions.assertThat((ShortBuffer) null).isNull();
        Assertions.assertThat(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, Raw.shortBufferAssertion()).isNull();
        Assertions.assertThat(createShortBuffer(new short[]{1, 2}), Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.shortBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortBuffer", Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void intBufferAssertionTest() {
        Assertions.assertThat((IntBuffer) null).isNull();
        Assertions.assertThat(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, Raw.intBufferAssertion()).isNull();
        Assertions.assertThat(createIntBuffer(new int[]{1, 2}), Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.intBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intBuffer", Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void longBufferAssertionTest() {
        Assertions.assertThat((LongBuffer) null).isNull();
        Assertions.assertThat(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(null, Raw.longBufferAssertion()).isNull();
        Assertions.assertThat(createLongBuffer(new long[]{1L, 2L}), Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.longBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longBuffer", Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);

        try {
            Assertions.assertThat(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void floatBufferAssertionTest() {
        Assertions.assertThat((FloatBuffer) null).isNull();
        Assertions.assertThat(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(null, Raw.floatBufferAssertion()).isNull();
        Assertions.assertThat(createFloatBuffer(new float[]{1.0f, 2.0f}), Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.floatBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatBuffer", Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        try {
            Assertions.assertThat(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void doubleBufferAssertionTest() {
        Assertions.assertThat((DoubleBuffer) null).isNull();
        Assertions.assertThat(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(null, Raw.doubleBufferAssertion()).isNull();
        Assertions.assertThat(createDoubleBuffer(new double[]{1.0f, 2.0f}), Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.doubleBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleBuffer", Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);

        try {
            Assertions.assertThat(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charBufferAssertionTest() {
        Assertions.assertThat((CharBuffer) null).isNull();
        Assertions.assertThat(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(49, 50);
        Assertions.assertThat(null, Raw.charBufferAssertion()).isNull();
        Assertions.assertThat(createCharBuffer(new char[]{'1', '2'}), Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);
        Assertions.assertThat(new NullFieldClass(), "_field", Raw.charBufferAssertion()).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charBuffer", Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);

        try {
            Assertions.assertThat(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failTest() {
        try {
            Assertions.fail("fail a test");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("fail a test.");
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

        private String[] _objectArray = new String[]{"1", "2", "3"};

        private Class<String> _class = String.class;

        private CharSequence _charSequence = new StringBuilder("test");

        private String _string = "test";

        private Comparable<Integer> _comparable = Integer.valueOf("5");

        private Iterable<String> _iterable = Arrays.asList("1", "2", "3");

        private Throwable _throwable = new AssertionError("error");

        private Collection<String> _collection = Arrays.asList("1", "2", "3");

        private Iterator<String> _iterator = Arrays.asList("1", "2", "3").iterator();

        private List<String> _list = Arrays.asList("1", "2", "3");

        private Set<String> _set = new HashSet<>(Arrays.asList("1", "2", "3"));

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
