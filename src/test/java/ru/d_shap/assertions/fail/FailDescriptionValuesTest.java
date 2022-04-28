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
package ru.d_shap.assertions.fail;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link FailDescriptionValues}.
 *
 * @author Dmitry Shapovalov
 */
public final class FailDescriptionValuesTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FailDescriptionValuesTest() {
        super();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void initialValuesTest() {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(null, null);
        Assertions.assertThat(failDescriptionValues, "_actualDefined", Raw.booleanAssertion()).isFalse();
        Assertions.assertThat(failDescriptionValues, "_actualDeltaDefined", Raw.booleanAssertion()).isFalse();
        Assertions.assertThat(failDescriptionValues, "_expected1Defined", Raw.booleanAssertion()).isFalse();
        Assertions.assertThat(failDescriptionValues, "_expected2Defined", Raw.booleanAssertion()).isFalse();
        Assertions.assertThat(failDescriptionValues, "_expectedDeltaDefined", Raw.booleanAssertion()).isFalse();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryNullActualClassTest() {
        FailDescriptionValues failDescriptionValues000 = new FailDescriptionValues(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues000)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(null, null);
        failDescriptionValues011.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(null, "actual");
        failDescriptionValues012.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(null, null);
        failDescriptionValues021.addActualWithDelta("delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(null, "actual");
        failDescriptionValues022.addActualWithDelta("delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(null, null);
        failDescriptionValues031.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(null, "actual");
        failDescriptionValues032.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(null, null);
        failDescriptionValues041.addExpectedWithDelta("expected", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(null, "actual");
        failDescriptionValues042.addExpectedWithDelta("expected", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues51 = new FailDescriptionValues(null, null);
        failDescriptionValues51.addActual();
        failDescriptionValues51.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues51)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(null, "actual");
        failDescriptionValues052.addActual();
        failDescriptionValues052.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues61 = new FailDescriptionValues(null, null);
        failDescriptionValues61.addActualWithDelta("delta");
        failDescriptionValues61.addExpectedWithDelta("expected", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues61)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(null, "actual");
        failDescriptionValues062.addActualWithDelta("delta");
        failDescriptionValues062.addExpectedWithDelta("expected", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues071 = new FailDescriptionValues(null, null);
        failDescriptionValues071.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues071)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues072 = new FailDescriptionValues(null, "actual");
        failDescriptionValues072.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues072)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues081 = new FailDescriptionValues(null, null);
        failDescriptionValues081.addExpectedWithDelta("expected1", "expected2", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues081)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues082 = new FailDescriptionValues(null, "actual");
        failDescriptionValues082.addExpectedWithDelta("expected1", "expected2", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues082)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues091 = new FailDescriptionValues(null, null);
        failDescriptionValues091.addActual();
        failDescriptionValues091.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues091)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues092 = new FailDescriptionValues(null, "actual");
        failDescriptionValues092.addActual();
        failDescriptionValues092.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues092)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues101 = new FailDescriptionValues(null, null);
        failDescriptionValues101.addActualWithDelta("delta");
        failDescriptionValues101.addExpectedWithDelta("expected1", "expected2", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues101)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues102 = new FailDescriptionValues(null, "actual");
        failDescriptionValues102.addActualWithDelta("delta");
        failDescriptionValues102.addExpectedWithDelta("expected1", "expected2", "delta");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues102)).containsExactlyInOrder();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryTest() {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualTest() {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Actual:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "");
        failDescriptionValues2.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Actual:<>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues3.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Actual:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Actual:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, null);
        failDescriptionValues012.addActualWithDelta("");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Actual:<<NULL>±>");

