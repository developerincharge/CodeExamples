package interfaceandabstract;

interface Playable {
    void play();
}

class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("Playing the Guitar");
    }
}

public class InterfaceDemo {


    public static void main(String[] args) {

        Playable guitar = new Guitar();
        guitar.play();
    }
}
