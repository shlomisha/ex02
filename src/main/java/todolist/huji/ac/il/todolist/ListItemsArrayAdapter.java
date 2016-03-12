package todolist.huji.ac.il.todolist;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class ListItemsArrayAdapter extends ArrayAdapter<ToDoListItem> {

	public ListItemsArrayAdapter(Context context, ArrayList<ToDoListItem> items) {
		super(context, 0, items);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		final ToDoListItem item = getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_todo_list_item_show, parent, false);
		}

		String color = (position % 2 == 0 ? "#7FBFEF" : "#00B0F0");
		convertView.setBackgroundColor(Color.parseColor(color));

		final TextView id = (TextView) convertView.findViewById(R.id.txtID);
		final TextView name = (TextView) convertView.findViewById(R.id.txtName);
		final TextView deadLine = (TextView) convertView.findViewById(R.id.txtDeadLine);

		id.setText(Integer.toString(item.getID()));
		name.setText(item.getName());
		deadLine.setText(item.getDeadLine());

		convertView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				Intent intentActivity = new Intent(getContext(), TodoListDeleteActivity.class);
				Bundle extras = new Bundle();

				extras.putString("index", Integer.toString(position));
				extras.putString("id", Integer.toString(item.getID()));
				extras.putString("title", item.getName());
				extras.putString("dead_line", item.getDeadLine());
				intentActivity.putExtras(extras);

				getContext().startActivity(intentActivity);
				return (true);
			}
		});

		return convertView;
	}
}