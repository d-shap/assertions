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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.Matchers;
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
    public void matcherAssertionTest() {
        createBaseAssertion(null, null).matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertion(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertion(null, null).matcherAssertion("value", Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertion(null, "").matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertion(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertion(null, "").matcherAssertion("value", Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: null\n     but: was \"value\"");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void matcherAssertionWithMessageTest() {
        createBaseAssertion(null, null).matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertion(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertion(null, null).matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, null).matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertion(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertion(null, null).matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, null).matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertion(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertion(null, null).matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertion(null, "").matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertion(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertion(null, "").matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, "").matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertion(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertion(null, "").matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, "").matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertion(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertion(null, "").matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: null\n     but: was \"value\"");
        }
        createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertion(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\nExpected: not null\n     but: was null");
        }
        createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertion(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\nExpected: null\n     but: was \"value\"");
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
        createBaseAssertion(new byte[]{}).as(Raw.byteArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new byte[]{}).as(Raw.byteArrayAssertion()).getActual()).hasClass(byte[].class);
        initialize(Raw.byteArrayAssertion(), new byte[]{}).as(Raw.byteArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.byteArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new short[]{}).as(Raw.shortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new short[]{}).as(Raw.shortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[]{}).as(Raw.shortArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.shortArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new int[]{}).as(Raw.intArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new int[]{}).as(Raw.intArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[]{}).as(Raw.intArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.intArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new long[]{}).as(Raw.longArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new long[]{}).as(Raw.longArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[]{}).as(Raw.longArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.longArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new float[]{}).as(Raw.floatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new float[]{}).as(Raw.floatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[]{}).as(Raw.floatArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.floatArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new double[]{}).as(Raw.doubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new double[]{}).as(Raw.doubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[]{}).as(Raw.doubleArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.doubleArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new boolean[]{}).as(Raw.booleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new boolean[]{}).as(Raw.booleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).as(Raw.booleanArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.booleanArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new char[]{}).as(Raw.charArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new char[]{}).as(Raw.charArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[]{}).as(Raw.charArrayAssertion()).hasLength(0);
        try {
            createBaseAssertion(new Object()).as(Raw.charArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }

        createBaseAssertion(new String[]{}).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertion(new String[]{}).as(Raw.<String>objectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).as(Raw.<String>objectArrayAssertion()).hasLength(0);
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
    public void convertValueTest() {
        Assertions.assertThat(createBaseAssertion(null).convertValue(createHashSet("value1", "value2"), List.class)).isInstanceOf(List.class);
        Assertions.assertThat(createBaseAssertion(null).convertValue(createHashSet("value1", "value2"), List.class)).isNotInstanceOf(Set.class);

        Assertions.assertThat(createBaseAssertion(null).convertValue(createHashSet("value1", "value2"), Map.class)).isInstanceOf(Set.class);
        Assertions.assertThat(createBaseAssertion(null).convertValue(createHashSet("value1", "value2"), Map.class)).isNotInstanceOf(Map.class);

        try {
            createBaseAssertion(null, null).convertValue(createErrorInputStream(), Integer.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            createBaseAssertion(null, "Message").convertValue(createErrorInputStream(), Integer.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
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

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getAssertionErrorBuilderTest() {
        Assertions.assertThat(createBaseAssertion(null, null).getAssertionErrorBuilder().build().getMessage()).isEqualTo("");
        Assertions.assertThat(createBaseAssertion(null, "Message").getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
    }

}
