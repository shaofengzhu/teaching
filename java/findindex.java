public class findindex
{
    public static void main(String[] args)
    {
        String s = "Hello, world";
        char ch = 'w';

        int index = indexOf(s, ch);
        System.out.println(index);
    }

    private static int indexOf(String s, char ch)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (ch == s.charAt(i))
            {
                return i;
            }
        }

        return -1;
    }
}