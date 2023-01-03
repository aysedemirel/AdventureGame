package adventure.game.location.battle;

public class Forest implements BattleLocation {

  private boolean isMenuActive = false;

  public Forest() {
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
    st.append("You are in FOREST");
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
