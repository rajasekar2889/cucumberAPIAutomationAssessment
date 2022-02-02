package main.java.Test;

public class test {
    public static void main(String[] args) {
        String str = "RAJ";
        char chars[] = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

        String s1= "TEST";
        StringBuilder s2 = new StringBuilder(s1);
        s2 = s2.reverse();
        System.out.println(s2);
    }


}