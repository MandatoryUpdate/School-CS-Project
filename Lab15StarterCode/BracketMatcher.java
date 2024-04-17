public class BracketMatcher
{
    public static void main(String[] args)
    {

    }
	
    public static String matchBrackets(String str)
    {
        Stack<String> s = new MyStack<String>();
        String open = "{[(";
        String closed = "}])";
        for(int i = 0 ; i < str.length() ; i++)
        {
            String letter = str.substring(i, i + 1);
            if(open.indexOf(letter) > -1){
                s.push(letter);
            }
            else if(closed.indexOf(letter) > - 1){
                if(s.isEmpty()){
                    return "Too many closing brackets";
                }
                else{
                    if(open.indexOf(s.pop()) != closed.indexOf(letter))
                    {
                        return "Bracket mismatch";
                    }
                }
            }
        }
        if(s.isEmpty())
            return "Balanced";
        return "Not enough closing brackets";
    }
}