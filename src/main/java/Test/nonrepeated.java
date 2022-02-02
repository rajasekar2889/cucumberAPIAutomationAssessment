package main.java.Test;

public class nonrepeated {
    public static void main (String[] args){
//        int r = 123;
//        String rs = String.valueOf(r);
//        System.out.println(rs);
//        String ss = "000456";
//        int nn = Integer.parseInt(ss);
//        int nn2 = Integer.valueOf(ss);
//        System.out.println(nn);
//        System.out.println(nn2);

        String s1 = "madam";
        for(int i=0 ; i < s1.length(); i++){
            boolean unique = true;
            for (int j = 0 ; j< s1.length(); j++) {
                if (i != j && s1.charAt(i) == s1.charAt(j)) {
                    unique = false;
                    break;
                }
            }
                if(unique) {
                    System.out.println("first non repeated letter is: " + s1.charAt(i));
                    break;
                }



            }
        }

    }

