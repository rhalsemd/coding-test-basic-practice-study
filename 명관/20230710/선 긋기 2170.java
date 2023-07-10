import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x;
    int y;

    public int compareTo(Point p) {
        return Integer.compare(x, p.x);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Point> point = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point.add(new Point(x, y));
        }

        Collections.sort(point);

        int result = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (right < point.get(i).x) {
                result += right - left;
                left = point.get(i).x;
                right = point.get(i).y;
            } else {
                right = Math.max(right, point.get(i).y);
            }
        }
        result += right - left;
        System.out.println(result);
    }
}