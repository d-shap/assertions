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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
     * {@link MessageAssertion} class test.
     */
    @Test
    public void bytePrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byte", Raw.byteAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("").that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Byte) null).isNull();
        Assertions.assertWithMessage("Test message").that(Byte.valueOf((byte) 5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.byteAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that((byte) 5, Raw.byteAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.byteAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteObj", Raw.byteAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("").that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Byte.valueOf((byte) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6b> but was:<5b>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_short", Raw.shortAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("").that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Short) null).isNull();
        Assertions.assertWithMessage("Test message").that(Short.valueOf((short) 5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.shortAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that((short) 5, Raw.shortAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.shortAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortObj", Raw.shortAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("").that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Short.valueOf((short) 5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6s> but was:<5s>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_int", Raw.intAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Integer) null).isNull();
        Assertions.assertWithMessage("Test message").that(Integer.valueOf(5)).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.intAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5, Raw.intAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.intAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intObj", Raw.intAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Integer.valueOf(5)).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5L).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_long", Raw.longAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("").that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Long) null).isNull();
        Assertions.assertWithMessage("Test message").that(Long.valueOf(5L)).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(null, Raw.longAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5L, Raw.longAssertion()).isEqualTo(5L);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.longAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longObj", Raw.longAssertion()).isEqualTo(5L);

        try {
            Assertions.assertWithMessage(null).that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("").that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Long.valueOf(5L)).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6L> but was:<5L>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_float", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertWithMessage(null).that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Float) null).isNull();
        Assertions.assertWithMessage("Test message").that(Float.valueOf(5.0f)).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(null, Raw.floatAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that((float) 5, Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.floatAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatObj", Raw.floatAssertion()).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertWithMessage(null).that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("").that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Float.valueOf(5.0f)).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6.0f±0.001f> but was:<5.0f>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doublePrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_double", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertWithMessage(null).that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Double) null).isNull();
        Assertions.assertWithMessage("Test message").that(Double.valueOf(5.0)).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(null, Raw.doubleAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(5.0, Raw.doubleAssertion()).isEqualTo(5.0, 0.001);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.doubleAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleObj", Raw.doubleAssertion()).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertWithMessage(null).that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("").that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Double.valueOf(5.0)).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6.0±0.001> but was:<5.0>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that(true).isTrue();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_boolean", Raw.booleanAssertion()).isTrue();

        try {
            Assertions.assertWithMessage(null).that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
        }
        try {
            Assertions.assertWithMessage("").that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should be false.");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should be false.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Boolean) null).isNull();
        Assertions.assertWithMessage("Test message").that(Boolean.TRUE).isTrue();
        Assertions.assertWithMessage("Test message").that(null, Raw.booleanAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(true, Raw.booleanAssertion()).isTrue();
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.booleanAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_booleanObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_booleanObj", Raw.booleanAssertion()).isTrue();

        try {
            Assertions.assertWithMessage(null).that(Boolean.TRUE).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
        }
        try {
            Assertions.assertWithMessage("").that(Boolean.TRUE).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Boolean.TRUE).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should be false.");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Boolean.TRUE).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should be false.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charPrimitiveAssertionTest() {
        Assertions.assertWithMessage("Test message").that('5').isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_char", Raw.charAssertion()).isEqualTo('5');

        try {
            Assertions.assertWithMessage(null).that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("").that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("Test message").that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charObjectAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Character) null).isNull();
        Assertions.assertWithMessage("Test message").that(Character.valueOf('5')).isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(null, Raw.charAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that('5', Raw.charAssertion()).isEqualTo('5');
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.charAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charObj").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charObj", Raw.charAssertion()).isEqualTo('5');

        try {
            Assertions.assertWithMessage(null).that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("").that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Character.valueOf('5')).isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6(54)> but was:<5(53)>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field").isNull();
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.objectAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_object", Raw.objectAssertion()).isNotEqualTo(new StringBuilder("value"));

        try {
            Assertions.assertWithMessage(null).that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value>");
        }
        try {
            Assertions.assertWithMessage("").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be different.\n\tActual:<value>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be different.\n\tActual:<value>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectMatcherAssertionTest() {
        Assertions.assertWithMessage("Test message").that(10, Matchers.is(Matchers.equalTo(10)));
        Assertions.assertWithMessage("Test message").that(1L, Matchers.instanceOf(Long.class));
        Assertions.assertWithMessage("Test message").that(1L, Matchers.isA(Long.class));
        Assertions.assertWithMessage("Test message").that("", Matchers.emptyString());
        Assertions.assertWithMessage("Test message").that("", Matchers.emptyOrNullString());
        Assertions.assertWithMessage("Test message").that(new Integer[]{7, 5, 12, 16}, Matchers.arrayWithSize(4));
        Assertions.assertWithMessage("Test message").that(new Integer[]{7, 5, 12, 16}, Matchers.arrayContaining(7, 5, 12, 16));
        Assertions.assertWithMessage("Test message").that(Arrays.asList(5, 2, 4), Matchers.hasSize(3));
        Assertions.assertWithMessage("Test message").that(Arrays.asList(5, 2, 4), Matchers.contains(5, 2, 4));
        Assertions.assertWithMessage("Test message").that(Arrays.asList(5, 2, 4), Matchers.containsInAnyOrder(2, 4, 5));
        Assertions.assertWithMessage("Test message").that(Arrays.asList(5, 2, 4), Matchers.everyItem(Matchers.greaterThan(1)));
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Matchers.nullValue());
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_object", Matchers.notNullValue());
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_object", Matchers.not(Matchers.equalTo(new StringBuilder("value"))));

        try {
            Assertions.assertWithMessage(null).that(10, Matchers.is(Matchers.equalTo(11)));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: is <11>\n     but: was <10>");
        }
        try {
            Assertions.assertWithMessage("").that(10, Matchers.is(Matchers.equalTo(11)));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: is <11>\n     but: was <10>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(10, Matchers.is(Matchers.equalTo(11)));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\nExpected: is <11>\n     but: was <10>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(10, Matchers.is(Matchers.equalTo(11)));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\nExpected: is <11>\n     but: was <10>");
        }
        try {
            Assertions.assertWithMessage(null).that(createPrivateFieldsClass(), "_object", Matchers.equalTo(new StringBuilder("value")));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _object.\nExpected: <value>\n     but: was <value>");
        }
        try {
            Assertions.assertWithMessage("").that(createPrivateFieldsClass(), "_object", Matchers.equalTo(new StringBuilder("value")));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _object.\nExpected: <value>\n     but: was <value>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_object", Matchers.equalTo(new StringBuilder("value")));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's field: _object.\nExpected: <value>\n     but: was <value>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createPrivateFieldsClass(), "_object", Matchers.equalTo(new StringBuilder("value")));
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's field: _object.\nExpected: <value>\n     but: was <value>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.byteArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteArray", Raw.byteArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            Assertions.assertWithMessage("").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.shortArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortArray", Raw.shortArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            Assertions.assertWithMessage("").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s]> but was:<[1s, 2s, 3s]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.intArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intArray", Raw.intArrayAssertion()).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.longArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longArray", Raw.longArrayAssertion()).containsExactlyInOrder(1L, 2L, 3L);

        try {
            Assertions.assertWithMessage(null).that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            Assertions.assertWithMessage("").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L]> but was:<[1L, 2L, 3L]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.floatArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatArray", Raw.floatArrayAssertion()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

        try {
            Assertions.assertWithMessage(null).that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            Assertions.assertWithMessage("").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.doubleArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleArray", Raw.doubleArrayAssertion()).containsExactlyInOrder(1.0, 2.0, 3.0);

        try {
            Assertions.assertWithMessage(null).that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.booleanArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_booleanArray", Raw.booleanArrayAssertion()).containsExactlyInOrder(true, true, false);

        try {
            Assertions.assertWithMessage(null).that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, T]> but was:<[T, T, F]>");
        }
        try {
            Assertions.assertWithMessage("").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, T]> but was:<[T, T, F]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, T]> but was:<[T, T, F]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, T]> but was:<[T, T, F]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.charArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charArray", Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3');

        try {
            Assertions.assertWithMessage(null).that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            Assertions.assertWithMessage("").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((String[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>objectArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new String[]{"1", "2", "3"}, Raw.<String>objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>objectArrayAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_objectArray", Raw.<String>objectArrayAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new String[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.classAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_class", Raw.classAssertion()).isSubtypeOf(Object.class);

        try {
            Assertions.assertWithMessage(null).that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.String>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charSequence", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertWithMessage("Test message").that((String) null).isNull();
        Assertions.assertWithMessage("Test message").that("test").hasLength(4);
        Assertions.assertWithMessage("Test message").that(null, Raw.charSequenceAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that("test", Raw.charSequenceAssertion()).hasLength(4);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.charSequenceAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_string", Raw.charSequenceAssertion()).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage(null).that("Expected:<aaa>").isEqualTo("but was:<10>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<but was:<10>> but was:<Expected:<aaa>>");
        }
        try {
            Assertions.assertWithMessage("").that("Expected:<aaa>").isEqualTo("but was:<10>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<but was:<10>> but was:<Expected:<aaa>>");
        }
        try {
            Assertions.assertWithMessage("Test message").that("Expected:<aaa>").isEqualTo("but was:<10>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<but was:<10>> but was:<Expected:<aaa>>");
        }
        try {
            Assertions.assertWithMessage(null).that("but was:<10>").isEqualTo("Expected:<aaa>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Expected:<aaa>> but was:<but was:<10>>");
        }
        try {
            Assertions.assertWithMessage("").that("but was:<10>").isEqualTo("Expected:<aaa>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Expected:<aaa>> but was:<but was:<10>>");
        }
        try {
            Assertions.assertWithMessage("Test message").that("but was:<10>").isEqualTo("Expected:<aaa>");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<Expected:<aaa>> but was:<but was:<10>>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void comparableAssertionTest() {
        Comparable<Integer> comparable = Integer.valueOf("5");
        Assertions.assertWithMessage("Test message").that((Comparable<Integer>) null).isNull();
        Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(null, Raw.<Integer>comparableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(comparable, Raw.<Integer>comparableAssertion()).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<Integer>comparableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_comparable", Raw.<Integer>comparableAssertion()).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iterableAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Iterable<String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createIterable("1", "2", "3")).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>iterableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createIterable("1", "2", "3"), Raw.<String>iterableAssertion()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>iterableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_iterable", Raw.<String>iterableAssertion()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(DataHelper.createIterable("1", "2", "3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(DataHelper.createIterable("1", "2", "3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(DataHelper.createIterable("1", "2", "3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(DataHelper.createIterable("1", "2", "3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.throwableAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_throwable", Raw.throwableAssertion()).isInstanceOf(Error.class);

        try {
            Assertions.assertWithMessage(null).that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Iterator<String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createIterator("1", "2", "3"), Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>iteratorAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_iterator", Raw.<String>iteratorAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(DataHelper.createIterator("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertWithMessage("Test message").that((List<String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>listAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3"), Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>listAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_list", Raw.<String>listAssertion()).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void setAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Set<String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>setAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createHashSet("1", "2", "3"), Raw.<String>setAssertion()).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>setAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_set", Raw.<String>setAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(DataHelper.createHashSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void sortedSetAssertionTest() {
        Assertions.assertWithMessage("Test message").that((SortedSet<String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(DataHelper.createTreeSet("1", "2", "3"), Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String>sortedSetAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_sortedSet").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_sortedSet", Raw.<String>sortedSetAssertion()).containsExactly("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("").that(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(DataHelper.createTreeSet("1", "2", "3")).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void mapAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Map<String, String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>mapAssertion()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String, String>mapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_map", Raw.<String, String>mapAssertion()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createHashMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void sortedMapAssertionTest() {
        Assertions.assertWithMessage("Test message").that((SortedMap<String, String>) null).isNull();
        Assertions.assertWithMessage("Test message").that(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createTreeMap("1", "val1", "2", "val2", "3", "val3"), Raw.<String, String>sortedMapAssertion()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.<String, String>sortedMapAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_sortedMap").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_sortedMap", Raw.<String, String>sortedMapAssertion()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createTreeMap("1", "val1", "2", "val2", "3", "val3")).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void dateAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Date) null).isNull();
        Assertions.assertWithMessage("Test message").that(createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(null, Raw.dateAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createDate(2020, Calendar.JULY, 11, 15, 23, 47), Raw.dateAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.dateAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_date").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_date", Raw.dateAssertion()).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);

        try {
            Assertions.assertWithMessage(null).that(createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2019, Calendar.AUGUST, 11, 15, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("").that(createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2019, Calendar.AUGUST, 11, 15, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2019, Calendar.AUGUST, 11, 15, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2019, Calendar.AUGUST, 11, 15, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void calendarAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Calendar) null).isNull();
        Assertions.assertWithMessage("Test message").that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(null, Raw.calendarAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), Raw.calendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.calendarAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_calendar").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_calendar", Raw.calendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);

        try {
            Assertions.assertWithMessage(null).that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("").that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void timeZoneAssertionTest() {
        Assertions.assertWithMessage("Test message").that((TimeZone) null).isNull();
        Assertions.assertWithMessage("Test message").that(TimeZone.getTimeZone("UTC")).hasDisplayName("Coordinated Universal Time");
        Assertions.assertWithMessage("Test message").that(null, Raw.timeZoneAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(TimeZone.getTimeZone("UTC"), Raw.timeZoneAssertion()).hasDisplayName("Coordinated Universal Time");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.timeZoneAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_timeZone").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_timeZone", Raw.timeZoneAssertion()).hasDisplayName("Greenwich Mean Time");

        try {
            Assertions.assertWithMessage(null).that(TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
        try {
            Assertions.assertWithMessage("").that(TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.inputStreamAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_inputStream", Raw.inputStreamAssertion()).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertWithMessage(null).that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.readerAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_reader", Raw.readerAssertion()).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertWithMessage(null).that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void bufferedReaderAssertionTest() {
        Assertions.assertWithMessage("Test message").that((BufferedReader) null).isNull();
        Assertions.assertWithMessage("Test message").that(new BufferedReader(new StringReader("1\n2\n3"))).isNextLinesEqualTo("1", "2");
        Assertions.assertWithMessage("Test message").that(null, Raw.bufferedReaderAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new BufferedReader(new StringReader("1\n2\n3")), Raw.bufferedReaderAssertion()).isNextLinesEqualTo("1", "2");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.bufferedReaderAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_bufferedReader").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_bufferedReader", Raw.bufferedReaderAssertion()).isNextLinesEqualTo("1", "2");

        try {
            Assertions.assertWithMessage(null).that(new BufferedReader(new StringReader("1\n2\n3"))).isNextLinesEqualTo("2", "3");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(new BufferedReader(new StringReader("1\n2\n3"))).isNextLinesEqualTo("2", "3");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new BufferedReader(new StringReader("1\n2\n3"))).isNextLinesEqualTo("2", "3");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new BufferedReader(new StringReader("1\n2\n3"))).isNextLinesEqualTo("2", "3");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.byteBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_byteBuffer", Raw.byteBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.shortBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_shortBuffer", Raw.shortBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            Assertions.assertWithMessage("").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.intBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_intBuffer", Raw.intBufferAssertion()).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.longBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_longBuffer", Raw.longBufferAssertion()).containsExactlyInOrder(1L, 2L);

        try {
            Assertions.assertWithMessage(null).that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            Assertions.assertWithMessage("").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.floatBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_floatBuffer", Raw.floatBufferAssertion()).containsExactlyInOrder(1.0f, 2.0f);

        try {
            Assertions.assertWithMessage(null).that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            Assertions.assertWithMessage("").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((DoubleBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(null, Raw.doubleBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0f, 2.0f}), Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.doubleBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_doubleBuffer", Raw.doubleBufferAssertion()).containsExactlyInOrder(1.0, 2.0);

        try {
            Assertions.assertWithMessage(null).that(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("").that(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createDoubleBuffer(new double[]{1.0f, 2.0f})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
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
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.charBufferAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_charBuffer", Raw.charBufferAssertion()).containsExactlyInOrder(49, 50);

        try {
            Assertions.assertWithMessage(null).that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void xmlGregorianCalendarAssertionTest() {
        Assertions.assertWithMessage("Test message").that((XMLGregorianCalendar) null).isNull();
        Assertions.assertWithMessage("Test message").that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(null, Raw.xmlGregorianCalendarAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), Raw.xmlGregorianCalendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.xmlGregorianCalendarAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_xmlGregorianCalendar").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_xmlGregorianCalendar", Raw.xmlGregorianCalendarAssertion()).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);

        try {
            Assertions.assertWithMessage(null).that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("").that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createXmlCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2019, Calendar.AUGUST, 11, 13, 23, 45, 0);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void qnameAssertionTest() {
        Assertions.assertWithMessage("Test message").that((QName) null).isNull();
        Assertions.assertWithMessage("Test message").that(new QName("local")).hasProperties("local");
        Assertions.assertWithMessage("Test message").that(null, Raw.qnameAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(new QName("local"), Raw.qnameAssertion()).hasProperties("local");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.qnameAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_qname").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_qname", Raw.qnameAssertion()).hasProperties("local");

        try {
            Assertions.assertWithMessage(null).that(new QName("local1")).hasProperties("local2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            Assertions.assertWithMessage("").that(new QName("local1")).hasProperties("local2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new QName("local1")).hasProperties("local2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(new QName("local1")).hasProperties("local2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's local part.\n\tActual and expected values should be the same.\n\tExpected:<local2> but was:<local1>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void nodeAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Node) null).isNull();
        Assertions.assertWithMessage("Test message").that(createNode("<node>content</node>")).hasProperties("node");
        Assertions.assertWithMessage("Test message").that(null, Raw.nodeAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createNode("<node>content</node>"), Raw.nodeAssertion()).hasProperties("node");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.nodeAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_node").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_node", Raw.nodeAssertion()).hasProperties("node");

        try {
            Assertions.assertWithMessage(null).that(createNode("<node1>content</node1>")).hasProperties("node2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<node2> but was:<node1>");
        }
        try {
            Assertions.assertWithMessage("").that(createNode("<node1>content</node1>")).hasProperties("node2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<node2> but was:<node1>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createNode("<node1>content</node1>")).hasProperties("node2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<node2> but was:<node1>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createNode("<node1>content</node1>")).hasProperties("node2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<node2> but was:<node1>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void elementAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Element) null).isNull();
        Assertions.assertWithMessage("Test message").that(createElement("<element>content</element>")).hasProperties("element");
        Assertions.assertWithMessage("Test message").that(null, Raw.elementAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createElement("<element>content</element>"), Raw.elementAssertion()).hasProperties("element");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.elementAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_element").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_element", Raw.elementAssertion()).hasProperties("element");

        try {
            Assertions.assertWithMessage(null).that(createElement("<element1>content</element1>")).hasProperties("element2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            Assertions.assertWithMessage("").that(createElement("<element1>content</element1>")).hasProperties("element2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createElement("<element1>content</element1>")).hasProperties("element2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createElement("<element1>content</element1>")).hasProperties("element2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<element2> but was:<element1>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void documentAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Document) null).isNull();
        Assertions.assertWithMessage("Test message").that(createDocument("<document>content</document>")).hasProperties("document");
        Assertions.assertWithMessage("Test message").that(null, Raw.documentAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createDocument("<document>content</document>"), Raw.documentAssertion()).hasProperties("document");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.documentAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_document").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_document", Raw.documentAssertion()).hasProperties("document");

        try {
            Assertions.assertWithMessage(null).that(createDocument("<document1>content</document1>")).hasProperties("document2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<document2> but was:<document1>");
        }
        try {
            Assertions.assertWithMessage("").that(createDocument("<document1>content</document1>")).hasProperties("document2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<document2> but was:<document1>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createDocument("<document1>content</document1>")).hasProperties("document2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<document2> but was:<document1>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createDocument("<document1>content</document1>")).hasProperties("document2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's local name.\n\tActual and expected values should be the same.\n\tExpected:<document2> but was:<document1>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void attrAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Attr) null).isNull();
        Assertions.assertWithMessage("Test message").that(createAttr("<element attr='val'/>")).hasProperties("attr", "val");
        Assertions.assertWithMessage("Test message").that(null, Raw.attrAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createAttr("<element attr='val'/>"), Raw.attrAssertion()).hasProperties("attr", "val");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.attrAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_attr").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_attr", Raw.attrAssertion()).hasProperties("attr", "val");

        try {
            Assertions.assertWithMessage(null).that(createAttr("<element attr='val1'/>")).hasProperties("attr", "val2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            Assertions.assertWithMessage("").that(createAttr("<element attr='val1'/>")).hasProperties("attr", "val2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createAttr("<element attr='val1'/>")).hasProperties("attr", "val2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createAttr("<element attr='val1'/>")).hasProperties("attr", "val2");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's value.\n\tActual and expected values should be the same.\n\tExpected:<val2> but was:<val1>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void characterDataAssertionTest() {
        Assertions.assertWithMessage("Test message").that((CharacterData) null).isNull();
        Assertions.assertWithMessage("Test message").that(createCharacterData("<!-- character data -->")).hasData(" character data ");
        Assertions.assertWithMessage("Test message").that(null, Raw.characterDataAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createCharacterData("<!-- character data -->"), Raw.characterDataAssertion()).hasData(" character data ");
        Assertions.assertWithMessage("Test message").that(createNullFieldClass(), "_field", Raw.characterDataAssertion()).isNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_characterData").isNotNull();
        Assertions.assertWithMessage("Test message").that(createPrivateFieldsClass(), "_characterData", Raw.characterDataAssertion()).hasData(" character data ");

        try {
            Assertions.assertWithMessage(null).that(createCharacterData("<!-- character data -->")).hasData("character data");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<character data> but was:< character data >");
        }
        try {
            Assertions.assertWithMessage("").that(createCharacterData("<!-- character data -->")).hasData("character data");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<character data> but was:< character data >");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createCharacterData("<!-- character data -->")).hasData("character data");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<character data> but was:< character data >");
        }
        try {
            Assertions.assertWithMessage("value''s.").that(createCharacterData("<!-- character data -->")).hasData("character data");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value''s.\n\tCheck actual value's data.\n\tActual and expected values should be the same.\n\tExpected:<character data> but was:< character data >");
        }
    }

}
