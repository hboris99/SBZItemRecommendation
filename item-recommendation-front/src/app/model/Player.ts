export interface User{
  name : String,
  boughtItems : Item[],
  recommendedItems : Item[],
  isEnemy : boolean,
  currentGold : number,
  totalGold : number,
  statToItemize : String,
  enemyItems : Item[],
  drlEnemyItems: [Item[]],
  playerClass: PlayerClass


}

export interface Item{
  name : String
}

export enum PlayerClass{
  TANK, MARKSMAN, ASSASIN, SUPPORT, FIGHTER, MAGE
}
