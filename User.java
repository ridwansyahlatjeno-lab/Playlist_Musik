// ==========================================
// #2 Inheritance (Parent & Admin)
// ==========================================
abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }

    // Method Polymorphism 
    public abstract void tampilkanAkses();
}
