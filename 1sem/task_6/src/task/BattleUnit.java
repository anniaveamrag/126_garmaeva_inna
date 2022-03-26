package task;

public class BattleUnit {
    private int Strength, Armor, Health, X, Y;
    public BattleUnit(int Strength, int Armor, int Health, int X, int Y) {
    this.Strength = Strength; this.Armor = Armor; this.Health = Health; this.X = X; this.Y = Y; }
    public int getStrength() {
        return Strength; }
    public int getArmor() {
        return Armor; }
    public int getHealth() {
        return Health; }
    public int getX() {
        return X; }
    public int getY() {
        return Y;}
    public void attacked(BattleUnit enemy) {
        if ((Armor >= 0) && (enemy.getStrength() - Armor > 0))
            Health = Health - (enemy.getStrength() - Armor);
        else if (Armor < 0)
            Health = Health - (enemy.getStrength()); }
    public boolean isAlive() {
        if (Health >= 0)
            return true;
        else {
            return false;
        }
    }
    public void moveUp() {
        Y = Y - 1; }
    public void moveDown() {
        Y = Y + 1; }
    public void moveLeft() {
        X = X - 1; }
    public void moveRight() {
        X = X + 1; }
    }
