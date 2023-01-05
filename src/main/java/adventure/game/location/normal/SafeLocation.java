package adventure.game.location.normal;

import adventure.game.character.Archer;
import adventure.game.character.Knight;
import adventure.game.character.Samurai;
import adventure.game.player.Player;

public class SafeLocation implements NormalLocation {

  private final Player player;

  public SafeLocation(Player player) {
    this.player = player;
    onLocation();
  }

  public static void resetHealthy(Player player) {
    switch (player.getName()) {
      case "Knight" -> player.setHealthy(Knight.HEALTHY);
      case "Samurai" -> player.setHealthy(Samurai.HEALTHY);
      case "Archer" -> player.setHealthy(Archer.HEALTHY);
      default -> player.setHealthy(0);
    }
  }

  @Override
  public boolean onLocation() {
    showMenu();
    resetHealthy(player);
    System.out.println("Health: " + player.getHealthy());
    return true;
  }

  @Override
  public void showMenu() {
    System.out.println("Your health is refreshing....");
  }

  @Override
  public boolean isMenuActive() {
    return false;
  }
}
