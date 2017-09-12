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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

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
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.ByteAssertion;
import ru.d_shap.assertions.primitive.CharAssertion;
import ru.d_shap.assertions.primitive.DoubleAssertion;
import ru.d_shap.assertions.primitive.FloatAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.primitive.ShortAssertion;

/**
 * Tests for {@link BaseAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BaseAssertionTest {

    /**
     * Test class constructor.
     */
    public BaseAssertionTest() {
        super();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asTest() {
        Object object = new Object();
        BaseAssertionImpl baseAssertion = new BaseAssertionImpl(object, null);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class)).hasClass(BaseAssertionImpl.class);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class)).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class).getActual()).isSameAs(object);

        Assertions.assertThat(baseAssertion.as(ObjectAssertion.class)).hasClass(ObjectAssertion.class);
        Assertions.assertThat(baseAssertion.as(ObjectAssertion.class)).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(ObjectAssertion.class).getActual()).isSameAs(object);
        baseAssertion.as(ObjectAssertion.class).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveByteAssertionTest() {
        new BaseAssertionImpl((byte) 10, null).as(ByteAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, null).as(ShortAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, null).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, null).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl((byte) 10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl((byte) 10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl((byte) 10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            new BaseAssertionImpl((byte) 10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Byte, java.lang.String)");
        }
        Assertions.assertThat(new ByteAssertion((byte) 10, null).as(BaseAssertionImpl.class).getActual()).hasClass(Byte.class);
        new ByteAssertion((byte) 10, null).as(ByteAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, null).as(ShortAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, null).as(IntAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, null).as(LongAssertion.class).isEqualTo(10L);
        new ByteAssertion((byte) 10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new ByteAssertion((byte) 10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new ByteAssertion((byte) 10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            new ByteAssertion((byte) 10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Byte, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveShortAssertionTest() {
        try {
            new BaseAssertionImpl((short) 10, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        new BaseAssertionImpl((short) 10, null).as(ShortAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((short) 10, null).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((short) 10, null).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl((short) 10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl((short) 10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl((short) 10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            new BaseAssertionImpl((short) 10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Short, java.lang.String)");
        }
        Assertions.assertThat(new ShortAssertion((short) 10, null).as(BaseAssertionImpl.class).getActual()).hasClass(Short.class);
        try {
            new ShortAssertion((short) 10, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        new ShortAssertion((short) 10, null).as(ShortAssertion.class).isEqualTo(10);
        new ShortAssertion((short) 10, null).as(IntAssertion.class).isEqualTo(10);
        new ShortAssertion((short) 10, null).as(LongAssertion.class).isEqualTo(10L);
        new ShortAssertion((short) 10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new ShortAssertion((short) 10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new ShortAssertion((short) 10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            new ShortAssertion((short) 10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Short, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveIntAssertionTest() {
        try {
            new BaseAssertionImpl(10, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        new BaseAssertionImpl(10, null).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl(10, null).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl(10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Integer, java.lang.String)");
        }
        Assertions.assertThat(new IntAssertion(10, null).as(BaseAssertionImpl.class).getActual()).hasClass(Integer.class);
        try {
            new IntAssertion(10, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new IntAssertion(10, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        new IntAssertion(10, null).as(IntAssertion.class).isEqualTo(10);
        new IntAssertion(10, null).as(LongAssertion.class).isEqualTo(10L);
        new IntAssertion(10, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new IntAssertion(10, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new IntAssertion(10, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new IntAssertion(10, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Integer, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveLongAssertionTest() {
        try {
            new BaseAssertionImpl(10L, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        new BaseAssertionImpl(10L, null).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl(10L, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10L, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10L, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Long, java.lang.String)");
        }
        Assertions.assertThat(new LongAssertion(10L, null).as(BaseAssertionImpl.class).getActual()).hasClass(Long.class);
        try {
            new LongAssertion(10L, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        new LongAssertion(10L, null).as(LongAssertion.class).isEqualTo(10L);
        new LongAssertion(10L, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new LongAssertion(10L, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new LongAssertion(10L, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Long, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveFloatAssertionTest() {
        try {
            new BaseAssertionImpl(10.0f, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, null).as(LongAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        new BaseAssertionImpl(10.0f, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10.0f, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10.0f, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Float, java.lang.String)");
        }
        Assertions.assertThat(new FloatAssertion(10.0f, null).as(BaseAssertionImpl.class).getActual()).hasClass(Float.class);
        try {
            new FloatAssertion(10.0f, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, null).as(LongAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        new FloatAssertion(10.0f, null).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new FloatAssertion(10.0f, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new FloatAssertion(10.0f, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Float, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveDoubleAssertionTest() {
        try {
            new BaseAssertionImpl(10.0, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, null).as(LongAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, null).as(FloatAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        new BaseAssertionImpl(10.0, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10.0, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
        Assertions.assertThat(new DoubleAssertion(10.0, null).as(BaseAssertionImpl.class).getActual()).hasClass(Double.class);
        try {
            new DoubleAssertion(10.0, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, null).as(LongAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, null).as(FloatAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        new DoubleAssertion(10.0, null).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new DoubleAssertion(10.0, null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveBooleanAssertionTest() {
        new BaseAssertionImpl(true, null).as(BooleanAssertion.class).isTrue();
        Assertions.assertThat(new BooleanAssertion(true, null).as(BaseAssertionImpl.class).getActual()).hasClass(Boolean.class);
        try {
            new BooleanAssertion(true, null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, null).as(IntAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, null).as(LongAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, null).as(FloatAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, null).as(DoubleAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Boolean, java.lang.String)");
        }
        new BooleanAssertion(true, null).as(BooleanAssertion.class).isTrue();
        try {
            new BooleanAssertion(true, null).as(CharAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Boolean, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveCharAssertionTest() {
        new BaseAssertionImpl('c', null).as(CharAssertion.class).isAlphabetic();
        Assertions.assertThat(new CharAssertion('c', null).as(BaseAssertionImpl.class).getActual()).hasClass(Character.class);
        try {
            new CharAssertion('c', null).as(ByteAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Character, java.lang.String)");
        }
        try {
            new CharAssertion('c', null).as(ShortAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Character, java.lang.String)");
        }
        new CharAssertion('c', null).as(IntAssertion.class).isEqualTo(99);
        new CharAssertion('c', null).as(LongAssertion.class).isEqualTo(99L);
        new CharAssertion('c', null).as(FloatAssertion.class).isEqualTo(99.0f, 0.01f);
        new CharAssertion('c', null).as(DoubleAssertion.class).isEqualTo(99.0, 0.01);
        try {
            new CharAssertion('c', null).as(BooleanAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Character, java.lang.String)");
        }
        new CharAssertion('c', null).as(CharAssertion.class).isAlphabetic();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        new BaseAssertionImpl(new byte[0], null).as(ByteArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new byte[0], null).as(ByteArrayAssertion.class).getActual()).hasClass(byte[].class);
        new ByteArrayAssertion(new byte[0], null).as(ByteArrayAssertion.class).hasLength(0);
        try {
            new ByteArrayAssertion(new byte[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([B, java.lang.String)");
        }

        new BaseAssertionImpl(new short[0], null).as(ShortArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new short[0], null).as(ShortArrayAssertion.class).getActual()).hasClass(short[].class);
        new ShortArrayAssertion(new short[0], null).as(ShortArrayAssertion.class).hasLength(0);
        try {
            new ShortArrayAssertion(new short[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([S, java.lang.String)");
        }

        new BaseAssertionImpl(new int[0], null).as(IntArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new int[0], null).as(IntArrayAssertion.class).getActual()).hasClass(int[].class);
        new IntArrayAssertion(new int[0], null).as(IntArrayAssertion.class).hasLength(0);
        try {
            new IntArrayAssertion(new int[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([I, java.lang.String)");
        }

        new BaseAssertionImpl(new long[0], null).as(LongArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new long[0], null).as(LongArrayAssertion.class).getActual()).hasClass(long[].class);
        new LongArrayAssertion(new long[0], null).as(LongArrayAssertion.class).hasLength(0);
        try {
            new LongArrayAssertion(new long[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([J, java.lang.String)");
        }

        new BaseAssertionImpl(new float[0], null).as(FloatArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new float[0], null).as(FloatArrayAssertion.class).getActual()).hasClass(float[].class);
        new FloatArrayAssertion(new float[0], null).as(FloatArrayAssertion.class).hasLength(0);
        try {
            new FloatArrayAssertion(new float[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([F, java.lang.String)");
        }

        new BaseAssertionImpl(new double[0], null).as(DoubleArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new double[0], null).as(DoubleArrayAssertion.class).getActual()).hasClass(double[].class);
        new DoubleArrayAssertion(new double[0], null).as(DoubleArrayAssertion.class).hasLength(0);
        try {
            new DoubleArrayAssertion(new double[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([D, java.lang.String)");
        }

        new BaseAssertionImpl(new boolean[0], null).as(BooleanArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new boolean[0], null).as(BooleanArrayAssertion.class).getActual()).hasClass(boolean[].class);
        new BooleanArrayAssertion(new boolean[0], null).as(BooleanArrayAssertion.class).hasLength(0);
        try {
            new BooleanArrayAssertion(new boolean[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Z, java.lang.String)");
        }

        new BaseAssertionImpl(new char[0], null).as(CharArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new char[0], null).as(CharArrayAssertion.class).getActual()).hasClass(char[].class);
        new CharArrayAssertion(new char[0], null).as(CharArrayAssertion.class).hasLength(0);
        try {
            new CharArrayAssertion(new char[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([C, java.lang.String)");
        }

        new BaseAssertionImpl(new String[0], null).as(ObjectArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new String[0], null).as(ObjectArrayAssertion.class).getActual()).hasClass(String[].class);
        new ObjectArrayAssertion(new String[0], null).as(ObjectArrayAssertion.class).hasLength(0);
        try {
            new ObjectArrayAssertion(new String[0], null).as(IterableAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Ljava.lang.String;, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        new BaseAssertionImpl(new ArrayList<String>(), null).as(ListAssertion.class).isEmpty();
        new BaseAssertionImpl(new ArrayList<String>(), null).as(CollectionAssertion.class).isEmpty();
        new BaseAssertionImpl(new ArrayList<String>(), null).as(IterableAssertion.class).isEmpty();

        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(ListAssertion.class)).hasClass(ListAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(CollectionAssertion.class)).hasClass(CollectionAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(IterableAssertion.class)).hasClass(IterableAssertion.class);

        new BaseAssertionImpl(new HashSet<String>(), null).as(SetAssertion.class).isEmpty();
        new BaseAssertionImpl(new HashSet<String>(), null).as(CollectionAssertion.class).isEmpty();
        new BaseAssertionImpl(new HashSet<String>(), null).as(IterableAssertion.class).isEmpty();

        Assertions.assertThat(new SetAssertion(new HashSet<String>(), null).as(SetAssertion.class)).hasClass(SetAssertion.class);
        Assertions.assertThat(new SetAssertion(new HashSet<String>(), null).as(CollectionAssertion.class)).hasClass(CollectionAssertion.class);
        Assertions.assertThat(new SetAssertion(new HashSet<String>(), null).as(IterableAssertion.class)).hasClass(IterableAssertion.class);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asWrongConstructorFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionWrongParameterCountConstructor.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterCountConstructor - class should have one constructor BaseAssertionWrongParameterCountConstructor(java.lang.Object, java.lang.String)");
        }
        try {
            new ListAssertion(new ArrayList<String>(), null).as(MapAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion - class should have one constructor MapAssertion(java.util.ArrayList, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(new Object(), "message").as(BaseAssertionWrongParameterTypeConstructor.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterTypeConstructor - class should have one constructor BaseAssertionWrongParameterTypeConstructor(java.lang.Object, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionMultipleConstructors.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionMultipleConstructors - class should have one constructor BaseAssertionMultipleConstructors(java.lang.Object, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asIllegalAccessFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionIllegalAccess.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionIllegalAccess");
            Assertions.assertThat(ex).isCauseInstanceOf(IllegalAccessException.class);
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInvocationTargetFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionInvocationTarget.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInvocationTarget");
            Assertions.assertThat(ex).isCauseInstanceOf(InvocationTargetException.class);
            Assertions.assertThat(ex).toCause().isCauseInstanceOf(RuntimeException.class);
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInstantiationFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionInstantiation.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInstantiation");
            Assertions.assertThat(ex).isCauseInstanceOf(InstantiationException.class);
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getActualTest() {
        Object object = new Object();
        Assertions.assertThat(new BaseAssertionImpl(object, null).getActual()).isNotNull();
        Assertions.assertThat(new BaseAssertionImpl(object, null).getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "some message").getMessage()).isEqualTo("some message");

        try {
            Assertions.assertThat(new BaseAssertionImpl(null, "some message").getMessage()).isEqualTo("some other message");
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<some other message> but was:<some message>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualIsNotNullTest() {
        new BaseAssertionImpl(new Object(), null).checkActualIsNotNull();
        new BaseAssertionImpl("test", null).checkActualIsNotNull();

        try {
            new BaseAssertionImpl(null, null).checkActualIsNotNull();
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotNullTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull(new Object());
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull("test");
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull(1);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotNull(null);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyTrueTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyTrue(false);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyFalseTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyFalse(false);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((Throwable) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((Throwable) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageAndThrowableTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", null).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", null).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", null).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message. fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", null).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message. fail message");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void actualAsStringTest() {
        Assertions.assertThat(new BaseAssertionImpl("value", null).actualAsString()).isEqualTo("value");
        Assertions.assertThat(new BaseAssertionImpl(1, null).actualAsString()).isEqualTo("1");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionImpl extends BaseAssertion {

        BaseAssertionImpl(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionWrongParameterCountConstructor extends BaseAssertion {

        BaseAssertionWrongParameterCountConstructor(final Object actual) {
            super(actual, null);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionWrongParameterTypeConstructor extends BaseAssertion {

        BaseAssertionWrongParameterTypeConstructor(final Object actual, final StringBuilder message) {
            super(actual, message.toString());
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionMultipleConstructors extends BaseAssertion {

        BaseAssertionMultipleConstructors(final Object actual, final String message) {
            super(actual, message);
        }

        BaseAssertionMultipleConstructors(final Object actual, final Object message) {
            super(actual, message.toString());
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionIllegalAccess extends BaseAssertion {

        private BaseAssertionIllegalAccess(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionInvocationTarget extends BaseAssertion {

        BaseAssertionInvocationTarget(final Object actual, final String message) {
            super(actual, message);
            throw new RuntimeException();
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private abstract static class BaseAssertionInstantiation extends BaseAssertion {

        BaseAssertionInstantiation(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

}
