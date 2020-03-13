 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw5;
import knguyenhw5.StackArray;
/**
 *
 * @author Kha Nguyen  
 * Class does post fix, in order of precedence
 */
public class PostFix {
    
    public String convertToPostfix (String inputExpression){
        StackInterface<Character> operatorStack = new StackArray<Character>(100);
        String postfix = "";
        char topOperator;
        
        for(int i =0 ; i < inputExpression.length();i++){
           char inputChar = inputExpression.charAt(i);
           if(' ' != inputChar)
           {
            switch(inputChar){
                case '^':
                    operatorStack.push(inputChar);
                    break;
                case '(':
                    operatorStack.push(inputChar);
                    break;
                case ')':
                    topOperator = operatorStack.pop();
                    while(topOperator != '(')
                    {
                        postfix += topOperator;
                        topOperator = operatorStack.pop();     
                    }
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!operatorStack.isEmpty() && determinPrecedenceLevel(inputChar) <= determinPrecedenceLevel(operatorStack.peek()))
                    {
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    } 
                    operatorStack.push(inputChar);
                    break;
                default: 
                    postfix += inputChar;
                    break;

             }
           }
        }
        while(!operatorStack.isEmpty())
        {
            topOperator =operatorStack.pop();
            postfix += topOperator;
        }   
        return postfix;
    }
    
    private int determinPrecedenceLevel(char op) {
        switch (op) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
            default:
                return -1;
        }
    }
    
    
}
