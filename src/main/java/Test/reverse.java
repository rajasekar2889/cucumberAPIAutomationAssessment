package Test;

public class reverse {
    public static void main (String[] args){
        String s1 = "I love myself";
        String[] s2 = s1.split(" ");
        String result = "";
        for(int i= s2.length-1;i>=0;i--){
            result = result+ s2[i] + " ";

        }
        System.out.println(result);
    }

}
