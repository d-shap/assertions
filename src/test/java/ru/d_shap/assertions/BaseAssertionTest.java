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

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).as(BaseAssertionImpl.class).getActual()).isNull();
        try {
            new BaseAssertionImpl(object, new FailDescription()).as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }

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
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(ByteAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(ShortAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl((byte) 10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl((byte) 10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            new BaseAssertionImpl((byte) 10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Byte, java.lang.String)");
        }
        Assertions.assertThat(new ByteAssertion((byte) 10, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Byte.class);
        new ByteAssertion((byte) 10, new FailDescription()).as(ByteAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, new FailDescription()).as(ShortAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new ByteAssertion((byte) 10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new ByteAssertion((byte) 10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new ByteAssertion((byte) 10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new ByteAssertion((byte) 10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
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
            new BaseAssertionImpl((short) 10, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        new BaseAssertionImpl((short) 10, new FailDescription()).as(ShortAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((short) 10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl((short) 10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl((short) 10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl((short) 10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl((short) 10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            new BaseAssertionImpl((short) 10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Short, java.lang.String)");
        }
        Assertions.assertThat(new ShortAssertion((short) 10, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Short.class);
        try {
            new ShortAssertion((short) 10, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        new ShortAssertion((short) 10, new FailDescription()).as(ShortAssertion.class).isEqualTo(10);
        new ShortAssertion((short) 10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new ShortAssertion((short) 10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new ShortAssertion((short) 10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new ShortAssertion((short) 10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new ShortAssertion((short) 10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            new ShortAssertion((short) 10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
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
            new BaseAssertionImpl(10, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        new BaseAssertionImpl(10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new BaseAssertionImpl(10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl(10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Integer, java.lang.String)");
        }
        Assertions.assertThat(new IntAssertion(10, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Integer.class);
        try {
            new IntAssertion(10, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new IntAssertion(10, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        new IntAssertion(10, new FailDescription()).as(IntAssertion.class).isEqualTo(10);
        new IntAssertion(10, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new IntAssertion(10, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new IntAssertion(10, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new IntAssertion(10, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            new IntAssertion(10, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
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
            new BaseAssertionImpl(10L, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        new BaseAssertionImpl(10L, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new BaseAssertionImpl(10L, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10L, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10L, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10L, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Long, java.lang.String)");
        }
        Assertions.assertThat(new LongAssertion(10L, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Long.class);
        try {
            new LongAssertion(10L, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        new LongAssertion(10L, new FailDescription()).as(LongAssertion.class).isEqualTo(10L);
        new LongAssertion(10L, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new LongAssertion(10L, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new LongAssertion(10L, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            new LongAssertion(10L, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
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
            new BaseAssertionImpl(10.0f, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        new BaseAssertionImpl(10.0f, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new BaseAssertionImpl(10.0f, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10.0f, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0f, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Float, java.lang.String)");
        }
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Float.class);
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        new FloatAssertion(10.0f, new FailDescription()).as(FloatAssertion.class).isEqualTo(10.0f, 0.01f);
        new FloatAssertion(10.0f, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
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
            new BaseAssertionImpl(10.0, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(FloatAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        new BaseAssertionImpl(10.0, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(10.0, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Double.class);
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(FloatAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        new DoubleAssertion(10.0, new FailDescription()).as(DoubleAssertion.class).isEqualTo(10.0, 0.01);
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveBooleanAssertionTest() {
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(FloatAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(DoubleAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Boolean, java.lang.String)");
        }
        new BaseAssertionImpl(true, new FailDescription()).as(BooleanAssertion.class).isTrue();
        try {
            new BaseAssertionImpl(true, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Boolean, java.lang.String)");
        }
        Assertions.assertThat(new BooleanAssertion(true, new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Boolean.class);
        try {
            new BooleanAssertion(true, new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, new FailDescription()).as(IntAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, new FailDescription()).as(LongAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, new FailDescription()).as(FloatAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            new BooleanAssertion(true, new FailDescription()).as(DoubleAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Boolean, java.lang.String)");
        }
        new BooleanAssertion(true, new FailDescription()).as(BooleanAssertion.class).isTrue();
        try {
            new BooleanAssertion(true, new FailDescription()).as(CharAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Boolean, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveCharAssertionTest() {
        try {
            new BaseAssertionImpl('c', new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Character, java.lang.String)");
        }
        try {
            new BaseAssertionImpl('c', new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Character, java.lang.String)");
        }
        new BaseAssertionImpl('c', new FailDescription()).as(IntAssertion.class).isEqualTo(99);
        new BaseAssertionImpl('c', new FailDescription()).as(LongAssertion.class).isEqualTo(99L);
        new BaseAssertionImpl('c', new FailDescription()).as(FloatAssertion.class).isEqualTo(99.0f, 0.01f);
        new BaseAssertionImpl('c', new FailDescription()).as(DoubleAssertion.class).isEqualTo(99.0, 0.01);
        try {
            new BaseAssertionImpl('c', new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Character, java.lang.String)");
        }
        new BaseAssertionImpl('c', new FailDescription()).as(CharAssertion.class).isAlphabetic();
        Assertions.assertThat(new CharAssertion('c', new FailDescription()).as(BaseAssertionImpl.class).getActual()).hasClass(Character.class);
        try {
            new CharAssertion('c', new FailDescription()).as(ByteAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Character, java.lang.String)");
        }
        try {
            new CharAssertion('c', new FailDescription()).as(ShortAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Character, java.lang.String)");
        }
        new CharAssertion('c', new FailDescription()).as(IntAssertion.class).isEqualTo(99);
        new CharAssertion('c', new FailDescription()).as(LongAssertion.class).isEqualTo(99L);
        new CharAssertion('c', new FailDescription()).as(FloatAssertion.class).isEqualTo(99.0f, 0.01f);
        new CharAssertion('c', new FailDescription()).as(DoubleAssertion.class).isEqualTo(99.0, 0.01);
        try {
            new CharAssertion('c', new FailDescription()).as(BooleanAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Character, java.lang.String)");
        }
        new CharAssertion('c', new FailDescription()).as(CharAssertion.class).isAlphabetic();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        new BaseAssertionImpl(new byte[0], new FailDescription()).as(ByteArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new byte[0], new FailDescription()).as(ByteArrayAssertion.class).getActual()).hasClass(byte[].class);
        new ByteArrayAssertion(new byte[0], new FailDescription()).as(ByteArrayAssertion.class).hasLength(0);
        try {
            new ByteArrayAssertion(new byte[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([B, java.lang.String)");
        }

        new BaseAssertionImpl(new short[0], new FailDescription()).as(ShortArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new short[0], new FailDescription()).as(ShortArrayAssertion.class).getActual()).hasClass(short[].class);
        new ShortArrayAssertion(new short[0], new FailDescription()).as(ShortArrayAssertion.class).hasLength(0);
        try {
            new ShortArrayAssertion(new short[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([S, java.lang.String)");
        }

        new BaseAssertionImpl(new int[0], new FailDescription()).as(IntArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new int[0], new FailDescription()).as(IntArrayAssertion.class).getActual()).hasClass(int[].class);
        new IntArrayAssertion(new int[0], new FailDescription()).as(IntArrayAssertion.class).hasLength(0);
        try {
            new IntArrayAssertion(new int[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([I, java.lang.String)");
        }

        new BaseAssertionImpl(new long[0], new FailDescription()).as(LongArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new long[0], new FailDescription()).as(LongArrayAssertion.class).getActual()).hasClass(long[].class);
        new LongArrayAssertion(new long[0], new FailDescription()).as(LongArrayAssertion.class).hasLength(0);
        try {
            new LongArrayAssertion(new long[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([J, java.lang.String)");
        }

        new BaseAssertionImpl(new float[0], new FailDescription()).as(FloatArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new float[0], new FailDescription()).as(FloatArrayAssertion.class).getActual()).hasClass(float[].class);
        new FloatArrayAssertion(new float[0], new FailDescription()).as(FloatArrayAssertion.class).hasLength(0);
        try {
            new FloatArrayAssertion(new float[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([F, java.lang.String)");
        }

        new BaseAssertionImpl(new double[0], new FailDescription()).as(DoubleArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new double[0], new FailDescription()).as(DoubleArrayAssertion.class).getActual()).hasClass(double[].class);
        new DoubleArrayAssertion(new double[0], new FailDescription()).as(DoubleArrayAssertion.class).hasLength(0);
        try {
            new DoubleArrayAssertion(new double[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([D, java.lang.String)");
        }

        new BaseAssertionImpl(new boolean[0], new FailDescription()).as(BooleanArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new boolean[0], new FailDescription()).as(BooleanArrayAssertion.class).getActual()).hasClass(boolean[].class);
        new BooleanArrayAssertion(new boolean[0], new FailDescription()).as(BooleanArrayAssertion.class).hasLength(0);
        try {
            new BooleanArrayAssertion(new boolean[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Z, java.lang.String)");
        }

        new BaseAssertionImpl(new char[0], new FailDescription()).as(CharArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new char[0], new FailDescription()).as(CharArrayAssertion.class).getActual()).hasClass(char[].class);
        new CharArrayAssertion(new char[0], new FailDescription()).as(CharArrayAssertion.class).hasLength(0);
        try {
            new CharArrayAssertion(new char[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([C, java.lang.String)");
        }

        new BaseAssertionImpl(new String[0], new FailDescription()).as(ObjectArrayAssertion.class).hasLength(0);
        Assertions.assertThat(new BaseAssertionImpl(new String[0], new FailDescription()).as(ObjectArrayAssertion.class).getActual()).hasClass(String[].class);
        new ObjectArrayAssertion(new String[0], new FailDescription()).as(ObjectArrayAssertion.class).hasLength(0);
        try {
            new ObjectArrayAssertion(new String[0], new FailDescription()).as(IterableAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Ljava.lang.String;, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        new BaseAssertionImpl(new ArrayList<String>(), new FailDescription()).as(ListAssertion.class).isEmpty();
        new BaseAssertionImpl(new ArrayList<String>(), new FailDescription()).as(CollectionAssertion.class).isEmpty();
        new BaseAssertionImpl(new ArrayList<String>(), new FailDescription()).as(IterableAssertion.class).isEmpty();

        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), new FailDescription()).as(ListAssertion.class)).hasClass(ListAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), new FailDescription()).as(CollectionAssertion.class)).hasClass(CollectionAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), new FailDescription()).as(IterableAssertion.class)).hasClass(IterableAssertion.class);

        new BaseAssertionImpl(new HashSet<String>(), new FailDescription()).as(SetAssertion.class).isEmpty();
        new BaseAssertionImpl(new HashSet<String>(), new FailDescription()).as(CollectionAssertion.class).isEmpty();
        new BaseAssertionImpl(new HashSet<String>(), new FailDescription()).as(IterableAssertion.class).isEmpty();

        Assertions.assertThat(new SetAssertion(new HashSet<String>(), new FailDescription()).as(SetAssertion.class)).hasClass(SetAssertion.class);
        Assertions.assertThat(new SetAssertion(new HashSet<String>(), new FailDescription()).as(CollectionAssertion.class)).hasClass(CollectionAssertion.class);
        Assertions.assertThat(new SetAssertion(new HashSet<String>(), new FailDescription()).as(IterableAssertion.class)).hasClass(IterableAssertion.class);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asWrongConstructorFailTest() {
        try {
            new ListAssertion(new ArrayList<String>(), new FailDescription()).as(MapAssertion.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion - class should have one constructor MapAssertion(java.util.ArrayList, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(null, new FailDescription()).as(BaseAssertionWrongParameterCountConstructorImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterCountConstructorImpl - class should have one constructor BaseAssertionWrongParameterCountConstructorImpl(java.lang.Object, java.lang.String)");
        }
        try {
            new BaseAssertionImpl("value", new FailDescription()).as(BaseAssertionWrongParameterCountConstructorImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterCountConstructorImpl - class should have one constructor BaseAssertionWrongParameterCountConstructorImpl(java.lang.String, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(null, new FailDescription().addMessage("message")).as(BaseAssertionWrongParameterTypeConstructorImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterTypeConstructorImpl - class should have one constructor BaseAssertionWrongParameterTypeConstructorImpl(java.lang.Object, java.lang.String)");
        }
        try {
            new BaseAssertionImpl("value", new FailDescription().addMessage("message")).as(BaseAssertionWrongParameterTypeConstructorImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongParameterTypeConstructorImpl - class should have one constructor BaseAssertionWrongParameterTypeConstructorImpl(java.lang.String, java.lang.String)");
        }
        try {
            new BaseAssertionImpl(null, new FailDescription()).as(BaseAssertionMultipleConstructorsImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionMultipleConstructorsImpl - class should have one constructor BaseAssertionMultipleConstructorsImpl(java.lang.Object, java.lang.String)");
        }
        try {
            new BaseAssertionImpl("value", new FailDescription()).as(BaseAssertionMultipleConstructorsImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionMultipleConstructorsImpl - class should have one constructor BaseAssertionMultipleConstructorsImpl(java.lang.String, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInvocationTargetFailTest() {
        try {
            new BaseAssertionImpl("value", new FailDescription()).as(BaseAssertionInvocationRuntimeExceptionImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInvocationRuntimeExceptionImpl");
            Assertions.assertThat(ex).isCauseInstanceOf(InvocationTargetException.class);
            Assertions.assertThat(ex).toCause().isCauseInstanceOf(RuntimeException.class);
            Assertions.assertThat(ex).toCause().hasCauseMessage("ERROR");
        }
        try {
            new BaseAssertionImpl("value", new FailDescription()).as(BaseAssertionInvocationAssertionErrorImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("ERROR");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInstantiationFailTest() {
        try {
            new BaseAssertionImpl("value", new FailDescription()).as(BaseAssertionInstantiationExceptionImpl.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInstantiationExceptionImpl");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getActualTest() {
        Object object = new Object();
        Assertions.assertThat(new BaseAssertionImpl(object, new FailDescription()).getActual()).isNotNull();
        Assertions.assertThat(new BaseAssertionImpl(object, new FailDescription()).getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualIsNotNullTest() {
        new BaseAssertionImpl(new Object(), new FailDescription()).checkActualIsNotNull();
        new BaseAssertionImpl("test", new FailDescription()).checkActualIsNotNull();

        try {
            new BaseAssertionImpl(null, new FailDescription()).checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotNullTest() {
        new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotNull(new Object());
        new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotNull("test");
        new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotNull(1);

        try {
            new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotNull(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyTrueTest() {
        new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotEmptyTrue(false);

        try {
            new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyFalseTest() {
        new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotEmptyFalse(false);

        try {
            new BaseAssertionImpl(null, new FailDescription()).checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError("fail message").getMessage()).isEqualTo("fail message.");

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError("fail message").getMessage()).isEqualTo("fail message.");

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message.");

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError(new RuntimeException()).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription()).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEmpty();

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError(new RuntimeException()).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("")).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEmpty();

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message")).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, new FailDescription().addMessage("assertion message.")).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class BaseAssertionImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual          the actual value.
         * @param failDescription the fail description.
         */
        public BaseAssertionImpl(final Object actual, final FailDescription failDescription) {
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
    public static final class BaseAssertionWrongParameterCountConstructorImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual the actual value.
         */
        public BaseAssertionWrongParameterCountConstructorImpl(final Object actual) {
            super(actual, null);
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
    public static final class BaseAssertionWrongParameterTypeConstructorImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual  the actual value.
         * @param message the assertion message.
         */
        public BaseAssertionWrongParameterTypeConstructorImpl(final Object actual, final StringBuilder message) {
            super(actual, new FailDescription().addMessage(message.toString()));
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
    public static final class BaseAssertionMultipleConstructorsImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual          the actual value.
         * @param failDescription the fail description.
         */
        public BaseAssertionMultipleConstructorsImpl(final Object actual, final FailDescription failDescription) {
            super(actual, failDescription);
        }

        /**
         * Create new object.
         *
         * @param actual  the actual value.
         * @param message the assertion message.
         */
        public BaseAssertionMultipleConstructorsImpl(final Object actual, final Object message) {
            super(actual, new FailDescription().addMessage(message.toString()));
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
    public static final class BaseAssertionInvocationRuntimeExceptionImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual          the actual value.
         * @param failDescription the fail description.
         */
        public BaseAssertionInvocationRuntimeExceptionImpl(final Object actual, final FailDescription failDescription) {
            super(actual, failDescription);
            throw new RuntimeException("ERROR");
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
    public static final class BaseAssertionInvocationAssertionErrorImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual          the actual value.
         * @param failDescription the fail description.
         */
        public BaseAssertionInvocationAssertionErrorImpl(final Object actual, final FailDescription failDescription) {
            super(actual, failDescription);
            throw new AssertionError("ERROR");
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
    public abstract static class BaseAssertionInstantiationExceptionImpl extends BaseAssertion {

        /**
         * Create new object.
         *
         * @param actual          the actual value.
         * @param failDescription the fail description.
         */
        public BaseAssertionInstantiationExceptionImpl(final Object actual, final FailDescription failDescription) {
            super(actual, failDescription);
        }

        @Override
        protected final String asString(final Object value, final boolean actual) {
            return value.toString();
        }

    }

}
