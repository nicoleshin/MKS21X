public class Barcode implements Comparable<Barcode> {

    private String _zip;
    private int _checkDigit;
    private static final String[] code = {"|||:::",":::||","::|:|", "::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

    public Barcode(String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException("Zip is not the correct length");
	}
	_zip = zip;
	_checkDigit = checkSum();
    }

    private int checkSum () {
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    if (Character.isDigit(_zip.charAt(i))) {
		throw new IllegalArgumentException("Zip must only contain numbers");
	    }
	    sum += Integer.parseInt(_zip.substring(i, i+1));
	}
	return sum % 10;
    }

    public int compareTo(Barcode other) {
	return _zip.compareTo(other._zip);
    }

    public String toString() {
	String ret = " |";
	for (int i = 0; i < _zip.length(); i++) {
	    ret += findCode(Integer.parseInt(_zip.substring(i,i+1)));
	}
	return _zip + ret + "|";
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
