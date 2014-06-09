package TwoSigma;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class OnlineTest_2Sigma_Q2 {
	public static void main(String[] args) {
		int numOfDataCenter = 0;
		int datacenter = 1; // data center number starting from 1
		Pattern pattern = Pattern.compile(" ");

		// HashMap -> Key is file number, value is list of machines that
		// contain the file
		Map<Integer, ArrayList<Integer>> datasetMap = new HashMap<Integer, ArrayList<Integer>>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try {
			numOfDataCenter = parseInteger(bf.readLine());
			// map machine number to file number

			while (datacenter <= numOfDataCenter) {
				String line = bf.readLine();
				String[] tokens = pattern.split(line);

				for (int i = 1; i < tokens.length; i++) {
					int filenum = parseInteger(tokens[i]);
					ArrayList<Integer> dataset = datasetMap.get(filenum);

					if (dataset == null) {
						dataset = new ArrayList<Integer>();
					}

					dataset.add(datacenter);
					datasetMap.put(filenum, dataset);
				}

				datacenter++;
			}

			for (Integer f : datasetMap.keySet()) {
				for (int i = 1; i <= numOfDataCenter; i++) {
					if (!datasetMap.get(f).contains(i)) { // the file is not in
															// this machine
						System.out.println(f + " " + datasetMap.get(f).get(0)
								+ " " + i);
					}
				}
			}

			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static int parseInteger(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			i = -1;
		} finally {
			return i;
		}
	}
}
