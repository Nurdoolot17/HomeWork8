package com.company;

public class Bersek extends Hero {

        public Bersek(int heroesHealth, int heroesDamage, String heroName) {
            super(heroesHealth, heroesDamage, SuperAbility.SAVE_DAMAGE_AND_REVERT, heroName);
        }

        @Override
        public void appleSuperPower(Hero[] heroes, Boss boss) {
            int berserkSave;
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && heroes[i].getHeroName() == this.getHeroName()) {
                    berserkSave = boss.getDamage();
                    boss.setHealth(boss.getHealth() - berserkSave/2);
                }
            }
        }
    }