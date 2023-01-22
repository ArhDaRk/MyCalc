import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws EOFException {
        System.out.print("Введите математическую операцию - два операнда и один оператор (+, -, /, *) ");
        Scanner input = new Scanner(System.in);
        InputData var1 = new InputData();
        var1.inputValue = input.nextLine();
        var1.calculate();
    }
}
class InputData {
    String inputValue;
    void calculate() throws EOFException {
        String[] words = inputValue.split(" ");
        if(words.length >= 4){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        if(words.length == 1){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
        else System.out.println(whatIsIt(words[0],words[1],words[2]));
    }
    public static int getOperandAndCalculate(int first,String op,int second){
        int calculate = 0;
        switch (op) {
            case "+" -> calculate = (first + second);
            case "-" -> calculate = (first - second);
            case "*" -> calculate = (first * second);
            case "/" -> calculate = (first / second);
            default -> {
                try {
                    throw new IOException();
                } catch (IOException e){
                    System.out.println("Этот калькулятор не знает такого операнда: " + op);
                }
            }
        }
        return calculate;
    }
    public static String whatIsIt(String cell1,String operand, String cell2){
            if(checkForArab(cell1) == true && checkForArab(cell2) == true) {
                        int answer = getOperandAndCalculate(Integer.parseInt(cell1),operand,Integer.parseInt(cell2)); //вернуть результат операции иначе проверить дальше
                        return Integer.toString(answer);
            }
            if(checkForRim(cell1) == true && checkForRim(cell2) == true){
                int answer = getOperandAndCalculate(getRimToArab(cell1),operand,getRimToArab(cell2));  // тут логику сложения римских чисел
                if(answer >= 1) return String.valueOf(RimNumbers.valueOfLabel(answer));
                try {
                    throw new IOException();
                } catch (IOException e){
                    return  "throws Exception //т.к. т.к. в римской системе нет отрицательных чисел";
                }
            }
            if(checkForArab(cell1) == true && checkForRim(cell2) == true){
                    try {
                        throw new IOException();
                    } catch (IOException e){
                        return  "throws Exception //т.к. используются одновременно разные системы счисления";
                    }
            }
            if(checkForRim(cell1) == true && checkForArab(cell2) == true){
                try {
                    throw new IOException();
                } catch (IOException e){
                    return  "throws Exception //т.к. используются одновременно разные системы счисления";
                }
            }
        try {
            throw new IOException();
        } catch (IOException e){
            return  "throws Exception //т.к. формат математической операции не удовлетворяет заданию";
        }
    }
    public static Boolean checkForArab(String input){
//
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};
        for(String check : numbers){
                if(check.equals(input)) return true;
        }
        return false;
    }
    public static Boolean checkForRim(String input){
        String[] rimNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for(String check : rimNumbers){
            if(check.equals(input)) return true;
        }
        return false;
    }
    public static int getRimToArab (String  input){
               RimNumbers out =  RimNumbers.valueOf(input);
        return out.getNumber();
    }
}
