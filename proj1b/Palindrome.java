
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> retDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            retDeque.addLast(word.charAt(i));
        }

        return retDeque;
    }

    public boolean isPalindrome(String word) {
        // Any word of length 1 is a Palindrome, e.g. "a","K"
        // "a","K" are palindrome, but "*","%" are not
        if (word.length() == 1) {
            return isLetters(word.charAt(0));
        }
        Palindrome palindrome = new Palindrome();
        Deque<Character> origin = palindrome.wordToDeque(word);
        Deque<Character> reverse = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            reverse.addFirst(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (origin.removeFirst() != reverse.removeFirst()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        // any 0 or 1 word is considered a palindrome, as 61b required.
        // "a","K" are palindrome, but "*","%" are not
        if (word.length() == 1) {
            return isLetters(word.charAt(0));
        }

        Palindrome palindrome = new Palindrome();
        Deque<Character> origin = palindrome.wordToDeque(word);
        Deque<Character> reverse = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            reverse.addFirst(word.charAt(i));
        }

        // skip the middle element if word is odd length
        if (oddLength(word)) {
            int mid = word.length() / 2;
            for (int i = 0; i < word.length(); i++) {
                if (i == mid) {
                    continue;
                }
                if (!cc.equalChars(origin.get(i), reverse.get(i))) {
                    return false;
                }
            }
            return true;
        } else { // if word length is even
            for (int i = 0; i < word.length(); i++) {
                if (!cc.equalChars(origin.get(i), reverse.get(i))) {
                    return false;
                }
            }
            return true;
        }
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
