package Util;

public class IntVector extends Vector<Integer> {

    public IntVector(int x, int y) {
        super(x, y);
    }
    
    public static IntVector fromDimension(java.awt.Dimension dimension) {
        return new IntVector((int)dimension.getWidth(), (int)dimension.getHeight());
    }

    public IntVector divide(int amount) {
        this.x /= amount;
        this.y /= amount;
        return this;
    }

    public IntVector divout(int amount) {
        return new IntVector(this.x / amount, this.y / amount);
    }

    @Override
    public String toString() {
        return String.format("[x: %d, y: %d]", this.x, this.y);
    }

}