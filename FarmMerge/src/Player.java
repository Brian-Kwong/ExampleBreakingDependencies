public class Player extends User {
    String email;
    String password;
    String address;
    int experience;
    int balance = 0;

    public String toString() {
        return "Player{" +
                "\n\t uuid=" + uuid +
                "\n\t username='" + username + '\'' +
                "\n\t name='" + name + '\'' +
                "\n\t age='" + age + '\'' +
                "\n\t email='" + email + '\'' +
                "\n\t password='" + password + '\'' +
                "\n\t address='" + address + '\'' +
                "\n\t experience=" + experience +
                "\n}";
    }

    public void updateBalance(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount. Balance cannot be updated.");
        }
    }
}
