package io.beyonnex.api;

import io.beyonnex.service.AnagramService;
import jakarta.inject.Inject;

import java.util.logging.Logger;

/**
 * An API class that uses the AnagramService to check if two strings are anagrams.
 *
 * @author Guilherme D'Amoreira
 */
public class AnagramApi {

    private final Logger log = Logger.getLogger(AnagramApi.class.getName());

    private final AnagramService anagramService;

    /**
     * Constructs an instance of AnagramApi with the specified AnagramService.
     *
     * @param anagramService the AnagramService to use for checking anagrams
     */
    @Inject
    public AnagramApi(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    /**
     * Runs the anagram check on the given strings.
     *
     * @param string1 the first string
     * @param string2 the second string
     */
    public void run(String string1, String string2) {
        boolean isAnagram = this.anagramService.isAnagram(string1, string2);
        if (isAnagram) {
            log.info(String.format("The following strings \"%s\" and \"%s\" are anagram.", string1, string2));
        } else {
            log.info(String.format("The following strings \"%s\" and \"%s\" are not anagram.", string1, string2));
        }
    }

}
