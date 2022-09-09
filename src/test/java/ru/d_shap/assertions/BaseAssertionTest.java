///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.asimp.java.lang.ObjectAssertion;
import ru.d_shap.assertions.asimp.java.util.ListAssertion;
import ru.d_shap.assertions.asimp.java.util.SetAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedSetAssertion;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConversionExceptionHolder;
import ru.d_shap.assertions.util.DataHelper;

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
        Assertions.assertThat(createBaseAssertionObject(object).getActual()).isNotNull();
        Assertions.assertThat(createBaseAssertionObject(object).getActual()).isSameAs(object);

        try {
            createBaseAssertionObject().getActual();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertionObject();
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

        BaseAssertion<Object> baseAssertion2 = createBaseAssertionObject();
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

        BaseAssertion<CharSequence> baseAssertion3 = createBaseAssertionCharSequence();
        baseAssertion3.initialize(null);
        Assertions.assertThat(baseAssertion3.getActual()).isNull();
        Assertions.assertThat(baseAssertion3, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion3.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion3.initialize(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion3.as(Raw.charSequenceAssertion()).isNull();
        try {
            baseAssertion3.as(Raw.charSequenceAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<CharSequence> baseAssertion4 = createBaseAssertionCharSequence();
        baseAssertion4.initialize("value");
        Assertions.assertThat(baseAssertion4.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion4, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion4.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion4.initialize("value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion4.as(Raw.charSequenceAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        baseAssertion4.as(Raw.charSequenceAssertion()).isNotNull();

        BaseAssertion<CharSequence> baseAssertion5 = createBaseAssertionCharSequence();
        try {
            initializeWithRawActual(baseAssertion5, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeWithMessageTest() {
        BaseAssertion<Object> baseAssertion01 = createBaseAssertionObject();
        baseAssertion01.initialize(null, null);
        Assertions.assertThat(baseAssertion01.getActual()).isNull();
        Assertions.assertThat(baseAssertion01, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion01.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion01.initialize(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion01.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion01.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion02 = createBaseAssertionObject();
        baseAssertion02.initialize(new Object(), null);
        Assertions.assertThat(baseAssertion02.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion02, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion02.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion02.initialize(new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion02.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion02.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion03 = createBaseAssertionObject();
        baseAssertion03.initialize(null, "");
        Assertions.assertThat(baseAssertion03.getActual()).isNull();
        Assertions.assertThat(baseAssertion03, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion03.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion03.initialize(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        baseAssertion03.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion03.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion04 = createBaseAssertionObject();
        baseAssertion04.initialize(new Object(), "");
        Assertions.assertThat(baseAssertion04.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion04, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion04.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion04.initialize(new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }
        try {
            baseAssertion04.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion04.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion05 = createBaseAssertionObject();
        baseAssertion05.initialize(null, "Message");
        Assertions.assertThat(baseAssertion05.getActual()).isNull();
        Assertions.assertThat(baseAssertion05, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion05.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion05.initialize(null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }
        baseAssertion05.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion05.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion06 = createBaseAssertionObject();
        baseAssertion06.initialize(new Object(), "Message");
        Assertions.assertThat(baseAssertion06.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion06, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion06.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion06.initialize(new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }
        try {
            baseAssertion06.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion06.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion07 = createBaseAssertionObject();
        baseAssertion07.initialize(null, "value''s");
        Assertions.assertThat(baseAssertion07.getActual()).isNull();
        Assertions.assertThat(baseAssertion07, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion07.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion07.initialize(null, "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }
        baseAssertion07.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion07.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tActual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion08 = createBaseAssertionObject();
        baseAssertion08.initialize(new Object(), "value''s");
        Assertions.assertThat(baseAssertion08.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion08, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion08.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion08.initialize(new Object(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }
        try {
            baseAssertion08.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("value's.\n\tActual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion08.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<Object> baseAssertion09 = createBaseAssertionObject();
        baseAssertion09.initialize(null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion09.getActual()).isNull();
        Assertions.assertThat(baseAssertion09, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion09.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion09.initialize(null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }
        baseAssertion09.as(Raw.objectAssertion()).isNull();
        try {
            baseAssertion09.as(Raw.objectAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tActual value should not be null.");
        }

        BaseAssertion<Object> baseAssertion10 = createBaseAssertionObject();
        baseAssertion10.initialize(new Object(), "Message: {0}", true);
        Assertions.assertThat(baseAssertion10.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion10, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion10.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion10.initialize(new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }
        try {
            baseAssertion10.as(Raw.objectAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message: T.\n\tActual value should be null.\n\tActual:<java.lang.Object@.*>");
        }
        baseAssertion10.as(Raw.objectAssertion()).isNotNull();

        BaseAssertion<CharSequence> baseAssertion11 = createBaseAssertionCharSequence();
        baseAssertion11.initialize(null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion11.getActual()).isNull();
        Assertions.assertThat(baseAssertion11, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion11.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion11.initialize(null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }
        baseAssertion11.as(Raw.charSequenceAssertion()).isNull();
        try {
            baseAssertion11.as(Raw.charSequenceAssertion()).isNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tActual value should not be null.");
        }

        BaseAssertion<CharSequence> baseAssertion12 = createBaseAssertionCharSequence();
        baseAssertion12.initialize("value", "Message: {0}", true);
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12, "_failDescription").isNotNull();
        Assertions.assertThat(baseAssertion12.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion12.initialize("value", "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }
        try {
            baseAssertion12.as(Raw.charSequenceAssertion()).isNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tActual value should be null.\n\tActual:<value>");
        }
        baseAssertion12.as(Raw.charSequenceAssertion()).isNotNull();

        BaseAssertion<CharSequence> baseAssertion13 = createBaseAssertionCharSequence();
        try {
            initializeWithRawActual(baseAssertion13, new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void initializeAssertionTest() {
        BaseAssertion<Object> baseAssertion1 = createBaseAssertionObject(null, null);

        BaseAssertion<Object> baseAssertion11 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion11, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion11, null);
        Assertions.assertThat(baseAssertion11.getActual()).isNull();
        Assertions.assertThat(baseAssertion11.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion11, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion12 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion12, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion12, new Object());
        Assertions.assertThat(baseAssertion12.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion12.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion12, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion13 = createBaseAssertionCharSequence();
        try {
            createBaseAssertionCharSequence().initializeAssertion(baseAssertion13, "value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion13, "value");
        Assertions.assertThat(baseAssertion13.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion13.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion13, "value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertionObject(null, "");

        BaseAssertion<Object> baseAssertion21 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion21, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion2.initializeAssertion(baseAssertion21, null);
        Assertions.assertThat(baseAssertion21.getActual()).isNull();
        Assertions.assertThat(baseAssertion21.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion21, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion22 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion22, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion2.initializeAssertion(baseAssertion22, new Object());
        Assertions.assertThat(baseAssertion22.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion22.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion22, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion23 = createBaseAssertionCharSequence();
        try {
            createBaseAssertionCharSequence().initializeAssertion(baseAssertion23, "value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion2.initializeAssertion(baseAssertion23, "value");
        Assertions.assertThat(baseAssertion23.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion23.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion23, "value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertionObject(null, "Base message");

        BaseAssertion<Object> baseAssertion31 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion31, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion3.initializeAssertion(baseAssertion31, null);
        Assertions.assertThat(baseAssertion31.getActual()).isNull();
        Assertions.assertThat(baseAssertion31.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion31, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion32 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion32, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion3.initializeAssertion(baseAssertion32, new Object());
        Assertions.assertThat(baseAssertion32.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion32.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion32, new Object());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion33 = createBaseAssertionCharSequence();
        try {
            createBaseAssertionCharSequence().initializeAssertion(baseAssertion33, "value");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion3.initializeAssertion(baseAssertion33, "value");
        Assertions.assertThat(baseAssertion33.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion33.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion33, "value");
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
        BaseAssertion<Object> baseAssertion1 = createBaseAssertionObject(null, null);

        BaseAssertion<Object> baseAssertion101 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion101, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion101, null, null);
        Assertions.assertThat(baseAssertion101.getActual()).isNull();
        Assertions.assertThat(baseAssertion101.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion101, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion102 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion102, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion102, new Object(), null);
        Assertions.assertThat(baseAssertion102.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion102.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion102, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion103 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion103, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion103, null, "");
        Assertions.assertThat(baseAssertion103.getActual()).isNull();
        Assertions.assertThat(baseAssertion103.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion103, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion104 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion104, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion104, new Object(), "");
        Assertions.assertThat(baseAssertion104.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion104.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion1.initializeAssertion(baseAssertion104, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion105 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion105, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion105, null, "Message");
        Assertions.assertThat(baseAssertion105.getActual()).isNull();
        Assertions.assertThat(baseAssertion105.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion105, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion106 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion106, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion106, new Object(), "Message");
        Assertions.assertThat(baseAssertion106.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion106.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion106, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion107 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion107, null, "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion107, null, "value''s");
        Assertions.assertThat(baseAssertion107.getActual()).isNull();
        Assertions.assertThat(baseAssertion107.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion107, null, "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion108 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion108, new Object(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion108, new Object(), "value''s");
        Assertions.assertThat(baseAssertion108.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion108.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion108, new Object(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion109 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion109, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion109, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion109.getActual()).isNull();
        Assertions.assertThat(baseAssertion109.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion109, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion110 = createBaseAssertionObject();
        try {
            createBaseAssertionObject().initializeAssertion(baseAssertion110, new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion110, new Object(), "Message: {0}", true);
        Assertions.assertThat(baseAssertion110.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion110.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion110, new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion111 = createBaseAssertionCharSequence();
        try {
            createBaseAssertionCharSequence().initializeAssertion(baseAssertion111, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion111, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion111.getActual()).isNull();
        Assertions.assertThat(baseAssertion111.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion111, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion112 = createBaseAssertionCharSequence();
        try {
            createBaseAssertionCharSequence().initializeAssertion(baseAssertion112, "value", "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        baseAssertion1.initializeAssertion(baseAssertion112, "value", "Message: {0}", true);
        Assertions.assertThat(baseAssertion112.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion112.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion1.initializeAssertion(baseAssertion112, "vallue", "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion2 = createBaseAssertionObject(null, "");

        BaseAssertion<Object> baseAssertion201 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion201, null, null);
        Assertions.assertThat(baseAssertion201.getActual()).isNull();
        Assertions.assertThat(baseAssertion201.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion201, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion202 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion202, new Object(), null);
        Assertions.assertThat(baseAssertion202.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion202.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion202, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion203 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion203, null, "");
        Assertions.assertThat(baseAssertion203.getActual()).isNull();
        Assertions.assertThat(baseAssertion203.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion203, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion204 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion204, new Object(), "");
        Assertions.assertThat(baseAssertion204.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion204.getAssertionErrorBuilder().build().getMessage()).isEmpty();
        try {
            baseAssertion2.initializeAssertion(baseAssertion204, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion205 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion205, null, "Message");
        Assertions.assertThat(baseAssertion205.getActual()).isNull();
        Assertions.assertThat(baseAssertion205.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion205, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion206 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion206, new Object(), "Message");
        Assertions.assertThat(baseAssertion206.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion206.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion206, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion207 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion207, null, "value''s");
        Assertions.assertThat(baseAssertion207.getActual()).isNull();
        Assertions.assertThat(baseAssertion207.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion207, null, "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion208 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion208, new Object(), "value''s");
        Assertions.assertThat(baseAssertion208.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion208.getAssertionErrorBuilder().build().getMessage()).isEqualTo("value's.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion208, new Object(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion209 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion209, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion209.getActual()).isNull();
        Assertions.assertThat(baseAssertion209.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion209, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion210 = createBaseAssertionObject();
        baseAssertion2.initializeAssertion(baseAssertion210, new Object(), "Message: {0}", true);
        Assertions.assertThat(baseAssertion210.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion210.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion210, new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion211 = createBaseAssertionCharSequence();
        baseAssertion2.initializeAssertion(baseAssertion211, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion211.getActual()).isNull();
        Assertions.assertThat(baseAssertion211.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion211, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion212 = createBaseAssertionCharSequence();
        baseAssertion2.initializeAssertion(baseAssertion212, "value", "Message: {0}", true);
        Assertions.assertThat(baseAssertion212.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion212.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message: T.");
        try {
            baseAssertion2.initializeAssertion(baseAssertion212, "value", "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion3 = createBaseAssertionObject(null, "Base message");

        BaseAssertion<Object> baseAssertion301 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion301, null, null);
        Assertions.assertThat(baseAssertion301.getActual()).isNull();
        Assertions.assertThat(baseAssertion301.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion301, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion302 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion302, new Object(), null);
        Assertions.assertThat(baseAssertion302.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion302.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion302, new Object(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion303 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion303, null, "");
        Assertions.assertThat(baseAssertion303.getActual()).isNull();
        Assertions.assertThat(baseAssertion303.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion303, null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion304 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion304, new Object(), "");
        Assertions.assertThat(baseAssertion304.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion304.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion304, new Object(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion305 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion305, null, "Message");
        Assertions.assertThat(baseAssertion305.getActual()).isNull();
        Assertions.assertThat(baseAssertion305.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion305, null, "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion306 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion306, new Object(), "Message");
        Assertions.assertThat(baseAssertion306.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion306.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion306, new Object(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion307 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion307, null, "value''s");
        Assertions.assertThat(baseAssertion307.getActual()).isNull();
        Assertions.assertThat(baseAssertion307.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tvalue's.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion307, null, "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tvalue's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion308 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion308, new Object(), "value''s");
        Assertions.assertThat(baseAssertion308.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion308.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tvalue's.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion308, new Object(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tvalue's.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion309 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion309, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion309.getActual()).isNull();
        Assertions.assertThat(baseAssertion309.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: T.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion309, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<Object> baseAssertion310 = createBaseAssertionObject();
        baseAssertion3.initializeAssertion(baseAssertion310, new Object(), "Message: {0}", true);
        Assertions.assertThat(baseAssertion310.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion310.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: T.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion310, new Object(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion311 = createBaseAssertionCharSequence();
        baseAssertion3.initializeAssertion(baseAssertion311, null, "Message: {0}", true);
        Assertions.assertThat(baseAssertion311.getActual()).isNull();
        Assertions.assertThat(baseAssertion311.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: T.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion311, null, "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\n\tAssertion should not be initialized.");
        }

        BaseAssertion<CharSequence> baseAssertion312 = createBaseAssertionCharSequence();
        baseAssertion3.initializeAssertion(baseAssertion312, "value", "Message: {0}", true);
        Assertions.assertThat(baseAssertion312.getActual()).isNotNull();
        Assertions.assertThat(baseAssertion312.getAssertionErrorBuilder().build().getMessage()).isEqualTo("Base message.\n\tMessage: T.");
        try {
            baseAssertion3.initializeAssertion(baseAssertion312, "value", "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\n\tAssertion should not be initialized.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void matcherAssertionTest() {
        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue());
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()));
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()));
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue());
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
        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue(), "value''s");
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "value''s");
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.nullValue(), "Message: {0}", true);
        try {
            createBaseAssertionObject().matcherAssertion(null, Matchers.nullValue(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message: {0}", true);
        try {
            createBaseAssertionObject().matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null, null).matcherAssertion("value", Matchers.nullValue(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue(), "value''s");
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "value''s");
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.nullValue(), "Message: {0}", true);
        try {
            createBaseAssertionObject(null, "").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message: {0}", true);
        try {
            createBaseAssertionObject(null, "").matcherAssertion("value", Matchers.nullValue(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message: T.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue(), null);
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), null);
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue(), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "Message");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "Message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "value''s");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tvalue's.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "value''s");
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "value''s");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tvalue's.\nExpected: null\n     but: was \"value\"");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.nullValue(), "Message: {0}", true);
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion(null, Matchers.not(Matchers.nullValue()), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\nExpected: not null\n     but: was null");
        }

        createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.not(Matchers.nullValue()), "Message: {0}", true);
        try {
            createBaseAssertionObject(null, "Base message").matcherAssertion("value", Matchers.nullValue(), "Message: {0}", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Base message.\n\tMessage: T.\nExpected: null\n     but: was \"value\"");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asTest() {
        Object object = new Object();

        Assertions.assertThat(createBaseAssertionObject(null).as(createBaseAssertionObject()).getActual()).isNull();
        Assertions.assertThat(createBaseAssertionObject(null, "Message").as(createBaseAssertionObject()).getActual()).isNull();
        try {
            createBaseAssertionObject().as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: assertion.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").as(null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: assertion.");
        }

        createBaseAssertionObject(object).as(Raw.objectAssertion()).isSameAs(object);
        createBaseAssertionObject(object, "Message").as(Raw.objectAssertion()).isSameAs(object);
        try {
            createBaseAssertionObject(object).as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertionObject(object, "Message").as(Raw.objectAssertion()).isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }

        BaseAssertion<Object> baseAssertion = createBaseAssertionObject(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject())).isInstanceOf(BaseAssertion.class);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject())).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject()).getActual()).isSameAs(object);

        ObjectAssertion objectAssertion = createBaseAssertionObject(object).as(Raw.objectAssertion());
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

        Assertions.assertThat(createBaseAssertionObject(null).as(createBaseAssertionObject(), "As message").getActual()).isNull();
        Assertions.assertThat(createBaseAssertionObject(null, "Message").as(createBaseAssertionObject(), "As message").getActual()).isNull();
        try {
            createBaseAssertionObject().as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: assertion.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").as(null, "As message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: assertion.");
        }

        createBaseAssertionObject(object).as(Raw.objectAssertion(), "As message").isSameAs(object);
        createBaseAssertionObject(object, "Message").as(Raw.objectAssertion(), "As message").isSameAs(object);
        try {
            createBaseAssertionObject(object).as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("As message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertionObject(object, "Message").as(Raw.objectAssertion(), "As message").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tAs message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertionObject(object).as(Raw.objectAssertion(), "value''s").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("value''s.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }
        try {
            createBaseAssertionObject(object, "Message").as(Raw.objectAssertion(), "value''s").isNotSameAs(object);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tvalue''s.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object.*>");
        }

        BaseAssertion<Object> baseAssertion = createBaseAssertionObject(object);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject(), "As message")).isInstanceOf(BaseAssertion.class);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject(), "As message")).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(createBaseAssertionObject(), "As message").getActual()).isSameAs(object);

        ObjectAssertion objectAssertion = createBaseAssertionObject(object).as(Raw.objectAssertion(), "As message");
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message")).hasClass(ObjectAssertion.class);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message")).isNotSameAs(objectAssertion);
        Assertions.assertThat(objectAssertion.as(Raw.objectAssertion(), "As message").getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asPrimitiveAssertionTest() {
        createBaseAssertionObject((byte) 10).as(Raw.byteAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertionObject((byte) 10).as(Raw.byteAssertion()).getActual()).hasClass(Byte.class);
        initialize(Raw.byteAssertion(), (byte) 10).as(Raw.byteAssertion()).isEqualTo(10);
        try {
            createBaseAssertionObject(new Object()).as(Raw.byteAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Byte> but was:<java.lang.Object>");
        }

        createBaseAssertionObject((short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertionObject((short) 10).as(Raw.shortAssertion()).getActual()).hasClass(Short.class);
        initialize(Raw.shortAssertion(), (short) 10).as(Raw.shortAssertion()).isEqualTo(10);
        try {
            createBaseAssertionObject(new Object()).as(Raw.shortAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Short> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(10).as(Raw.intAssertion()).isEqualTo(10);
        Assertions.assertThat(createBaseAssertionObject(10).as(Raw.intAssertion()).getActual()).hasClass(Integer.class);
        initialize(Raw.intAssertion(), 10).as(Raw.intAssertion()).isEqualTo(10);
        try {
            createBaseAssertionObject(new Object()).as(Raw.intAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Integer> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(10L).as(Raw.longAssertion()).isEqualTo(10L);
        Assertions.assertThat(createBaseAssertionObject(10L).as(Raw.longAssertion()).getActual()).hasClass(Long.class);
        initialize(Raw.longAssertion(), 10L).as(Raw.longAssertion()).isEqualTo(10L);
        try {
            createBaseAssertionObject(new Object()).as(Raw.longAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Long> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        Assertions.assertThat(createBaseAssertionObject(10.0f).as(Raw.floatAssertion()).getActual()).hasClass(Float.class);
        initialize(Raw.floatAssertion(), 10.0f).as(Raw.floatAssertion()).isEqualTo(10.0f, 0.01f);
        try {
            createBaseAssertionObject(new Object()).as(Raw.floatAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Float> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        Assertions.assertThat(createBaseAssertionObject(10.0).as(Raw.doubleAssertion()).getActual()).hasClass(Double.class);
        initialize(Raw.doubleAssertion(), 10.0).as(Raw.doubleAssertion()).isEqualTo(10.0, 0.01);
        try {
            createBaseAssertionObject(new Object()).as(Raw.doubleAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Double> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(true).as(Raw.booleanAssertion()).isTrue();
        Assertions.assertThat(createBaseAssertionObject(true).as(Raw.booleanAssertion()).getActual()).hasClass(Boolean.class);
        initialize(Raw.booleanAssertion(), true).as(Raw.booleanAssertion()).isTrue();
        try {
            createBaseAssertionObject(new Object()).as(Raw.booleanAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Boolean> but was:<java.lang.Object>");
        }

        createBaseAssertionObject('c').as(Raw.charAssertion()).isEqualTo(99);
        Assertions.assertThat(createBaseAssertionObject('c').as(Raw.charAssertion()).getActual()).hasClass(Character.class);
        initialize(Raw.charAssertion(), 'c').as(Raw.charAssertion()).isEqualTo(99);
        try {
            createBaseAssertionObject(new Object()).as(Raw.charAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Character> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asArrayAssertionTest() {
        createBaseAssertionObject(new byte[]{}).as(Raw.byteArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new byte[]{}).as(Raw.byteArrayAssertion()).getActual()).hasClass(byte[].class);
        initialize(Raw.byteArrayAssertion(), new byte[]{}).as(Raw.byteArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.byteArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[B> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new short[]{}).as(Raw.shortArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new short[]{}).as(Raw.shortArrayAssertion()).getActual()).hasClass(short[].class);
        initialize(Raw.shortArrayAssertion(), new short[]{}).as(Raw.shortArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.shortArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[S> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new int[]{}).as(Raw.intArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new int[]{}).as(Raw.intArrayAssertion()).getActual()).hasClass(int[].class);
        initialize(Raw.intArrayAssertion(), new int[]{}).as(Raw.intArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.intArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[I> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new long[]{}).as(Raw.longArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new long[]{}).as(Raw.longArrayAssertion()).getActual()).hasClass(long[].class);
        initialize(Raw.longArrayAssertion(), new long[]{}).as(Raw.longArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.longArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[J> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new float[]{}).as(Raw.floatArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new float[]{}).as(Raw.floatArrayAssertion()).getActual()).hasClass(float[].class);
        initialize(Raw.floatArrayAssertion(), new float[]{}).as(Raw.floatArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.floatArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[F> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new double[]{}).as(Raw.doubleArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new double[]{}).as(Raw.doubleArrayAssertion()).getActual()).hasClass(double[].class);
        initialize(Raw.doubleArrayAssertion(), new double[]{}).as(Raw.doubleArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.doubleArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[D> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new boolean[]{}).as(Raw.booleanArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new boolean[]{}).as(Raw.booleanArrayAssertion()).getActual()).hasClass(boolean[].class);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).as(Raw.booleanArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.booleanArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Z> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new char[]{}).as(Raw.charArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new char[]{}).as(Raw.charArrayAssertion()).getActual()).hasClass(char[].class);
        initialize(Raw.charArrayAssertion(), new char[]{}).as(Raw.charArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.charArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[C> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(new String[]{}).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        Assertions.assertThat(createBaseAssertionObject(new String[]{}).as(Raw.<String>objectArrayAssertion()).getActual()).hasClass(String[].class);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).as(Raw.<String>objectArrayAssertion()).hasLength(0);
        try {
            createBaseAssertionObject(new Object()).as(Raw.<String>objectArrayAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Ljava.lang.Object;> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asCollectionAssertionTest() {
        createBaseAssertionObject(DataHelper.<String>createArrayList()).as(Raw.<String>listAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).as(Raw.<String>listAssertion()).isEmpty();
        try {
            createBaseAssertionObject(new Object()).as(Raw.<String>listAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.List> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(DataHelper.<String>createArrayList()).as(Raw.<String>iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createArrayList()).as(Raw.<String>listAssertion())).hasClass(ListAssertion.class);
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createArrayList()).as(Raw.<String>listAssertion()).isEmpty();

        createBaseAssertionObject(DataHelper.createHashSet()).as(Raw.setAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.setAssertion(), DataHelper.createHashSet()).as(Raw.setAssertion())).hasClass(SetAssertion.class);
        initialize(Raw.setAssertion(), DataHelper.createHashSet()).as(Raw.setAssertion()).isEmpty();
        try {
            createBaseAssertionObject(new Object()).as(Raw.setAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Set> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(DataHelper.createHashSet()).as(Raw.iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.iterableAssertion(), DataHelper.createHashSet()).as(Raw.setAssertion())).hasClass(SetAssertion.class);
        initialize(Raw.iterableAssertion(), DataHelper.createHashSet()).as(Raw.setAssertion()).isEmpty();

        createBaseAssertionObject(DataHelper.createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.sortedSetAssertion(), DataHelper.createTreeSet()).as(Raw.sortedSetAssertion())).hasClass(SortedSetAssertion.class);
        initialize(Raw.sortedSetAssertion(), DataHelper.createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
        try {
            createBaseAssertionObject(new Object()).as(Raw.sortedSetAssertion());
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.SortedSet> but was:<java.lang.Object>");
        }

        createBaseAssertionObject(DataHelper.createTreeSet()).as(Raw.iterableAssertion()).isEmpty();
        Assertions.assertThat(initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).as(Raw.sortedSetAssertion())).hasClass(SortedSetAssertion.class);
        initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).as(Raw.sortedSetAssertion()).isEmpty();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void convertValueTest() {
        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), null, List.class)).isInstanceOf(List.class);
        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), null, List.class)).isNotInstanceOf(Set.class);

        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), new ConversionExceptionHolder(), List.class)).isInstanceOf(List.class);
        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), new ConversionExceptionHolder(), List.class)).isNotInstanceOf(Set.class);

        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), null, Map.class)).isInstanceOf(Set.class);
        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), null, Map.class)).isNotInstanceOf(Map.class);

        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), new ConversionExceptionHolder(), Map.class)).isInstanceOf(Set.class);
        Assertions.assertThat(createBaseAssertionObject(null).convertValue(DataHelper.createHashSet("value1", "value2"), new ConversionExceptionHolder(), Map.class)).isNotInstanceOf(Map.class);

        try {
            createBaseAssertionObject().convertValue(DataHelper.createHashSet("value1", "value2"), null, List.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject().convertValue(DataHelper.createHashSet("value1", "value2"), new ConversionExceptionHolder(), List.class);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }

        try {
            createBaseAssertionObject(null, null).convertValue(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), null, byte[].class, 1);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            createBaseAssertionObject(null, "Message").convertValue(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), null, byte[].class, 1);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }

        ConversionExceptionHolder conversionExceptionHolder1 = new ConversionExceptionHolder();
        Assertions.assertThat(createBaseAssertionObject(null, null).convertValue(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), conversionExceptionHolder1, byte[].class, 1)).isNull();
        Assertions.assertThat(conversionExceptionHolder1.getConversionException()).hasCause(IOException.class);
        Assertions.assertThat(conversionExceptionHolder1.getConversionException()).hasCauseMessage("read exception");

        ConversionExceptionHolder conversionExceptionHolder2 = new ConversionExceptionHolder();
        Assertions.assertThat(createBaseAssertionObject(null, "Message").convertValue(DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), conversionExceptionHolder2, byte[].class, 1)).isNull();
        Assertions.assertThat(conversionExceptionHolder2.getConversionException()).hasCause(IOException.class);
        Assertions.assertThat(conversionExceptionHolder2.getConversionException()).hasCauseMessage("read exception");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualIsNotNullTest() {
        createBaseAssertionObject(new Object()).checkActualIsNotNull();
        createBaseAssertionObject("test").checkActualIsNotNull();

        try {
            createBaseAssertionObject().checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(null).checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createBaseAssertionObject(null, "Message").checkActualIsNotNull();
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualPropertyIsNotNullTest() {
        createBaseAssertionObject(null).checkActualPropertyIsNotNull(new Object(), null);
        createBaseAssertionObject(null).checkActualPropertyIsNotNull(new Object(), "");
        createBaseAssertionObject(null).checkActualPropertyIsNotNull(new Object(), "arg");

        createBaseAssertionObject(null).checkActualPropertyIsNotNull("test", null);
        createBaseAssertionObject(null).checkActualPropertyIsNotNull("test", "");
        createBaseAssertionObject(null).checkActualPropertyIsNotNull("test", "arg");

        createBaseAssertionObject(null).checkActualPropertyIsNotNull(1, null);
        createBaseAssertionObject(null).checkActualPropertyIsNotNull(1, "");
        createBaseAssertionObject(null).checkActualPropertyIsNotNull(1, "arg");

        try {
            createBaseAssertionObject().checkActualPropertyIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkActualPropertyIsNotNull(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value's property should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkActualPropertyIsNotNull(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value's property should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkActualPropertyIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value's property should not be null: .");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkActualPropertyIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value's property should not be null: .");
        }
        try {
            createBaseAssertionObject(new Object()).checkActualPropertyIsNotNull(null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value's property should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkActualPropertyIsNotNull(null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value's property should not be null: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotNullTest() {
        createBaseAssertionObject(null).checkArgumentIsNotNull(new Object(), null);
        createBaseAssertionObject(null).checkArgumentIsNotNull(new Object(), "");
        createBaseAssertionObject(null).checkArgumentIsNotNull(new Object(), "arg");

        createBaseAssertionObject(null).checkArgumentIsNotNull("test", null);
        createBaseAssertionObject(null).checkArgumentIsNotNull("test", "");
        createBaseAssertionObject(null).checkArgumentIsNotNull("test", "arg");

        createBaseAssertionObject(null).checkArgumentIsNotNull(1, null);
        createBaseAssertionObject(null).checkArgumentIsNotNull(1, "");
        createBaseAssertionObject(null).checkArgumentIsNotNull(1, "arg");

        try {
            createBaseAssertionObject().checkArgumentIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotNull(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotNull(null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: .");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotNull(null, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: .");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotNull(null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotNull(null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyTest() {
        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, null, true);
        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, "", true);
        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, "arg", true);

        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, null, false);
        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, "", false);
        createBaseAssertionObject(null).checkArgumentIsNotEmpty(false, "arg", false);

        try {
            createBaseAssertionObject().checkArgumentIsNotEmpty(false, "", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject().checkArgumentIsNotEmpty(false, "", false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, null, true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: <NULL>.\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, null, true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: <NULL>.\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, "", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: .\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, "", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: .\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, "arg", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: arg.\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, "arg", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: arg.\n\tThe result is always true.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, null, false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: <NULL>.\n\tThe result is always false.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, null, false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: <NULL>.\n\tThe result is always false.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, "", false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: .\n\tThe result is always false.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, "", false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: .\n\tThe result is always false.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsNotEmpty(true, "arg", false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: arg.\n\tThe result is always false.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsNotEmpty(true, "arg", false);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: arg.\n\tThe result is always false.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsFiniteFloatPrimitiveTest() {
        createBaseAssertionObject(null).checkArgumentIsFinite(0.0f, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(0.0f, "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(10.0f, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(10.0f, "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(-10.0f, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(-10.0f, "arg");

        try {
            createBaseAssertionObject().checkArgumentIsFinite(0.0f, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.NaN, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.NaN, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.NaN, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.NaN, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.POSITIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.POSITIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.NEGATIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.NEGATIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsFiniteFloatObjectTest() {
        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("0.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("0.0"), "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("10.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("10.0"), "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("-10.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Float.valueOf("-10.0"), "arg");

        try {
            createBaseAssertionObject().checkArgumentIsFinite(Float.valueOf("0.0"), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite((Float) null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite((Float) null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite((Float) null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite((Float) null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.valueOf("NaN"), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.valueOf("NaN"), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.valueOf("NaN"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.valueOf("NaN"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.valueOf("Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.valueOf("Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Float.valueOf("-Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Float.valueOf("-Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsFiniteDoublePrimitiveTest() {
        createBaseAssertionObject(null).checkArgumentIsFinite(0.0, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(0.0, "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(10.0, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(10.0, "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(-10.0, "");
        createBaseAssertionObject(null).checkArgumentIsFinite(-10.0, "arg");

        try {
            createBaseAssertionObject().checkArgumentIsFinite(0.0, "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.NaN, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.NaN, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.NaN, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.NaN, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.POSITIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.POSITIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.NEGATIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.NEGATIVE_INFINITY, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsFiniteDoubleObjectTest() {
        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("0.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("0.0"), "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("10.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("10.0"), "arg");

        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("-10.0"), "");
        createBaseAssertionObject(null).checkArgumentIsFinite(Double.valueOf("-10.0"), "arg");

        try {
            createBaseAssertionObject().checkArgumentIsFinite(Double.valueOf("0.0"), "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite((Double) null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite((Double) null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite((Double) null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite((Double) null, "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.valueOf("NaN"), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.valueOf("NaN"), null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.valueOf("NaN"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.valueOf("NaN"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.valueOf("Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.valueOf("Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsFinite(Double.valueOf("-Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsFinite(Double.valueOf("-Infinity"), "arg");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: arg.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsValidBooleanTest() {
        createBaseAssertionObject(null).checkArgumentIsValid(true, null, null);
        createBaseAssertionObject(null).checkArgumentIsValid(true, "", null);
        createBaseAssertionObject(null).checkArgumentIsValid(true, "arg", null);

        createBaseAssertionObject(null).checkArgumentIsValid(true, "arg", "");
        createBaseAssertionObject(null).checkArgumentIsValid(true, "arg", "message");
        createBaseAssertionObject(null).checkArgumentIsValid(true, "arg", "message.");
        createBaseAssertionObject(null).checkArgumentIsValid(true, "arg", "message: {0}.", true);

        try {
            createBaseAssertionObject().checkArgumentIsValid(false, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: <NULL>.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: .");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: .");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.");
        }

        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "arg", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "arg", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "arg", "message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "arg", "message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "arg", "message.");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "arg", "message.");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage.");
        }
        try {
            createBaseAssertionObject(new Object()).checkArgumentIsValid(false, "arg", "message: {0}.", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage: T.");
        }
        try {
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(false, "arg", "message: {0}.", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage: T.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsValidConversionExceptionHolderTest() {
        createBaseAssertionObject(null).checkArgumentIsValid(null, null, null);
        createBaseAssertionObject(null).checkArgumentIsValid(null, "", null);
        createBaseAssertionObject(null).checkArgumentIsValid(null, "arg", null);

        createBaseAssertionObject(null).checkArgumentIsValid(null, "arg", "");
        createBaseAssertionObject(null).checkArgumentIsValid(null, "arg", "message");
        createBaseAssertionObject(null).checkArgumentIsValid(null, "arg", "message.");
        createBaseAssertionObject(null).checkArgumentIsValid(null, "arg", "message: {0}.", true);

        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), null, null);
        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "", null);
        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "arg", null);

        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "arg", "");
        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "arg", "message");
        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "arg", "message.");
        createBaseAssertionObject(null).checkArgumentIsValid(new ConversionExceptionHolder(), "arg", "message: {0}.", true);

        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject().checkArgumentIsValid(conversionExceptionHolder, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: <NULL>.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, null, null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: <NULL>.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: .\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: .\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "arg", null);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "arg", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "arg", "");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "arg", "message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "arg", "message");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "arg", "message.");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "arg", "message.");
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object()).checkArgumentIsValid(conversionExceptionHolder, "arg", "message: {0}.", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: arg.\n\tmessage: T.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
        try {
            ConversionExceptionHolder conversionExceptionHolder = new ConversionExceptionHolder();
            conversionExceptionHolder.setConversionException(new ConversionException(new IOException("IO ex")));
            createBaseAssertionObject(new Object(), "Message").checkArgumentIsValid(conversionExceptionHolder, "arg", "message: {0}.", true);
            Assertions.fail("BaseAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: arg.\n\tmessage: T.\n\tjava.io.IOException: IO ex.");
            Assertions.assertThat(ex).hasCause(IOException.class);
            Assertions.assertThat(ex).hasCauseMessage("IO ex");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getAssertionErrorBuilderTest() {
        Assertions.assertThat(createBaseAssertionObject().getAssertionErrorBuilder().build().getMessage()).isEqualTo("");
        Assertions.assertThat(createBaseAssertionObject(null, null).getAssertionErrorBuilder().build().getMessage()).isEqualTo("");
        Assertions.assertThat(createBaseAssertionObject(null, "Message").getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
        Assertions.assertThat(createBaseAssertionObject(null, "Message.").getAssertionErrorBuilder().build().getMessage()).isEqualTo("Message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void messageReuseTest() {
        BaseAssertion<Object> assertion11 = createBaseAssertionObject(null, null);
        Assertions.assertThat(assertion11.getAssertionErrorBuilder().build()).hasMessage("");

        BaseAssertion<Object> assertion12 = createBaseAssertionObject();
        assertion11.initializeAssertion(assertion12, null);
        Assertions.assertThat(assertion12.getAssertionErrorBuilder().build()).hasMessage("");

        BaseAssertion<Object> assertion13 = createBaseAssertionObject();
        assertion11.initializeAssertion(assertion13, null);
        Assertions.assertThat(assertion13.getAssertionErrorBuilder().build()).hasMessage("");

        BaseAssertion<Object> assertion14 = createBaseAssertionObject();
        assertion13.initializeAssertion(assertion14, null);
        Assertions.assertThat(assertion14.getAssertionErrorBuilder().build()).hasMessage("");

        BaseAssertion<Object> assertion15 = createBaseAssertionObject();
        assertion11.initializeAssertion(assertion15, null, "Message 1");
        Assertions.assertThat(assertion15.getAssertionErrorBuilder().build()).hasMessage("Message 1.");

        BaseAssertion<Object> assertion16 = createBaseAssertionObject();
        assertion15.initializeAssertion(assertion16, null, "Message 2");
        Assertions.assertThat(assertion16.getAssertionErrorBuilder().build()).hasMessage("Message 1.\n\tMessage 2.");

        BaseAssertion<Object> assertion17 = createBaseAssertionObject();
        assertion15.initializeAssertion(assertion17, null, "Message 3");
        Assertions.assertThat(assertion17.getAssertionErrorBuilder().build()).hasMessage("Message 1.\n\tMessage 3.");

        BaseAssertion<Object> assertion18 = createBaseAssertionObject();
        assertion17.initializeAssertion(assertion18, null, "Message 4");
        Assertions.assertThat(assertion18.getAssertionErrorBuilder().build()).hasMessage("Message 1.\n\tMessage 3.\n\tMessage 4.");

        BaseAssertion<Object> assertion19 = createBaseAssertionObject();
        assertion17.initializeAssertion(assertion19, null, "Message 5");
        Assertions.assertThat(assertion19.getAssertionErrorBuilder().build()).hasMessage("Message 1.\n\tMessage 3.\n\tMessage 5.");

        BaseAssertion<Object> assertion21 = createBaseAssertionObject(null, "Base message");
        Assertions.assertThat(assertion21.getAssertionErrorBuilder().build()).hasMessage("Base message.");

        BaseAssertion<Object> assertion22 = createBaseAssertionObject();
        assertion21.initializeAssertion(assertion22, null);
        Assertions.assertThat(assertion22.getAssertionErrorBuilder().build()).hasMessage("Base message.");

        BaseAssertion<Object> assertion23 = createBaseAssertionObject();
        assertion21.initializeAssertion(assertion23, null);
        Assertions.assertThat(assertion23.getAssertionErrorBuilder().build()).hasMessage("Base message.");

        BaseAssertion<Object> assertion24 = createBaseAssertionObject();
        assertion23.initializeAssertion(assertion24, null);
        Assertions.assertThat(assertion24.getAssertionErrorBuilder().build()).hasMessage("Base message.");

        BaseAssertion<Object> assertion25 = createBaseAssertionObject();
        assertion21.initializeAssertion(assertion25, null, "Message 1");
        Assertions.assertThat(assertion25.getAssertionErrorBuilder().build()).hasMessage("Base message.\n\tMessage 1.");

        BaseAssertion<Object> assertion26 = createBaseAssertionObject();
        assertion25.initializeAssertion(assertion26, null, "Message 2");
        Assertions.assertThat(assertion26.getAssertionErrorBuilder().build()).hasMessage("Base message.\n\tMessage 1.\n\tMessage 2.");

        BaseAssertion<Object> assertion27 = createBaseAssertionObject();
        assertion25.initializeAssertion(assertion27, null, "Message 3");
        Assertions.assertThat(assertion27.getAssertionErrorBuilder().build()).hasMessage("Base message.\n\tMessage 1.\n\tMessage 3.");

        BaseAssertion<Object> assertion28 = createBaseAssertionObject();
        assertion27.initializeAssertion(assertion28, null, "Message 4");
        Assertions.assertThat(assertion28.getAssertionErrorBuilder().build()).hasMessage("Base message.\n\tMessage 1.\n\tMessage 3.\n\tMessage 4.");

        BaseAssertion<Object> assertion29 = createBaseAssertionObject();
        assertion27.initializeAssertion(assertion29, null, "Message 5");
        Assertions.assertThat(assertion29.getAssertionErrorBuilder().build()).hasMessage("Base message.\n\tMessage 1.\n\tMessage 3.\n\tMessage 5.");
    }

    private BaseAssertion<Object> createBaseAssertionObject() {
        return new BaseAssertionObjectImpl();
    }

    private BaseAssertion<Object> createBaseAssertionObject(final Object actual) {
        return initialize(createBaseAssertionObject(), actual);
    }

    private BaseAssertion<Object> createBaseAssertionObject(final Object actual, final String message) {
        return initialize(createBaseAssertionObject(), actual, message);
    }

    private BaseAssertion<CharSequence> createBaseAssertionCharSequence() {
        return new BaseAssertionCharSequenceImpl();
    }

    private static final class BaseAssertionObjectImpl extends BaseAssertion<Object> {

        BaseAssertionObjectImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

    }

    private static final class BaseAssertionCharSequenceImpl extends BaseAssertion<CharSequence> {

        BaseAssertionCharSequenceImpl() {
            super();
        }

        @Override
        protected Class<CharSequence> getActualValueClass() {
            return CharSequence.class;
        }

    }

}
