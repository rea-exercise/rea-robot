package com.codeexercise.robot;

/**
 *
 * A point representing a location in (x,y) coordinate space, specified in
 * integer precision.
 *
 */
public final class Location {

    private final  int x;

    private final int y;

    /**
     * @return Returns the X coordinate of this Point
     */
    public int getX() {
        return x;
    }

    /**
     * @return Returns the Y coordinate of this Point
     */
    public int getY() {
        return y;
    }


    /**
     * Constructs and initializes a point at the specified (x,y) location in the
     * coordinate space.
     *
     * @param x
     * @param y
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /*
     * Returns a string representation of the point, such as "(5, -2)".
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals( Object obj ) {
        if (obj instanceof Location) {
            Location l = (Location)obj;
            return l.x == x && l.y == y;
        } else {
            return false;
        }
    }

}
