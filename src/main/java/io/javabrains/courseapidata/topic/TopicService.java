package io.javabrains.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topics= new ArrayList<>( Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//            new Topic("java","Core Java","core java description"),
//            new Topic("javascript","Javascript","Javascript description")
//            ));
    public List<Topic> getAllTopics(){
//        return topics;  //getters and setters are compulsary for private members

        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();

        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }

        topicRepository.save(topic);

    }


    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
