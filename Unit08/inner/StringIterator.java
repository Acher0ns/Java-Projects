package inner;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {
    private String string;
    private int index;

    public StringIterator(String string) {
        this.string = string;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < string.length();
    }

    @Override
    public Character next() {
        Character character = string.charAt(index);
        index++;
        return character;
    }

    public static Iterable<Character> iterableString(String string) {
        return new Iterable<Character>() {
            @Override
            public Iterator<Character> iterator() {
                return new StringIterator(string);
            }
        };
    }

    public static void main(String[] args) {
        for (char ch : iterableString("Hello World")) {
            System.out.println(ch);
        }
    }
}
