import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
interface Filter {
    boolean apply(Object o);
}

public class Main {
    public static void main(String[] args) {
        System.out.println("№1");
        first();
        System.out.println("№2");
        second();
        System.out.println("№3");
        third();
        System.out.println("№4");
        fourth();
        System.out.println("№5");
        fifth();
        System.out.println("№6");
        sixth();
        System.out.println("№7");
        seventh();

    }
    // ghghg/hghg/ghg/
    public static void first() {
        System.out.println("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Введите разделитель:");
        String p = sc.nextLine();
        System.out.println(Arrays.toString(str.split(p)));
    }
    public static void second(){
            System.out.print("Введите строку: ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            Pattern p1 = Pattern.compile("abcdefghijklmnopqrstuv18340");
            Matcher m1 = p1.matcher( str );
            boolean b = m1.matches();
            System.out.println(b);
    }
    // 25.98 USD
    public static void third(){
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern p1 = Pattern.compile("\\d+(\\.\\d+)?\\s?((USD)|(EUR)|(RUB))");
        // 25.98 USD 2.12 U 25.93 RUB
        Matcher m1 = p1.matcher(str);
        ArrayList<String> ans = new ArrayList<>();
        while (m1.find()) {
            ans.add(m1.group());
        }
        System.out.println(ans);
    }
    //(1 + 8) – 9 / 4
    public static void fourth(){
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern p1 = Pattern.compile("(\\w?\\s*\\d+\\s*\\+\\s*\\d+\\s*\\w?)");
        Matcher m1 = p1.matcher(str);
        boolean a = false;
        while (m1.find()) {
            a = true;
        }
        if (a == true) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    // 1/1/1899
    public static void fifth(){
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern p1 = Pattern.compile("(((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((19)|([2-9][0-9]))[0-9][0-9]\\D*)+");
        Matcher m1 = p1.matcher(str);
        boolean a = m1.matches();
        if (a == true) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    //user@example.com
    public static void sixth(){
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern p1 = Pattern.compile("\\w+@(([a-z]+.[a-z]{2,3})|([a-z]+))");
        Matcher m1 = p1.matcher(str);
        boolean a = m1.matches();
        if (a == true) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    //A007
    public static void seventh(){
        System.out.print("Введите строку: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern p1 = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9_]{8,}");
        Matcher m1 = p1.matcher(str);
        boolean a = m1.matches();
        if (a == true) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    public static Object[] filter(Object[] array, Filter filter) {
        int offset = 0;

        for(int i = 0; i< array.length; i++){
            if(!filter.apply(array[i])){
                offset++;
            } else{
                array[i - offset] = array[i];
            }
        }

        return Arrays.copyOf(array, array.length - offset);
    }
}