public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
        int reverse = reverse(x);
        if(x!= 0 && reverse == 0){
            return false;
        }
        if(x == reverse)
            return true;
        return false;
    }
    public static int reverse(int x){
        int reverse = 0;
        while(x > reverse){
            int n = x%10;
            x = x/10;
            if(reverse > Integer.MAX_VALUE || (reverse == Integer.MAX_VALUE/10 && n > 7)) return 0;
            if(reverse < Integer.MIN_VALUE || (reverse == Integer.MIN_VALUE/10 && n < -8)) return 0;
            reverse = reverse *10 + n;
        }
        return reverse;
    }
}

