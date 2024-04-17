package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed
 * characters of S with all the even-indexed characters of S, this process should be repeated N times.
 *
 * Examples:
 *
 * encrypt("012345", 1)  =>  "135024"
 * encrypt("012345", 2)  =>  "135024"  ->  "304152"
 * encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
 *
 * encrypt("01234", 1)  =>  "13024"
 * encrypt("01234", 2)  =>  "13024"  ->  "32104"
 * encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
 * Together with the encryption function, you should also implement a decryption function which reverses the process.
 *
 * If the string S is an empty value or the integer N is not positive, return the first argument without changes.
 */
public class SimpleEncryption1AlternatingSplit {

    public static String encrypt(final String text, final int n) {
        System.out.println(n);
        if (n <= 0) {
            return text;
        } else {
            String even = "";
            String odd = "";
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (i % 2 == 0) {
                    even += c;
                } else {
                    odd += c;
                }
            }
            return encrypt(odd + even, n - 1);
        }
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0) {
            return encryptedText;
        } else {
            String result = "";
            int half = encryptedText.length() / 2;
            for (int i = 0; i < half; i++) {
                char c1 = encryptedText.charAt(i);
                char c2 = encryptedText.charAt(half + i);
                result = result + c2 + "" + c1;
            }
            if (encryptedText.length() % 2 == 1) {
                result = result + encryptedText.charAt(encryptedText.length() - 1);
            }
            return decrypt(result, n - 1);
        }
    }

    @Test
    public void testDecrypt() {
        assertEquals("This is a test!", decrypt("This is a test!", 0));
        assertEquals("This is a test!", decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", decrypt("This is a test!", 4));
        assertEquals("This is a test!", decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
        assertEquals("This kata is very interesting!", decrypt("stsrnenT a ytsghk v et!iaieiri", 2));
        assertEquals("This kata is very interesting!", decrypt("treTaysh  tiiiissnn  tgkve!aer", 3));
        assertEquals("This kata is very interesting!", decrypt("rTyh iisn tkearteas tiisn gv!e", 4));
    }

    @Test
    public void testEncrypt() {
        assertEquals("This is a test!", encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", encrypt("This is a test!", 3));
        assertEquals("This is a test!", encrypt("This is a test!", 4));
        assertEquals("hsi  etTi sats!", encrypt("This is a test!", 5));
        assertEquals("This is a test!", encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", encrypt("This kata is very interesting!", 1));
        assertEquals("stsrnenT a ytsghk v et!iaieiri", encrypt("This kata is very interesting!", 2));
        assertEquals("treTaysh  tiiiissnn  tgkve!aer", encrypt("This kata is very interesting!", 3));
        assertEquals("rTyh iisn tkearteas tiisn gv!e", encrypt("This kata is very interesting!", 4));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", encrypt("", 0));
        assertEquals("", decrypt("", 0));
        assertNull(encrypt(null, 0));
        assertNull(decrypt(null, 0));
    }

}
