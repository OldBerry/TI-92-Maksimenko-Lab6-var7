import java.util.Random;

import static java.lang.System.exit;

class Linkedlist {

    private class Node {

        int key;
        String value;
        Node link;
    }
    Node top;
    Linkedlist()
    {
        this.top = null;
    }

    public void push(int key, String value)
    {

        Node temp = new Node();

        temp.key = key;
        temp.value = value;

        temp.link = top;

        top = temp;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void display()
    {
        if (top == null) {
            System.out.print("Stack is empty\n");
        }
        else {
            Node temp = top;
            System.out.print("Stack: ");
            while (temp != null) {

                System.out.printf("%d => %s  ", temp.key, temp.value);
                temp = temp.link;
            }
            System.out.printf("\n");
        }
    }
}
//________________________________

public class Hash {
    Linkedlist[] HashTable;
    int slots = 20;

    public Hash()
    {
        HashTable = new Linkedlist[slots];
        for (int i = 0; i < slots; i++)
            HashTable[i] = new Linkedlist();
    }

    int GetHash(int key)
    {
        return (int)Math.floor(20*(key%0.956));
    }

    public void put(int key, String value)
    {
        int HashIndex=GetHash(key);
        Linkedlist NeededList = HashTable[HashIndex];
        NeededList.push(key, value);
    }

    public void displaynode (int node)
    {
        Linkedlist NeededList = HashTable[node];
        NeededList.display();
    }


    public static void main(String[] args)
    {
        Hash map = new Hash();


        for(int i=0; i<=100; i++)
        {
            map.put(generateRandomNumber(), generateRandomWords(5));
        }
        for(int i = 0; i<20; i++)
        {
            map.displaynode(i);
        }

    }

    public static String generateRandomWords(int number) //n
    {
        String randomStrings;
        Random random = new Random();

        char[] word = new char[number];
        for(int j = 0; j < word.length; j++)  //n
        {
            word[j] = (char)('a' + random.nextInt(26));
        }
        randomStrings = new String(word);

        return randomStrings;
    }

    public static int generateRandomNumber() //n
    {
        int random_number;
        Random random = new Random();
        random_number = random.nextInt(50);
        return random_number;
    }


}
