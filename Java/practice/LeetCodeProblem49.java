package practice;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class LeetCodeProblem49 {
    public static void main(String args[]) {
        Problem pb = new Problem();
        List<List<String>> ls = pb.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        if(ls == null) return;

        for(List<String> strls : ls) {
            System.out.println(strls);
        }
    }
}

class Problem {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs) {
            String sortedStr = sortedString(str);
            if(map.containsKey(sortedStr)) {
                (map.get(sortedStr)).add(str);
            } else {
                map.put(sortedStr, new ArrayList<String>());
                (map.get(sortedStr)).add(str);
            }
        }

        Set<String> set = map.keySet();
        String[] keys = set.toArray(new String[set.size()]);
        List<List<String>> al = new ArrayList<List<String>>();

        for(String key : keys) {
            al.add(map.get(key));
        }

        return al;
    }

    public String sortedString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
