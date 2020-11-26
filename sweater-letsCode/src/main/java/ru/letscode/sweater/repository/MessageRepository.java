package ru.letscode.sweater.repository;

import org.springframework.data.repository.CrudRepository;
import ru.letscode.sweater.entyti.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);

}
