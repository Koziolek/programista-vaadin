package pl.koziolekweb.progvaadin.validators;


import com.vaadin.data.Validator;
import org.javatuples.Pair;
import pl.koziolekweb.progvaadin.model.JobType;
import pl.koziolekweb.progvaadin.model.WorkerType;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.12.13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public class JobToWorkerValidator implements Validator {

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (value instanceof Pair) {
			Pair<JobType, WorkerType> setting = (Pair<JobType, WorkerType>) value;
			if (!setting.getValue0().isFor(setting.getValue1()))
				throw new InvalidValueException("Nieprawidłowy typ zadania dla pracownika");
		}
	}
}
