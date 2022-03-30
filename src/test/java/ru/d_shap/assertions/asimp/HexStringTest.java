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
package ru.d_shap.assertions.asimp;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link HexString}.
 *
 * @author Dmitry Shapovalov
 */
public final class HexStringTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public HexStringTest() {
        super();
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addByteValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue((byte) 0);
        Assertions.assertThat(hexString01).hasToString("00");

        HexString hexString02 = new HexString();
        hexString02.addValue((byte) 1);
        Assertions.assertThat(hexString02).hasToString("01");

        HexString hexString03 = new HexString();
        hexString03.addValue((byte) 31);
        Assertions.assertThat(hexString03).hasToString("1f");

        HexString hexString04 = new HexString();
        hexString04.addValue((byte) 100);
        Assertions.assertThat(hexString04).hasToString("64");

        HexString hexString05 = new HexString();
        hexString05.addValue(Byte.MAX_VALUE);
        Assertions.assertThat(hexString05).hasToString("7f");

        HexString hexString06 = new HexString();
        hexString06.addValue((byte) -1);
        Assertions.assertThat(hexString06).hasToString("ff");

        HexString hexString07 = new HexString();
        hexString07.addValue((byte) -100);
        Assertions.assertThat(hexString07).hasToString("9c");

        HexString hexString08 = new HexString();
        hexString08.addValue(Byte.MIN_VALUE);
        Assertions.assertThat(hexString08).hasToString("80");
        hexString08.addValue((byte) 44);
        Assertions.assertThat(hexString08).hasToString("802c");
        hexString08.addValue((byte) -97);
        Assertions.assertThat(hexString08).hasToString("802c9f");
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addShortValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue((short) 0);
        Assertions.assertThat(hexString01).hasToString("0000");

        HexString hexString02 = new HexString();
        hexString02.addValue((short) 1);
        Assertions.assertThat(hexString02).hasToString("0001");

        HexString hexString03 = new HexString();
        hexString03.addValue((short) 31);
        Assertions.assertThat(hexString03).hasToString("001f");

        HexString hexString04 = new HexString();
        hexString04.addValue((short) 479);
        Assertions.assertThat(hexString04).hasToString("01df");

        HexString hexString05 = new HexString();
        hexString05.addValue((short) 7311);
        Assertions.assertThat(hexString05).hasToString("1c8f");

        HexString hexString06 = new HexString();
        hexString06.addValue(Short.MAX_VALUE);
        Assertions.assertThat(hexString06).hasToString("7fff");

        HexString hexString07 = new HexString();
        hexString07.addValue((short) -1);
        Assertions.assertThat(hexString07).hasToString("ffff");

        HexString hexString08 = new HexString();
        hexString08.addValue((short) -100);
        Assertions.assertThat(hexString08).hasToString("ff9c");

        HexString hexString09 = new HexString();
        hexString09.addValue(Short.MIN_VALUE);
        Assertions.assertThat(hexString09).hasToString("8000");
        hexString09.addValue((short) 10347);
        Assertions.assertThat(hexString09).hasToString("8000286b");
        hexString09.addValue((short) -22978);
        Assertions.assertThat(hexString09).hasToString("8000286ba63e");
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addIntegerValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue(0);
        Assertions.assertThat(hexString01).hasToString("00000000");

        HexString hexString02 = new HexString();
        hexString02.addValue(1);
        Assertions.assertThat(hexString02).hasToString("00000001");

        HexString hexString03 = new HexString();
        hexString03.addValue(31);
        Assertions.assertThat(hexString03).hasToString("0000001f");

        HexString hexString04 = new HexString();
        hexString04.addValue(479);
        Assertions.assertThat(hexString04).hasToString("000001df");

        HexString hexString05 = new HexString();
        hexString05.addValue(7311);
        Assertions.assertThat(hexString05).hasToString("00001c8f");

        HexString hexString06 = new HexString();
        hexString06.addValue(102351);
        Assertions.assertThat(hexString06).hasToString("00018fcf");

        HexString hexString07 = new HexString();
        hexString07.addValue(1300879);
        Assertions.assertThat(hexString07).hasToString("0013d98f");

