package TwoSigma;
public class Question1_2Sig {

	public static void main(String[] args) throws Exception {
		if (args.length == 1) {
			System.out.println(args[0]);

		} else if (args.length < 3) {
			throw new Exception("Invalid input!");
		} else {

			int dif1 = Integer.parseInt(args[1]) - Integer.parseInt(args[0]);
			int i = 1;
			int j = 2;
			int res = 0;

			while (j < args.length) {
				int n1 = Integer.parseInt(args[i]);
				int n2 = Integer.parseInt(args[j]);

				if ((n2 - n1) == 2 * dif1) {
					res = (n1 + n2) / 2;
				}
				i++;
				j++;

			}
			System.out.println(res);
		}

	}

}
