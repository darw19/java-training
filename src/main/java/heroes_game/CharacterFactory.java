package heroes_game;

import org.fluttercode.datafactory.impl.DataFactory;

public class CharacterFactory {

    public enum CharacterType {

        HobbitType(1) {
            public Hobbit create() {
                return new Hobbit();
            }
        },
        ElfType(2) {
            public Elf create() {
                return new Elf();
            }
        },
        KnightType(3) {
            public Knight create() {
                return new Knight();
            }
        },
        KingType(4) {
            public King create() {
                return new King();
            }
        },
        ;

        public abstract Character create();

        private final int value;
        private CharacterType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static CharacterType findByCode(int code){
            for(CharacterType v : values()){
                if((v.getValue()) == code){
                    return v;
                }
            }
            return HobbitType;
        }
    }
    public Character createCharacter() {
        DataFactory dataFactory = new DataFactory();
        dataFactory.randomize((int) (System.currentTimeMillis() % 1000));
        dataFactory.getNumberBetween(1,5);
        Character c = CharacterType.findByCode(dataFactory.getNumberBetween(1,5)).create();
        return c;
    }
}
