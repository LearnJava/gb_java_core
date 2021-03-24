package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        new App().runFindingWords();
    }

    void runFindingWords() {
        List<String> words = new ArrayList<String>();
        words.add("Аврелий" );
        words.add("Аврелия" );
        words.add("Аврея" );
        words.add("Аврора" );
        words.add("Авсей" );
        words.add("Автоном" );
        words.add("Авудим" );
        words.add("Авундий" );
        words.add("Агав" );
        words.add("Агавва" );
        words.add("Агап" );
        words.add("Агапа" );
        words.add("Агапей" );
        words.add("Агапея" );
        words.add("Агапий" );
        words.add("Агапион" );
        words.add("Агапит" );
        words.add("Агапия" );
        words.add("Агапон" );
        words.add("Агата" );
        words.add("Агафа" );
        words.add("Агафангел" );
        words.add("Агафия" );
        words.add("Аврелий" );
        words.add("Аврелия" );
        words.add("Аврея" );
        words.add("Аврора" );
        words.add("Агав" );
        words.add("Агавва" );
        words.add("Агап" );
        words.add("Агапа" );
        words.add("Агапей" );
        words.add("Агапея" );
        words.add("Агапий" );
        words.add("Агапион" );
        words.add("Агапит" );
        words.add("Агапия" );
        words.add("Агапон" );
        words.add("Агата" );
        words.add("Агап" );
        words.add("Агапа" );
        words.add("Агапей" );
        words.add("Агапея" );
        words.add("Агапий" );
        words.add("Агапион" );
        words.add("Агапит" );
        words.add("Агапия" );
        words.add("Агапон" );
        words.add("Агата" );
        printUnicWordsMethod1(words);
        System.out.println("===================");

        System.out.println("Уникальные имена... Метод второй.");
        printUnicWordsMethod2(words);
        System.out.println("===================");

        System.out.println("Список всех слов...");
        System.out.println(countAllWords(words));
    }

    private void printUnicWordsMethod2(List<String> words) {
        Map<String, Integer> wordsMap2 = new HashMap<>();

        for (String st: words) {
            wordsMap2.put(st, (int) words.stream().filter(st::equals).count());
        }
        for (Map.Entry<String, Integer> w: wordsMap2.entrySet()) {
            if (w.getValue() == 1) {
                System.out.println(w.getKey());
            }
        }
    }

    private void printUnicWordsMethod1(List<String> words) {
        Map<String, Integer> wordsMap = countAllWords(words);
        System.out.println("Уникальные имена... Метод первый.");
        for (Map.Entry<String, Integer> w: wordsMap.entrySet()) {
            if (w.getValue() == 1) {
                System.out.println(w.getKey());
            }
        }
    }

    private Map<String, Integer> countAllWords(List<String> words) {
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            Integer count = wordsMap.get(word);
            count = count == null ? 1 : count + 1;
            wordsMap.put(word, count);
        }
        return wordsMap;
    }
}
