public class MySetTester
{
    public static void main(String[] args)
    {
        MySet <String> t = new MySet <String>();

    String word = "Never Gonna Give You Up";

    for(int i=0; i<word.length(); i++)

    {

       String letter = word.substring(i, i+1);

       t.add(letter);

    }

    int z = t.size();
    System.out.println(t.size());
    }
}