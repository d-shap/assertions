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

/**
 * Helper class to perform concurent operations.
 *
 * @author Dmitry Shapovalov
 */
public final class ConcurentHelper {

    private ConcurentHelper() {
        super();
    }

    /**
     * Causes the currently executing thread to sleep for the specified number of milliseconds.
     *
     * @param milliseconds the specified number of milliseconds.
     */
    public static void sleep(final long milliseconds) {
        if (milliseconds > 0) {
            Interruptable interruptable = new SleepInterruptable(milliseconds);
            runInterruptable(interruptable);
        }
    }

    /**
     * Run the specified runnable in a separate thread.
     *
     * @param runnable the specified runnable.
     */
    public static void run(final Runnable runnable) {
        Runnable runnableInvoker = new RunnableInvoker(null, runnable);
        runnableInvoker.run();
    }

    /**
     * Run the specified runnable in a separate thread and wait for its completition.
     *
     * @param runnable the specified runnable.
     */
    public static void runAndWait(final Runnable runnable) {
        Object semaphore = new Object();
        Runnable runnableInvoker = new RunnableInvoker(semaphore, runnable);
        runnableInvoker.run();
    }

    static void runInterruptable(final Interruptable interruptable) {
        try {
            interruptable.run();
        } catch (InterruptedException ex) {
            throw new ConcurentException(ex);
        }
    }

    interface Interruptable {

        void run() throws InterruptedException;

    }

    private static final class SleepInterruptable implements Interruptable {

        private final long _milliseconds;

        SleepInterruptable(final long milliseconds) {
            super();
            _milliseconds = milliseconds;
        }

        @Override
        public void run() throws InterruptedException {
            Thread.sleep(_milliseconds);
        }

    }

    private static final class WaitInterruptable implements Interruptable {

        private final Object _semaphore;

        WaitInterruptable(final Object semaphore) {
            super();
            _semaphore = semaphore;
        }

        @Override
        public void run() throws InterruptedException {
            synchronized (_semaphore) {
                _semaphore.wait();
            }
        }

    }

    private static final class NotifyAllInterruptable implements Interruptable {

        private final Object _semaphore;

        NotifyAllInterruptable(final Object semaphore) {
            super();
            _semaphore = semaphore;
        }

        @Override
        public void run() throws InterruptedException {
            synchronized (_semaphore) {
                _semaphore.notifyAll();
            }
        }

    }

    private static final class RunnableInvoker implements Runnable {

        private final Object _semaphore;

        private final Runnable _runnable;

        RunnableInvoker(final Object semaphore, final Runnable runnable) {
            super();
            _semaphore = semaphore;
            _runnable = runnable;
        }

        @Override
        public void run() {
            Runnable runnable = new RunnableNotifier(_semaphore, _runnable);
            Thread thread = new Thread(runnable);
            thread.start();
            if (_semaphore != null) {
                Interruptable interruptable = new WaitInterruptable(_semaphore);
                runInterruptable(interruptable);
            }
        }

    }

    private static final class RunnableNotifier implements Runnable {

        private final Object _semaphore;

        private final Runnable _runnable;

        RunnableNotifier(final Object semaphore, final Runnable runnable) {
            super();
            _semaphore = semaphore;
            _runnable = runnable;
        }

        @Override
        public void run() {
            _runnable.run();
            if (_semaphore != null) {
                NotifyAllInterruptable interruptable = new NotifyAllInterruptable(_semaphore);
                runInterruptable(interruptable);
            }
        }

    }

}
