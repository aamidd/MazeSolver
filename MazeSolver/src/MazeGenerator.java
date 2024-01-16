import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class MazeGenerator {

    public char[][] randomaze() {
        char[][] maze = new char[12][12];
        SecureRandom random = new SecureRandom();
        int randomEntrance = random.nextInt(10) + 1;
        int randomExit = random.nextInt(10) + 1;
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 11) {
                for (int j = 0; j < 12; j++) {
                    maze[i][j] = '#';
                }
            } else {
                if (i == randomEntrance) {
                    maze[i][0] = '.';
                } else {
                    maze[i][0] = '#';
                }
                if (i == randomExit) {
                    maze[i][11] = '.';
                } else {
                    maze[i][11] = '#';
                }
                for (int j = 1; j < 11; j++) {
                    maze[i][j] = random.nextInt(2) == 0 && j != 1 ? '#' : '.';
                }
            }
        }
        return maze;
    }

    public char[][] mazeFromFile(String path) {
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
