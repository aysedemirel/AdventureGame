# AdventureGame

Text based adventure game

| To finish the game, after all the monsters in the war zones are cleared :                            |
|------------------------------------------------------------------------------------------------------|
| The region-specific reward must be added to the player's inventory.                                  |
| If the player can collect all the prizes and return to the "Safe House", s/he win the game.          |
| In addition, it is not possible to re-enter the region where the award was won.                      |
| When the player encounters a monster, who will make the first move must be determined by 50% chance. |                                                                                      |

## Battle Regions:

| Regional |          Prize          |   Monster    |
|----------|-------------------------|--------------|
| Cave     | Food                    | Zombie (1-3) |
| Forest   | Wood                    | Vampire(1-3) |
| River    | Water                   | Bear (1-3)   |
| Mine     | Money, Weapons or Armor | Snake (1-5)  |

## Monsters

| Monsters |          DAMAGE          | HEALTH |                    MONEY                    |
|----------|--------------------------|--------|---------------------------------------------|
| Snake    | Random (between 3 and 6) |     12 | None (Probability of gaining items instead) |
| Bear     | 7                        |     20 | 12                                          |
| Vampire  | 4                        |     14 | 7                                           |
| Zombie   | 3                        |     10 | 4                                           |

## Weapons

| Weapons | DAMAGE | MONEY |
|---------|--------|-------|
| Handgun |      2 |    25 |
| Rifle   |      7 |    45 |
| Sword   |      3 |    35 |

## Armors

| Armors | DAMAGE | MONEY |
|--------|--------|-------|
| Light  |      1 |    15 |
| Mid    |      3 |    25 |
| Heavy  |      5 |    40 |

## Characters

| Characters | DAMAGE | HEALTH | MONEY |
|------------|--------|--------|-------|
| Samurai    |      5 |     21 |    15 |
| Archer     |      7 |     18 |    20 |
| Knight     |      8 |     24 |     5 |

### In mine area

Items dropped from a defeated opponent in the mining area:

| Chances of not winning anything : 45% |
|---------------------------------------|

|       Weapon Chance: 15%       |
|--------------------------------|
| Rifle Chance of Winning 20%    |
| Sword Probability 30%          |
| Handgun Chances of Winning 50% |

|    Armor Probability : 15%     |
|--------------------------------|
| Chance to Gain Heavy Armor 20% |
| Medium Armor Chance 30%        |
| Chance to Gain Light Armor 50% |

| Chances of earning Money : 25% |
|--------------------------------|
| 10 Chances of Money 20%        |
| 5 Chances of Money 30%         |
| 1 Chance of Money 50%          |