        HexString hexString08 = new HexString();
        hexString08.addValue(26461823);
        Assertions.assertThat(hexString08).hasToString("0193c67f");

        HexString hexString09 = new HexString();
        hexString09.addValue(Integer.MAX_VALUE);
        Assertions.assertThat(hexString09).hasToString("7fffffff");

        HexString hexString10 = new HexString();
        hexString10.addValue(-1);
        Assertions.assertThat(hexString10).hasToString("ffffffff");

        HexString hexString11 = new HexString();
        hexString11.addValue(-100);
        Assertions.assertThat(hexString11).hasToString("ffffff9c");

        HexString hexString12 = new HexString();
        hexString12.addValue(Integer.MIN_VALUE);
        Assertions.assertThat(hexString12).hasToString("80000000");
        hexString12.addValue(55023845);
        Assertions.assertThat(hexString12).hasToString("80000000034798e5");
        hexString12.addValue(-11038295);
        Assertions.assertThat(hexString12).hasToString("80000000034798e5ff5791a9");
    }

    /**
     * {@link HexString} class test.
     */
    @Test
    public void addLongValueTest() {
        HexString hexString01 = new HexString();
        hexString01.addValue(0L);
        Assertions.assertThat(hexString01).hasToString("0000000000000000");

        HexString hexString02 = new HexString();
        hexString02.addValue(1L);
        Assertions.assertThat(hexString02).hasToString("0000000000000001");

        HexString hexString03 = new HexString();
        hexString03.addValue(31L);
        Assertions.assertThat(hexString03).hasToString("000000000000001f");

        HexString hexString04 = new HexString();
        hexString04.addValue(479L);
        Assertions.assertThat(hexString04).hasToString("00000000000001df");

        HexString hexString05 = new HexString();
        hexString05.addValue(7311L);
        Assertions.assertThat(hexString05).hasToString("0000000000001c8f");

        HexString hexString06 = new HexString();
        hexString06.addValue(102351L);
        Assertions.assertThat(hexString06).hasToString("0000000000018fcf");

        HexString hexString07 = new HexString();
        hexString07.addValue(1300879L);
        Assertions.assertThat(hexString07).hasToString("000000000013d98f");

        HexString hexString08 = new HexString();
        hexString08.addValue(26461823L);
        Assertions.assertThat(hexString08).hasToString("000000000193c67f");

        HexString hexString09 = new HexString();
        hexString09.addValue(5663606399L);
        Assertions.assertThat(hexString09).hasToString("000000015193c67f");

        HexString hexString10 = new HexString();
        hexString10.addValue(1998528431743L);
        Assertions.assertThat(hexString10).hasToString("000001d15193c67f");

        HexString hexString11 = new HexString();
        hexString11.addValue(459395365586559L);
        Assertions.assertThat(hexString11).hasToString("0001a1d15193c67f");

        HexString hexString12 = new HexString();
        hexString12.addValue(78149847602153087L);
        Assertions.assertThat(hexString12).hasToString("0115a4df5193c67f");

        HexString hexString13 = new HexString();
        hexString13.addValue(Long.MAX_VALUE);
        Assertions.assertThat(hexString13).hasToString("7fffffffffffffff");

        HexString hexString14 = new HexString();
        hexString14.addValue(-1L);
        Assertions.assertThat(hexString14).hasToString("ffffffffffffffff");

        HexString hexString15 = new HexString();
        hexString15.addValue(-100L);
        Assertions.assertThat(hexString15).hasToString("ffffffffffffff9c");

        HexString hexString16 = new HexString();
        hexString16.addValue(Long.MIN_VALUE);
        Assertions.assertThat(hexString16).hasToString("8000000000000000");
        hexString16.addValue(165436834109822375L);
        Assertions.assertThat(hexString16).hasToString("8000000000000000024bbfec91e195a7");
        hexString16.addValue(-12321947394758339L);
        Assertions.assertThat(hexString16).hasToString("8000000000000000024bbfec91e195a7ffd439410e98293d");
    }

}
