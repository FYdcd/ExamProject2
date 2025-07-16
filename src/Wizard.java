public class Wizard extends Character{
    private int mp;

    public Wizard(String name,int hp,int mp){
        super(name, hp);
        this.mp = mp;
    }

    @Override
    public void attack(Creature target){
        if(this.mp>0){
            System.out.println(getName()+"は火の玉を放った！"+target.getName()+"に3のダメージを与えた！");
            target.setHp(target.getHp()-3);
            setMp(getMp()-1);
        }else{
            System.out.println(getName()+"はMPが足りず、攻撃できない！");
        }
    }

    public int getMp(){
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}
