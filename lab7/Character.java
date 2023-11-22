public class Character {
  private String name;
  private int health;
  private double damage;
  private double speed;

  Character(String name, int health, double damage, double speed) {
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.speed = speed;
  };

  @Override
  public String toString() {
    return "Character \"" + this.name + "\": health = " + this.health + ", damage = " + this.damage + ", speed = " + this.speed;
  };
};
