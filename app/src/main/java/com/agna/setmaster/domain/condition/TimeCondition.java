/*
 * Copyright 2016 Maxim Tuev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agna.setmaster.domain.condition;

import com.agna.setmaster.domain.DayOfWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Time Condition entity
 */
public class TimeCondition extends Condition {
    private Date from;
    private Date to;
    private ArrayList<DayOfWeek> days = new ArrayList<>(Arrays.asList(DayOfWeek.ENUMS));


    public TimeCondition() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        from = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 0);
        to = calendar.getTime();
    }

    public TimeCondition(Date from, Date to, ArrayList<DayOfWeek> days) {
        this.from = from;
        this.to = to;
        this.days = days;
    }

    private TimeCondition(String id, boolean active, Date from, Date to, ArrayList<DayOfWeek> days) {
        super(id, active);
        this.from = from;
        this.to = to;
        this.days = days;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setDays(ArrayList<DayOfWeek> days) {
        this.days = days;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public ArrayList<DayOfWeek> getDays() {
        return days;
    }

    @Override
    public Condition clone() {
        return new TimeCondition(getId(), isActive(), getFrom(), getTo(), getDays());
    }


}
