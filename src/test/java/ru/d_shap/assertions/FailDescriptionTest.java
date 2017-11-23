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
    public void createAssertionErrorTest() {
        Assertions.assertThat(new FailDescription().createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription().createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").createAssertionError()).hasMessage("message?");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").createAssertionError()).hasMessage("message!");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").createAssertionError()).hasMessage("message:.");
        Assertions.assertThat(new FailDescription("message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription((FailDescription) null).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(null, "message").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").createAssertionError()).hasMessage("message1. message2.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2.");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).createAssertionError()).hasMessage("message? Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).createAssertionError()).hasMessage("message! Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).createAssertionError()).hasMessage("message:. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).createAssertionError()).hasMessage("message1. message2. Actual:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion);
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message? Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message! Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message:. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).createAssertionError()).hasMessage("message1. message2. Expected:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedRangeTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message? Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message! Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message:. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").createAssertionError()).hasMessage("message1. message2. Expected:<null:Value2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).createAssertionError()).hasMessage("message1. message2. Expected:<Value1:null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message? Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message! Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message:. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).createAssertionError()).hasMessage("message1. message2. Expected:<null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedRangeTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message? Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message! Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message:. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").createAssertionError()).hasMessage("message1. message2. Expected:<null:Value2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").createAssertionError()).toCause().isNull();
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).createAssertionError()).hasMessage("message1. message2. Expected:<Value1:null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).createAssertionError()).toCause().isNull();

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new FailDescription().addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription().addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message?");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message!");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:.");
        Assertions.assertThat(new FailDescription("message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("");
        Assertions.assertThat(new FailDescription((FailDescription) null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message.");
        Assertions.assertThat(new FailDescription(null, "message").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2.");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2.");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2.");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndThrowableTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message? Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message! Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Actual:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Actual:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Actual:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedAndThrowableTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message? Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message! Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithExpectedRangeAndThrowableTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription().addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message? Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message! Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription("message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(null, "message").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<null:Value2>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<Value1:null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedAndThrowableTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message? Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message! Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue> but was:<actualValue>");
    }

    /**
     * {@link FailDescription} class test.
     */
    @Test
    public void createAssertionErrorWithActualAndExpectedRangeAndThrowableTest() {
        BaseAssertion baseAssertion = createBaseAssertion("actualValue");

        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription().addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message.").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message?").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message? Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message!").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message! Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription("message:").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message:. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription("message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription((FailDescription) null).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message")).addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(null, "message").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<null>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(createBaseAssertion(null, null)).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<null:Value2> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, null, "Value2").addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).hasMessage("message1. message2. Expected:<Value1:null> but was:<actualValue>");
        Assertions.assertThat(new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "Value1", null).addThrowable(new RuntimeException("error")).createAssertionError()).isCauseInstanceOf(RuntimeException.class);

        FailDescription failDescription = new FailDescription(new FailDescription("message1"), "message2").addActual(baseAssertion).addExpected(baseAssertion, "expectedValue1", "expectedValue2").addThrowable(new RuntimeException("error"));
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
        Assertions.assertThat(failDescription.createAssertionError()).hasMessage("message1. message2. Expected:<expectedValue1:expectedValue2> but was:<actualValue>");
    }

}
