import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Created by icondor on 26/03/16.
 */
public class SkeletonJava {

    /* utility methods for INPUT/OUTPUT using a GUI or Console, please leave them as they are */


    // GUI
    public static int readIntGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        int returnValue = Integer.parseInt(input);
        return returnValue;
    }

    public static double readDoubleGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        double returnValue = Double.parseDouble(input);
        return returnValue;
    }

    public static String readStringGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        return input;
    }

    public static void printGUI(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(int text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(double text) {
        JOptionPane.showMessageDialog(null, text);
    }

    // CONSOLE
    public static String readStringConsole(String label) {
        System.out.print(label);
        String input = new Scanner(System.in).nextLine();
        return input;
    }

    public static void add(int[]... x) {
        for (int i = 0; i < x.length; i++) {

        }
    }

    public static int readIntConsole(String label) {
        System.out.println(label);
        int input = new Scanner(System.in).nextInt();
        return input;
    }

    public static double readDoubleConsole(String label) {
        System.out.print(label);
        double input = new Scanner(System.in).nextDouble();
        return input;
    }

    public static void printConsole(String text) {
        System.out.println(text);
    }

    public static void printConsole(int text) {
        System.out.println(text);
    }

    public static void printConsole(double text) {
        System.out.println(text);
    }

    public static void printMe(int x, int b) {
        int total = (x + b) / 2;
        JOptionPane.showMessageDialog(null, "media este " + total);


    }

    public static int getMax(int x, int y) {

        int max;
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        return max;


    }

    public static boolean User(String name, String password) {
        boolean check = false;
        if (name.equals("alin") && password.equals("12345")) {
            check = true;
        }
        return check;
    }

    public static void notePad() {
        Runtime rs = Runtime.getRuntime();

        try {
            rs.exec("notepad");

        } catch (Exception e) {
            System.out.println("file not found");
        }
    }/* end of utility methods*/


    static String[] contacte = new String[3]; //the mighty array
    static int index =0;


    //  listing method
    public static void printMe() {
        for (int i = 0; i < contacte.length; i++) {
            System.out.println(contacte[i]);
        }
    }

    // add method
    public static void addMe(String adaug) {
        int cautIndex = searchMe(adaug);
        if(cautIndex==-1) {
            try {
                contacte[index] = adaug;
                index++;
            }catch(Exception e){
                printConsole("numarul de contacte depasit");
            }
        }
        else{
            printConsole("contactul exista si se afla pe pozitia " + cautIndex);
        }
    }

    // search method
    public static int searchMe(String contact) {
         int r =-1;
        for (int i = 0; i < contacte.length; i++) {
            if (contact.equals(contacte[i])) {
                r=i;break;
            }
        }
        return r;
    }
    //modify
    public static void modifyMe(String word,String newWord){
        int cont = searchMe(word);
        if(cont==-1){
            printConsole("contactul nu exista");
        }
        else{
            contacte[cont]=newWord;
        }
    }
    //delete
    public static void deleteMe(String word){
        int cont = searchMe(word);
        if(cont==-1){
            printConsole("contactul nu exista");
        }
        else{
            contacte[cont]=null;
        }
    }

    /* here starts the main class */
    public static void main(String[] arguments) {

        int object;
        String word;
        String word2;
        do {
            printConsole("1-adauga\n2-afiseaza\n3-cauta contact\n4-modifica contact\n5-sterge\n6-iesire\n" );
             object = readIntConsole("enter number :");

            //  printMe();
            if (object == 1) {
                word = readStringConsole("adauga contact: ");
                addMe(word);
            } else if (object == 2) {
                printMe();
            } else if (object == 3) {
                word = readStringConsole("cauta contact: ");
                System.out.println(searchMe(word));
            }else if(object == 4){
                word= readStringConsole("contactul : ");
                word2 = readStringConsole("contactul nou: ");
                modifyMe(word,word2);
            }else if(object == 5){
                word = readStringConsole("sterge contact :");
                deleteMe(word);
            }

        }while (object!=6);
    }//end of main method
}
// end of class
