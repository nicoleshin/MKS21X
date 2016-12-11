public class Barcode implements Comparable<Barcode> {

    public static void main(String[] args) {
        Barcode b = new Barcode("08451");
        System.out.println(b.toString());
        System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
    }

    private String _zip;
    private int _checkDigit;
    private static final String[] key = {"||:::",":::||","::|:|", "::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

    public Barcode(String zip) {
        if (zip.length() != 5) {
            throw new IllegalArgumentException("Zip must be 5 characters long");
        } else if (!allDigits(zip)) {
            throw new IllegalArgumentException("Zip must only contain digits");
        }
        _zip = zip;
        _checkDigit = getCheckDigit(_zip);
    }

    private static String getIndex(String code) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(code)) {
                return ""+i;
            }
        }
        return ":(";
    }

    private static int getCheckDigit(String zip) {
        int sum = 0;
        for (int i = 0; i < zip.length(); i++) {
            sum += Integer.parseInt(zip.substring(i, i+1));
        }
        return sum % 10;
    }

    private static boolean allDigits(String s) {
        try {
            int a = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int compareTo(Barcode other) {
        return _zip.compareTo(other._zip);
    }

    public String toString() {
        String ret = toCode(_zip);;
        return _zip + " " + ret;
    }

    public static String toCode(String zip) {
        if (zip.length() != 5) {
            throw new IllegalArgumentException("Zip must be 5 characters long");
        } else if (!allDigits(zip)) {
            throw new IllegalArgumentException("Zip must only contain digits");
        }
        String ret = "|";
        for (int i = 0; i < zip.length(); i++) {
            ret += key[Integer.parseInt(zip.substring(i,i+1))];
        }
        return ret + key[getCheckDigit(zip)] +"|";
    }

    public static String toZip(String code) {
        if (code.length() != 32) {
            throw new IllegalArgumentException("Barcode must be 32 characters long");
        } else if (code.charAt(0) != '|' && code.charAt(31) != '|') {
            throw new IllegalArgumentException("Barcode must start and end with '|'");
        }
        String ret = "";
        for (int i = 1; i < code.length()-7; i+=5) {
            String index = getIndex(code.substring(i,i+5));
            if (index.equals(":(")) {
                throw new IllegalArgumentException("Barcode is invalid");
            }
            ret += index;
        }
        String check = getIndex(code.substring(26,31));
        if (check.equals(":(") || getCheckDigit(ret) != Integer.parseInt(check)) {
            throw new IllegalArgumentException("The check digit of the barcode does not match the zip");
        }
        return ret;
    }
}
