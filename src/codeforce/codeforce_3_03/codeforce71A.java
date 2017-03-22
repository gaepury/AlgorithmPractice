package codeforce.codeforce_3_03;

import java.util.Scanner;

//3.3 Way Too Long Words
public class codeforce71A {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int n;

        try {
            n = s.nextInt();
            if (n <= 0 || n > 100) {
                throw new Exception();
            } else {
                String[] strArray = new String[n];

                for (int i = 0; i < strArray.length; i++)
                    strArray[i] = s.next();

                tooLongChange(strArray);

                print(strArray);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void print(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }

    public static void tooLongChange(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() > 10) {
                strArray[i] = String.valueOf(strArray[i].charAt(0)) + (strArray[i].length() - 2)
                        + String.valueOf(strArray[i].charAt(strArray[i].length() - 1));
            }
        }
    }

}
