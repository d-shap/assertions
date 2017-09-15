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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import ru.d_shap.assertions.array.BooleanArrayAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.array.CharArrayAssertion;
import ru.d_shap.assertions.array.DoubleArrayAssertion;
import ru.d_shap.assertions.array.FloatArrayAssertion;
import ru.d_shap.assertions.array.IntArrayAssertion;
import ru.d_shap.assertions.array.LongArrayAssertion;
import ru.d_shap.assertions.array.ObjectArrayAssertion;
import ru.d_shap.assertions.array.ShortArrayAssertion;
import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.collection.IteratorAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.core.CharSequenceAssertion;
import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.ComparableAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;
import ru.d_shap.assertions.core.StringAssertion;
import ru.d_shap.assertions.core.ThrowableAssertion;
import ru.d_shap.assertions.io.InputStreamAssertion;
import ru.d_shap.assertions.io.ReaderAssertion;
import ru.d_shap.assertions.nio.ByteBufferAssertion;
import ru.d_shap.assertions.nio.CharBufferAssertion;
import ru.d_shap.assertions.nio.DoubleBufferAssertion;
import ru.d_shap.assertions.nio.FloatBufferAssertion;
import ru.d_shap.assertions.nio.IntBufferAssertion;
import ru.d_shap.assertions.nio.LongBufferAssertion;
import ru.d_shap.assertions.nio.ShortBufferAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.ByteAssertion;
import ru.d_shap.assertions.primitive.CharAssertion;
import ru.d_shap.assertions.primitive.DoubleAssertion;
import ru.d_shap.assertions.primitive.FloatAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.primitive.ShortAssertion;

/**
 * Tests for {@link Assertions}.
 *
 * @author Dmitry Shapovalov
 */
