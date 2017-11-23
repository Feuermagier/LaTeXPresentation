package firemage.latexpres.io;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import firemage.latexpres.core.Displayable;
import firemage.latexpres.core.ISection;
import firemage.latexpres.core.Presentation;
import firemage.latexpres.core.SlideType;
import firemage.latexpres.core.TreeNode;
import firemage.latexpres.core.section.Section;
import firemage.latexpres.core.section.SubSection;
import firemage.latexpres.core.section.SubSubSection;

public class SaveAction {

	private File file;
	private Presentation presToLoad;
	
	
	public Presentation load() {
		
		try {

			Document doc = new SAXBuilder().build(file);
			presToLoad = new Presentation(doc.getRootElement().getAttributeValue("name"));
			presToLoad.setFile(file);
			
			presToLoad.setAuthor(doc.getRootElement().getAttributeValue("author"));
			presToLoad.setDate(doc.getRootElement().getAttributeValue("date"));

			TreeNode root = presToLoad.getTree().getRoot();

			for (Element el : doc.getRootElement().getChildren()) {
				TreeNode childNode = addNode(el);
				if(childNode != null)
					root.addChild(addNode(el));
			}
	
			
			return presToLoad;
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private TreeNode addNode(Element el) {
		System.out.println("Element: " + el.getAttributeValue("name"));
		Displayable disp = null;
		if (el.getAttributeValue("type").equals(SlideType.LATEX_SLIDE.toString())) {
			LaTeXSlide slide = new LaTeXSlide(el.getAttributeValue("name"));
			slide.setText(el.getText());
			disp = slide;
		} else if(el.getAttributeValue("type").equals(SlideType.JAVA_ANIMATED_SLIDE.toString())) {
			JavaAnimatedSlide slide = new JavaAnimatedSlide(el.getAttributeValue("name"));
			slide.setCodeSource(pres.getFile(), el.getText());
			disp = slide;
		} else if (el.getAttributeValue("type").equals(SECTION)) {

			ISection section;

			switch (getDepth(el)) {
			case 1:
				section = new Section(el.getAttributeValue("name"));
				break;
			case 2:
				section = new SubSection(el.getAttributeValue("name"));
				break;
			case 3:
				section = new SubSubSection(el.getAttributeValue("name"));
				break;
			default:
				section = null;
			}

			disp = section;
		}
		
		if(disp == null)
			return null;

		TreeNode node = new TreeNode(disp);
		disp.setId(el.getAttributeValue("id"));
		if (Integer.parseInt(disp.getId()) > registerCounter)
			registerCounter = Integer.parseInt(disp.getId());

		if (el.getChildren().size() > 0) {
			for (Element child : el.getChildren()) {
				TreeNode childNode = addNode(child);
				if(childNode != null)
					node.addChild(addNode(child));
			}
		}

		return node;
	}

	private int getDepth(Element el) {
		Element parent = el.getParentElement();
		int depth = 0;
		while (parent != null) {
			parent = parent.getParentElement();
			depth++;
		}
		return depth;
	}
}
