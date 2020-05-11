// I avow that I did this exam without help from any other person.
//Andy Me

public class GenericTester<T extends Number<T>>{
    public <T> List<T> myMethod(Class<T> arrayX) {
        List<T> list = new ArrayList<>();
        list = Arrays.asList(arrayX);
        return list;
    }
}
