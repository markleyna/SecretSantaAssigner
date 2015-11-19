import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Nicole on 11/19/2015.
 */
public class SecretSanta {
    private static String[] familyMembers = new String[]{"Nicole", "Winnie", "Justin", "Vinson", "Manoj", "Anchal",
            "Jonathan", "Madeline", "Ujjwal", "Kate", "Nathanael"};

    public static String[][] generateSantas() {
        String[][] pairs = new String[familyMembers.length][2];
        Random r = new Random();
        int num = familyMembers.length;
        for (int i = 0; i < familyMembers.length; i++) {
            pairs[i][0] = familyMembers[i];
        }
        int j = 0;
        do {
            int index = r.nextInt(familyMembers.length);
            if (pairs[index][1] == null && !pairs[index][0].equals(familyMembers[j])) {
                pairs[index][1] = familyMembers[j];
                num--;
                j++;
            }
        } while (num != 1);

        for (int i = 0; i < familyMembers.length; i++) {
            if (pairs[i][1] == null) {
                pairs[i][1] = familyMembers[familyMembers.length - 1];
            }
        }
        return pairs;
    }

    public static void main(String args[]) {
        String[][] assignments = generateSantas();
        String[] options = Arrays.copyOf(familyMembers, familyMembers.length + 1);
        options[options.length - 1] = "Quit";
        String input;
        String message = "Secret Santa's have been assigned. Type your name to see who you should get a gift " +
                "for! P.S. Select quit to quit the program--don't do this until everyone knows who they're getting a " +
                "gift for! P.P.S. DON'T EVER HIT CANCEL.";
        do {
            input = (String) JOptionPane.showInputDialog(null, message, "Pick your name", JOptionPane
                    .OK_OPTION, null, options, options[0]);
            for (int i = 0; i < familyMembers.length; i++) {
                if (assignments[i][0].equals(input)) {
                    String message2 = "You've been assigned to be " + assignments[i][1] + "'s Secret Santa";
                    JOptionPane.showMessageDialog(null, message2, "Assignment", JOptionPane.OK_OPTION);
                }
            }
        } while (!input.equals("Quit"));
    }
}
