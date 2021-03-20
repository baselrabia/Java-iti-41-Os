import java.util.regex.*;  
import java.util.StringTokenizer;  


public class IPCutter3 {

     
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
  
        StringTokenizer st = new StringTokenizer(ip,".");  
        while (st.hasMoreTokens()) {  
            System.out.println(st.nextToken());  
        }  
    
  

    }

    
}