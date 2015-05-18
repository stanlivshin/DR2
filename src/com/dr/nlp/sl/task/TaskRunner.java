package com.dr.nlp.sl.task;

import java.util.ArrayList;

/**
 * Task Runner runs a list
 * of tasks based on Task Interface
 * 
 * @author Stan Livshin
 */
@SuppressWarnings("rawtypes")
public class TaskRunner {

	//stores a list of tasks
	private ArrayList<Task> tasks;
	
	/**
	 * @return arraylist of tasks
	 */
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * clears array list of all tasks
	 */
	public void resetTasks() {
		tasks = new ArrayList<>();
	}

	/**
	 * @param task - a task to add
	 */
	public void addTask(Task task) {
		tasks.add(task);
	}

	/**
	 * Default Constructor
	 */
	public TaskRunner() {
		tasks = new ArrayList<>();
	}
	
	/**
	 * Runs all tasks stored in the
	 * array list and then resets
	 * the array to be empty
	 */
	public void runTasks() {
		for (Task task: tasks){
			task.runTask();
		}
		resetTasks();
	}
}