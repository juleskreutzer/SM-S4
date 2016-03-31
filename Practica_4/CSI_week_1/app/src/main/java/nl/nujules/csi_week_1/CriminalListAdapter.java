package nl.nujules.csi_week_1;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("InflateParams")  // See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CriminalListAdapter extends ArrayAdapter<Criminal> {

	private Context context;
	private List<Criminal> criminals;

	public CriminalListAdapter(Context context, List<Criminal> criminals) {
		super(context, R.layout.criminallistitem, criminals);
		
		this.context = context;
		this.criminals = criminals;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.criminallistitem, null);
		}

		TextView name = (TextView) convertView.findViewById(R.id.CriminalName);
		TextView bounty = (TextView) convertView.findViewById(R.id.CriminalBounty);
		ImageView image = (ImageView) convertView.findViewById(R.id.CriminalImage);

		Criminal c = criminals.get(position);

		name.setText(c.name);
		bounty.setText(String.format("Bounty: %s",c.getBountyInDollars()));
		image.setImageDrawable(c.mugshot);

		return convertView;
	}

}
