public class OffByN implements CharacterComparator{
    /** Declare variables */
    private int diff;

    /** Constructor */
    public OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
