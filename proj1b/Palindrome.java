
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> retDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            retDeque.addLast(word.charAt(i));
        }

        return retDeque;
    }

    public boolean isPalindrome(String word) {
        // any 0 or 1 word is considered a palindrome, as 61b required, e.g. "a","K"
        /** Modify: don't check if x and y are letters or not */
        if (word.length() <= 1) {
            return true;
        }
        Palindrome palindrome = new Palindrome();
        Deque<Character> origin = palindrome.wordToDeque(word);
        while (origin.size() > 1) {
            if (origin.removeFirst() != origin.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        // any 0 or 1 word is considered a palindrome, as 61b required.
        /** Modify: don't check if x and y are letters or not */
        if (word.length() <= 1) {
            return true;
        }

        Palindrome palindrome = new Palindrome();
        Deque<Character> origin = palindrome.wordToDeque(word);

        // skip the middle element if word is odd length
        while (origin.size() > 1) {
            if (!cc.equalChars(origin.removeFirst(), origin.removeLast())) {
                return false;
            }
        }
        return true;
    }

    private boolean isLetters(char x) {
        return (x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z');
    }

    private boolean oddLength(String word) {
        int flag = (word.length() % 2);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }
}
