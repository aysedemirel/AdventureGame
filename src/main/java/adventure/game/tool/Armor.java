package adventure.game.tool;

/**
 * @author aysedemireldeniz
 */
public enum Armor {
  LIGHT(1, 15),
  MID(3, 25),
  HEAVY(5, 45);

  final int money;
  final int damage;

  Armor(int damage, int money) {
    this.money = money;
    this.damage = damage;
  }

  public int getMoney() {
    return money;
  }

  public int getDamage() {
    return damage;
  }
}
