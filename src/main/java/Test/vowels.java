package Test;

public class vowels {
    public static void main (String[] args){
        int vCount =0;
        int cCount=0;
        int sCount=0;
        String s1 = "educationsssss";
        char ch[] = s1.toCharArray();
        for(int i=0 ;i<ch.length;i++){
            if(ch[i] =='s'){
                sCount++;
            }
            if(ch[i] =='a'||ch[i] =='e'||ch[i] =='i'||ch[i] =='o'||ch[i] =='u'){
                vCount++;
            }
            else{
                cCount++;
            }
        }
        System.out.println("SCount" + sCount);
        System.out.println(vCount); System.out.println(cCount);



    }
}
