package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor); }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int a = 999999;
        int b = 0;
        BattleUnit a1 = null;
        BattleUnit b1 = null;
        for (int i = 0; i < ownTeam.length; i++) {
            if (ownTeam[i].health() < a && ownTeam[i].health() > 0) {
                a = ownTeam[i].health();
                a1 = ownTeam[i]; }
            else if (ownTeam[i].health() > b && ownTeam[i].health() > 0) {
                b1 = ownTeam[i];
                b = ownTeam[i].health(); }
        }
        a1.heal(10);
        b1.setStrength(a1.strength()+1); }
    public void attack(BattleUnit other){
        other.setStrength(other.strength()-2);
        other.setMaxHealth(other.maxHealth()-4); }
}

