package adventure.game.location.battle;

public class River implements BattleLocation {

  private boolean isMenuActive = false;

  public River() {
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
    st.append("You are in RIVER");
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
