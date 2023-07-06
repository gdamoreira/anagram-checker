package io.beyonnex.service;

/**
 * An interface for determining if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of another word or phrase,
 * using all the original letters exactly once. For example, the words "listen" and "silent"
 * are anagrams of each other.
 *
 * @author Guilherme D'Amoreira
 */
public interface AnagramService {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param string1 the first string
     * @param string2 the second string
     * @return true if the strings are anagrams, false otherwise
     */
    boolean isAnagram(String string1, String string2);
}