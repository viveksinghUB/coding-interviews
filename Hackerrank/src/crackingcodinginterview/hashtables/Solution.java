package crackingcodinginterview.hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sravan on 10/1/16.
 */
public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        populateMap(magazineMap, magazine);
        populateMap(noteMap, note);
    }

    private void populateMap(Map<String, Integer> map, String word) {
        for(String magWord:word.split(" ")) {
            if(map.containsKey(magWord)) {
                map.put(magWord, map.get(magWord).intValue() + 1);
            }
            else {
                map.put(magWord, 1);
            }
        }
    }

    public boolean solve() {
        if(noteMap.size() > magazineMap.size()) {
            return false;
        }
        else {
            for(String noteKey:noteMap.keySet()) {
                if(!magazineMap.containsKey(noteKey)) {
                    return false;
                }
                else {
                    int noteCount = noteMap.get(noteKey);
                    int magCount = magazineMap.get(noteKey);
                    if(noteCount > magCount) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}

