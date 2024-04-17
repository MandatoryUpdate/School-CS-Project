public class Lab10Part1
{
    public static void main(String[] args)
    {
        MyArrayList list = new MyArrayList();
        list.add("cheese");
        list.add("cream");
        list.add("butter");
        list.add("milk");
        list.add("yogurt");
        int rand = (int)(Math.random()* list.size());
        String day = (String)list.get(rand);
        System.out.println(day.toUpperCase());
    }
}