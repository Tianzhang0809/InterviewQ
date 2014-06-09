package online_test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindCity {
	public static void main(String[] args) {
		Integer[] first = { 1, 2, 3, 2, 5 };
		Integer[] second = { 3, 3, 4, 4, 6 };
		find_city(7, 1, 4, first, second);

	}

	public static void find_city(Integer n, Integer home_city,
			Integer dest_city, Integer[] firstCityRoads,
			Integer[] secondCityRoads) {
		if (home_city == dest_city) {
			System.out.println(1);
		}

		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < firstCityRoads.length; i++) {
			graph[firstCityRoads[i]][secondCityRoads[i]] = 1;
			graph[secondCityRoads[i]][firstCityRoads[i]] = 1;
		}

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		int len = 1;
		for (int i = 1; i <= n; i++) {
			if (graph[home_city][i] == 1) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int size = q.size(); // bfs to search each step
			for (int i = 0; i < size; i++) {
				int current = q.poll();
				visited.add(current);
				if (current == dest_city) {
					System.out.print(len);
					return;
				}

				for (int j = 1; j <= n; j++) {
					if (!visited.contains(j) && graph[current][j] == 1) {
						q.offer(j);
					}

				}

			}
			len++;
		}
		System.out.print(len);
	}

	private static void print(int[][] graph) {
		for (int[] arr : graph) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Challenge 3: City Roads You are living in a country with N cities. Each
	 * city is identified by an unique integer ID in the [1..N] range. The
	 * cities are connected by M bidirectional roads. All the roads have the
	 * same length. Given the ID of your home city and the ID of a destination
	 * city Your task is to write a function that prints to the standard output
	 * (stdout) the minimum number of roads you need to travel in order to reach
	 * the destination city. the destination city will always be accessible from
	 * your home city. Note that your function will receive the following
	 * arguments: N which is an integer number giving the number of cities
	 * home_city which is an integer number giving the ID of your home city
	 * dest_city which is an integer number giving the ID of the destination
	 * city firstCityRoads which is an array of integers giving the ID of the
	 * first city connected by each road secondCityRoads which is an array of
	 * integers giving the ID of the second city connected by each road The ith
	 * road connects the ith city in the firstCityRoad array and the ith city in
	 * the secondCityRoad array. Data constraints the number of cities will not
	 * exceed 5000 the number of roads will not exceed 100000 Efficiency
	 * constraints your function is expected to print the result in less than 2
	 * seconds Example Input Output N: 7 home_city: 1 dest_city: 4
	 * firstCityRoads: [1, 2, 3, 2, 5] secondCityRoads: [3, 3, 4, 4, 6] 2
	 * Explanation For the input presented above we have: 7 cities identified by
	 * IDs=1,2,3,4,5,6,7 5 roads connecting the following pairs of cities:
	 * (1,3), (2,3), (3,4), (2,4), (5,6) from your home city ID=1 you can reach
	 * the destination city ID=4 taking either the 1, 3, 4 route or 1, 3, 2, 4
	 * route the 1, 3, 4 route requires you to travel two roads (1,3) and (3,4)
	 * the 1, 3, 2, 4 route requires you to travel three roads (1,3), (3,2) and
	 * (2,4) the first route is the shortest one requiring you to travel only 2
	 * roads
	 */
}
