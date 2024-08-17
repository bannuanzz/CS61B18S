public class Palindrome {
    public LinkedListDeque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() == 1) {
            return true;
        }
        int i = 0, j = word.length() - 1;
        while (i <= j) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
