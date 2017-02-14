///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for {@link MessageAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class MessageAssertionTest {

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
    public void byteAssertionTest() {
        Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(5);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(5);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5).isEqualTo(5);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5L).isEqualTo(5L);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(5.0f, 0.001f);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(5.0, 0.001);

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanAssertionTest() {
        Assertions.assertWithMessage("Test message").that(true).isTrue();

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charAssertionTest() {
        Assertions.assertWithMessage("Test message").that('5').isEqualTo('5');

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
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectAssertionTest() {
        Object object = new StringBuilder("value");
        Assertions.assertWithMessage("Test message").that(object).isSameAs(object);

        try {
            Assertions.assertWithMessage(null).that(object).isSameAs(new StringBuilder("another value"));
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<another value> but was:<value>");
        }
        try {
            Assertions.assertWithMessage("").that(object).isSameAs(new StringBuilder("another value"));
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<another value> but was:<value>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(object).isSameAs(new StringBuilder("another value"));
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<another value> but was:<value>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new byte[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new byte[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new short[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new short[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new int[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new int[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new long[]{1L, 2L, 3L}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new long[]{1L, 2L, 3L}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new float[]{1.0f, 2.0f, 3.0f}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new float[]{1.0f, 2.0f, 3.0f}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new double[]{1.0, 2.0, 3.0}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new double[]{1.0, 2.0, 3.0}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new boolean[]{true, true, false}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new boolean[]{true, true, false}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new char[]{'1', '2', '3'}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new char[]{'1', '2', '3'}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).hasLength(3);

        try {
            Assertions.assertWithMessage(null).that(new Object[]{"1", "2", "3"}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(new Object[]{"1", "2", "3"}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).hasLength(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void classAssertionTest() {
        Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(Object.class);

        try {
            Assertions.assertWithMessage(null).that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charSequenceAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertWithMessage("Test message").that("test").hasLength(4);

        try {
            Assertions.assertWithMessage(null).that("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("").that("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
        try {
            Assertions.assertWithMessage("Test message").that("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void comparableAssertionTest() {
        Comparable<?> comparable = Integer.valueOf("5");
        Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(comparable).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("").that(comparable).isEqualTo(6);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(6);
            Assertions.fail("Assertions test fail");
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
        Assertions.assertWithMessage("Test message").that(iterable).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void throwableAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(Error.class);

        try {
            Assertions.assertWithMessage(null).that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void collectionAssertionTest() {
        Collection<?> collection = Arrays.asList("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(collection).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(collection).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(collection).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(collection).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Collection<?> collection = Arrays.asList("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(collection.iterator()).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(collection.iterator()).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(collection.iterator()).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(collection.iterator()).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void listAssertionTest() {
        List<?> list = Arrays.asList("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(list).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(list).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(list).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(list).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void setAssertionTest() {
        Set<?> set = new HashSet<>(Arrays.asList("1", "2", "3"));
        Assertions.assertWithMessage("Test message").that(set).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(set).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(set).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(set).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void mapAssertionTest() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "val1");
        map.put("2", "val2");
        map.put("3", "val3");
        Assertions.assertWithMessage("Test message").that(map).toKeys().hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(map).toKeys().hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("").that(map).toKeys().hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(map).toKeys().hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertWithMessage(null).that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertWithMessage(null).that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new MessageAssertion(null).asString(null)).isNull();
        Assertions.assertThat(new MessageAssertion(null).asString(new Object())).isNull();
        Assertions.assertThat(new MessageAssertion(null).asString("value")).isNull();
    }

}
