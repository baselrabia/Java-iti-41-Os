public class Complex {

    int real;
    int img;

    public Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public static Complex add(Complex n1, Complex n2)
    {
        Complex temp = new Complex(0, 0);

        temp.real = n1.real + n2.real;
        temp.img = n1.img + n2.img;

        return temp ;
    }

    public static Complex sub(Complex n1, Complex n2)
    {
        Complex temp = new Complex(0, 0);

        temp.real = n1.real - n2.real;
        temp.img = n1.img - n2.img;

          return temp;
    }

    public static void main(String[] args) {
        Complex n1 = new Complex(3, 2);

        System.out.println("Complex number 1 : "
                           + n1.real + " + "
                           + n1.img + "i");
        Complex n2 = new Complex(4, 4);
      
        System.out.println("Complex number 2 : "
                           + n2.real + " + "
                           + n2.img +"i");

        Complex temp =  new Complex(0, 0);

        temp = add(n1, n2);

        System.out.println("Sum = " +  temp.real + " + !" + temp.img);
        
        temp = sub(n1, n2);

        System.out.println("Sub = " +  temp.real + " + !" + temp.img);
    }

    
}