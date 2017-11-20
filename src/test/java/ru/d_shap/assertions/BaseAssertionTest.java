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
    public void asPrimitiveAssertionTest() {
        createBaseAssertion((byte) 10).as(new ByteAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((byte) 10).as(new ByteAssertion()).getActual()).hasClass(Byte.class);
        initialize(Raw.byteAssertion(), (byte) 10).as(new ByteAssertion()).isEqualTo(10);
        try {
            initialize(Raw.byteAssertion(), (byte) 10).as(new ByteArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion((short) 10).as(new ShortAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((short) 10).as(new ShortAssertion()).getActual()).hasClass(Short.class);
        initialize(Raw.shortAssertion(), (short) 10).as(new ShortAssertion()).isEqualTo(10);
        try {
            initialize(Raw.shortAssertion(), (short) 10).as(new ShortArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(10).as(new IntAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion(10).as(new IntAssertion()).getActual()).hasClass(Integer.class);
        initialize(Raw.intAssertion(), 10).as(new IntAssertion()).isEqualTo(10);
        try {
            initialize(Raw.intAssertion(), 10).as(new IntArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(10L).as(new LongAssertion()).isEqualTo(10L);
        Assertions.assertThat(createBaseAssertion(10L).as(new LongAssertion()).getActual()).hasClass(Long.class);
        initialize(Raw.longAssertion(), 10L).as(new LongAssertion()).isEqualTo(10L);
        try {
            initialize(Raw.longAssertion(), 10L).as(new LongArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(10.0f).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        Assertions.assertThat(createBaseAssertion(10.0f).as(new FloatAssertion()).getActual()).hasClass(Float.class);
        initialize(Raw.floatAssertion(), 10.0f).as(new FloatAssertion()).isEqualTo(10.0f, 0.01f);
        try {
            initialize(Raw.floatAssertion(), 10.0f).as(new FloatArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(10.0).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        Assertions.assertThat(createBaseAssertion(10.0).as(new DoubleAssertion()).getActual()).hasClass(Double.class);
        initialize(Raw.doubleAssertion(), 10.0).as(new DoubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(Raw.doubleAssertion(), 10.0).as(new DoubleArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(true).as(new BooleanAssertion()).isTrue();
        Assertions.assertThat(createBaseAssertion(true).as(new BooleanAssertion()).getActual()).hasClass(Boolean.class);
        initialize(Raw.booleanAssertion(), true).as(new BooleanAssertion()).isTrue();
        try {
            initialize(Raw.booleanAssertion(), true).as(new BooleanArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion('c').as(new CharAssertion()).isEqualTo(99);
        Assertions.assertThat(createBaseAssertion('c').as(new CharAssertion()).getActual()).hasClass(Character.class);
        initialize(Raw.charAssertion(), 'c').as(new CharAssertion()).isEqualTo(99);
        try {
            initialize(Raw.charAssertion(), 'c').as(new CharArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
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
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new short[0]).as(new ShortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[0]).as(new ShortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[0]).as(new ShortArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new int[0]).as(new IntArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[0]).as(new IntArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[0]).as(new IntArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new long[0]).as(new LongArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[0]).as(new LongArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[0]).as(new LongArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new float[0]).as(new FloatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[0]).as(new FloatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[0]).as(new FloatArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new double[0]).as(new DoubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[0]).as(new DoubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[0]).as(new DoubleArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new boolean[0]).as(new BooleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[0]).as(new BooleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(new BooleanArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new char[0]).as(new CharArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[0]).as(new CharArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[0]).as(new CharArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }

        createBaseAssertion(new String[0]).as(new ObjectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[0]).as(new ObjectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.objectArrayAssertion(), new String[0]).as(new ObjectArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.objectArrayAssertion(), new String[0]).as(Raw.iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
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
        Assertions.assertThat(baseAssertion2.getFailDescription("message1").createAssertionError().getMessage()).isEqualTo("Message. message1.");
        Assertions.assertThat(baseAssertion2.getFailDescription("message2").createAssertionError().getMessage()).isEqualTo("Message. message2.");
        Assertions.assertThat(baseAssertion2.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
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
