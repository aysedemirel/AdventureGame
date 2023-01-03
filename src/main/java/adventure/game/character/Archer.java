package adventure.game.character;

public class Archer implements GameCharacter {

  public static final int HEALTHY = 18;
  public static final int DAMAGE = 7;
  public static final int MONEY = 20;

  public static String getCharMenu() {
    Archer archer = new Archer();
    return "Name: " + archer.getName() + " (a):" + "Damage:"
        + archer.getDamage() + "----" + "Health:" + archer.getHealthy() + "----"
        + "Money: " + archer.getMoney() + "\n";
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
    return "Archer";
  }
}
