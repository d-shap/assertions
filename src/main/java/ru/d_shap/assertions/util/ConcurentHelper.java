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
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            throw new ConcurentException(ex);
        }
    }

    /**
     * Invoke the specified runnable in separate thread and wait for completition.
     *
     * @param runnable the specified runnable.
     */
    public static void invokeAndWait(final Runnable runnable) {
        Object semaphore = new Object();
        Invoker invoker = new Invoker(semaphore, runnable);
        invoker.invoke();
    }

    private static final class Invoker {

        private final Object _semaphore;

        private final Runnable _runnable;

        Invoker(final Object semaphore, final Runnable runnable) {
            super();
            _semaphore = semaphore;
            _runnable = runnable;
        }

        void invoke() {
            Runnable runnableWithSemaphore = new RunnableWithSemaphore(_semaphore, _runnable);
            Thread thread = new Thread(runnableWithSemaphore);
            thread.start();
            synchronized (_semaphore) {
                try {
                    _semaphore.wait();
                } catch (InterruptedException ex) {
                    throw new ConcurentException(ex);
                }
            }
        }

    }

    private static final class RunnableWithSemaphore implements Runnable {

        private final Object _semaphore;

        private final Runnable _runnable;

        RunnableWithSemaphore(final Object semaphore, final Runnable runnable) {
            super();
            _semaphore = semaphore;
            _runnable = runnable;
        }

        @Override
        public void run() {
            _runnable.run();
            synchronized (_semaphore) {
                _semaphore.notifyAll();
            }
        }

    }

}
