import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator obo = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("flke", obo));
        assertTrue(palindrome.isPalindrome("f", obo));
        assertFalse(palindrome.isPalindrome("APPLE", obo));
    }
}
