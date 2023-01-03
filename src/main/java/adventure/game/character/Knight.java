package adventure.game.character;

public class Knight implements GameCharacter {

  public static final int HEALTHY = 24;
  public static final int DAMAGE = 8;
  public static final int MONEY = 5;

  public static String getCharMenu() {
    Knight knight = new Knight();
    return "Name: " + knight.getName() + " (k):" + "Damage:" + knight.getDamage()
        + "----" + "Health:" + knight.getHealthy() + "----" + "Money: "
        + knight.getMoney() + "\n";
  }

  @Override
  public int getHealthy() {
    return HEALTHY;
  }

  @Override
  public int getMoney() {
    return MONEY;
  }

  @Override
  public int getDamage() {
    return DAMAGE;
  }

  @Override
  public String getName() {
    return "Knight";
  }
}
