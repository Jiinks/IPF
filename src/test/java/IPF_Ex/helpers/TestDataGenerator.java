package IPF_Ex.helpers;

import java.util.Random;

/**
 * TestDataGenerator
 */
public class TestDataGenerator {
    private static Random random = new Random();

    private static String generateString(int length) {
        String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";        
        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = charList.charAt(random.nextInt(charList.length()));
        }
        
        return new String(text);
    }
    
    public static String GetEmail(){
        return "TestEmail_" + generateString(8) + "@mailinator.com";
    }

    public static String GetFirstName(){
        return "FirstName" + generateString(4);
    }

    public static String GetLastName(){
        return "LastName" + generateString(4);
    }

    public static String GetRandomString(){
        return generateString(10);
    }

    public static String GetPostCode(){
        int partOne = random.nextInt((99 - 10) + 1) + 10;
        int partTwo = random.nextInt((999 - 100) + 1) + 100;
        return partOne + "" + partTwo;
    }

    public static String GetMobilePhoneNumber(){
        int partOne = random.nextInt((999 - 100) + 1) + 100;
        int partTwo = random.nextInt((999 - 100) + 1) + 100;
        int partThree = random.nextInt((999 - 100) + 1) + 100;
        return partOne + "-" + partTwo + "-" + partThree;
    }

    
    
}