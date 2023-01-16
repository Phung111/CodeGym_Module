package fileReadAndWrite;

public interface IModel<T> {
    T parseData(String line);
}
