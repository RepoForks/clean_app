package com.two_man.setmaster.ui.screen.profile.condition.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.two_man.setmaster.R;
import com.two_man.setmaster.entity.condition.TimeCondition;
import com.two_man.setmaster.ui.screen.profile.condition.ConditionListAdapter;
import com.two_man.setmaster.ui.util.ConditionViewUtil;
import com.two_man.setmaster.ui.util.DayOfWeekUtil;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 */
public class TimeConditionHolder extends RecyclerView.ViewHolder implements ConditionHolder<TimeCondition> {

    protected final TextView value;
    protected final ImageView icon;
    private final View container;
    private final TextView status;
    private final View deleteBtn;

    public TimeConditionHolder(View itemView, ConditionListAdapter.OnConditionHolderActionListener listener) {
        super(itemView);
        container = itemView.findViewById(R.id.condition_container);
        icon = (ImageView) itemView.findViewById(R.id.condition_icon);
        value = (TextView) itemView.findViewById(R.id.condition_value);
        status = (TextView) itemView.findViewById(R.id.condition_status);
        deleteBtn = itemView.findViewById(R.id.condition_delete);
        deleteBtn.setOnClickListener(v -> listener.onDelete(getAdapterPosition()));
        container.setOnClickListener(v -> listener.onClick(v, getAdapterPosition()));
    }

    public void bind(TimeCondition condition) {
        icon.setImageResource(ConditionViewUtil.getConditionImage(condition.getClass()));
        value.setText(getValue(condition));
        status.setVisibility(condition.isActive()
                ? View.VISIBLE
                : View.GONE);
    }

    private String getValue(TimeCondition condition) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String result = formatter.format(condition.getFrom()) + " - "
                + formatter.format(condition.getTo()) + " "
                + DayOfWeekUtil.daysToString(condition.getDays(), value.getContext());
        return result;
    }

    public static TimeConditionHolder newInstance(ViewGroup parent, ConditionListAdapter.OnConditionHolderActionListener listener) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.codition_list_item_layout, parent, false);
        return new TimeConditionHolder(v, listener);
    }
}
