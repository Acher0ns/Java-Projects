package assignment;

import java.util.HashMap;
import java.util.Map;

import graphs.WAdjacencyGraph;
import graphs.WGraph;

public class Word {
    public static WGraph<Character> makeGraph(String word) {
        WGraph<Character> wordGraph = new WAdjacencyGraph<Character>();

        Map<Integer, Character> charMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char cahracter = word.charAt(i);
            charMap.put(i, cahracter);
            wordGraph.add(cahracter);
        }

        String wordTwice = word + reverse(word);
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);

            char nextChar1 = wordTwice.charAt(i + 1);
            char nextChar2 = wordTwice.charAt(i + 2);
            char nextChar3 = wordTwice.charAt(i + 3);
            wordGraph.connect(character, nextChar1, 1);
            wordGraph.connect(character, nextChar2, 10);
            wordGraph.connect(character, nextChar3, 100);
        }
        return wordGraph;
    }

    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    public static void main(String[] args) {
        WGraph<Character> wordGraph = makeGraph("kamron");
        System.out.println(wordGraph.dijkstrasPath('k', 'n'));
    }
}
