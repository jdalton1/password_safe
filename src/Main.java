import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {
        String file_name = "password_safe.txt";
        String username = get_username();
        int pwd_length = get_pwd_length();
        ArrayList<Character> pwd = new ArrayList<>();
        String pwd_string = "";

        Password newPassword = new Password(username, pwd_length);
        newPassword.generate_password(pwd);
        newPassword.display(pwd);
        create_file(file_name);

        for (Character character : pwd) {
            pwd_string += character;
        }
        writeFile(file_name, username, pwd_string);
    }

    public static String get_username(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your username or email: ");
        return input.nextLine();
    }

    public static int get_pwd_length(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many characters do you want your password to be? ");
        return input.nextInt();
    }

    public static void create_file(String file_name){

        try{
            File pwSafe = new File(file_name);
            if (pwSafe.createNewFile()){
                System.out.println("Password Safe file created successfully.");
                System.out.println("The file is named \"password_safe.txt\"");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }

    public static void writeFile(String file_name, String username, String pwd){
        try {
            FileWriter writer = new FileWriter(file_name,true);
            writer.append("Username: " + username);
            writer.append("\nPassword: " + pwd);
            writer.append("\n\n");

            writer.close();
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
