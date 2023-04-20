package Medium;

public class PushDominoes_838 {

	public static void main(String[] args) {
		System.out.println(pushDominoes("R.R.L"));
	}

	public static String pushDominoes(String dominoes) {
		char[] arr = dominoes.toCharArray();

		int i = 0;
		while (i < arr.length) {
			if (arr[i] == '.') {
				i++;
			} else if (arr[i] == 'L') {
				for (int a = i - 1; a >= 0; a--) {
					if (arr[a] == '.') {
						arr[a] = 'L';
					} else {
						break;
					}
				}
				i++;
			} else {
				int b = i + 1;
				if (i == arr.length - 1 || arr[b] == 'R') {
					i++;
					continue;
				}
				boolean noL = true;
                int till = arr.length;
				for (; b < arr.length; b++) {
					if (arr[b] == 'L') {
						noL = false;
						break;
					}
                    if(arr[b] == 'R'){
                        till = b;
                        break;
                    }
				}
				if (noL) {
					for (; i < till; i++) {
						arr[i] = 'R';
					}
					i = b;
				} else {
					int diff = b - i;
					while (diff > 2) {
						arr[++i] = 'R';
						arr[--b] = 'L';
						diff -= 2;
					}
					i = b+1;
				}
			}
		}
		return new String(arr);
	}
}
