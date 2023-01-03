package adventure.game.location.battle;

import adventure.game.location.Location;

public interface BattleLocation extends Location {

  default void showMenu(String location) {
    StringBuilder st = new StringBuilder();
    st.append("You are in ");
    st.append(location);
    st.append("Look around (1)");
    st.append("Return main menu (2)");
    System.out.println(st);
  }

}
