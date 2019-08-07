package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param other - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Point point = (Point) other;

        if (point.x == this.x && point.y == this.y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this == other) return true;
        if (other instanceof Bar) {
            Bar bar = (Bar) other;
            if ((this.x >= bar.getFirstCornerX() && this.x <= bar.getSecondCornerX())
                || (this.x <= bar.getFirstCornerX() && this.x >= bar.getSecondCornerX())
                    && (this.y >= bar.getFirstCornerY() && this.y <= bar.getSecondCornerY()) || (this.y <= bar.getFirstCornerY() && this.y >= bar.getSecondCornerY())
            )
                return true;
            else
                return false;
        } else {
            return true;
        }
    }
}
