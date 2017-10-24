package heroes_game;

public class Elf extends Character {
    public Elf(){
        hp = 10;
        power = 10;
    }

    @Override
    public void kick(Character c) {
        if (c.getHp() < this.hp) {
            System.out.println("Dicrease hp by: " + c.getHp());
            c.setHp(0);
        }
        else {
            System.out.println("Dicrease hp by 1");
            c.setHp(c.getHp() - 1);
        }
    }
}
