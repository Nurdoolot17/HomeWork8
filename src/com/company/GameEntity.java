package com.company;

public  abstract class GameEntity {
    private int health;
    private int damage;

    public GameEntity(int heroesHealth, int heroesDamage) {
        this.health = heroesHealth;
        this.damage = heroesDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}