package mx.com.sfinx.iron_system.utils;

public class TextUtilities {

    /**
     * Convert an HEX string in byte array
     *
     * @param str - to convert in byte array
     * @return Byte array
     */
    public static byte[] hexStringToByteArray(String str) {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
                    + Character.digit(str.charAt(i+1), 16));
        }
        return data;
    }

    /**
     * Convert byte array to hex string
     * @param bytes
     * @return String
     */
    public static String byteArrayToHexString(byte[] bytes) {
        if(bytes == null)
            return null;

        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            // lower case
            // result.append(String.format("%02x", aByte));
            // upper case
            result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }
}
