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
    public void addFailDescriptionEntryNullValueClassTest() throws ConvertionException {
        FailDescriptionValues failDescriptionValues01 = new FailDescriptionValues(null, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues01)).isEmpty();

        FailDescriptionValues failDescriptionValues02 = new FailDescriptionValues(null, null);
        failDescriptionValues02.addActual();
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues02)).isEmpty();

        FailDescriptionValues failDescriptionValues03 = new FailDescriptionValues(null, "actual");
        failDescriptionValues03.addActual();
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues03)).isEmpty();

        FailDescriptionValues failDescriptionValues04 = new FailDescriptionValues(null, null);
        failDescriptionValues04.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues04)).isEmpty();

        FailDescriptionValues failDescriptionValues05 = new FailDescriptionValues(null, "actual");
        failDescriptionValues05.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues05)).isEmpty();

        FailDescriptionValues failDescriptionValues06 = new FailDescriptionValues(null, null);
        failDescriptionValues06.addActual();
        failDescriptionValues06.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues06)).isEmpty();

        FailDescriptionValues failDescriptionValues07 = new FailDescriptionValues(null, "actual");
        failDescriptionValues07.addActual();
        failDescriptionValues07.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues07)).isEmpty();

        FailDescriptionValues failDescriptionValues08 = new FailDescriptionValues(null, null);
        failDescriptionValues08.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues08)).isEmpty();

        FailDescriptionValues failDescriptionValues09 = new FailDescriptionValues(null, "actual");
        failDescriptionValues09.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues09)).isEmpty();

        FailDescriptionValues failDescriptionValues10 = new FailDescriptionValues(null, null);
        failDescriptionValues10.addActual();
        failDescriptionValues10.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues10)).isEmpty();

        FailDescriptionValues failDescriptionValues11 = new FailDescriptionValues(null, "actual");
        failDescriptionValues11.addActual();
        failDescriptionValues11.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues11)).isEmpty();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryTest() throws ConvertionException {
        FailDescriptionValues failDescriptionValues = new FailDescriptionValues(String.class, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues)).isEmpty();
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpectedTest() throws ConvertionException {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues1)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues1).get(0))).containsExactlyInOrder("Expected:<null>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addExpected(null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues2)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues2).get(0))).containsExactlyInOrder("Expected:<null>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues3)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues3).get(0))).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues4)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues4).get(0))).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addExpected("expected1", "expected2");
        failDescriptionValues5.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues5)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues5).get(0))).containsExactlyInOrder("Expected:<expected>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addExpected("expected1", "expected2");
        failDescriptionValues6.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues6)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues6).get(0))).containsExactlyInOrder("Expected:<expected>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryExpected2Test() throws ConvertionException {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addExpected(null, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues1)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues1).get(0))).containsExactlyInOrder("Expected:<null:null>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addExpected(null, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues2)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues2).get(0))).containsExactlyInOrder("Expected:<null:null>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues3)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues3).get(0))).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues4)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues4).get(0))).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addExpected("expected");
        failDescriptionValues5.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues5)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues5).get(0))).containsExactlyInOrder("Expected:<expected1:expected2>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addExpected("expected");
        failDescriptionValues6.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues6)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues6).get(0))).containsExactlyInOrder("Expected:<expected1:expected2>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualTest() throws ConvertionException {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues1)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues1).get(0))).containsExactlyInOrder("Actual:<null>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues2)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues2).get(0))).containsExactlyInOrder("Actual:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpectedTest() throws ConvertionException {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues1)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues1).get(0))).containsExactlyInOrder("Expected:<null> but was:<null>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues2)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues2).get(0))).containsExactlyInOrder("Expected:<null> but was:<actual>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues3)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues3).get(0))).containsExactlyInOrder("Expected:<expected> but was:<null>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues4)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues4).get(0))).containsExactlyInOrder("Expected:<expected> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected1", "expected2");
        failDescriptionValues5.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues5)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues5).get(0))).containsExactlyInOrder("Expected:<expected> but was:<null>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected1", "expected2");
        failDescriptionValues6.addExpected("expected");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues6)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues6).get(0))).containsExactlyInOrder("Expected:<expected> but was:<actual>");
    }

    /**
     * {@link FailDescriptionValues} class test.
     */
    @Test
    public void addFailDescriptionEntryActualAndExpected2Test() throws ConvertionException {
        FailDescriptionValues failDescriptionValues1 = new FailDescriptionValues(String.class, null);
        failDescriptionValues1.addActual();
        failDescriptionValues1.addExpected(null, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues1)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues1).get(0))).containsExactlyInOrder("Expected:<null:null> but was:<null>");

        FailDescriptionValues failDescriptionValues2 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues2.addActual();
        failDescriptionValues2.addExpected(null, null);
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues2)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues2).get(0))).containsExactlyInOrder("Expected:<null:null> but was:<actual>");

        FailDescriptionValues failDescriptionValues3 = new FailDescriptionValues(String.class, null);
        failDescriptionValues3.addActual();
        failDescriptionValues3.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues3)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues3).get(0))).containsExactlyInOrder("Expected:<expected1:expected2> but was:<null>");

        FailDescriptionValues failDescriptionValues4 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues4.addActual();
        failDescriptionValues4.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues4)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues4).get(0))).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");

        FailDescriptionValues failDescriptionValues5 = new FailDescriptionValues(String.class, null);
        failDescriptionValues5.addActual();
        failDescriptionValues5.addExpected("expected");
        failDescriptionValues5.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues5)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues5).get(0))).containsExactlyInOrder("Expected:<expected1:expected2> but was:<null>");

        FailDescriptionValues failDescriptionValues6 = new FailDescriptionValues(String.class, "actual");
        failDescriptionValues6.addActual();
        failDescriptionValues6.addExpected("expected");
        failDescriptionValues6.addExpected("expected1", "expected2");
        Assertions.assertThat(getFailDescriptionEntries(failDescriptionValues6)).hasSize(1);
        Assertions.assertThat(getFormattedMessages(getFailDescriptionEntries(failDescriptionValues6).get(0))).containsExactlyInOrder("Expected:<expected1:expected2> but was:<actual>");
    }

}
