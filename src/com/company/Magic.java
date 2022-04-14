package com.company;

public class Magic extends Hero {
    public Magic(int heroesHealth, int heroesDamage, String heroName) {
        super(heroesHealth, heroesDamage, SuperAbility.BOOST, heroName);

    }
    @Override
        public void appleSuperPower(Hero[] heroes, Boss boss){
            int number = RPG_Game.random.nextInt(5) + 1;
            for (int i = 0; i < heroes.length; i++) {
                if ((heroes[i].getHealth() > 0) && (this != heroes[i])) {
                    heroes[i].setDamage(heroes[i].getDamage() + number);
                }
            }
        }
    }
