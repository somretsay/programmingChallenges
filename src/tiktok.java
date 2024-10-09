import java.util.HashMap;
import java.util.Scanner;

public class tiktok {
    public static void main(String[] args) {
        HashMap<String, Integer> view = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of entries: ");
        int entry = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline character after nextInt()

        for (int i = 0; i < entry; i++) {
            System.out.print("Enter TikTok account information (name views): ");
            String accountInfo = keyboard.nextLine();
            String[] info = accountInfo.split(" ");

            String accountName = info[0];
            int viewCount = Integer.parseInt(info[1]);

            if (!view.containsKey(accountName)) {
                // Account does not exist, add new entry
                view.put(accountName, viewCount);
            } else {
                // Account already exists, update view count
                int currentViews = view.get(accountName);
                view.put(accountName, currentViews + viewCount);
            }
        }

        System.out.println("TikTok Account View Counts: " + view.entrySet());
    }
}

