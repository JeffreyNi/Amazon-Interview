/*************************************************************
 *
 * Amazon:
 * Given an array of strings, find out all strings that are anagrams
 * with each other, output them as a list. Find out all group of 
 * anagrams, output them in a list of lists.
 *
 * anagrams Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: ["tan", "nat", "eat", "tea", "ate"]
 *
 * groupAnagrams Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: 
 * [
 *   ["ate", "eat", "tea"];
 *   ["nat", "tan"],
 *   ["bat"]
 * ]
 *
 * Keyword: HashMap, sort
 *
 * @author Jiafeng Ni
 *
 *************************************************************/

import java.util.*;

public class Anagrams {
    /**
     * Find out all strings that has anagrams in the array, out put
     * them into a list.
     * @param strs array of strings where to find anagrams
     * @return list of all strings that has anagrams in the array
     */
    public static List<String> anagrams(String[] strs) {
	List<String> result = new ArrayList<String>();
	if (strs == null || strs.length == 0) { return result; }
	
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	for (int i = 0; i < strs.length; i++) {
	    char[] charArr = strs[i].toCharArray();
	    Arrays.sort(charArr);
	    String sorted = Arrays.toString(charArr);

	    if (!map.containsKey(sorted)) { 
		List<String> list = new ArrayList<String>();
		list.add(strs[i]);
		map.put(sorted, list);
	    } else {
		map.get(sorted).add(strs[i]);
	    }
	}

	Iterator iter = map.values().iterator();
	while (iter.hasNext()) {
	    List<String> list = (ArrayList<String>) iter.next();
	    if (list.size() > 1) { result.addAll(list); }
	}

	return result;
    }

    /**
     * LeetCode Problem No.49 Group Anagrams
     *
     * Given an array of strins, group anagrams together. For the return 
     * value, each inner list's elements must follow the lexicographic
     * order. All inputs will be in lower-case.
     * @param strs the given array of strings
     * @return groups of anagrams in list of lists
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
	List<List<String>> result = new ArrayList<List<String>>();
	if (strs == null || strs.length == 0) {return result;}

	Map<String, List<String>> map = new HashMap<String, List<String>>();
	for (String str : strs) {
	    char[] charArr = str.toCharArray();
	    Arrays.sort(charArr);
	    String sorted = Arrays.toString(charArr);

	    if (map.containsKey(sorted)) { map.get(sorted).add(str); }
	    else {
		List<String> list = new ArrayList<String>();
		list.add(str);
		map.put(sorted, list);
	    }
	}

	for (String key : map.keySet()) {
	    Collections.sort(map.get(key));
	}

	return new ArrayList<List<String>>(map.values());
    }



    public static void main(String[] args) {
	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
	List<String> anagrams = anagrams(strs);
	List<List<String>> group = groupAnagrams(strs);

	System.out.println(anagrams);
	System.out.println(group);	
    }
}