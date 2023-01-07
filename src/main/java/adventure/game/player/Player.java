package adventure.game.player;

import adventure.game.character.GameCharacter;
import adventure.game.tool.Armor;
import adventure.game.tool.Weapon;
import java.util.Locale;

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
    totalDamage += handgunCount * Weapon.HANDGUN.getDamage();
    totalDamage += rifleCount * Weapon.RIFLE.getDamage();
    totalDamage += swordCount * Weapon.SWORD.getDamage();
    return totalDamage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void giveDamage(int damage) {
    healthy -= damage;
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
    totalHealth += lightArmorCount * Armor.LIGHT.getDamage();
    totalHealth += midArmorCount * Armor.MID.getDamage();
    totalHealth += heavyArmorCount * Armor.HEAVY.getDamage();
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
    money -= Armor.LIGHT.getMoney();
    printPlayer();
  }

  public void addMidArmor() {
    midArmorCount++;
    money -= Armor.MID.getMoney();
    printPlayer();
  }

  public void addHeavyArmor() {
    heavyArmorCount++;
    money -= Armor.HEAVY.getMoney();
    printPlayer();
  }

  public void addHandgun() {
    handgunCount++;
    money -= Weapon.HANDGUN.getMoney();
    printPlayer();
  }

  public void addRifle() {
    rifleCount++;
    money -= Weapon.RIFLE.getMoney();
    printPlayer();
  }

  public void addSword() {
    swordCount++;
    money -= Weapon.SWORD.getMoney();
    printPlayer();
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
                                   Player %s
            +------------+-------------+-----------------+------------+
            | Health: %d | Handgun: %d | Light armor: %d | Water: %d  |
            | Damage: %d | Rifle: %d   | Mid armor: %d   | Food: %d   |
            | Money: %d  | Sword: %d   | Heavy armor: %d | Wooden: %d |
            +------------+-------------+-----------------+------------+""",
        name.toUpperCase(Locale.ENGLISH),
        healthy, handgunCount, lightArmorCount, waterCount,
        damage, rifleCount, midArmorCount, foodCount,
        money, swordCount, heavyArmorCount, woodenCount);
    System.out.println(st);
  }

  public boolean isCaveFinish() {
    return foodCount > 0;
  }

  public boolean isForestFinish() {
    return woodenCount > 0;
  }

  public boolean isRiverFinish() {
    return waterCount > 0;
  }

  public boolean isMoneyEnough(int money) {
    if (getMoney() >= money) {
      return true;
    } else {
      System.out.println("Sorry, You don't have enough money...");
      return false;
    }
  }

  public void resetHealth() {
    setHealthy(character.getHealthy());
  }
}
