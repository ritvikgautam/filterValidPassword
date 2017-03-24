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
        Boolean returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("abyoy");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("boyaff");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("by");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("byoa");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("a!klf");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("!op@a");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.twoConsecutiveConsonant();
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testTwoConsecutiveVowels() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        inputPassword.setPassword("aa");
        Boolean returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("aboy");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("boya");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("by");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("byoa");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("a!eaf");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword("!ae@a");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        inputPassword.setPassword(" ");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("!@#$%");
        returnValue = inputPassword.twoConsecutiveVowel();
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        inputPassword.setPassword("");
        returnValue = inputPassword.twoConsecutiveVowel();
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
    }
}
