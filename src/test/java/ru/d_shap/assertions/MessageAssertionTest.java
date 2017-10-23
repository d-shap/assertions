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
            Assertions.assertWithMessage("Test message").that(null, ByteAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that((byte) 5, ByteAssertion.class).isEqualTo(5);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ByteAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byte").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byte", ByteAssertion.class).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("").that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that((byte) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(5);
        try {
            Assertions.assertWithMessage("Test message").that(null, ShortAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that((short) 5, ShortAssertion.class).isEqualTo(5);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ShortAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_short").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_short", ShortAssertion.class).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("").that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that((short) 5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5).isEqualTo(5);
        try {
            Assertions.assertWithMessage("Test message").that(null, IntAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(5, IntAssertion.class).isEqualTo(5);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", IntAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_int").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_int", IntAssertion.class).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("").that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5L).isEqualTo(5L);
        try {
            Assertions.assertWithMessage("Test message").that(null, LongAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(5L, LongAssertion.class).isEqualTo(5L);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", LongAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_long").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_long", LongAssertion.class).isEqualTo(5L);

        try {
            Assertions.assertWithMessage(null).that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("").that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5L).isEqualTo(6L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(5.0f, 0.001f);
        try {
            Assertions.assertWithMessage("Test message").that(null, FloatAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(5.0f, FloatAssertion.class).isEqualTo(5.0f, 0.001f);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", FloatAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_float").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_float", FloatAssertion.class).isEqualTo(5.0f, 0.001f);

        try {
            Assertions.assertWithMessage(null).that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
        try {
            Assertions.assertWithMessage("").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0f).isEqualTo(6.0f, 0.001f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleAssertionTest() {
        Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(5.0, 0.001);
        try {
            Assertions.assertWithMessage("Test message").that(null, DoubleAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(5.0, DoubleAssertion.class).isEqualTo(5.0, 0.001);
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", DoubleAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_double").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_double", DoubleAssertion.class).isEqualTo(5.0, 0.001);

        try {
            Assertions.assertWithMessage(null).that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
        try {
            Assertions.assertWithMessage("").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(5.0).isEqualTo(6.0, 0.001);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6.0> but was:<5.0>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanAssertionTest() {
        Assertions.assertWithMessage("Test message").that(true).isTrue();
        try {
            Assertions.assertWithMessage("Test message").that(null, BooleanAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(true, BooleanAssertion.class).isTrue();
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", BooleanAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_boolean").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_boolean", BooleanAssertion.class).isTrue();

        try {
            Assertions.assertWithMessage(null).that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("").that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(true).isFalse();
            Assertions.fail("MessageAssertion test fail");
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
            Assertions.assertWithMessage("Test message").that(null, CharAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that('5', CharAssertion.class).isEqualTo('5');
        try {
            Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", CharAssertion.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Object, java.lang.String)");
        }
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_char").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_char", CharAssertion.class).isEqualTo('5');

        try {
            Assertions.assertWithMessage(null).that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>.");
        }
        try {
            Assertions.assertWithMessage("").that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6(54)> but was:<5(53)>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that('5').isEqualTo('6');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6(54)> but was:<5(53)>.");
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
        Assertions.assertWithMessage("Test message").that(null, ObjectAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(object, ObjectAssertion.class).isNotEqualTo(new StringBuilder("value"));
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field").isNull();
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ObjectAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_object").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_object", ObjectAssertion.class).isNotEqualTo(new StringBuilder("value"));

        try {
            Assertions.assertWithMessage(null).that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            Assertions.assertWithMessage("").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(object).isNotEqualTo(object);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be different. Actual:<value>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((byte[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, ByteArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}, ByteArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ByteArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteArray", ByteArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new byte[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((short[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, ShortArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}, ShortArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ShortArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortArray", ShortArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new short[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((int[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(null, IntArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}, IntArrayAssertion.class).containsExactlyInOrder(1, 2, 3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", IntArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intArray", IntArrayAssertion.class).containsExactlyInOrder(1, 2, 3);

        try {
            Assertions.assertWithMessage(null).that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new int[]{1, 2, 3}).containsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((long[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertWithMessage("Test message").that(null, LongArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}, LongArrayAssertion.class).containsExactlyInOrder(1L, 2L, 3L);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", LongArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longArray", LongArrayAssertion.class).containsExactlyInOrder(1L, 2L, 3L);

        try {
            Assertions.assertWithMessage(null).that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new long[]{1L, 2L, 3L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((float[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertWithMessage("Test message").that(null, FloatArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}, FloatArrayAssertion.class).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", FloatArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatArray", FloatArrayAssertion.class).containsExactlyInOrder(1.0f, 2.0f, 3.0f);

        try {
            Assertions.assertWithMessage(null).that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new float[]{1.0f, 2.0f, 3.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((double[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertWithMessage("Test message").that(null, DoubleArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}, DoubleArrayAssertion.class).containsExactlyInOrder(1.0, 2.0, 3.0);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", DoubleArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleArray", DoubleArrayAssertion.class).containsExactlyInOrder(1.0, 2.0, 3.0);

        try {
            Assertions.assertWithMessage(null).that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new double[]{1.0, 2.0, 3.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void booleanArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((boolean[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false);
        Assertions.assertWithMessage("Test message").that(null, BooleanArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}, BooleanArrayAssertion.class).containsExactlyInOrder(true, true, false);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", BooleanArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_booleanArray", BooleanArrayAssertion.class).containsExactlyInOrder(true, true, false);

        try {
            Assertions.assertWithMessage(null).that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new boolean[]{true, true, false}).containsExactlyInOrder(true, true, false, true);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, true]> but was:<[true, true, false]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((char[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3');
        Assertions.assertWithMessage("Test message").that(null, CharArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}, CharArrayAssertion.class).containsExactlyInOrder('1', '2', '3');
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", CharArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charArray", CharArrayAssertion.class).containsExactlyInOrder('1', '2', '3');

        try {
            Assertions.assertWithMessage(null).that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new char[]{'1', '2', '3'}).containsExactlyInOrder('1', '2', '3', '4');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Object[]) null).isNull();
        Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, ObjectArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}, ObjectArrayAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ObjectArrayAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_objectArray").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_objectArray", ObjectArrayAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new Object[]{"1", "2", "3"}).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void classAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Class<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(Object.class);
        Assertions.assertWithMessage("Test message").that(null, ClassAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(String.class, ClassAssertion.class).isSubtypeOf(Object.class);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ClassAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_class").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_class", ClassAssertion.class).isSubtypeOf(Object.class);

        try {
            Assertions.assertWithMessage(null).that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>.");
        }
        try {
            Assertions.assertWithMessage("").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(String.class).isSubtypeOf(StringBuilder.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.String>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charSequenceAssertionTest() {
        Assertions.assertWithMessage("Test message").that((CharSequence) null).isNull();
        Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(4);
        Assertions.assertWithMessage("Test message").that(null, CharSequenceAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new StringBuilder("test"), CharSequenceAssertion.class).hasLength(4);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", CharSequenceAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charSequence").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charSequence", CharSequenceAssertion.class).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>.");
        }
        try {
            Assertions.assertWithMessage("").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringBuilder("test")).hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value length. Values should be the same. Expected:<5> but was:<4>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void stringAssertionTest() {
        Assertions.assertWithMessage("Test message").that((String) null).isNull();
        Assertions.assertWithMessage("Test message").that("test").hasLength(4);
        Assertions.assertWithMessage("Test message").that(null, StringAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that("test", StringAssertion.class).hasLength(4);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", StringAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_string").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_string", StringAssertion.class).hasLength(4);

        try {
            Assertions.assertWithMessage(null).that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>.");
        }
        try {
            Assertions.assertWithMessage("").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<5> but was:<4>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that("test").hasLength(5);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value length. Values should be the same. Expected:<5> but was:<4>.");
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
        Assertions.assertWithMessage("Test message").that(null, ComparableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(comparable, ComparableAssertion.class).isEqualTo(5);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ComparableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_comparable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_comparable", ComparableAssertion.class).isEqualTo(5);

        try {
            Assertions.assertWithMessage(null).that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(comparable).isEqualTo(6);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Values should be the same. Expected:<6> but was:<5>.");
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
        Assertions.assertWithMessage("Test message").that(null, IterableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(iterable, IterableAssertion.class).hasSize(3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", IterableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterable", IterableAssertion.class).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            Assertions.assertWithMessage("").that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(iterable).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void throwableAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Throwable) null).isNull();
        Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(Error.class);
        Assertions.assertWithMessage("Test message").that(null, ThrowableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new AssertionError("error"), ThrowableAssertion.class).isInstanceOf(Error.class);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ThrowableAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_throwable").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_throwable", ThrowableAssertion.class).isInstanceOf(Error.class);

        try {
            Assertions.assertWithMessage(null).that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>.");
        }
        try {
            Assertions.assertWithMessage("").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new AssertionError("error")).isInstanceOf(RuntimeException.class);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.AssertionError>.");
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
        Assertions.assertWithMessage("Test message").that(null, CollectionAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(collection, CollectionAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", CollectionAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_collection").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_collection", CollectionAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(collection).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Iterator<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, IteratorAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator(), IteratorAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", IteratorAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterator").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_iterator", IteratorAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3").iterator()).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void listAssertionTest() {
        Assertions.assertWithMessage("Test message").that((List<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, ListAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3"), ListAssertion.class).containsExactlyInOrder("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ListAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_list").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_list", ListAssertion.class).containsExactlyInOrder("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(Arrays.asList("1", "2", "3")).containsExactlyInOrder("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void setAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Set<?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(null, SetAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3")), SetAssertion.class).containsExactly("1", "2", "3");
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", SetAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_set").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_set", SetAssertion.class).containsExactly("1", "2", "3");

        try {
            Assertions.assertWithMessage(null).that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new HashSet<>(Arrays.asList("1", "2", "3"))).containsExactly("1", "2", "3", "4");
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void mapAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Map<?, ?>) null).isNull();
        Assertions.assertWithMessage("Test message").that(createMap()).hasSize(3);
        Assertions.assertWithMessage("Test message").that(null, MapAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createMap(), MapAssertion.class).hasSize(3);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", MapAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_map").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_map", MapAssertion.class).hasSize(3);

        try {
            Assertions.assertWithMessage(null).that(createMap()).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            Assertions.assertWithMessage("").that(createMap()).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createMap()).hasSize(4);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        Assertions.assertWithMessage("Test message").that((InputStream) null).isNull();
        Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);
        Assertions.assertWithMessage("Test message").that(null, InputStreamAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3}), InputStreamAssertion.class).isNextBytesEqualTo(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", InputStreamAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_inputStream").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_inputStream", InputStreamAssertion.class).isNextBytesEqualTo(1, 2);

        try {
            Assertions.assertWithMessage(null).that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(2, 3);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void readerAssertionTest() {
        Assertions.assertWithMessage("Test message").that((Reader) null).isNull();
        Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('1', '2');
        Assertions.assertWithMessage("Test message").that(null, ReaderAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new StringReader("123"), ReaderAssertion.class).isNextCharsEqualTo('1', '2');
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ReaderAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_reader").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_reader", ReaderAssertion.class).isNextCharsEqualTo('1', '2');

        try {
            Assertions.assertWithMessage(null).that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(new StringReader("123")).isNextCharsEqualTo('2', '3');
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void byteBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((ByteBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createByteBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, ByteBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createByteBuffer(), ByteBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ByteBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_byteBuffer", ByteBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createByteBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createByteBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createByteBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void shortBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((ShortBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createShortBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, ShortBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createShortBuffer(), ShortBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", ShortBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_shortBuffer", ShortBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createShortBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createShortBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createShortBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void intBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((IntBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createIntBuffer()).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(null, IntBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createIntBuffer(), IntBufferAssertion.class).containsExactlyInOrder(1, 2);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", IntBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_intBuffer", IntBufferAssertion.class).containsExactlyInOrder(1, 2);

        try {
            Assertions.assertWithMessage(null).that(createIntBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createIntBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createIntBuffer()).containsExactlyInOrder(2, 1);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void longBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((LongBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createLongBuffer()).containsExactlyInOrder(1L, 2L);
        Assertions.assertWithMessage("Test message").that(null, LongBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createLongBuffer(), LongBufferAssertion.class).containsExactlyInOrder(1L, 2L);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", LongBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_longBuffer", LongBufferAssertion.class).containsExactlyInOrder(1L, 2L);

        try {
            Assertions.assertWithMessage(null).that(createLongBuffer()).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createLongBuffer()).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createLongBuffer()).containsExactlyInOrder(2L, 1L);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void floatBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((FloatBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createFloatBuffer()).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertWithMessage("Test message").that(null, FloatBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createFloatBuffer(), FloatBufferAssertion.class).containsExactlyInOrder(1.0f, 2.0f);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", FloatBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_floatBuffer", FloatBufferAssertion.class).containsExactlyInOrder(1.0f, 2.0f);

        try {
            Assertions.assertWithMessage(null).that(createFloatBuffer()).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createFloatBuffer()).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createFloatBuffer()).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void doubleBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((DoubleBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer()).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(null, DoubleBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createDoubleBuffer(), DoubleBufferAssertion.class).containsExactlyInOrder(1.0, 2.0);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", DoubleBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_doubleBuffer", DoubleBufferAssertion.class).containsExactlyInOrder(1.0, 2.0);

        try {
            Assertions.assertWithMessage(null).that(createDoubleBuffer()).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createDoubleBuffer()).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createDoubleBuffer()).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link MessageAssertion} class test.
     */
    @Test
    public void charBufferAssertionTest() {
        Assertions.assertWithMessage("Test message").that((CharBuffer) null).isNull();
        Assertions.assertWithMessage("Test message").that(createCharBuffer()).containsExactlyInOrder(49, 50);
        Assertions.assertWithMessage("Test message").that(null, CharBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(createCharBuffer(), CharBufferAssertion.class).containsExactlyInOrder(49, 50);
        Assertions.assertWithMessage("Test message").that(new NullFieldClass(), "_field", CharBufferAssertion.class).isNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charBuffer").isNotNull();
        Assertions.assertWithMessage("Test message").that(new PrivateFieldsClass(), "_charBuffer", CharBufferAssertion.class).containsExactlyInOrder(49, 50);

        try {
            Assertions.assertWithMessage(null).that(createCharBuffer()).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("").that(createCharBuffer()).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            Assertions.assertWithMessage("Test message").that(createCharBuffer()).containsExactlyInOrder(50, 49);
            Assertions.fail("MessageAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Test message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
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
