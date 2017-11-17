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
public final class BaseAssertionTest extends AssertionTest {

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

        Assertions.assertThat(createBaseAssertion(null).as(new BaseAssertionImpl()).getActual()).isNull();
        try {
            createBaseAssertion(object).as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createBaseAssertion(object, "Message").as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }

        BaseAssertion baseAssertion = createBaseAssertion(object);
        Assertions.assertThat(baseAssertion.as(new BaseAssertionImpl())).hasClass(BaseAssertionImpl.class);
        Assertions.assertThat(baseAssertion.as(new BaseAssertionImpl())).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(new BaseAssertionImpl()).getActual()).isSameAs(object);

        Assertions.assertThat(baseAssertion.as(new ObjectAssertion())).hasClass(ObjectAssertion.class);
        Assertions.assertThat(baseAssertion.as(new ObjectAssertion())).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(new ObjectAssertion()).getActual()).isSameAs(object);
        baseAssertion.as(new ObjectAssertion()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveByteAssertionTest() {
        createBaseAssertion((byte) 10).as(new ByteAssertion()).isEqualTo(10);
        createBaseAssertion((byte) 10).as(new ShortAssertion()).isEqualTo(10);
        createBaseAssertion((byte) 10).as(new IntAssertion()).isEqualTo(10);
        createBaseAssertion((byte) 10).as(new LongAssertion()).isEqualTo(10L);
        createBaseAssertion((byte) 10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        createBaseAssertion((byte) 10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion((byte) 10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            createBaseAssertion((byte) 10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Byte, java.lang.String)");
        }
        Assertions.assertThat(initialize(new ByteAssertion(), (byte) 10).as(new BaseAssertionImpl()).getActual()).hasClass(Byte.class);
        initialize(new ByteAssertion(), (byte) 10).as(new ByteAssertion()).isEqualTo(10);
        initialize(new ByteAssertion(), (byte) 10).as(new ShortAssertion()).isEqualTo(10);
        initialize(new ByteAssertion(), (byte) 10).as(new IntAssertion()).isEqualTo(10);
        initialize(new ByteAssertion(), (byte) 10).as(new LongAssertion()).isEqualTo(10L);
        initialize(new ByteAssertion(), (byte) 10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        initialize(new ByteAssertion(), (byte) 10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new ByteAssertion(), (byte) 10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Byte, java.lang.String)");
        }
        try {
            initialize(new ByteAssertion(), (byte) 10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Byte, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveShortAssertionTest() {
        try {
            createBaseAssertion((short) 10).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        createBaseAssertion((short) 10).as(new ShortAssertion()).isEqualTo(10);
        createBaseAssertion((short) 10).as(new IntAssertion()).isEqualTo(10);
        createBaseAssertion((short) 10).as(new LongAssertion()).isEqualTo(10L);
        createBaseAssertion((short) 10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        createBaseAssertion((short) 10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion((short) 10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            createBaseAssertion((short) 10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Short, java.lang.String)");
        }
        Assertions.assertThat(initialize(new ShortAssertion(), (short) 10).as(new BaseAssertionImpl()).getActual()).hasClass(Short.class);
        try {
            initialize(new ShortAssertion(), (short) 10).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Short, java.lang.String)");
        }
        initialize(new ShortAssertion(), (short) 10).as(new ShortAssertion()).isEqualTo(10);
        initialize(new ShortAssertion(), (short) 10).as(new IntAssertion()).isEqualTo(10);
        initialize(new ShortAssertion(), (short) 10).as(new LongAssertion()).isEqualTo(10L);
        initialize(new ShortAssertion(), (short) 10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        initialize(new ShortAssertion(), (short) 10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new ShortAssertion(), (short) 10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Short, java.lang.String)");
        }
        try {
            initialize(new ShortAssertion(), (short) 10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Short, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveIntAssertionTest() {
        try {
            createBaseAssertion(10).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            createBaseAssertion(10).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        createBaseAssertion(10).as(new IntAssertion()).isEqualTo(10);
        createBaseAssertion(10).as(new LongAssertion()).isEqualTo(10L);
        createBaseAssertion(10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        createBaseAssertion(10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion(10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            createBaseAssertion(10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Integer, java.lang.String)");
        }
        Assertions.assertThat(initialize(new IntAssertion(), 10).as(new BaseAssertionImpl()).getActual()).hasClass(Integer.class);
        try {
            initialize(new IntAssertion(), 10).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            initialize(new IntAssertion(), 10).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Integer, java.lang.String)");
        }
        initialize(new IntAssertion(), 10).as(new IntAssertion()).isEqualTo(10);
        initialize(new IntAssertion(), 10).as(new LongAssertion()).isEqualTo(10L);
        initialize(new IntAssertion(), 10).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        initialize(new IntAssertion(), 10).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new IntAssertion(), 10).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Integer, java.lang.String)");
        }
        try {
            initialize(new IntAssertion(), 10).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Integer, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveLongAssertionTest() {
        try {
            createBaseAssertion(10L).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            createBaseAssertion(10L).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            createBaseAssertion(10L).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        createBaseAssertion(10L).as(new LongAssertion()).isEqualTo(10L);
        createBaseAssertion(10L).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        createBaseAssertion(10L).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion(10L).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            createBaseAssertion(10L).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Long, java.lang.String)");
        }
        Assertions.assertThat(initialize(new LongAssertion(), 10L).as(new BaseAssertionImpl()).getActual()).hasClass(Long.class);
        try {
            initialize(new LongAssertion(), 10L).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            initialize(new LongAssertion(), 10L).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            initialize(new LongAssertion(), 10L).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Long, java.lang.String)");
        }
        initialize(new LongAssertion(), 10L).as(new LongAssertion()).isEqualTo(10L);
        initialize(new LongAssertion(), 10L).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        initialize(new LongAssertion(), 10L).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new LongAssertion(), 10L).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Long, java.lang.String)");
        }
        try {
            initialize(new LongAssertion(), 10L).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Long, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveFloatAssertionTest() {
        try {
            createBaseAssertion(10.0f).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0f).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0f).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0f).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        createBaseAssertion(10.0f).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        createBaseAssertion(10.0f).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion(10.0f).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0f).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Float, java.lang.String)");
        }
        Assertions.assertThat(initialize(new FloatAssertion(), 10.0f).as(new BaseAssertionImpl()).getActual()).hasClass(Float.class);
        try {
            initialize(new FloatAssertion(), 10.0f).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            initialize(new FloatAssertion(), 10.0f).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            initialize(new FloatAssertion(), 10.0f).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            initialize(new FloatAssertion(), 10.0f).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Float, java.lang.String)");
        }
        initialize(new FloatAssertion(), 10.0f).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        initialize(new FloatAssertion(), 10.0f).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new FloatAssertion(), 10.0f).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Float, java.lang.String)");
        }
        try {
            initialize(new FloatAssertion(), 10.0f).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Float, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveDoubleAssertionTest() {
        try {
            createBaseAssertion(10.0).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0).as(new FloatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        createBaseAssertion(10.0).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion(10.0).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            createBaseAssertion(10.0).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
        Assertions.assertThat(initialize(new DoubleAssertion(), 10.0).as(new BaseAssertionImpl()).getActual()).hasClass(Double.class);
        try {
            initialize(new DoubleAssertion(), 10.0).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            initialize(new DoubleAssertion(), 10.0).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            initialize(new DoubleAssertion(), 10.0).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            initialize(new DoubleAssertion(), 10.0).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            initialize(new DoubleAssertion(), 10.0).as(new FloatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Double, java.lang.String)");
        }
        initialize(new DoubleAssertion(), 10.0).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(new DoubleAssertion(), 10.0).as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Double, java.lang.String)");
        }
        try {
            initialize(new DoubleAssertion(), 10.0).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Double, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveBooleanAssertionTest() {
        try {
            createBaseAssertion(true).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            createBaseAssertion(true).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            createBaseAssertion(true).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            createBaseAssertion(true).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            createBaseAssertion(true).as(new FloatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            createBaseAssertion(true).as(new DoubleAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Boolean, java.lang.String)");
        }
        createBaseAssertion(true).as(new BooleanAssertion()).isTrue();
        try {
            createBaseAssertion(true).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Boolean, java.lang.String)");
        }
        Assertions.assertThat(initialize(new BooleanAssertion(), true).as(new BaseAssertionImpl()).getActual()).hasClass(Boolean.class);
        try {
            initialize(new BooleanAssertion(), true).as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            initialize(new BooleanAssertion(), true).as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            initialize(new BooleanAssertion(), true).as(new IntAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.IntAssertion - class should have one constructor IntAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            initialize(new BooleanAssertion(), true).as(new LongAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.LongAssertion - class should have one constructor LongAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            initialize(new BooleanAssertion(), true).as(new FloatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.FloatAssertion - class should have one constructor FloatAssertion(java.lang.Boolean, java.lang.String)");
        }
        try {
            initialize(new BooleanAssertion(), true).as(new DoubleAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.DoubleAssertion - class should have one constructor DoubleAssertion(java.lang.Boolean, java.lang.String)");
        }
        initialize(new BooleanAssertion(), true).as(new BooleanAssertion()).isTrue();
        try {
            initialize(new BooleanAssertion(), true).as(new CharAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.CharAssertion - class should have one constructor CharAssertion(java.lang.Boolean, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveCharAssertionTest() {
        try {
            createBaseAssertion('c').as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Character, java.lang.String)");
        }
        try {
            createBaseAssertion('c').as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Character, java.lang.String)");
        }
        createBaseAssertion('c').as(new IntAssertion()).isEqualTo(99);
        createBaseAssertion('c').as(new LongAssertion()).isEqualTo(99L);
        createBaseAssertion('c').as(new FloatAssertion()).isEqualTo(99.0f, 0.01f);
        createBaseAssertion('c').as(new DoubleAssertion()).isEqualTo(99.0, 0.01);
        try {
            createBaseAssertion('c').as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Character, java.lang.String)");
        }
        createBaseAssertion('c').as(new CharAssertion()).isAlphabetic();
        Assertions.assertThat(initialize(new CharAssertion(), 'c').as(new BaseAssertionImpl()).getActual()).hasClass(Character.class);
        try {
            initialize(new CharAssertion(), 'c').as(new ByteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ByteAssertion - class should have one constructor ByteAssertion(java.lang.Character, java.lang.String)");
        }
        try {
            initialize(new CharAssertion(), 'c').as(new ShortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.ShortAssertion - class should have one constructor ShortAssertion(java.lang.Character, java.lang.String)");
        }
        initialize(new CharAssertion(), 'c').as(new IntAssertion()).isEqualTo(99);
        initialize(new CharAssertion(), 'c').as(new LongAssertion()).isEqualTo(99L);
        initialize(new CharAssertion(), 'c').as(new FloatAssertion()).isEqualTo(99.0f, 0.01f);
        initialize(new CharAssertion(), 'c').as(new DoubleAssertion()).isEqualTo(99.0, 0.01);
        try {
            initialize(new CharAssertion(), 'c').as(new BooleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.primitive.BooleanAssertion - class should have one constructor BooleanAssertion(java.lang.Character, java.lang.String)");
        }
        initialize(new CharAssertion(), 'c').as(new CharAssertion()).isAlphabetic();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        createBaseAssertion(new byte[0]).as(new ByteArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new byte[0]).as(new ByteArrayAssertion()).getActual()).hasClass(byte[].class);
        initialize(Raw.byteArrayAssertion(), new byte[0]).as(new ByteArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.byteArrayAssertion(), new byte[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([B, java.lang.String)");
        }

        createBaseAssertion(new short[0]).as(new ShortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[0]).as(new ShortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[0]).as(new ShortArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([S, java.lang.String)");
        }

        createBaseAssertion(new int[0]).as(new IntArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[0]).as(new IntArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[0]).as(new IntArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([I, java.lang.String)");
        }

        createBaseAssertion(new long[0]).as(new LongArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[0]).as(new LongArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[0]).as(new LongArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([J, java.lang.String)");
        }

        createBaseAssertion(new float[0]).as(new FloatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[0]).as(new FloatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[0]).as(new FloatArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([F, java.lang.String)");
        }

        createBaseAssertion(new double[0]).as(new DoubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[0]).as(new DoubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[0]).as(new DoubleArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([D, java.lang.String)");
        }

        createBaseAssertion(new boolean[0]).as(new BooleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[0]).as(new BooleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(new BooleanArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Z, java.lang.String)");
        }

        createBaseAssertion(new char[0]).as(new CharArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[0]).as(new CharArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[0]).as(new CharArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([C, java.lang.String)");
        }

        createBaseAssertion(new String[0]).as(new ObjectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[0]).as(new ObjectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.objectArrayAssertion(), new String[0]).as(new ObjectArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.objectArrayAssertion(), new String[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.core.IterableAssertion - class should have one constructor IterableAssertion([Ljava.lang.String;, java.lang.String)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        createBaseAssertion(new ArrayList<String>()).as(Raw.listAssertion()).isEmpty();
        createBaseAssertion(new ArrayList<String>()).as(Raw.collectionAssertion()).isEmpty();
        createBaseAssertion(new ArrayList<String>()).as(Raw.iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(new ListAssertion(), new ArrayList<String>()).as(Raw.listAssertion())).hasClass(ListAssertion.class);
        Assertions.assertThat(initialize(new ListAssertion(), new ArrayList<String>()).as(Raw.collectionAssertion())).hasClass(CollectionAssertion.class);
        Assertions.assertThat(initialize(new ListAssertion(), new ArrayList<String>()).as(Raw.iterableAssertion())).hasClass(IterableAssertion.class);

        createBaseAssertion(new HashSet<String>()).as(Raw.setAssertion()).isEmpty();
        createBaseAssertion(new HashSet<String>()).as(Raw.collectionAssertion()).isEmpty();
        createBaseAssertion(new HashSet<String>()).as(Raw.iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(new SetAssertion(), new HashSet<String>()).as(Raw.setAssertion())).hasClass(SetAssertion.class);
        Assertions.assertThat(initialize(new SetAssertion(), new HashSet<String>()).as(Raw.collectionAssertion())).hasClass(CollectionAssertion.class);
        Assertions.assertThat(initialize(new SetAssertion(), new HashSet<String>()).as(Raw.iterableAssertion())).hasClass(IterableAssertion.class);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getActualTest() {
        Object object = new Object();
        Assertions.assertThat(createBaseAssertion(object).getActual()).isNotNull();
        Assertions.assertThat(createBaseAssertion(object).getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getFailDescriptionTest() {
        BaseAssertion baseAssertion1 = createBaseAssertion(null);
        Assertions.assertThat(baseAssertion1.getFailDescription()).isNotSameAs(baseAssertion1.getFailDescription());
        Assertions.assertThat(baseAssertion1.getFailDescription().createAssertionError().getMessage()).isEmpty();

        BaseAssertion baseAssertion2 = createBaseAssertion(null, "Message");
        Assertions.assertThat(baseAssertion2.getFailDescription("message1").createAssertionError().getMessage()).isEqualTo("message. message1.");
        Assertions.assertThat(baseAssertion2.getFailDescription("message2").createAssertionError().getMessage()).isEqualTo("message. message2.");
        Assertions.assertThat(baseAssertion2.getFailDescription().createAssertionError().getMessage()).isEqualTo("message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualIsNotNullTest() {
        createBaseAssertion(new Object()).checkActualIsNotNull();
        createBaseAssertion("test").checkActualIsNotNull();

        try {
            createBaseAssertion(null).checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            createBaseAssertion(null, "Message").checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotNullTest() {
        createBaseAssertion(null).checkArgumentIsNotNull(new Object());
        createBaseAssertion(null).checkArgumentIsNotNull("test");
        createBaseAssertion(null).checkArgumentIsNotNull(1);

        try {
            createBaseAssertion(null).checkArgumentIsNotNull(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsNotNull(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyTrueTest() {
        createBaseAssertion(null).checkArgumentIsNotEmptyTrue(false);

        try {
            createBaseAssertion(null).checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyFalseTest() {
        createBaseAssertion(null).checkArgumentIsNotEmptyFalse(false);

        try {
            createBaseAssertion(null).checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsValidTest() {
        createBaseAssertion(null).checkArgumentIsValid(true);

        try {
            createBaseAssertion(null).checkArgumentIsValid(false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsValid(false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorTest() {
        Assertions.assertThat(createBaseAssertion(null).createAssertionError()).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError()).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("")).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message")).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.")).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue")).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue")).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue")).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue")).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException())).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException("some runtime exception"))).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError(new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException())).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException("some runtime exception"))).hasMessage("");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException())).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException("some runtime exception"))).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException())).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException("some runtime exception"))).hasMessage("fail message.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>.");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithActualTest() {
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual()).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual()).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("")).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message")).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.")).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue")).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue")).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue")).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue")).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).hasMessage("Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).hasMessage("fail message. Actual:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>.");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
    }

}
