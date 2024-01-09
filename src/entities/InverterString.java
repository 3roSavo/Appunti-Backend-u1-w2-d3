package entities;

public class InverterString {
    public String modify(String string) {
        String[] word = string.split("");
        String invertedWord = "";
        for (int i = word.length -1; i >= 0; i--) {
            invertedWord = invertedWord + word[i];
        }
        return invertedWord;
    }
}
