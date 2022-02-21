public class Fiend {
    private int damage;
    private int health;
    private String name;

    public Fiend (String name, int health, int damage){
        this.damage = damage;
        this.health = health;
        this.name = name;

    }

    public void printOut(){
        System.out.println("damage = "+this.damage);
        System.out.println("health = " + this.health);
        System.out.println("name = " + this.name);
    }
}
