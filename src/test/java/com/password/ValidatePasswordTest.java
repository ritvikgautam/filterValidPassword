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

        Boolean returnValue = inputPassword.isLatinAlphabet("thisispassword");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.isLatinAlphabet("123");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        // TODO: this should not return false
        returnValue = inputPassword.isLatinAlphabet("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.isLatinAlphabet("ď");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testLowerCase() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.isLowerCase("thisispassword");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.isLowerCase("");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.isLowerCase("thisIsPassword");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.isLowerCase("THISISPASSWORD");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testValidLength() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.isValidLength("thisispassword");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.isValidLength("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.isValidLength("thisisareallylongpasswordthatislowercasebutisprobablyverylong");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.isValidLength("!@#$%^^");
        Assert.assertThat(returnValue, CoreMatchers.is(true));
    }

    @Test
    public void testTwoConsecutiveLetters() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.twoConsecutiveLetters("aa");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveLetters("bb");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveLetters("ee");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("oo");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("12");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("a1a");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("a!a");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters(" ");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("!@#$%");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveLetters("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testTwoConsecutiveConsonants() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.twoConsecutiveConsonant("aa");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveConsonant("abyoy");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant("boyaff");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant("by");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant("byoa");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant("a!klf");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant("!op@a");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveConsonant(" ");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveConsonant("!@#$%");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveConsonant("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testTwoConsecutiveVowels() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.twoConsecutiveVowel("aa");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveVowel("aboy");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveVowel("boya");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveVowel("by");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveVowel("byoa");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveVowel("a!eaf");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveVowel("!ae@a");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.twoConsecutiveVowel(" ");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveVowel("!@#$%");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.twoConsecutiveVowel("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testContainVowel() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.containVowel("a");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.containVowel("aboy");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.containVowel("boya");
        Assert.assertThat(returnValue, CoreMatchers.is(true));

        returnValue = inputPassword.containVowel("by");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.containVowel(" ");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.containVowel("!@#$%");
        Assert.assertThat(returnValue, CoreMatchers.is(false));

        returnValue = inputPassword.containVowel("");
        Assert.assertThat(returnValue, CoreMatchers.is(false));
    }

    @Test
    public void testValidPassword() throws Exception {
        ValidatePassword inputPassword = new ValidatePassword();

        Boolean returnValue = inputPassword.isValidPassword("thisIsPassword");

        Assert.assertThat(returnValue, CoreMatchers.is(true));
    }
}
