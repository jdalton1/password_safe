import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Password {

    private static int pwd_length;

    Password(String username, int pwd_length){
        this.pwd_length = pwd_length;
    }


    public void generate_password(ArrayList pwd) {
        Scanner input = new Scanner(System.in);
        Random glyph = new Random();

        char[] specials = {'!', '@','#','$','%','^','&','*','(',')','[','{',']','}'};
        char symbol = 0;

        for(int i=0; i < pwd_length; i++) {
            int num = (int) (Math.random() * 4);
            int special = (int)(Math.random() * 14);


            switch (num) {
                case 0 -> symbol = (char) ('0' + glyph.nextInt(9));
                case 1 -> symbol = (char) ('A' + glyph.nextInt(26));
                case 2 -> symbol = (char) ('a' + glyph.nextInt(26));
                case 3 -> symbol = (char) (specials[special]);
            }

            pwd.add(symbol);
        }
    }

    public void display(ArrayList pwd) {
        Scanner input = new Scanner(System.in);
        System.out.println("Password generated successfully");

        System.out.println("Would you like to display your password? (y/n)");
        String answer = input.nextLine();

        if (Objects.equals(answer, "y")){
            for (int i = 0; i < pwd.size();i++) {
                System.out.print(pwd.get(i));
            }
        }
    }
}
