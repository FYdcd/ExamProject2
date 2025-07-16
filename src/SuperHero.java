public class SuperHero extends Hero{
    public SuperHero(Hero hero){
        super(hero.getName(), hero.getHp(), hero.getWeapon());
        System.out.println(hero.getName()+"はスーパーヒーローになった！");
    }

    @Override
    public void attack(Creature target){
        System.out.println(getName()+"は"+getWeapon()+"で攻撃！"+target.getName()+"に25のダメージを与えた！");
        target.setHp(target.getHp()-25);
    }
}
