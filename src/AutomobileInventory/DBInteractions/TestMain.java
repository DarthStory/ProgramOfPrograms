package AutomobileInventory.DBInteractions;

public class TestMain {
    public static void main(String[] args) throws Exception {
        UserManager manager = new UserManager();

        // Add users
        manager.addUser("user12", "password1");
        //manager.addUser("user23", "password2");

        // Load users from file
        manager.loadFromFile();

        // Validate users
        System.out.println(manager.validateUser("user1", "password1"));  // Should return true
        //System.out.println(manager.validateUser("user2", "wrongpassword"));  // Should return false
    }
}
