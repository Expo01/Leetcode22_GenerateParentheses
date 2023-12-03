import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}



class Solution {
    String L = "(", R = ")";
    List<String> combos = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int L_Count = n, R_Count = n;
        StringBuilder temp = new StringBuilder();

        create(L_Count,R_Count,temp);

        return combos;

    }

/*      narrow this to n=2 for test case rapidity
            (())
            ()()
*/

    private void create(int L_Count, int R_Count, StringBuilder temp){
        if(L_Count == 0 && R_Count == 0){
            combos.add(temp.toString());
        }

        if(L_Count > 0){
            temp.append(L);
            create(L_Count-1,R_Count,temp);
            temp.deleteCharAt(temp.length()-1);
        }


        if(L_Count < R_Count && R_Count >0){
            temp.append(R);
            create(L_Count,R_Count-1,temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}

/*
        Input:  n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
 WHERE n = 3
    ((()))  max out lefts 3 lefts at left most place
    (()())  the right most left  got flipped to R bracket then immediatly L bracket followed by 2 ))
    (())()
    ()(())
    ()()()
    this is actually a backtracking problem, max out the L flip L to R and add L until 0 then fill in R till 0

     */



// assign a char '(' and ')' and a leftBracket and rightBracker counter = n;
// with stringbuilder, making them string "(" would be better. less conversion
// append a ( and call recsurive options where if LB count != 0 then
// pass new LB amount and append. second call option of append RB.
// eventually will reach a case where L bracket is 0 and so no more L bracket calls