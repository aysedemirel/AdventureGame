package adventure.game.player;

import adventure.game.armor.LightArmor;
import adventure.game.armor.MidArmor;
import adventure.game.armor.WeightyArmor;
import adventure.game.character.GameCharacter;
import adventure.game.weapon.Handgun;
import adventure.game.weapon.Rifle;
import adventure.game.weapon.Sword;

public class Player {

  private int waterCount = 0;
  private int woodenCount = 0;
  private int foodCount = 0;
  private int damage;
  private int money;
  private int healthy;
  private String name;
  private int handgunCount = 0;
  private int rifleCount = 0;
  private int swordCount = 0;
  private int lightArmorCount = 0;
  private int midArmorCount = 0;
  private int heavyArmorCount = 0;
  private GameCharacter character;

  public Player() {
  }

  public Player(GameCharacter ch) {
    this.character = ch;
    setDamage(ch.getDamage());
    setHealthy(ch.getHealthy());
    setMoney(ch.getMoney());
    setName(ch.getName());
  }

  public int getDamage() {
    int totalDamage = damage;
    totalDamage += handgunCount * Handgun.DAMAGE;
    totalDamage += rifleCount * Rifle.DAMAGE;
    totalDamage += swordCount * Sword.DAMAGE;
    return totalDamage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int giveDamage(int damage) {
    healthy -= damage;
    return healthy;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void addMoney(int m) {
    money += m;
  }

  public int getHealthy() {
    int totalHealth = healthy;
    totalHealth += lightArmorCount * LightArmor.DAMAGE;
    totalHealth += midArmorCount * MidArmor.DAMAGE;
    totalHealth += heavyArmorCount * WeightyArmor.DAMAGE;
    return totalHealth;
  }

  public void setHealthy(int healthy) {
    this.healthy = healthy;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addLightArmor() {
    lightArmorCount++;
    printPlayer();
  }

  public void addMidArmor() {
    midArmorCount++;
    printPlayer();
  }

  public void addHeavyArmor() {
    heavyArmorCount++;
    printPlayer();
  }

  public void addHandgun() {
    handgunCount++;
    printPlayer();
  }

  public void addRifle() {
    rifleCount++;
    printPlayer();
  }

  public void addSword() {
    swordCount++;
    printPlayer();
  }

  public int getHandgunCount() {
    return handgunCount;
  }

  public int getRifleCount() {
    return rifleCount;
  }

  public int getSwordCount() {
    return swordCount;
  }

  public int getLightArmorCount() {
    return lightArmorCount;
  }

  public int getMidArmorCount() {
    return midArmorCount;
  }

  public int getHeavyArmorCount() {
    return heavyArmorCount;
  }

  public void addWater() {
    waterCount++;
    printPlayer();
  }

  public void addFood() {
    foodCount++;
    printPlayer();
  }

  public void addWooden() {
    woodenCount++;
    printPlayer();
  }

  public boolean isWin() {
    return waterCount > 0 && foodCount > 0 && woodenCount > 0;
  }

  public void printPlayer() {
    String st = String.format("""   
            +------------+-------------+-----------------+------------+
            |                       Player %s                         |
            +------------+-------------+-----------------+------------+
            | Health: %d | Handgun: %d | Light armor: %d | Water: %d  |
            | Damage: %d | Rifle: %d   | Mid armor: %d   | Food: %d   |
            | Money: %d  | Sword: %d   | Heavy armor: %d | Wooden: %d |
            +------------+-------------+-----------------+------------+""",
        name,
        healthy, handgunCount, lightArmorCount, waterCount,
        damage, rifleCount, midArmorCount, foodCount,
        money, swordCount, heavyArmorCount, woodenCount);
    System.out.println(st);
  }
}
