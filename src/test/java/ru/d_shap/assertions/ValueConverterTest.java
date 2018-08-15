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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for {@link ValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ValueConverterTest() {
        super();
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ValueConverter.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(ValueConverter.convert(null, String.class)).isNull();

        Assertions.assertThat(ValueConverter.convert(100, Character.class)).isInstanceOf(Character.class);
        Assertions.assertThat(ValueConverter.convert(100, Character.class)).isEqualTo((char) 100);
        Assertions.assertThat(ValueConverter.convert(100000, Character.class)).isInstanceOf(Integer.class);
        Assertions.assertThat(ValueConverter.convert(100000, Character.class)).isEqualTo(100000);

        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 5), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 4), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 3), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 2), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5).iterator(), List.class, 1), Raw.<Integer>listAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5), Map.class)).isInstanceOf(List.class);
    }

}
