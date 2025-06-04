package encapsulation;

public class Main {

    public static void main(String[] args) {

        Player tim = new Player("Tim", 200, "Sword");
        System.out.println("Initial Health  "+ tim.healthRemaining());

//        tim.fullName = "Tim";
//        tim.health = 20;
//        tim.weapon = "Sword";

        int damage = 10;
        tim.loseHealth(damage);
        System.out.println("Remaining Health = "+ tim.healthRemaining());
        //player.health = 200;
        tim.loseHealth(80);
        System.out.println("Remaining health = "+tim.healthRemaining());

    }
}
