package heroes_game;

import org.fluttercode.datafactory.impl.DataFactory;


public class GameManager {

    public void fight( Character c1, Character c2) throws InterruptedException {
        DataFactory dataFactory = new DataFactory();

        while (c1.getHp() > 0 && c2.getHp() > 0) {
            int nextKickBy = dataFactory.getNumberBetween(0,2);
            if (nextKickBy == 0) {
                System.out.println(c1.getClass() + " kicks " + c2.getClass());
                c1.kick(c2);
                Thread.sleep(1000);
                System.out.println("\nHP after kick:\n" + c1.getClass() + " hp: " + c1.getHp() + "\n" + c2.getClass() + " hp: " + c2.getHp() + "\n");

            }
            else {
                System.out.println(c2.getClass() + " kicks " + c1.getClass());
                c2.kick(c1);
                Thread.sleep(1000);
                System.out.println("\nHP after kick:\n" + c2.getClass() + " hp: " + c2.getHp() + "\n" + c1.getClass() + " hp: " + c1.getHp() + "\n");
            }
        }

        if (c1.getHp() > 0) {
            System.out.println(c1.getClass() + " won! Congratulations!");
        }
        else {
            System.out.println(c2.getClass() + " won! Congratulations!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CharacterFactory factory = new CharacterFactory();
        Character c1 = factory.createCharacter();
        Character c2 = factory.createCharacter();
        System.out.println(c1.getClass() + " (hp: " + c1.getHp() + " power: " + c1.getPower() + ") vs " + c2.getClass() + " (hp: " + c2.getHp() + " power: " + c2.getPower() + ")\n");

        GameManager manager = new GameManager();

        manager.fight(c1, c2);
    }
}

