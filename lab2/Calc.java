public class Calc {

     
    public static void main(String[] args) {
        
    if(args.length != 3)
    {
        System.out.println("Error !! : Args are empty");
        
    }else {

    if ( !(isInt(args[0]) && isInt(args[2])) ){
        System.out.println("Error !! : Args are Not numbers");

    }else{


    double first = Double. parseDouble( args[0]) ;
    double second = Double. parseDouble( args[2]) ;
    char operator = args[1].charAt(0);
    System.out.println("the operation entered: " + args[0] + " " + args[1] + " " + args[2]);  

    double result;
    switch (operator) {
        case '+':
            result = first + second;
            break;

        case '-':
            result = first - second;
            break;

        case 'x':
            result = first * second;
            break;

        case '/':
            result = first / second;
            break;
        
        case '%':
            result = first % second;
            break;

        default:
            System.out.printf("Error! operator is not correct");
            return;
    }

    System.out.println("Result = " + first + " " + operator + " " + second + " = " + result);
  

    } }


    
}


public static boolean isInt(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

}