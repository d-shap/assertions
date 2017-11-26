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

import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;

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
    public void initializeTest() {
        BaseAssertion baseAssertion1 = createBaseAssertion();
        baseAssertion1.initialize(null);
        Assertions.assertThat(baseAssertion1.getActual()).isNull();
        Assertions.assertThat(baseAssertion1.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initialize(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion2 = createBaseAssertion();
        baseAssertion2.initialize(new Object());
        Assertions.assertThat(baseAssertion2.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion2.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initialize(new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion3 = createBaseAssertion();
        baseAssertion3.initialize(null, null);
        Assertions.assertThat(baseAssertion3.getActual()).isNull();
        Assertions.assertThat(baseAssertion3.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion3.initialize(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion4 = createBaseAssertion();
        baseAssertion4.initialize(new Object(), null);
        Assertions.assertThat(baseAssertion4.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion4.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion4.initialize(new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion5 = createBaseAssertion();
        baseAssertion5.initialize(null, "");
        Assertions.assertThat(baseAssertion5.getActual()).isNull();
        Assertions.assertThat(baseAssertion5.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion5.initialize(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion6 = createBaseAssertion();
        baseAssertion6.initialize(new Object(), "");
        Assertions.assertThat(baseAssertion6.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion6.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion6.initialize(new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion7 = createBaseAssertion();
        baseAssertion7.initialize(null, "Message");
        Assertions.assertThat(baseAssertion7.getActual()).isNull();
        Assertions.assertThat(baseAssertion7.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion7.initialize(null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion8 = createBaseAssertion();
        baseAssertion8.initialize(new Object(), "Message");
        Assertions.assertThat(baseAssertion8.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion8.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion8.initialize(new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeAssertionTest() {
        BaseAssertion baseAssertion1 = createBaseAssertion(null, null);

        BaseAssertion baseAssertion11 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion11, null);
        Assertions.assertThat(baseAssertion11.getActual()).isNull();
        Assertions.assertThat(baseAssertion11.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion11, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion12 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion12, new Object());
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion12, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion13 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion13, null, null);
        Assertions.assertThat(baseAssertion13.getActual()).isNull();
        Assertions.assertThat(baseAssertion13.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion13, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion14 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion14, new Object(), null);
        Assertions.assertThat(baseAssertion14.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion14.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion14, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion15 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion15, null, "");
        Assertions.assertThat(baseAssertion15.getActual()).isNull();
        Assertions.assertThat(baseAssertion15.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion15, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion16 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "");
        Assertions.assertThat(baseAssertion16.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion16.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion17 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion17, null, "Message");
        Assertions.assertThat(baseAssertion17.getActual()).isNull();
        Assertions.assertThat(baseAssertion17.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion17, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion18 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion18, new Object(), "Message");
        Assertions.assertThat(baseAssertion18.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion18.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion18, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion2 = createBaseAssertion(null, "");

        BaseAssertion baseAssertion21 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion21, null);
        Assertions.assertThat(baseAssertion21.getActual()).isNull();
        Assertions.assertThat(baseAssertion21.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion21, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion22 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion22, new Object());
        Assertions.assertThat(baseAssertion22.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion22.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion22, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion23 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion23, null, null);
        Assertions.assertThat(baseAssertion23.getActual()).isNull();
        Assertions.assertThat(baseAssertion23.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion23, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion24 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion24, new Object(), null);
        Assertions.assertThat(baseAssertion24.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion24.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion24, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion25 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion25, null, "");
        Assertions.assertThat(baseAssertion25.getActual()).isNull();
        Assertions.assertThat(baseAssertion25.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion25, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion26 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "");
        Assertions.assertThat(baseAssertion26.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion26.getFailDescription().createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion27 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion27, null, "Message");
        Assertions.assertThat(baseAssertion27.getActual()).isNull();
        Assertions.assertThat(baseAssertion27.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion27, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion28 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion28, new Object(), "Message");
        Assertions.assertThat(baseAssertion28.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion28.getFailDescription().createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion28, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion3 = createBaseAssertion(null, "Base message");

        BaseAssertion baseAssertion31 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion31, null);
        Assertions.assertThat(baseAssertion31.getActual()).isNull();
        Assertions.assertThat(baseAssertion31.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion31, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion32 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion32, new Object());
        Assertions.assertThat(baseAssertion32.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion32.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion32, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion33 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion33, null, null);
        Assertions.assertThat(baseAssertion33.getActual()).isNull();
        Assertions.assertThat(baseAssertion33.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion33, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion34 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion34, new Object(), null);
        Assertions.assertThat(baseAssertion34.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion34.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion34, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion35 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion35, null, "");
        Assertions.assertThat(baseAssertion35.getActual()).isNull();
        Assertions.assertThat(baseAssertion35.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion35, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion36 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "");
        Assertions.assertThat(baseAssertion36.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion36.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion37 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion37, null, "Message");
        Assertions.assertThat(baseAssertion37.getActual()).isNull();
        Assertions.assertThat(baseAssertion37.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message. Message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion37, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Message. Assertion should not be initialized.");
        }

        BaseAssertion baseAssertion38 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion38, new Object(), "Message");
        Assertions.assertThat(baseAssertion38.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion38.getFailDescription().createAssertionError().getMessage()).isEqualTo("Base message. Message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion38, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Message. Assertion should not be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asTest() {
        Object object = new Object();

        Assertions.assertThat(createBaseAssertion(null).as(createBaseAssertion()).getActual()).isNull();
        Assertions.assertThat(createBaseAssertion(null, "Message").as(createBaseAssertion()).getActual()).isNull();
        Assertions.assertThat(createBaseAssertion(null).as(createBaseAssertion(), "As message").getActual()).isNull();
        Assertions.assertThat(createBaseAssertion(null, "Message").as(createBaseAssertion(), "As message").getActual()).isNull();
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
        try {
            createBaseAssertion(object).as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createBaseAssertion(object, "Message").as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }

        createBaseAssertion(object).as(Raw.objectAssertion()).isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion()).isSameAs(object);
        createBaseAssertion(object).as(Raw.objectAssertion(), "As message").isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion(), "As message").isSameAs(object);
        try {
            createBaseAssertion(object).as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertion(object, "Message").as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertion(object).as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("As message. Values should be different. Actual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertion(object, "Message").as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. As message. Values should be different. Actual:<java.lang.Object.*>");
        }

        BaseAssertion baseAssertion = createBaseAssertion(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion())).hasClass(BaseAssertionImpl.class);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion())).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion()).getActual()).isSameAs(object);

        ObjectAssertion objectAssertion = createBaseAssertion(object).as(Raw.objectAssertion());
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion())).hasClass(ObjectAssertion.class);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion())).isNotSameAs(objectAssertion);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion()).getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveAssertionTest() {
        createBaseAssertion((byte) 10).as(Raw.byteAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((byte) 10).as(Raw.byteAssertion()).getActual()).hasClass(Byte.class);
        initialize(Raw.byteAssertion(), (byte) 10).as(Raw.byteAssertion()).isEqualTo(10);
        try {
            initialize(Raw.byteAssertion(), (byte) 10).as(Raw.byteArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).as(Raw.byteArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion((short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((short) 10).as(Raw.shortAssertion()).getActual()).hasClass(Short.class);
        initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        try {
            initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(10).as(Raw.intAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion(10).as(Raw.intAssertion()).getActual()).hasClass(Integer.class);
        initialize(Raw.intAssertion(), 10).as(Raw.intAssertion()).isEqualTo(10);
        try {
            initialize(Raw.intAssertion(), 10).as(Raw.intArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.intAssertion(), 10).as(Raw.intArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(10L).as(Raw.longAssertion()).isEqualTo(10L);
        Assertions.assertThat(createBaseAssertion(10L).as(Raw.longAssertion()).getActual()).hasClass(Long.class);
        initialize(Raw.longAssertion(), 10L).as(Raw.longAssertion()).isEqualTo(10L);
        try {
            initialize(Raw.longAssertion(), 10L).as(Raw.longArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).as(Raw.longArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        Assertions.assertThat(createBaseAssertion(10.0f).as(Raw.floatAssertion()).getActual()).hasClass(Float.class);
        initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        try {
            initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        Assertions.assertThat(createBaseAssertion(10.0).as(Raw.doubleAssertion()).getActual()).hasClass(Double.class);
        initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(true).as(Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(createBaseAssertion(true).as(Raw.booleanAssertion()).getActual()).hasClass(Boolean.class);
        initialize(Raw.booleanAssertion(), true).as(Raw.booleanAssertion()).isTrue();
        try {
            initialize(Raw.booleanAssertion(), true).as(Raw.booleanArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.booleanAssertion(), true).as(Raw.booleanArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion('c').as(Raw.charAssertion()).isEqualTo(99);
        Assertions.assertThat(createBaseAssertion('c').as(Raw.charAssertion()).getActual()).hasClass(Character.class);
        initialize(Raw.charAssertion(), 'c').as(Raw.charAssertion()).isEqualTo(99);
        try {
            initialize(Raw.charAssertion(), 'c').as(Raw.charArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.charAssertion(), 'c').as(Raw.charArrayAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        createBaseAssertion(new byte[0]).as(Raw.byteArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new byte[0]).as(Raw.byteArrayAssertion()).getActual()).hasClass(byte[].class);
        initialize(Raw.byteArrayAssertion(), new byte[0]).as(Raw.byteArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.byteArrayAssertion(), new byte[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.intArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.longArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.charArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }

        createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[0]).as(Raw.<String>iterableAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[0]).as(Raw.<String>iterableAssertion(), "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("As message. Value should match the assertion.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>listAssertion()).isEmpty();
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>collectionAssertion()).isEmpty();
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>collectionAssertion())).hasClass(CollectionAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>iterableAssertion())).hasClass(IterableAssertion.class);

        createBaseAssertion(new HashSet<String>()).as(Raw.<String>setAssertion()).isEmpty();
        createBaseAssertion(new HashSet<String>()).as(Raw.<String>collectionAssertion()).isEmpty();
        createBaseAssertion(new HashSet<String>()).as(Raw.<String>iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(Raw.<String>setAssertion(), new HashSet<String>()).as(Raw.<String>setAssertion())).hasClass(SetAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>setAssertion(), new HashSet<String>()).as(Raw.<String>collectionAssertion())).hasClass(CollectionAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>setAssertion(), new HashSet<String>()).as(Raw.<String>iterableAssertion())).hasClass(IterableAssertion.class);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkInitializedTest() {
        createBaseAssertion(null).checkInitialized();
        try {
            createBaseAssertion().checkInitialized();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
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

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue")).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue")).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue")).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue")).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
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

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion(null).createAssertionError("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithActualTest() {
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual()).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("")).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message")).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.")).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue")).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue")).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue")).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue")).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2")).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2")).toCause().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2")).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2")).toCause().isNull();

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual(new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).hasMessage("fail message. Actual:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual((Object) "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");

        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException())).toCause().toMessage().isNull();
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasMessage("fail message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(createBaseAssertion("actualValue").createAssertionErrorWithActual("fail message.", "expectedValue1", "expectedValue2", new RuntimeException("some runtime exception"))).hasCauseMessage("some runtime exception");
    }

}
