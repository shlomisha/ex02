package todolist.huji.ac.il.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoListManagerActivity extends AppCompatActivity {

	public ListItemsArrayAdapter itemsAdapter;

	public static ArrayList<ToDoListItem> todoList = new ArrayList<ToDoListItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list_manager);

		this.setButtons();
		this.setList();
	}

	private void setList() {

//		this.todoList = new ArrayList<ToDoListItem>();
//		this.todoList.add(new ToDoListItem("todo 1", "18/03/2016, 23:59"));
//		this.todoList.add(new ToDoListItem("todo 2", "20/03/2016, 18:30"));
//		this.todoList.add(new ToDoListItem("todo 3", "22/04/2016 14:20"));
//		this.todoList.add(new ToDoListItem("todo 4", "24/04/2016 10:45"));
//		this.todoList.add(new ToDoListItem("todo 5", "26/04/2016 08:40"));
//		this.todoList.add(new ToDoListItem("todo 6", "28/04/2016 09:15"));

		final ListView list = (ListView) findViewById(R.id.lstTodoItems);
		final TextView emptyList = (TextView) findViewById(R.id.txtTodoItemsEmpty);

		itemsAdapter = new ListItemsArrayAdapter(this, todoList);
		list.setAdapter(itemsAdapter);

		emptyList.setVisibility(this.todoList.size() == 0 ? View.VISIBLE : View.GONE);
	}

	private void setButtons() {
		final Button addButton = (Button) findViewById(R.id.btnAddNewItem);
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final EditText newItemTitle = (EditText) findViewById(R.id.edtNewItem);
				final EditText newItemDeadLine = (EditText) findViewById(R.id.edtNewItemDeadLine);
				final TextView emptyList = (TextView) findViewById(R.id.txtTodoItemsEmpty);

				String title = newItemTitle.getText().toString();
				String deadLine = newItemDeadLine.getText().toString();

				todoList.add(new ToDoListItem(title, deadLine));

				newItemTitle.setText("");
				newItemDeadLine.setText("");

				findViewById(R.id.llNewItem).setVisibility(View.GONE);
				emptyList.setVisibility(View.GONE);

				itemsAdapter.notifyDataSetChanged();
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		findViewById(R.id.llNewItem).setVisibility(View.VISIBLE);

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {
		super.onResume();
		itemsAdapter.notifyDataSetChanged();

	}
}