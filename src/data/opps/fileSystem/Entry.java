package data.opps.fileSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Entry {
	protected String name;
	protected Directory parent;
	protected long created_at;
	protected long modified_at;

	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		created_at = System.currentTimeMillis();
		modified_at = System.currentTimeMillis();
	}

	public boolean delete() {
		if (parent == null)
			return false;
		return parent.deleteEntry(this);
	}

	public abstract int size();

	public abstract EntryType type();

	public String getName() {
		return name;
	}

	public Directory getParent() {
		return parent;
	}

	public long getCreated_at() {
		return created_at;
	}

	public long getModified_at() {
		return modified_at;
	}

}

// subclasses : Directory , File

class Directory extends Entry {
	protected List<Entry> contents = null;

	public Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<Entry>();
	}

	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}

	// instead of addFile,AddDirectory we add Entry
	public void addEntry(Entry entry) {
		contents.add(entry);
	}

	protected List<Entry> getContents() {
		return contents;
	}

	public int numberOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e.type() == EntryType.DIRECTORY) {
				count++; // Directory counts as a file
				Directory d = (Directory) e;
				count += d.numberOfFiles();
			} else if (e.type() == EntryType.FILE)
				count++;
		}
		return count;
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry e : contents)
			size += e.size();

		return size;
	}

	@Override
	public EntryType type() {
		return EntryType.DIRECTORY;
	}

}

class File extends Entry {
	private String content;

	public File(String name, Directory parent, String content) {
		super(name, parent);
		this.content = content;
	}

	@Override
	public int size() {
		return content.length();
	}

	@Override
	public EntryType type() {
		return EntryType.FILE;
	}

}

enum EntryType {
	DIRECTORY, FILE
}
