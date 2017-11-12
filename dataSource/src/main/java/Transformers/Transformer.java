package Transformers;

public interface Transformer<T,O> {
    T transform(O row);
}
