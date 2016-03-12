package todolist.huji.ac.il.todolist;

import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TodoListDeleteActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_todo_list_item_delete);

		final Intent intent = getIntent();
		final Bundle extras = intent.getExtras();

		final int itemIndex = Integer.parseInt(extras.getString("index"));

		final TextView id = (TextView) findViewById(R.id.txtID);
		final TextView title = (TextView) findViewById(R.id.txtTitle);
		final TextView deadLine = (TextView) findViewById(R.id.txtDeadLine);

		id.setText(extras.getString("id"));
		title.setText(extras.getString("title"));
		deadLine.setText(extras.getString("dead_line"));

		Button delete = (Button) findViewById(R.id.menuItemDelete);
		delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getBaseContext(), TodoListManagerActivity.class);
				TodoListManagerActivity.todoList.remove(itemIndex);

				startActivity(intent);
			}
		});
	}
}