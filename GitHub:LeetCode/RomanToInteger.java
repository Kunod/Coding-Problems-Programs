public class RomanToInteger {
    public int romanToInt(String s) {
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = 0;
            int next = 0;

            switch (s.charAt(i)) {
                case 'I':
                    current = I;
                    break;
                case 'V':
                    current = V;
                    break;
                case 'X':
                    current = X;
                    break;
                case 'L':
                    current = L;
                    break;
                case 'C':
                    current = C;
                    break;
                case 'D':
                    current = D;
                    break;
                case 'M':
                    current = M;
                    break;
            }

            if (i + 1 < s.length()) {
                switch (s.charAt(i + 1)) {
                    case 'I':
                        next = I;
                        break;
                    case 'V':
                        next = V;
                        break;
                    case 'X':
                        next = X;
                        break;
                    case 'L':
                        next = L;
                        break;
                    case 'C':
                        next = C;
                        break;
                    case 'D':
                        next = D;
                        break;
                    case 'M':
                        next = M;
                        break;
                }
            }

            if (current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    } 
}
