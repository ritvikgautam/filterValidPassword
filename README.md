# Filter Valid password
Given a text file of passwords, this library creates another text file containing only **invalid** passwords.

## What is an invalid password?
An invalid password does **not** satisfy any of the following criteria.

- Must contain at least one vowel.
- Must not have more than two consecutive vowels or consonants.
- Must not have two consecutive occurances of the same letter, except for 'ee' or 'oo'.
- Each password is between 1 and 20 characters long and contains only lowercase letters of Latin alphabet.
 
The vowels are {a, e, i, o, u}. All other letters are considered consonants. 

## Execution

Compile and Run Tests: `mvn clean package`

Execute main program: `mvn exec:java -Dexec.mainClass="com.password.invalidTextFilePassword"`

Main Class Path: `src/main/java/com.password/invalidTextFilePassword.java`

Library Path: `src/main/java/com.password/ValidatePassword.java`

Test File Path: `src/test/java/com.password/ValidatePasswordTest.java`

## Examples
The output file will contain the violated rule next to each invalid password. 


| Input        
| ------------- 
| a      
| bontres      
| eep
| houctuh
| ptoui
| tv
| wiing
| zoggax

| Output    
| ------------- 
| bontres, more than two consecutive vowels or consonants 
| ptoui, more than two consecutive vowels or consonants 
| ptoui, more than two consecutive vowels or consonants 
| tv, no vowel 
| wiinq, consecutive occurrence of the same letter 
| zoggax, consecutive occurrence of the same letter
