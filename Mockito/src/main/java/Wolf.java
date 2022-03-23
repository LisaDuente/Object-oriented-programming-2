import java.util.Random;

public class Wolf {

    int damage;
    int health;

    public Wolf(){
        damage = 0;
        health = 10;
    }

    public void bite(Wolf wolf){
        Random random = new Random();
        this.damage = random.nextInt(5);
        wolf.health = wolf.health - this.damage;
    }

    public int getHealth() {
        return health;
    }
}
