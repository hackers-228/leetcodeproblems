class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        boolean goDown = false;
        int row = 0;
        for(char c: s.toCharArray()){
            rows[row].append(c);

            if(row == 0 || row == numRows-1) goDown = !goDown;

            row += goDown ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb: rows){
            ans.append(sb);
        }

        return ans.toString();
    }
}