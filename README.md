Assertions framework
====================
Assertions framework provides facilities for the unit testing.
Framework allows checking of conditions via existing assertion classes.
This assertion classes make the tests more readable, understandable and maintainable.
Also this assertion classes reduce the amount of code needed to perform some complicated checks.

Import declaration for all the following examples:
```
import static ru.d_shap.assertions.Assertions.assertThat;
```

Assertion examples for the primitive data types:
```
assertThat(booleanValue).isTrue();
assertThat(byteValue).isEqualTo(5);
assertThat(shortValue).isNotEqualTo(10);
assertThat(intValue).isGreaterThan(0);
assertThat(longValue).isInRange(1L, 10L);
assertThat(floatValue).isNotNaN();
assertThat(doubleValue).isEqualTo(5.0, 0.001);
assertThat(charValue).isAlphabetic();
```

Assertion examples for the core data types:
```
assertThat(objectValue).isNotNull();
assertThat(objectValue).isNotSameAs(new Object());
assertThat(objectValue).isInstanceOf(Number.class);

assertThat(stringValue).isNotBlank();
assertThat(stringValue).isEqualTo("value");
assertThat(stringValue).containsIgnoreCase("ALU");
assertThat(stringValue).isPartOf("Some value");
assertThat(stringValue).matches("\\w+");

assertThat(classValue).isSubtypeOf(Number.class);
assertThat(classValue).hasOnePrivateConstructor();
assertThat(classValue).asEnum().hasValueCount(5);

assertThat(throwableValue).hasMessage("Exception");
```

Assertion examples for the array data types:
```
assertThat(booleanArrayValue).isEmpty();
assertThat(byteArrayValue).hasLength(3);
assertThat(shortArrayValue).contains(5);
assertThat(intArrayValue).containsAll(5, 10, 15);
assertThat(longArrayValue).containsAny(1L, 2L, 3L);
assertThat(floatArrayValue).containsNone(10.0f, 20.0f);
assertThat(charArrayValue).doesNotContain('c');
assertThat(objectArrayValue).containsAllInOrder("val1", "val2", "val3");
```

Assertion examples for the collection data types:
```
assertThat(listValue).isNotEmpty();
assertThat(listValue).hasSize(3);
assertThat(listValue).containsAll("val1", "val2", "val3");
assertThat(listValue).containsAny("val2", "val4");
assertThat(listValue).containsNone("val7", "val5");

assertThat(setValue).isEmpty();
assertThat(setValue).containsExactly("val1", "val3", "val5");

assertThat(mapValue).isNullOrEmpty();
assertThat(mapValue).hasSize(5);
assertThat(mapValue).containsAnyKey("key1", "key2", "key3");
assertThat(mapValue).containsEntry("key", "value");
assertThat(mapValue).containsNone(expectedMapValue);
```

Assertion examples for the io data types:
```
assertThat(inputStreamValue).isNextBytesEqualTo(1, 2, 3);
assertThat(inputStreamValue).isAllBytesEqualTo(10, 100, 15);
assertThat(inputStreamValue).isCompleted();

assertThat(readerValue).isNextCharsEqualTo('v', 'a', 'l', '1');
assertThat(readerValue).isAllCharsEqualTo('v', 'a', 'l', '2');
assertThat(readerValue).isCompleted();
```

Assertion examples for the nio data types:
```
assertThat(byteBufferValue).hasCapacity(10);
assertThat(shortBufferValue).hasLimit(5);
assertThat(intBufferValue).hasPosition(7);
assertThat(longBufferValue).contains(4L);
assertThat(floatBufferValue).containsExactlyInOrder(1.0f, 2.0f, 1.0f, 2.0f, 3.0f);
assertThat(doubleBufferValue).rewindAndContainsAll(5.0, 10.0, 15.0);
assertThat(charBufferValue).rewindAndContainsNone('a', 'b', 'c');
```
