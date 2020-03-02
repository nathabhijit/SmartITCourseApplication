package com.myLearning.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("IT101", "Spring Framework", "Overview of Sprint Framework"),
			new Topic("IT102","Artificial Intelligence","In-depth Artificial Intteligence"),
			new Topic ("IT103","Kubernetes","Dev-Ops with Kubernetes in AWS Cloud")));


	
	public Topic getTopicById (String id)
	{
		return topicRepository.findById(id).orElse(null);
	}
	

	public List<Topic> getAllTopics ()
	{
		List<Topic> topiclist = new ArrayList<>();
		topicRepository.findAll().forEach(topiclist::add);
		return topiclist;
	}
	
	public void addTopic(Topic topic) {	
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
