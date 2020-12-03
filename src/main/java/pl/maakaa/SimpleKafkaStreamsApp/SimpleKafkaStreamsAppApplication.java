package pl.maakaa.SimpleKafkaStreamsApp;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import pl.maakaa.SimpleKafkaStreamsApp.domain.Event;
import pl.maakaa.SimpleKafkaStreamsApp.domain.enums.EventType;
import pl.maakaa.SimpleKafkaStreamsApp.kafka.config.KafkaStreamsProcessor;

@SpringBootApplication
@EnableBinding(KafkaStreamsProcessor.class)
public class SimpleKafkaStreamsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaStreamsAppApplication.class, args);
	}

	/**
	 * Method that consumes events from the first kafka topic, filters them and passes filtered events to the second topic.
	 * @param events - a stream of events to be processed.
	 * @return KStream - a stream of filtered events.
	 */
	@StreamListener(KafkaStreamsProcessor.FIRST_TOPIC)
	@SendTo(KafkaStreamsProcessor.SECOND_TOPIC)
	public KStream<?, Event> process(KStream<?, Event> events) {
		return events
				.filter((key, value) -> value.getType().equals(EventType.NEW))
				.map((key, value) -> new KeyValue<>(null, value));
	}

}
