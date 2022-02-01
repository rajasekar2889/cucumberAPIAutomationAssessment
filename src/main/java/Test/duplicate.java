package Test;

public class duplicate {
    public static void main (String[] args){
        String s1 = "JRSAJ";
        System.out.print(s1.length());
        char chars[] = s1.toCharArray();
        for(int i=0 ; i < chars.length; i++){
            int count = 1;
            for (int j = i+1 ; j< chars.length; j++){
                if(chars[i]==chars[j] && chars[i] != ' '){
                    count++;
                    chars[j]='0';

                    if(count>1 && chars[i] != '0' ){
                        System.out.print(chars[i]);
                    }


                }

            }
        }

    }
}
