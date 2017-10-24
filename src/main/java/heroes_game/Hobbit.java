package heroes_game;

public class Hobbit extends Character {
    public Hobbit() {
        hp = 3;
        power = 0;
    }

    @Override
    public void kick(Character c) {
        cry();
    }

    private void cry() {
        System.out.println("My power is 0 =(((((  (crying)");
    }
}
