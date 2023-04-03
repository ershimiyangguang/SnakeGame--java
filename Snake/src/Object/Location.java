package Object;

public class Location {
    private int x;
    private int y;

    public Location() {
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location location) {
        this.setX(location.getX());
        this.setY(location.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equal(Location location) {
        if (location.getX()==x && location.getY()==y) return true;
        else return false;
    }

}
