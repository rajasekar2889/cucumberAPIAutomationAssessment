package tests;

import java.util.ArrayList;
import java.util.List;

////Given a string, find the first non-repeating character in it.
//// For example, if the input string is "total", then the output
//// should be 'o' and if the input string is "madam", then the output should be 'd'.
public class testing
{

   // String s = "total";

    public void findNonRepeat(String inputStr){
        for(char i :inputStr.toCharArray()){
            if ( inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
                System.out.println("First non-repeating character is: "+i);
                break;
            }
        }
    }



    public static void main(String args[]){

        testing t = new testing();
        t.findNonRepeat("tatal");
    }
}


//let findNonRepeat() = function(String string){
//
//    s[]= string.split("")
//
//        for(int i =0;i<s.length;i++){
//            let a = s[i] t
//        let flag =0;
//        for(int j=i+1;j<s.length;j++){
//        let b=s[j]
//
//        if(a==b){
//        flag++
//        }
//        else if(flag==0){
//        console.log(`first non repeative letter is{s[i]}`)
//        }
//        }
//        }
//        }
//findNonrepeat("total")

