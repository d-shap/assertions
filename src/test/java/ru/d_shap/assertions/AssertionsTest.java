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
package ru.d_shap.assertions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.d_shap.assertions.util.DataHelper;

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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Simple test.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void objectMatcherAssertionTest() {
        Assertions.assertThat(10, Matchers.is(Matchers.equalTo(10)));
        Assertions.assertThat(1L, Matchers.instanceOf(Long.class));
        Assertions.assertThat(1L, Matchers.isA(Long.class));
        Assertions.assertThat("", Matchers.emptyString());
        Assertions.assertThat("", Matchers.emptyOrNullString());
        Assertions.assertThat(new Integer[]{7, 5, 12, 16}, Matchers.arrayWithSize(4));
        Assertions.assertThat(new Integer[]{7, 5, 12, 16}, Matchers.arrayContaining(7, 5, 12, 16));
        Assertions.assertThat(DataHelper.createArrayList(5, 2, 4), Matchers.hasSize(3));
        Assertions.assertThat(DataHelper.createArrayList(5, 2, 4), Matchers.contains(5, 2, 4));
        Assertions.assertThat(DataHelper.createArrayList(5, 2, 4), Matchers.containsInAnyOrder(2, 4, 5));
        Assertions.assertThat(DataHelper.createArrayList(5, 2, 4), Matchers.everyItem(Matchers.greaterThan(1)));
        Assertions.assertThat(createNullFieldClass(), "_field", Matchers.nullValue());
        Assertions.assertThat(createPrivateFieldsClass(), "_object", Matchers.notNullValue());
        Assertions.assertThat(createPrivateFieldsClass(), "_object", Matchers.not(Matchers.equalTo(new StringBuilder("value"))));

        try {
            Assertions.assertThat(10, Matchers.is(Matchers.equalTo(11)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: is <11>\n     but: was <10>");
        }
        try {
            Assertions.assertThat(createPrivateFieldsClass(), "_object", Matchers.equalTo(new StringBuilder("value")));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field value: _object.\nExpected: <value>\n     but: was <value>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s]> but was:<[1s, 2s, 3s]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L]> but was:<[1L, 2L, 3L]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, T]> but was:<[T, T, F]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.String>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertThat((String) null).isNull();
        Assertions.assertThat("test").hasLength(4);
        Assertions.assertThat(null, Raw.charSequenceAssertion()).isNull();
        Assertions.assertThat("test", Raw.charSequenceAssertion()).hasLength(4);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_string", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertThat("test").hasLength(5);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertThat("Expected:<aaa>").isEqualTo("but was:<10>");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<but was:<10>> but was:<Expected:<aaa>>");
        }
        try {
            Assertions.assertThat("but was:<10>").isEqualTo("Expected:<aaa>");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Expected:<aaa>> but was:<but was:<10>>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void iterableAssertionTest() {
        Assertions.assertThat((Iterable<String>) null).isNull();
        Assertions.assertThat(DataHelper.createIterable("1", "2", "3")).hasSize(3);
        Assertions.assertThat(null, Raw.<String>iterableAssertion()).isNull();
        Assertions.assertThat(DataHelper.createIterable("1", "2", "3"), Raw.<String>iterableAssertion()).hasSize(3);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>iterableAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterable", Raw.<String>iterableAssertion()).hasSize(3);

        try {
            Assertions.assertThat(DataHelper.createIterable("1", "2", "3")).hasSize(4);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Assertions.assertThat((Iterator<String>) null).isNull();
        Assertions.assertThat(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat((Iterator<String>) DataHelper.createListIterator(0, "1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertThat(DataHelper.createIterator("1", "2", "3"), Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(DataHelper.createListIterator(0, "1", "2", "3"), Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_iterator", Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(createPrivateFieldsClass(), "_listIterator", Raw.<String>iteratorAssertion()).containsExactlyInOrder("2", "3");

        try {
            Assertions.assertThat(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void listIteratorAssertionTest() {
        Assertions.assertThat((ListIterator<String>) null).isNull();
        Assertions.assertThat(DataHelper.createListIterator(1, "1", "2", "3")).containsExactlyInOrder("2", "3");
        Assertions.assertThat(null, Raw.<String>listIteratorAssertion()).isNull();
        Assertions.assertThat(DataHelper.createListIterator(1, "1", "2", "3"), Raw.<String>listIteratorAssertion()).containsExactlyInOrder("2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>listIteratorAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_listIterator").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_listIterator", Raw.<String>listIteratorAssertion()).containsExactlyInOrder("2", "3");

        try {
            Assertions.assertThat(DataHelper.createListIterator(1, "1", "2", "3")).containsExactlyInOrder("1", "2", "3");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertThat((List<String>) null).isNull();
        Assertions.assertThat(DataHelper.createArrayList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>listAssertion()).isNull();
        Assertions.assertThat(DataHelper.createArrayList("1", "2", "3"), Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>listAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_list", Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(DataHelper.createArrayList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void setAssertionTest() {
        Assertions.assertThat((Set<String>) null).isNull();
        Assertions.assertThat(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(DataHelper.createHashSet("1", "2", "3"), Raw.<String>setAssertion()).containsExactly("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>setAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_set", Raw.<String>setAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertThat(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void sortedSetAssertionTest() {
        Assertions.assertThat((SortedSet<String>) null).isNull();
        Assertions.assertThat(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertThat(null, Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertThat(DataHelper.createTreeSet("1", "2", "3"), Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedSet").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedSet", Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertThat(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void mapAssertionTest() {
        Assertions.assertThat((Map<String, String>) null).isNull();
        Assertions.assertThat(DataHelper.createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertThat(null, Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertThat(DataHelper.createHashMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>mapAssertion()).hasSize(3);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_map", Raw.<String, String>mapAssertion()).hasSize(3);

        try {
            Assertions.assertThat(DataHelper.createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void sortedMapAssertionTest() {
        Assertions.assertThat((SortedMap<String, String>) null).isNull();
        Assertions.assertThat(DataHelper.createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertThat(null, Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertThat(DataHelper.createTreeMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>sortedMapAssertion()).hasSize(3);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedMap").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_sortedMap", Raw.<String, String>sortedMapAssertion()).hasSize(3);

        try {
            Assertions.assertThat(DataHelper.createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void dateAssertionTest() {
        Assertions.assertThat((Date) null).isNull();
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertThat(null, Raw.dateAssertion()).isNull();
        Assertions.assertThat(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47), Raw.dateAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.dateAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_date").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_date", Raw.dateAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);

        try {
            Assertions.assertThat(DataHelper.createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2019, Calendar.AUGUST, 11, 15, 23, 45, 0);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void calendarAssertionTest() {
        Assertions.assertThat((Calendar) null).isNull();
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertThat(null, Raw.calendarAssertion()).isNull();
        Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), Raw.calendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.calendarAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_calendar").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_calendar", Raw.calendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);

        try {
            Assertions.assertThat(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void timeZoneAssertionTest() {
        Assertions.assertThat((TimeZone) null).isNull();
        Assertions.assertThat(TimeZone.getTimeZone("UTC")).hasDisplayName("Coordinated Universal Time");
        Assertions.assertThat(null, Raw.timeZoneAssertion()).isNull();
        Assertions.assertThat(TimeZone.getTimeZone("UTC"), Raw.timeZoneAssertion()).hasDisplayName("Coordinated Universal Time");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.timeZoneAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_timeZone").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_timeZone", Raw.timeZoneAssertion()).hasDisplayName("Greenwich Mean Time");

        try {
            Assertions.assertThat(TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void localeAssertionTest() {
        Assertions.assertThat((Locale) null).isNull();
        Assertions.assertThat(Locale.UK).hasCountry("GB");
        Assertions.assertThat(null, Raw.localeAssertion()).isNull();
        Assertions.assertThat(Locale.UK, Raw.localeAssertion()).hasCountry("GB");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.localeAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_locale").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_locale", Raw.localeAssertion()).hasCountry("GB");

        try {
            Assertions.assertThat(Locale.UK).hasCountry("US");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<US> but was:<GB>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertThat((InputStream) null).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(1, 2);
        Assertions.assertThat(null, Raw.inputStreamAssertion()).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3}), Raw.inputStreamAssertion()).areNextBytesEqualTo(1, 2);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.inputStreamAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_inputStream", Raw.inputStreamAssertion()).areNextBytesEqualTo(1, 2);

        try {
            Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(2, 3);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertThat((Reader) null).isNull();
        Assertions.assertThat(new StringReader("123")).areNextCharsEqualTo('1', '2');
        Assertions.assertThat(null, Raw.readerAssertion()).isNull();
        Assertions.assertThat(new StringReader("123"), Raw.readerAssertion()).areNextCharsEqualTo('1', '2');
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.readerAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_reader", Raw.readerAssertion()).areNextCharsEqualTo('1', '2');

        try {
            Assertions.assertThat(new StringReader("123")).areNextCharsEqualTo('2', '3');
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void bufferedReaderAssertionTest() {
        Assertions.assertThat((BufferedReader) null).isNull();
        Assertions.assertThat(new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("1", "2");
        Assertions.assertThat(null, Raw.bufferedReaderAssertion()).isNull();
        Assertions.assertThat(new BufferedReader(new StringReader("1\n2\n3")), Raw.bufferedReaderAssertion()).areNextLinesEqualTo("1", "2");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.bufferedReaderAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_bufferedReader").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_bufferedReader", Raw.bufferedReaderAssertion()).areNextLinesEqualTo("1", "2");

        try {
            Assertions.assertThat(new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("2", "3");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
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
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void xmlGregorianCalendarAssertionTest() {
        Assertions.assertThat((XMLGregorianCalendar) null).isNull();
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertThat(null, Raw.xmlGregorianCalendarAssertion()).isNull();
        Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), Raw.xmlGregorianCalendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.xmlGregorianCalendarAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_xmlGregorianCalendar").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_xmlGregorianCalendar", Raw.xmlGregorianCalendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);

        try {
            Assertions.assertThat(DataHelper.createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void qnameAssertionTest() {
        Assertions.assertThat((QName) null).isNull();
        Assertions.assertThat(new QName("local")).hasProperties("local");
        Assertions.assertThat(null, Raw.qnameAssertion()).isNull();
        Assertions.assertThat(new QName("local"), Raw.qnameAssertion()).hasProperties("local");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.qnameAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_qname").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_qname", Raw.qnameAssertion()).hasProperties("local");

        try {
            Assertions.assertThat(new QName("local1")).hasProperties("local2");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void nodeAssertionTest() {
        Assertions.assertThat((Node) null).isNull();
        Assertions.assertThat(createNode("<node>content</node>")).hasProperties("node");
        Assertions.assertThat(null, Raw.nodeAssertion()).isNull();
        Assertions.assertThat(createNode("<node>content</node>"), Raw.nodeAssertion()).hasProperties("node");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.nodeAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_node").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_node", Raw.nodeAssertion()).hasProperties("node");

        try {
            Assertions.assertThat(createNode("<node1>content</node1>")).hasProperties("node2");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<node2> but was:<node1>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void elementAssertionTest() {
        Assertions.assertThat((Element) null).isNull();
        Assertions.assertThat(createElement("<element>content</element>")).hasProperties("element");
        Assertions.assertThat(null, Raw.elementAssertion()).isNull();
        Assertions.assertThat(createElement("<element>content</element>"), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.elementAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_element").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_element", Raw.elementAssertion()).hasProperties("element");

        try {
            Assertions.assertThat(createElement("<element1>content</element1>")).hasProperties("element2");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void documentAssertionTest() {
        Assertions.assertThat((Document) null).isNull();
        Assertions.assertThat(createDocument("<document>content</document>")).hasProperties("document");
        Assertions.assertThat(null, Raw.documentAssertion()).isNull();
        Assertions.assertThat(createDocument("<document>content</document>"), Raw.documentAssertion()).hasProperties("document");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.documentAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_document").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_document", Raw.documentAssertion()).hasProperties("document");

        try {
            Assertions.assertThat(createDocument("<document1>content</document1>")).hasProperties("document2");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<document2> but was:<document1>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void attrAssertionTest() {
        Assertions.assertThat((Attr) null).isNull();
        Assertions.assertThat(createAttr("<element attr='val'/>")).hasProperties("attr", "val");
        Assertions.assertThat(null, Raw.attrAssertion()).isNull();
        Assertions.assertThat(createAttr("<element attr='val'/>"), Raw.attrAssertion()).hasProperties("attr", "val");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.attrAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_attr").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_attr", Raw.attrAssertion()).hasProperties("attr", "val");

        try {
            Assertions.assertThat(createAttr("<element attr='val1'/>")).hasProperties("attr", "val2");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void characterDataAssertionTest() {
        Assertions.assertThat((CharacterData) null).isNull();
        Assertions.assertThat(createCharacterData("<!-- character data -->")).hasData(" character data ");
        Assertions.assertThat(null, Raw.characterDataAssertion()).isNull();
        Assertions.assertThat(createCharacterData("<!-- character data -->"), Raw.characterDataAssertion()).hasData(" character data ");
        Assertions.assertThat(createNullFieldClass(), "_field", Raw.characterDataAssertion()).isNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_characterData").isNotNull();
        Assertions.assertThat(createPrivateFieldsClass(), "_characterData", Raw.characterDataAssertion()).hasData(" character data ");

        try {
            Assertions.assertThat(createCharacterData("<!-- character data -->")).hasData("character data");
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<character data> but was:< character data >");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void assertionInvokerTest() {
        AssertionInvoker assertionInvoker = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(1).isEqualTo(1);
            }
        };
        Assertions.assertThat(assertionInvoker);
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 0), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 0)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 0), createAssertionInvoker(12, 0)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 0), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 0)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 0), createAssertionInvoker(22, 0)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 1))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 0), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 0), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 0))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 0), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 21), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 1))));
        Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 11), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 0), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 1))));

        try {
            AssertionInvoker assertionInvokerFail = new AssertionInvoker() {

                @Override
                public void invoke() {
                    Assertions.assertThat(1).isEqualTo(0);
                }
            };
            Assertions.assertThat(assertionInvokerFail);
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.or(Assertions.and(createAssertionInvoker(11, 0), createAssertionInvoker(12, 12)), Assertions.and(createAssertionInvoker(21, 0), createAssertionInvoker(22, 22)), Assertions.not(createAssertionInvoker(1, 1))));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("OR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "AND predicate failed.");
            Assertions.assertThat(ex).toSuppressed(0).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).toSuppressed(0).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<11>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "AND predicate failed.");
            Assertions.assertThat(ex).toSuppressed(1).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).toSuppressed(1).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<21>");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "NOT predicate failed.");
            Assertions.assertThat(ex).toSuppressed(2).hasSuppressed();
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void andTest() {
        Assertions.assertThat(Assertions.and());
        Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1)));
        Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2)));
        Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));

        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
        try {
            Assertions.assertThat(Assertions.and(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("AND predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void orTest() {
        Assertions.assertThat(Assertions.or());
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
        Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));

        try {
            Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("OR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("OR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.or(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("OR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void xorTest() {
        Assertions.assertThat(Assertions.xor());
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
        Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));

        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 2), createAssertionInvoker(3, 3)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 0), createAssertionInvoker(3, 3)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 1), createAssertionInvoker(2, 2), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
        try {
            Assertions.assertThat(Assertions.xor(createAssertionInvoker(1, 0), createAssertionInvoker(2, 0), createAssertionInvoker(3, 0)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<0> but was:<1>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Actual and expected values should be the same.\n\tExpected:<0> but was:<2>");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "Actual and expected values should be the same.\n\tExpected:<0> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void notTest() {
        Assertions.assertThat(Assertions.not(createAssertionInvoker(1, 0)));

        try {
            Assertions.assertThat(Assertions.not(createAssertionInvoker(1, 1)));
            Assertions.fail(Assertions.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("NOT predicate failed.");
            Assertions.assertThat(ex).hasSuppressed();
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failWithMessageTest() {
        try {
            Assertions.fail((String) null);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail("");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(" ");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage(" .");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail("fail a test");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("fail a test.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail("value''s");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.");
            Assertions.assertThat(ex).causeIsNull();
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failWithMessageAndThrowableTest() {
        try {
            Assertions.fail((String) null, new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail("", new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail(" ", new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage(" .");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail("fail a test", null);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("fail a test.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail("fail a test", new IOException());
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("fail a test.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).causeMessageIsNull();
        }
        try {
            Assertions.fail("fail a test", new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("fail a test.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail("value''s", new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failWithClassTest() {
        try {
            Assertions.fail((Class<?>) null);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: clazz.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(String.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String test fail.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(Date.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Date test fail.");
            Assertions.assertThat(ex).causeIsNull();
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failWithClassAndThrowableTest() {
        try {
            Assertions.fail((Class<?>) null, new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: clazz.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(String.class, new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("String test fail.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail(Date.class, new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Date test fail.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
        try {
            Assertions.fail(Date.class, null);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Date test fail.");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(Date.class, new IOException());
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Date test fail.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).causeMessageIsNull();
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void failWithThrowableTest() {
        try {
            Assertions.fail((Throwable) null);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            Assertions.fail(new IOException());
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).causeMessageIsNull();
        }
        try {
            Assertions.fail(new IOException("io exception"));
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: io exception.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("io exception");
        }
    }

}
