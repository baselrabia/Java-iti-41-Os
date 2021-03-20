import java.util.regex.*;  


public class IPCutter {

     
    public static void main(String[] args) {
        
        String ip = args[0];


       String IPV4_PATTERN =
           "^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
           "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
           "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
           "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";

        boolean validip = Pattern.matches(IPV4_PATTERN, ip);  
        if(validip == false){
             System.out.println(ip + " Not a Valid Ip");
              return;
        }

        while( ip.equals("") == false ){
            int index = ip.indexOf(".");
            if (index == -1) {
                System.out.println(ip);
                break;
            }
            String result = ip.substring(0,index);
            System.out.println(result);
            ip = ip.substring(index+1);
        }
    
  

    }

    
}