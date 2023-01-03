package adventure.game.player;

import adventure.game.character.GameCharacter;

public class Player {

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
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getHealthy() {
    return healthy;
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

  public void printPlayer() {
    StringBuilder sb = new StringBuilder();
    sb.append("Player ").append(name).append("\n");
    sb.append("----------").append("\n");
    sb.append("Health: ").append(healthy).append("\n");
    sb.append("Damage: ").append(damage).append("\n");
    sb.append("Money: ").append(money).append("\n");
    sb.append("----------").append("\n");
    sb.append("Handgun: ").append(handgunCount).append("\n");
    sb.append("Rifle: ").append(rifleCount).append("\n");
    sb.append("Sword: ").append(swordCount).append("\n");
    sb.append("----------").append("\n");
    sb.append("Light armor: ").append(lightArmorCount).append("\n");
    sb.append("Mid armor: ").append(midArmorCount).append("\n");
    sb.append("Heavy armor: ").append(heavyArmorCount).append("\n");
    System.out.println(sb);
  }
}
