package encapsulation;

public class Player {

   private String name;
   private int healthPercentage;
   private String weapon;

//    public Player() {
//    }


    public Player(String name) {
        this(name, 100, "sword");
    }

    public Player(String fullName, int health, String weapon) {
        this.name = fullName;
        if(health <= 0){
            this.healthPercentage = 1;
        }else if (health > 100){
            this.healthPercentage = 100;
        }else {
            this.healthPercentage = health;
        }
        this.weapon = weapon;
    }



    public void loseHealth(int damage){
        healthPercentage = healthPercentage - damage;
        if(healthPercentage <= 0){
            System.out.println("Player knocked out of Game");
        }
    }

    public int healthRemaining(){
        return healthPercentage;
    }
    public void restoreHealth(int extraHealth){
        healthPercentage = healthPercentage + extraHealth;
        if(healthPercentage > 100){
            System.out.println("Player restored to 100%");
            healthPercentage = 100;
        }
    }

}


