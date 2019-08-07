package ru.atom.geometry;

public class Bar implements Collider {
    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.firstCornerX = firstCornerX;
        this.firstCornerY = firstCornerY;
        this.secondCornerX = secondCornerX;
        this.secondCornerY = secondCornerY;
    }

    public int getFirstCornerX() {
        return firstCornerX;
    }

    public int getFirstCornerY() {
        return firstCornerY;
    }

    public int getSecondCornerX() {
        return secondCornerX;
    }

    public int getSecondCornerY() {
        return secondCornerY;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this == other) return true;
        if (other instanceof Point) {
            Point point = (Point) other;
            if ((point.getX() >= this.getFirstCornerX() && point.getX() <= this.getSecondCornerX()) && (point.getY() >= this.getFirstCornerY() && point.getY() <= this.getSecondCornerY()))
                return true;
            else
                return false;
        } else
            return false;
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (other instanceof Bar) {
            var bar = (Bar) other;
            if (this.barSquare() == bar.barSquare())
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    private int barSquare() {
        return firstCornerX * secondCornerX * firstCornerY * secondCornerY;
    }
}
