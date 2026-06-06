import java.util.*;

public class Main {

    static class Employee {
        int dest;
        long weight;

        Employee(int dest, long weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            long P = sc.nextLong();
            long W = sc.nextLong();

            int[] waiting = new int[n + 1];

            for (int i = 1; i <= n - 1; i++) {
                waiting[i] = sc.nextInt();
            }

            List<Employee>[] floors = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                floors[i] = new ArrayList<>();
            }

            for (int i = 1; i <= n - 1; i++) {

                int cnt = waiting[i];

                int[] dests = new int[cnt];
                for (int j = 0; j < cnt; j++) {
                    dests[j] = sc.nextInt();
                }

                long[] weights = new long[cnt];
                for (int j = 0; j < cnt; j++) {
                    weights[j] = sc.nextLong();
                }

                for (int j = 0; j < cnt; j++) {
                    floors[i].add(new Employee(dests[j], weights[j]));
                }
            }

            long currentPersons = 0;
            long currentWeight = 0;

            Map<Integer, long[]> inside = new HashMap<>();

            int answer = n;

            for (int floor = 1; floor <= n; floor++) {

                long[] leaving = inside.remove(floor);

                if (leaving != null) {
                    currentPersons -= leaving[0];
                    currentWeight -= leaving[1];
                }

                for (Employee emp : floors[floor]) {

                    currentPersons++;
                    currentWeight += emp.weight;

                    long[] arr = inside.getOrDefault(emp.dest, new long[2]);
                    arr[0]++;
                    arr[1] += emp.weight;
                    inside.put(emp.dest, arr);
                }

                if (currentPersons > P || currentWeight > W) {
                    answer = floor;
                    break;
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
