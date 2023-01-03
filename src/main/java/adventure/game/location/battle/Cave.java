package adventure.game.location.battle;

public class Cave implements BattleLocation {

  private boolean isMenuActive = false;

  public Cave() {
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    return false;
  }

  @Override
  public void showMenu() {
    StringBuilder st = new StringBuilder();
    st.append("You are in CAVE");
    st.append("Look around (1)");
    st.append("Return main menu (2)");
    System.out.println(st);
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }
}
