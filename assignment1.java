import java.io.File;
import java.util.Scanner;
import java.lang.Object;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class assignment1 {







    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String fn=sc.next(); /*FIELD NAME INPUT*/
      int notexist=0;  /*SET TO ZERO*/
      int charr=0;
      int typ=-1;

        try {
          Scanner input = new Scanner(System.in);

          File file = new File("metadata.txt");
              String[] fielddata=null;


          input = new Scanner(file);
          int position=0; /* position of field in datafile*/
          int chk=0;


                      while (input.hasNextLine()) { /*READS THE META DATA FILE */


                          String line = input.nextLine();
                           String[] arr=line.split(",") ;

                           if(arr[0].equals(fn)){ /* WHEN FIRST WORD OF LINE IS SAME AS FIELD NAME */
                             fielddata=arr;
                            /* FIELD DATA CONTAINS CONTAINS INFORMATION OF OUR INPUT field */

                             position=chk;     /*FIELD NAME POSITION IN DATAFILE */

                            System.out.println("k");
                           }
                           System.out.println(line);
                           System.out.println(arr[0]+"n");
                           chk++;
                      }
                    System.out.println("Finish reading data description file....");
                      input.close();
                      if(fielddata==null){

                      notexist=1;  /*if fielddata equals null*/
                      }
                      else{
                        String type=fielddata[fielddata.length-1];
                        String[] type_arr=type.split("");

                        if(type_arr[0].equals("C")){  /*to make sure that field is not of type char as max valof char can't be found */
                        charr=1;
                        typ=0;

                        }
                        else if(type_arr[0].equals("I"))
                        {
                          typ=1;
                        }
                        else if(type_arr[0].equals("F"))
                        {
                          typ=2;
                        }



                      }
                     System.out.println();
                     Scanner datafile=new Scanner(System.in);
                      File filedata = new File("datafile.txt");
                      datafile=new Scanner(filedata);
                      int cntln=0;
                      int max=Integer.MIN_VALUE;
                      while (datafile.hasNextLine()) {
                        String line = datafile.nextLine();
                        String[] array=line.split(" ") ;

                        System.out.println(line);
                      if(charr!=1 && notexist!=1 && cntln>1)
                      {
                        if(typ==1)
                        {int chkk=0;
                          for(int k=0;k<array.length;k++){
                            if(array[k].equals("")==false){

                          System.out.println(array[k]+position);}}
                        /*  int element=Integer.parseInt(array[position]);*/

                        }



                      }cntln++;}
                      System.out.println("Find max value in the field " + fn);
                      if(notexist==1){
                        System.out.println("--- Error: field name not found");
                      }
                      else if(charr==1){
                        System.out.println("---- Error: field char max cant be found"); /*IF FIELD NAME IS CHAR NO MAX CAN BE FOUND */

                      }

/* WHAT'S LEFT


JUST NEED TO COMPUTE THE MAX VALUE OF THE FIELD DATA IN EVERY LINE IF NOT CHAR TYPE by parsing into int or float*/










        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
