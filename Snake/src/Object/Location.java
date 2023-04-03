package Object;

//位置类
public class Location {
    //位置的x指标
    private int x;
    //位置的y坐标
    private int y;
    //无参数构造函数
    public Location() {
    }
    //带参数构造函数
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //拷贝构造函数
    public Location(Location location) {
        this.setX(location.getX());
        this.setY(location.getY());
    }
    //获取x
    public int getX() {
        return x;
    }
    //获取y
    public int getY() {
        return y;
    }
    //设置x
    public void setX(int x) {
        this.x = x;
    }
    //设置y
    public void setY(int y) {
        this.y = y;
    }
    //判断两个位置是否相等
    public boolean equal(Location location) {
        if (location.getX()==x && location.getY()==y) return true;
        else return false;
    }

}
