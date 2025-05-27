import java.util.*;

public class Client {
    static ArrayList<ArrayList<Integer>> test_array_2 = new ArrayList<>();
    static {
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 1, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(9, 0, 0, 1, 0, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2, 0, 0, 0)));
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1)));
    }

    public static void main(String[] args) {
        List<String> path = findPath();
        System.out.println(path);
        printPathVisual(path);
    }

    private static List<String> findPath() {
        int rows = test_array_2.size();
        int cols = test_array_2.get(0).size();
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (test_array_2.get(r).get(c) == 1 && isBoundary(r, c, rows, cols)) {
                    int startWall = getWall(r, c, rows, cols);
                    ArrayList<String> path = new ArrayList<>();
                    if (dfs(r, c, startWall, path, visited, rows, cols)) {
                        return path;
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean dfs(int r, int c, int startWall,
                               List<String> path, boolean[][] visited,
                               int rows, int cols) {
        visited[r][c] = true;
        path.add(format(r, c));

        int thisWall = getWall(r, c, rows, cols);
        if (path.size() > 1
         && thisWall != -1
         && thisWall != startWall
         && (thisWall + 2) % 4 != startWall) {
            return true;
        }

        int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
        for (int[] d : deltas) {
            int nr = r + d[0], nc = c + d[1];
            if (inBounds(nr, nc, rows, cols)
             && test_array_2.get(nr).get(nc) == 1
             && !visited[nr][nc]) {
                if (dfs(nr, nc, startWall, path, visited, rows, cols)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private static void printPathVisual(List<String> path) {
        Set<String> set = new HashSet<>(path);
        int rows = test_array_2.size();
        int cols = test_array_2.get(0).size();
        for (int r = 0; r < rows; r++) {
            System.out.print("[ ");
            for (int c = 0; c < cols; c++) {
                String key = format(r, c);
                System.out.print(set.contains(key) ? "1" : " ");
                if (c < cols - 1) System.out.print(" , ");
            }
            System.out.println(" ]");
        }
    }

    private static int getWall(int r, int c, int R, int C) {
        if (r == 0)       return 0; // top
        if (c == C - 1)   return 1; // right
        if (r == R - 1)   return 2; // bottom
        if (c == 0)       return 3; // left
        return -1;
    }

    private static boolean inBounds(int r, int c, int R, int C) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    private static boolean isBoundary(int r, int c, int R, int C) {
        return getWall(r, c, R, C) != -1;
    }

    private static String format(int r, int c) {
        return "test_array_2[" + r + "][" + c + "]";
    }
}
