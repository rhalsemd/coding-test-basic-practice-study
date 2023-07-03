import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node> l = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            l.add(new Node(A, B));
        }

        Collections.sort(l);

        Queue<Integer> q = new PriorityQueue<>();
        q.offer(l.get(0).end);

        for(int i = 1; i<N; i++){
            Node next = l.get(i);

            if(next.start < q.peek())
                q.offer(next.end);
            else{
                q.poll();
                q.offer(next.end);
            }
        }

        System.out.println(q.size());
    }
}
class Node implements Comparable<Node>{
    int start, end;

    Node(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node a){
        if(this.start == a.start)
            return this.end - a.end;
        return this.start - a.start;
    }
}