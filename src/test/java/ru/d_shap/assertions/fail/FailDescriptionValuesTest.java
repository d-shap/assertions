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

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryNullActualClassTest() throws Exception {
        FailDescriptionValues failDescriptionValues01 = new FailDescriptionValues(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues01)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues02 = new FailDescriptionValues(null, null);
        failDescriptionValues02.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues02)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues03 = new FailDescriptionValues(null, "actual");
        failDescriptionValues03.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues03)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues04 = new FailDescriptionValues(null, null);
        failDescriptionValues04.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues04)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues05 = new FailDescriptionValues(null, "actual");
        failDescriptionValues05.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues05)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues06 = new FailDescriptionValues(null, null);
        failDescriptionValues06.addActual();
        failDescriptionValues06.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues06)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues07 = new FailDescriptionValues(null, "actual");
        failDescriptionValues07.addActual();
        failDescriptionValues07.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues07)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues08 = new FailDescriptionValues(null, null);
        failDescriptionValues08.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues08)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues09 = new FailDescriptionValues(null, "actual");
        failDescriptionValues09.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues09)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues10 = new FailDescriptionValues(null, null);
        failDescriptionValues10.addActual();
        failDescriptionValues10.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues10)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues11 = new FailDescriptionValues(null, "actual");
        failDescriptionValues11.addActual();
        failDescriptionValues11.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues11)).containsExactlyInOrder();
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder();
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualTest() throws Exception {
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
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder();

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder();
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Actual:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addActual();
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Actual:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues3.addActual();
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Actual:<actual±<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Actual:<actual±D!>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(Byte.class, (byte) 1);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Actual:<1b±2b>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryExpectedTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addExpected("expected1", "expected2");
        failDescriptionValues5.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addExpected("expected1", "expected2");
        failDescriptionValues6.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryRawExpectedTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues2.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryExpectedDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addExpected(null);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected");
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, null);
        failDescriptionValues4.addExpected("expected");
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected±D!>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(Byte.class, (byte) 1);
        failDescriptionValues5.addExpected((byte) 4);
        failDescriptionValues5.addDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<4b±2b>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryRawExpectedDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addRawExpected(null, String.class);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues2.addRawExpected(null, String.class);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>±D!>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addRawExpected("expected", String.class);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected±<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues4.addRawExpected("expected", String.class);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryExpected2Test() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addExpected("expected");
        failDescriptionValues5.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addExpected("expected");
        failDescriptionValues6.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected1:expected2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryRawExpected2Test() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues2.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryExpected2DeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null, null);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addExpected(null, null);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected1", "expected2");
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, null);
        failDescriptionValues4.addExpected("expected1", "expected2");
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(Byte.class, (byte) 1);
        failDescriptionValues5.addExpected((byte) 4, (byte) 6);
        failDescriptionValues5.addDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<4b:6b±2b>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryRawExpected2DeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addRawExpected(null, null, String.class);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues2.addRawExpected(null, null, String.class);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues4.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2±D!>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpectedTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected1", "expected2");
        failDescriptionValues5.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected1", "expected2");
        failDescriptionValues6.addExpected("expected");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpectedTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues2.addActual();
        failDescriptionValues2.addRawExpected(null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addActual();
        failDescriptionValues4.addRawExpected("expected", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpectedDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected(null);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected(null);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected");
        failDescriptionValues5.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, null);
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected");
        failDescriptionValues6.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues7 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues7.addActual();
        failDescriptionValues7.addExpected("expected");
        failDescriptionValues7.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues7)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues8 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues8.addActual();
        failDescriptionValues8.addExpected("expected");
        failDescriptionValues8.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues8)).containsExactlyInOrder("Expected:<expected±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues9 = new FailDescriptionValues(Byte.class, (byte) 1);
        failDescriptionValues9.addActual();
        failDescriptionValues9.addExpected((byte) 4);
        failDescriptionValues9.addDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues9)).containsExactlyInOrder("Expected:<4b±2b> but was:<1b>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpectedDeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addRawExpected(null, String.class);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues2.addActual();
        failDescriptionValues2.addRawExpected(null, String.class);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues3.addActual();
        failDescriptionValues3.addRawExpected(null, String.class);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<<NULL>±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addActual();
        failDescriptionValues4.addRawExpected(null, String.class);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<<NULL>±D!> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addRawExpected("expected", String.class);
        failDescriptionValues5.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues6.addActual();
        failDescriptionValues6.addRawExpected("expected", String.class);
        failDescriptionValues6.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues7 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues7.addActual();
        failDescriptionValues7.addRawExpected("expected", String.class);
        failDescriptionValues7.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues7)).containsExactlyInOrder("Expected:<expected±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues8 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues8.addActual();
        failDescriptionValues8.addRawExpected("expected", String.class);
        failDescriptionValues8.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues8)).containsExactlyInOrder("Expected:<expected±D!> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpected2Test() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected");
        failDescriptionValues5.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected");
        failDescriptionValues6.addExpected("expected1", "expected2");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpected2Test() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues2.addActual();
        failDescriptionValues2.addRawExpected(null, null, String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addActual();
        failDescriptionValues4.addRawExpected("expected1", "expected2", String.class);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<expected1:expected2> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpected2DeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null, null);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, null);
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null, null);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected(null, null);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected(null, null);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected1", "expected2");
        failDescriptionValues5.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, null);
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected1", "expected2");
        failDescriptionValues6.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues7 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues7.addActual();
        failDescriptionValues7.addExpected("expected1", "expected2");
        failDescriptionValues7.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues7)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<actual>");

        FailDescriptionValues failDescriptionValues8 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues8.addActual();
        failDescriptionValues8.addExpected("expected1", "expected2");
        failDescriptionValues8.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues8)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<actual>");

        FailDescriptionValues failDescriptionValues9 = new FailDescriptionValues(Byte.class, (byte) 1);
        failDescriptionValues9.addActual();
        failDescriptionValues9.addExpected((byte) 4, (byte) 6);
        failDescriptionValues9.addDelta(2);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues9)).containsExactlyInOrder("Expected:<4b:6b±2b> but was:<1b>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void addFailDescriptionEntryActualAndRawExpected2DeltaTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addRawExpected(null, null, String.class);
        failDescriptionValues1.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues2.addActual();
        failDescriptionValues2.addRawExpected(null, null, String.class);
        failDescriptionValues2.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues3.addActual();
        failDescriptionValues3.addRawExpected(null, null, String.class);
        failDescriptionValues3.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues3)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues4.addActual();
        failDescriptionValues4.addRawExpected(null, null, String.class);
        failDescriptionValues4.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues4)).containsExactlyInOrder("Expected:<<NULL>:<NULL>±D!> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues5.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues5)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(Node.class, null);
        failDescriptionValues6.addActual();
        failDescriptionValues6.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues6.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues6)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<NULL>>");

        FailDescriptionValues failDescriptionValues7 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues7.addActual();
        failDescriptionValues7.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues7.addDelta(null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues7)).containsExactlyInOrder("Expected:<expected1:expected2±<NULL>> but was:<<element/>>");

        FailDescriptionValues failDescriptionValues8 = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues8.addActual();
        failDescriptionValues8.addRawExpected("expected1", "expected2", String.class);
        failDescriptionValues8.addDelta("D!");
        Assertions.assertThat(getFormattedMessages(failDescriptionValues8)).containsExactlyInOrder("Expected:<expected1:expected2±D!> but was:<<element/>>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpectedNullFailTest() throws Exception {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues.addActual();
        failDescriptionValues.addRawExpected("expected", null);
        getFormattedMessages(failDescriptionValues);
    }

    /**
     * {@link FailDescriptionValues} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpected2NullFailTest() throws Exception {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(Node.class, createNode("<element/>"));
        failDescriptionValues.addActual();
        failDescriptionValues.addRawExpected("expected1", "expected2", null);
        getFormattedMessages(failDescriptionValues);
    }

    private List<String> getFormattedMessages(final FailDescriptionValues failDescriptionValues) throws Exception {
        List<FailDescriptionEntry> failDescriptionEntries = new ArrayList<>();
        failDescriptionValues.addFailDescriptionEntry(failDescriptionEntries);
        List<String> formattedMessages = new ArrayList<>();
        if (!failDescriptionEntries.isEmpty()) {
            FailDescriptionEntry failDescriptionEntry = failDescriptionEntries.get(0);
            failDescriptionEntry.addFormattedMessage(formattedMessages);
        }
        return formattedMessages;
    }

}
