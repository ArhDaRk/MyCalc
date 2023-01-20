import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("Введите математическую операцию - два операнда и один оператор (+, -, /, *) ");
        Scanner input = new Scanner(System.in);
        InputData var1 = new InputData();
        var1.inputValue = input.nextLine();
        var1.calculate();
    }
}
class InputData {
    String inputValue;
    void calculate(){
        String[] words = inputValue.split(" ");
        System.out.println(whatIsIt(words[0],words[1],words[2]));
    }
    public static String getOperandAndCalculate(String a,String op,String b){
        String calculate = "";
        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);
        switch (op){
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            case "/":
                System.out.println(first / second);
                break;
            default:
                throw new IllegalStateException("Этот калькулятор не знает такого операнда: " + op);
        }
        return calculate;
    }
    public static String whatIsIt(String cell1,String operand, String cell2){
        String[] rimNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String [] numbers = {"1","2","3","4","5","6","7","8","9","10"};
        for (String arab : numbers){
            if(arab.equals(cell1)) {
                for(String arab2 : numbers){
                    if(arab2.equals(cell2)){
                        return getOperandAndCalculate(cell1,operand,cell2); //вернуть результат операции иначе проверить дальше
                    }
                }
                for (String arab2 : rimNumbers)
                    if (arab2.equals(cell2)) {
                        throw new IllegalStateException("используются одновременно разные системы счисления");
                    }
            }
        }
        for (String rim : rimNumbers){
            if(rim.equals(cell1)){
                for(String rim2 : rimNumbers){
                    if (rim2.equals(cell2)){
                        return cell1 + cell2; // тут логику сложения римских чисел
                    }
                }
            }
        }

        return "Ерунда тут какая то у Вас";
    }
}
