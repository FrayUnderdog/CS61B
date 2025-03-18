import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    static OffByN obn = new OffByN(2);

    @Test
    public void testOffByN() {
        assertTrue(palindrome.isPalindrome("flajd", obn));
        assertTrue(palindrome.isPalindrome("fljd", obn));
        assertTrue(palindrome.isPalindrome("f", obn));
        assertFalse(palindrome.isPalindrome("APPLE", obn));
    }
}
