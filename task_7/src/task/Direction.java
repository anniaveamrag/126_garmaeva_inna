package task;

public enum Direction {
    North() {
        public Vector2 move(Vector2 start, double distance) {
            Vector2 z = new Vector2(start.getX(), start.getY() - distance);
            return z;
        }
    },
    West() {
        public Vector2 move(Vector2 start, double distance) {
            Vector2 z = new Vector2(start.getX() - distance, start.getY());
            return z;
        }
    },
    South() {
        public Vector2 move(Vector2 start, double distance) {
            Vector2 z = new Vector2(start.getX(), start.getY() + distance);
            return z;
        }
    },
    East() {
        public Vector2 move(Vector2 start, double distance) {
            Vector2 z = new Vector2(start.getX() + distance, start.getY());
            return z;
        }
    };
    public abstract Vector2 move(Vector2 start, double distance);
}
