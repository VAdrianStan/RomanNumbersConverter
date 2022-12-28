public class Roman {

    public static String convert(int n) {
        if (n > 3999)
            return "The number must be less than 4000";
        else {
            int[] splitedArray = splitNumber(n);
            String result = null;

            switch (splitedArray.length) {
                case 4:
                    result = convertThousands(splitedArray[0]) + convertHundreds(splitedArray[1]) +
                            convertDecimals(splitedArray[2]) + convertUnits(splitedArray[3]);
                    break;
                case 3:
                    result = convertHundreds(splitedArray[0]) +
                            convertDecimals(splitedArray[1]) + convertUnits(splitedArray[2]);
                    break;
                case 2:
                    result = convertDecimals(splitedArray[0]) + convertUnits(splitedArray[1]);
                    break;
                case 1:
                    result = convertUnits(splitedArray[0]);
                    break;
            }
            return result;
        }
    }

    static int[] splitNumber(int n) {

        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }

    static String convertThousands(int n) {
        String result = null;
        switch (n) {
            case 1:
                result = "M";
                break;
            case 2:
                result = "MM";
                break;
            case 3:
                result = "MMM";
                break;
        }
        return result;
    }

    static String convertHundreds(int n) {
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        return romanHundreds[n];
    }

    static String convertDecimals(int n) {
        String[] romanDecimals = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        return romanDecimals[n];
    }

    static String convertUnits(int n) {
        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return romanUnits[n];
    }
}
