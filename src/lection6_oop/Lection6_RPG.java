package lection6_oop;

import java.util.Random;
import java.util.Scanner;

public class Lection6_RPG {
    /*static class TrainingGround{
        public static void main(String[] args) {
            Enemy enemy = new Enemy();
            Hero heroWar = new Warrior("Warrior");
            heroWar.AttackEnemy(enemy);
            Hero heroMage = new Mage("Mage");
            heroMage.AttackEnemy(enemy);
            Hero heroArch = new Archer("Archer");
            heroArch.AttackEnemy(enemy);
        }
    }
    */

    static class BattleGroud{
        public static void main(String[] args) {
            Enemy enemy = new Vampire();
            Hero hero = new Mage("Qwerty");
            startBattle(enemy, hero);
        }
    }

    static void startBattle(Enemy enemy, Hero hero){
        System.out.println("Вы вступаете в бой");
        while(enemy.getHealth()>0 & hero.getHealthPoint()>0){
            hero.AttackEnemy(enemy);
        }
    }

}

//--------------------------------------------------------------------------------------------------------------------------

abstract class Hero{
    private String name;
    private int healthPoint;

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    Hero(String name){
        this.name = name;
    }

    abstract void AttackEnemy(Enemy enemy);

    void takeDamage(int damage){
        setHealthPoint(getHealthPoint()-damage);
        if(getHealthPoint() > 0){
            System.out.println("У вас осталось " + getHealthPoint() + " ед.здоровья");
        }
        else {
            System.out.println("Вы погибли!");
        }
    }

}

//--------------------------------------------------------------------------------------------------------------------------

class Warrior extends Hero{

    Warrior(String name) {
        super(name);
        setHealthPoint(120);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
                System.out.println("Воин " + getName() + " aтакует врага топором нанося " + damage + " ед. урона");
        }
        enemy.takeDamage(damage);
        if (enemy.isAlive()) {
            takeDamage(enemy.counterBlow());
        }
    }

    @Override
    void takeDamage(int damage) {
        Random random = new Random();
        int parry = random.nextInt(10);
        if(parry == 0 || parry == 1){
            System.out.println("Вы парируете удар!");
        }
        else{
            setHealthPoint(getHealthPoint()-damage);
            if(getHealthPoint() > 0){
                System.out.println("У вас осталось " + getHealthPoint() + " ед.здоровья");
            }
            else {
                System.out.println("Вы погибли!");
            }
        }
    }
}

//--------------------------------------------------------------------------------------------------------------------------

class Mage extends Hero{

    Mage(String name) {
        super(name);
        setHealthPoint(100);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        int frost = random.nextInt(99);
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
            System.out.println("Маг " + getName() + " aтакует врага ледяным шаром нанося " + damage + " ед. урона");
            if (frost > 75) {
                System.out.println("Попытка заморозить врага удалась!");
                enemy.frozen = true;
            }
            enemy.takeDamage(damage);
            if (enemy.isAlive() & !enemy.frozen) {
                takeDamage(enemy.counterBlow());
            }
            enemy.frozen = false;
        }
        }
}

//--------------------------------------------------------------------------------------------------------------------------

class Archer extends Hero{

    Archer(String name) {
        super(name);
        setHealthPoint(110);
    }

    @Override
    void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(30);
        int critical = random.nextInt(5);
        if(critical == 0 || critical == 1){
            damage *= 2;
        }
        if(damage==0){
            System.out.println("Вы промахнулись!");
        }
        else{
            if(critical == 0 || critical == 1){
                System.out.println("Лучник " + getName() + " наносит критический удар на " + damage*2 + " ед. урона");
            }
            else{
                System.out.println("Лучник " + getName() + " пускает в врага стрелу нанося " + damage + " ед. урона");
            }
        }
        enemy.takeDamage(damage);
        if (enemy.isAlive()) {
            takeDamage(enemy.counterBlow());
        }
    }
}

//--------------------------------------------------------------------------------------------------------------------------

interface Mortal{
    boolean isAlive();
}

abstract class Enemy implements Mortal{
    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    boolean frozen = false;

    void takeDamage(int damage){
        setHealth(getHealth()-damage);
        if(isAlive()){
            System.out.println("У врага осталось " + getHealth() + " ед. здоровья");
        }
        else {
            System.out.println("Враг повержен!");
        }
    }

    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if (counterblow == 0) {
            System.out.println("Враг промахнулся в ответ!");
            return counterblow;
        }
        else {
            System.out.println("Враг в ответ наносит " + counterblow + " ед. урона");
            return counterblow;
        }
    }

    @Override
    public boolean isAlive() {
        if(getHealth()>0){
            return true;
        }
        else return false;
    }
}

//--------------------------------------------------------------------------------------------------------------------------

class Zombie extends Enemy{
    boolean alive = true;

    Zombie(){
        setHealth(100);
    }

    @Override
    public boolean isAlive() {
        Random random = new Random();
        int ressurect = random.nextInt(5);
        if (getHealth()>0) {
            return true;
        }
        else{
            if(ressurect == 1 || ressurect == 3 || ressurect ==5 & alive){
                System.out.println("Зомби воскресает!");
                setHealth(100);
                alive = false;
                return true;
            }
            else{
                return false;
            }
        }
    }

}

class Snake extends Enemy{

    int poisoncounter = 0;

    Snake(){
        setHealth(100);
    }

    @Override
    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if (counterblow == 0) {
            System.out.println("Змея промахивается в ответ.");
            return counterblow;
        }
        else {
            ++poisoncounter;
            if (poisoncounter == 5) {
                System.out.println("Вы получаете смертельный урон от яда!");
                return 500;
            }
            else {
                System.out.println("Змея в ответ наносит " + counterblow + " ед. урона, степень отравления ядом: " + poisoncounter);
                return counterblow;
            }
        }
    }
}

class Vampire extends Enemy{

    Vampire(){
        setHealth(100);
    }

    @Override
    int counterBlow(){
        Random random = new Random();
        int counterblow = random.nextInt(20);
        if(counterblow==0){
            System.out.println("Вампир промахивается в ответ.");
            return counterblow;
        }
        else {
            System.out.println("Вампир в ответ наносит " + counterblow + " ед. урона и восстанавливает себе " + counterblow/2 + " ед. здоровья");
            setHealth(getHealth()+counterblow/2);
            return counterblow;
        }
    }

}


