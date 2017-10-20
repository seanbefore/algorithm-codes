/*
	time limited...
*/


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> sb=new Stack<Character>();//stack of brace
        Stack<Integer> sp=new Stack<Integer>();//posotion of the brace
        Stack<Integer> ss=new Stack<Integer>();//start
        Stack<Integer> se=new Stack<Integer>();//end
        
        Character b,peekb;
        
        int popi,start,end,s2,e2;
        int max=0,temp;
        
        start=-2;
        end=-2;
        for(int i=0;i<s.length();i++){
            b=s.charAt(i);
            if(sb.isEmpty()){
                sb.push(b);
                sp.push(i);
            }else{
                peekb=sb.peek();
                if(peekb<b){
                    sb.pop();
                    popi=sp.pop();
                    if(popi>end){
                        ss.push(start);
                        se.push(end);
                        start=popi;
                        end=i;
                    }else{
                        start=popi;
                        end=i;
                    }                              
                }else{
                    sb.push(b);
                    sp.push(i);
                }
            }
        }
        if(end!=0) {
            ss.push(start);
            se.push(end);
        }
        start=0;
        end=0;
    
        while(!ss.isEmpty()){
            if(start==end){
                start=ss.pop();
                end=se.pop();
                max= max>end-start?max:end-start;
            }else{
                s2=ss.pop();
                e2=se.pop();
                
                if(start<s2) continue;
                else if(start==e2+1){
                    start=s2;
                    max= max>end-start?max:end-start;
                }else{
                    start=s2;
                    end=e2;
                    max= max>end-start?max:end-start;
                }
            }
        }
        
        max= max>end-start?max:end-start;
        max= max==0?0:max+1;
        
        return max;
    }
}