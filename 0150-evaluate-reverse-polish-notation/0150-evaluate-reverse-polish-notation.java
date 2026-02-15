class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String st: tokens){
            if(isOperand(st)){
                s.push(Integer.parseInt(st));
            }else{
                int operand2 = s.pop();
                int operand1 = s.pop();
                switch(st){
                    case "+":
                        s.push(operand1 + operand2);
                        break;
                    case "-":
                        s.push(operand1- operand2);
                        break;
                    case "*":
                        s.push(operand1 * operand2);
                        break;
                    case "/":
                        s.push(operand1 / operand2);
                        break;
                }
            }
        }
        return s.pop();
    }

    private static boolean isOperand(String token){
        return token.matches("-?\\d+");
    }

}