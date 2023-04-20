package Medium;

public class NumberOfOperationToMakeNetworkConnection_1319 {

	public static void main(String[] args) {
		int [][] a = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		System.out.println(makeConnected(6, a));
	}

	public static int makeConnected(int n, int[][] connections) {
		int reqCables = n - 1;
		if (connections.length < reqCables) {
			return -1;
		}

		int[] count = new int[n];

		for (int i = 0; i < connections.length; i++) {
			for (int j = 0; j < 2; j++) {
				count[connections[i][j]]++;
			}
		}

		int res = 0;

		for (int i = 0; i < count.length; i++) {
			if ((i != 2 && i % 2 == 0) || i == 1) {
				if (count[i] > 2) {
					res += count[i] - 2;
				}
			} else {
				if (count[i] > 1) {
					res += count[i] - 1;
				}
			}
		}
		return res;
	}

}
