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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

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
    public void bytePrimitiveAssertionTest() {
        Assertions.assertThat((byte) 5).isEqualTo(5);
        Assertions.assertThat(createPrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byte", Raw.byteAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat((byte) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteObjectAssertionTest() {
        Assertions.assertThat((Byte) null).isNull();
        Assertions.assertThat(Byte.valueOf((byte) 5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.byteAssertion()).isNull();
        Assertions.assertThat((byte) 5, Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.byteAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteObj", Raw.byteAssertion()).isEqualTo(5);

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
    public void shortPrimitiveAssertionTest() {
        Assertions.assertThat((short) 5).isEqualTo(5);
        Assertions.assertThat(createPrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_short", Raw.shortAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat((short) 5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void shortObjectAssertionTest() {
        Assertions.assertThat((Short) null).isNull();
        Assertions.assertThat(Short.valueOf((short) 5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.shortAssertion()).isNull();
        Assertions.assertThat((short) 5, Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.shortAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortObj", Raw.shortAssertion()).isEqualTo(5);

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
    public void intPrimitiveAssertionTest() {
        Assertions.assertThat(5).isEqualTo(5);
        Assertions.assertThat(createPrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_int", Raw.intAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat(5).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void intObjectAssertionTest() {
        Assertions.assertThat((Integer) null).isNull();
        Assertions.assertThat(Integer.valueOf(5)).isEqualTo(5);
        Assertions.assertThat(null, Raw.intAssertion()).isNull();
        Assertions.assertThat(5, Raw.intAssertion()).isEqualTo(5);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.intAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intObj", Raw.intAssertion()).isEqualTo(5);

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
    public void longPrimitiveAssertionTest() {
        Assertions.assertThat(5L).isEqualTo(5L);
        Assertions.assertThat(createPrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_long", Raw.longAssertion()).isEqualTo(5);

        try {
            Assertions.assertThat(5L).isEqualTo(6L);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void longObjectAssertionTest() {
        Assertions.assertThat((Long) null).isNull();
        Assertions.assertThat(Long.valueOf(5L)).isEqualTo(5L);
        Assertions.assertThat(null, Raw.longAssertion()).isNull();
        Assertions.assertThat(5L, Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.longAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longObj", Raw.longAssertion()).isEqualTo(5L);

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
    public void floatPrimitiveAssertionTest() {
        Assertions.assertThat(5.0f).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(createPrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_float", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertThat(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void floatObjectAssertionTest() {
        Assertions.assertThat((Float) null).isNull();
        Assertions.assertThat(Float.valueOf(5.0f)).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(null, Raw.floatAssertion()).isNull();
        Assertions.assertThat((float) 5, Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.floatAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatObj", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

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
    public void doublePrimitiveAssertionTest() {
        Assertions.assertThat(5.0).isEqualTo(5.0, 0.001);
        Assertions.assertThat(createPrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_double", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertThat(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void doubleObjectAssertionTest() {
        Assertions.assertThat((Double) null).isNull();
        Assertions.assertThat(Double.valueOf(5.0)).isEqualTo(5.0, 0.001);
        Assertions.assertThat(null, Raw.doubleAssertion()).isNull();
        Assertions.assertThat(5.0, Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.doubleAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleObj", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

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
    public void booleanPrimitiveAssertionTest() {
        Assertions.assertThat(true).isTrue();
        Assertions.assertThat(createPrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_boolean", Raw.booleanAssertion()).isTrue();

        try {
            Assertions.assertThat(true).isFalse();
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void booleanObjectAssertionTest() {
        Assertions.assertThat((Boolean) null).isNull();
        Assertions.assertThat(Boolean.TRUE).isTrue();
        Assertions.assertThat(null, Raw.booleanAssertion()).isNull();
        Assertions.assertThat(true, Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.booleanAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_booleanObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_booleanObj", Raw.booleanAssertion()).isTrue();

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
    public void charPrimitiveAssertionTest() {
        Assertions.assertThat('5').isEqualTo('5');
        Assertions.assertThat(createPrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_char", Raw.charAssertion()).isEqualTo('5');

        try {
            Assertions.assertThat('5').isEqualTo('6');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void charObjectAssertionTest() {
        Assertions.assertThat((Character) null).isNull();
        Assertions.assertThat(Character.valueOf('5')).isEqualTo('5');
        Assertions.assertThat(null, Raw.charAssertion()).isNull();
        Assertions.assertThat('5', Raw.charAssertion()).isEqualTo('5');
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.charAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charObj").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charObj", Raw.charAssertion()).isEqualTo('5');

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
        Assertions.assertThat(createNullFieldClass(), "_field").isNull();
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.objectAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_object", Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.byteArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteArray", Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.shortArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortArray", Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.intArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intArray", Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.longArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longArray", Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.floatArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatArray", Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.doubleArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleArray", Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.booleanArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_booleanArray", Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.charArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charArray", Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>objectArrayAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_objectArray", Raw.<String>objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");

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
        Assertions.assertThat((Class<?>) null).isNull();
        Assertions.assertThat(String.class).isSubtypeOf(Object.class);
        Assertions.assertThat(null, Raw.classAssertion()).isNull();
        Assertions.assertThat(String.class, Raw.classAssertion()).isSubtypeOf(Object.class);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.classAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_class", Raw.classAssertion()).isSubtypeOf(Object.class);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charSequence", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertThat(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<5> but was:<4>");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.stringAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_string", Raw.stringAssertion()).hasLength(4);

        try {
            Assertions.assertThat("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<5> but was:<4>");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<Integer>comparableAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_comparable", Raw.<Integer>comparableAssertion()).isEqualTo(5);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>iterableAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterable", Raw.<String>iterableAssertion()).hasSize(3);

        try {
            Assertions.assertThat(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.throwableAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_throwable", Raw.throwableAssertion()).isInstanceOf(Error.class);

        try {
            Assertions.assertThat(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterator", Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>listAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_list", Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");

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
        Assertions.assertThat(createHashSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(createHashSet("1", "2", "3"), Raw.<String>setAssertion()).containsExactly("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_set", Raw.<String>setAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertThat(createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void sortedSetAssertionTest() {
        Assertions.assertThat((SortedSet<String>) null).isNull();
        Assertions.assertThat(createTreeSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertThat(createTreeSet("1", "2", "3"), Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedSet").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedSet", Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertThat(createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_map", Raw.<String, String>mapAssertion()).hasSize(3);

        try {
            Assertions.assertThat(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void sortedMapAssertionTest() {
        Assertions.assertThat((SortedMap<String, String>) null).isNull();
        Assertions.assertThat(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertThat(null, Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertThat(createTreeMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>sortedMapAssertion()).hasSize(3);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedMap").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedMap", Raw.<String, String>sortedMapAssertion()).hasSize(3);

        try {
            Assertions.assertThat(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.inputStreamAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_inputStream", Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.readerAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_reader", Raw.readerAssertion()).isNextCharsEqualTo('1', '2');

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.byteBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_byteBuffer", Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.shortBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_shortBuffer", Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.intBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_intBuffer", Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.longBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_longBuffer", Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.floatBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_floatBuffer", Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.doubleBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_doubleBuffer", Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);

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
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.charBufferAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_charBuffer", Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);

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

}
