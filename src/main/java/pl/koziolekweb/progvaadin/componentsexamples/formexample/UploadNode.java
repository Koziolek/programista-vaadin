package pl.koziolekweb.progvaadin.componentsexamples.formexample;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import pl.koziolekweb.progvaadin.componentsexamples.AbstractItemNode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 25.09.13
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("deprecation")
public class UploadNode extends AbstractItemNode {
	public UploadNode(HorizontalSplitPanel target) {
		super(target);
	}

	@Override
	public void onClick() {
		final ProgressIndicator progressIndicator = new ProgressIndicator();
		progressIndicator.setPollingInterval(10);
		Upload upload = new Upload();
		upload.setReceiver(new Upload.Receiver() {
			@Override
			public OutputStream receiveUpload(String filename, String mimeType) {
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream("/dev/null");
				} catch (FileNotFoundException e) {

				}
				return fos;
			}
		});
		upload.addProgressListener(new Upload.ProgressListener() {
			@Override
			public void updateProgress(long readBytes, long contentLength) {
				progressIndicator.setValue((float) readBytes / (float) contentLength);
				System.out.println( (float)readBytes / (float)contentLength);
			}
		});
		VerticalLayout vl = new VerticalLayout();
		vl.addComponent(upload);
		vl.addComponent(progressIndicator);
		setExample(vl);
		setSourceCode("final ProgressIndicator progressIndicator = new ProgressIndicator();" +
				"<br />progressIndicator.setPollingInterval(10);" +
				"<br />Upload upload = new Upload();" +
				"<br />upload.setReceiver(new Upload.Receiver() {" +
				"<br />@Override" +
				"<br />public OutputStream receiveUpload(String filename, String mimeType) {" +
				"<br />FileOutputStream fos = null;" +
				"<br />try {" +
				"<br />fos = new FileOutputStream(\"/dev/null\");" +
				"<br />} catch (FileNotFoundException e) {" +
				"<br />" +
				"<br />}" +
				"<br />return fos;" +
				"<br />}" +
				"<br />});" +
				"<br />upload.addProgressListener(new Upload.ProgressListener() {" +
				"<br />@Override" +
				"<br />public void updateProgress(long readBytes, long contentLength) {" +
				"<br />progressIndicator.setValue((float) readBytes / (float) contentLength);" +
				"<br />}" +
				"<br />});");
		done();
	}

	@Override
	public String toString() {
		return "Upload i pasek postępu";
	}
}
