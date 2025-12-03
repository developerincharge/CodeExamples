package generics;

class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }
}

public class GenericsDemo {

    public static void main(String[] args) {

        Box<Integer> integerBox = new Box<>(567);
        System.out.println("Integer box contains :  "+integerBox.getContent());

        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println(stringBox.getContent());

    }
}
