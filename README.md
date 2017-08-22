Assertions framework
====================
Classes provides facilities to make the unit test assertions more readable.

The following example shows some assertions for the primitive data types:
```
assertThat(Math.max(5, 10)).isEqualTo(10);
assertThat(Math.pow(2.0, 10.0)).isGreaterThan(1000.0);
```

The following example shows some assertions for the String:
```
assertThat("value").isNotBlank();
assertThat("value").isEqualTo("value");
assertThat("value").containsIgnoreCase("ALU");
assertThat("value").isPartOf("Some value.");
assertThat("value").matches("\\w+");
```

The following example shows some assertions for the collection data types:
```
assertThat(Arrays.asList("val1", "val2", "val3")).isNotEmpty();
assertThat(Arrays.asList("val1", "val2", "val3")).hasSize(3);
assertThat(Arrays.asList("val1", "val2", "val3")).containsAny("val2", "val4");
assertThat(Arrays.asList("val1", "val2", "val3")).doesNotContain("test");

assertThat(new HashMap<>()).isEmpty();

Map<String, String> map = new HashMap<>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
assertThat(map).hasSize(3);
assertThat(map).containsEntry("key2", "value2");
assertThat(map).doesNotContainEntry("key", "value");
assertThat(map).containsAllKeys("key1", "key2", "key3");
```
