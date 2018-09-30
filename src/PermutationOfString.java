import java.util.Scanner;

public class PermutationOfString {
    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner s = new Scanner(System.in);
        String str = s.next();
        permute(str,0,str.length()-1);
    }

    public static void permute(String str, int l, int r){
        if(l == r)
            System.out.println(str);
        else{
            for(int i=l;i<=r;i++) {
                str = swap(str, l, i);
                permute(str, l+1, i);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String str, int l, int r){
        char [] array = str.toCharArray();
        char temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        return String.valueOf(array);

    }
}
