package adventure.game.location;

import java.util.Scanner;

/**
 * @author aysedemireldeniz
 */
public interface Location {

  Scanner scanner = new Scanner(System.in);

  boolean onLocation();

  void showMenu();

  boolean isMenuActive();

  String getName();

}
