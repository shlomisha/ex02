package todolist.huji.ac.il.todolist;

public class ToDoListItem {

	private static int _lastID = 0;

	private int _id;
	private String _name;
	private String _deadLine;

	public ToDoListItem(String name, String deadLine) {
		_lastID++;

		this._id = _lastID;
		this._name = name;
		this._deadLine = deadLine;
	}

	public int getID() {
		return (this._id);
	}

	public String getName() {
		return (this._name);
	}

	public String getDeadLine() {
		return (this._deadLine);
	}

}