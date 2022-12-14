import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.function.Consumer;

class StreamConsumer implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamConsumer(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
    }
}
