package adventure.game.tool;

/**
 * @author aysedemireldeniz
 */
public enum Weapon {
  HANDGUN(2, 25),
  RIFLE(7, 45),
  SWORD(3, 35);
  final int damage;
  final int money;

  Weapon(int damage, int money) {
    this.damage = damage;
    this.money = money;
  }

  public int getDamage() {
    return damage;
  }

  public int getMoney() {
    return money;
  }
}
