package adventure.game;

public class Main {

  private final Game game;

  public Main() {
    game = new Game();
    game.selectCharacter();
    game.startGame();
  }

  public static void main(String[] args) {
    new Main();
  }
}
