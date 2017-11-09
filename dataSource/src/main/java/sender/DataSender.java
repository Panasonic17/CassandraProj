package sender;

/**
 * Created by Oleksandr_Shainoga on 11/9/2017.
 */
public interface DataSender<T> {
    public void send(T data);
}
