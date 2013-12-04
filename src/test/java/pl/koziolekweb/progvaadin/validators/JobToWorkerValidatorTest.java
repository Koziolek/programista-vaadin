package pl.koziolekweb.progvaadin.validators;

import com.vaadin.data.Validator;
import org.fest.assertions.Assertions;
import org.javatuples.Pair;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.koziolekweb.progvaadin.model.JobType;
import pl.koziolekweb.progvaadin.model.WorkerType;

import static com.vaadin.data.Validator.InvalidValueException;
import static pl.koziolekweb.progvaadin.model.JobType.*;
import static pl.koziolekweb.progvaadin.model.WorkerType.*;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 04.12.13
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
public class JobToWorkerValidatorTest {

	private JobToWorkerValidator validator;

	@BeforeMethod
	public void setUp() throws Exception {
		validator = new JobToWorkerValidator();

	}

	@Test
	public void testValidateHandToBlue() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(HAND_WORK, BLUE_COLLAR);
		validator.validate(setting);
	}

	@Test
	private void testValidateArtToArtist() {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(ART_WORK, ARTST);
		validator.validate(setting);
	}

	@Test
	public void testValidateOfficeToWhite() {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(OFFICE_WORK, WHITE_COLLAR);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateHandToWhite() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(HAND_WORK, WHITE_COLLAR);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateHandToArtist() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(HAND_WORK, ARTST);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateOfficeToBlue() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(OFFICE_WORK, BLUE_COLLAR);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateOfficeToArtist() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(OFFICE_WORK, ARTST);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateArtToBlue() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(ART_WORK, BLUE_COLLAR);
		validator.validate(setting);
	}

	@Test(expectedExceptions = InvalidValueException.class)
	public void testValidateArtToWhite() throws Exception {
		Pair<JobType, WorkerType> setting = new Pair<JobType, WorkerType>(ART_WORK, WHITE_COLLAR);
		validator.validate(setting);
	}
}
