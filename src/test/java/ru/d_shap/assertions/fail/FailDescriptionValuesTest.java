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
package ru.d_shap.assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
    public void addFailDescriptionEntryNullValueClassTest() throws Exception {
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
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(String.class, null);
        Assertions.assertThat(getFormattedMessages(failDescriptionValues)).containsExactlyInOrder();
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
    public void addFailDescriptionEntryActualTest() throws Exception {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues1)).containsExactlyInOrder("Actual:<<NULL>>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        Assertions.assertThat(getFormattedMessages(failDescriptionValues2)).containsExactlyInOrder("Actual:<actual>");
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
