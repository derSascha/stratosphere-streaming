/***********************************************************************************************************************
 *
 * Copyright (C) 2010 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 **********************************************************************************************************************/

package eu.stratosphere.nephele.plugins;

import eu.stratosphere.nephele.configuration.Configuration;
import eu.stratosphere.nephele.io.IOReadableWritable;
import eu.stratosphere.nephele.taskmanager.Task;

public interface TaskManagerPlugin extends PluginCommunication {

	/**
	 * Registers a new incoming task with this task manager plugin.
	 * 
	 * @param id
	 *        the ID of the vertex representing the task
	 * @param jobConfiguration
	 *        the job configuration
	 * @param environment
	 *        the environment of the task
	 * @param pluginData
	 *        arbitrary data attached by plugins on the job manager for use by plugins on the task manager
	 */
	public void registerTask(Task task, Configuration jobConfiguration, IOReadableWritable pluginData);

	/**
	 * Unregisters a finished, canceled, or failed task from this task manager plugin.
	 * 
	 * @param task The task.
	 */
	public void unregisterTask(Task task);

	/**
	 * Called by the task manager to indicate that Nephele is about to shut down.
	 */
	public void shutdown();
}
