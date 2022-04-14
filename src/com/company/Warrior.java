package com.company;

public class Warrior extends Hero {
    public Warrior(int heroesHealth, int heroesDamage, String heroName) {
        super(heroesHealth, heroesDamage, SuperAbility.CRITICAL_DAMAGE, heroName);
    }

    @Override
    public void appleSuperPower(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(4) + 2;
        for (int i = 0; i < heroes.length; i++) {
            int warrior = 25;
            if (heroes[i].getHealth() > 0 && heroes[i].getHeroName() == this.getHeroName()) {
                heroes[i].setDamage(warrior * number);
            }
        }

    }
}