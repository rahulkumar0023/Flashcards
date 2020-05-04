public class AsciiCharSequence implements CharSequence /* extends/implements */ {

    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int i) {
        return toString().charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(bytes, i, i1));
    }

    public String toString(){
        return new String(bytes);
    }
    // implementation
}