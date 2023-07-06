package io.beyonnex.service;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Objects;

/**
 * An implementation of the AnagramService interface that determines if two strings are anagrams of each other.
 *
 * @author Guilherme D'Amoreira
 */
public class DefaultAnagramService implements AnagramService {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param string1 the first string
     * @param string2 the second string
     * @return true if the strings are anagrams, false otherwise
     * @throws NullPointerException if either string1 or string2 is null
     */
    @Override
    public boolean isAnagram(String string1, String string2) {
        Objects.requireNonNull(string1, "string1 is required.");
        Objects.requireNonNull(string2, "string2 is required.");
        return isLetterBasedAnagram(string1, string2);
    }

    /**
     * Preprocesses a string by removing non-alphabetic characters and converting it to lowercase.
     *
     * @param source the string to preprocess
     * @return the preprocessed string
     */
    String preprocess(String source) {
        return source.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    /**
     * Checks if two preprocessed strings are anagrams of each other based on character frequency.
     *
     * @param string1 the first preprocessed string
     * @param string2 the second preprocessed string
     * @return true if the preprocessed strings are anagrams, false otherwise
     */
    boolean isLetterBasedAnagram(String string1, String string2) {
        return isAnagramMultiset(preprocess(string1), preprocess(string2));
    }

    /**
     * Checks if two preprocessed strings are anagrams of each other using multisets.
     *
     * @param string1 the first preprocessed string
     * @param string2 the second preprocessed string
     * @return true if the preprocessed strings are anagrams, false otherwise
     */
    boolean isAnagramMultiset(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        for (int i = 0; i < string1.length(); i++) {
            multiset1.add(string1.charAt(i));
            multiset2.add(string2.charAt(i));
        }
        return multiset1.equals(multiset2);
    }
}