package pl.koziolekweb.progvaadin.model;

import static pl.koziolekweb.progvaadin.model.WorkerType.ARTST;
import static pl.koziolekweb.progvaadin.model.WorkerType.BLUE_COLLAR;
import static pl.koziolekweb.progvaadin.model.WorkerType.WHITE_COLLAR;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.12.13
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public enum JobType {
	HAND_WORK(BLUE_COLLAR),
	OFFICE_WORK(WHITE_COLLAR),
	ART_WORK(ARTST);

	private final WorkerType workerType;

	private JobType(WorkerType workerType) {
		this.workerType = workerType;
	}

	public boolean isFor(WorkerType workerType) {
		return this.workerType == workerType;
	}
}
