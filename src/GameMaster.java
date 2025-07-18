import creature.Character;
import creature.Monster;
import creature.character.Hero;
import creature.character.SuperHero;
import creature.character.Thief;
import creature.character.Wizard;
import creature.monster.Goblin;
import creature.monster.Matango;
import creature.monster.Slime;

import java.util.ArrayList;
public class GameMaster {
    public static void main(String[] args){
        GameMaster game = new GameMaster();
        game.startGame();
        //Character c = new Character("名無し", 50);
        //Hero testHero = new Hero("テスト勇者", -10, "テスト剣");
    }

    public void startGame(){
        ArrayList<creature.Character> party = new ArrayList<>();
        Hero hero = new Hero("勇者",100,"剣");
        Wizard wizard = new Wizard("魔法使い",60,30);
        Thief thief = new Thief("盗賊",70);
        ArrayList<Monster> monsters = new ArrayList<>();
        /*
        hero.name = "ミナト";
        hero.hp = 200;
         */

        try{
            party.add(hero);
            party.add(wizard);
            party.add(thief);
            //party.add(new Hero("テストヒーロー",-10,"剣"));
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            System.out.println("エラーが発生しました。\nゲームを開始できません。");
            return;
        }

        try {
            monsters.add(new Matango('A',45));
            monsters.add(new Goblin('A',50));
            monsters.add(new Slime('A',40));
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.out.println("エラーが発生しました。\nゲームを開始できません。");
            return;
        }

        System.out.println("---味方パーティ---");
        for(creature.Character member : party){
            member.showStatus();
        }
        System.out.println("---敵グループ---");
        for(Monster monster : monsters){
            monster.showStatus();
        }

        System.out.println("\n味方の総攻撃！");
        if(hero.isAlive()){
            for(Monster targetMonster:monsters){
                hero.attack(targetMonster);
            }
        }
        if(wizard.isAlive()){
            for(Monster targetMonster:monsters){
                wizard.attack(targetMonster);
            }
        }
        if(thief.isAlive()){
            for(Monster targetMonster:monsters){
                thief.attack(targetMonster);
            }
        }

        System.out.println("\n敵の総攻撃！");
        for(Monster attackerM:new ArrayList<>(monsters)){
            if(!attackerM.isAlive()){
                continue;
            }
            for(creature.Character targetCharacter:party){
                if(targetCharacter.isAlive()){
                    attackerM.attack(targetCharacter);
                }
            }
        }

        System.out.println("\nダメージを受けた勇者が突然光りだした！");
        SuperHero superHero = new SuperHero(hero);
        for(int i=0; i< party.size(); i++){
            if(party.get(i)==hero){
                party.set(i,superHero);
                break;
            }
        }
        System.out.println("\n勇者はスーパーヒーローに進化した！");
        if(superHero.isAlive()){
            for(Monster targetMonster:monsters){
                superHero.attack(targetMonster);
            }
        }

        System.out.println("\n---味方パーティ最終ステータス---");
        for(Character member : party){
            member.showStatus();
            if(member.isAlive()){
                System.out.println(member.getName()+"：生存");
            }else{
                System.out.println(member.getName()+"：死亡");
            }
        }

        System.out.println("\n---敵グループ最終ステータス---");
        for(Monster monster : monsters){
            monster.showStatus();
            if(monster.isAlive()){
                System.out.println(monster.getName()+"：生存");
            }else{
                System.out.println(monster.getName()+"：討伐済み");
            }
        }
    }
}
