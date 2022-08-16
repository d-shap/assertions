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

import java.io.IOException;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IOStreamException}.
 *
 * @author Dmitry Shapovalov
 */
public final class IOStreamExceptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IOStreamExceptionTest() {
        super();
    }

    /**
     * {@link IOStreamException} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(new IOStreamException(null)).messageIsNull();

        Assertions.assertThat(new IOStreamException(new IOException())).messageIsNull();
        Assertions.assertThat(new IOStreamException(new IOException())).causeMessageIsNull();

        Assertions.assertThat(new IOStreamException(new IOException("exception"))).hasMessage("exception");
        Assertions.assertThat(new IOStreamException(new IOException("exception"))).hasCauseMessage("exception");
    }

    /**
     * {@link IOStreamException} class test.
     */
    @Test
    public void getCauseTest() {
        Assertions.assertThat(new IOStreamException(null)).causeIsNull();

        Assertions.assertThat(new IOStreamException(new IOException())).hasCause(IOException.class);

        Assertions.assertThat(new IOStreamException(new IOException("exception"))).hasCause(IOException.class);
    }

}
