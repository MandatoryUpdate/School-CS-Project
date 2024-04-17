import java.util.Scanner;
import java.io.*;

public class RoyalFamily 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Define a variable to store the root node
        TNode<String> root = null;
        //TODO: SETUP TREE DATA
        //1. Use Scanner to read the data.txt file
        //2. The first line in data.txt is the root node
        //3. For each line in data.txt in the format A > B
        //        - *find* the A node
        //        - add B as a child of A
        File file = new File("data.txt");
        Scanner s = new Scanner(file);
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            String[] parts = line.split(" > ");
            TNode<String> Parent = new TNode<String>(parts[0]);
            if(root == null)
            {
                root = Parent;
            }
            else
            {
                TNode<String> Child = new TNode<String>(parts[1]);
                find(root,parts[0].trim()).addChild(Child);
            }
        }
        //TODO: test printPath method
        TNode<String> child = find(root, "Princess Beatrice of York");
        String path = getPath( child );
        System.out.println(path);
    }
    
    /**
     *    @return node if its data matches name, or return a child node with data that matches name
     */
    public static TNode<String> find(TNode<String> node, String name)
    {
        //use recursion to check this node and all of its children to see if their data matches the specified name
        if(node.getData().equals(name))
        {
            return node;
        }
        for(TNode<String> child : node.getChildren())
        {
            TNode<String> check = find(child, name);
            if(check != null)
            {
                return check;
            }
        }
        return null;
    }
    
    /**
     *    @return a String containing the path from the root node to the specified node, separeated by ->
     */
    public static String getPath(TNode<String> node)
    {
        //use recursion to concatenate the getPath of this node's parent with this node's data
        if(node.getParent() == null)
        {
            return node.getData();
        }
        return getPath(node.getParent()) + " -> " + node.getData();
    }
}