public class OffByN implements CharacterComparator {
    static int num;

    public void OffbyN(int N) {
        num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == num) || (y - x == num);
    }
}
