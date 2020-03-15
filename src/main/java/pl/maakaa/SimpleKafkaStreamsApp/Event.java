package pl.maakaa.SimpleKafkaStreamsApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class that represents the event object that is read from and write to the kafka topic.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String content;
    private EventType type;
}
