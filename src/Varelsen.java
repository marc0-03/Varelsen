public class Varelsen {
    private int Hunger;
    private int Direction;


    public Varelsen(int hunger){
        Hunger = hunger;
        Direction = (int) Math.random()*4;
    }


    public void Eat(int food){
        Hunger+=food;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }
    public int getDirection() {
        return Direction;
    }

    public void changeHunger() {
        Hunger=-1;
    }
    public boolean starveCheck() {
        if (Hunger==0) {
            return true;
        } else {
            return false;
        }
    }
}
