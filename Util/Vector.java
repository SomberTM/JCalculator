package Util;

public abstract class Vector<T extends Number> {
    
    public T x, y;

    public Vector(T x, T y) {
        this.x = x; this.y = y;
    }

    public void replace(Vector<T> other) {
        this.x = other.x;
        this.y = other.y;
    }

}
