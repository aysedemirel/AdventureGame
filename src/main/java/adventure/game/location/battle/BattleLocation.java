package adventure.game.location.battle;

import adventure.game.location.Location;

public interface BattleLocation extends Location {

  default void showMenu(String location) {
    String st = String.format("""
        +----------------------+
        |    You are in %s     |
        +----------------------+
        | Look around (1)      |
        | Return main menu (2) |
        +----------------------+""", location);
    System.out.println(st);
  }

}
