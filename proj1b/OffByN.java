public class OffByN implements CharacterComparator {
    private int num;

    public void OffbyN(int N) {
        this.num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == num;
    }
}
