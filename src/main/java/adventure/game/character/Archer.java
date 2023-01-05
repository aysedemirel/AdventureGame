package adventure.game.character;

public class Archer implements GameCharacter {

  public static final int HEALTHY = 18;
  public static final int DAMAGE = 7;
  public static final int MONEY = 20;

  public static String getCharMenu() {
    Archer archer = new Archer();
    return String.format("""             
        | %s (a) | Damage: %d | Health: %d | Money: %d |
        +--------------+------------+------------+-----------+
        """, archer.getName(), archer.getDamage(), archer.getHealthy(), archer.getMoney());
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
