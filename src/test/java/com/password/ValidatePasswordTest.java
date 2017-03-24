package com.password;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * This is a test file for the Validate Password class.
 */
public class ValidatePasswordTest {
    @Test
    public void testLatinAlphabet() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("thisispassword");
        Boolean returnValue = inputPassword.isLatinAlphabet();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("123");
        returnValue = inputPassword.isLatinAlphabet();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        // TODO: this should not return false
        inputPassword.setPassword("");
        returnValue = inputPassword.isLatinAlphabet();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("ď");
        returnValue = inputPassword.isLatinAlphabet();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testLowerCase() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("thisispassword");
        Boolean returnValue = inputPassword.isLowerCase();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("");
        returnValue = inputPassword.isLowerCase();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("thisIsPassword");
        returnValue = inputPassword.isLowerCase();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("THISISPASSWORD");
        returnValue = inputPassword.isLowerCase();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testValidLength() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("thisispassword");
        Boolean returnValue = inputPassword.isValidLength();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("");
        returnValue = inputPassword.isValidLength();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("thisisareallylongpasswordthatislowercasebutisprobablyverylong");
        returnValue = inputPassword.isValidLength();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%^^");
        returnValue = inputPassword.isValidLength();
        Assert.assertThat(returnValue, CoreMatchers.is(true));
    }

    @Test
    public void testTwoConsecutiveLetters() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("aa");
        Boolean returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("bb");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("ee");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("oo");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("12");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("a1a");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("a!a");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.twoConsecutiveLetters();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testTwoConsecutiveConsonants() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("aa");
        Boolean returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("aaa");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("yyyy");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("abpyoy");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("boyaftf");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("byt");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("bryoa");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("a!klf");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("!op@a");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.threeConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testTwoConsecutiveVowels() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("aaa");
        Boolean returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("aboy");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("boyaa");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("by");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("byoia");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("a!eauf");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("!ae@a");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.threeConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testContainVowel() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("a");
        Boolean returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("aboy");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("boya");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("by");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.containVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testValidPassword() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("a");
        Boolean returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("bontres");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("eep");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("houctuh");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("ptoui");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("tv");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("wiing");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("zoggax");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.isValidPassword();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }
}
