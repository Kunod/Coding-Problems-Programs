import java.util.*;
class ZigZag {
    public String convert(String s, int numRows) 
    {
        if (numRows == 1)
            return s;
        int width = s.length();
        char[][] zigzag = new char[numRows][width];
        for (int i = 0; i < numRows;i++)
        Arrays.fill(zigzag[i], ' ');
        for (int i = 0,j=0,k = 0;k < s.length();)
        {
            if (j == 0)
            {
                for (;j < numRows && k < s.length();j++)
                {
                    zigzag[j][i] = s.charAt(k);
                    k++;
                }
            }
            j = numRows - 2;
            i++;
            for (;j > 0&& k < s.length();j--,i++)
            {
                zigzag[j][i] = s.charAt(k);
                k++;
            }
        }
        String answer = "";
        for (int i = 0;i < numRows ;i++)
        {
            for (int j = 0;j < width;j++)
                if (zigzag[i][j] != ' ')
                    answer += zigzag[i][j];
        }
        return answer;
    }
}
