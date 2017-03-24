package com.password;

import java.util.HashSet;

/**
 * This class is used to validate an input password based on defined parameters.
 */

public class ValidatePassword {

    boolean containVowel(String inputString) {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        for(Character c: inputString.toCharArray()) {
            if(vowel.contains(c)) {
                return true;
            }
        }
        return false;
    }

    boolean twoConsecutiveVowel(String inputString) {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = inputString.toCharArray();

        for(int i = 0; i < inputString.length() - 1; i++) {
            if(!Character.isLetter(inputStringArray[i])) {
                continue;
            }
            if(vowel.contains(inputStringArray[i]) && vowel.contains(inputStringArray[i+1])) {
                return true;
            }
        }

        return false;
    }

    boolean twoConsecutiveConsonant(String inputString) {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = inputString.toCharArray();

        for(int i = 0; i < inputString.length() - 1; i++) {
            if(Character.isLetter(inputStringArray[i])) {
                if(!vowel.contains(inputStringArray[i]) && !vowel.contains(inputStringArray[i+1])) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean twoConsecutiveLetters(String inputString) {
        char[] inputStringArray = inputString.toCharArray();

        for(int i = 0; i < inputString.length() - 1; i++) {
            if(Character.isLetter(inputStringArray[i])) {
                if (inputStringArray[i] == inputStringArray[i + 1]) {
                    if(inputStringArray[i] == 'e' || inputStringArray[i] == 'o') {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    boolean isValidLength(String inputString) {
        if(inputString.length() > 0 && inputString.length() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    boolean isLowerCase(String inputString) {
        char[] inputStringArray = inputString.toCharArray();

        for(int i = 0; i < inputString.length(); i++) {
            if(!Character.isLowerCase(inputStringArray[i])) {
                return false;
            }
        }

        return true;
    }

    boolean isLatinAlphabet(String inputString) {
        return inputString.matches("\\w+");
    }

    boolean isValidPassword(String inputPassword) {
        return true;
    }
}
