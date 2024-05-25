class Solution 
{
    public int reverse(int x) {
        String xString = Integer.toString(x);
        boolean isNegative = xString.charAt(0) == '-';
        
        StringBuilder sb = new StringBuilder(isNegative ? xString.substring(1) : xString);
        String reversedString = sb.reverse().toString();
        
        try {
            int reversed = Integer.parseInt(reversedString);
            return isNegative ? -reversed : reversed;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}