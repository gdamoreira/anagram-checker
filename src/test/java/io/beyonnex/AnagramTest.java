package io.beyonnex;

import io.beyonnex.service.AnagramService;
import io.beyonnex.service.DefaultAnagramService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AnagramTest {

    private AnagramService anagramService;

    @BeforeAll
    public void setUp() {
        anagramService = new DefaultAnagramService();
    }

    @Test
    public void testValidAnagram() {
        boolean result = anagramService.isAnagram("listen", "silent");
        Assertions.assertTrue(result);
    }

    @Test
    public void testInvalidAnagram() {
        boolean result = anagramService.isAnagram("hello", "world");
        Assertions.assertFalse(result);
    }

    @Test
    public void testEmptyStrings() {
        boolean result = anagramService.isAnagram("", "");
        Assertions.assertTrue(result);
    }

    @Test
    public void testDifferentLength() {
        boolean result = anagramService.isAnagram("abcd", "abcde");
        Assertions.assertFalse(result);
    }

    @Test
    public void testCaseInsensitive() {
        boolean result = anagramService.isAnagram("Listen", "silent");
        Assertions.assertTrue(result);
    }

    @Test
    public void testWithSpaces() {
        boolean result = anagramService.isAnagram("funeral", "real fun");
        Assertions.assertTrue(result);
    }

    @Test
    public void testWithSpecialCharacters() {
        boolean result = anagramService.isAnagram("hello!", "!olleh");
        Assertions.assertTrue(result);
    }

    @Test
    public void testWithNumbers() {
        boolean result = anagramService.isAnagram("12345", "54321");
        Assertions.assertTrue(result);
    }

    @Test
    public void testSameCharactersDifferentOrder() {
        boolean result = anagramService.isAnagram("aaaabbbb", "bbaaaabb");
        Assertions.assertTrue(result);
    }

    @Test
    public void testLongStrings() {
        boolean result = anagramService.isAnagram("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba");
        Assertions.assertTrue(result);
    }

    @Test
    public void testSingleCharacter() {
        boolean result = anagramService.isAnagram("a", "a");
        Assertions.assertTrue(result);
    }

    @Test
    public void testSingleCharacterDifferent() {
        boolean result = anagramService.isAnagram("a", "b");
        Assertions.assertFalse(result);
    }

    @Test
    public void testMixedCaseAnagram() {
        boolean result = anagramService.isAnagram("AbC", "bCa");
        Assertions.assertTrue(result);
    }

    @Test
    public void testMixedCaseNonAnagram() {
        boolean result = anagramService.isAnagram("AbC", "bCd");
        Assertions.assertFalse(result);
    }

    @Test
    public void testMultipleSpaces() {
        boolean result = anagramService.isAnagram("a b c", "cba");
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("provideMostKnowAnagrams")
    void testMultipleKnowAnagrams(String string1, String string2, boolean expected) {
        boolean result = anagramService.isAnagram(string1, string2);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideMostKnowAnagrams() {
        return Stream.of(
                Arguments.of("listen", "silent", true),
                Arguments.of("debit card", "bad credit", true),
                Arguments.of("dormitory", "dirty room", true),
                Arguments.of("slot machines", "cash lost in me", true),
                Arguments.of("schoolmaster", "the classroom", true),
                Arguments.of("conversation", "voices rant on", true),
                Arguments.of("Elvis", "lives", true),
                Arguments.of("eleven plus two", "twelve plus one", true),
                Arguments.of("astronomer", "moon starer", true),
                Arguments.of("funeral", "real fun", true),
                Arguments.of("tired", "tried", true),
                Arguments.of("post", "stop", true),
                Arguments.of("Clint Eastwood", "Old West action", true),
                Arguments.of("cinema", "iceman", true),
                Arguments.of("dogs", "gods", true),
                Arguments.of("fun", "nun", false),
                Arguments.of("roast beef", "eat for BSE", true),
                Arguments.of("desserts", "stressed", true),
                Arguments.of("the eyes", "they see", true),
                Arguments.of("cash", "sash", false),
                Arguments.of("debit card", "crab diet", false),
                Arguments.of("carthorse", "orchestral", false),
                Arguments.of("fast", "faster", false),
                Arguments.of("tall", "taller", false),
                Arguments.of("happy", "happier", false),
                Arguments.of("big", "bigger", false),
                Arguments.of("strong", "stronger", false),
                Arguments.of("brave", "braver", false),
                Arguments.of("loud", "louder", false),
                Arguments.of("cold", "colder", false),
                Arguments.of("bright", "brighter", false),
                Arguments.of("quick", "quicker", false)
        );
    }

}