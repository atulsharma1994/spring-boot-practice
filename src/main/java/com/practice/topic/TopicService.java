package com.practice.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> listOfTopics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring", "Spring Description"),
					new Topic("java", "Java", "Java Description"),
					new Topic("javascript", "JavaScript", "JavaScript Description"))
			);
			
	public List<Topic> getAllTopics() {
		return listOfTopics;
	}
	
	public void addTopic(Topic topic) {
		listOfTopics.add(topic);
	}
	
	public Topic getTopic(String id) {
		return listOfTopics.stream().filter( (topic) -> topic.getId().equals(id)).findFirst().get();
	}
	
	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<listOfTopics.size(); i++) {
			Topic t = listOfTopics.get(i);
			if(t.getId().equals(id)) {
				listOfTopics.set(i, topic);
				break;
			}
		}
	}
	
	public void deleteTopic(String id) {
		listOfTopics.removeIf((topic) -> topic.getId().equals(id));
	}
	
}
