package practice;

public class HelloWorld{
  public static void main(String args[]) {
    System.out.println("Hello World");
    boolean[] in = new boolean[26];
    for(int i = 0; i < in.length; i++) {
      System.out.println(in[i]);
    }
    String s = "abcdefghijklmnpqrstuvwxyz";
    for(int i = 0; i < s.length(); i++) {
      System.out.println(s.codePointAt(i));
    }
  }
}
