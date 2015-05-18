package com.dr.nlp.sl.task.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dr.nlp.sl.task.Task;
import com.dr.nlp.sl.task.TaskRunner;

public class TaskRunnerTest {

	@Test
	public void testTaskRunner() {
		TaskRunner taskRunner = new TaskRunner();
		assertEquals(0, taskRunner.getTasks().size());
		Task task = new Task() {

			@Override
			public void runTask() {}

			@Override
			public Object getResult() {	return null; }
		};
		taskRunner.addTask(task);
		assertEquals(1, taskRunner.getTasks().size());
		taskRunner.addTask(task);
		assertEquals(2, taskRunner.getTasks().size());
		taskRunner.runTasks();
		assertEquals(0, taskRunner.getTasks().size());
	}
}
