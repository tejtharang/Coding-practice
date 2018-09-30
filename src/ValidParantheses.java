import java.util.List;
import java.util.ArrayList;
public class ValidParantheses {
    public static boolean isValid(String s) {
        String [] str = s.split("");
        List<String> list = new ArrayList<String>();
        for(int i=0;i<str.length;i++){
            if(str[i].equals("(") || str[i].equals("{") || str[i].equals("["))
                list.add(str[i]);
            else if(str[i].equals( ")"))
            {    if(list.size() == 0)
                return false;
            else if(!list.get(list.size()-1).equals ("("))
                return false;
            else
                list.remove(list.size()-1);
            }
            else if(str[i].equals("]"))
            {    if(list.size() == 0)
                return false;
            else if(!list.get(list.size()-1).equals("["))
                return false;
            else
                list.remove(list.size()-1);
            }
            else if(str[i].equals("}"))
            {    if(list.size() == 0)
                return false;
            else if(!list.get(list.size()-1).equals("{"))
                return false;
            else
                list.remove(list.size()-1);
            }

        }
        if(list.size() == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
