package creature;
import weapon.Weapon;

public abstract class Character implements Creature {
    private String name;
    private int hp;
    private Weapon weapon;

    public Character(String name,int hp,Weapon weapon){
        if (hp<0){
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
    }

    @Override
    public final boolean isAlive(){
        return this.hp>0;
    }
    @Override
    public void showStatus(){
        System.out.println(this.name+"：HP "+this.hp);
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getHp(){
        return hp;
    }
    @Override
    public void setHp(int hp){
        this.hp=Math.max(0,hp);
    }

    public Weapon getWeapon(){return weapon;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}

    public void die(){System.out.println(this.name + "は死んでしまった！");}
}
