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

import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
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
    public void initializeTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertion();
        baseAssertion1.initialize(null);
        Assertions.assertThat(baseAssertion1.getActual()).isNull();
        Assertions.assertThat(baseAssertion1, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion1.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initialize(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion1.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion1.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion();
        baseAssertion2.initialize(new Object());
        Assertions.assertThat(baseAssertion2.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion2, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion2.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initialize(new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion2.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.lang.Object@.*>");
        }
        baseAssertion2.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion();
        baseAssertion3.initialize(null, null);
        Assertions.assertThat(baseAssertion3.getActual()).isNull();
        Assertions.assertThat(baseAssertion3, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion3.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion3.initialize(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion3.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion3.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }

        BaseAssertion<Object> baseAssertion4 = createBaseAssertion();
        baseAssertion4.initialize(new Object(), null);
        Assertions.assertThat(baseAssertion4.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion4, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion4.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion4.initialize(new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion4.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.lang.Object@.*>");
        }
        baseAssertion4.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion5 = createBaseAssertion();
        baseAssertion5.initialize(null, "");
        Assertions.assertThat(baseAssertion5.getActual()).isNull();
        Assertions.assertThat(baseAssertion5, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion5.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion5.initialize(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion5.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion5.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }

        BaseAssertion<Object> baseAssertion6 = createBaseAssertion();
        baseAssertion6.initialize(new Object(), "");
        Assertions.assertThat(baseAssertion6.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion6, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion6.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion6.initialize(new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion6.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.lang.Object@.*>");
        }
        baseAssertion6.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion7 = createBaseAssertion();
        baseAssertion7.initialize(null, "Message");
        Assertions.assertThat(baseAssertion7.getActual()).isNull();
        Assertions.assertThat(baseAssertion7, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion7.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion7.initialize(null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }
        baseAssertion7.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion7.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }

        BaseAssertion<Object> baseAssertion8 = createBaseAssertion();
        baseAssertion8.initialize(new Object(), "Message");
        Assertions.assertThat(baseAssertion8.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion8, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion8.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion8.initialize(new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }
        try {
            baseAssertion8.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.lang.Object@.*>");
        }
        baseAssertion8.as(Raw.objectAssertion()).isNotNull();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeAssertionTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertion(null, null);

        BaseAssertion<Object> baseAssertion11 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion11, null);
        Assertions.assertThat(baseAssertion11.getActual()).isNull();
        Assertions.assertThat(baseAssertion11.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion11, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion12 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion12, new Object());
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion12, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion13 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion13, null, null);
        Assertions.assertThat(baseAssertion13.getActual()).isNull();
        Assertions.assertThat(baseAssertion13.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion13, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion14 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion14, new Object(), null);
        Assertions.assertThat(baseAssertion14.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion14.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion14, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion15 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion15, null, "");
        Assertions.assertThat(baseAssertion15.getActual()).isNull();
        Assertions.assertThat(baseAssertion15.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion15, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion16 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "");
        Assertions.assertThat(baseAssertion16.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion16.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion17 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion17, null, "Message");
        Assertions.assertThat(baseAssertion17.getActual()).isNull();
        Assertions.assertThat(baseAssertion17.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion17, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion18 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion18, new Object(), "Message");
        Assertions.assertThat(baseAssertion18.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion18.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion18, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion(null, "");

        BaseAssertion<Object> baseAssertion21 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion21, null);
        Assertions.assertThat(baseAssertion21.getActual()).isNull();
        Assertions.assertThat(baseAssertion21.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion21, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion22 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion22, new Object());
        Assertions.assertThat(baseAssertion22.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion22.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion22, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion23 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion23, null, null);
        Assertions.assertThat(baseAssertion23.getActual()).isNull();
        Assertions.assertThat(baseAssertion23.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion23, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion24 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion24, new Object(), null);
        Assertions.assertThat(baseAssertion24.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion24.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion24, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion25 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion25, null, "");
        Assertions.assertThat(baseAssertion25.getActual()).isNull();
        Assertions.assertThat(baseAssertion25.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion25, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion26 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "");
        Assertions.assertThat(baseAssertion26.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion26.createAssertionError().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion27 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion27, null, "Message");
        Assertions.assertThat(baseAssertion27.getActual()).isNull();
        Assertions.assertThat(baseAssertion27.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion27, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion28 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion28, new Object(), "Message");
        Assertions.assertThat(baseAssertion28.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion28.createAssertionError().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion28, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion(null, "Base message");

        BaseAssertion<Object> baseAssertion31 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion31, null);
        Assertions.assertThat(baseAssertion31.getActual()).isNull();
        Assertions.assertThat(baseAssertion31.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion31, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion32 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion32, new Object());
        Assertions.assertThat(baseAssertion32.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion32.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion32, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion33 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion33, null, null);
        Assertions.assertThat(baseAssertion33.getActual()).isNull();
        Assertions.assertThat(baseAssertion33.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion33, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion34 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion34, new Object(), null);
        Assertions.assertThat(baseAssertion34.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion34.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion34, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion35 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion35, null, "");
        Assertions.assertThat(baseAssertion35.getActual()).isNull();
        Assertions.assertThat(baseAssertion35.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion35, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion36 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "");
        Assertions.assertThat(baseAssertion36.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion36.createAssertionError().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion37 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion37, null, "Message");
        Assertions.assertThat(baseAssertion37.getActual()).isNull();
        Assertions.assertThat(baseAssertion37.createAssertionError().getMessage()).isEqualTo("Base message. Message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion37, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message. Message. Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion38 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion38, new Object(), "Message");
        Assertions.assertThat(baseAssertion38.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion38.createAssertionError().getMessage()).isEqualTo("Base message. Message.");
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
        try {
            createBaseAssertion().as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
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

        createBaseAssertion(object).as(Raw.objectAssertion()).isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion()).isSameAs(object);
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

        BaseAssertion<Object> baseAssertion = createBaseAssertion(object);
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
    public void asWithMessageTest() {
        Object object = new Object();

        Assertions.assertThat(createBaseAssertion(null).as(createBaseAssertion(), "As message").getActual()).isNull();
        Assertions.assertThat(createBaseAssertion(null, "Message").as(createBaseAssertion(), "As message").getActual()).isNull();
        try {
            createBaseAssertion().as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
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

        createBaseAssertion(object).as(Raw.objectAssertion(), "As message").isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion(), "As message").isSameAs(object);
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

        BaseAssertion<Object> baseAssertion = createBaseAssertion(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion(), "As message")).hasClass(BaseAssertionImpl.class);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion(), "As message")).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion(), "As message").getActual()).isSameAs(object);

        ObjectAssertion objectAssertion = createBaseAssertion(object).as(Raw.objectAssertion(), "As message");
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message")).hasClass(ObjectAssertion.class);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message")).isNotSameAs(objectAssertion);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message").getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveAssertionTest() {
        createBaseAssertion((byte) 10).as(Raw.byteAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((byte) 10).as(Raw.byteAssertion()).getActual()).hasClass(Byte.class);
        initialize(Raw.byteAssertion(), (byte) 10).as(Raw.byteAssertion()).isEqualTo(10);

        createBaseAssertion((short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((short) 10).as(Raw.shortAssertion()).getActual()).hasClass(Short.class);
        initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortAssertion()).isEqualTo(10);

        createBaseAssertion(10).as(Raw.intAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion(10).as(Raw.intAssertion()).getActual()).hasClass(Integer.class);
        initialize(Raw.intAssertion(), 10).as(Raw.intAssertion()).isEqualTo(10);

        createBaseAssertion(10L).as(Raw.longAssertion()).isEqualTo(10L);
        Assertions.assertThat(createBaseAssertion(10L).as(Raw.longAssertion()).getActual()).hasClass(Long.class);
        initialize(Raw.longAssertion(), 10L).as(Raw.longAssertion()).isEqualTo(10L);

        createBaseAssertion(10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        Assertions.assertThat(createBaseAssertion(10.0f).as(Raw.floatAssertion()).getActual()).hasClass(Float.class);
        initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);

        createBaseAssertion(10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        Assertions.assertThat(createBaseAssertion(10.0).as(Raw.doubleAssertion()).getActual()).hasClass(Double.class);
        initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);

        createBaseAssertion(true).as(Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(createBaseAssertion(true).as(Raw.booleanAssertion()).getActual()).hasClass(Boolean.class);
        initialize(Raw.booleanAssertion(), true).as(Raw.booleanAssertion()).isTrue();

        createBaseAssertion('c').as(Raw.charAssertion()).isEqualTo(99);
        Assertions.assertThat(createBaseAssertion('c').as(Raw.charAssertion()).getActual()).hasClass(Character.class);
        initialize(Raw.charAssertion(), 'c').as(Raw.charAssertion()).isEqualTo(99);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        createBaseAssertion(new byte[0]).as(Raw.byteArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new byte[0]).as(Raw.byteArrayAssertion()).getActual()).hasClass(byte[].class);
        initialize(Raw.byteArrayAssertion(), new byte[0]).as(Raw.byteArrayAssertion()).hasLength(0);

        createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);

        createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.intArrayAssertion()).hasLength(0);

        createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.longArrayAssertion()).hasLength(0);

        createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);

        createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);

        createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);

        createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.charArrayAssertion()).hasLength(0);

        createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>listAssertion()).isEmpty();
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);

        createBaseAssertion(new HashSet<String>()).as(Raw.<String>setAssertion()).isEmpty();
        createBaseAssertion(new HashSet<String>()).as(Raw.<String>iterableAssertion()).isEmpty();

        Assertions.assertThat(initialize(Raw.<String>setAssertion(), new HashSet<String>()).as(Raw.<String>setAssertion())).hasClass(SetAssertion.class);
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), new HashSet<String>()).as(Raw.<String>setAssertion())).hasClass(SetAssertion.class);
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
