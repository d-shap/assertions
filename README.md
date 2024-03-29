# Assertions library
Assertions library provides facilities for the unit testing.
Assertions library allows checking of conditions using predefined assertions.
These assertions make tests more readable, understandable and maintainable.
Also, these assertions reduce the amount of code needed to perform some complicated checks.

Assertions library is based on the following pillars:
* The tests should be as simple and as readable, as possible
* The fail messages should be as informative, as possible

Import declaration for all the following examples:
```
import static ru.d_shap.assertions.Assertions.*;
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
assertThat(charValue).isLetter();
```

Assertion examples for the java.lang data types:
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
assertThat(booleanArrayValue).isNotNull().isEmpty();
assertThat(byteArrayValue).hasLength(3);
assertThat(shortArrayValue).contains(5);
assertThat(intArrayValue).containsAll(5, 10, 15);
assertThat(intArrayValue).hasHexString("12CC1204");
assertThat(longArrayValue).containsAny(1L, 2L, 3L);
assertThat(floatArrayValue).containsNone(10.0f, 20.0f);
assertThat(charArrayValue).doesNotContain('c');
assertThat(stringArrayValue).containsAllInOrder("val1", "val2", "val3");
```

Assertion examples for the java.util data types:
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
assertThat(mapValue).containsNone("key1", "value1", "key2", "value2", "key3", "value3");

assertThat(dateValue).hasDate(2020, Calendar.SEPTEMBER, 10);
assertThat(dateValue).hasDateAndTime(2020, Calendar.SEPTEMBER, 10, 11, 30, 0);
assertThat(calendarValue).hasUtcDateAndTime(2020, Calendar.SEPTEMBER, 10, 11, 30, 0);
assertThat(calendarValue).hasTimeZoneDate(2020, Calendar.SEPTEMBER, 10, "UTC");
assertThat(calendarValue).hasTimeZoneTime(11, 30, 0, 500, "GMT");
```

Assertion examples for the java.io data types:
```
assertThat(inputStreamValue).isNextBytesEqualTo(1, 2, 3);
assertThat(inputStreamValue).isAllBytesEqualTo(10, 100, 15);
assertThat(inputStreamValue).isCompleted();

assertThat(readerValue).isNextCharsEqualTo('v', 'a', 'l', '1');
assertThat(readerValue).isAllCharsEqualTo('v', 'a', 'l', '2');
assertThat(readerValue).isCompleted();
```

Assertion examples for the java.nio data types:
```
assertThat(byteBufferValue).hasCapacity(10);
assertThat(shortBufferValue).hasLimit(5);
assertThat(intBufferValue).hasPosition(7);
assertThat(longBufferValue).contains(4L);
assertThat(longBufferValue).hasHexString("FF1234C20D");
assertThat(floatBufferValue).containsExactlyInOrder(1.0f, 2.0f, 1.0f, 2.0f, 3.0f);
assertThat(doubleBufferValue).rewindAndContainsAll(5.0, 10.0, 15.0);
assertThat(charBufferValue).rewindAndContainsNone('a', 'b', 'c');
```

Assertion examples for the javax.xml.namespace data types:
```
assertThat(qnameValue).hasNamespaceURI("http://example.com");
assertThat(qnameValue).hasLocalPart("local");
```

Assertion examples for the org.w3c.dom data types:
```
assertThat(documentValue).isEqualTo("<p>content</p>");
assertThat(documentValue).isNotEqualTo("<?xml version='1.0'?>\n<p>text 1<br/>text 2<br/>text 3</p>");

assertThat(elementValue).isEqualTo(documentValue.getDocumentElement().getFirstChild());
assertThat(elementValue).hasAttribute("http://example.com", "attrName");
assertThat(elementValue).hasAttributeValue("attrName", "attrValue");
assertThat(elementValue).hasChildNodes();
assertThat(elementValue).hasChildElementsCount(5);
```

