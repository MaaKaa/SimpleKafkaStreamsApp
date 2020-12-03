package pl.maakaa.SimpleKafkaStreamsApp.kafka.config;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

/**
 * Interface that defines kafka streams.
 */
public interface KafkaStreamsProcessor {
    String FIRST_TOPIC = "input";
    String SECOND_TOPIC = "output";

    @Input(FIRST_TOPIC)
    KStream<?, ?> inboundEvents();

    @Output(SECOND_TOPIC)
    KStream<?, ?> outboundEvents();
}
