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

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DataException}.
 *
 * @author Dmitry Shapovalov
 */
public final class DataExceptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DataExceptionTest() {
        super();
    }

    /**
     * {@link DataException} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(new DataException(null)).messageIsNull();

        Assertions.assertThat(new DataException(new DatatypeConfigurationException())).messageIsNull();
        Assertions.assertThat(new DataException(new DatatypeConfigurationException())).causeMessageIsNull();

        Assertions.assertThat(new DataException(new DatatypeConfigurationException("exception"))).hasMessage("exception");
        Assertions.assertThat(new DataException(new DatatypeConfigurationException("exception"))).hasCauseMessage("exception");
    }

    /**
     * {@link DataException} class test.
     */
    @Test
    public void getCauseTest() {
        Assertions.assertThat(new DataException(null)).causeIsNull();

        Assertions.assertThat(new DataException(new DatatypeConfigurationException())).hasCause(DatatypeConfigurationException.class);

        Assertions.assertThat(new DataException(new DatatypeConfigurationException("exception"))).hasCause(DatatypeConfigurationException.class);
    }

}
