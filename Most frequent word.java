//Naive Approach: Use the nested loops, compare the word from the outer loop with all the other elements using the inner loop, and count its appearances. Keep track of the word which appears the maximum number of times.

//Time Complexity: O(N2)

//Better Approach: Use Map.

//Iterate the array and construct a hashmap with the word as the key and its appearances count as value.

//Iterate the hashmap and pick the word with the maximum count.

//Time Complexity: O(N), Space Complexity: O(N)

Run This Code
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class MostFrequentWord {
    public static String findFrequentWord(String [] input){
        System.out.println("Input: " + Arrays.toString(input));
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            String word = input[i];
            int count = map.getOrDefault(word, 0);
            map.put(word, count+1);
        }
        String frequentWord=null;
        int count = 0;
        for (String key:map.keySet()){
            if(count<map.get(key)){
                count = map.get(key);
                frequentWord = key;
            }
        }
        return frequentWord;
    }
    public static void main(String[] args) {
        String [] input = {"Algorithms", "String", "Integer", "Integer",
                "Algorithms", "String", "Integer",
                "Algorithms", "String", "Algorithms"};
        System.out.println("Most frequent word: " + findFrequentWord(input));
    }
}
