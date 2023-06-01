import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class poliomino_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String boardLine = br.readLine();
        String[] boardArray = boardLine.split("");
        ArrayList<String> boards = new ArrayList<>();
        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i < boardArray.length; i++){
            String board = boardArray[i];
            if (board.equals("X")) {
                cnt++;
            } else {
                if (cnt == 2) {
                    boards.add("BB.");
                } else {
                    if (cnt >= 1) {
                        flag = true;
                        break;
                    } else {
                        boards.add(".");
                    }
                }
                cnt = 0;
            }
            if (cnt == 4) {
                cnt = 0;
                boards.add("AAAA");
            } else if (cnt == 2 && i == boardArray.length - 1) {
                cnt = 0;
                boards.add("BB");
            }
        }
        if (cnt == 1 || cnt == 3) {
            flag = true;
        }
        if (flag == false) {
            String joinedString = String.join("", boards);
            System.out.println(joinedString);
        } else {
            System.out.println(-1);
        }
    }
}
