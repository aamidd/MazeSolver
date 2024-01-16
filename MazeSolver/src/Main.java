public class Main {

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        // random maze
        MazeSolver mazeSolver = new MazeSolver(mazeGenerator.randomaze());
        mazeSolver.solve();
        mazeSolver.draw();
        // maze from file
        mazeSolver = new MazeSolver(mazeGenerator.mazeFromFile("maze.txt"));
        mazeSolver.solve();
        mazeSolver.draw();
    }
}
