package adventure.game.location.normal;

public class SafeLocation implements NormalLocation {

  private final boolean isMenuActive = false;

  public SafeLocation() {
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    return true;
  }

  @Override
  public void showMenu() {
    System.out.println("Your health is refreshing....");
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }
}
