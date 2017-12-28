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

import org.junit.Test;

/**
 * Tests for {@link FailDescription}.
 *
 * @author Dmitry Shapovalov
 */
public final class FailDescriptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FailDescriptionTest() {
        super();
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void getFullMessageTest() {
        Assertions.assertThat(FailDescription.getFullMessage(null)).isEqualTo("");
        Assertions.assertThat(FailDescription.getFullMessage("")).isEqualTo("");
        Assertions.assertThat(FailDescription.getFullMessage(" ")).isEqualTo(" .");
        Assertions.assertThat(FailDescription.getFullMessage("message")).isEqualTo("message.");
        Assertions.assertThat(FailDescription.getFullMessage("message.")).isEqualTo("message.");
        Assertions.assertThat(FailDescription.getFullMessage("message?")).isEqualTo("message?");
        Assertions.assertThat(FailDescription.getFullMessage("message!")).isEqualTo("message!");
        Assertions.assertThat(FailDescription.getFullMessage("message:")).isEqualTo("message:.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorTest() {
        Assertions.assertThat(new FailDescription().createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription().createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription((String) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription("").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").createAssertionError()).hasMessage("message1.\n\tmessage2.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).createAssertionError()).hasMessage("message1.\n\tmessage2: null.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").createAssertionError()).hasMessage("message1.\n\tmessage2: .");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").createAssertionError()).hasMessage("message1.\n\tmessage2: , .");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).hasMessage("message.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).createAssertionError()).hasMessage("message.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion);
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedRangeTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null:Value2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<Value1:null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedRangeTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null:Value2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<Value1:null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new FailDescription().addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription().addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription((String) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription("").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndThrowableTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tActual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tActual:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedAndThrowableTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedRangeAndThrowableTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription((String) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null:Value2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<Value1:null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedAndThrowableTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedRangeAndThrowableTest() {
        BaseAssertion<Object> baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((String) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), null, "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object[]) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", new Object[0]).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: .\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: parameter.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", (Object) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: {0}.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "'message2: {0}'", "parameter").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: null, null.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", null, null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: , .\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", "", "").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2: 12345678, true.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2: {0}, {1}", 12345678, true).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<null:Value2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<Value1:null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1.\n\tmessage2.\n\tExpected:<expectedValue1:expectedValue2> but was:<actualValue>");
    }

}