public final class AssertionsTest {

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
        try {
            Assertions.assertThat(null, ByteAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat((byte) 5, ByteAssertion.class).isEqualTo(5);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", ByteAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byte", ByteAssertion.class).isEqualTo(5);

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
    public void shortAssertionTest() {
        Assertions.assertThat((short) 5).isEqualTo(5);
        try {
            Assertions.assertThat(null, ShortAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat((short) 5, ShortAssertion.class).isEqualTo(5);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", ShortAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_short", ShortAssertion.class).isEqualTo(5);

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
    public void intAssertionTest() {
        Assertions.assertThat(5).isEqualTo(5);
        try {
            Assertions.assertThat(null, IntAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(5, IntAssertion.class).isEqualTo(5);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", IntAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_int", IntAssertion.class).isEqualTo(5);

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
    public void longAssertionTest() {
        Assertions.assertThat(5L).isEqualTo(5L);
        try {
            Assertions.assertThat(null, LongAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(5L, LongAssertion.class).isEqualTo(5L);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", LongAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_long", LongAssertion.class).isEqualTo(5L);

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
    public void floatAssertionTest() {
        Assertions.assertThat(5.0f).isEqualTo(5.0f, 0.001f);
        try {
            Assertions.assertThat(null, FloatAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(5.0f, FloatAssertion.class).isEqualTo(5.0f, 0.001f);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", FloatAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_float", FloatAssertion.class).isEqualTo(5.0f, 0.001f);

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
    public void doubleAssertionTest() {
        Assertions.assertThat(5.0).isEqualTo(5.0, 0.001);
        try {
            Assertions.assertThat(null, DoubleAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(5.0, DoubleAssertion.class).isEqualTo(5.0, 0.001);
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", DoubleAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_double", DoubleAssertion.class).isEqualTo(5.0, 0.001);

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
    public void booleanAssertionTest() {
        Assertions.assertThat(true).isTrue();
        try {
            Assertions.assertThat(null, BooleanAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(true, BooleanAssertion.class).isTrue();
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", BooleanAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_boolean", BooleanAssertion.class).isTrue();

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
    public void charAssertionTest() {
        Assertions.assertThat('5').isEqualTo('5');
        try {
            Assertions.assertThat(null, CharAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat('5', CharAssertion.class).isEqualTo('5');
        try {
            Assertions.assertThat(new NullFieldClass(), "_field", CharAssertion.class);
            Assertions.fail("Assertions test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertThat(new PrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_char", CharAssertion.class).isEqualTo('5');

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
    public void objectAssertionTest() {
        Object object = new StringBuilder("value");
        Assertions.assertThat((Object) null).isNull();
        Assertions.assertThat(object).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertThat(null, ObjectAssertion.class).isNull();
        Assertions.assertThat(object, ObjectAssertion.class).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertThat(new NullFieldClass(), "_field").isNull();
        Assertions.assertThat(new NullFieldClass(), "_field", ObjectAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_object", ObjectAssertion.class).isNotEqualTo(new StringBuilder("value"));

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
        Assertions.assertThat(null, ByteArrayAssertion.class).isNull();
        Assertions.assertThat(new byte[]{1, 2, 3}, ByteArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", ByteArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteArray", ByteArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(null, ShortArrayAssertion.class).isNull();
        Assertions.assertThat(new short[]{1, 2, 3}, ShortArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", ShortArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortArray", ShortArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(null, IntArrayAssertion.class).isNull();
        Assertions.assertThat(new int[]{1, 2, 3}, IntArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(new NullFieldClass(), "_field", IntArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intArray", IntArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

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
        Assertions.assertThat(null, LongArrayAssertion.class).isNull();
        Assertions.assertThat(new long[]{1L, 2L, 3L}, LongArrayAssertion.class).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertThat(new NullFieldClass(), "_field", LongArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longArray", LongArrayAssertion.class).containsExactlyInOrder(1L, 2L, 3L);

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
        Assertions.assertThat(null, FloatArrayAssertion.class).isNull();
        Assertions.assertThat(new float[]{1.0f, 2.0f, 3.0f}, FloatArrayAssertion.class).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertThat(new NullFieldClass(), "_field", FloatArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatArray", FloatArrayAssertion.class).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

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
        Assertions.assertThat(null, DoubleArrayAssertion.class).isNull();
        Assertions.assertThat(new double[]{1.0, 2.0, 3.0}, DoubleArrayAssertion.class).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertThat(new NullFieldClass(), "_field", DoubleArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleArray", DoubleArrayAssertion.class).containsExactlyInOrder(1.0, 2.0, 3.0);

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
        Assertions.assertThat(null, BooleanArrayAssertion.class).isNull();
        Assertions.assertThat(new boolean[]{true, true, false}, BooleanArrayAssertion.class).containsExactlyInOrder(true, true, false);
        Assertions.assertThat(new NullFieldClass(), "_field", BooleanArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_booleanArray", BooleanArrayAssertion.class).containsExactlyInOrder(true, true, false);

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
        Assertions.assertThat(null, CharArrayAssertion.class).isNull();
        Assertions.assertThat(new char[]{'1', '2', '3'}, CharArrayAssertion.class).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(new NullFieldClass(), "_field", CharArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charArray", CharArrayAssertion.class).containsExactlyInOrder('1', '2', '3');

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
        Assertions.assertThat((Object[]) null).isNull();
        Assertions.assertThat(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, ObjectArrayAssertion.class).isNull();
        Assertions.assertThat(new Object[]{"1", "2", "3"}, ObjectArrayAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", ObjectArrayAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_objectArray", ObjectArrayAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
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
        Assertions.assertThat(null, ClassAssertion.class).isNull();
        Assertions.assertThat(String.class, ClassAssertion.class).isSubtypeOf(Object.class);
        Assertions.assertThat(new NullFieldClass(), "_field", ClassAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_class", ClassAssertion.class).isSubtypeOf(Object.class);

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
        Assertions.assertThat(null, CharSequenceAssertion.class).isNull();
        Assertions.assertThat(new StringBuilder("test"), CharSequenceAssertion.class).hasLength(4);
        Assertions.assertThat(new NullFieldClass(), "_field", CharSequenceAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charSequence", CharSequenceAssertion.class).hasLength(4);

        try {
            Assertions.assertThat(new StringBuilder("test")).hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertThat((String) null).isNull();
        Assertions.assertThat("test").hasLength(4);
        Assertions.assertThat(null, StringAssertion.class).isNull();
        Assertions.assertThat("test", StringAssertion.class).hasLength(4);
        Assertions.assertThat(new NullFieldClass(), "_field", StringAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_string", StringAssertion.class).hasLength(4);

        try {
            Assertions.assertThat("test").hasLength(5);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5> but was:<4>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void comparableAssertionTest() {
        Comparable<?> comparable = Integer.valueOf("5");
        Assertions.assertThat((Comparable<?>) null).isNull();
        Assertions.assertThat(comparable).isEqualTo(5);
        Assertions.assertThat(null, ComparableAssertion.class).isNull();
        Assertions.assertThat(comparable, ComparableAssertion.class).isEqualTo(5);
        Assertions.assertThat(new NullFieldClass(), "_field", ComparableAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_comparable", ComparableAssertion.class).isEqualTo(5);

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
        Iterable<?> iterable = Arrays.asList("1", "2", "3");
        Assertions.assertThat((Iterable<?>) null).isNull();
        Assertions.assertThat(iterable).hasSize(3);
        Assertions.assertThat(null, IterableAssertion.class).isNull();
        Assertions.assertThat(iterable, IterableAssertion.class).hasSize(3);
        Assertions.assertThat(new NullFieldClass(), "_field", IterableAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterable", IterableAssertion.class).hasSize(3);

        try {
            Assertions.assertThat(iterable).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void throwableAssertionTest() {
        Assertions.assertThat((Throwable) null).isNull();
        Assertions.assertThat(new AssertionError("error")).isInstanceOf(Error.class);
        Assertions.assertThat(null, ThrowableAssertion.class).isNull();
        Assertions.assertThat(new AssertionError("error"), ThrowableAssertion.class).isInstanceOf(Error.class);
        Assertions.assertThat(new NullFieldClass(), "_field", ThrowableAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_throwable", ThrowableAssertion.class).isInstanceOf(Error.class);

        try {
            Assertions.assertThat(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void collectionAssertionTest() {
        Collection<?> collection = Arrays.asList("1", "2", "3");
        Assertions.assertThat((Collection<?>) null).isNull();
        Assertions.assertThat(collection).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, CollectionAssertion.class).isNull();
        Assertions.assertThat(collection, CollectionAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", CollectionAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_collection").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_collection", CollectionAssertion.class).containsExactlyInOrder("1", "2", "3");

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
        Assertions.assertThat((Iterator<?>) null).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, IteratorAssertion.class).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3").iterator(), IteratorAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", IteratorAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_iterator", IteratorAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertThat(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertThat((List<?>) null).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(null, ListAssertion.class).isNull();
        Assertions.assertThat(Arrays.asList("1", "2", "3"), ListAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", ListAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_list", ListAssertion.class).containsExactlyInOrder("1", "2", "3");

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
        Assertions.assertThat((Set<?>) null).isNull();
        Assertions.assertThat(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3");
        Assertions.assertThat(null, SetAssertion.class).isNull();
        Assertions.assertThat(new HashSet<>(Arrays.asList("1", "2", "3")), SetAssertion.class).containsExactly("1", "2", "3");
        Assertions.assertThat(new NullFieldClass(), "_field", SetAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_set", SetAssertion.class).containsExactly("1", "2", "3");

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
        Assertions.assertThat((Map<?, ?>) null).isNull();
        Assertions.assertThat(createMap()).hasSize(3);
        Assertions.assertThat(null, MapAssertion.class).isNull();
        Assertions.assertThat(createMap(), MapAssertion.class).hasSize(3);
        Assertions.assertThat(new NullFieldClass(), "_field", MapAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_map", MapAssertion.class).hasSize(3);

        try {
            Assertions.assertThat(createMap()).hasSize(4);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertThat((InputStream) null).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);
        Assertions.assertThat(null, InputStreamAssertion.class).isNull();
        Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3}), InputStreamAssertion.class).isNextBytesEqualTo(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", InputStreamAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_inputStream", InputStreamAssertion.class).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertThat(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertThat((Reader) null).isNull();
        Assertions.assertThat(new StringReader("123")).isNextCharsEqualTo('1', '2');
        Assertions.assertThat(null, ReaderAssertion.class).isNull();
        Assertions.assertThat(new StringReader("123"), ReaderAssertion.class).isNextCharsEqualTo('1', '2');
        Assertions.assertThat(new NullFieldClass(), "_field", ReaderAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_reader", ReaderAssertion.class).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertThat(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("Assertions test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link Assertions} class test.
     */
    @Test
    public void byteBufferAssertionTest() {
        Assertions.assertThat((ByteBuffer) null).isNull();
        Assertions.assertThat(createByteBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, ByteBufferAssertion.class).isNull();
        Assertions.assertThat(createByteBuffer(), ByteBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", ByteBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_byteBuffer", ByteBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createByteBuffer()).containsExactlyInOrder(2, 1);
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
        Assertions.assertThat(createShortBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, ShortBufferAssertion.class).isNull();
        Assertions.assertThat(createShortBuffer(), ShortBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", ShortBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_shortBuffer", ShortBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createShortBuffer()).containsExactlyInOrder(2, 1);
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
        Assertions.assertThat(createIntBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(null, IntBufferAssertion.class).isNull();
        Assertions.assertThat(createIntBuffer(), IntBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertThat(new NullFieldClass(), "_field", IntBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_intBuffer", IntBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertThat(createIntBuffer()).containsExactlyInOrder(2, 1);
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
        Assertions.assertThat(createLongBuffer()).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(null, LongBufferAssertion.class).isNull();
        Assertions.assertThat(createLongBuffer(), LongBufferAssertion.class).containsExactlyInOrder(1L, 2L);
        Assertions.assertThat(new NullFieldClass(), "_field", LongBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_longBuffer", LongBufferAssertion.class).containsExactlyInOrder(1L, 2L);

        try {
            Assertions.assertThat(createLongBuffer()).containsExactlyInOrder(2L, 1L);
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
        Assertions.assertThat(createFloatBuffer()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(null, FloatBufferAssertion.class).isNull();
        Assertions.assertThat(createFloatBuffer(), FloatBufferAssertion.class).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertThat(new NullFieldClass(), "_field", FloatBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_floatBuffer", FloatBufferAssertion.class).containsExactlyInOrder(1.0f, 2.0f);

        try {
            Assertions.assertThat(createFloatBuffer()).containsExactlyInOrder(2.0f, 1.0f);
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
        Assertions.assertThat(createDoubleBuffer()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(null, DoubleBufferAssertion.class).isNull();
        Assertions.assertThat(createDoubleBuffer(), DoubleBufferAssertion.class).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertThat(new NullFieldClass(), "_field", DoubleBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_doubleBuffer", DoubleBufferAssertion.class).containsExactlyInOrder(1.0, 2.0);

        try {
            Assertions.assertThat(createDoubleBuffer()).containsExactlyInOrder(2.0, 1.0);
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
        Assertions.assertThat(createCharBuffer()).containsExactlyInOrder(49, 50);
        Assertions.assertThat(null, CharBufferAssertion.class).isNull();
        Assertions.assertThat(createCharBuffer(), CharBufferAssertion.class).containsExactlyInOrder(49, 50);
        Assertions.assertThat(new NullFieldClass(), "_field", CharBufferAssertion.class).isNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertThat(new PrivateFieldsClass(), "_charBuffer", CharBufferAssertion.class).containsExactlyInOrder(49, 50);

        try {
            Assertions.assertThat(createCharBuffer()).containsExactlyInOrder(50, 49);
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
            Assertions.assertThat(ex).hasMessage("fail a test");
        }
    }

    private static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "val1");
        map.put("2", "val2");
        map.put("3", "val3");
        return map;
    }

    private static ByteBuffer createByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ShortBuffer createShortBuffer() {
        ShortBuffer shortBuffer = ByteBuffer.allocate(4).asShortBuffer();
        shortBuffer.put((short) 1);
        shortBuffer.put((short) 2);
        shortBuffer.flip();
        return shortBuffer;
    }

    private static IntBuffer createIntBuffer() {
        IntBuffer intBuffer = ByteBuffer.allocate(8).asIntBuffer();
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.flip();
        return intBuffer;
    }

    private static LongBuffer createLongBuffer() {
        LongBuffer longBuffer = ByteBuffer.allocate(16).asLongBuffer();
        longBuffer.put(1L);
        longBuffer.put(2L);
        longBuffer.flip();
        return longBuffer;
    }

    private static FloatBuffer createFloatBuffer() {
        FloatBuffer floatBuffer = ByteBuffer.allocate(8).asFloatBuffer();
        floatBuffer.put(1.0f);
        floatBuffer.put(2.0f);
        floatBuffer.flip();
        return floatBuffer;
    }

    private static DoubleBuffer createDoubleBuffer() {
        DoubleBuffer doubleBuffer = ByteBuffer.allocate(16).asDoubleBuffer();
        doubleBuffer.put(1.0);
        doubleBuffer.put(2.0);
        doubleBuffer.flip();
        return doubleBuffer;
    }

    private static CharBuffer createCharBuffer() {
        CharBuffer charBuffer = ByteBuffer.allocate(4).asCharBuffer();
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.flip();
        return charBuffer;
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

        private short _short = 5;

        private int _int = 5;

        private long _long = 5L;

        private float _float = 5.0f;

        private double _double = 5.0;

        private boolean _boolean = true;

        private char _char = '5';

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

        private Map<String, String> _map = createMap();

        private InputStream _inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});

        private Reader _reader = new StringReader("123");

        private ByteBuffer _byteBuffer = createByteBuffer();

        private ShortBuffer _shortBuffer = createShortBuffer();

        private IntBuffer _intBuffer = createIntBuffer();

        private LongBuffer _longBuffer = createLongBuffer();

        private FloatBuffer _floatBuffer = createFloatBuffer();

        private DoubleBuffer _doubleBuffer = createDoubleBuffer();

        private CharBuffer _charBuffer = createCharBuffer();

        PrivateFieldsClass() {
            super();
        }

    }

}
