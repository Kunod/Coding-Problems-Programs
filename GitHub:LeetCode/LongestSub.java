import java.util.*;
import java.util.Arrays;

class LongestSub {
    public int lengthOfLongestSubstring(String s) 
    {

        int zero = 0;
        int oneIncrease = 1;
        int arrLengthNum = 0;
        int newNumber = 0;

        if (s.length() == 1) 
        {
            return 1;
        }
        //save each time theres a length of chars - in an array
        ArrayList<Integer> arrAns = new ArrayList<Integer>();
        ArrayList<String> arrList = new ArrayList<String>();

        if (s.length() == 2)
        {
            arrList = new ArrayList();
            arrList.add(s.substring(0,1));
            if (arrList.contains(s.substring(1,2)))
            {
                return 1;
            }
            else 
            {
                return 2;
            }
        }

        boolean flag = false;
        boolean secondFlag = false;

        //use newNumber to make arrLengthNum equals to it
    

        for(int i = 0; oneIncrease <= s.length();) 
        {
            
            if (arrList.contains(s.substring(zero, oneIncrease))) 
            {

                i++;
                arrList = new ArrayList();
                arrAns.add(arrLengthNum);
                arrLengthNum = 1;
                newNumber++; 
                zero = newNumber;
                oneIncrease = zero+1;
                arrList.add(s.substring(zero, oneIncrease));
                flag = true;       
            }
            else
            {
                arrList.add(s.substring(zero, oneIncrease));
                arrLengthNum++;
                oneIncrease++;
                zero++;
            }
            
            if (flag == true)
            {
                zero++;
                oneIncrease++;
            }

            if (oneIncrease > s.length())
            {
                arrAns.add(arrLengthNum);
            }
            flag = false;
            
            }

        //use the array to find the highest num

        int answerBefore = 0;
        int answer = 0;

        for (int i = 0; i < arrAns.size(); i++) 
        {
            answerBefore = arrAns.get(i);
            if (answerBefore >= answer) 
            {
                answer = answerBefore;
            }

        }
        return answer;

    }
}
