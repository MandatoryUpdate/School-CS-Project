import java.util.regex.*;
public class Palindrome
{
    public static void main(String[] args)
    {
        String first = "Rise to vote, sir";
        System.out.println(isPalindrome(first));
        
    }
    
    public static boolean isPalindrome(String str)
    {
        String legal = "abscdefghijklmnopqrstuvwxyz";
        Stack<String> s = new MyStack<String>();
        Queue<String> q = new MyQueue<String>();  
        String letter = " ";
        for(int i = 0 ; i < str.length() ; i++)
        {
            letter = str.substring(i, i+1);
            if(legal.indexOf(letter.toLowerCase()) > -1 )
            {
                s.push(letter.toLowerCase());
                q.add(letter.toLowerCase());
            }
        }
        
        for(int i = 0 ; i < q.size() ; i++)
        {
            if(!(q.remove().equals(s.pop())))
                return false;
        }
        return true;
    }
}