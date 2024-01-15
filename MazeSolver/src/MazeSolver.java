import java.util.ArrayList;

public class MazeSolver {
    private final char[][] maze;
    private final int entrancePoint;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
        entrancePoint = findEntrance();
        if (entrancePoint == -1){
            System.err.println("no entrance point. terminating.");
            System.exit(1);
        }
    }

    public void solve() {
        if (!solve(maze, entrancePoint, 0))
            System.out.println("Unsolvable maze");
    }

    private boolean solve(char[][] maze, int y, int x) {
        if (maze[y][x] == '#') {
            return false;
        }
        maze[y][x] = 'x';
        if (isExt(y, x)) {
            return true;
        }

        int[][] possibleMoves = possibleMoves(y, x);
        for (int[] m : possibleMoves) {
            if (solve(maze, y + m[0], x + m[1])) {
                return true;
            }
        }
        maze[y][x] = '.';
        return false;
    }

    public void draw() {
        for (char[] row : maze) {
            for (char c : row) {
                if (c == 'x')
                    System.out.printf("\u001B[31m%c\u001B[0m ", c);
                else
                    System.out.printf("%c ", c);
            }
            System.out.println();
        }
        System.out.printf("%n%n%n");
    }

    private int[][] possibleMoves(int y, int x) {
        ArrayList<int[]> moves = new ArrayList<>();
        if (x != 0 && maze[y][x - 1] == '.') {
            moves.add(new int[]{0, -1});
        }
        if (maze[y - 1][x] == '.') {
            moves.add(new int[]{-1, 0});
        }
        if (maze[y + 1][x] == '.') {
            moves.add(new int[]{1, 0});
        }
        if (maze[y][x + 1] == '.') {
            moves.add(new int[]{0, 1});
        }

        return moves.toArray(new int[0][0]);
    }

    private int findEntrance() {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == '.')
                return i;
        }
        return -1;
    }

    private boolean isExt(int y, int x) {
        return !(y == entrancePoint && x == 0) && (x == 0 || x == maze[0].length - 1 || y == 0 || y == maze.length - 1);
    }
}
