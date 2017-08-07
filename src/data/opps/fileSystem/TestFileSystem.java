package data.opps.fileSystem;

/**
 * Q. Design a File system using OOPs concepts.
 *
 */
public class TestFileSystem {

	public static void main(String[] args) {
		Directory root = new Directory("ROOT", null);
		Directory dir1 = new Directory("CHILD_DIR", root);
		File file1 = new File("File1", root, "text_for_file1");
		File file2 = new File("File2", root, "text_for_file2");
		File file3 = new File("File3", root, "text_for_file3");
		
		root.addEntry(dir1);
		root.addEntry(file1);
		dir1.addEntry(file2);
		dir1.addEntry(file3);
		
		System.out.println("root name = "+root.getName()+ " , Root contents : ");
		traverse(root, 0);
		
	}

	private static void traverse(Directory root, int spaces) {
		for (Entry e : root.getContents()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < spaces; i++)
				sb.append("-");

			System.out.println(sb.toString() + e.getName());
			if (e.type() == EntryType.DIRECTORY) {
				traverse((Directory) e, spaces + 2);
			}
		}
	}

}