        FailDescriptionValues failDescriptionValues013 = new FailDescriptionValues(String.class, null);
        failDescriptionValues013.addActualWithDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues013)).containsExactlyInOrder("Actual:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, "");
        failDescriptionValues021.addActualWithDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Actual:<±<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "");
        failDescriptionValues022.addActualWithDelta("");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Actual:<±>");

        FailDescriptionValues failDescriptionValues023 = new FailDescriptionValues(String.class, "");
        failDescriptionValues023.addActualWithDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues023)).containsExactlyInOrder("Actual:<±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues031.addActualWithDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Actual:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActualWithDelta("");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Actual:<actual±>");

        FailDescriptionValues failDescriptionValues033 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues033.addActualWithDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues033)).containsExactlyInOrder("Actual:<actual±D!>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues041.addActualWithDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Actual:<12345±<NULL>>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues042.addActualWithDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Actual:<12345±2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addExpected("expected1", "expected2");
        failDescriptionValues031.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addExpected("expected1", "expected2");
        failDescriptionValues032.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Integer.class, null);
        failDescriptionValues041.addExpected(123);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<123>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues042.addExpected(123);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<123>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues051 = new FailDescriptionValues(String.class, null);
        failDescriptionValues051.addExpectedWithDelta("expected1", "expected2", "DDD");
        failDescriptionValues051.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues051)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues052.addExpectedWithDelta("expected1", "expected2", "DDD");
        failDescriptionValues052.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(Integer.class, null);
        failDescriptionValues061.addExpectedWithDelta(123, 2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<123±2>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues062.addExpectedWithDelta(123, 2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<123±2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues31 = new FailDescriptionValues(String.class, null);
        failDescriptionValues31.addExpected("expected");
        failDescriptionValues31.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues31)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues32 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues32.addExpected("expected");
        failDescriptionValues32.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues32)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Integer.class, null);
        failDescriptionValues041.addExpected(123, 456);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<123:456>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues042.addExpected(123, 456);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<123:456>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpected2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues51 = new FailDescriptionValues(String.class, null);
        failDescriptionValues51.addExpectedWithDelta("expected", "DDD");
        failDescriptionValues51.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues51)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues52 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues52.addExpectedWithDelta("expected", "DDD");
        failDescriptionValues52.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues52)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(Integer.class, null);
        failDescriptionValues061.addExpectedWithDelta(123, 456, 2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<123:456±2>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(Integer.class, 12345);
        failDescriptionValues062.addExpectedWithDelta(123, 456, 2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<123:456±2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryRawExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryRawExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryRawExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryRawExpected2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActual();
        failDescriptionValues012.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActual();
        failDescriptionValues022.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected> but was:<actual>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addExpected("expected1", "expected2");
        failDescriptionValues031.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActual();
        failDescriptionValues032.addExpected("expected1", "expected2");
        failDescriptionValues032.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected> but was:<actual±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActual();
        failDescriptionValues012.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActual();
        failDescriptionValues022.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActual();
        failDescriptionValues032.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActual();
        failDescriptionValues041.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActual();
        failDescriptionValues042.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±D!> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addExpectedWithDelta(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addExpectedWithDelta("expected", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues051 = new FailDescriptionValues(String.class, null);
        failDescriptionValues051.addActualWithDelta(null);
        failDescriptionValues051.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues051)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues052.addActualWithDelta(null);
        failDescriptionValues052.addExpectedWithDelta(null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(String.class, null);
        failDescriptionValues061.addActualWithDelta(null);
        failDescriptionValues061.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues062.addActualWithDelta(null);
        failDescriptionValues062.addExpectedWithDelta("expected", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<expected±D!> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues071 = new FailDescriptionValues(String.class, null);
        failDescriptionValues071.addActualWithDelta("DA!");
        failDescriptionValues071.addExpectedWithDelta(null, "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues071)).containsExactlyInOrder("Expected:<<NULL>±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues072 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues072.addActualWithDelta("DA!");
        failDescriptionValues072.addExpectedWithDelta(null, "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues072)).containsExactlyInOrder("Expected:<<NULL>±DE!> but was:<actual±DA!>");

        FailDescriptionValues failDescriptionValues081 = new FailDescriptionValues(String.class, null);
        failDescriptionValues081.addActualWithDelta("DA!");
        failDescriptionValues081.addExpectedWithDelta("expected", "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues081)).containsExactlyInOrder("Expected:<expected±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues082 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues082.addActualWithDelta("DA!");
        failDescriptionValues082.addExpectedWithDelta("expected", "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues082)).containsExactlyInOrder("Expected:<expected±DE!> but was:<actual±DA!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActual();
        failDescriptionValues012.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActual();
        failDescriptionValues022.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addExpected("expected");
        failDescriptionValues031.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActual();
        failDescriptionValues032.addExpected("expected");
        failDescriptionValues032.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpected2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActual();
        failDescriptionValues012.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActual();
        failDescriptionValues022.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActual();
        failDescriptionValues032.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActual();
        failDescriptionValues041.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActual();
        failDescriptionValues042.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndExpected2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(String.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(String.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addExpectedWithDelta(null, null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(String.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(String.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addExpectedWithDelta("expected1", "expected2", null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<actual±D!>");

        FailDescriptionValues failDescriptionValues051 = new FailDescriptionValues(String.class, null);
        failDescriptionValues051.addActualWithDelta(null);
        failDescriptionValues051.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues051)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues052.addActualWithDelta(null);
        failDescriptionValues052.addExpectedWithDelta(null, null, "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(String.class, null);
        failDescriptionValues061.addActualWithDelta(null);
        failDescriptionValues061.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues062.addActualWithDelta(null);
        failDescriptionValues062.addExpectedWithDelta("expected1", "expected2", "D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues071 = new FailDescriptionValues(String.class, null);
        failDescriptionValues071.addActualWithDelta("DA!");
        failDescriptionValues071.addExpectedWithDelta(null, null, "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues071)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues072 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues072.addActualWithDelta("DA!");
        failDescriptionValues072.addExpectedWithDelta(null, null, "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues072)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±DE!> but was:<actual±DA!>");

        FailDescriptionValues failDescriptionValues081 = new FailDescriptionValues(String.class, null);
        failDescriptionValues081.addActualWithDelta("DA!");
        failDescriptionValues081.addExpectedWithDelta("expected1", "expected2", "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues081)).containsExactlyInOrder("Expected:<expected1:expected2±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues082 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues082.addActualWithDelta("DA!");
        failDescriptionValues082.addExpectedWithDelta("expected1", "expected2", "DE!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues082)).containsExactlyInOrder("Expected:<expected1:expected2±DE!> but was:<actual±DA!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActual();
        failDescriptionValues012.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActual();
        failDescriptionValues022.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues031.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActual();
        failDescriptionValues032.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues032.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndRawExpectedTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected> but was:<<element/>±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActual();
        failDescriptionValues012.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActual();
        failDescriptionValues022.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActual();
        failDescriptionValues032.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActual();
        failDescriptionValues041.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActual();
        failDescriptionValues042.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±D!> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndRawExpectedWithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addRawExpectedWithDelta(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addRawExpectedWithDelta("expected", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues051 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues051.addActualWithDelta(null);
        failDescriptionValues051.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues051)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues052.addActualWithDelta(null);
        failDescriptionValues052.addRawExpectedWithDelta(null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues061.addActualWithDelta(null);
        failDescriptionValues061.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues062.addActualWithDelta(null);
        failDescriptionValues062.addRawExpectedWithDelta("expected", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<expected±D!> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues071 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues071.addActualWithDelta("DA!");
        failDescriptionValues071.addRawExpectedWithDelta(null, "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues071)).containsExactlyInOrder("Expected:<<NULL>±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues072 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues072.addActualWithDelta("DA!");
        failDescriptionValues072.addRawExpectedWithDelta(null, "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues072)).containsExactlyInOrder("Expected:<<NULL>±DE!> but was:<<element/>±DA!>");

        FailDescriptionValues failDescriptionValues081 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues081.addActualWithDelta("DA!");
        failDescriptionValues081.addRawExpectedWithDelta("expected", "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues081)).containsExactlyInOrder("Expected:<expected±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues082 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues082.addActualWithDelta("DA!");
        failDescriptionValues082.addRawExpectedWithDelta("expected", "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues082)).containsExactlyInOrder("Expected:<expected±DE!> but was:<<element/>±DA!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActual();
        failDescriptionValues012.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActual();
        failDescriptionValues022.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addRawExpected("expected", String.class);
        failDescriptionValues031.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActual();
        failDescriptionValues032.addRawExpected("expected", String.class);
        failDescriptionValues032.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndRawExpected2Test() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<element/>±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRaw2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActual();
        failDescriptionValues011.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActual();
        failDescriptionValues012.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActual();
        failDescriptionValues021.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActual();
        failDescriptionValues022.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActual();
        failDescriptionValues031.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActual();
        failDescriptionValues032.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActual();
        failDescriptionValues041.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActual();
        failDescriptionValues042.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualWithDeltaAndRawExpected2WithDeltaTest() {
        FailDescriptionValues failDescriptionValues011 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues011.addActualWithDelta(null);
        failDescriptionValues011.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues011)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues012 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues012.addActualWithDelta(null);
        failDescriptionValues012.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues012)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues021 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues021.addActualWithDelta("D!");
        failDescriptionValues021.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues021)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues022 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues022.addActualWithDelta("D!");
        failDescriptionValues022.addRawExpectedWithDelta(null, null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues022)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues031 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues031.addActualWithDelta(null);
        failDescriptionValues031.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues031)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues032 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues032.addActualWithDelta(null);
        failDescriptionValues032.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues032)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues041 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues041.addActualWithDelta("D!");
        failDescriptionValues041.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues041)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues042 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues042.addActualWithDelta("D!");
        failDescriptionValues042.addRawExpectedWithDelta("expected1", "expected2", null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues042)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<element/>±D!>");

        FailDescriptionValues failDescriptionValues051 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues051.addActualWithDelta(null);
        failDescriptionValues051.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues051)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues052 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues052.addActualWithDelta(null);
        failDescriptionValues052.addRawExpectedWithDelta(null, null, "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues052)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues061 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues061.addActualWithDelta(null);
        failDescriptionValues061.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues061)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues062 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues062.addActualWithDelta(null);
        failDescriptionValues062.addRawExpectedWithDelta("expected1", "expected2", "D!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues062)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<element/>±<NULL>>");

        FailDescriptionValues failDescriptionValues071 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues071.addActualWithDelta("DA!");
        failDescriptionValues071.addRawExpectedWithDelta(null, null, "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues071)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues072 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues072.addActualWithDelta("DA!");
        failDescriptionValues072.addRawExpectedWithDelta(null, null, "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues072)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±DE!> but was:<<element/>±DA!>");

        FailDescriptionValues failDescriptionValues081 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues081.addActualWithDelta("DA!");
        failDescriptionValues081.addRawExpectedWithDelta("expected1", "expected2", "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues081)).containsExactlyInOrder("Expected:<expected1:expected2±DE!> but was:<<NULL>±DA!>");

        FailDescriptionValues failDescriptionValues082 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues082.addActualWithDelta("DA!");
        failDescriptionValues082.addRawExpectedWithDelta("expected1", "expected2", "DE!", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues082)).containsExactlyInOrder("Expected:<expected1:expected2±DE!> but was:<<element/>±DA!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpectedNullClassFailTest() {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues.addActual();
        failDescriptionValues.addRawExpected("expected", null);
        getFormattedMessages(failDescriptionValues);
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpected2NullClassFailTest() {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues.addActual();
        failDescriptionValues.addRawExpected("expected1", "expected2", null);
        getFormattedMessages(failDescriptionValues);
    }

    private List<String> getFormattedMessages(final FailDescriptionValues failDescriptionValues) {
        List<FailDescriptionEntry> failDescriptionEntries = DataHelper.createArrayList();
        failDescriptionValues.addFailDescriptionEntry(failDescriptionEntries);
        List<String> formattedMessages = DataHelper.createArrayList();
        if (!failDescriptionEntries.isEmpty()) {
            FailDescriptionEntry failDescriptionEntry = failDescriptionEntries.get(0);
            failDescriptionEntry.addFormattedMessage(formattedMessages);
        }
        return formattedMessages;
    }

}
