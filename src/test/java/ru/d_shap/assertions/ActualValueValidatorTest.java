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
package ru.d_shap.assertions;

import org.junit.Test;

import ru.d_shap.assertions.fail.AssertionErrorBuilder;

/**
 * Tests for {@link ActualValueValidator}.
 *
 * @author Dmitry Shapovalov
 */
public final class ActualValueValidatorTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ActualValueValidatorTest() {
        super();
    }

    /**
     * {@link ActualValueValidator} class test.
     */
    @Test
    public void isValidTest() {
        ActualValueValidator actualValueValidator1 = new ActualValueValidator();
        Assertions.assertThat(actualValueValidator1.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator1.validate(new Object())).isNull();

        ActualValueValidator actualValueValidator2 = new ActualValueValidator();
        actualValueValidator2.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator2.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator2.validate(new Object())).isNull();

        ActualValueValidator actualValueValidator3 = new ActualValueValidator();
        actualValueValidator3.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator3.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator3.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator3.validate(new Object())).isNull();

        ActualValueValidator actualValueValidator4 = new ActualValueValidator();
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator4.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator4.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator4.validate(new Object())).isNull();

        ActualValueValidator actualValueValidator5 = new ActualValueValidator();
        actualValueValidator5.addActualValueValidator(createActualValueValidator(true));
        ActualValueValidatorProvider actualValueValidatorProvider5 = createActualValueValidator(false);
        actualValueValidator5.addActualValueValidator(actualValueValidatorProvider5);
        actualValueValidator5.addActualValueValidator(createActualValueValidator(true));
        Assertions.assertThat(actualValueValidator5.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator5.validate(new Object())).isEqualTo(actualValueValidatorProvider5);

        ActualValueValidator actualValueValidator6 = new ActualValueValidator();
        actualValueValidator6.addActualValueValidator(createActualValueValidator(true));
        actualValueValidator6.addActualValueValidator(createActualValueValidator(true));
        ActualValueValidatorProvider actualValueValidatorProvider6 = createActualValueValidator(false);
        actualValueValidator6.addActualValueValidator(actualValueValidatorProvider6);
        Assertions.assertThat(actualValueValidator6.validate(null)).isNull();
        Assertions.assertThat(actualValueValidator6.validate(new Object())).isEqualTo(actualValueValidatorProvider6);
    }

    private ActualValueValidatorProvider createActualValueValidator(final boolean valid) {
        return new BaseActualValueValidatorImpl(valid);
    }

    private static final class BaseActualValueValidatorImpl implements ActualValueValidatorProvider {

        private final boolean _valid;

        BaseActualValueValidatorImpl(final boolean valid) {
            super();
            _valid = valid;
        }

        @Override
        public boolean isValid(final Object actual) {
            return _valid;
        }

        @Override
        public Object getFailActualValue(final Object actual) {
            return actual;
        }

        @Override
        public void addFailMessage(final AssertionErrorBuilder assertionErrorBuilder) {
            // Ignore
        }

    }

}
