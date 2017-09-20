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
/**
 * <p>
 * Assertions framework provides facilities for the unit testing. Assertions framework allows checking of conditions
 * via existing assertion classes. This assertion classes make the tests more readable, understandable and maintainable.
 * Also this assertion classes reduce the amount of code needed to perform some complicated checks.
 * </p>
 * <p>
 * Import declaration for all the following examples:
 * </p>
 * <pre>{@code
 * import static ru.d_shap.assertions.Assertions.assertThat;
 * }</pre>
 * <p>
 * Assertion examples for the primitive data types:
 * </p>
 * <pre>{@code
 * assertThat(booleanValue).isTrue();
 * assertThat(byteValue).isEqualTo(5);
 * assertThat(shortValue).isNotEqualTo(10);
 * assertThat(intValue).isGreaterThan(0);
 * assertThat(longValue).isInRange(1L, 10L);
 * assertThat(floatValue).isNotNaN();
 * assertThat(doubleValue).isEqualTo(5.0, 0.001);
 * assertThat(charValue).isAlphabetic();
 * }</pre>
 * <p>
 * Assertion examples for the core data types:
 * </p>
 * <pre>{@code
 * assertThat(objectValue).isNotNull();
 * assertThat(objectValue).isNotSameAs(new Object());
 * assertThat(objectValue).isInstanceOf(Number.class);
 *
 * assertThat(stringValue).isNotBlank();
 * assertThat(stringValue).isEqualTo("value");
 * assertThat(stringValue).containsIgnoreCase("ALU");
 * assertThat(stringValue).isPartOf("Some value");
 * assertThat(stringValue).matches("\\w+");
 *
 * assertThat(classValue).isSubtypeOf(Number.class);
 * assertThat(classValue).hasOnePrivateConstructor();
 * assertThat(classValue).asEnum().hasValueCount(5);
 *
 * assertThat(throwableValue).hasMessage("Exception");
 * }</pre>
 * <p>
 * Assertion examples for the array data types:
 * </p>
 * <pre>{@code
 * assertThat(booleanArrayValue).isEmpty();
 * assertThat(byteArrayValue).hasLength(3);
 * assertThat(shortArrayValue).contains(5);
 * assertThat(intArrayValue).containsAll(5, 10, 15);
 * assertThat(longArrayValue).containsAny(1L, 2L, 3L);
 * assertThat(floatArrayValue).containsNone(10.0f, 20.0f);
 * assertThat(charArrayValue).doesNotContain('c');
 * assertThat(objectArrayValue).containsAllInOrder("val1", "val2", "val3");
 * }</pre>
 * <p>
 * Assertion examples for the collection data types:
 * </p>
 * <pre>{@code
 * assertThat(listValue).isNotEmpty();
 * assertThat(listValue).hasSize(3);
 * assertThat(listValue).containsAll("val1", "val2", "val3");
 * assertThat(listValue).containsAny("val2", "val4");
 * assertThat(listValue).containsNone("val7", "val5");
 *
 * assertThat(setValue).isEmpty();
 * assertThat(setValue).containsExactly("val1", "val3", "val5");
 *
 * assertThat(mapValue).isNullOrEmpty();
 * assertThat(mapValue).hasSize(5);
 * assertThat(mapValue).containsAnyKey("key1", "key2", "key3");
 * assertThat(mapValue).containsEntry("key", "value");
 * assertThat(mapValue).containsNone(expectedMapValue);
 * }</pre>
 * <p>
 * Assertion examples for the io data types:
 * </p>
 * <pre>{@code
 * assertThat(inputStreamValue).isNextBytesEqualTo(1, 2, 3);
 * assertThat(inputStreamValue).isAllBytesEqualTo(10, 100, 15);
 * assertThat(inputStreamValue).isCompleted();
 *
 * assertThat(readerValue).isNextCharsEqualTo('v', 'a', 'l', '1');
 * assertThat(readerValue).isAllCharsEqualTo('v', 'a', 'l', '2');
 * assertThat(readerValue).isCompleted();
 * }</pre>
 * <p>
 * Assertion examples for the nio data types:
 * </p>
 * <pre>{@code
 * assertThat(byteBufferValue).hasCapacity(10);
 * assertThat(shortBufferValue).hasLimit(5);
 * assertThat(intBufferValue).hasPosition(7);
 * assertThat(longBufferValue).contains(4L);
 * assertThat(floatBufferValue).containsExactlyInOrder(1.0f, 2.0f, 1.0f, 2.0f, 3.0f);
 * assertThat(doubleBufferValue).rewindAndContainsAll(5.0, 10.0, 15.0);
 * assertThat(charBufferValue).rewindAndContainsNone('a', 'b', 'c');
 * }</pre>
 * <p>
 * Custom assertion classes can be used in the next extension points:
 * </p>
 * <ul>
 * <li>{@link ru.d_shap.assertions.Assertions#assertThat(java.lang.Object, java.lang.Class)}</li>
 * <li>{@link ru.d_shap.assertions.Assertions#assertThat(java.lang.Object, java.lang.String, java.lang.Class)}</li>
 * <li>{@link ru.d_shap.assertions.BaseAssertion#as(java.lang.Class)}</li>
 * <li>{@link ru.d_shap.assertions.MessageAssertion#that(java.lang.Object, java.lang.Class)}</li>
 * <li>{@link ru.d_shap.assertions.MessageAssertion#that(java.lang.Object, java.lang.String, java.lang.Class)}</li>
 * </ul>
 */
package ru.d_shap.assertions;
