package adventure.game.location.normal;

import adventure.game.location.Location;
import adventure.game.player.Player;

public class SafeLocation implements Location {

  private final Player player;

  public SafeLocation(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    player.resetHealth();
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

  @Override
  public String getName() {
    return "SAFE AREA";
  }
}
