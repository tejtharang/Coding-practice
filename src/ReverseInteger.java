public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    public static int reverse(int x){
        int reverse = 0;
        while(x!=0){
            int n = x%10;
            x = x/10;
            if(reverse > Integer.MAX_VALUE || (reverse == Integer.MAX_VALUE/10 && n > 7)) return 0;
            if(reverse < Integer.MIN_VALUE || (reverse == Integer.MIN_VALUE/10 && n < -8)) return 0;
            reverse = reverse *10 + n;
        }
        return reverse;
    }

}
