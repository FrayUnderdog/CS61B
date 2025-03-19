public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        /** Modify: don't check if x and y are letters or not
            if (!isLetters(x) || !isLetters(y)) {
                return false;
            }
         */
        return Math.abs(x - y) == 1;
    }

    private boolean isLetters(char x) {
        return (x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z');
    }
}
