package adventure.game.location.battle;

import adventure.game.tool.Armor;
import adventure.game.tool.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class GiftGenerator {

  private static final String WEAPON = "Weapon";
  private static final String ARMOR = "Armor";
  private static final String MONEY = "Money";
  private static final String NOTHING = "Nothing";
  private static GiftGenerator instance;
  List<Weapon> weaponList;
  List<Armor> armorList;
  List<Integer> moneyList;
  List<String> all;

  public GiftGenerator() {
    createWeaponList();
    createArmorList();
    createMoneyList();
    createAllGiftList();
  }

  public static GiftGenerator getInstance() {
    if (instance == null) {
      instance = new GiftGenerator();
    }
    return instance;
  }

  private void createWeaponList() {
    weaponList = new ArrayList<>();
    weaponList.add(Weapon.HANDGUN); // 1
    weaponList.add(Weapon.HANDGUN); // 2
    weaponList.add(Weapon.HANDGUN); // 3
    weaponList.add(Weapon.HANDGUN); // 4
    weaponList.add(Weapon.HANDGUN); // 5
    weaponList.add(Weapon.SWORD); // 1
    weaponList.add(Weapon.SWORD); // 2
    weaponList.add(Weapon.SWORD); // 3
    weaponList.add(Weapon.RIFLE); // 1
    weaponList.add(Weapon.RIFLE); // 2
  }

  private void createArmorList() {
    armorList = new ArrayList<>();
    armorList.add(Armor.LIGHT); // 1
    armorList.add(Armor.LIGHT); // 2
    armorList.add(Armor.LIGHT); // 3
    armorList.add(Armor.LIGHT); // 4
    armorList.add(Armor.LIGHT); // 5
    armorList.add(Armor.MID); // 1
    armorList.add(Armor.MID); // 2
    armorList.add(Armor.MID); // 3
    armorList.add(Armor.HEAVY); // 1
    armorList.add(Armor.HEAVY); // 2
  }

  private void createMoneyList() {
    moneyList = new ArrayList<>();
    moneyList.add(1); // 1
    moneyList.add(1); // 2
    moneyList.add(1); // 3
    moneyList.add(1); // 4
    moneyList.add(1); // 5
    moneyList.add(5); // 1
    moneyList.add(5); // 2
    moneyList.add(5); // 3
    moneyList.add(10); // 1
    moneyList.add(10); // 2
  }

  private void createAllGiftList() {
    all = new ArrayList<>();
    all.add(WEAPON); // 1
    all.add(WEAPON); // 2
    all.add(WEAPON); // 3
    all.add(ARMOR); // 1
    all.add(ARMOR); // 2
    all.add(ARMOR); // 3
    all.add(MONEY); // 1
    all.add(MONEY); // 2
    all.add(MONEY); // 3
    all.add(MONEY); // 4
    all.add(MONEY); // 5
    all.add(NOTHING); // 1
    all.add(NOTHING); // 2
    all.add(NOTHING); // 3
    all.add(NOTHING); // 4
    all.add(NOTHING); // 5
    all.add(NOTHING); // 6
    all.add(NOTHING); // 7
    all.add(NOTHING); // 8
    all.add(NOTHING); // 9
  }

  public Object getRandomGift() {
    String gift = all.get(ThreadLocalRandom.current().nextInt(all.size() - 1));
    Object giftResult = NOTHING;
    switch (gift) {
      case WEAPON -> {
        Weapon w = weaponList.get(ThreadLocalRandom.current().nextInt(weaponList.size() - 1));
        switch (w) {
          case HANDGUN -> giftResult = Weapon.HANDGUN;
          case RIFLE -> giftResult = Weapon.RIFLE;
          case SWORD -> giftResult = Weapon.SWORD;
          default -> System.out.println("Something is wrong with random gift....");
        }
      }
      case ARMOR -> {
        Armor a = armorList.get(ThreadLocalRandom.current().nextInt(armorList.size() - 1));
        switch (a) {
          case HEAVY -> giftResult = Armor.HEAVY;
          case MID -> giftResult = Armor.MID;
          case LIGHT -> giftResult = Armor.LIGHT;
          default -> System.out.println("Something is wrong with random gift....");
        }
      }
      case MONEY -> {
        int m = moneyList.get(ThreadLocalRandom.current().nextInt(moneyList.size() - 1));
        giftResult = "money-> " + m;
      }
      default -> System.out.println("Sorry but you can not earn anything...");
    }
    return giftResult;
  }
}
