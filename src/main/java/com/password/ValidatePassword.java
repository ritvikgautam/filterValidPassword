package com.password;

import java.util.HashSet;

/**
 * This class is used to validate an input password based on defined parameters.
 */

public class ValidatePassword {

    private String password;

    ValidatePassword() {

    }

    ValidatePassword(String inputString) {
        this.password = inputString;
    }

    void setPassword(String inputString) {
        this.password = inputString;
    }

    boolean containVowel() {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        for(Character c: this.password.toCharArray()) {
            if(vowel.contains(c)) {
                return true;
            }
        }
        return false;
    }

    boolean twoConsecutiveVowel() {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length() - 1; i++) {
            if(!Character.isLetter(inputStringArray[i])) {
                continue;
            }
            if(vowel.contains(inputStringArray[i]) && vowel.contains(inputStringArray[i+1])) {
                return true;
            }
        }

        return false;
    }

    boolean twoConsecutiveConsonant() {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length() - 1; i++) {
            if(Character.isLetter(inputStringArray[i])) {
                if(!vowel.contains(inputStringArray[i]) && !vowel.contains(inputStringArray[i+1])) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean twoConsecutiveLetters() {
        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length() - 1; i++) {
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

    boolean isValidLength() {
        if(this.password.length() > 0 && this.password.length() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    boolean isLowerCase() {
        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length(); i++) {
            if(!Character.isLowerCase(inputStringArray[i])) {
                return false;
            }
        }

        return true;
    }

    boolean isLatinAlphabet() {
        return this.password.matches("\\w+");
    }

    boolean isValidPassword() {
        return true;
    }
}
