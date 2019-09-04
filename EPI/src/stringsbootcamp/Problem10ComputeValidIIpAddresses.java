package stringsbootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem10ComputeValidIIpAddresses {

	public static void main(String[] args) {
		List<String> validIpAddress = getValidIpAddress("19216800");
		System.out.println(validIpAddress.size());
		Iterator<String>  iterator = validIpAddress.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	private static List<String> getValidIpAddress(String ip) {
		List<String> validIps = new ArrayList<>();
		for (int i = 1; i < 4 && i < ip.length(); i++) {
			String firstPart = ip.substring(0, i);
			if(isValidOctal(firstPart)) {
				for (int j = 1; j < 4 && i+j < ip.length(); j++) {
					String secondPart = ip.substring(i, i+j);
					if(isValidOctal(secondPart)) {
						for (int k = 1; k < 4 && i+j+k < ip.length(); k++) {
							String thirdPart = ip.substring(j+i, i+k+j);
							String fourthPart = ip.substring(i+k+j);
							if(isValidOctal(thirdPart) && isValidOctal(fourthPart)) {
								validIps.add(firstPart+"."+secondPart+"."+thirdPart+"."+fourthPart);
							}
						}
					}
				}
			}
		}

		return validIps;
	}

	public static boolean isValidOctal(String octal) {
		if (octal.length() > 3) {
			return false;
		}
		if (octal.startsWith("0") && octal.length() > 1) {
			return false;
		}
		int parseInt = Integer.parseInt(octal);
		return parseInt >= 0 && parseInt <= 255;
	}

}
