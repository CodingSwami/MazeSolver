import javax.swing.JFrame;
import java.util.*;
import java.awt.*;

public class NewClass extends JFrame {

    private int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    };
    public ArrayList<Integer> path = new ArrayList<>();

    public NewClass() {
        setTitle("Maze Solver");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze, 1, 1, path);
        System.out.println(path);

    }

    @Override
    public void paint(Graphics g) {
        g.translate(100, 150);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        for (int i = 0; i < path.size(); i += 2) {
            int path_x = path.get(i);
            int path_y = path.get(i + 1);

            System.out.println("X coordinate" + path_x);
            System.out.println("Y coordinate" + path_y);

            g.setColor(Color.GREEN);
            g.fillOval(30 * path_x, 30 * path_y, 20, 20);

        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
