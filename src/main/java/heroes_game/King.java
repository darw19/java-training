package heroes_game;

import org.fluttercode.datafactory.impl.DataFactory;


public class King extends Character {
    private int lowRange = 5;
    private int highRange = 16;
    public King() {
        DataFactory dataFactory = new DataFactory();
        hp = dataFactory.getNumberBetween(lowRange, highRange);
        power = dataFactory.getNumberBetween(lowRange, highRange);
    }
    @Override
    public void kick(Character c) {
        DataFactory dataFactory = new DataFactory();

        int dicreaseBy = dataFactory.getNumberBetween(0, power);
        System.out.println("Dicrease hp by: " + dicreaseBy);
        int targetHp = c.getHp() - dicreaseBy;

        c.setHp(targetHp >= 0 ? targetHp : 0);
    }
}
