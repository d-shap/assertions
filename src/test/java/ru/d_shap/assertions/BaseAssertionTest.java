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

import org.junit.Test;

import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.collection.SortedSetAssertion;
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
        Assertions.assertThat(baseAssertion1.getAssertionErrorBuilder().build().getMessage()).isEmpty();
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion();
        baseAssertion2.initialize(new Object());
        Assertions.assertThat(baseAssertion2.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion2, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion2.getAssertionErrorBuilder().build().getMessage()).isEmpty();
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
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion2.as(Raw.objectAssertion()).isNotNull();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeWithMessageTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertion();
        baseAssertion1.initialize(null, null);
        Assertions.assertThat(baseAssertion1.getActual()).isNull();
        Assertions.assertThat(baseAssertion1, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion1.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initialize(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion1.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion1.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion();
        baseAssertion2.initialize(new Object(), null);
        Assertions.assertThat(baseAssertion2.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion2, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion2.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initialize(new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion2.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion2.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion();
        baseAssertion3.initialize(null, "");
        Assertions.assertThat(baseAssertion3.getActual()).isNull();
        Assertions.assertThat(baseAssertion3, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion3.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion3.initialize(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion3.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion3.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion4 = createBaseAssertion();
        baseAssertion4.initialize(new Object(), "");
        Assertions.assertThat(baseAssertion4.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion4, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion4.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion4.initialize(new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion4.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion4.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion5 = createBaseAssertion();
        baseAssertion5.initialize(null, "Message");
        Assertions.assertThat(baseAssertion5.getActual()).isNull();
        Assertions.assertThat(baseAssertion5, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion5.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion5.initialize(null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }
        baseAssertion5.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion5.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion6 = createBaseAssertion();
        baseAssertion6.initialize(new Object(), "Message");
        Assertions.assertThat(baseAssertion6.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion6, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion6.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion6.initialize(new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }
        try {
            baseAssertion6.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion6.as(Raw.objectAssertion()).isNotNull();
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
        Assertions.assertThat(baseAssertion11.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion11, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion12 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion12, new Object());
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion12, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion(null, "");

        BaseAssertion<Object> baseAssertion21 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion21, null);
        Assertions.assertThat(baseAssertion21.getActual()).isNull();
        Assertions.assertThat(baseAssertion21.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion21, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion22 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion22, new Object());
        Assertions.assertThat(baseAssertion22.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion22.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion22, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion(null, "Base message");

        BaseAssertion<Object> baseAssertion31 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion31, null);
        Assertions.assertThat(baseAssertion31.getActual()).isNull();
        Assertions.assertThat(baseAssertion31.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion31, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion32 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion32, new Object());
        Assertions.assertThat(baseAssertion32.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion32.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion32, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeAssertionWithMessageTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertion(null, null);

        BaseAssertion<Object> baseAssertion11 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion11, null, null);
        Assertions.assertThat(baseAssertion11.getActual()).isNull();
        Assertions.assertThat(baseAssertion11.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion11, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion12 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion12, new Object(), null);
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion12, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion13 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion13, null, "");
        Assertions.assertThat(baseAssertion13.getActual()).isNull();
        Assertions.assertThat(baseAssertion13.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion13, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion14 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion14, new Object(), "");
        Assertions.assertThat(baseAssertion14.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion14.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion14, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion15 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion15, null, "Message");
        Assertions.assertThat(baseAssertion15.getActual()).isNull();
        Assertions.assertThat(baseAssertion15.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion15, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion16 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "Message");
        Assertions.assertThat(baseAssertion16.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion16.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion16, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion(null, "");

        BaseAssertion<Object> baseAssertion21 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion21, null, null);
        Assertions.assertThat(baseAssertion21.getActual()).isNull();
        Assertions.assertThat(baseAssertion21.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion21, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion22 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion22, new Object(), null);
        Assertions.assertThat(baseAssertion22.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion22.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion22, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion23 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion23, null, "");
        Assertions.assertThat(baseAssertion23.getActual()).isNull();
        Assertions.assertThat(baseAssertion23.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion23, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion24 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion24, new Object(), "");
        Assertions.assertThat(baseAssertion24.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion24.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion24, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion25 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion25, null, "Message");
        Assertions.assertThat(baseAssertion25.getActual()).isNull();
        Assertions.assertThat(baseAssertion25.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion25, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion26 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "Message");
        Assertions.assertThat(baseAssertion26.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion26.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion26, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion(null, "Base message");

        BaseAssertion<Object> baseAssertion31 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion31, null, null);
        Assertions.assertThat(baseAssertion31.getActual()).isNull();
        Assertions.assertThat(baseAssertion31.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion31, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion32 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion32, new Object(), null);
        Assertions.assertThat(baseAssertion32.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion32.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion32, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion33 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion33, null, "");
        Assertions.assertThat(baseAssertion33.getActual()).isNull();
        Assertions.assertThat(baseAssertion33.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion33, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion34 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion34, new Object(), "");
        Assertions.assertThat(baseAssertion34.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion34.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion34, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion35 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion35, null, "Message");
        Assertions.assertThat(baseAssertion35.getActual()).isNull();
        Assertions.assertThat(baseAssertion35.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion35, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion36 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "Message");
        Assertions.assertThat(baseAssertion36.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion36.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion36, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeAssertionWithMessageAndParameterTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertion(null, null);

        BaseAssertion<Object> baseAssertion111 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion111, null, null);
        Assertions.assertThat(baseAssertion111.getActual()).isNull();
        Assertions.assertThat(baseAssertion111.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion111, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion112 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion112, new Object(), null);
        Assertions.assertThat(baseAssertion112.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion112.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion112, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion113 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion113, null, "");
        Assertions.assertThat(baseAssertion113.getActual()).isNull();
        Assertions.assertThat(baseAssertion113.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion113, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion114 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion114, new Object(), "");
        Assertions.assertThat(baseAssertion114.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion114.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion114, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion115 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion115, null, "Message");
        Assertions.assertThat(baseAssertion115.getActual()).isNull();
        Assertions.assertThat(baseAssertion115.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion115, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion116 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion116, new Object(), "Message");
        Assertions.assertThat(baseAssertion116.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion116.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion116, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion121 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion121, null, null, "");
        Assertions.assertThat(baseAssertion121.getActual()).isNull();
        Assertions.assertThat(baseAssertion121.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion121, null, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion122 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion122, new Object(), null, "");
        Assertions.assertThat(baseAssertion122.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion122.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion122, new Object(), null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion123 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion123, null, "", "");
        Assertions.assertThat(baseAssertion123.getActual()).isNull();
        Assertions.assertThat(baseAssertion123.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion123, null, "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion124 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion124, new Object(), "", "");
        Assertions.assertThat(baseAssertion124.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion124.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion124, new Object(), "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion125 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion125, null, "Message", "");
        Assertions.assertThat(baseAssertion125.getActual()).isNull();
        Assertions.assertThat(baseAssertion125.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion125, null, "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion126 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion126, new Object(), "Message", "");
        Assertions.assertThat(baseAssertion126.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion126.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion126, new Object(), "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion131 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion131, null, null, "param");
        Assertions.assertThat(baseAssertion131.getActual()).isNull();
        Assertions.assertThat(baseAssertion131.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion131, null, null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion132 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion132, new Object(), null, "param");
        Assertions.assertThat(baseAssertion132.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion132.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion132, new Object(), null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion133 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion133, null, "", "param");
        Assertions.assertThat(baseAssertion133.getActual()).isNull();
        Assertions.assertThat(baseAssertion133.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion133, null, "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion134 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion134, new Object(), "", "param");
        Assertions.assertThat(baseAssertion134.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion134.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion134, new Object(), "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion135 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion135, null, "Message: {0}", "param");
        Assertions.assertThat(baseAssertion135.getActual()).isNull();
        Assertions.assertThat(baseAssertion135.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: param.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion135, null, "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: param.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion136 = createBaseAssertion();
        baseAssertion1.initializeAssertion(baseAssertion136, new Object(), "Message: {0}", "param");
        Assertions.assertThat(baseAssertion136.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion136.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: param.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion136, new Object(), "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: param.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertion(null, "");

        BaseAssertion<Object> baseAssertion211 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion211, null, null);
        Assertions.assertThat(baseAssertion211.getActual()).isNull();
        Assertions.assertThat(baseAssertion211.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion211, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion212 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion212, new Object(), null);
        Assertions.assertThat(baseAssertion212.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion212.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion212, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion213 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion213, null, "");
        Assertions.assertThat(baseAssertion213.getActual()).isNull();
        Assertions.assertThat(baseAssertion213.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion213, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion214 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion214, new Object(), "");
        Assertions.assertThat(baseAssertion214.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion214.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion214, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion215 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion215, null, "Message");
        Assertions.assertThat(baseAssertion215.getActual()).isNull();
        Assertions.assertThat(baseAssertion215.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion215, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion216 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion216, new Object(), "Message");
        Assertions.assertThat(baseAssertion216.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion216.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion216, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion221 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion221, null, null, "");
        Assertions.assertThat(baseAssertion221.getActual()).isNull();
        Assertions.assertThat(baseAssertion221.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion221, null, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion222 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion222, new Object(), null, "");
        Assertions.assertThat(baseAssertion222.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion222.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion222, new Object(), null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion223 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion223, null, "", "");
        Assertions.assertThat(baseAssertion223.getActual()).isNull();
        Assertions.assertThat(baseAssertion223.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion223, null, "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion224 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion224, new Object(), "", "");
        Assertions.assertThat(baseAssertion224.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion224.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion224, new Object(), "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion225 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion225, null, "Message", "");
        Assertions.assertThat(baseAssertion225.getActual()).isNull();
        Assertions.assertThat(baseAssertion225.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion225, null, "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion226 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion226, new Object(), "Message", "");
        Assertions.assertThat(baseAssertion226.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion226.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion226, new Object(), "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion231 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion231, null, null, "param");
        Assertions.assertThat(baseAssertion231.getActual()).isNull();
        Assertions.assertThat(baseAssertion231.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion231, null, null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion232 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion232, new Object(), null, "param");
        Assertions.assertThat(baseAssertion232.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion232.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion232, new Object(), null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion233 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion233, null, "", "param");
        Assertions.assertThat(baseAssertion233.getActual()).isNull();
        Assertions.assertThat(baseAssertion233.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion233, null, "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion234 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion234, new Object(), "", "param");
        Assertions.assertThat(baseAssertion234.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion234.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion234, new Object(), "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion235 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion235, null, "Message: {0}", "param");
        Assertions.assertThat(baseAssertion235.getActual()).isNull();
        Assertions.assertThat(baseAssertion235.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: param.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion235, null, "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: param.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion236 = createBaseAssertion();
        baseAssertion2.initializeAssertion(baseAssertion236, new Object(), "Message: {0}", "param");
        Assertions.assertThat(baseAssertion236.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion236.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: param.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion236, new Object(), "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: param.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertion(null, "Base message");

        BaseAssertion<Object> baseAssertion311 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion311, null, null);
        Assertions.assertThat(baseAssertion311.getActual()).isNull();
        Assertions.assertThat(baseAssertion311.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion311, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion312 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion312, new Object(), null);
        Assertions.assertThat(baseAssertion312.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion312.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion312, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion313 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion313, null, "");
        Assertions.assertThat(baseAssertion313.getActual()).isNull();
        Assertions.assertThat(baseAssertion313.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion313, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion314 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion314, new Object(), "");
        Assertions.assertThat(baseAssertion314.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion314.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion314, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion315 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion315, null, "Message");
        Assertions.assertThat(baseAssertion315.getActual()).isNull();
        Assertions.assertThat(baseAssertion315.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion315, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion316 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion316, new Object(), "Message");
        Assertions.assertThat(baseAssertion316.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion316.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion316, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion321 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion321, null, null, "");
        Assertions.assertThat(baseAssertion321.getActual()).isNull();
        Assertions.assertThat(baseAssertion321.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion321, null, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion322 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion322, new Object(), null, "");
        Assertions.assertThat(baseAssertion322.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion322.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion322, new Object(), null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion323 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion323, null, "", "");
        Assertions.assertThat(baseAssertion323.getActual()).isNull();
        Assertions.assertThat(baseAssertion323.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion323, null, "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion324 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion324, new Object(), "", "");
        Assertions.assertThat(baseAssertion324.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion324.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion324, new Object(), "", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion325 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion325, null, "Message", "");
        Assertions.assertThat(baseAssertion325.getActual()).isNull();
        Assertions.assertThat(baseAssertion325.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion325, null, "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion326 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion326, new Object(), "Message", "");
        Assertions.assertThat(baseAssertion326.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion326.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion326, new Object(), "Message", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion331 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion331, null, null, "param");
        Assertions.assertThat(baseAssertion331.getActual()).isNull();
        Assertions.assertThat(baseAssertion331.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion331, null, null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion332 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion332, new Object(), null, "param");
        Assertions.assertThat(baseAssertion332.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion332.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion332, new Object(), null, "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion333 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion333, null, "", "param");
        Assertions.assertThat(baseAssertion333.getActual()).isNull();
        Assertions.assertThat(baseAssertion333.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion333, null, "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion334 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion334, new Object(), "", "param");
        Assertions.assertThat(baseAssertion334.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion334.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion334, new Object(), "", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion335 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion335, null, "Message: {0}", "param");
        Assertions.assertThat(baseAssertion335.getActual()).isNull();
        Assertions.assertThat(baseAssertion335.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: param.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion335, null, "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: param.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion336 = createBaseAssertion();
        baseAssertion3.initializeAssertion(baseAssertion336, new Object(), "Message: {0}", "param");
        Assertions.assertThat(baseAssertion336.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion336.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: param.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion336, new Object(), "Message: {0}", "param");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: param.\n\tAssertion should not be initialized.");
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
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }

        createBaseAssertion(object).as(Raw.objectAssertion()).isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion()).isSameAs(object);
        try {
            createBaseAssertion(object).as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be different.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertion(object, "Message").as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object.*>");
        }

        BaseAssertion<Object> baseAssertion = createBaseAssertion(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion())).isInstanceOf(BaseAssertion.class);
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
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }

        createBaseAssertion(object).as(Raw.objectAssertion(), "As message").isSameAs(object);
        createBaseAssertion(object, "Message").as(Raw.objectAssertion(), "As message").isSameAs(object);
        try {
            createBaseAssertion(object).as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("As message.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertion(object, "Message").as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tAs message.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object.*>");
        }

        BaseAssertion<Object> baseAssertion = createBaseAssertion(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertion(), "As message")).isInstanceOf(BaseAssertion.class);
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
        try {
            createBaseAssertion(new Object()).as(Raw.byteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion((short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion((short) 10).as(Raw.shortAssertion()).getActual()).hasClass(Short.class);
        initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        try {
            createBaseAssertion(new Object()).as(Raw.shortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(10).as(Raw.intAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertion(10).as(Raw.intAssertion()).getActual()).hasClass(Integer.class);
        initialize(Raw.intAssertion(), 10).as(Raw.intAssertion()).isEqualTo(10);
        try {
            createBaseAssertion(new Object()).as(Raw.intAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(10L).as(Raw.longAssertion()).isEqualTo(10L);
        Assertions.assertThat(createBaseAssertion(10L).as(Raw.longAssertion()).getActual()).hasClass(Long.class);
        initialize(Raw.longAssertion(), 10L).as(Raw.longAssertion()).isEqualTo(10L);
        try {
            createBaseAssertion(new Object()).as(Raw.longAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        Assertions.assertThat(createBaseAssertion(10.0f).as(Raw.floatAssertion()).getActual()).hasClass(Float.class);
        initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        try {
            createBaseAssertion(new Object()).as(Raw.floatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        Assertions.assertThat(createBaseAssertion(10.0).as(Raw.doubleAssertion()).getActual()).hasClass(Double.class);
        initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertion(new Object()).as(Raw.doubleAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(true).as(Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(createBaseAssertion(true).as(Raw.booleanAssertion()).getActual()).hasClass(Boolean.class);
        initialize(Raw.booleanAssertion(), true).as(Raw.booleanAssertion()).isTrue();
        try {
            createBaseAssertion(new Object()).as(Raw.booleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion('c').as(Raw.charAssertion()).isEqualTo(99);
        Assertions.assertThat(createBaseAssertion('c').as(Raw.charAssertion()).getActual()).hasClass(Character.class);
        initialize(Raw.charAssertion(), 'c').as(Raw.charAssertion()).isEqualTo(99);
        try {
            createBaseAssertion(new Object()).as(Raw.charAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
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
            createBaseAssertion(new Object()).as(Raw.byteArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[0]).as(Raw.shortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[0]).as(Raw.shortArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.shortArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[0]).as(Raw.intArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[0]).as(Raw.intArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.intArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[0]).as(Raw.longArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[0]).as(Raw.longArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.longArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[0]).as(Raw.floatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[0]).as(Raw.floatArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.floatArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[0]).as(Raw.doubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[0]).as(Raw.doubleArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.doubleArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[0]).as(Raw.booleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).as(Raw.booleanArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.booleanArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[0]).as(Raw.charArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[0]).as(Raw.charArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.charArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[0]).as(Raw.<String>objectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.<String>objectArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>listAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        initialize(Raw.<String>listAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion()).isEmpty();
        try {
            createBaseAssertion(new Object()).as(Raw.<String>listAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new ArrayList<String>()).as(Raw.<String>iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).as(Raw.<String>listAssertion()).isEmpty();

        createBaseAssertion(createHashSet()).as(Raw.setAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.setAssertion(), createHashSet()).as(Raw.setAssertion())).hasClass(SetAssertion.class);
        initialize(Raw.setAssertion(), createHashSet()).as(Raw.setAssertion()).isEmpty();
        try {
            createBaseAssertion(new Object()).as(Raw.setAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(createHashSet()).as(Raw.iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.iterableAssertion(), createHashSet()).as(Raw.setAssertion())).hasClass(SetAssertion.class);
        initialize(Raw.iterableAssertion(), createHashSet()).as(Raw.setAssertion()).isEmpty();

        createBaseAssertion(createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.sortedSetAssertion(), createTreeSet()).as(Raw.sortedSetAssertion())).hasClass(SortedSetAssertion.class);
        initialize(Raw.sortedSetAssertion(), createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
        try {
            createBaseAssertion(new Object()).as(Raw.sortedSetAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(createTreeSet()).as(Raw.iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.iterableAssertion(), createTreeSet()).as(Raw.sortedSetAssertion())).hasClass(SortedSetAssertion.class);
        initialize(Raw.iterableAssertion(), createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createBaseAssertion(null, "Message").checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            createBaseAssertion(null, "Message").checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
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
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
    }

}
