public class BarCode implements Comparable<BarCode> {
    private String _zip;
    private int _checkDigit;

    public BarCode(String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException("Zip is not the correct length");
	}
	_zip = zip;
	_checkDigit = checkSum();
    }

    private int checkSum () {
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    // NumberFormatException
	    sum += Integer.parseInt(_zip.substring(i, i+1));
	}
	return sum % 10;
    }

    public BarCode clone() {
	return new BarCode(_zip);
    }

    public int compareTo(BarCode other) {
	// CHANGE _zip to int
	int sum = _zip + _checkDigit;
	int otherSum = other._zip + other._checkDigit;
	return sum - otherSum;
    }

    public String toString() {
	String ret = "";
	for (int i = 0; i < _zip.length(); i++) {
	    // NumberFormatException
	    ret += findCode(Integer.parseInt(_zip.substring(i,i+1)));
	}
	return ret;
    }

    private String findCode(int num) {
	switch (num) {
	    case 0: return "||:::";
	    case 1: return ":::||";
	    case 2: return "::|:|";
	    case 3: return "::||:";
	    case 4: return ":|::|";
	    case 5: return ":|:|:";
	    case 6: return ":||::";
	    case 7: return "|:::|";
	    case 8: return "|::|:";
	    case 9: return "|:|::";
	    default: return "AAAAAAAA";
	}
    }
}
