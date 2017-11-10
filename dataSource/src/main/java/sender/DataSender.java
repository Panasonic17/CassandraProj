package sender;

/**
 * Created by Oleksandr_Shainoga on 11/9/2017.
 */
public interface DataSender<T> {
     void send(T data);
}
