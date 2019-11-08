public class Powerset{
     String str = "abcd"; //our string
     public static void main(String []args){
        Powerset ps = new Powerset();
        for(int i = 0; i< hw.str.length();i++){ //traverse through all characters
            ps.subs("",i);
        }
     }

     void subs(String substr,int index)
     {
         String s = ""+str.charAt(index); //very important, create a variable on each stack
         s = substr+s; //append the subset so far
         System.out.println(s); //print

         for(int i=index+1;i<str.length();i++)
           subs(s,i); //call recursively

     }
}