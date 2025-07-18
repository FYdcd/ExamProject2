package creature.monster;

import creature.Creature;
import creature.Monster;

public class Goblin extends Monster {
    public Goblin(char suffix,int hp){
        super("ゴブリン",hp,suffix); // ここで名前を渡しているため、GameMasterでは不要
    }

    @Override
    public void attack(Creature target){
        System.out.println(getName()+getSuffix()+"はナイフで切りつけた！"+target.getName()+"に8のダメージを与えた！");
        target.setHp(target.getHp()-8);
    }
}