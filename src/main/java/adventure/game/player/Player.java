package adventure.game.player;

import adventure.game.character.GameCharacter;

public class Player {

  private int damage;
  private int money;
  private int healthy;
  private String name;

  public Player() {
  }

  public Player(GameCharacter ch) {
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
}
