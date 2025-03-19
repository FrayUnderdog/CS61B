import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("flke", offByOne));
        assertTrue(palindrome.isPalindrome("f", offByOne));
        assertFalse(palindrome.isPalindrome("APPLE", offByOne));
        assertFalse(palindrome.isPalindrome("Flake", offByOne));
        assertFalse(palindrome.isPalindrome("%", offByOne));
    }
}
