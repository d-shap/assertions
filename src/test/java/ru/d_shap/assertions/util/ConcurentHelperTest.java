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
package ru.d_shap.assertions.util;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ConcurentHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConcurentHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConcurentHelperTest() {
        super();
    }

    /**
     * {@link ConcurentHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ConcurentHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ConcurentHelper} class test.
     */
    @Test
    public void sleepTest() {
        ConcurentHelper.sleep(-1);
        ConcurentHelper.sleep(0);
        ConcurentHelper.sleep(10);
    }

    /**
     * {@link ConcurentHelper} class test.
     */
    @Test
    public void runInterruptableFailTest() {
        ConcurentHelper.Interruptable interruptable = new InterruptableFail();
        try {
            ConcurentHelper.runInterruptable(interruptable);
            Assertions.fail("ConcurentHelper test fail");
        } catch (ConcurentException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
    }

    /**
     * {@link ConcurentHelper} class test.
     */
    @Test
    public void runTest() {
        List<String> values = DataHelper.createArrayList();
        Runnable runnable = new RunnableSleep(values);
        ConcurentHelper.run(runnable);
        Assertions.assertThat(values).containsExactlyInOrder();
        ConcurentHelper.sleep(1000);
        Assertions.assertThat(values).containsExactlyInOrder("value");
    }

    /**
     * {@link ConcurentHelper} class test.
     */
    @Test
    public void runAndWaitTest() {
        List<String> values = DataHelper.createArrayList();
        List<String> expectedValues = DataHelper.createArrayList();
        Runnable[] runnables = new Runnable[100];
        for (int i = 0; i < runnables.length; i++) {
            runnables[i] = new RunnableListAdd(values, i);
            expectedValues.add("value: " + i);
        }
        for (Runnable runnable : runnables) {
            ConcurentHelper.runAndWait(runnable);
        }
        Assertions.assertThat(values).containsExactlyInOrder(expectedValues);
    }

    private static final class InterruptableFail implements ConcurentHelper.Interruptable {

        InterruptableFail() {
            super();
        }

        @Override
        public void run() throws InterruptedException {
            throw new InterruptedException("fail");
        }

    }

    private static final class RunnableSleep implements Runnable {

        private final List<String> _values;

        RunnableSleep(final List<String> values) {
            super();
            _values = values;
        }

        @Override
        public void run() {
            ConcurentHelper.sleep(500);
            _values.add("value");
        }

    }

    private static final class RunnableListAdd implements Runnable {

        private final List<String> _values;

        private final int _value;

        RunnableListAdd(final List<String> values, final int value) {
            super();
            _values = values;
            _value = value;
        }

        @Override
        public void run() {
            _values.add("value: " + _value);
        }

    }

}
