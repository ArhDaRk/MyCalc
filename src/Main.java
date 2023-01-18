import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.print("Введите математическую операцию - два операнда и один оператор (+, -, /, *) ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        InputData var1 = new InputData();
        var1.fall = text;
        var1.returnable();


    }
}
class InputData {
    String fall;
    void returnable(){
        String calculate = "";
        String[] words = fall.split(" ");
        int first = Integer.parseInt(whatIsIt(words[0]));
        int second = Integer.parseInt(whatIsIt(words[2]));
        String out = whatIsIt(words[1]);
        switch (out){
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
                throw new IllegalStateException("Unexpected value: " + out);
        }
        System.out.println(calculate);
    }

    public static String whatIsIt(String input){
        String[] operand = {"+","-","*","/"};
        String[] rimNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        for(String word : operand){
            if(word.equals(input))return word;
        }
        for (String rim : rimNumbers){
            if(rim.equals(input)) return rim;
        }
        for (int call : numbers){
            if (call == Integer.parseInt(input)){
                return Integer.toString(call);
            }
        }

        return "Ерунда тут какая то у вас";
    }
}
