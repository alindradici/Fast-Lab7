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
    }/* end of utility methods+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


      //the mighty array************************************************
    static List<Person> list = new ArrayList<>();
    static int index =0;


    //  listing method
    public static void printMe() {
        for (int i = 0; i < list.size(); i++) {

            if(list.get(i)!= null){
                System.out.println(list.get(i).getName());
                System.out.println(list.get(i).getPhone());
            }

        }
    }
    // add method
    public static void addMe(String name,String phone) {

        try {

            Person p = new Person(name, phone);
            list.add(p);

        }catch (Exception e){
            printConsole("lista contacte supraincarcata");
        }
    }

    // search method
    public static int searchMe(String contact) {
         int r =-1;
        for (int i = 0; i < list.size(); i++) {
          Person p = list.get(i);
            String nume = list.get(i).getName();
            if (list.contains(nume)){
                r=i;break;
            }
        }
        return r;
    }
    //modify
    public static void modifyMe(String word){
        int cont = searchMe(word);
        int decizie=0;

        if(cont==-1){
            printConsole("contactul nu exista");
        }
        else{
            decizie = readIntConsole("1-modifica numele\n2-modifica numarul");
            if(decizie==1){
                String newName = readStringConsole("introduceti nume nou: ");
                list.get(cont).setName(newName);
            }
            else if(decizie==2){
                String newPhone = readStringConsole("introduceti telefon nou : ");
                list.get(cont).setPhone(newPhone);
            }
        }
    }
    //delete
    public static void deleteMe(String word){
        int cont = searchMe(word);
        if(cont==-1){
            printConsole("contactul nu exista");
        }
        else{
            list.remove(cont);
        }
    }

    /* here starts the main class */
    public static void main(String[] arguments) {

       int object;
        String word;
        String word2;
        String word3;
        do {
            printConsole("1-adauga\n2-afiseaza\n3-cauta contact\n4-modifica contact\n5-sterge\n6-iesire\n" );
             object = readIntConsole("enter number :");

            //  printMe();
            if (object == 1) {
                word = readStringConsole("adauga contact: ");
                word2 = readStringConsole("adauga telefon: ");
                addMe(word,word2);
            } else if (object == 2) {
                printMe();
            } else if (object == 3) {
                word = readStringConsole("cauta contact: ");
                System.out.println(searchMe(word));
            }else if(object == 4){

                word= readStringConsole("contactul : ");
                modifyMe(word);

            }else if(object == 5){
                word = readStringConsole("sterge contact :");
                deleteMe(word);
            }

        }while (object!=6);


    }//end of main method
}
// end of class
