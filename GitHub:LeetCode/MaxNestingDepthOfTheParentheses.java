public class MaxNestingDepthOfTheParentheses {
    public int maxDepth(String s) {

        int count = 0;
        int count2 = 0; 
        boolean flag = false;

        for (int i = s.length()-1; i >= 0; i--)
        {
            if (s.charAt(i) == '(')
            {
                count++;
                flag = true;
            }
            if (flag == true)
            {
                if (s.charAt(i) == ')')
                {
                    count2++;
                }
            }
            if (count2 > count)
            {
                count2--;
            }   
        }
        return count-count2;
    }    
}
