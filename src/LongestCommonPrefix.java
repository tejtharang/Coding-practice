public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length() -1);
            }
        }
        return prefix;
    }

    public static void main(String []  args){
        System.out.println("Hello");
    }
}