Assertion examples for the Hamcrest matchers:
```
assertThat(intValue, is(equalTo(10)));

assertThat(longValue, instanceOf(Long.class));
assertThat(longValue, isA(Long.class));

assertThat(stringValue, isEmptyString());
assertThat(stringValue, isEmptyOrNullString());

assertThat(intArrayValue, arrayWithSize(4));
assertThat(intArrayValue, arrayContaining(7, 5, 12, 16));

assertThat(listValue, hasSize(3));
assertThat(listValue, contains(5, 2, 4));
assertThat(listValue, containsInAnyOrder(2, 4, 5));
assertThat(listValue, everyItem(greaterThan(1)));
```

# Assertions library and Hamcrest
## Too many braces
Hamcrest has the target to make tests as readable as possible.
But Hamcrest tends to use too many braces in even simple assertions.
And this braces makes tests less readable.

For example, JUnit check for equals:
```
assertEquals(expected, actual);
``` 
Hamcrest check for equals:
```
assertThat(actual, is(equalTo(expected)));
```
Assertions library check for equals:
```
assertThat(actual).isEqualTo(expected);
```

JUnit check for not equals:
```
assertNotEquals(expected, actual)
```
Hamcrest check for not equals:
```
assertThat(actual, is(not(equalTo(expected))));
```
Also, valid Hamcrest check for not equals, but with less sense:
```
assertThat(actual, not(is(equalTo(expected))));
```
Assertions library check for not equals:
```
assertThat(actual).isNotEqualTo(expected);
```

## Static import
Hamcrest assertions are readable only if static import is used.
But sometimes coding policy does not allow static import.
Or there could be several unit-testing libraries it the project that provide `assertThat` method.
In this case tests with Hamcrest matchers are not readable at all.

Hamcrest check with static import:
```
assertThat(actual, is(not(equalTo(expected))));
```
Hamcrest check without static import:
```
MatcherAssert.assertThat(actual, Matchers.is(Matchers.not(Matchers.equalTo(expected))));
```
Assertions library check with static import:
```
assertThat(actual).isNotEqualTo(expected);
```
Assertions library check without static import:
```
Assertions.assertThat(actual).isNotEqualTo(expected);
```

## Combinations of matchers
Hamcrest allows any combination of matchers in assertions:
```
assertThat(10, greaterThan(5));
assertThat(Arrays.asList(15, 20, 25, 30), everyItem(greaterThan(5)));
assertThat("value", anyOf(nullValue(), equalTo("test"), allOf(containsString("alu"), not(containsString("zzz")))));
assertThat(new HashMap<String, String>(), allOf(hasEntry(equalTo("key1"), anyOf(equalToIgnoringCase("VALUE1"), isEmptyString())), not(hasEntry(startsWith("key2"), not(equalToIgnoringCase("VALUE2"))))));
```
But some combinations of matchers do not make sense.
Also, it is too difficult to understand some complicated combinations of matchers.
The test should be as simple as possible - to prevent mistakes in the test itself.
And too complicated combinations of matchers are error prone.

Assertions library provides methods for specific combinations of assertions:
```
assertThat(intValue).isInRange(1, 4);
assertThat(intValue).isNotInRange(1, 4);

assertThat(stringValue).isNullOrBlank();
assertThat(stringValue).isNullOrEmpty();
```
This prevents creation of the error prone combinations of assertions.

Also, Assertions library provides predicates to create complicated combinations of assertions:
```
assertThat(
    or(
        () -> assertThat(list).isNull(),
        and(
            () -> assertThat(list).isNotEmpty(),
            () -> assertThat(list).contains("value")
        ),
        not(
            () -> assertThat(list).hasSize(5)
        )
    )
);
```
But this predicates make assertions more complicated and error prone.
That is why they should be avaided if it is possible. 

## Custom assertions and matchers
Custom Hamcrest matchers can be easily developed and used in assertions.
Assertions library does not support custom assertions.

But Assertions library can use Hamcrest matchers.
In this case Assertions library can be used as a main library for the unit testing.
And in case of specific assertions custom Hamcrest matchers can be used.

# The latest release
Assertions library:
* **&lt;groupId&gt;**: ru.d-shap
* **&lt;artifactId&gt;**: assertions
* **&lt;version&gt;**: 2.3

# Donation
If you find my code useful, you can [bye me a coffee](https://www.paypal.me/dshapovalov)
