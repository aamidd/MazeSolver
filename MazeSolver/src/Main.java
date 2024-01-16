import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char[][] maze =
                mazeFromFile("maze.txt");
        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.solve();
        mazeSolver.draw();
    }

    private static char[][] mazeFromFile(String path) {
        try {
            ArrayList<char[]> maze = new ArrayList<>();
            List<String> lines = Files.lines(Paths.get(path)).map(l -> l.replaceAll(" ", "")).toList();
            lines.forEach(l -> maze.add(l.toCharArray()));
            return maze.toArray(new char[0][0]);
        } catch (IOException e) {
            System.err.println("no such file");
        }
        return null;
    }
}
