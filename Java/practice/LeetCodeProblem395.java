package practice;

//import java.util.HashMap;

public class LeetCodeProblem395 {
  public static void main(String args[]) {
    System.out.println(longestSubstring("ababbc", 2));

  }

  public static int longestSubstring(String s, int k) {
      //HashMap<String, int[]> table = new HashMap<>();
      char []str = s.toCharArray();
      return recurse(str, 0, str.length, k);
/*
      for(int i = 0; i < s.length(); i++) {
        for(int j = i+1; j <= s.length(); j++) {
          flag = false;
          String sbstr = s.substring(i, j);
          int []counts = new int[26];
          for(int t = 0; t < sbstr.length(); t++) {
            counts[sbstr.codePointAt(t) - 97] += 1;
          }
          for(int t = 0; t < 26; t++) {
            if(counts[t] > 0 && counts[t] < k) {
              flag = true;
              break;
            }
          }
          if(!flag && len < sbstr.length()) {
            len = sbstr.length();
          }
        }
      }

      return len;
      */
  }

  public static int recurse(char []str, int start, int end, int k) {
    if(end - start < k) {
      return 0;
    }

    int []counts = new int[26];

    for(int i = start; i < end; i++) {
      counts[str[i] - 'a'] += 1;
    }

    for(int i = 0; i < 26; i++) {
      if(counts[i] > 0 &&  counts[i] < k) {
        for(int j = start; j < end; j++) {
          if(str[j] == i + 'a') {
            int left = recurse(str, start, j, k);
            int right = recurse(str, j+1, end, k);
            return Math.max(left, right);
          }
        }
      }
    }

    return end - start;
  }
}
