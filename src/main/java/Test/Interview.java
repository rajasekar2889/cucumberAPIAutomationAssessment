package Test;

public class Interview {

    public static String reverseString(String str){

        String[] arr = str.split(" ");
        String fs ="";
        for(int i =0;i< arr.length;i++) {
            String r = "";
            r = arr[i];
//            StringBuffer rs  = new StringBuffer(r);
//            rs = rs.reverse();
            char ch[]=r.toCharArray();

            for (int j = ch.length-1; j >= 0; j--) {
                fs=fs + ch[j] ;
            }
            fs = fs + " ";
        }

        System.out.println(fs.trim());
        return fs.trim();
    }

    public static void main (String args[]) {
        //Interview obj = new Interview();
        String str = "my name is raj";
        reverseString(str);

        }

    }
