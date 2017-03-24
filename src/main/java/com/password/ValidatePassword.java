package com.password;

import java.io.FileReader;
import java.util.*;

/**
 * This class is used to validate an input password based on defined parameters.
 */

public class ValidatePassword {

    private String password;
    private String reason;

    // Constructors to get input password
    ValidatePassword() {

    }

    ValidatePassword(String inputString) {
        this.password = inputString;
    }

    // Set password
    void setPassword(String inputString) {
        this.password = inputString;
    }

    // Set reasons for invalid password, if any.
    private String setReason() {
        if(!containVowel()) {
            this.reason = "no vowel";
        } else if(!twoConsecutiveLetters()) {
            this.reason = "consecutive occurrence of the same letter";
        } else if(!threeConsecutiveConsonant() || !threeConsecutiveVowel()) {
            this.reason = "more than two consecutive vowels or consonants";
        } else if(!isValidLength()) {
            this.reason = "length is not between 0 and 20";
        } else if(!isLowerCase()) {
            this.reason = "contains upper case characters";
        } else if(!isLatinAlphabet()) {
            this.reason = "contains non latin characters";
        }

        return this.reason;
    }

    // Returns the reason if invalid password
    String getReason() {
        setReason();
        return this.reason;
    }

    // Checks if the password contains a vowel
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

    // Checks if the password contains three consecutive vowels
    boolean threeConsecutiveVowel() {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length() - 2; i++) {
            if(!Character.isLetter(inputStringArray[i])) {
                continue;
            }
            if(vowel.contains(inputStringArray[i]) && vowel.contains(inputStringArray[i+1]) && vowel.contains(inputStringArray[i+2])) {
                return true;
            }
        }

        return false;
    }

    // Check if the password contains three consecutive consonants.
    boolean threeConsecutiveConsonant() {
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length() - 2; i++) {
            if(Character.isLetter(inputStringArray[i])) {
                if(!vowel.contains(inputStringArray[i]) && !vowel.contains(inputStringArray[i+1]) && !vowel.contains(inputStringArray[i+2])) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the password contains two consecutive letters. 'ee' and 'oo' are exceptions.
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

    // Check if the length of password is between 0 and 20.
    boolean isValidLength() {
        if(this.password.length() > 0 && this.password.length() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // Check if all characters in password are in lower case.
    boolean isLowerCase() {
        char[] inputStringArray = this.password.toCharArray();

        for(int i = 0; i < this.password.length(); i++) {
            if(!Character.isLowerCase(inputStringArray[i])) {
                return false;
            }
        }

        return true;
    }

    // Check if all characters in password are in Latin
    boolean isLatinAlphabet() {
        return this.password.matches("\\w+");
    }

    // Checks if the password is a valid password based on the given parameters.
    boolean isValidPassword() {
        if(isValidLength()) {
            if(isLowerCase()) {
                if(isLatinAlphabet()) {
                    if(containVowel()) {
                        if(!twoConsecutiveLetters()) {
                            if(!threeConsecutiveConsonant()) {
                                if(!threeConsecutiveVowel()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // Returns a list of invalid passwords, along with the reasons, given an input of passwords as FileReader
    ArrayList<String> isValidPassword(FileReader inputFile) {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner inputScanner = new Scanner(inputFile);

        while(inputScanner.hasNext()) {
            String currentPassword = inputScanner.next();
            setPassword(currentPassword);
            if(!isValidPassword()) {
                String temp = currentPassword + ", " + getReason() + "\n";
                lines.add(temp);
            }
        }

        return lines;
    }
}
