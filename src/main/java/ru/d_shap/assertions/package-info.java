///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
 * Classes provides facilities to make the unit test assertions more readable.
 * </p>
 * <p>
 * The following example shows some assertions for the primitive data types:
 * </p>
 * <pre>{@code
 * assertThat(Math.max(5, 10)).isEqualTo(10);
 * assertThat(Math.pow(2.0, 10.0)).isGreaterThan(1000.0);
 * }</pre>
 * <p>
 * The following example shows some assertions for the String:
 * </p>
 * <pre>{@code
 * assertThat("value").isNotBlank();
 * assertThat("value").isEqualTo("value");
 * assertThat("value").containsIgnoreCase("ALU");
 * assertThat("value").isPartOf("Some value.");
 * assertThat("value").matches("\\w+");
 * }</pre>
 * <p>
 * The following example shows some assertions for the collection data types:
 * </p>
 * <pre>{@code
 * assertThat(Arrays.asList("val1", "val2", "val3")).isNotEmpty();
 * assertThat(Arrays.asList("val1", "val2", "val3")).hasSize(3);
 * assertThat(Arrays.asList("val1", "val2", "val3")).containsAny("val2", "val4");
 * assertThat(Arrays.asList("val1", "val2", "val3")).doesNotContain("test");
 *
 * assertThat(new HashMap<>()).isEmpty();
 *
 * Map<String, String> map = new HashMap<>();
 * map.put("key1", "value1");
 * map.put("key2", "value2");
 * map.put("key3", "value3");
 * assertThat(map).hasSize(3);
 * assertThat(map).containsEntry("key2", "value2");
 * assertThat(map).doesNotContainEntry("key", "value");
 * assertThat(map).containsAllKeys("key1", "key2", "key3");
 * }</pre>
 */
package ru.d_shap.assertions;
