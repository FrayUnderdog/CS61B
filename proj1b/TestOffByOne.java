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
        assertTrue(palindrome.isPalindrome("1#2", offByOne));  // 数字和符号
        assertTrue(palindrome.isPalindrome("A@B", offByOne)); // 大写和符号
        assertTrue(palindrome.isPalindrome("#", offByOne));    // 只有一个符号
    }
}
