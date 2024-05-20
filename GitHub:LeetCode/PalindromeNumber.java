class PalindromeNumber {
    public boolean isPalindrome(int x) {
        
        //for loop that flips the whole value
        String num = String.valueOf(x);

        String[] regular = new String[num.length()];
        
        String[] flipped = new String[num.length()];

        int base = 0;
        int counter = 1;

        int j = String.valueOf(x).length();

        for(int i = String.valueOf(x).length()-1; base < num.length(); i--)
        {
            regular[base] = num.substring(base, counter);
            flipped[base] = num.substring(i,j);
            base++;
            counter++;
            j--;
        }

        if (Arrays.equals(regular, flipped))
        {
            return true;
        }
        return false;
    }
}