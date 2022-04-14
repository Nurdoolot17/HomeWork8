package com.company;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50);
        Warrior warrior = new Warrior(270, 25, "Warrior");
        Medic doctor = new Medic(250, 10,15, "Doctor");
        Bersek bersek = new Bersek(300, 25, "Berserk");
        Magic magic = new Magic(250,30, "Magic");
        Medic assistant = new Medic(250, 10, 5, "Assistant");


        Hero[] heroes = new Hero[]{warrior, doctor, magic, assistant, bersek};

        printStatistics(heroes, boss);

        while(!isGameFinished(heroes, boss)){
            round(heroes,boss);
        }


    }

    private static void round(Hero[] heroes, Boss boss){
        roundNumber++;
        bossHits(heroes,boss);
        heroesHit(heroes,boss);
        applySuperPowers(heroes, boss);
        printStatistics(heroes,boss);

    }
    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("ROUND: " + roundNumber);
        System.out.println("Boss Health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getHeroName() + " Health: " + heroes[i].getHealth() + " [" + heroes[i].getDamage() + "]");
        }
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() >0){
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() >0){
                boss.setHealth(boss.getHealth() -heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0){
            System.out.println("Heroes Won");
            return true;
        }
        boolean allDeadHeroes = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allDeadHeroes = false;
                break;

            }
        }
        if (allDeadHeroes){
            System.out.println("Boss Won!");
        }
        return allDeadHeroes;
    }
    private static void applySuperPowers(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].appleSuperPower(heroes, boss);
            }
        }
    }
}
