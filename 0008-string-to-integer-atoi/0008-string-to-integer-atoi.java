class Solution {
    public int myAtoi(String s) {
        int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int i = 0, n = s.length(), sign = 1, result = 0;
    
     while (i < n && s.charAt(i) == ' '){
            i++;
    }
     if (i < n && s.charAt(i) == '-' ){
            sign=-1;
            i++;
    }
    if (i < n && s.charAt(i) == '+') {
            if (i < n && i!=0 && s.charAt(i-1)=='-'){
                return 0;
            }
            sign=1;
            i++;
    }
     while (i < n && Character.isDigit(s.charAt(i))) {
        int digit = s.charAt(i) - '0';
         if (result >(INT_MAX - digit)/10) {
             if (sign == 1){
                 return INT_MAX;
             }
            else{
                return INT_MIN;
                }
            }
         result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }
}