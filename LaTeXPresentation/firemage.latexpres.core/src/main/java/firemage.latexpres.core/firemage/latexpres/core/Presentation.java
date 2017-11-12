package firemage.latexpres.core;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import firemage.latexpres.core.section.Root;

public class Presentation {

		private Tree tree;
		private String title;
		private String date = "Montag, 22. Mai 2017";
		private String author = "Unknown";
		private File file = null;
		
		public Presentation(String title) {
			this.title = title;
			Root root = new Root(title);
			TreeNode rootNode = new TreeNode(root);
			tree = new Tree(rootNode);
		}

		/**
		 * @return the tree
		 */
		public Tree getTree() {
			return tree;
		}

		/**
		 * @param tree the tree to set
		 */
		public void setTree(Tree tree) {
			this.tree = tree;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the date
		 */
		public String getDate() {
			if(date == null || date.equals(""))
				return date = LocalDate.now()
						.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMAN));
			return date;
		}

		/**
		 * @param date the date to set
		 */
		public void setDate(String date) {
			this.date = date;
		}

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		/**
		 * @param author the author to set
		 */
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public TreeNode getElementById(String id) {
			for(TreeNode node : tree.getAllNodes()) {
				if(node == null)
					continue;
				if(node.getValue() == null)
					continue;
				if(node.getValue().getId() == null)
					throw new IllegalStateException("Unregistered node " + node.getValue().getTextToDisplay());
				if(node.getValue().getId().equals(id))
					return node;
			}
			throw new IllegalStateException("Unknwon id " + id);
		}

		/**
		 * @return the file
		 */
		public File getFile() {
			return file;
		}

		/**
		 * @param file the file to set
		 */
		public void setFile(File file) {
			this.file = file;
		}
}
