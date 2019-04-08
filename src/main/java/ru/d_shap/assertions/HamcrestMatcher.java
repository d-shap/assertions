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

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import ru.d_shap.assertions.fail.FailDescription;

/**
 * Class to perform hamcrest assertions.
 *
 * @author Dmitry Shapovalov
 */
final class HamcrestMatcher {

    private HamcrestMatcher() {
        super();
    }

    static <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher) {
        MatcherAssert.assertThat(actual, matcher);
    }

    static <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher, final String message, final Object... arguments) {
        String fullMessage = new FailDescription(message, arguments).getFullMessage();
        MatcherAssert.assertThat(fullMessage, actual, matcher);
    }

    static <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher, final FailDescription failDescription) {
        String fullMessage = failDescription.getFullMessage();
        MatcherAssert.assertThat(fullMessage, actual, matcher);
    }

    static <W, U extends W> void matcherAssertion(final U actual, final Matcher<W> matcher, final FailDescription failDescription, final String message, final Object... arguments) {
        String fullMessage = new FailDescription(failDescription, message, arguments).getFullMessage();
        MatcherAssert.assertThat(fullMessage, actual, matcher);
    }

}
