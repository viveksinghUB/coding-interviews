package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sravan on 9/18/16.
 */
public class GroupAnagrams {

    public static Map<Character, Integer> alphabetMap = new HashMap<>();

    static
    {
        alphabetMap.put('a', 1);
        alphabetMap.put('b', 2);
        alphabetMap.put('c', 3);
        alphabetMap.put('d', 4);
        alphabetMap.put('e', 5);
        alphabetMap.put('f', 6);
        alphabetMap.put('g', 7);
        alphabetMap.put('h', 8);
        alphabetMap.put('i', 9);
        alphabetMap.put('j', 10);
        alphabetMap.put('k', 11);
        alphabetMap.put('l', 12);
        alphabetMap.put('m', 13);
        alphabetMap.put('n', 14);
        alphabetMap.put('o', 15);
        alphabetMap.put('p', 16);
        alphabetMap.put('q', 17);
        alphabetMap.put('r', 18);
        alphabetMap.put('s', 19);
        alphabetMap.put('t', 10);
        alphabetMap.put('u', 21);
        alphabetMap.put('v', 22);
        alphabetMap.put('w', 23);
        alphabetMap.put('x', 24);
        alphabetMap.put('y', 25);
        alphabetMap.put('z', 26);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> anagramGroup = new ArrayList<>();

        for(int i=0; i<strs.length; i++)
        {

        }

        return anagramGroup;

    }

    public static void main(String[] args) {

    }
}
