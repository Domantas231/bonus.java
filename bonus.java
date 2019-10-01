import java.util.*;

class Main
{ 
    public static void main (String[] args) 
    { 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");

        int number = scanner.nextInt();
        
        LinkedList<Integer> numberList = toList(number);

        if(isAKindOfMagic(numberList.size(), numberList, number) == true){
            System.out.println("It's magic!");
        }
        else {
            System.out.println("It's not magic :c");
        }

        scanner.close();
    } 

    public static LinkedList<Integer> toList (int number){
        LinkedList<Integer> NumberByNumber = new LinkedList<Integer>();

        while(number > 0){
            NumberByNumber.add(number % 10);
            number /= 10;
        }

        return NumberByNumber;
    }

    public static boolean isAKindOfMagic(int size, LinkedList<Integer> numberlist, int number){
        int nOCO = 0;

        for(int i = 1; i <= size; i++){
            int newNumber = number * i;
            LinkedList<Integer> newNumberList = toList(newNumber);

            for(int number1 : numberlist)
                for(int number2 : newNumberList){
                    if(number1 == number2){
                        newNumberList.remove(newNumberList.indexOf(number2));
                        break;
                    }
                }
            
            if(newNumberList.size() == 0){ 
                nOCO++; 
            }
        }


        return nOCO == size;
    }
}